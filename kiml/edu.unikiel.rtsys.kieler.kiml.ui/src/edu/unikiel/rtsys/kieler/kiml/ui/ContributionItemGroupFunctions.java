package edu.unikiel.rtsys.kieler.kiml.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.services.DiagramLayouters;
import edu.unikiel.rtsys.kieler.kiml.layout.services.LayoutProviders;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutConstants;

public class ContributionItemGroupFunctions extends CompoundContributionItem {

	// must be the same String as defined in the plugin.xml under the command
	public static final String HIGHLIGHT_GROUP_MEMBERS = "edu.unikiel.rtsys.kieler.kiml.ui.command.highlightGroupMembers";
	public static final String SELECT_GROUP_MEMBERS = "edu.unikiel.rtsys.kieler.kiml.ui.command.selectGroupMembers";
	public static final String UNGROUP_ELEMENTS = "edu.unikiel.rtsys.kieler.kiml.ui.command.ungroupElements";

	protected IContributionItem[] getContributionItems() {

		ArrayList<IContributionItem> contribItems = new ArrayList<IContributionItem>();

		String editorID = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().getEditorSite().getId();
		if (DiagramLayouters.getInstance().getDiagramLayouter(editorID)
				.getSettings()
				.get(KimlLayoutConstants.SETTINGS_GROUP_EVERY_SINGLE_ELEMENT) != null) {

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

	public ContributionItemGroupFunctions() {
	}

	public ContributionItemGroupFunctions(String id) {
		super(id);
	}

}
