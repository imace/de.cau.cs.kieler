/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
package de.cau.cs.kieler.ksbase.ui.handler;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.ksbase.core.KielerWorkflow;
import de.cau.cs.kieler.ksbase.core.Messages;

/**
 * The command to execute an Xtend transformation. Handles MWE initialization
 * too
 * 
 * @author Michael Matzen
 * 
 */
public class ExecuteTransformationCommand extends AbstractTransactionalCommand {

    private KielerWorkflow workflow;
    private WorkflowContext context;
    private Issues issues;
    private NullProgressMonitor monitor;
    private List<IFile> affectedFiles;

    /**
     * Creates a command to execute a transformation.
     * 
     * @param domain
     *            the editing domain through which model changes are made
     * @param label
     *            the command label
     * @param adapter
     *            an adapter to the {@code View} of the base diagram
     */
    public ExecuteTransformationCommand(TransactionalEditingDomain domain,
            String label, IAdaptable adapter) {
        super(domain, label, null);
        context = new WorkflowContextDefaultImpl();
        issues = new IssuesImpl();
        monitor = new NullProgressMonitor();
    }

    /*
     * (non-Javadoc)
     * 
     * @seeorg.eclipse.gmf.runtime.emf.commands.core.command.
     * AbstractTransactionalCommand
     * #doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
     * org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
            IAdaptable info) throws ExecutionException {
        // TOOD: Suppress messages from xtend/mwe
        if (workflow == null) {
            return CommandResult
                    .newErrorCommandResult(Messages.ExecuteTransformationCommand_Workflow_Initialization_Error);
        }
        try {
            workflow.invoke(this.context, this.monitor, this.issues);
        } catch (Exception e) {
            return CommandResult
                    .newErrorCommandResult(Messages.ExecuteTransformationCommand_Workflow_Invoke_Error);
        }
        if (issues.hasWarnings()) {
            for (MWEDiagnostic warnings : issues.getWarnings()) {
                System.err.println("Warning: " + warnings.getMessage()); //$NON-NLS-1$
            } // TODO: Check how to write multiple warnings, or write directly
            // to the log
            return CommandResult.newWarningCommandResult(
                    "Transformation completed with warnings. " //$NON-NLS-1$
                            + issues.getWarnings()[0], null);
        } else if (issues.hasErrors()) {
            for (MWEDiagnostic errors : issues.getErrors()) {
                System.err.println("Error: " + errors.getMessage()); //$NON-NLS-1$
            } // TODO: Check how to write multiple errors, or write directly to
            // the log
            return CommandResult
                    .newErrorCommandResult("Transformation failed. " //$NON-NLS-1$
                            + issues.getErrors()[0]);
        }

        return CommandResult.newOKCommandResult();
    }

    /**
     * Initializes the transformation
     * 
     * @param editPart
     *            Current edit part
     * @param selection
     *            Current selection
     * @param command
     *            The command to execute
     * @param numSelections
     *            Number of elements that are transformed
     * @param fileName
     *            Name of the .ext transformation file
     * @return
     */
    public boolean initalize(IEditorPart editPart, ISelection selection,
            String command, int numSelections, String fileName,
            String basePackage) {
        StructuredSelection s;

        if (selection instanceof StructuredSelection)
            s = (StructuredSelection) selection;
        else
            return false; // TODO: Throw unsupported exception to user

        if (s.size() != numSelections)
            return false;

        Object selectedObject = s.getFirstElement();
        if (selectedObject instanceof EditPart) {
            if (fileName.contains(".")) { // Remove .ext from fileName //$NON-NLS-1$
                fileName = fileName.substring(0, fileName.lastIndexOf(".")); //$NON-NLS-1$
            }

            workflow = new KielerWorkflow(command, fileName, basePackage);
            Object model = ((EditPart) selectedObject).getModel();
            if (model instanceof View) {
                context.set("model", ((View) model).getElement()); //$NON-NLS-1$
            }

        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List getAffectedFiles() {
        if (affectedFiles != null)
            return affectedFiles;
        else
            return super.getAffectedFiles();
    }

}
