package com.dlsc.batik.viewer;

import java.awt.Panel;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;

public class SVGView extends ViewPart {
	private static final String TITLE = Messages.getString("SVGView.30"); //$NON-NLS-1$

	private boolean debug = false;
	private Panel awtPanel;
	private IFile svgFile;
	private IProject svgProject;

	private Action refreshAction;
	private Action donateAction;
	
	private SVGComposite svg;
	private PrintAction printAction;
	
	/**
	 * The constructor.
	 */
	public SVGView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and
	 * initialize it.
	 */
	public void createPartControl(Composite parent) {		
		parent.setLayout(new FillLayout());
		
		svg = new SVGComposite(parent,SWT.NONE,false);
		getViewSite().getPage().addSelectionListener(svg);
		
		parent.layout();
		makeActions();
		contributeToActionBars();
	}
	
	private void setStatusText(String txt) {
		setStatusText(txt,false);
	}
	
	private void setStatusText(String txt, boolean error) {
		Display d = Display.getDefault();
		if (d != null) {
			final String status = txt;
			final boolean ferror = error;
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					IActionBars actionBars = getViewSite().getActionBars();
					if (actionBars != null) {
						IStatusLineManager statusLineManager = actionBars.getStatusLineManager();
						if (statusLineManager != null) {
							if (ferror) {
								statusLineManager.setErrorMessage(BatikUIPlugin.getDefault().getImage(BatikUIPlugin.IMG_BATIK_16),status);
							} else {
								statusLineManager.setMessage(status);
							}
						}
					}
				}
			});
		}
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(refreshAction);
		manager.add(printAction);
		manager.add(donateAction);
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(refreshAction);
		manager.add(printAction);
	}

	private void makeActions() {
		refreshAction = new Action() {
			public void run() {
				svg.paintSVGFile();
			}
		};
		refreshAction.setText(Messages.getString("SVGView.23")); //$NON-NLS-1$
		refreshAction.setToolTipText(Messages.getString("SVGView.24")); //$NON-NLS-1$
		refreshAction.setImageDescriptor(BatikUIPlugin.getDefault().getImageDescriptor(BatikUIPlugin.IMG_REFRESH));

		donateAction = new Action() {
			public void run() {
				Program.launch(BatikUIPlugin.DONATION_URL);
			}
		};
		donateAction.setText(Messages.getString("SVGView.DONATE")); //$NON-NLS-1$
		donateAction.setToolTipText(Messages.getString("SVGView.DONATE_TOOLTIP")); //$NON-NLS-1$
	
		printAction = new PrintAction(svg);
		printAction.setImageDescriptor(BatikUIPlugin.getDefault().getImageDescriptor(BatikUIPlugin.IMG_PRINT));
	}

	public void setFocus() {
		svg.setFocus();
	}

	public void dispose() {
		getViewSite().getPage().removeSelectionListener(svg);
		svg.dispose();
		super.dispose();
	}
}