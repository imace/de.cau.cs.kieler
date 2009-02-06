/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *	       Miro Spönemann, msp@informatik.uni-kiel.de
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.ui.diagramlayouter;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.kiml.layout.KimlLayoutPlugin;

/**
 * Controls all the KLayoutGraph builders, which are loaded at startup. Realized
 * as a singleton to allow easy access from anywhere and a fast processing.
 * <p/>
 * Collects the KLayoutGraph builders that extend
 * {@link KimlAbstractLayoutGraphBuilder} and register themselves at the
 * <code>kimlLayoutGraphBuilder</code> extension point.
 * <p/>
 * Provides a function to get a concrete KLayoutGraph builder for a given
 * model/editor provider.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Spönemann</a>
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlAbstractLayoutGraphBuilder
 * @see KimlDiagramLayouter
 */
public final class LayoutGraphBuilders {

	/* singleton holder */
	private static final LayoutGraphBuilders INSTANCE = new LayoutGraphBuilders();

	/*
	 * maps the name of a KLayoutGraph builder to the instantiated KLayoutGraph
	 * builder object
	 */
	private HashMap<String, KimlAbstractLayoutGraphBuilder> layoutGraphBuildersMap = new HashMap<String, KimlAbstractLayoutGraphBuilder>();

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
				.getConfigurationElementsFor(KimlAbstractLayoutGraphBuilder.EXTENSION_POINT_ID);

		for (IConfigurationElement element : extensions) {
			try {
				KimlAbstractLayoutGraphBuilder layoutGraphBuilder = (KimlAbstractLayoutGraphBuilder) element
						.createExecutableExtension(KimlAbstractLayoutGraphBuilder.ATTRIBUTE_CLASS);
				String editorId = element
						.getAttribute(KimlAbstractLayoutGraphBuilder.ATTRIBUTE_EDITOR_ID);
				if (layoutGraphBuilder != null && editorId != null) {
					layoutGraphBuildersMap.put(editorId, layoutGraphBuilder);
				}
			} catch (CoreException exception) {
				StatusManager.getManager().handle(exception,
						KimlLayoutPlugin.PLUGIN_ID);
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
	public KimlAbstractLayoutGraphBuilder getLayoutGraphBuilder(String editorId) {
		KimlAbstractLayoutGraphBuilder layoutGraphBuilder = layoutGraphBuildersMap
				.get(editorId);
		if (layoutGraphBuilder != null)
			return layoutGraphBuilder;
		else
			return layoutGraphBuildersMap.get("*");
	}

}
