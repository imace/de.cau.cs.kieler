/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.layout.services;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;

/**
 * Abstract class every concrete layout provider has to extend. Performs the
 * layout of a KNodeGroup through the {@link #doLayout} method and provides
 * information of the layout provider through the {@link #getLayouterInfo}
 * method.
 * <p/>
 * Every layout provider can be switched to enabled or disabled with the
 * {@link #setEnabled} method, as well as its status can be queried with the
 * {@link #isEnabled} call.
 * <p/>
 * Concrete layout providers for must register themselves through the
 * <code>kimlLayoutProvider</code> extension point. All layouter providers
 * published to Eclipse this way are collected with the {@link LayoutProviders}
 * singleton.
 * <p/>
 * There is still no proper error handling. This must be addressed on a KIELER
 * basis.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutProviders
 * @see KimlNullLayoutProvider
 */
public abstract class KimlAbstractLayoutProvider {

	/*
	 * some strings used when creating the concrete layouters via the extension
	 * point mechanism
	 */
	public static final String EXTENSION_POINT_ID = "de.cau.cs.kieler.kiml.layout.kimlLayoutProvider";
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_ICON = "icon";
	private boolean enabled = true;

	/**
	 * Layout providers must implement this method in which they perform the
	 * actual layout process.
	 * 
	 * @param nodeGroup
	 *            The KNodeGroup which should be laid out
	 */
	public abstract void doLayout(KNodeGroup nodeGroup);

	/**
	 * The implemented method should return a LAYOUT_INFO for the layout
	 * provider. Information provided is:
	 * <ul>
	 * <li>Layouter Name</li>
	 * <li>Layout Type</li>
	 * <li>Layout option </i>
	 * <li>Layouter Collection ID</li>
	 * </ul>
	 * 
	 * @return The LAYOUTER_INFO for this layout provider
	 * 
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO
	 *      LAYOUTER_INFO
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE
	 *      LAYOUT_TYPE
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION
	 *      LAYOUT_OPTION
	 */
	public abstract LAYOUTER_INFO getLayouterInfo();

	/**
	 * Sets the desired state of the layout provider. Layout Providers can for
	 * example be turned of in the preference page of each layouter.
	 * 
	 * @param state
	 *            Boolean indicating the state to be set.
	 */
	public void setEnabled(boolean state) {
		enabled = state;
	}

	/**
	 * Queries the actual enable state of the layout provider.
	 * 
	 * @return true, if layouter is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}
}
