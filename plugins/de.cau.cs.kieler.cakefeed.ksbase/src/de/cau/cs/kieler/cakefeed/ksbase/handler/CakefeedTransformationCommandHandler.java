package de.cau.cs.kieler.cakefeed.ksbase.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import de.cau.cs.kieler.ksbase.core.EditorTransformationSettings;
import de.cau.cs.kieler.ksbase.core.Transformation;
import de.cau.cs.kieler.ksbase.core.TransformationManager;
import de.cau.cs.kieler.ksbase.ui.KSBasEUIPlugin;
import de.cau.cs.kieler.ksbase.ui.TransformationUIManager;
import de.cau.cs.kieler.ksbase.ui.handler.ExecuteTransformationRequest;
import de.cau.cs.kieler.ksbase.ui.handler.TransformationCommandHandler;
import de.cau.cs.kieler.ksbase.ui.listener.ITransformationEventListener;

	public class CakefeedTransformationCommandHandler extends
		TransformationCommandHandler {

		public Object execute(final ExecutionEvent event) throws ExecutionException {

	    	EditorTransformationSettings editor = TransformationManager.INSTANCE.getEditorById(event
	                .getParameter(EDITOR_PARAM));
	    	Transformation transformation = editor.getTransformationByName(event.getParameter(TRANSFORMATION_PARAM));
	        if (editor != null) {
	            
	            IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
	            // System.out.println("Diag childs (pre): " +
	            // ((DiagramEditor)activeEditor).getDiagram().getVisibleChildren().size());
	            ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getSelectionService()
	                    .getSelection();

	            if (selection instanceof StructuredSelection && !selection.isEmpty()) {

	                // First, we have to store the transformation file because Xtend
	                // doesn't execute strings
	                // We have to do this every time, because we can't be sure that the
	                // file we wrote last time is still valid. We will write it
	                // to the meta-inf folder:

	                EditPart selectedElement = (EditPart) ((StructuredSelection) selection)
	                        .getFirstElement();

	                File file = null;
	                FileOutputStream out = null;
	                try {
	                    IPath path = ResourcesPlugin.getPlugin().getStateLocation();
	                    file = File.createTempFile("extension", ".ext", new File(path.toOSString()));
	                    out = new FileOutputStream(file);
	                    if (!file.exists()) {
	                        if (!file.createNewFile()) {
	                            KSBasEUIPlugin.getDefault().logError(
	                                    "Xtend extension file could not be stored in temporary folder.");
	                            return null;
	                        }
	                    }

	                    out.write(editor.getExtFile().getBytes());
	                    out.flush();
	                    out.close();

	                    // Create request
	                    ExecuteTransformationRequest request = new ExecuteTransformationRequest(
	                            activeEditor, transformation.getExtension(), file.getAbsolutePath(),
	                            selection, editor.getModelPackageClass(), transformation.getParameters());

	                    Command transformationCommand = selectedElement.getCommand(request);

	                    // gets a command stack to execute the command
	                    DiagramCommandStack commandStack = null;
	                    Object adapter = activeEditor.getAdapter(CommandStack.class);
	                    if (adapter instanceof DiagramCommandStack) {
	                        commandStack = (DiagramCommandStack) adapter;
	                    }
	                    if (commandStack == null) {
	                        commandStack = new DiagramCommandStack(((DiagramEditor) activeEditor)
	                                .getDiagramEditDomain());
	                    }
	                    commandStack.execute(transformationCommand);
	                } catch (FileNotFoundException e) {
	                    KSBasEUIPlugin.getDefault().logError("Xtend file not found.");
	                } catch (IOException e) {
	                    KSBasEUIPlugin.getDefault().logError("Xtend file could not be read.");
	                } finally {

	                    // Remove temporary Xtend file
	                    if (file != null) {
	                        if (!file.delete()) {
	                            KSBasEUIPlugin.getDefault().logWarning("Could not remove temporary file.");
	                        }
	                    }
	                    // Close stream
	                    if (out != null) {
	                        try {
	                            out.close();
	                        } catch (IOException e) {
	                            // ignoring nested exception
	                        }
	                    }

	                    // update edit policies, so GMF will generate diagram elements
	                    // for model elements which have been generated during the
	                    // transformation but

	                    if (activeEditor instanceof IDiagramWorkbenchPart) {
	                        EObject obj = ((View) ((IDiagramWorkbenchPart) activeEditor)
	                                .getDiagramEditPart().getModel()).getElement();

	                        List<?> editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(obj);
	                        for (Iterator<?> it = editPolicies.iterator(); it.hasNext();) {

	                            CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it.next();

	                            nextEditPolicy.refresh();
	                        }

	                        IDiagramGraphicalViewer graphViewer = ((IDiagramWorkbenchPart) activeEditor)
	                                .getDiagramGraphicalViewer();
	                        graphViewer.flush();
	                    }

	                }
	            }
	        	
	        } else {
	            KSBasEUIPlugin.getDefault().logError(
	                    "Could not find " + event.getParameter(EDITOR_PARAM)
	                            + ". Please check transformation settings for "
	                            + event.getParameter(TRANSFORMATION_PARAM));
	        }
	        return null;
	    }
}
