/**
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
package de.cau.cs.kieler.ksbase.core;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.cau.cs.kieler.ksbase.KSBasEPlugin;

/**
 * A utility class which contains a MWE Xtend component.
 * 
 * @author Michael Matzen - mim AT informatik.uni-kiel.de
 * 
 */
public class KSBasEXtendComponent {

    /** The MWE Xtend component. **/
    private XtendComponent xtendComponent;
    /** The component status. **/
    private boolean initalized;
    /** The workflow context. **/
    private WorkflowContext context;
    /**
     * The issues container which is used during the execution of a
     * transformation.
     **/
    private Issues issues;
    /**
     * The monitor which is used by Xtend. This is a null monitor because we
     * don't want any process feedback.
     **/
    private NullProgressMonitor xtendMonitor;

    /**
     * Creates a new Xtend component.
     * 
     */
    public KSBasEXtendComponent() {
        initalized = false;
        context = new WorkflowContextDefaultImpl();
        issues = new IssuesImpl();
        xtendMonitor = new NullProgressMonitor();
    }

    /**
     * Creates an Xtend component to execute.
     * 
     * @param operation
     *            Xtend function name
     * @param fileName
     *            The name of the Xtend file
     * @param basePackage
     *            The meta model package class to use
     * @param modelSelection
     *            selected model elements
     */
    public void createComponent(
            final String operation, final String fileName, final String basePackage,
            final String modelSelection) {

        xtendComponent = new XtendComponent();

        // with an EMFMetaMetaModel,
        EmfMetaModel emfmodel;

        // Load the EPackage class by using EcoreUtils
        EPackage pack = EcoreUtil2.getEPackageByClassName(basePackage);
        // create EMFMetaModel with the given EPackage
        emfmodel = new EmfMetaModel(pack);

        // Set metaModel-Slot
        xtendComponent.addMetaModel(emfmodel);
        // Create transformation value
        String value = fileName + "::" + operation + "(" + modelSelection + ")";

        xtendComponent.setInvoke(value);

        initalized = true;
    }

    /**
     * Invokes the component.
     */
    public void invoke() {
        if (!initalized || xtendComponent == null) {
            KSBasEPlugin.getDefault().getLog().log(
                    new Status(
                            IStatus.ERROR, KSBasEPlugin.PLUGIN_ID,
                            "Workflow has not been initialized!"));
            return;
        }
        xtendComponent.invoke(context, xtendMonitor, issues);
        // Logging errors and warnings:
        if (issues.hasWarnings()) {
            ILog log = KSBasEPlugin.getDefault().getLog();
            for (MWEDiagnostic warning : issues.getWarnings()) {
                log.log(new Status(
                        IStatus.WARNING, KSBasEPlugin.PLUGIN_ID,
                        "Warning while executing transformation: " + warning.getMessage()));
            }

        }
        if (issues.hasErrors()) {
            ILog log = KSBasEPlugin.getDefault().getLog();
            for (MWEDiagnostic warning : issues.getErrors()) {
                log.log(new Status(
                        IStatus.ERROR, KSBasEPlugin.PLUGIN_ID,
                        "Error while executing transformation: " + warning.getMessage()));
            }

        }

        // finally clear all settings after a transformation has been executed:
        initalized = false;
        context = new WorkflowContextDefaultImpl();
        issues = new IssuesImpl();
        xtendMonitor = new NullProgressMonitor();
    }

    /**
     * Sets data of a context slot.
     * 
     * @param slot
     *            The name of the slot
     * @param data
     *            The slot data
     */
    public void setContextData(final String slot, final Object data) {
        context.set(slot, data);
    }

    /**
     * Returns the component status.
     * 
     * @return True if the component has been initialized
     */
    public boolean isInitalized() {
        return this.initalized;
    }

    /**
     * Sets the initialized state to the given value. This has to be public
     * available to allow the command to set the status when all parameters have
     * been set.
     * 
     * @param status
     *            The new status
     */
    public void setInitialized(final boolean status) {
        this.initalized = status;
    }
}
