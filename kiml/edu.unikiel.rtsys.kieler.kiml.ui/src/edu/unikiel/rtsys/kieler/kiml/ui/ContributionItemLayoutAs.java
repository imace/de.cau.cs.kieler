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
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.LayoutProviders;

/**
 * Contributes to context and other menus. Returns menu entries for the
 * different layout actions dependend of the LayoutProviders currently enabled
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutProviders
 */
public class ContributionItemLayoutAs extends CompoundContributionItem {

	/* must be the same String as defined in the plugin.xml under the command */
	public static final String PARAM_LAYOUTER_NAME = "edu.unikiel.rtsys.kieler.kiml.ui.command.layoutAs.parameter.layouterName";
	public static final String LAYOUT_AS_COMMAND = "edu.unikiel.rtsys.kieler.kiml.ui.command.layoutAs";

	/**
	 * Returns all the items to display in the respective context menu. Should
	 * be bound to a certain menu in the plugin.xml file.
	 * 
	 * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
	 */
	protected IContributionItem[] getContributionItems() {

		Map<String, String> parameters = new HashMap<String, String>();
		ArrayList<IContributionItem> finalItems = new ArrayList<IContributionItem>();
		Map<LAYOUT_TYPE, MenuManager> managers = new HashMap<LAYOUT_TYPE, MenuManager>();

		/*
		 * first, get all layout providers, build up the menu entry and order
		 * the menu items according to the layout type, the layouter provides
		 */
		for (LAYOUTER_INFO layoutProviderInfo : LayoutProviders.getInstance()
				.getEnabledLayouterInfos()) {

			/* contruct one command for the layouter */
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

			/*
			 * add the command to the right menu manager, that is a submenu
			 * entry with the LAYOUT_TYPE literal as label. Make shure before
			 * that this menu manager exists...
			 */
			if (!managers.containsKey(layoutProviderInfo.getLayoutType())) {
				MenuManager mm = new MenuManager(layoutProviderInfo
						.getLayoutType().getLiteral());
				managers.put(layoutProviderInfo.getLayoutType(), mm);
				finalItems.add(mm);
			}
			/* ... and then add command to it */
			managers.get(layoutProviderInfo.getLayoutType()).add(cci);
		}

		/* if there is actually at least one item, add a new separator */
		if (finalItems.size() > 0)
			finalItems.add(0, new Separator());

		/* return the stuff to let the menu be built */
		return finalItems.toArray(new IContributionItem[] {});
	}

}
