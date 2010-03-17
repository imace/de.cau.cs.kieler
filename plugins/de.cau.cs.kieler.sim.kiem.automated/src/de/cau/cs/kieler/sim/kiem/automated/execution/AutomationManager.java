/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.sim.kiem.automated.execution;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.core.ui.errorhandler.GenericErrorHandler.StatusListener;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.KiemPlugin;
import de.cau.cs.kieler.sim.kiem.automated.IAutomatedComponent;
import de.cau.cs.kieler.sim.kiem.automated.IAutomatedProducer;
import de.cau.cs.kieler.sim.kiem.automated.KiemAutomatedPlugin;
import de.cau.cs.kieler.sim.kiem.automated.data.AbstractResult;
import de.cau.cs.kieler.sim.kiem.automated.data.ComponentResult;
import de.cau.cs.kieler.sim.kiem.automated.data.IterationResult;
import de.cau.cs.kieler.sim.kiem.automated.data.ModelResult;
import de.cau.cs.kieler.sim.kiem.automated.data.ResultStatus;
import de.cau.cs.kieler.sim.kiem.automated.execution.CancelManager.CancelStatus;
import de.cau.cs.kieler.sim.kiem.automated.execution.CancelManager.MonitorChecker;
import de.cau.cs.kieler.sim.kiem.automated.views.AutomatedEvalView;
import de.cau.cs.kieler.sim.kiem.automated.views.ExecutionFilePanel;
import de.cau.cs.kieler.sim.kiem.config.data.ScheduleData;
import de.cau.cs.kieler.sim.kiem.config.data.Tools;
import de.cau.cs.kieler.sim.kiem.execution.Execution;
import de.cau.cs.kieler.sim.kiem.internal.AbstractDataComponent;
import de.cau.cs.kieler.sim.kiem.internal.DataComponentWrapper;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.ui.StepTextField;

/**
 * The manager for handling the actual execution. It dispatches the execution
 * job, sets up the result list and execution, initializes the DataComponents
 * and the execution, steps through until all components are finished and then
 * gathers results and terminates the execution.
 * 
 * @author soh
 * @kieler.rating 2010-02-01 proposed yellow
 */
public final class AutomationManager implements StatusListener {

    /** The singleton instance of the AutomationManager. */
    private static AutomationManager instance = null;

    /**
     * The panel where the currently running execution should display its
     * results.
     */
    private ExecutionFilePanel currentPanel;
    /** The results of the currently running execution. */
    private IterationResult currentResult;
    /** Holds the list of faulty results at the beginning of the execution file. */
    private List<AbstractResult> cachedResults;

    /**
     * The list of all components that want to be notified when something
     * happens during the automated run.
     */
    private List<ExecutionListener> listeners;

    /**
     * The currently active worker thread for checking on timeout and monitor
     * status.
     */
    private MonitorChecker monitorChecker;

    /** The mutex for waiting while a step is processed. */
    private Semaphore stepDoneMutex;

    /** True if the execution is running, false if not. */
    private boolean running = false;

    /** The field for displaying the current step. */
    private StepTextField stepTextField;

    /** The monitor that is monitoring the progress of the current execution. */
    private IProgressMonitor monitor;

    /** True if the manager is about to stop the execution. */
    private boolean stoppedByManager;

    /** An information message for the current result. */
    private String message;

    /** The worst result for the current model file. */
    private ResultStatus worstResult;

    // --------------------------------------------------------------------------

    /** Singleton pattern. */
    private AutomationManager() {
        stepTextField = new StepTextField();
    }

    // --------------------------------------------------------------------------

    /**
     * Getter for the instance.
     * 
     * @return the instance.
     */
    public static synchronized AutomationManager getInstance() {
        if (instance == null) {
            instance = new AutomationManager();
        }
        return instance;
    }

    // --------------------------------------------------------------------------

    /**
     * Getter for the step text field.
     * 
     * @return the step text field
     */
    public StepTextField getStepTextField() {
        return stepTextField;
    }

    // --------------------------------------------------------------------------

