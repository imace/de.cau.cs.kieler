package de.cau.cs.kieler.klots.editor;

import de.cau.cs.kieler.klots.KlotsPlugin;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

/**
 * Manages the installation/deinstallation of global actions for multi-page editors.
 * Responsible for the redirection of global actions to the active editor.
 * Multi-page contributor replaces the contributors for the individual editors in the multi-page editor.
 */
public class SJEditorContributor extends MultiPageEditorActionBarContributor {
	private IEditorPart activeEditorPart;
	private Action compileAndLink;
	private Action downloadToNXT;
	
	
	/**
	 * Creates a multi-page contributor.
	 */
	public SJEditorContributor() {
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
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditor e = (SJEditor) editorPart;
					IFileEditorInput input = (IFileEditorInput)e.getJavaEditor().getEditorInput();
				    IFile file = input.getFile();
				    fileName = file.getName();
				    fileName = fileName.substring(0, fileName.lastIndexOf(".java"));
				    IProject activeProject = file.getProject();
				    projectName = activeProject.getName();
				    projectPath = activeProject.getLocation().toOSString();
				    projectPath = projectPath.substring(0, projectPath.lastIndexOf(projectName));
				    projectName = "." + Path.SEPARATOR + projectName;
				} else {
					System.out.println("###>>> COMPILE PATH ERROR: No active editor!");
				}
//				System.out.println("###>>> COMPILE AND LINK FILE PATH: " + filePath);
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
					String linkCommand = "\"cd " + projectPath + 
					" & nxjlink -cp \"" + projectName + Path.SEPARATOR + "embeddedSJ.jar;" + projectName + Path.SEPARATOR + "bin\" " +
					"." + Path.SEPARATOR + "examples" + Path.SEPARATOR + fileName + "Main " +
					"-o " + projectName + Path.SEPARATOR + "bin" + Path.SEPARATOR + fileName + ".nxj\"";
					System.out.println("###--->>> LINK COMMAND STRING: " + linkCommand);
					Process link = rt.exec("cmd /C " + linkCommand);
					link.waitFor();
					System.out.println("------> OK <-------");
					link.destroy();
//					compile.destroy();
					MessageDialog.openInformation(null, "Embedded SJ", "Embedded SJ program compiled and linked successfully!");
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		compileAndLink.setText("Build program");
		compileAndLink.setToolTipText("Build the embedded SJ program");
		compileAndLink.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(IDE.SharedImages.IMG_OPEN_MARKER));

		// --------------------- download to NXT ----------------------
		downloadToNXT = new Action() {
			public void run() {
				String projectName = "";
				String projectPath = "";
				String fileName = "";
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditor e = (SJEditor) editorPart;
					IFileEditorInput input = (IFileEditorInput)e.getJavaEditor().getEditorInput();
				    IFile file = input.getFile();
				    fileName = file.getName();
				    fileName = fileName.substring(0, fileName.lastIndexOf(".java"));
				    IProject activeProject = file.getProject();
				    projectName = activeProject.getName();
				    projectPath = activeProject.getLocation().toOSString();
				    projectPath = projectPath.substring(0, projectPath.lastIndexOf(projectName));
				    projectName = "." + Path.SEPARATOR + projectName;
				} else {
					System.out.println("###>>> DOWNLOAD TO NXT PATH ERROR: No active editor!");
				}
//				System.out.println("###>>> DOWNLOAD TO NXT FILE PATH: " + filePath);
				try {
					Runtime rt = Runtime.getRuntime() ;
					// download to NXT
					String uploadCommand = "\"cd " + projectPath +
					" & nxjupload -b -r " + projectName + Path.SEPARATOR + "bin" + Path.SEPARATOR + fileName + ".nxj\"";
					System.out.println("###--->>> DOWNLOAD COMMAND STRING: " + uploadCommand);
					Process upload = rt.exec("cmd /C " + uploadCommand);
					upload.waitFor();
					MessageDialog.openInformation(null, "Embedded SJ", "Embedded SJ program downloaded successfully to NXT!");
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		downloadToNXT.setText("Download to NXT");
		downloadToNXT.setToolTipText("Download embeded SJ erogram to NXT");
		downloadToNXT.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(IDE.SharedImages.IMG_OBJS_TASK_TSK));
		// ------------------------------------------------------------
	}
	
	
	public void contributeToMenu(IMenuManager manager) {
		IMenuManager menu = new MenuManager("Embedded &SJ &Menu");
		manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
		menu.add(compileAndLink);
		menu.add(downloadToNXT);
	}
	
	public void contributeToToolBar(IToolBarManager manager) {
		manager.add(new Separator());
		manager.add(compileAndLink);
		manager.add(downloadToNXT);
	}
	
}
