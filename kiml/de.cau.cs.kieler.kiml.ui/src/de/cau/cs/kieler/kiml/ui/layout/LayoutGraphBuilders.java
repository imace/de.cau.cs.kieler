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
package de.cau.cs.kieler.kiml.ui.layout;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;

/**
 * Controls all the KLayoutGraph builders, which are loaded at startup. Realized
 * as a singleton to allow easy access from anywhere and a fast processing.
 * <p/>
 * Collects the KLayoutGraph builders that extend
 * {@link AbstractLayoutGraphBuilder} and register themselves at the
 * <code>kimlLayoutGraphBuilder</code> extension point.
 * <p/>
 * Provides a function to get a concrete KLayoutGraph builder for a given
 * model/editor provider.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Spönemann</a>
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see AbstractLayoutGraphBuilder
 * @see DiagramLayouter
 */
public final class LayoutGraphBuilders {

	/* singleton holder */
	private static final LayoutGraphBuilders INSTANCE = new LayoutGraphBuilders();

	/*
	 * maps the name of a KLayoutGraph builder to the instantiated KLayoutGraph
	 * builder object
	 */
	private HashMap<String, AbstractLayoutGraphBuilder> layoutGraphBuildersMap = new HashMap<String, AbstractLayoutGraphBuilder>();

	/**
	 * @return the singleton instance of the LayoutGraphBuilders class
	 */
	public static LayoutGraphBuilders getInstance() {
		return INSTANCE;
	}

	/**
	 * On creation of the class all available extensions are loaded.
	 */
	private LayoutGraphBuilders() {
		loadAvailableLayoutGraphBuilders();
	};

	/**
	 * does the actual loading of the KLayoutGraph builder, which need to
	 * register themselves through the kimlLayoutGraphBuilder extension point.
	 */
	private void loadAvailableLayoutGraphBuilders() {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = reg
				.getConfigurationElementsFor(AbstractLayoutGraphBuilder.EXTENSION_POINT_ID);

		for (IConfigurationElement element : extensions) {
			try {
				AbstractLayoutGraphBuilder layoutGraphBuilder = (AbstractLayoutGraphBuilder) element
						.createExecutableExtension(AbstractLayoutGraphBuilder.ATTRIBUTE_CLASS);
				String editorId = element
						.getAttribute(AbstractLayoutGraphBuilder.ATTRIBUTE_EDITOR_ID);
				if (layoutGraphBuilder != null && editorId != null) {
					layoutGraphBuildersMap.put(editorId, layoutGraphBuilder);
				}
			} catch (CoreException exception) {
				StatusManager.getManager().handle(exception,
						KimlUiPlugin.PLUGIN_ID);
			}
		}
	}

	/**
	 * Fetches the appropriate KLayoutGraph builder for a given diagram editor.
	 * 
	 * @param editorId
	 *            ID string for the editor
	 * @return an instance of the KLayoutGraph builder, or the Generic
	 *         KLayoutGraph builder in the ui.package
	 */
	public AbstractLayoutGraphBuilder getLayoutGraphBuilder(String editorId) {
		AbstractLayoutGraphBuilder layoutGraphBuilder = layoutGraphBuildersMap
				.get(editorId);
		if (layoutGraphBuilder != null)
			return layoutGraphBuilder;
		else
			return layoutGraphBuildersMap.get("*");
	}

}
