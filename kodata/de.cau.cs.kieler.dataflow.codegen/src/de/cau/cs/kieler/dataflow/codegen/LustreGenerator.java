package de.cau.cs.kieler.dataflow.codegen;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.monitor.NullProgressMonitor;

public class LustreGenerator extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println(HandlerUtil.getCurrentSelection(event));
		IEditorPart ed = HandlerUtil.getActiveEditor(event);
		System.out.println(ed.getEditorInput().getName());
		if(ed.isDirty()){
		    ed.doSave(null);
		}
		//String model = Activator.getDefault().  ed.getEditorInput().getName();
		FileEditorInput uri = (FileEditorInput)ed.getEditorInput();
                String model = "file:" + uri.getURI().getRawPath();
                if(model.endsWith("_diagram")){
                    model=model.substring(0, model.length()-8);
                }
                System.out.println("model= "+ model);
                
	        Map<String,String> properties = new HashMap<String,String>();
	        Map<String, Object> slotContents = new HashMap<String, Object>();
	        
	        
	        System.out.println(Activator.getDefault().getStateLocation());
	        properties.put("model", model);
	        //properties.put("metamodel", MetaModel);
	        properties.put("src-gen", ".") ;
		

                WorkflowRunner runner = new WorkflowRunner();  
                
                //System.out.println("Log to: " + runner.getWorkflowLogFileName());
               String generator = "src/generator.oaw";
                //generator = "/home/ctr/shared/kieler/trunk/kodata/de.cau.cs.kieler.dataflow.codegen/src/generator.oaw";
		Log logger = LogFactoryImpl.getLog(runner.getClass());
		logger.fatal("Test");
                boolean success = runner.run(generator,
		        new NullProgressMonitor(),    
		            properties, 
		            slotContents);  
	
		if(success){
		    System.out.println("Code generation complete");
		}else{
		    System.out.println("Code generation failed");
		}
		
		
		return null;
	}

}
