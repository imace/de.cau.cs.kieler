package de.cau.cs.kieler.simplerailctrl.codegen.c.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.dynamichelpers.IFilter;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.workspace.util.*;
import org.eclipse.core.*;
import org.eclipse.gmf.runtime.notation.impl.*;
import org.eclipse.emf.ecore.resource.impl.*;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.gmf.runtime.notation.*;

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
		//get model instance file
		IEditorPart Editor = window.getActivePage().getActiveEditor();
		
		URIEditorInput EditorInput = (URIEditorInput)Editor.getEditorInput();
		//FileEditorInput uri = (FileEditorInput)Editor.getEditorInput();
		//String ModelFile = uri.getURI().getRawPath();// .getPath().makeAbsolute().toString();// .lastSegment().toString();// .toFile().toURI().getRawPath(); // .toString();// .toString();// .getURI() .toFileString();
		//delete "_diagram"-extension
		//ModelFile = ModelFile.replace("_diagram", "");
		//ModelFile = ModelFile.substring(0,ModelFile.length()-8);
		URI EditorURI = EditorInput.getURI();
		String ModelFile = EditorURI.toString();
		
		
		IFile DomainModel = getDomainFileOf(EditorURI);
		System.out.println(DomainModel.getFullPath().toString());
		
		System.out.println(ModelFile);
		
	    return null;
	}

	
//	public IFile getDomainFileOf(IFile diagramFile) {
	public IFile getDomainFileOf(URI diagramURI) {

	    ResourceSet set = new ResourceSetImpl();

	    Resource res = set.getResource(
	    		diagramURI,
//	        URI.createPlatformResourceURI,
//	            diagramFile.getFullPath().toString(),
//	            true),
	        true);

	    for (EObject o : res.getContents()) {
	        if (o instanceof Diagram) {

	            Diagram diagram = (Diagram) o;
	            return WorkspaceSynchronizer.getFile(
	                diagram.getElement().eResource());
	        }
	    }
	    return null;
	}
	
}