    /**
     * Ask all components for the list of file extensions that they support.
     * 
     * @return the list of extensions
     */
    private List<String> askForSupportedFiles() {
        List<String> result = new LinkedList<String>();

        for (IAutomatedComponent comp : getRelevantComponents()) {
            String[] extensions = comp.getSupportedExtensions();

            if (extensions != null && extensions.length > 0) {
                for (String extension : extensions) {
                    String s = (extension.startsWith(".") ? extension
                            .substring(1) : extension).trim();
                    if (!result.contains(s)) {
                        result.add(s);
                    }
                }
            }
        }

        return result;
    }

    /**
     * Ask all components if they want to perform more runs.
     * 
     * @return the number of additional runs
     */
    private int askForMoreRuns() {
        int result = 0;

        for (IAutomatedComponent comp : getRelevantComponents()) {
            result = Math.max(result, comp.wantsMoreRuns());
        }

        return result;
    }

    /**
     * Ask all components if they want to perform more steps.
     * 
     * @return the number of additional steps
     */
    private int askForMoreSteps() {
        int result = 0;

        for (IAutomatedComponent comp : getRelevantComponents()) {
            result = Math.max(result, comp.wantsMoreSteps());
        }

        return result;
    }

    // --------------------------------------------------------------------------

    /**
     * Determine whether or not the execution manager is currently running an
     * automated execution.
     * 
     * @return true if the manager is running.
     */
    public boolean isRunning() {
        return running;
    }

    // --------------------------------------------------------------------------
    // --------------------------------------------------------------------------

    /**
     * Automated execution of a list of predefined schedules.
     * 
     * @param executionFiles
     *            the list of execution files
     * @param modelFiles
     *            the list of model files for which to run the execution
     * @param properties
     *            the list of properties that should be set
     * @param monitorParam
     *            the progress monitor
     * @return the list of results
     */
    protected List<IterationResult> doAutomatedExecution(
            final IPath[] executionFiles, final List<IPath> modelFiles,
            final List<KiemProperty> properties,
            final IProgressMonitor monitorParam) {
        // list of results for returning to calls by other plugins
        List<IterationResult> results = new LinkedList<IterationResult>();
        // set monitor
        this.monitor = monitorParam;
        CancelManager.getInstance().setMonitor(monitorParam);

        // set up monitor
        String taskName = "Performing automated execution.";
        int executionlength = executionFiles.length * modelFiles.size();
        if (executionlength > 1) {
            monitor.beginTask(taskName, executionlength);
        } else {
            monitor.beginTask(taskName, IProgressMonitor.UNKNOWN);
        }

        // store the currently opened file.
        IPath currentFile = KiemPlugin.getDefault().getKIEMViewInstance()
                .getCurrentFile();
        Execution exec = KiemPlugin.getDefault().getExecution();
        if (exec != null) {
            exec.stopExecutionSync();
        }

        // register as error listener to avoid pop-ups during run
        KiemAutomatedPlugin.addErrorListener(this);
        try {
            running = true;

            for (final IPath execution : executionFiles) {

                executeExecutionFile(modelFiles, properties, results, execution);

                if (CancelManager.getInstance().isExecutionCanceled() != CancelStatus.NOT_CANCELED) {
                    CancelManager.getInstance().resetExecutionCancel();
                    break;
                }
            }

        } catch (RuntimeException e0) {
            // catch and throw exception, necessary to do wrap up
            throw e0;
        } finally {
            running = false;
            KiemAutomatedPlugin.removeErrorListener(this);
            monitor.done();
            if (currentFile != null) {
                try {
                    KiemPlugin.getDefault().openFile(currentFile, false);
                } catch (IOException e0) {
                    // couldn't restore file
                    Tools.showWarning("Couldn't restore file.", e0, false);
                }
            }

            refreshView();
        }
        return results;
    }

