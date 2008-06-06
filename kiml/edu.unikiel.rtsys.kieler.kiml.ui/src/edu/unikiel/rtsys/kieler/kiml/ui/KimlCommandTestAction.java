package edu.unikiel.rtsys.kieler.kiml.ui;

import kiel.layouter.graphviz.LayouterPlugin;

import org.eclipse.draw2d.Animation;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.ui.IWorkbenchPage;

import edu.unikiel.rtsys.kieler.core.services.GenericEventSource;
import edu.unikiel.rtsys.layouter.LayoutType;
import edu.unikiel.rtsys.layouter.gef.SetLayoutCommand;



public class KimlCommandTestAction extends DiagramAction {

	static final int animationDuration = 1000;
	static final boolean doAnimation = false;
	
	static GenericEventSource eventSource = new GenericEventSource();
	
	public KimlCommandTestAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		setId(ACTION_ID);
		setText("KIML test");
		setToolTipText("Tests some internal commands");
	}

	/* Action ID */
	static final String ACTION_ID = "edu.unikiel.rtsys.kieler.kiml.ui.testAction01";
	
	
	public boolean isSelectionListener() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Sets the target request to the arrange all request with the desired layout type.
	 * 
	 * @returns the configured ArrangeRequest
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 */
	protected Request createTargetRequest() {
		return new ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL, LayoutType.DEBUG);
	}
	
	/**
	 * Overrides the getCommand method to add a command before and one after the
	 * original command. The inserted commands are defined to trigger animation of
	 * the original command. 
	 */
	@Override
	protected Command getCommand(){
		CompoundCommand cc = new CompoundCommand();
		if(doAnimation){
			
			Command c1 = new Command(){
				public void execute(){Animation.markBegin();}
			};
			Command c2 = new Command(){
				public void execute(){Animation.run(animationDuration);}
			};
			Command origCommand = super.getCommand(); 
			cc.setLabel(origCommand.getLabel()); 
			cc.setDebugLabel(origCommand.getDebugLabel());
			cc.add(c1);
			cc.add(origCommand);
			cc.add(c2);
		}
		else{
			cc.add(super.getCommand());
		}
		// add fire change event command
		Command c3 = new Command(){
			public void execute(){eventSource.fireGenericEvent(LayouterPlugin.getDefault().getCommonLayer().getLayoutGraph());}
		};
		cc.add(c3);
		return cc;
	}

	/**
	 * Calculates the enablement state of the action. This action is enabled if
	 * the diagram is selected.
	 * 
	 * @return <code>true</code> if the diagram is selected
	 */
	protected boolean calculateEnabled() {
		return getDiagramGraphicalViewer() != null;
	}
	
	public static GenericEventSource getEventSource(){
		return eventSource;
	}
	
}
