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
package de.cau.cs.kieler.kiml.layout.services;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;

/**
 * Abstract class every concrete layout provider has to extend. Performs the
 * layout of a KLayoutNode through the {@link #doLayout} method and provides
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
	 * @param layoutNode the KLayoutNode which should be laid out
	 * @param progressMonitor progress monitor used to keep track of progress
	 * @throws KielerException if the method fails to perform layout for
	 *     some reason, which should be specified in the exception
	 */
	public abstract void doLayout(KLayoutNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException;

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
	 * @return The KLayouterInfo for this layout provider
	 * 
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo
	 *      KLayouterInfo
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType
	 *      KLayoutType
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption
	 *      KLayoutOption
	 */
	public abstract KLayouterInfo getLayouterInfo();

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