    /**
     * Execute one specific execution file.
     * 
     * @param modelFiles
     *            the list of model files
     * @param properties
     *            the list of properties
     * @param results
     *            the list of results
     * @param executionFile
     *            the path to the execution file
     */
    private void executeExecutionFile(final List<IPath> modelFiles,
            final List<KiemProperty> properties,
            final List<IterationResult> results, final IPath executionFile) {
        try {
            KiemPlugin.getDefault().openFile(executionFile, true);
        } catch (IOException e0) {
            // execution file not found, write to error log
            addExecutionFileFailedToPanel(executionFile, e0);
            return; // continue with next file
        }

        // load timeout here as execution file might carry his own timeout
        CancelManager.loadTimeout();
        // create a new table on the panel
        addExecutionFileToPanel(executionFile);

        // set up adding of results to the table
        cachedResults = new LinkedList<AbstractResult>();
        List<AbstractResult> cachedModelResults = new LinkedList<AbstractResult>();
        boolean firstModelFirstRun = true;

        List<String> supportedFiles = askForSupportedFiles();

        for (IPath model : modelFiles) {

            if (supportedFiles.contains(model.getFileExtension().trim())) {
                worstResult = ResultStatus.DONE;
                firstModelFirstRun = executeModelFile(properties, results,
                        executionFile, firstModelFirstRun, model);

                ModelResult modelResult = new ModelResult(model.toOSString());
                modelResult.setStatus(worstResult);
                getModelFileResultsFromProducers(modelResult);
                cachedModelResults.add(modelResult);
            }
            CancelManager.getInstance().resetModelFileCancel();

            // update progress
            monitor.worked(1);
            if (CancelManager.getInstance().isExecutionFileCanceled() != CancelStatus.NOT_CANCELED) {
                CancelManager.getInstance().resetExecutionFileCancel();
                break;
            }
        }

        flushCachedResults();
        addModelFileResultsToPanel(cachedModelResults, executionFile);
    }

    // --------------------------------------------------------------------------

    /**
     * Execute one model file.
     * 
     * @param properties
     *            the list of properties
     * @param results
     *            the list of results
     * @param execution
     *            the execution file
     * @param firstModelFirstRun
     *            true if it is the first valid run on the first valid model
     * @param model
     *            the model file
     * @return true if the run was not valid
     */
    private boolean executeModelFile(final List<KiemProperty> properties,
            final List<IterationResult> results, final IPath execution,
            final boolean firstModelFirstRun, final IPath model) {
        boolean result = firstModelFirstRun;
        CancelManager manager = CancelManager.getInstance();
        // the index of the current iteration
        int iteration = 0;

        String localMessage = null;
        int remainingRuns = 0;
        // call to data components, notify once before first iteration
        try {
            notifyObservers(model, iteration, properties);

            remainingRuns = askForMoreRuns();
            if (remainingRuns == 0) {
                localMessage = "No runs requested";
            }
        } catch (KiemInitializationException e0) {
            localMessage = e0.toString();
        }

        if (localMessage != null) {
            // model didn't want any runs at all, cache the result
            IterationResult noRunsResult = new IterationResult(model
                    .toOSString(), -1);
            if (remainingRuns == 0) {
                noRunsResult.setStatus(ResultStatus.DONE);
            } else {
                noRunsResult.setStatus(ResultStatus.ERROR);
            }
            noRunsResult.setMessage(localMessage);
            cachedResults.add(noRunsResult);
            return result;
        }

        boolean canceled = manager.isModelFileCanceled() != CancelStatus.NOT_CANCELED;
        while (remainingRuns-- > 0 && !canceled) {

            // update progress
            monitor.subTask(execution.toOSString() + " : " + model.toOSString()
                    + " Iteration No. " + iteration + " ( at least "
                    + remainingRuns + " remaining )");
            currentResult = new IterationResult(model.toOSString(), iteration);
            results.add(currentResult);

            if (!result) {
                // add result to panel unless first run where table columns have
                // to be initialized
                addResultToPanel();
            }

            // execute
            executeIteration();

            if (currentResult.getStatus() != ResultStatus.ERROR) {
                switch (manager.isIterationCanceled()) {
                case NOT_CANCELED:
                    currentResult.setStatus(ResultStatus.DONE);
                    break;
                case USER_CANCELED:
                    message += "(User Canceled Iteration)";
                    currentResult.setStatus(ResultStatus.ABORTED);
                    break;
                case ERROR_CANCELED:
                    message += "(Error Canceled Iteration)";
                    currentResult.setStatus(ResultStatus.ERROR);
                    break;
                }
                manager.resetIterationCancel();
                if (result) {
                    // add after run to ensure that all columns
                    // contributed by producers are filled
                    addResultToPanel();
                    result = false;
                }
            } else {
                if (result) {
                    cachedResults.add(currentResult);
                }
            }

            setWorstStatus();
            setMessageOnResult();
            message = "";

            // update the view through the display thread
            refreshView();

            canceled = manager.isModelFileCanceled() != CancelStatus.NOT_CANCELED;
            if (!canceled) {
                iteration++;
                try {
                    notifyObservers(model, iteration, properties);
                    if (remainingRuns == 0) {
                        remainingRuns = askForMoreRuns();
                    }
                } catch (KiemInitializationException e0) {
                    message += e0.toString();
                    manager.cancelModelFile(CancelStatus.ERROR_CANCELED);
                    canceled = true;
                }
            }
        }
        return result;
    }

