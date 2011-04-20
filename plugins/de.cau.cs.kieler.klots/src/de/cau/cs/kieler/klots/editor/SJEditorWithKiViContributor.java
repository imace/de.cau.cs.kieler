package de.cau.cs.kieler.klots.editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import de.cau.cs.kieler.klots.KlotsPlugin;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.osgi.framework.Bundle;


/**
 * Manages the installation/deinstallation of global actions for multi-page editors.
 * Responsible for the redirection of global actions to the active editor.
 * Multi-page contributor replaces the contributors for the individual editors in the multi-page editor.
 */
public class SJEditorWithKiViContributor extends MultiPageEditorActionBarContributor {
	
	// the OS specific file separator char, e.g. '/' or '\'
	private final String OS_FILE_SEPARATOR = System.getProperty("file.separator");
	// the OS specific path separator char, e.g. ':' or ';'
	private final String OS_PATH_SEPARATOR = System.getProperty("path.separator");
	
	private IEditorPart activeEditorPart;
	private Action compileAndLink;
	private Action downloadToNXT;
	
	private Action microStepForwards;
	private Action microStepBackwards;
	private Action microStepForwardsAll;
	private Action microStepBackwardsAll;
	
	
	/**
	 * Creates a multi-page contributor.
	 */
	public SJEditorWithKiViContributor() {
		super();
		createActions();
	}
	
