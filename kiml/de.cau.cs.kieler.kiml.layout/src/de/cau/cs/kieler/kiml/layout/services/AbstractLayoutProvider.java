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
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.layout.options.LayoutType;

/**
 * A layout provider executes a layout algorithm to layout the child elements of
 * a node.
 * <p>
 * When used in Eclipse, concrete layout providers must register through the
 * {@code kimlLayoutProvider} extension point. All layout providers
 * published to Eclipse this way are collected with the {@link KimlLayoutServices}
 * singleton.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see NullLayoutProvider
 */
public abstract class AbstractLayoutProvider {

    /** identifier of the Eclipse extension point for layout providers */
	public static final String EXTENSION_POINT_ID = "de.cau.cs.kieler.kiml.layout.kimlLayoutProvider";
	/** name of the 'id' attribute in the extension point */
	public static final String ATTRIBUTE_ID = "id";
	/** name of the 'class' attribute in the extension point */
	public static final String ATTRIBUTE_CLASS = "class";
	/** name of the 'name' attribute in the extension point */
	public static final String ATTRIBUTE_NAME = "name";
	/** name of the 'icon' attribute in the extension point */
	public static final String ATTRIBUTE_ICON = "icon";
	
	/** indicates whether this layout provider is enabled in the UI */
	private boolean enabled = true;

	/**
	 * Performs the actual layout process, that is attaches layout
     * information to the given node object.
	 * 
	 * @param layoutNode the parent node which should be laid out
	 * @param progressMonitor progress monitor used to keep track of progress
	 * @throws KielerException if the method fails to perform layout for
	 *     some reason, which should be specified in the exception
	 */
	public abstract void doLayout(KNode layoutNode,
			IKielerProgressMonitor progressMonitor) throws KielerException;

	/**
	 * Returns the name of this layout provider.
	 * 
	 * @return the layouter name
	 */
	public abstract String getName();
	
	/**
	 * Returns the type of this layout provider.
	 * 
	 * @return the layout type
	 */
	public abstract LayoutType getType();
	
	/**
	 * Returns the collection name of this layout provider.
	 * 
	 * @return the collection name
	 */
	public abstract String getCollection();

	/**
	 * Sets the desired state of the layout provider. Layout Providers can for
	 * example be turned of in the preference page of each layouter.
	 * 
	 * @param state
	 *            boolean indicating the state to be set
	 */
	public final void setEnabled(boolean state) {
		enabled = state;
	}

	/**
	 * Queries the actual enable state of the layout provider.
	 * 
	 * @return true if the layouter is enabled
	 */
	public final boolean isEnabled() {
		return enabled;
	}
	
}