    // --------------------------------------------------------------------------

    /**
     * Handles the execution of a single iteration.
     * 
     * @param unitsForThisIteration
     *            how many work units are available for this iteration
     */
    private void executeIteration() {
        Execution exec = null;
        stepDoneMutex = new Semaphore(0);
        // start the thread for checking for timeouts, monitor canceling,...
        monitorChecker = new MonitorChecker();
        monitorChecker.start();

        try {
            KiemPlugin kIEMInstance = KiemPlugin.getDefault();

            // call to KIEM to initialize
            if (kIEMInstance.initExecution()) {
                currentResult.setStatus(ResultStatus.RUNNING);
                refreshView();
                exec = kIEMInstance.getExecution();

                // step until no component wants another step
                int remainingSteps = askForMoreSteps();
                boolean keepStepping = CancelManager.getInstance()
                        .isIterationCanceled() == CancelStatus.NOT_CANCELED;

                while (remainingSteps-- > 0 && keepStepping) {
                    try {
                        // reset the timeout
                        monitorChecker.reset();

                        // call to KIEM for stepping
                        exec.stepExecutionSync();
                        // wait for step done event to be dispatched
                        stepDoneMutex.acquire();
                    } catch (InterruptedException e0) {
                        e0.printStackTrace();
                    }
                    keepStepping = CancelManager.getInstance()
                            .isIterationCanceled() == CancelStatus.NOT_CANCELED;
                    if (remainingSteps == 0 && keepStepping) {
                        // ask components for another step or abort
                        remainingSteps = askForMoreSteps();
                    }
                }
            }
        } catch (RuntimeException e0) {
            // something bad happened, try to continue
            message += e0.toString() + " ";
            currentResult.setStatus(ResultStatus.ERROR);
        } finally {
            // setup results
            Execution execution = KiemAutomatedPlugin.getKiemExecution();

            if (execution != null) {
                currentResult.addResult(new KiemProperty("Finished on step",
                        execution.getSteps() + ""));
                getResultsFromProducers(currentResult);

                stoppedByManager = true;
                execution.stopExecutionSync();
                stoppedByManager = false;
            } else {
                // the execution somehow was terminated
                message += "Abnormal termination of Execution ";
                currentResult.setStatus(ResultStatus.ERROR);
            }
            monitorChecker.cancel();
        }
    }

    // --------------------------------------------------------------------------
    // --------------------------------------------------------------------------

    /**
     * Add the execution file to the panel through the use of the display
     * thread.
     * 
     * @param executionFile
     *            the execution file to add
     */
    private void addExecutionFileToPanel(final IPath executionFile) {
        KiemAutomatedPlugin.getDisplay().syncExec(new Runnable() {
            /**
             * {@inheritDoc}
             */
            public void run() {
                AutomatedEvalView automatedView = KiemAutomatedPlugin
                        .getAutomatedEvalView();
                currentPanel = automatedView.addExecutionFile(executionFile);
            }
        });
    }

