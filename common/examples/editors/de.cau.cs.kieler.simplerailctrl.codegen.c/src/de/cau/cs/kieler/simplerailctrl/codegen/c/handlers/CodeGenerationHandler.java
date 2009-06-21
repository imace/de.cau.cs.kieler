package de.cau.cs.kieler.simplerailctrl.codegen.c.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;

public class CodeGenerationHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow activeWorkbenchWindow = HandlerUtil
				.getActiveWorkbenchWindow(event);

		IWorkbenchPage page = activeWorkbenchWindow.getActivePage();
		if (page == null) {
			return null;
		}

		IEditorPart editor = page.getActiveEditor();
		if (editor == null) {
			return null;
		}
		
		IWorkbenchWindow window = activeWorkbenchWindow;
		IEditorPart Editor = window.getActivePage().getActiveEditor();

		URIEditorInput EditorInput = (URIEditorInput)Editor.getEditorInput();
        URI EditorURI = EditorInput.getURI();
        String ModelFile = EditorURI.toString();
        //delete "_diagram"-extension
		ModelFile = ModelFile.replace("_diagram", "");
		
		
	    return null;
	}

	
}
