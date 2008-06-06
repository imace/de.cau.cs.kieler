package edu.unikiel.rtsys.kieler.kiml.ui;

import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContributionItemProvider;
import org.eclipse.jface.action.IAction;


public class KimlContributionItemProvider extends DiagramContributionItemProvider{
	
	protected IAction createAction(String actionId,
			IWorkbenchPartDescriptor partDescriptor) {
		if (KimlArrangeAction.ACTION_ID.equals(actionId)) {
			return new KimlArrangeAction(partDescriptor.getPartPage());
		}
		if (KimlCommandTestAction.ACTION_ID.equals(actionId)) {
			return new KimlCommandTestAction(partDescriptor.getPartPage());
		}
		return super.createAction(actionId, partDescriptor);
	}
}
