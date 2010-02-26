package de.cau.cs.kieler.cakefeed.xtend.handler;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.cakefeed.BasicFunctionBlockDiagram;
import de.cau.cs.kieler.cakefeed.CompositeFunctionBlockDiagram;
import de.cau.cs.kieler.cakefeed.impl.BasicFunctionBlockDiagramImpl;
import de.cau.cs.kieler.cakefeed.impl.CompositeFunctionBlockDiagramImpl;
import de.cau.cs.kieler.cakefeed.impl.FunctionBlockNetworkImpl;
import de.cau.cs.kieler.core.model.transformation.xtend.XtendTransformationFramework;
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;

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
            
            // URI TEST
            //URI uri = URI.createURI("platform:plugin//de.cau.cs.kieler.cakefeed.xtend//transformations//feature.ext");
            // END URI TEST
            
            // HAUKE SAGT: URI.createPlatformPluginURI("/de.cau.cs.kieler.cakefeed.xtend/transformations/feature.ext",true);
            // MICHA SAGT: platform:/resource/de.cau.cs.kieler.cakefeed.xtend//transformations/feature.ext
            String fileName = "C:\\Documents and Settings\\msch165\\Desktop\\eclipse workspace\\de.cau.cs.kieler.cakefeed.xtend\\src\\de\\cau\\cs\\kieler\\cakefeed\\xtend\\transformations\\feature.ext";
            String operation = null;
            
            XtendTransformationFramework xtend = new XtendTransformationFramework();
            
            EObject obj2 = null;
            if (obj instanceof BasicFunctionBlockDiagramImpl) {
            	obj2 = (BasicFunctionBlockDiagram)obj;
            	operation = "BFBDiagramToFBType";
            }else if (obj instanceof CompositeFunctionBlockDiagramImpl) {
            	obj2 = (CompositeFunctionBlockDiagram)obj;
            	operation = "CFBDiagramToFBType";
            }else if (obj instanceof FunctionBlockNetworkImpl) {
            	operation = "CFBNetworkToFFBNetwork";
            }
            
            parameters[0] = obj2;
            
            xtend.setParameters(parameters);
            xtend.initializeTransformation(fileName, operation, metaModels);
            Object result = xtend.executeTransformation();
            if (/*(obj instanceof EObject) && */(result instanceof EObject)) {
            	//String resourceName = ((EObject)obj).eResource().getURI().;
            	write(/*resourceName*/"C:/Documents and Settings/msch165/Desktop/CAKeFEED/demo/out.xml", (EObject)result);
            }
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
	
	public void write(String fileName, EObject root) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(FunctionblocksPackage.eNS_URI, FunctionblocksPackage.eINSTANCE);
		try {
			Resource resource = resourceSet.createResource(URI.createFileURI(fileName));
			resource.getContents().add(root);
			resource.save(null);
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}
	}

}
