package de.cau.cs.kieler.klots;

//import org.eclipse.core.resources.IFile;
//import org.eclipse.core.resources.ResourcesPlugin;
//import org.eclipse.core.runtime.IPath;
//import org.eclipse.core.runtime.Path;
//import org.eclipse.ui.IEditorDescriptor;
//import org.eclipse.ui.IEditorPart;
//import org.eclipse.ui.IWorkbenchPage;
//import org.eclipse.ui.PlatformUI;
//import org.eclipse.ui.part.FileEditorInput;

import org.json.JSONObject;

import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;

import de.cau.cs.kieler.klots.editor.InputDataPool;;

public class DataComponentObserver extends JSONObjectDataComponent implements
		IJSONObjectDataComponent {
	
	NXTCommunicator comm;
	InputDataPool dataPool;
	

	@Override
	public void initialize() throws KiemInitializationException {
		
		dataPool = InputDataPool.getInstance();
		dataPool.setBuffer(new StringBuffer("HFSCVBNJHFDXCV:LÖÖPKVXCSXC"));

//		try {
//			Runtime rt = Runtime.getRuntime() ;
//			System.out.print("Compiling program... ");
//			Process compile = rt.exec("E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\compile_src_new.bat") ;
//			compile.waitFor();
//			compile.destroy();
//			System.out.println("Done");
//			
//			System.out.print("Linking program... ");
//			Process link = rt.exec("E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\bin\\link_bin_new3.bat");
//			link.waitFor();
//			link.destroy();
//			System.out.println("Done");
//			
//			System.out.print("Downloading program to NXT... ");
//			Process upload = rt.exec("E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\bin\\upload_bin_new3.bat");
//			upload.waitFor();
//			upload.destroy();
//			System.out.println("Done");
//			
//			Thread.sleep(3000);
//			
//		} catch(Exception e){
//			e.printStackTrace();
//		}
		
//		System.out.println("DataComponentObserver -> INIT!");
		comm = NXTCommunicator.getInstance();
		
//		System.out.println();
//		System.out.println("Message received:");
//		System.out.println("----------------------------------------------");
		//System.out.println( comm.receiveMessage() );
//		System.out.println();
		
		
		dataPool.setBuffer(comm.receiveMessage());
		
	}

	@Override
	public void wrapup() throws KiemInitializationException {
		
	}

	@Override
	public boolean isProducer() {
		return false;
	}

	@Override
	public boolean isObserver() {
		return true;
	}

	@Override
	public JSONObject step(JSONObject jSONObject) throws KiemExecutionException {
		
//		System.out.println("DataComponentObserver -> STEP!");
//		System.out.println("Message received:");
//		System.out.println("----------------------------------------------");
		//System.out.println( comm.receiveMessage() );
//		System.out.println();
		
		dataPool.setBuffer(comm.receiveMessage());
		
		return null;
	}
	
	
//	private static IEditorPart openEditor() {
//		try {
//			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//			IPath path = new Path("./abro.sj");
//			System.out.println("PATH = " + path.toString() );
//			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
//			IEditorDescriptor desc = PlatformUI.getWorkbench().
//			        getEditorRegistry().getDefaultEditor(file.getName());
//			return page.openEditor(new FileEditorInput(file), desc.getId());
//		} catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

}
