package de.cau.cs.kieler.sim.ptolemy;

//Example Data Producer//

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.openarchitectureware.workflow.WorkflowRunner;

import de.cau.cs.kieler.sim.kiem.extension.DataProducer;

public class DataProducerExample extends DataProducer { 
  
	private static File _pluginFolder;
	
	public DataProducerExample() {
	}
	
	public void InitializeExecution(String ModelFile) {
		// M2M transformation here //
		System.out.println("M2M transformation about to start...");
		System.out.println(ModelFile);
		
		//String WorkflowFile = "file:X:/dop_eclipse/testspace/de.cau.cs.kieler.sim.ptolemy/src/de/cau/cs/kieler/sim/ptolemy/workflowM2M.oaw";
		
        Map<String,String> properties = new HashMap<String,String>();
        Map<String, Object> slotContents = new HashMap<String, Object>();
        
        System.out.println(DataProducerExample.getPluginFolder());
        
        String PluginRoot = DataProducerExample.getPluginFolder().getAbsolutePath();

        String WorkflowFile = PluginRoot + "\\workflowM2M.oaw";
		properties.put("emfmodel", "file:"+ModelFile);
		properties.put("emfmetamodel", "synccharts.ecore");
		properties.put("ptometamodel", "Moml.ecore");
		properties.put("momlmodel", "file:c:/generated.moml") ;
        
		System.out.println("M2M transformation - starting...");
		
        if (new WorkflowRunner().run(WorkflowFile , 
        		null, properties, slotContents)) {
        	System.out.println("C-Code Generation - completed.");
            System.exit(1);

        }
        else {
        	System.out.println("C-Code Generation - failed.");
        	System.exit(0);
        }
		

	}
	
	 public static File getPluginFolder() {
	        if(_pluginFolder == null) {
	            //URL url = Platform.getBundle("ID_OF_YOUR_PLUGIN").getEntry("/");
	            _pluginFolder = Platform.getLocation().toFile();// .resolve(url);
	            //_pluginFolder = new File(url.getPath());
	        }
	        return _pluginFolder;
	 }
	
	
}
