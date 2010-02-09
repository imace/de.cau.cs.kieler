package de.cau.cs.kieler.cakefeed.xtend.handler;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.cakefeed.BFBDiagram;
import de.cau.cs.kieler.cakefeed.CFBDiagram;
import de.cau.cs.kieler.cakefeed.impl.BFBDiagramImpl;
import de.cau.cs.kieler.cakefeed.impl.CFBDiagramImpl;
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

         
            //EPackage pack = EcoreUtil2.getEPackageByClassName("de.cau.cs.kieler.cakefeed.CakefeedPackage");
            //EmfMetaModel metaModel = new EmfMetaModel(pack);
            String cakefeedModel = "de.cau.cs.kieler.cakefeed.CakefeedPackage";
            String functionblocksModel = "de.cau.cs.kieler.functionblocks.FunctionblocksPackage";
            String[] metaModels = {cakefeedModel, functionblocksModel};
            
            Object[] parameters = new Object[1];
            
            String fileName = "feature.ext";
            String operation = null;
            
            XtendTransformationFramework xtend = new XtendTransformationFramework();
            
            EObject obj2 = null;
            if (obj instanceof BFBDiagramImpl) {
            	obj2 = (BFBDiagram)obj;
            	operation = "BFBDiagramToFBType";
            }else if (obj instanceof CFBDiagramImpl) {
            	obj2 = (CFBDiagram)obj;
            	operation = "CFBDiagramToFBType";
            }else if (true) {
            	operation = "";
            }
            
            parameters[0] = obj2;
            
            xtend.setParameters(parameters);
            xtend.initializeTransformation(fileName, operation, metaModels);
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
