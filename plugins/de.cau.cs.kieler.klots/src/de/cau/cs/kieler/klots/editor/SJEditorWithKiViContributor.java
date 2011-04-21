package de.cau.cs.kieler.klots.editor;

import js.tinyvm.TinyVM;
import js.common.CLIToolProgressMonitor;
import lejos.pc.tools.NXJUpload;
import de.cau.cs.kieler.klots.KlotsConstants;
import de.cau.cs.kieler.klots.KlotsPlugin;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.ErrorDialog;
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
				MultiStatus info;
				
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					IFileEditorInput input = (IFileEditorInput)e.getJavaEditor().getEditorInput();
				    IFile file = input.getFile();
				    fileName = file.getName();
				    fileName = fileName.substring(0, fileName.lastIndexOf("." + KlotsConstants.SJ_FILE_NAME_EXTENSION));
				    IProject activeProject = file.getProject();
				    projectName = activeProject.getName();
				    projectPath = activeProject.getLocation().toOSString();
				    projectPath = projectPath.substring(0, projectPath.lastIndexOf(projectName));
				    
				    Bundle lejosBundle = Platform.getBundle("org.lejos.nxt");
					String lejosPath = lejosBundle.getLocation();
					lejosPath = lejosPath.replaceFirst(".*file:", "");
				    System.out.println("%%%%%%%%%%%%%%%%%%>>> org.lejos.nxt LOCATION = >" + lejosPath + "<");
					
					String[] args = {"--bootclasspath", lejosPath,
							"--writeorder", "LE",
							"--classpath", "\".\"",
							"-v",
							"-cp", projectPath + projectName + OS_FILE_SEPARATOR + "embeddedSJ.jar" + OS_PATH_SEPARATOR +
							projectPath + projectName + OS_FILE_SEPARATOR + "bin",
							"." + OS_FILE_SEPARATOR + "examples" + OS_FILE_SEPARATOR + fileName,
							"-o", projectPath + projectName + OS_FILE_SEPARATOR + "bin" + OS_FILE_SEPARATOR + fileName + ".nxj"};
					TinyVM link = new TinyVM();
					link.addProgressMonitor(new CLIToolProgressMonitor());
					try {
						link.start(args);
						info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 0, "Embedded SJ program " + fileName + " built successfully!", null);
						info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 0, ">OK<", null));
					} catch (Exception le) {
						le.printStackTrace();
						info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to build Embedded SJ program " + fileName + "!", null);
						info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, le.getMessage(), null));
					}
				    
				} else {
					System.out.println("###>>> COMPILE PATH ERROR: No active editor!");
					info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to build Embedded SJ program " + fileName + "!", null);
					info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, "No active SJ editor!", null));
				}
				
				ErrorDialog.openError(null, "KLOTS", null, info);
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
				MultiStatus info;
				
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					IFileEditorInput input = (IFileEditorInput)e.getJavaEditor().getEditorInput();
				    IFile file = input.getFile();
				    fileName = file.getName();
				    fileName = fileName.substring(0, fileName.lastIndexOf("." + KlotsConstants.SJ_FILE_NAME_EXTENSION));
				    IProject activeProject = file.getProject();
				    projectName = activeProject.getName();
				    projectPath = activeProject.getLocation().toOSString();
				    projectPath = projectPath.substring(0, projectPath.lastIndexOf(projectName));
				    
				    String[] args = {"-b", projectPath + projectName + OS_FILE_SEPARATOR + "bin" + OS_FILE_SEPARATOR + fileName + ".nxj"};
					NXJUpload up = new NXJUpload();
					try {
						up.run(args);
						info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 0, "Embedded SJ program " + fileName + " downloaded successfully!", null);
						info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 0, ">OK<", null));
					} catch (Exception le) {
						le.printStackTrace();
						info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to download Embedded SJ program " + fileName + "!", null);
						info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, le.getMessage(), null));
					}
				    
				} else {
					System.out.println("###>>> DOWNLOAD TO NXT PATH ERROR: No active editor!");
					info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to download Embedded SJ program " + fileName + "!", null);
					info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, "No active SJ editor!", null));
				}
				
				ErrorDialog.openError(null, "KLOTS", null, info);
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
