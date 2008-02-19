/*
 * Created on 16.03.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dlsc.batik.editor;

import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.texteditor.BasicTextEditorActionContributor;

import com.dlsc.batik.viewer.PrintAction;

/**
 * @author dlemmermann
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SVGViewEditorActionBarContributor extends
		BasicTextEditorActionContributor {
	PrintAction printAction;
	
	public void init(IActionBars bars, IWorkbenchPage page) {
		super.init(bars, page);
		printAction = new PrintAction();
		printAction.setEnabled(true);
		bars.setGlobalActionHandler(ActionFactory.PRINT.getId(), printAction);
	}

	public void setActiveEditor(IEditorPart part) {
		printAction.setEditor(part);
	}
}
