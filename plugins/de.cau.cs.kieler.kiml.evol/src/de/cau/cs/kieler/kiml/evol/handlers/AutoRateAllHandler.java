/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.evol.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.core.ui.util.MonitoredOperation;
import de.cau.cs.kieler.kiml.evol.EvolPlugin;
import de.cau.cs.kieler.kiml.evol.genetic.Population;
import de.cau.cs.kieler.kiml.evol.ui.EvolView;

/**
 * Handler for auto-rating all individuals.
 *
 * @author bdu
 *
 */
public class AutoRateAllHandler extends AbstractHandler {

    /**
     * A job that does the auto-rating.
     *
     * @author bdu
     *
     */
    private static final class AutoRateAllJob extends Job {
        /**
         * @return the evolution view
         */
        private EvolView getView() {
            return this.view;
        }

        /**
         * @author bdu
         *
         */
        private static final class RefreshEvolViewRunnable implements Runnable {
            /**
             *
             */
            private final EvolView evolView;

            /**
             * Creates a new {@link RefreshEvolViewRunnable} instance.
             *
             * @param theEvolView
             */
            RefreshEvolViewRunnable(final EvolView theEvolView) {
                this.evolView = theEvolView;
            }

            public void run() {
                this.evolView.getTableViewer().refresh();
                this.evolView.refresh(false);
            }
        }

        /**
         * @author bdu
         *
         */
        private static final class AutoRateAllRunnable implements Runnable {
            /**
             *
             */
            private final IProgressMonitor monitor;
            private final EvolView view;

            /**
             * Creates a new {@link AutoRateAllRunnable} instance.
             *
             * @param theMonitor
             * @param theEditor
             * @param thePopulation
             */
            AutoRateAllRunnable(final EvolView theView, final IProgressMonitor theMonitor) {
                this.monitor = theMonitor;
                this.view = theView;
            }

            public void run() {
                // Rate all individuals in the current editor.
                this.view.getEvolModel().autoRate(this.monitor);

                // EvolUtil.autoRateIndividuals(this.population, this.editor,
                // this.monitor);
            }
        }

        /**
         * The population to be rated.
         */
        private final Population population;


        private final EvolView view;

        /**
         * Creates a new {@link AutoRateAllJob} instance.
         *
         * @param name
         * @param pop
         * @param theEditor
         * @param theView
         * @param theView
         */
        AutoRateAllJob(
                final String name,
 final Population pop,
                final EvolView theView) {
            super(name);
            Assert.isLegal(pop != null);
            this.population = pop;
            this.view = theView;
        }

        @Override
        protected IStatus run(final IProgressMonitor monitor) {
            try {
                monitor.subTask("Determining Individual Rating");
                final int delay = 200;
                Thread.sleep(delay);

                // Do the rating.
                MonitoredOperation.runInUI(new AutoRateAllRunnable(this.view, monitor), false);

                if (monitor.isCanceled()) {
                    return new Status(IStatus.CANCEL, EvolPlugin.PLUGIN_ID,
                            "The auto-rating was cancelled.");
                }

                monitor.subTask("Determining the average rating");
                System.out.println("Average rating: " + this.population.getAverageRating());
                monitor.worked(1);

                // monitor.subTask("Refreshing the evolution view");
                // final EvolView evolView = getView();
                // MonitoredOperation.runInUI(new
                // RefreshEvolViewRunnable(evolView), false);
                // monitor.worked(1);

                return new Status(IStatus.INFO, EvolPlugin.PLUGIN_ID, 0, "OK", null);

            } catch (final Exception exception) {
                return new Status(IStatus.ERROR, EvolPlugin.PLUGIN_ID,
                        "The auto-rating has failed.", exception);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public Object execute(final ExecutionEvent event) throws ExecutionException {

        final EvolView view =
                (EvolView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .findView(EvolView.ID);

        if (view == null) {
            throw new ExecutionException("The Evolution View could not be found.");
        }

        final Population pop = view.getPopulation();
        Assert.isNotNull(pop);

        // final IEditorPart editor = EvolUtil.getCurrentEditor();
        // Assert.isNotNull(editor);

        // Create jobs for auto-rating and refreshing.
        final Job autoRateAllJob = new AutoRateAllJob("auto-rating", pop, view);
        // final Job refreshViewJob = new
        // RefreshEvolutionViewJob("refreshing the view", view);

        // Process the jobs.
        final IProgressMonitor monitor = Job.getJobManager().createProgressGroup();

        try {
            final int size = pop.size();

            monitor.beginTask("Performing Auto-rating", size + 1 + 1);

            autoRateAllJob.setProgressGroup(monitor, size + 1);
            autoRateAllJob.setUser(true);
            autoRateAllJob.setPriority(Job.DECORATE);
            autoRateAllJob.schedule();

            // refreshViewJob.setProgressGroup(monitor, 1);
            // refreshViewJob.setUser(true);
            // refreshViewJob.setPriority(Job.SHORT);
            final int delay = 200;
            // refreshViewJob.schedule(delay);

            // XXX: Auto-rating and refreshing are divided into two separate
            // jobs. We want the autorating to be finished before the view is
            // being refreshed. This is done by joining on the auto-rating job,
            // but this way for some unknown reason the diligently notified
            // progress bar is not shown. Where is the progress bar? :(

            // autoRateAllJob.join();
            Thread.sleep(delay);
            // refreshViewJob.join();
            Thread.sleep(delay);

        } catch (final InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            monitor.done();
        }

        return null;
    }

}
