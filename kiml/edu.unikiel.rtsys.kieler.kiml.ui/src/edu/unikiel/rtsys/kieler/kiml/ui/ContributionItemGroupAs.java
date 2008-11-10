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

import edu.unikiel.rtsys.kieler.kiml.layout.services.LayoutProviders;

public class ContributionItemGroupAs extends CompoundContributionItem {

	// must be the same String as defined in the plugin.xml under the command
	public static final String PARAM_LAYOUTER_NAME = "edu.unikiel.rtsys.kieler.kiml.ui.command.groupAs.parameter.layouterName";
	public static final String GROUP_AS_COMMAND = "edu.unikiel.rtsys.kieler.kiml.ui.command.groupAs";

	protected IContributionItem[] getContributionItems() {

		ArrayList<IContributionItem> contribItems = new ArrayList<IContributionItem>();
		Map<String, String> parameters = new HashMap<String, String>();

		/* separator */
		contribItems.add(new Separator());
		
		for (String layouterName : LayoutProviders.getInstance()
				.getAvailableLayouterNames()) {
			parameters.clear();
			parameters.put(PARAM_LAYOUTER_NAME, layouterName);
			CommandContributionItemParameter ccip = new CommandContributionItemParameter(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
					"edu.unikiel.rtsys.kieler.kiml.ui.CommandContributionItem.GroupAs"
							+ layouterName, GROUP_AS_COMMAND,
					CommandContributionItem.STYLE_PUSH);
			ccip.parameters = parameters;
			ccip.label = "Layout As " + layouterName;

			IContributionItem cci = new CommandContributionItem(ccip);
			contribItems.add(cci);
		}
		return contribItems.toArray(new IContributionItem[] {});
	}

	public ContributionItemGroupAs() {
	}

	public ContributionItemGroupAs(String id) {
		super(id);
	}

}
