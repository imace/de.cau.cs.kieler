package de.cau.cs.kieler.klots.editor;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.util.KlotsJob;


/**
 * Manages the installation/deinstallation of global actions for multi-page editors.
 * Responsible for the redirection of global actions to the active editor.
 * Multi-page contributor replaces the contributors for the individual editors in the multi-page editor.
 */
public class KlotsEditorContributor extends EditorActionBarContributor {
	
	private IEditorPart activeEditorPart;
	private Action compileAndLink;
	private Action downloadToNXT;
	private Action runProgram;
	
	
	/**
	 * Creates a multi-page contributor.
	 */
	public KlotsEditorContributor() {
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
		// ---------------------- compile and link --------------------------
		compileAndLink = new Action() {
			public void run() {
			
				KlotsJob job = new KlotsJob( KlotsJob.LINK_JOB,
						KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() );
				job.setUser(true);
				job.schedule();
				
//				String projectName = "";
//				String projectPath = "";
//				String fileName = "";
//				MultiStatus info;
//				
//				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
//				if(editorPart != null) {
//					SJEditor e = (SJEditor) editorPart;
//					IFileEditorInput input = (IFileEditorInput)e.getEditorInput();
//				    IFile file = input.getFile();
//				    fileName = file.getName();
//				    fileName = fileName.substring(0, fileName.lastIndexOf("." + KlotsConstants.SJ_FILE_NAME_EXTENSION));
//				    IProject activeProject = file.getProject();
//				    projectName = activeProject.getName();
//				    projectPath = activeProject.getLocation().toOSString();
//				    projectPath = projectPath.substring(0, projectPath.lastIndexOf(projectName));
//				    
//				    Bundle lejosBundle = Platform.getBundle("org.lejos.nxt");
//					String lejosPath = lejosBundle.getLocation();
//					lejosPath = lejosPath.replaceFirst(".*file:", "");
//				    System.out.println("%%%%%%%%%%%%%%%%%%>>> org.lejos.nxt LOCATION = >" + lejosPath + "<");
//					
//					final String[] args = {"--bootclasspath", lejosPath,
//							"--writeorder", "LE",
//							"--classpath", "\".\"",
//							"-v",
//							"-cp", projectPath + projectName + OS_FILE_SEPARATOR + "embeddedSJ.jar" + OS_PATH_SEPARATOR +
//							projectPath + projectName + OS_FILE_SEPARATOR + "bin",
//							"." + OS_FILE_SEPARATOR + "examples" + OS_FILE_SEPARATOR + fileName,
//							"-o", projectPath + projectName + OS_FILE_SEPARATOR + "bin" + OS_FILE_SEPARATOR + fileName + ".nxj"};
//					final TinyVM link = new TinyVM();
//					link.addProgressMonitor(new CLIToolProgressMonitor());
//					try {
//						link.start(args);
//						info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 0, "Embedded SJ program " + fileName + " built successfully!", null);
//						info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 0, ">OK<", null));
//					} catch (Exception le) {
//						le.printStackTrace();
//						info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to build Embedded SJ program " + fileName + "!", null);
//						info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, le.getMessage(), null));
//					}
//				    
//				} else {
//					System.out.println("###>>> COMPILE PATH ERROR: No active editor!");
//					info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to build Embedded SJ program " + fileName + "!", null);
//					info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, "No active SJ editor!", null));
//				}
//				
//				ErrorDialog.openError(null, "KLOTS", null, info);
				
			}
		};
		compileAndLink.setText("Build program");
		compileAndLink.setToolTipText("Build Embedded SJ program");
		compileAndLink.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/linkIcon.png") );
//		compileAndLink.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstepIconDisabled.png") );

		
		// ------------------------ download to NXT -------------------------
		downloadToNXT = new Action() {
			public void run() {
				
				KlotsJob job = new KlotsJob( KlotsJob.DOWNLOAD_JOB,
						KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() );
				job.setUser(true);
				job.schedule();
				
//				String projectName = "";
//				String projectPath = "";
//				String fileName = "";
//				MultiStatus info;
//				
//				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
//				if(editorPart != null) {
//					SJEditor e = (SJEditor) editorPart;
//					IFileEditorInput input = (IFileEditorInput)e.getEditorInput();
//				    IFile file = input.getFile();
//				    fileName = file.getName();
//				    fileName = fileName.substring(0, fileName.lastIndexOf("." + KlotsConstants.SJ_FILE_NAME_EXTENSION));
//				    IProject activeProject = file.getProject();
//				    projectName = activeProject.getName();
//				    projectPath = activeProject.getLocation().toOSString();
//				    projectPath = projectPath.substring(0, projectPath.lastIndexOf(projectName));
//				    
//				    String[] args = {"-b", projectPath + projectName + OS_FILE_SEPARATOR + "bin" + OS_FILE_SEPARATOR + fileName + ".nxj"};
//					NXJUpload up = new NXJUpload();
//					try {
//						up.run(args);
//						info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 0, "Embedded SJ program " + fileName + " downloaded successfully!", null);
//						info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 0, ">OK<", null));
//					} catch (Exception le) {
//						le.printStackTrace();
//						info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to download Embedded SJ program " + fileName + "!", null);
//						info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, le.getMessage(), null));
//					}
//				    
//				} else {
//					System.out.println("###>>> DOWNLOAD TO NXT PATH ERROR: No active editor!");
//					info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to download Embedded SJ program " + fileName + "!", null);
//					info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, "No active SJ editor!", null));
//				}
//				
//				ErrorDialog.openError(null, "KLOTS", null, info);
				
			}
		};
		downloadToNXT.setText("Download to NXT");
		downloadToNXT.setToolTipText("Download Embedded SJ program to NXT");
		downloadToNXT.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/downloadIcon.png") );
//		downloadToNXT.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstepIconDisabled.png") );
		
		
		// -------------------------- run program ---------------------------
		runProgram = new Action() {
			public void run() {
				
				KlotsJob job = new KlotsJob( KlotsJob.RUN_JOB,
						KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() );
				job.setUser(true);
				job.schedule();
				
//				String fileName = "";
//				MultiStatus info;
//				
//				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
//				if(editorPart != null) {
//					SJEditor e = (SJEditor) editorPart;
//					IFileEditorInput input = (IFileEditorInput)e.getEditorInput();
//				    IFile file = input.getFile();
//				    fileName = file.getName();
//				    fileName = fileName.substring(0, fileName.lastIndexOf("." + KlotsConstants.SJ_FILE_NAME_EXTENSION));
//				    fileName += ".nxj";
//				    
//					NXTCommand nxtCommand = NXTCommand.getSingleton();
//					try {
//						NXTComm nxtComm = NXTCommunicator.getInstance().getNXTComm();
//						nxtCommand.setNXTComm(nxtComm);
//						nxtCommand.startProgram(fileName);
//						// must close low level transmission in order to be able to start a high level transmission
//						NXTCommunicator.getInstance().closeTransmission(false);
//						String msg = NXTCommunicator.getInstance().receiveMessage().toString();
//						if( msg.startsWith("[{" + KlotsConstants.STANDALONE_PROGRAM_MODE_COMMAND_KEY) ) {
//							NXTCommunicator.getInstance().sendMessage(KlotsConstants.STANDALONE_PROGRAM_MODE_COMMAND_KEY);
//							RemotePrintReceiver printer = new RemotePrintReceiver(NXTCommunicator.getInstance());
//							printer.start();
//						}
//					} catch (Exception le) {
//						le.printStackTrace();
//						info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to start Embedded SJ program " + fileName + "!", null);
//						info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, le.getMessage(), null));
//						ErrorDialog.openError(null, "KLOTS", null, info);
//					}
//				    
//				} else {
//					System.out.println("###>>> RUN PROGRAM ON NXT PATH ERROR: No active editor!");
//					info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to start Embedded SJ program " + fileName + "!", null);
//					info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, "No active SJ editor!", null));
//					ErrorDialog.openError(null, "KLOTS", null, info);
//				}
				
			}
		};
		runProgram.setText("Run program on NXT");
		runProgram.setToolTipText("Run program on NXT");
		runProgram.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/runProgramIcon.png") );
//		runProgram.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/runProgramIconDisabled.png") );
		// ------------------------------------------------------------------
			
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
		manager.add(runProgram);
		manager.add(new Separator());
	}
	
}
