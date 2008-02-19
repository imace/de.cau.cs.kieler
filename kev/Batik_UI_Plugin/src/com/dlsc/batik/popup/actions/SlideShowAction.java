package com.dlsc.batik.popup.actions;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.dlsc.batik.preferences.SlideshowPreferencePage;
import com.dlsc.batik.viewer.BatikUIPlugin;
import com.dlsc.batik.viewer.Messages;
import com.dlsc.batik.viewer.SlideShow;

public class SlideShowAction implements IObjectActionDelegate {
	private IFile[] file;

	/**
	 * Constructor for Action1.
	 */
	public SlideShowAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		boolean ok =
			MessageDialog.openConfirm(
				Display.getCurrent().getActiveShell(),
				Messages.getString("SlideShowAction.DIALOG_TITLE"), //$NON-NLS-1$
				Messages.getString("SlideShowAction.INSTRUCTION")); //$NON-NLS-1$
		if (ok) {
			Thread.currentThread().setContextClassLoader(
				getClass().getClassLoader());
			int s = file.length;
			java.io.File[] jFile = new java.io.File[s];
			for (int i = 0; i < s; i++) {
				jFile[i] =
					new java.io.File(file[i].getRawLocation().toString());
			}

			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

			IPreferenceStore store =
				BatikUIPlugin.getDefault().getPreferenceStore();

			if (!store.getBoolean(SlideshowPreferencePage.P_FULL_SCREEN)) {
				int width =
					store.getInt(SlideshowPreferencePage.P_WINDOW_WIDTH);
				int height =
					store.getInt(SlideshowPreferencePage.P_WINDOW_HEIGHT);
				dim = new Dimension(width, height);
			}

			String[] settings =
				{
					"-ws", //$NON-NLS-1$
					Integer.toString(dim.width)
						+ "," //$NON-NLS-1$
						+ Integer.toString(dim.height),
					"-ft", //$NON-NLS-1$
					Integer.toString(
						store.getInt(SlideshowPreferencePage.P_FRAME_TIME)
							* 1000),
					"-tt", //$NON-NLS-1$
					Integer.toString(
						store.getInt(SlideshowPreferencePage.P_TRANSITION_TIME)
							* 1000)};

			LinkedList list = new LinkedList();
			for (int i = 0; i < settings.length; i++) {
				list.add(settings[i]);
			}

			for (int i = 0; i < jFile.length; i++) {
				list.add(jFile[i].getAbsolutePath());
			}

			String[] args = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				args[i] = (String) list.get(i);
			}

			SlideShow.main(args);
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
}
