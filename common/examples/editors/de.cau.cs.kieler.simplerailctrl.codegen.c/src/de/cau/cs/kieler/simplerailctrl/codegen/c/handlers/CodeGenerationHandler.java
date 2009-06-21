package de.cau.cs.kieler.simplerailctrl.codegen.c.handlers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;
import org.eclipse.ui.part.FileEditorInput;

public class CodeGenerationHandler extends AbstractHandler {
	
	private static String _pluginFolder;
	
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

        String ModelFile = "";
		if (Editor.getEditorInput() instanceof URIEditorInput) {
			URIEditorInput EditorInput = (URIEditorInput)Editor.getEditorInput();
	        URI EditorURI = EditorInput.getURI();
	        ModelFile = EditorURI.toString();
		}
		else {
			FileEditorInput EditorInput = (FileEditorInput)Editor.getEditorInput();
			ModelFile = EditorInput.getURI().toString();
		}
		
        //delete "_diagram"-extension
		ModelFile = ModelFile.replace("_diagram", "");

		String PluginRoot = this.getPluginFolder();
		String GenFolder = PluginRoot + "src-gen";
		
		// code generation here //
        Map<String,String> properties = new HashMap<String,String>();
        Map<String, Object> slotContents = new HashMap<String, Object>();
        
        String WorkflowFile = "model/workflow.oaw";
		properties.put("model", ModelFile);
		properties.put("metamodel", "SimpleRailCtrl.ecore");
		properties.put("src-gen", GenFolder); 
		
		System.out.println("Code Generation - starting...");
		
        if (new WorkflowRunner().run(WorkflowFile , 
        		new oAwMonitor(), properties, slotContents)) {
        	System.out.println("Code Generation - completed.");
        }
        else {
        	System.out.println("Code Generation - failed.");
        }
		
	    return null;
	}

	
	 public static String getPluginFolder() {
	        if(_pluginFolder == null) {
	            _pluginFolder = Platform.getBundle("de.cau.cs.kieler.simplerailctrl.codegen.c").getLocation();// .toFile();// .resolve(url);
	            _pluginFolder = _pluginFolder.replace("initial@reference:", "");
	            _pluginFolder = _pluginFolder.replace("reference:", "");
	            _pluginFolder = _pluginFolder.replace("file:/", "");
	        }
	        return _pluginFolder;
	 }
	
	 //-------------------------------------------------------------------
	 class oAwMonitor implements ProgressMonitor {

		public void beginTask(String name, int totalWork) {
			// TODO Auto-generated method stub
			
		}

		public void done() {
			// TODO Auto-generated method stub
			
		}

		public void finished(Object element, Object context) {
			// TODO Auto-generated method stub
			
		}

		public void internalWorked(double work) {
			// TODO Auto-generated method stub
			
		}

		public boolean isCanceled() {
			// TODO Auto-generated method stub
			return false;
		}

		public void postTask(Object element, Object context) {
			// TODO Auto-generated method stub
			
		}

		public void preTask(Object element, Object context) {
			// TODO Auto-generated method stub
			
		}

		public void setCanceled(boolean value) {
			// TODO Auto-generated method stub
			
		}

		public void setTaskName(String name) {
			// TODO Auto-generated method stub
			
		}

		public void started(Object element, Object context) {
			// TODO Auto-generated method stub
			
		}

		public void subTask(String name) {
			// TODO Auto-generated method stub
			
		}

		public void worked(int work) {
			// TODO Auto-generated method stub
			
		}
		 
	 }
}
