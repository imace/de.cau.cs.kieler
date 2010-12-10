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
 *
 *****************************************************************************/
package de.cau.cs.kieler.synccharts.sim.sc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.core.kexpressions.Signal;
import de.cau.cs.kieler.core.kexpressions.ValueType;
import de.cau.cs.kieler.core.model.validation.ValidationManager;
import de.cau.cs.kieler.sim.kiem.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.automated.AbstractAutomatedProducer;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeChoice;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;
import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.codegen.sc.WorkflowGenerator;

/**
 * This is the data component to handle the communication between KIEM and the external SC-Program.
 * 
 * @kieler.rating 2010-06-14 proposed yellow
 * 
 * @author tam
 * 
 */
public class SCDataComponent extends AbstractAutomatedProducer {

    private WorkflowGenerator wf = null;
    private Process process = null;
    private PrintWriter toSC;
    private BufferedReader fromSC;
    private BufferedReader error;
    private String outPath;
    // validation is true if the simulation is used for validation otherwise
    // false
    private boolean validation;
    // newValidation is false if it is not necessary to generate new sc-files
    // - because the model has not changed for the validation - otherwise true
    private boolean newValidation;
    private String fileLocation;

    /**
     * 
     * This method fetches the location of the used sc- and header files. With the resulting files
     * and the folder for the output files it starts the compilation of the program. After compiling
     * a process with the execution of the resulting program is started.
     * 
     * {@inheritDoc}
     */
    public void initialize() throws KiemInitializationException {
        // Enable SC checks in possibly open GMF SyncCharts editor
        ValidationManager.enableCheck("de.cau.cs.kieler.synccharts.ScChecks");
        ValidationManager.validateActiveEditor();

        // building path to bundle
        Bundle bundle = Platform.getBundle("de.cau.cs.kieler.synccharts.codegen.sc");

        URL url = null;
        try {
            url = FileLocator.toFileURL(FileLocator.find(bundle, new Path("simulation"), null));
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        String bundleLocation = url.getFile();
        // because of windows vs. linux
        bundleLocation = bundleLocation.replaceAll("[/\\\\]+", "\\" + File.separator);
        if (bundleLocation.startsWith("\\")) {
            bundleLocation = bundleLocation.substring(1);
        }

        boolean compiled = false;

        try {

            if (!validation || (validation && newValidation)) {
                // compile
                String compiler = (getProperties()[1]).getValue();
                String compile = compiler + " " + outPath + "sim.c " + outPath + "sim_data.c "
                        + outPath + "misc.c " + bundleLocation + "cJSON.c " + "-I "
                        + bundleLocation + " " + "-o " + outPath
                        + "simulation -lm -D_SC_NOTRACE -D_SC_SUPPRESS_ERROR_DETECT -D_SC_USE_PRE";
                process = Runtime.getRuntime().exec(compile);
                System.out.println(compile);

                compiled = true;

                InputStream stderr = process.getErrorStream();
                InputStreamReader isr = new InputStreamReader(stderr);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                String errorString = "";
                while ((line = br.readLine()) != null) {
                    errorString += "\n" + line;

                }
                // TODO: -D_SC_SUPPRESS_ERROR_DETECT: error messages detecting
                // (use own buffer)
                int exitValue = process.waitFor();

                if (exitValue != 0) {
                    throw new KiemInitializationException("could not compile", true, new Exception(
                            errorString));
                }
            }

            // start compiled sc code
            String executable = outPath + "simulation ";

            process = Runtime.getRuntime().exec(executable);

            toSC = new PrintWriter(new OutputStreamWriter(process.getOutputStream()));
            fromSC = new BufferedReader(new InputStreamReader(process.getInputStream()));
            error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            if (process != null) {
                process.destroy();
            }
            String compileError = "";
            if (!compiled) {
                compileError = "No compiler found! Please select one in the "
                        + "\"SC simulation\" component in the Execution Manager";
                throw new KiemInitializationException(compileError, true, null);
            } else {
                throw new KiemInitializationException("could not simulate", true, e);
            }

        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            if (process != null) {
                process.destroy();
            }
            throw new KiemInitializationException("could not simulate", true, e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * The step method handles the communication between the generated sc program and KIEM. For
     * communication JSON Strings are exchanged via std. I/O.
     * 
     */
    public JSONObject doStep(final JSONObject jSONObject) throws KiemExecutionException {
        JSONObject out = null;
        try {
            jSONObject.remove("state");
            // boolToInt converts true and t to 1, false and f to 0
            String jSONString = boolToInt(jSONObject).toString();
            toSC.write(jSONString + "\n");
            toSC.flush();
            while (error.ready()) {
                System.out.print(error.read());
            }

            String receivedMessage = fromSC.readLine();
            // print and delete debug information
            receivedMessage = printDebugInfos(receivedMessage);
            while (error.ready()) {
                System.err.print(error.readLine());
            }

            out = new JSONObject(receivedMessage);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            process.destroy();
        } catch (JSONException e) {
            e.printStackTrace();
            process.destroy();
        }

        try {
            if (out.has("state")) {
                JSONArray stateArray = out.getJSONArray("state");
                String allStates = "";

                for (int i = 0; i < stateArray.length(); i++) {
                    allStates += stateArray.opt(i) + ",";
                }
                allStates = allStates.substring(0, allStates.length() - 1);
                out.remove("state");
                out.put("state", allStates);
            } else {
                out.put("state", "");
            }
        } catch (JSONException e) {
            System.err.println(e.getMessage());
            process.destroy();
        }

        // System.out.println("incoming " + out.toString());
        // System.out.println("outgoing " + jSONObject.toString());
        return out;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isObserver() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isProducer() {
        return true;
    }

    public KiemProperty[] doProvideProperties() {
        final int numberOfProperties = 3;
        KiemProperty[] properties = new KiemProperty[numberOfProperties];
        KiemPropertyTypeFile compilerFile = new KiemPropertyTypeFile(true);
        properties[0] = new KiemProperty("Compiler", compilerFile, "gcc");
        properties[1] = new KiemProperty("File Location", "");
        // String[] items = { "complete hierarchie", "shortest hierarchie",
        // "unique incremental name" };
        // TODO: only complete hierarchie is supported yet
        String[] items = { "Complete Hierarchie" };
        KiemPropertyTypeChoice choice = new KiemPropertyTypeChoice(items);
        properties[2] = new KiemProperty("Label Names for SC Code", choice, items[0]);

        return properties;
    }

    /**
     * 
     * On stopping the simulation the sc process will be destroyed (if it was not closed normally).
     * If the simulation files are generated into a temp folder it will be deleted.
     * 
     * {@inheritDoc}
     */
    public void wrapup() throws KiemInitializationException {
        process.destroy();
        // delete temp folder if no validation
        if (!validation) {
            File folder = new File(outPath);
            if (folder.getAbsolutePath().contains(System.getProperty("java.io.tmpdir"))) {
                boolean folderDeleted = deleteFolder(folder);
                if (folderDeleted) {
                    System.out.println("temp folder " + folder + " successfully deleted");
                } else {
                    System.err.println("error while deleting temp folder: " + folder);
                }
            }
        }
    }

    // -------------------------------------------------------------------------

//    private DiagramEditor diagramEditor = null;
//    private boolean diagramEditorFlag = false;
//
//    DiagramEditor getInputEditor() {
//        String kiemEditorProperty = this.getProperties()[0].getValue();
//        diagramEditorFlag = false;
//
//        Display.getDefault().syncExec(new Runnable() {
//            public void run() {
//                // get the active editor as a default case (if property is empty)
//                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
//                IWorkbenchPage activePage = window.getActivePage();
//                IEditorPart editor = activePage.getActiveEditor();
//                if (editor instanceof DiagramEditor) {
//                    diagramEditor = (DiagramEditor) editor;
//                }
//                diagramEditorFlag = true;
//            }
//        });
//
//        while (!diagramEditorFlag) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return diagramEditor;
//    }

    // -------------------------------------------------------------------------

//    public String getInputModel() {
//        DiagramEditor inputEditor = this.getInputEditor();
//        // now extract the file
//        View notationElement = ((View) inputEditor.getDiagramEditPart().getModel());
//        EObject myModel = (EObject) notationElement.getElement();
//        URI uri = myModel.eResource().getURI();
//
//        return uri.toPlatformString(false);
//    } 
    
    // -------------------------------------------------------------------------

    /**
     * @return {@link JSONObject} the initial JSON object before the simulation could be started.
     * 
     *         A path for the output files will be determined. A differentiation between simulation
     *         or validation will be made. After these initializations the codegen process will be
     *         started.
     * 
     */
    public JSONObject doProvideInitialVariables() {

        JSONObject returnObj = new JSONObject();

        if ((getProperties()[2]).getValue().equals("")) {
            String tempDir = System.getProperty("java.io.tmpdir");
            // for Windows (tmpdir ends with backslash)
            if (tempDir.endsWith("\\")) {
                tempDir = tempDir.substring(0, tempDir.length() - 1);
            }
            outPath = tempDir + File.separator + randomString() + File.separator;
        } else {
            outPath = (getProperties()[3]).getValue();
            if (!outPath.endsWith(File.separator)) {
                outPath += File.separator;
            }
        }

        if (validation) {
            outPath = System.getProperty("java.io.tmpdir") + File.separator + "SC_Validation"
                    + File.separator;
        }

        // will be skipped if a validation is triggered once again for the same
        // model.
        if (!validation || (validation && newValidation)) {
            if (validation) {
                wf = new WorkflowGenerator(fileLocation);
            } else {
                String fileLocation2 = getInputModel();
                wf = new WorkflowGenerator(fileLocation2);
            }
            // generate Code from SyncChart
            // true sets the flag for simulation
            wf.invokeWorkflow(true, outPath);
        }
        // if the if-statement above is skipped the wf object exists because it
        // has been created
        // at least for the first validation of a model.
        EObject myModel = wf.getModel();
        List<Signal> signalList = ((Region) myModel).getStates().get(0).getSignals();
        for (int i = 0; i < signalList.size(); i++) {
            try {
                returnObj.accumulate(signalList.get(i).getName(), JSONSignalValues.newValue(false));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return returnObj;
    }

    /*
     * Creates a random string of 16 letters/numbers.
     */
    private static String randomString() {
        final int folderLength = 16;
        String allowedChars = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        int max = allowedChars.length();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < folderLength; i++) {
            int value = random.nextInt(max);
            buffer.append(allowedChars.charAt(value));
        }
        return buffer.toString();
    }

    /*
     * Returns a list of signals of the model. Not used at the moment but might be useful later.
     */
    @SuppressWarnings("unused")
    private String[] getSignals() {
        Region myModel = (Region) (wf.getModel());
        List<String> tmp = new LinkedList<String>();
        String[] out = new String[0];
        List<Signal> signalList = myModel.getStates().get(0).getSignals();

        for (int i = 0; i < signalList.size(); i++) {
            tmp.add(signalList.get(i).getName());
        }
        out = tmp.toArray(new String[tmp.size()]);
        return out;
    }

    /*
     * Converts the inputs for true and false given by the user in the data table to valid true and
     * false for SC
     * 
     * example: t, true, 1 = true
     */
    private JSONObject boolToInt(final JSONObject signals) {
        JSONObject out = signals;
        Region myModel = (Region) (wf.getModel());
        List<Signal> signalList = myModel.getStates().get(0).getSignals();
        for (Signal signal : signalList) {
            if (signal.getType().equals(ValueType.BOOL)) {
                String sig = signal.getName();
                try {
                    JSONObject jSONSig = signals.getJSONObject(sig);
                    if (!jSONSig.isNull("value")) {
                        Object obj = jSONSig.get("value");
                        int bool = 0;
                        if (obj.equals(true) || obj.equals("t")) {
                            bool = 1;
                        }
                        jSONSig.remove("value");
                        jSONSig.put("value", bool);
                        out.remove(sig);
                        out.put(sig, jSONSig);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return out;
    }

    /*
     * Deletes a given folder.
     */
    private boolean deleteFolder(final File dir) {
        if (dir.isDirectory()) {
            String[] entries = dir.list();
            for (int x = 0; x < entries.length; x++) {
                File aktFile = new File(dir.getPath(), entries[x]);
                deleteFolder(aktFile);
            }
        }
        return dir.delete();
    }

    private String printDebugInfos(final String s) {
        String out = "";
        String[] debugInfos = s.split("DEBUGEND");
        for (String string : debugInfos[0].split("INFO")) {
            if (!string.equals("")) {
                System.out.println("SC Debug Info: " + string);
            }
        }
        String[] noDebugInfos = s.split("DEBUGEND");
        out = noDebugInfos[noDebugInfos.length - 1];
        return out;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<KiemProperty> produceInformation() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getSupportedExtensions() {
        String[] out = { "kixs" };
        return out;
    }

    /**
     * {@inheritDoc}
     * 
     * Is called _before_ provideInitialVariables. Sets the flags for validation.
     * 
     */
    @Override
    public void setParameters(final List<KiemProperty> properties)
            throws KiemInitializationException {
        validation = true;
        newValidation = true;
        for (KiemProperty p : properties) {
            if (p.getKey().equals(MODEL_FILE)) {
                fileLocation = p.getValue();
            }
            if (p.getKey().equals(ITERATION)) {
                if (Integer.parseInt(p.getValue()) > 0) {
                    newValidation = false;
                }
            }
        }
    }
}