	/**
	 * Returns the action registed with the given text editor.
	 * @return IAction or null if editor is null.
	 */
	protected IAction getAction(ITextEditor editor, String actionID) {
		return (editor == null ? null : editor.getAction(actionID));
	}
	
	
	/* (non-JavaDoc)
	 * Method declared in AbstractMultiPageEditorActionBarContributor.
	 */
	public void setActivePage(IEditorPart part) {
		if (activeEditorPart == part)
			return;

		activeEditorPart = part;

		IActionBars actionBars = getActionBars();
		if (actionBars != null) {

			ITextEditor editor = (part instanceof ITextEditor) ? (ITextEditor) part : null;

			actionBars.setGlobalActionHandler(
				ActionFactory.DELETE.getId(),
				getAction(editor, ITextEditorActionConstants.DELETE));
			actionBars.setGlobalActionHandler(
				ActionFactory.UNDO.getId(),
				getAction(editor, ITextEditorActionConstants.UNDO));
			actionBars.setGlobalActionHandler(
				ActionFactory.REDO.getId(),
				getAction(editor, ITextEditorActionConstants.REDO));
			actionBars.setGlobalActionHandler(
				ActionFactory.CUT.getId(),
				getAction(editor, ITextEditorActionConstants.CUT));
			actionBars.setGlobalActionHandler(
				ActionFactory.COPY.getId(),
				getAction(editor, ITextEditorActionConstants.COPY));
			actionBars.setGlobalActionHandler(
				ActionFactory.PASTE.getId(),
				getAction(editor, ITextEditorActionConstants.PASTE));
			actionBars.setGlobalActionHandler(
				ActionFactory.SELECT_ALL.getId(),
				getAction(editor, ITextEditorActionConstants.SELECT_ALL));
			actionBars.setGlobalActionHandler(
				ActionFactory.FIND.getId(),
				getAction(editor, ITextEditorActionConstants.FIND));
			actionBars.setGlobalActionHandler(
				IDEActionFactory.BOOKMARK.getId(),
				getAction(editor, IDEActionFactory.BOOKMARK.getId()));
			actionBars.updateActionBars();
		}
	}
	
	
	private void createActions() {
		// ------------------ compile and link ----------------------
		compileAndLink = new Action() {
			public void run() {
				String projectName = "";
				String projectPath = "";
				String fileName = "";
				
				String pluginPath = "";
				String lejosPath = "";
			    String bcelPath = "";
			    String bluecovePath = "";
			    String bluecove_gplPath = "";
			    String commons_cliPath = "";
				
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					IFileEditorInput input = (IFileEditorInput)e.getJavaEditor().getEditorInput();
				    IFile file = input.getFile();
				    fileName = file.getName();
				    fileName = fileName.substring(0, fileName.lastIndexOf(".java"));
				    IProject activeProject = file.getProject();
				    projectName = activeProject.getName();
				    projectPath = activeProject.getLocation().toOSString();
				    projectPath = projectPath.substring(0, projectPath.lastIndexOf(projectName));
				    
				    //projectName = "." + Path.SEPARATOR + projectName;
				    
				    // ------------------------------------------------------
				    // XXX: LAST CHANGES
				    Bundle bundle = Platform.getBundle(KlotsPlugin.PLUGIN_ID);
				    Path path = new Path("icons/editor.gif");
				    URL fileURL = FileLocator.find(bundle, path, null);
				    try {
						pluginPath = FileLocator.toFileURL(fileURL).toString();
						pluginPath = pluginPath.replace("de.cau.cs.kieler.klots/icons/editor.gif", "");
						System.out.println("????????? FULL PATH: >" + pluginPath + "<");
						// if Windows system
						if( pluginPath.contains(":\\") ) {
							pluginPath = pluginPath.replaceFirst("file:/", "");
						} else {
							pluginPath = pluginPath.replaceFirst("file:", "");
						}
						System.out.println("????????? TRIMMED PATH: >" + pluginPath + "<");
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				    
//				    lejosPath = pluginPath + "org.lejos";
//				    bcelPath = pluginPath + "org.lejos.3rdparty.bcel";
//				    bluecovePath = pluginPath + "org.lejos.3rdparty.bluecove";
//					bluecove_gplPath = pluginPath + "org.lejos.3rdparty.bluecove-gpl";
//				    commons_cliPath = pluginPath + "org.lejos.3rdparty.commons-cli";
					lejosPath = pluginPath + "org.lejos.nxt";
				    bcelPath = pluginPath + "org.lejos.pc.all";
				    bluecovePath = pluginPath + "org.lejos.pc.all";
				    bluecove_gplPath = pluginPath + "org.lejos.pc.all";
				    commons_cliPath = pluginPath + "org.lejos.pc.all";
				    // ------------------------------------------------------
				    
				} else {
					System.out.println("###>>> COMPILE PATH ERROR: No active editor!");
				}
				try {
					Runtime rt = Runtime.getRuntime() ;
					// compile
//					String compileCommand = "\"cd " + projectPath + 
//					" & nxjc -cp \"" + projectName + Path.SEPARATOR + "embeddedSJ.jar\" " +
//					projectName + Path.SEPARATOR + "examples" + Path.SEPARATOR + "*.java\"";
//					System.out.println("###--->>> COMPILE COMMAND STRING: " + compileCommand);
//					Process compile = rt.exec("cmd /C " + compileCommand);
//					compile.waitFor();
					
					// link
//					String linkCommand = "\"cd " + projectPath + 
//					" & nxjlink -cp \"" + projectName + Path.SEPARATOR + "embeddedSJ.jar;" + projectName + "\" " +
//					"." + Path.SEPARATOR + "examples" + Path.SEPARATOR + "EmbeddedABROMain2 " +
//					"-o " + projectName + Path.SEPARATOR + "eABRO2.nxj\"";
					
					
					// ------------------------------------------------------
					// XXX: TESTING SOMETHING NEW!
//					String linkCommand = "\"cd " + projectPath + 
//					" & nxjlink -cp \"" + projectName + Path.SEPARATOR + "embeddedSJ.jar;" + projectName + Path.SEPARATOR + "bin\" " +
//					"." + Path.SEPARATOR + "examples" + Path.SEPARATOR + fileName + "Main " +
//					"-o " + projectName + Path.SEPARATOR + "bin" + Path.SEPARATOR + fileName + ".nxj\"";
					
					// XXX: LAST WORKING!
//					String linkCommand = "\"cd " + projectPath + 
//					" & nxjlink -v -cp \"" + projectName + Path.SEPARATOR + "embeddedSJ.jar;" + projectName + Path.SEPARATOR + "bin\" " +
//					"." + Path.SEPARATOR + "examples" + Path.SEPARATOR + fileName + " " +
//					"-o " + projectName + Path.SEPARATOR + "bin" + Path.SEPARATOR + fileName + ".nxj > " + projectName + Path.SEPARATOR + "build.log\"";
					
				    // XXX: STANDALONE VERSION WORKING ONLY WITH CMD AND BASH
//					String linkCommand = "java -Dnxj.home=\"" + lejosPath +
//					"\" -DCOMMAND_NAME=\"nxjlink\" -Djava.library.path=\"" +
//					lejosPath + Path.SEPARATOR + "bin" + "\" -classpath \"" +
//					bluecovePath + ";" + bcelPath + ";" + commons_cliPath + ";" + lejosPath +
//					"\" js.tinyvm.TinyVM --bootclasspath \"" + lejosPath +
//					"\" --writeorder \"LE\" --classpath \".\" " +
//					"-v -cp \"" + projectPath + projectName + Path.SEPARATOR + "embeddedSJ.jar;" + projectPath + projectName + Path.SEPARATOR + "bin\" " +
//					"." + Path.SEPARATOR + "examples" + Path.SEPARATOR + fileName + " " +
//					"-o " + projectPath + projectName + Path.SEPARATOR + "bin" + Path.SEPARATOR + fileName + ".nxj > " + projectPath + projectName + Path.SEPARATOR + "build.log";
					
					// ------------------------------------------------------
				    // XXX: FINAL STANDALONE WORKING ON WINDOWS!
//					String linkCommand = "java -Dnxj.home=\"" + lejosPath +
//					"\" -DCOMMAND_NAME=\"nxjlink\" -Djava.library.path=\"" +
//					lejosPath + Path.SEPARATOR + "bin" + "\" -classpath \"" +
//					bluecovePath + ";" + bcelPath + ";" + commons_cliPath + ";" + lejosPath +
//					"\" js.tinyvm.TinyVM --bootclasspath \"" + lejosPath +
//					"\" --writeorder \"LE\" --classpath \".\" " +
//					"-v -cp \"" + projectPath + projectName + Path.SEPARATOR + "embeddedSJ.jar;" + projectPath + projectName + Path.SEPARATOR + "bin\" " +
//					"." + Path.SEPARATOR + "examples" + Path.SEPARATOR + fileName + " " +
//					"-o " + projectPath + projectName + Path.SEPARATOR + "bin" + Path.SEPARATOR + fileName + ".nxj";
					
					
					// XXX: LINUX INTEGRATION TEST
					String linkCommand = "java -Dnxj.home=\"" + lejosPath +
					"\" -DCOMMAND_NAME=\"nxjlink\" -Djava.library.path=\"" +
					lejosPath + OS_FILE_SEPARATOR + "bin" +
					"\" -classpath \"" + bluecovePath + OS_PATH_SEPARATOR + bluecove_gplPath + OS_PATH_SEPARATOR +
					bcelPath + OS_PATH_SEPARATOR + commons_cliPath + OS_PATH_SEPARATOR + lejosPath +
					"\" js.tinyvm.TinyVM --bootclasspath \"" + lejosPath +
					"\" --writeorder \"LE\" --classpath \".\" " +
					"-v -cp \"" + projectPath + projectName + OS_FILE_SEPARATOR + "embeddedSJ.jar" + OS_PATH_SEPARATOR +
					projectPath + projectName + OS_FILE_SEPARATOR + "bin\" " +
					"." + OS_FILE_SEPARATOR + "examples" + OS_FILE_SEPARATOR + fileName + " " +
					"-o " + projectPath + projectName + OS_FILE_SEPARATOR + "bin" + OS_FILE_SEPARATOR + fileName + ".nxj";
					// ------------------------------------------------------
					
					System.out.println("###--->>> LINK COMMAND STRING: " + linkCommand);
					
//					Process link = rt.exec("cmd /C " + linkCommand);
					Process link = rt.exec(linkCommand);
					
					InputStream is = link.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					String line;
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					}
					
				       
					link.waitFor();
					System.out.println("------> OK <-------");
					link.destroy();
					MessageDialog.openInformation(null, "Embedded SJ", "Embedded SJ program compiled and linked successfully!");
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		compileAndLink.setText("Build program");
		compileAndLink.setToolTipText("Build the embedded SJ program");
		compileAndLink.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/linkIcon.png") );
//		compileAndLink.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstepIconDisabled.png") );

		
		// --------------------- download to NXT ----------------------
		downloadToNXT = new Action() {
			public void run() {
				String projectName = "";
				String projectPath = "";
				String fileName = "";
				
				String pluginPath = "";
				String lejosPath = "";
			    String bcelPath = "";
			    String bluecovePath = "";
			    String bluecove_gplPath = "";
			    String commons_cliPath = "";
				
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					IFileEditorInput input = (IFileEditorInput)e.getJavaEditor().getEditorInput();
				    IFile file = input.getFile();
				    fileName = file.getName();
				    fileName = fileName.substring(0, fileName.lastIndexOf(".java"));
				    IProject activeProject = file.getProject();
				    projectName = activeProject.getName();
				    projectPath = activeProject.getLocation().toOSString();
				    projectPath = projectPath.substring(0, projectPath.lastIndexOf(projectName));
				    
				    
//				    projectName = "." + Path.SEPARATOR + projectName;
				    
				    // ------------------------------------------------------
				    // XXX: NEW!!!
				    Bundle bundle = Platform.getBundle(KlotsPlugin.PLUGIN_ID);
				    Path path = new Path("icons/editor.gif");
				    URL fileURL = FileLocator.find(bundle, path, null);
				    try {
						pluginPath = FileLocator.toFileURL(fileURL).toString();
						pluginPath = pluginPath.replace("de.cau.cs.kieler.klots/icons/editor.gif", "");
						System.out.println("????????? FULL PATH: >" + pluginPath + "<");
						// if Windows system
						if( pluginPath.contains(":\\") ) {
							pluginPath = pluginPath.replaceFirst("file:/", "");
						} else {
							pluginPath = pluginPath.replaceFirst("file:", "");
						}
						System.out.println("????????? TRIMMED PATH: >" + pluginPath + "<");
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				    
					
//				    lejosPath = pluginPath + "org.lejos";
//				    bcelPath = pluginPath + "org.lejos.3rdparty.bcel";
//				    bluecovePath = pluginPath + "org.lejos.3rdparty.bluecove";
//				    bluecove_gplPath = pluginPath + "org.lejos.3rdparty.bluecove-gpl";
//				    commons_cliPath = pluginPath + "org.lejos.3rdparty.commons-cli";
					lejosPath = pluginPath + "org.lejos.nxt";
				    bcelPath = pluginPath + "org.lejos.pc.all";
				    bluecovePath = pluginPath + "org.lejos.pc.all";
				    bluecove_gplPath = pluginPath + "org.lejos.pc.all";
				    commons_cliPath = pluginPath + "org.lejos.pc.all";
					
				    
				} else {
					System.out.println("###>>> DOWNLOAD TO NXT PATH ERROR: No active editor!");
				}
				try {
					Runtime rt = Runtime.getRuntime() ;
					// download to NXT
//					String downloadToNXTCommand = "\"cd " + projectPath +
//					" & nxjupload -b -r " + projectName + Path.SEPARATOR + "bin" + Path.SEPARATOR + fileName + ".nxj\"";
					
					// XXX: STANDALONE VERSION WORKING ONLY WITH CMD AND BASH
//					String downloadToNXTCommand = "java -Dnxj.home=\"" + lejosPath +
//					"\" -DCOMMAND_NAME=\"nxjupload\" -Djava.library.path=\"" +
//					lejosPath + Path.SEPARATOR + "bin" + "\" -classpath \"" +
//					bcelPath + ";" + bluecovePath + ";" + commons_cliPath + ";" +
//					lejosPath + "\" lejos.pc.tools.NXJUpload " +
//					"-b -r " + projectPath + projectName + Path.SEPARATOR + "bin" + Path.SEPARATOR + fileName + ".nxj";
					
					// XXX: LINUX INTEGRATION TEST
					String downloadToNXTCommand = "java -Dnxj.home=\"" + lejosPath +
					"\" -DCOMMAND_NAME=\"nxjupload\" -Djava.library.path=\"" +
					lejosPath + OS_FILE_SEPARATOR + "bin" + "\" -classpath \"" + bcelPath + OS_PATH_SEPARATOR +
					bluecovePath + OS_PATH_SEPARATOR + bluecove_gplPath + OS_PATH_SEPARATOR +
					commons_cliPath + OS_PATH_SEPARATOR + lejosPath +
					"\" lejos.pc.tools.NXJUpload " +
					"-b -r " + projectPath + projectName + OS_FILE_SEPARATOR + "bin" + OS_FILE_SEPARATOR + fileName + ".nxj";
					
					// ------------------------------------------------------
					
					System.out.println("###--->>> DOWNLOAD COMMAND STRING: " + downloadToNXTCommand);
//					Process upload = rt.exec("cmd /C " + downloadToNXTCommand);
					Process upload = rt.exec(downloadToNXTCommand);
					upload.waitFor();
					MessageDialog.openInformation(null, "Embedded SJ", "Embedded SJ program downloaded successfully to NXT!");
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		downloadToNXT.setText("Download to NXT");
		downloadToNXT.setToolTipText("Download embeded SJ erogram to NXT");
		downloadToNXT.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/downloadIcon.png") );
//		downloadToNXT.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstepIconDisabled.png") );
		// ------------------------------------------------------------------
		
		
		// ----------------------- micro step forward -----------------------
		microStepForwards = new Action() {
			public void run() {
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doMicroStepForwards();
				} else {
					System.out.println("###>>> MICRO STEP FORWARDS ERROR: No active editor!");
				}
			}
		};
		microStepForwards.setText("Microstep Forwards");
		microStepForwards.setToolTipText("Take a microstep forwards");
		microStepForwards.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/microStepIcon.png") );
		
		// ----------------------- micro step backward ----------------------
		microStepBackwards = new Action() {
			public void run() {
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doMicroStepBackwards();
				} else {
					System.out.println("###>>> MICRO STEP BACKWARDS ERROR: No active editor!");
				}
			}
		};
		microStepBackwards.setText("Microstep Backwards");
		microStepBackwards.setToolTipText("Take a microstep backwards");
		microStepBackwards.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/microStepBackIcon.png") );
		
		
		// --------------------- all forward micro steps --------------------
		microStepForwardsAll = new Action() {
			public void run() {
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doAllForwardMicroSteps();
				} else {
					System.out.println("###>>> ALL MICRO STEPS FORWARDS ERROR: No active editor!");
				}
			}
		};
		microStepForwardsAll.setText("All Forward Microsteps");
		microStepForwardsAll.setToolTipText("Do all forward microsteps");
		microStepForwardsAll.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/macroStepIcon.png") );
		
		// --------------------- all backward micro steps -------------------
		microStepBackwardsAll = new Action() {
			public void run() {
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doAllBackwardMicroSteps();
				} else {
					System.out.println("###>>> ALL MICRO STEPS BACKWARDS ERROR: No active editor!");
				}
			}
		};
		microStepBackwardsAll.setText("All Backward Microsteps");
		microStepBackwardsAll.setToolTipText("Do all backward microsteps");
		microStepBackwardsAll.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/macroStepBackIcon.png") );
		// ------------------------------------------------------------
	}
	
	
	
	// ----------------------------------------------------------------------
	// XXX: No menu contribution, for now buttons on the toolbar suffice
	//public void contributeToMenu(IMenuManager manager) {
		//IMenuManager menu = new MenuManager("Embedded &SJ &Menu");
		//manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
		//menu.add(compileAndLink);
		//menu.add(downloadToNXT);
	//}
	// ----------------------------------------------------------------------
	
	public void contributeToToolBar(IToolBarManager manager) {
		manager.add(new Separator());
		manager.add(compileAndLink);
		manager.add(downloadToNXT);
		manager.add(new Separator());
	}
	
}
