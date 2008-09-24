package edu.unikiel.rtsys.kieler.kiml.layout.services;

import java.util.ArrayList;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;

public abstract class KimlAbstractLayoutProvider {

	public static final String EXTENSION_POINT_ID = "edu.unikiel.rtsys.kieler.kiml.layout.kimlLayoutProvider";
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_ICON = "icon";
	
	/**
	 * Layout providers must implement this methods to perform the actual layout
	 * process.
	 * 
	 * @param nodeGroup
	 *            The KNodeGroup which should be laid out
	 */
	public abstract void doLayout(KNodeGroup nodeGroup);

	/**
	 * This method identifies the layout provider in case there are ambiguities.
	 * 
	 * @return An Id to identify the layout provider
	 */
	public abstract String getLayoutProviderID();

	/**
	 * This methods returns an ArrayList with the available layouters, enriched
	 * with information of the types of layout they provide (each layouter name
	 * should correspond to one type of layout) and information about layout
	 * options (can be more than one, combined by | ).
	 * 
	 * @return An ArrayList with information about the available layouters
	 */
	public abstract ArrayList<LAYOUTER_INFO> getLayouterInfos();

	/*
	 * The following functions are convenience methods for users working with
	 * the layout provider
	 */
	public ArrayList<String> getLayouterNames() {
		ArrayList<String> layouterNames = new ArrayList<String>();
		for (LAYOUTER_INFO layouterInfo : getLayouterInfos()) {
			layouterNames.add(layouterInfo.getLayouterName());
		}
		return layouterNames;
	}

	public ArrayList<LAYOUT_TYPE> getLayoutTypes() {
		ArrayList<LAYOUT_TYPE> layoutTypes = new ArrayList<LAYOUT_TYPE>();
		for (LAYOUTER_INFO layouterInfo : getLayouterInfos()) {
			layoutTypes.add(layouterInfo.getLayoutType());
		}
		return layoutTypes;
	}

	public boolean providesLayouterName(String layouterName) {
		return getLayouterNames().contains(layouterName);
	}

	public boolean providesLayoutType(LAYOUT_TYPE layoutType) {
		return getLayoutTypes().contains(layoutType);
	}

	public ArrayList<String> getLayouterNamesForLayoutType(
			LAYOUT_TYPE layoutType) {
		ArrayList<String> layouterNames = new ArrayList<String>();
		for (LAYOUTER_INFO layouterInfo : getLayouterInfos()) {
			if (layouterInfo.getLayoutType().equals(layoutType))
				layouterNames.add(layouterInfo.getLayouterName());
		}
		return layouterNames;
	}

	public LAYOUT_TYPE getLayoutTypeForLayouterName(String layouterName) {
		for (LAYOUTER_INFO layouterInfo : getLayouterInfos()) {
			if (layouterInfo.getLayouterName().equals(layouterName))
				return layouterInfo.getLayoutType();
		}
		return null;
	}

}
