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
  
	private static String _pluginFolder;
	
	public DataProducerExample() {
	}
	
	public void InitializeExecution(String ModelFile) {
		System.setProperty("javax.xml.parsers.SAXParserFactory",
		"com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");
		
        String PluginRoot = DataProducerExample.getPluginFolder();

		//delete old generated model if exists
		String PtolemyModel = PluginRoot + "src-gen/generated.moml";
		File PtolemyModelFile = new File(PtolemyModel);
		if (PtolemyModelFile.exists()) {
			System.out.println("Deleting file '"+PtolemyModel+"'");
			if (!PtolemyModelFile.delete()) {
				System.out.println("Could not delete file '"+PtolemyModel+"'");
			}
		}
		
		// M2M transformation here //
		System.out.println("M2M transformation about to start...");
		System.out.println(ModelFile);
		
        Map<String,String> properties = new HashMap<String,String>();
        Map<String, Object> slotContents = new HashMap<String, Object>();
        
        String WorkflowFile = "model/workflowM2M.oaw";
		properties.put("emfmodel", "file:"+ModelFile);
		properties.put("emfmetamodel", "synccharts.ecore");
		properties.put("ptometamodel", "Moml.ecore");
		properties.put("momlmodel", PtolemyModel); //"src-gen/generated.moml") ;
		
        
		System.out.println("M2M transformation - starting...");
		
        if (new WorkflowRunner().run(WorkflowFile , 
        		null, properties, slotContents)) {
        	System.out.println("M2M transformation - completed.");
        }
        else {
        	System.out.println("M2M transformation - failed.");
        }
		
        /*
		try {
	        String command = "D:\\Studium2009\\PtolemyVergil.bat " + PtolemyModel;
	        Process enc = Runtime.getRuntime().exec(command);
	        enc.waitFor();
	    	enc.getErrorStream().close();
	    	enc.getOutputStream().close();
	    	enc.getInputStream().close();
		    System.out.println(command);
		}//end try
		catch(Exception e) {
			e.printStackTrace();
		}//end catch
		*/

	}
	
	 public static String getPluginFolder() {
	        if(_pluginFolder == null) {
	            _pluginFolder = Platform.getBundle("de.cau.cs.kieler.sim.ptolemy").getLocation();// .toFile();// .resolve(url);
	            _pluginFolder = _pluginFolder.replace("initial@reference:", "");
	        }
	        return _pluginFolder;
	 }
	
	
}
