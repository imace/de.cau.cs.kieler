package edu.unikiel.rtsys.kieler.kiml.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.services.LayoutProviders;

public class ContributionItemLayoutAs extends CompoundContributionItem {

	// must be the same String as defined in the plugin.xml under the command
	public static final String PARAM_LAYOUTER_NAME = "edu.unikiel.rtsys.kieler.kiml.ui.command.layoutAs.parameter.layouterName";
	public static final String LAYOUT_AS_COMMAND = "edu.unikiel.rtsys.kieler.kiml.ui.command.layoutAs";

	protected IContributionItem[] getContributionItems() {

		Map<String, String> parameters = new HashMap<String, String>();
		ArrayList<IContributionItem> finalItems = new ArrayList<IContributionItem>();

		/*
		 * first, get all layout providers, build up the menu entry and order
		 * the menu items according to the layout type, the layouter provides
		 */
		for (LAYOUTER_INFO layoutProviderInfo : LayoutProviders.getInstance()
				.getEnabledLayouterInfos()) {

			parameters.clear();
			parameters.put(PARAM_LAYOUTER_NAME, layoutProviderInfo
					.getLayouterName());
			CommandContributionItemParameter ccip = new CommandContributionItemParameter(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
					LAYOUT_AS_COMMAND + layoutProviderInfo.getLayouterName(),
					LAYOUT_AS_COMMAND, CommandContributionItem.STYLE_PUSH);
			ccip.parameters = parameters;
			ccip.label = layoutProviderInfo.getLayouterName();

			IContributionItem cci = new CommandContributionItem(ccip);
			MenuManager mm = new MenuManager(layoutProviderInfo.getLayoutType()
					.getLiteral());
			mm.add(cci);
			finalItems.add(mm);
		}

		if (finalItems.size() > 0)
			finalItems.add(0, new Separator());

		return finalItems.toArray(new IContributionItem[] {});
	}

	public ContributionItemLayoutAs() {
	}

	public ContributionItemLayoutAs(String id) {
		super(id);
	}

}
