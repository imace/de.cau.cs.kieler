/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui;

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

import de.cau.cs.kieler.kiml.layout.options.LayoutType;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;


/**
 * Contributes to context and other menus. Returns menu entries for the
 * different layout actions dependend of the LayoutProviders currently enabled
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutProviders
 */
public class ContributionItemLayoutAs extends CompoundContributionItem {

	/* must be the same String as defined in the plugin.xml under the command */
	public static final String PARAM_LAYOUTER_NAME = "de.cau.cs.kieler.kiml.ui.command.layoutAs.parameter.layouterName";
	public static final String LAYOUT_AS_COMMAND = "de.cau.cs.kieler.kiml.ui.command.layoutAs";

	/**
	 * Returns all the items to display in the respective context menu. Should
	 * be bound to a certain menu in the plugin.xml file.
	 * 
	 * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
	 */
	protected IContributionItem[] getContributionItems() {

		Map<String, String> parameters = new HashMap<String, String>();
		ArrayList<IContributionItem> finalItems = new ArrayList<IContributionItem>();
		Map<LayoutType, MenuManager> managers = new HashMap<LayoutType, MenuManager>();

		/*
		 * first, get all layout providers, build up the menu entry and order
		 * the menu items according to the layout type, the layouter provides
		 */
		for (AbstractLayoutProvider layoutProvider : KimlLayoutServices
		        .getInstance().getEnabledProviders()) {

			// construct one command for the layouter
			parameters.clear();
			parameters.put(PARAM_LAYOUTER_NAME, layoutProvider.getName());
			CommandContributionItemParameter ccip = new CommandContributionItemParameter(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
					LAYOUT_AS_COMMAND + layoutProvider.getName(),
					LAYOUT_AS_COMMAND, CommandContributionItem.STYLE_PUSH);
			ccip.parameters = parameters;
			ccip.label = layoutProvider.getName();
			IContributionItem cci = new CommandContributionItem(ccip);

			/*
			 * add the command to the right menu manager, that is a submenu
			 * entry with the KLayoutType literal as label. Make sure before
			 * that this menu manager exists...
			 */
			if (!managers.containsKey(layoutProvider.getType())) {
				MenuManager mm = new MenuManager(layoutProvider.getType().toString());
				managers.put(layoutProvider.getType(), mm);
				finalItems.add(mm);
			}
			/* ... and then add command to it */
			managers.get(layoutProvider.getType()).add(cci);
		}

		/* if there is actually at least one item, add a new separator */
		if (finalItems.size() > 0)
			finalItems.add(0, new Separator());

		/* return the stuff to let the menu be built */
		return finalItems.toArray(new IContributionItem[] {});
	}

}