    /**
     * Add a message to the view that loading the execution file failed.
     * 
     * @param executionFile
     *            the execution file
     * @param e0
     *            the exception that caused the error
     */
    private void addExecutionFileFailedToPanel(final IPath executionFile,
            final IOException e0) {
        KiemAutomatedPlugin.getDisplay().syncExec(new Runnable() {
            /**
             * {@inheritDoc}
             */
            public void run() {
                AutomatedEvalView automatedView = KiemAutomatedPlugin
                        .getAutomatedEvalView();
                automatedView.addExecutionFileFailed(executionFile, e0);
            }
        });
    }

    /**
     * Adds the results of all model files under the given execution file.
     * 
     * @param modelResults
     *            the list of model file results.
     * @param executionFile
     *            the execution file
     */
    private void addModelFileResultsToPanel(
            final List<AbstractResult> modelResults, final IPath executionFile) {
        KiemAutomatedPlugin.getDisplay().syncExec(new Runnable() {
            /**
             * {@inheritDoc}
             */
            public void run() {
                AutomatedEvalView automatedView = KiemAutomatedPlugin
                        .getAutomatedEvalView();
                ExecutionFilePanel panel = automatedView
                        .addExecutionFile(executionFile);
                panel.addResult(modelResults);
            }
        });
    }

    /**
     * Add the result current Result to the panel by use of the display thread.
     */
    private void addResultToPanel() {
        flushCachedResults();
        KiemAutomatedPlugin.getDisplay().syncExec(new Runnable() {
            /**
             * {@inheritDoc}
             */
            public void run() {
                currentPanel.addResult(currentResult);
            }
        });
    }

    /**
     * Add any results that were not yet added to the results panel.
     */
    private void flushCachedResults() {
        KiemAutomatedPlugin.getDisplay().syncExec(new Runnable() {
            /**
             * {@inheritDoc}
             */
            public void run() {
                if (cachedResults != null && !cachedResults.isEmpty()) {
                    if (!cachedResults.contains(currentResult)) {
                        cachedResults.add(currentResult);
                    }
                    currentPanel.addResult(cachedResults);
                    cachedResults = new LinkedList<AbstractResult>();
                }
            }
        });
    }

    // --------------------------------------------------------------------------

    /**
     * Automated execution of a list of predefined schedules.
     * 
     * @param schedules
     *            the list of schedules.
     * @param modelFiles
     *            the list of model files for which to run the execution
     * @param properties
     *            the list of properties that should be set
     * @param monitorParam
     *            the progress monitor
     * @return the list of results
     */
    protected List<IterationResult> doAutomatedExecution(
            final List<ScheduleData> schedules, final List<IPath> modelFiles,
            final List<KiemProperty> properties,
            final IProgressMonitor monitorParam) {

        // convert schedules to paths
        IPath[] paths = new IPath[schedules.size()];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = schedules.get(i).getLocation();
        }

