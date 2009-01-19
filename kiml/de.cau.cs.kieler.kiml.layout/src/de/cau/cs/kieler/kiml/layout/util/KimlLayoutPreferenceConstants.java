/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.layout.util;

/**
 * Constant definitions for the KimlLayout plug-in preferences. Can be used be
 * other plug-in to query the global layout settings through this plug-in's
 * preference store.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class KimlLayoutPreferenceConstants {

	/* constants for layout engine part */
	public static final String PREF_LAYOUTPROVIDERS_LAYOUT_CONNECTION_LABELS = "pref.layout.layout.connection.labels";
	public static final String PREF_LAYOUTPROVIDERS_DEFAULT_LAYOUT_PROVIDER = "pref.layout.default.layouter";

	/* constants for diagram layouter part */
	public static final String PREF_DIAGRAMLAYOUTERS_USE_GMF_TO_LAYOUT_CONNECTION_LABELS = "pref.diagramlayouters.use.gmf.to.layout.connection.labels";
	public static final String PREF_DIAGRAMLAYOUTERS_SMOOTHEN_EDGES = "pref.diagramlayouters.smoothen.edges";
	public static final String PREF_DIAGRAMLAYOUTERS_MULTIPLE_LAYOUT_RUNS = "pref.diagramlayouters.multiple.layout.runs";

	/* constants for diagram layouter part */
	public static final String PREF_GROUP_EVERY_SINGLE_ELEMENT = "pref.group.every.single.element";

}
