package edu.unikiel.rtsys.kieler.kev.views;


import java.awt.Panel;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;

import com.dlsc.batik.viewer.BatikUIPlugin;

import edu.unikiel.rtsys.kieler.kev.Messages;
import edu.unikiel.rtsys.kieler.kev.actions.DelayTextField;
import edu.unikiel.rtsys.kieler.kev.actions.StartAction;
import edu.unikiel.rtsys.kieler.kev.actions.StepAction;
import edu.unikiel.rtsys.kieler.kev.actions.StopAction;
import edu.unikiel.rtsys.kieler.kev.animation.AnimationManager;

public class EnvironmentView extends ViewPart {
	
	private Action refreshAction;
	private Action startAction;
	private Action stopAction;
	private Action stepAction;
	private ControlContribution delayTextField;
		
	private EnvironmentComposite svg;
	private AnimationManager animationManager;
	
//	private PrintAction printAction;
	
	/**
	 * The constructor.
	 */
	public EnvironmentView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and
	 * initialize it.
	 */
	public void createPartControl(Composite parent) {		
		parent.setLayout(new FillLayout());
				
		svg = new EnvironmentComposite(parent,SWT.NONE,false);
		animationManager = new AnimationManager(this);
		getViewSite().getPage().addSelectionListener(svg);
		//getViewSite().getPage().addSelectionListener(animationManager);
		// listen to the event that rendering was finished
		svg.getSvgCanvas().addGVTTreeRendererListener(animationManager);
		
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
		manager.add(startAction);
		manager.add(stopAction);
		manager.add(stepAction);
				
//		manager.add(printAction);
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(refreshAction);
		manager.add(startAction);
		manager.add(stopAction);
		manager.add(stepAction);
		manager.add(delayTextField);
		
//		manager.add(printAction);
	}

	private void makeActions() {
		refreshAction = new Action() {
			public void run() {
				svg.paintSVGFile();
			}
		};
		refreshAction.setText(Messages.Refresh);
		refreshAction.setToolTipText(Messages.ReloadSVGImage);
		refreshAction.setImageDescriptor(BatikUIPlugin.getDefault().getImageDescriptor(BatikUIPlugin.IMG_REFRESH));

		startAction = new StartAction(animationManager);
		stopAction = new StopAction(animationManager);
		stepAction = new StepAction(animationManager);
		delayTextField = new DelayTextField(animationManager);
		
		
//		printAction = new PrintAction(svg);
//		printAction.setImageDescriptor(BatikUIPlugin.getDefault().getImageDescriptor(BatikUIPlugin.IMG_PRINT));
	}

	public void setFocus() {
		svg.setFocus();
	}

	public void dispose() {
		getViewSite().getPage().removeSelectionListener(svg);
		svg.dispose();
		super.dispose();
	}
	
	public EnvironmentComposite getComposite(){
		return svg;
	}
}