        return doAutomatedExecution(paths, modelFiles, properties, monitorParam);
    }

    // --------------------------------------------------------------------------

    /**
     * <p>
     * Trigger an execution with a list of execution files, a list of model
     * files and a list of properties. Each combination of execution and model
     * file will be stepped through until no component requests another step.
     * After that the execution will be stopped and move on to the next
     * combination unless one of the component requests that this combination is
     * run again.
     * </p>
     * <p>
     * This method is part of the KIEMAutos API and can be accessed from any
     * plugin.
     * </p>
     * <p>
     * The method will return asynchronously. Callers that want to be notified
     * of the results must register themselves as a listener on the instance of
     * the execution manager.
     * </p>
     * 
     * @param executionFiles
     *            the selected locations
     * @param modelFiles
     *            the model files
     * @param properties
     *            the properties
     */
    public void executeAsync(final IPath[] executionFiles,
            final List<IPath> modelFiles, final List<KiemProperty> properties) {

        AutomationJob job = new AutomationJob(executionFiles, modelFiles,
                properties);
        job.schedule();
    }

    /**
     * <p>
     * Trigger an execution with a list of schedules, a list of model files and
     * a list of properties. Each combination of execution and model file will
     * be stepped through until no component requests another step. After that
     * the execution will be stopped and move on to the next combination unless
     * one of the component requests that this combination is run again.
     * </p>
     * <p>
     * This method is part of the KIEMAutos API and can be accessed from any
     * plugin.
     * </p>
     * <p>
     * The method will return asynchronously. Callers that want to be notified
     * of the results must register themselves as a listener on the instance of
     * the execution manager.
     * </p>
     * 
     * @param selected
     *            the selected schedules
     * @param modelFiles
     *            the model files
     * @param properties
     *            the properties
     */
    public void executeAsync(final List<ScheduleData> selected,
            final List<IPath> modelFiles, final List<KiemProperty> properties) {

        // convert schedules to paths
        IPath[] array = new IPath[selected.size()];
        for (int i = 0; i < selected.size(); i++) {
            array[i] = selected.get(i).getLocation();
        }

        executeAsync(array, modelFiles, properties);
    }

    // --------------------------------------------------------------------------

    /**
     * Getter for the list of IAutomatedComponents that are currently registered
     * in the KIEM, enabled and want to interact with the automated execution.
     * 
     * @return the list of components
     */
    private List<IAutomatedComponent> getRelevantComponents() {
        List<IAutomatedComponent> result = new LinkedList<IAutomatedComponent>();

        for (DataComponentWrapper wrapper : KiemPlugin.getDefault()
                .getDataComponentWrapperList()) {
            if (wrapper.isEnabled()) {
                // only enabled components since others won't execute
                AbstractDataComponent comp = wrapper.getDataComponent();

                if (comp instanceof IAutomatedComponent) {
                    // only components that can actually interact with KIEMAuto
                    IAutomatedComponent autoComp = (IAutomatedComponent) comp;
                    result.add(autoComp);
                }
            }
        }

        return result;
    }

    /**
     * Provide the observers with all they information they need.
     * 
     * @param modelFile
     *            the model file
     * @param iteration
     *            the index of the current iteration
     * @param properties
     *            the list of custom properties
     * @throws KiemInitializationException
     *             if one the components could not be initialized
     */
    private void notifyObservers(final IPath modelFile, final int iteration,
            final List<KiemProperty> properties)
            throws KiemInitializationException {

        List<KiemProperty> list = new LinkedList<KiemProperty>();

        // add information to the property list
        list.add(new KiemProperty(IAutomatedComponent.MODEL_FILE, modelFile
                .toOSString()));
        list
                .add(new KiemProperty(IAutomatedComponent.ITERATION, iteration
                        + ""));

        for (KiemProperty prop : properties) {
            list.add(prop);
        }

        // notify observers
        for (IAutomatedComponent comp : getRelevantComponents()) {
            comp.setParameters(list);
        }
    }

    /**
     * Get the iteration results from the list of IAutomatedProducers.
     * 
     * @param iterationResult
     *            the results of the iteration.
     */
    private void getResultsFromProducers(final AbstractResult iterationResult) {

        for (IAutomatedComponent comp : getRelevantComponents()) {

            if (comp instanceof IAutomatedProducer) {
                // filter out all producers
                IAutomatedProducer producer = (IAutomatedProducer) comp;
                // producers should be data components, get the name
                String name = ((AbstractDataComponent) comp).getName();

                ComponentResult result = new ComponentResult(name);
                iterationResult.addChild(result);

                result.setResults(producer.produceInformation());
            }
        }
    }

    /**
     * Get the model file results from the list of IAutomatedProducers.
     * 
     * @param modelFileResult
     *            the results of the model file.
     */
    private void getModelFileResultsFromProducers(
            final AbstractResult modelFileResult) {

        for (IAutomatedComponent comp : getRelevantComponents()) {

            if (comp instanceof IAutomatedProducer) {
                // filter out all producers
                IAutomatedProducer producer = (IAutomatedProducer) comp;
                // producers should be data components, get the name
                String name = ((AbstractDataComponent) comp).getName();

                ComponentResult result = new ComponentResult(name);
                modelFileResult.addChild(result);

                result.setResults(producer.produceModelFileInformation());
            }
        }
    }

    // --------------------------------------------------------------------------
    // --------------------------------------------------------------------------

    /**
     * Tell the automation manager that the execution was paused due to an
     * error.
     */
    public void notifyOnErrorPause() {
        // abort iteration
        CancelManager.getInstance()
                .cancelIteration(CancelStatus.ERROR_CANCELED);
    }

    /**
     * Tell the automation manager that the execution was stopped due to an
     * error.
     */
    public void notifyOnErrorStop() {
        // abort iteration
        CancelManager.getInstance()
                .cancelIteration(CancelStatus.ERROR_CANCELED);
    }

    /**
     * Tell the automation manager that a step was processed and that the
     * execution can resume.
     */
    public void notifyOnStepFinished() {
        KiemAutomatedPlugin.getDisplay().asyncExec(new Runnable() {

            public void run() {
                Execution exec = KiemAutomatedPlugin.getKiemExecution();
                if (exec != null) {
                    stepTextField.updateTextfield(exec.getSteps() + "");
                } else {
                    stepTextField.updateTextfield(null);
                }
            }
        });

        // release the thread waiting in executeIteration()
        stepDoneMutex.release();
    }

    /**
     * Tell the automation manager that the user paused the execution.
     */
    public void notifyOnUserPause() {
        KiemPlugin.getDefault().getExecution().stepExecutionSync();
    }

    /**
     * Tell the automation manager that the user stopped the execution.
     */
    public void notifyOnUserStop() {
        if (!stoppedByManager) {
            CancelManager.getInstance().cancelIteration(
                    CancelStatus.USER_CANCELED);
        }
    }

    // --------------------------------------------------------------------------
    // --------------------------------------------------------------------------

    /**
     * Refresh the view.
     */
    private void refreshView() {
        KiemAutomatedPlugin.getDisplay().syncExec(new Runnable() {
            /**
             * {@inheritDoc}
             */
            public void run() {
                currentPanel.refresh();
            }
        });
    }

    // --------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public int reroute(final StatusAdapter statusAdapter, final int style) {
        // String pluginId = statusAdapter.getStatus().getPlugin();
        if ((style & StatusManager.BLOCK) != 0
                || (style & StatusManager.SHOW) != 0) {
            IStatus status = statusAdapter.getStatus();
            if (status != null) {
                message += status.getMessage() + " ";
            }

            CancelManager.getInstance().cancelIteration(
                    CancelStatus.ERROR_CANCELED);
            return StatusManager.LOG;
        }
        return StatusListener.DONT_CARE;
    }

    // --------------------------------------------------------------------------

    /**
     * Set the message on the current result.
     * */
    private void setMessageOnResult() {
        if (currentResult != null) {
            currentResult.setMessage(message);
        }
    }

    /**
     * Set the worst status for the current model file.
     */
    private void setWorstStatus() {
        ResultStatus status = currentResult.getStatus();
        if (status != worstResult) {
            switch (worstResult) {
            case RUNNING:
            case DONE:
            case CREATED:
                if (status == ResultStatus.ERROR
                        || status == ResultStatus.ABORTED) {
                    worstResult = status;
                }
                break;

            case ABORTED:
                if (status == ResultStatus.ERROR) {
                    worstResult = ResultStatus.ERROR;
                }
                break;

            case ERROR:
            default:
                break;
            }
        }
    }

    // --------------------------------------------------------------------------

    /**
     * Add a new listener.
     * 
     * @param listener
     *            the listener to add
     */
    public void addListener(final ExecutionListener listener) {
        if (listeners == null) {
            listeners = new LinkedList<ExecutionListener>();
        }
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    /**
     * Notify all observers that the execution has finished.
     * 
     * @param results
     *            the results of the execution
     */
    public void notifyExecutionFinished(final List<IterationResult> results) {
        if (listeners != null) {
            for (ExecutionListener listener : listeners) {
                listener.executionDone(results);
            }
        }
    }

    /**
     * Remove a listener.
     * 
     * @param listener
     *            the listener to remove
     */
    public void removeListener(final ExecutionListener listener) {
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    // --------------------------------------------------------------------------
    // --------------------------------------------------------------------------

    /**
     * Interface for all components that are interested in the state of the
     * current execution.
     * 
     * @author soh
     * @kieler.rating 2010-02-08 proposed yellow
     */
    public static interface ExecutionListener {

        /**
         * This method is called as soon as the automated run finishes.
         * 
         * @param results
         *            the results of the run
         */
        void executionDone(List<IterationResult> results);

    }
}
