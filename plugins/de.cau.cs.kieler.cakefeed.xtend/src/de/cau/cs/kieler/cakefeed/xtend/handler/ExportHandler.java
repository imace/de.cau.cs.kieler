package de.cau.cs.kieler.cakefeed.xtend.handler;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.cau.cs.kieler.cakefeed.BFBType;
import de.cau.cs.kieler.cakefeed.CFBType;
import de.cau.cs.kieler.cakefeed.FBNetwork;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBNetworkEditPart;
import de.cau.cs.kieler.core.model.transformation.xtend.XtendTransformationFramework;

public class ExportHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IEditorPart activeEditor =
                PlatformUI
                        .getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .getActiveEditor();
        if (activeEditor instanceof IDiagramWorkbenchPart) {
            EObject obj =
                    ((View) ((IDiagramWorkbenchPart) activeEditor).getDiagramEditPart().getModel())
                            .getElement();

         
            EPackage pack = EcoreUtil2.getEPackageByClassName(????);
            EmfMetaModel metaModel = new EmfMetaModel(pack);
            
            Object[] parameters = new Object[1];
            parameters[0] = obj;
            
            String fileName = "feature.ext";
            String operation = null;
            
            XtendTransformationFramework xtend = new XtendTransformationFramework();
            
            if (obj instanceof BFBType) {
            	operation = "bfbgmf2xml";
            }else if (obj instanceof CFBType) {
            	operation = "cfbgmf2xml";
            }else if (obj instanceof FBNetwork) {
            	operation = "fbnetworkgmf2xml";
            }
            
            xtend.initializeTransformation(fileName, operation, metaModel, parameters);
            xtend.executeTransformation();
            
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
}
