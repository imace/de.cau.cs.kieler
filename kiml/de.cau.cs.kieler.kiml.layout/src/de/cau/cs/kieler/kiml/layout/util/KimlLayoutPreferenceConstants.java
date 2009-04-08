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
package de.cau.cs.kieler.kiml.layout.util;

/**
 * Constant definitions for the KIML layout plug-in preferences. Can be used in
 * other plug-ins to query the global layout settings through this plug-in's
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
