package de.cau.cs.kieler.cakefeed.xtend.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBTypeEditPart;
import de.cau.cs.kieler.core.model.transformation.ITransformationFramework;
import de.cau.cs.kieler.ksbase.core.TransformationFrameworkFactory;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

public class CakefeedTransformationCommand extends AbstractTransactionalCommand {

	/** The component that handles execution of a transformation. **/
    private ITransformationFramework component;

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
    public CakefeedTransformationCommand(
            final TransactionalEditingDomain domain, final String label, final IAdaptable adapter) {
        super(domain, label, null);
        //Get the default transformation framework
        component = TransformationFrameworkFactory.getDefaultTransformationFramework();
    }
    
    /**
     * Executes the command.
     * 
     * @see org.eclipse.gmf.runtime.emf.commands.core.command.
     *      AbstractTransactionalCommand
     *      #doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
     *      org.eclipse.core.runtime.IAdaptable)
     * 
     * @param monitor
     *            Progress monitor for the execution
     * @param info
     *            Additional informations for the command
     * @return Either an Error/Warning command result if the execution failed,
     *         or OK else
     * @throws ExecutionException
     *             if the Execution faild due to a critical error.
     */
    @Override
    protected CommandResult doExecuteWithResult(
            final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {

        component.executeTransformation();

        IEditorPart activeEditor =
                PlatformUI
                        .getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .getActiveEditor();
        if (activeEditor instanceof IDiagramWorkbenchPart) {
            EObject obj =
                    ((View) ((IDiagramWorkbenchPart) activeEditor).getDiagramEditPart().getModel())
                            .getElement();

            List<?> editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(obj);
            for (Iterator<?> it = editPolicies.iterator(); it.hasNext();) {

                CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it.next();

                nextEditPolicy.refresh();
            }

            IDiagramGraphicalViewer graphViewer =
                    ((IDiagramWorkbenchPart) activeEditor).getDiagramGraphicalViewer();
            graphViewer.flush();
        }
        return CommandResult.newOKCommandResult();
    }
    
    /**
     * Initializes the transformation.
     * 
     * @param editPart
     *            Current edit part
     * @param selection
     *            Current selection
     * @param command
     *            The command to execute
     * @param fileName
     *            Name of the .ext transformation file
     * @param basePackage
     *            The package of the underlying meta model
     * @param parameter
     *            The parameters of the Xtend method
     * @return False if an error occurred
     */
	public boolean initalize(
            final IEditorPart editPart, final ISelection selection, final String command,
            final String fileName, final String basePackage, final String[] parameter) {
		StructuredSelection s;

        if (selection instanceof StructuredSelection) {
            s = (StructuredSelection) selection;
        } else {
            return false;
        }

        int i = 0;
        EditPart fBType = null;
        while ((fBType == null) && (i < s.size())) {
        	Object obj = s.toList().get(i);
        	if (obj instanceof EditPart) {
        		fBType = findRoot((EditPart)obj);
        	}
		}
        
        Object[] parameters = new Object[1];
        parameters[1] = fBType;
        
        EPackage pack = EcoreUtil2.getEPackageByClassName(basePackage);
        EmfMetaModel metaModel = new EmfMetaModel(pack);
        
        component.initializeTransformation(fileName, command, metaModel, parameters);
        
        return true;
	}

	private EditPart findRoot(EditPart eP) {
		if (eP == null) {
			return null;
		}
		else if ((eP instanceof BFBTypeEditPart)
				|| (eP instanceof CFBTypeEditPart)
				/*|| (eP instanceof ApplicationEditPart)*/) {
			return eP;
		}
		else {
			return findRoot(eP.getParent());
		}
	}

}
