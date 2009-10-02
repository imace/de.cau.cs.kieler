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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;

import de.cau.cs.kieler.ksbase.core.KielerWorkflow;

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
        //This is a very ugly way to suppress messages from xtend
        PrintStream syse = System.err;
        PrintStream syso = System.out;
        
        if (workflow == null) {
            return CommandResult
                    .newErrorCommandResult(Messages.ExecuteTransformationCommand_Workflow_Initialization_Error);
        }
        try {
            System.setErr(new PrintStream(new ByteArrayOutputStream()));
            System.setOut(new PrintStream(new ByteArrayOutputStream()));
            workflow.invoke(this.context, this.monitor, this.issues);
        } catch (Exception e) {
            return CommandResult
                    .newErrorCommandResult(Messages.ExecuteTransformationCommand_Workflow_Invoke_Error);
        }
        finally {
            System.setErr(syse);
            System.setOut(syso);
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
            String basePackage, Object[] paramConfig) {
        StructuredSelection s;

        if (selection instanceof StructuredSelection)
            s = (StructuredSelection) selection;
        else
            return false;

        if (s.size() != numSelections)
            return false;

        if (fileName.contains(".")) { // Remove .ext from fileName //$NON-NLS-1$
            fileName = fileName.substring(0, fileName.lastIndexOf(".")); //$NON-NLS-1$
        }
        
        StringBuffer modelSelection = new StringBuffer(); 
        List<Object> orderedList = new ArrayList<Object>(); //Ordered list of elements
        List<Object> leftovers = new ArrayList<Object>(); //Elements that could not be matched with a parameter
        
        for ( Object param : paramConfig) {
        	List<?> list = s.toList();
        	if ( param instanceof String) {
        		//look if one of the parameters matches the paramConfig 
        		for (Object elem : list) {
        			if ( elem.getClass().getCanonicalName().equals(param)) {
        				orderedList.add(elem);
        				break;
        			}
        		}
        		leftovers.add(param); //no matching parameter found
        	}
        	else if (param instanceof String[]) {
        		boolean inserted = false;
        		for (String parameter : (String[])param) {
        			if (inserted) //only insert once
        				break;
        			for (Object elem : list) {
            			if ( elem.getClass().getCanonicalName().equals(parameter)) {
            				orderedList.add(elem);
            				inserted = true;
            				break; //breaks the Object elem : list loop
            			}
            		}
        		}
        		leftovers.add(param); //no matching parameter found
        	}
        }
        orderedList.addAll(leftovers); //append leftover elements to the end of the list
        
        for ( int i = 0; i < orderedList.size(); ++i ) {
        	if ( i > 0)
        		modelSelection.append(",");
        	
        	String currentModel = "model"+String.valueOf(i);
        	modelSelection.append(currentModel);
        	Object selectedObject = orderedList.get(i);
        	if (selectedObject instanceof EditPart) {
        		Object model = ((EditPart) selectedObject).getModel();
        		if (model instanceof View) {
        			context.set(currentModel, ((View) model).getElement()); //$NON-NLS-1$
        		}
        	}
        }
        workflow = new KielerWorkflow(command, fileName, basePackage,modelSelection.toString());
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List getAffectedFiles() {
        IWorkspace workspace = ResourcesPlugin
        .getWorkspace();
        IPath location = Path.fromOSString("/home/mim/workspace_mtest3/test/default.synccharts_diagram");
        IFile file = workspace.getRoot()
        .getFileForLocation(location);

        ArrayList<IFile> l = new ArrayList<IFile>();
        l.add(file);
        return l;
    }

}
