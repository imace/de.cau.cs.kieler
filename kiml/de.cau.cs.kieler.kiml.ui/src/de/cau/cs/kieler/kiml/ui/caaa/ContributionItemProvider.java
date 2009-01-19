/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Christoph Wulf, cwu@informatik.uni-kiel.de
 *         Johannes Hedtrich, jhed@informatik.uni-kiel.de
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.ui.caaa;

import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContributionItemProvider;
import org.eclipse.jface.action.IAction;

/**
 * The diagram contribution item provider of the CAAA plug-in: It contributes
 * the auto arrange all action to all diagram editors.
 * 
 * @author <a href="mailto:cwu@informatik.uni-kiel.de">Christoph Wulf</a>
 * @author <a href="mailto:jhed@informatik.uni-kiel.de">Johannes Hedtrich</a> 
 * 
 */
public class ContributionItemProvider extends DiagramContributionItemProvider {

	protected IAction createAction(String actionId,
			IWorkbenchPartDescriptor partDescriptor) {
		if (AutoArrangeAllAction.ACTION_ID.equals(actionId)) {
			return new AutoArrangeAllAction(partDescriptor.getPartPage());
		}
		return super.createAction(actionId, partDescriptor);
	}
}
