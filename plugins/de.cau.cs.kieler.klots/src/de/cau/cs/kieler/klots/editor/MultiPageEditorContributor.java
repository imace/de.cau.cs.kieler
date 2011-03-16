package de.cau.cs.kieler.klots.editor;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
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
public class MultiPageEditorContributor extends MultiPageEditorActionBarContributor {
	private IEditorPart activeEditorPart;
	private Action compileAndLink;
	private Action downloadToNXT;
	
	PathLibrary pathLibrary = PathLibrary.getInstance();
	
	/**
	 * Creates a multi-page contributor.
	 */
	public MultiPageEditorContributor() {
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
				
				String filePath = pathLibrary.getPath();
				System.out.println("###>>> COMPILE AND LINK FILE PATH: " + filePath);
				
				try {
					Runtime rt = Runtime.getRuntime() ;
//					Process compile = rt.exec("E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\compile_src_new.bat") ;
//					String compileCommand = "nxjc E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\src\\sj\\*.java E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\src\\sj\\examples\\*.java E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\src\\sj\\exceptions\\*.java E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\src\\sj\\util\\*.java";
					String compileCommand = "nxjc " +
					filePath + Path.SEPARATOR + "sj" + Path.SEPARATOR + "*.java " +
					filePath + Path.SEPARATOR + "sj" + Path.SEPARATOR + "examples" + Path.SEPARATOR + "*.java " +
					filePath + Path.SEPARATOR + "sj" + Path.SEPARATOR + "exceptions" + Path.SEPARATOR + "*.java " +
					filePath + Path.SEPARATOR + "sj" + Path.SEPARATOR + "util" + Path.SEPARATOR + "*.java";
					Process compile = rt.exec("cmd /C " + compileCommand);
					compile.waitFor();
//					Process link = rt.exec("E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\bin\\link_bin_new3.bat");
//					String linkCommand = "\"cd E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\src & nxjlink -o eABRO2.nxj -cp \".\" .\\sj\\examples\\EmbeddedABROMain2\"";
					String linkCommand = "\"cd " + filePath + Path.SEPARATOR +
					" & nxjlink -o eABRO2.nxj -cp \".\" ." + Path.SEPARATOR + "sj" + Path.SEPARATOR + "examples" + Path.SEPARATOR + "EmbeddedABROMain2\"";
					Process link = rt.exec("cmd /C " + linkCommand);
					System.out.println("------> OK <-------");
					link.waitFor();
					link.destroy();
					compile.destroy();
					MessageDialog.openInformation(null, "Embedded SJ", "Embedded SJ program compiled and linked successfully!");
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		compileAndLink.setText("Compile and link");
		compileAndLink.setToolTipText("Compile and link embedded SJ program");
		compileAndLink.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(IDE.SharedImages.IMG_OPEN_MARKER));
		// --------------------- download to NXT ----------------------
		downloadToNXT = new Action() {
			public void run() {
				
				String filePath = pathLibrary.getPath();
				System.out.println("###>>> DOWNLOAD TO NXT FILE PATH: " + filePath);
				
				try {
					Runtime rt = Runtime.getRuntime() ;
//					Process upload = rt.exec("E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\bin\\upload_bin_new3.bat");
//					String uploadCommand = "\"cd E:\\iMesh\\PROGRAMME\\saves\\embedded_lejos_new\\src & nxjupload -b -r eABRO2.nxj\"";
					String uploadCommand = "\"cd " + filePath + " & nxjupload -b -r eABRO2.nxj\"";
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
		IMenuManager menu = new MenuManager("Embedded &JS &Menu");
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
