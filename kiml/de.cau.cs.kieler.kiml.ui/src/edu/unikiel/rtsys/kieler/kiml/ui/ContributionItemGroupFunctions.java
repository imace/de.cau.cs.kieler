/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.ui;

import java.util.ArrayList;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

import edu.unikiel.rtsys.kieler.kiml.layout.services.DiagramLayouters;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;


/**
 * Contributes to context and other menus. Returns just menu entries when the
 * grouping functionality of the respective diagram layouter is desired.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see DiagramLayouters
 */
public class ContributionItemGroupFunctions extends CompoundContributionItem {

	/* must be the same String as defined in the plugin.xml under the command */
	public static final String HIGHLIGHT_GROUP_MEMBERS = "edu.unikiel.rtsys.kieler.kiml.ui.command.highlightGroupMembers";
	public static final String SELECT_GROUP_MEMBERS = "edu.unikiel.rtsys.kieler.kiml.ui.command.selectGroupMembers";
	public static final String UNGROUP_ELEMENTS = "edu.unikiel.rtsys.kieler.kiml.ui.command.ungroupElements";

	/**
	 * Returns all the items to display in the respective context menu. Should be
	 * bound to a certain menu in the plugin.xml file.
	 * 
	 * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
	 */
	protected IContributionItem[] getContributionItems() {

		ArrayList<IContributionItem> contribItems = new ArrayList<IContributionItem>();

		String editorId = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().getEditorSite().getId();

		/*
		 * show the grouping functions only if the diagram layouter can handle groups
		 * other than complete compartments
		 */
		if (Boolean
				.parseBoolean(DiagramLayouters
						.getInstance()
						.getDiagramLayouter(editorId)
						.getSettings()
						.get(
								KimlLayoutPreferenceConstants.PREF_GROUP_EVERY_SINGLE_ELEMENT))) {

			/* separator */
			contribItems.add(new Separator());

			/* highlight */
			CommandContributionItemParameter ccip1 = new CommandContributionItemParameter(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
					"edu.unikiel.rtsys.kieler.kiml.ui.CommandContributionItem.highlightGroupMembers",
					HIGHLIGHT_GROUP_MEMBERS, CommandContributionItem.STYLE_PUSH);
			ccip1.label = "Highlight Group Members";
			IContributionItem cci = new CommandContributionItem(ccip1);
			contribItems.add(cci);

			/* select */
			CommandContributionItemParameter ccip2 = new CommandContributionItemParameter(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
					"edu.unikiel.rtsys.kieler.kiml.ui.CommandContributionItem.selectGroupMembers",
					SELECT_GROUP_MEMBERS, CommandContributionItem.STYLE_PUSH);
			ccip2.label = "Select Group Members";
			IContributionItem cci2 = new CommandContributionItem(ccip2);
			contribItems.add(cci2);

			/* ungroup */
			CommandContributionItemParameter ccip3 = new CommandContributionItemParameter(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
					"edu.unikiel.rtsys.kieler.kiml.ui.CommandContributionItem.ungroupElements",
					UNGROUP_ELEMENTS, CommandContributionItem.STYLE_PUSH);
			ccip3.label = "Ungroup Elemenst";
			IContributionItem cci3 = new CommandContributionItem(ccip3);
			contribItems.add(cci3);
		}
		return contribItems.toArray(new IContributionItem[] {});
	}
}
