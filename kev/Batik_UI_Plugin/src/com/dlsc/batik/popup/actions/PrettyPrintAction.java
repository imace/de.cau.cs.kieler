package com.dlsc.batik.popup.actions;

import java.util.LinkedList;

//import org.apache.batik.apps.svgpp.Main;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.dlsc.batik.preferences.PrettyPrintPreferencePage;
import com.dlsc.batik.viewer.BatikUIPlugin;
import com.dlsc.batik.viewer.Messages;

public class PrettyPrintAction implements IObjectActionDelegate {
	private IFile[] file;
	private IWorkbenchPart targetPart;
	
	/**
	 * Constructor for Action1.
	 */
	public PrettyPrintAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IPreferenceStore store =BatikUIPlugin.getDefault().getPreferenceStore();
		
		String newLine = store.getString(PrettyPrintPreferencePage.P_NEWLINE);
		String docType = store.getString(PrettyPrintPreferencePage.P_DOCTYPE);
		String publicID = store.getString(PrettyPrintPreferencePage.P_PUBLICID);
		String systemID = store.getString(PrettyPrintPreferencePage.P_SYSTEMID);
		String xmlDecl = store.getString(PrettyPrintPreferencePage.P_XMLDECL);
		boolean noFormat = store.getBoolean(PrettyPrintPreferencePage.P_NOFORMAT);
		int tabWidth = store.getInt(PrettyPrintPreferencePage.P_TABWIDTH);
		int docWidth = store.getInt(PrettyPrintPreferencePage.P_DOCWIDTH);

		LinkedList argList = new LinkedList();
		argList.add("-newline"); //$NON-NLS-1$
		argList.add(newLine);
		argList.add("-tab-width"); //$NON-NLS-1$
		argList.add(Integer.toString(tabWidth));
		argList.add("-doc-width"); //$NON-NLS-1$
		argList.add(Integer.toString(docWidth));
		argList.add("-xml-decl"); //$NON-NLS-1$
		argList.add(xmlDecl);

		if (noFormat) {
			argList.add("-no-format"); //$NON-NLS-1$
		}

		if (!docType.equals("leave")) { //$NON-NLS-1$
			argList.add("-doctype"); //$NON-NLS-1$
			argList.add(docType);
			if (docType.equals("replace")) { //$NON-NLS-1$
				argList.add("-public-id"); //$NON-NLS-1$
				argList.add(publicID);
				argList.add("-system-id"); //$NON-NLS-1$
				argList.add(systemID);
			}
		}

		//extra 2 slots for the file names src and dest
		String[] args = new String[argList.size() + 2]; 
		for (int j = 0; j < argList.size(); j++) {
			args[j] = (String) argList.get(j);
			trace(args[j]);
		}
		
		int s = file.length;
		for (int i = 0; i < s; i++) {
			IPath workDirPath = file[i].getProject().getPluginWorkingLocation(BatikUIPlugin.getDefault().getDescriptor());
			trace("work dir: " + workDirPath.toString()); //$NON-NLS-1$
			
			args[argList.size()] = file[i].getRawLocation().toString();
			args[argList.size() + 1] = file[i].getRawLocation().toString() + "tmp"; //$NON-NLS-1$
			
//			Main main = new Main(args);
			try {
//				main.run();

				file[i].getParent().refreshLocal(1, null);
				trace("Path: " + file[i].getProjectRelativePath().toString() + "tmp"); //$NON-NLS-1$ //$NON-NLS-2$
				Path path = new Path(file[i].getProjectRelativePath().toString() + "tmp"); //$NON-NLS-1$
				IFile tmpFile = file[i].getProject().getFile(path);
				file[i].setContents(tmpFile.getContents(), true, true, null);
				tmpFile.delete(true, false, null);
			} catch (Throwable t) {
				t.printStackTrace();
				MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.getString("PrettyPrintAction.FORMATTING_ERROR"), t.getMessage()); //$NON-NLS-1$
			}
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		StructuredSelection ss = (StructuredSelection) selection;
		Object[] obj = ss.toArray();
		int s = obj.length;
		file = new IFile[s];
		for (int i = 0; i < s; i++) {
			file[i] = (IFile) obj[i];
		}
	}
	
	private static void trace(String s) {
		String option = Platform.getDebugOption("com.dlsc.batik.ui/debug/formatting"); //$NON-NLS-1$
		if (option != null && option.equals("true")) { //$NON-NLS-1$
			System.out.println(s);
		}
	}
}
