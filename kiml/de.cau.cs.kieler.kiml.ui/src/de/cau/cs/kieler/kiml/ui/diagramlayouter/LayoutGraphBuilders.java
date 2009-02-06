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
 * Controls all the diagram transformers; which are loaded at startup. Realized as
 * a singleton to allow easy access from anywhere and a fast processing.
 * <p/>
 * Collects the diagram transformers that extend {@link KimlAbstractLayoutGraphBuilder} and
 * register themselves at the <code>kimlDiagramLayouter</code> extension point.
 * <p/>
 * Provides a function to get a concrete diagram transformer for a given
 * model/editor provider.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Spönemann</a>
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlAbstractLayoutGraphBuilder
 */
public final class LayoutGraphBuilders {

	/* singleton holder */
	private static final LayoutGraphBuilders INSTANCE = new LayoutGraphBuilders();

	/*
	 * maps the name of a diagram layouter to the instantiated diagram layouter
	 * object
	 */
	private HashMap<String, KimlAbstractLayoutGraphBuilder> layoutGraphBuildersMap = new HashMap<String, KimlAbstractLayoutGraphBuilder>();

	/**
	 * @return the singleton instance of the DiagramLayouters class
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
	 * does the actual loading of the diagram layouters, which need to register
	 * themselves through the kimlDiagramLayouter extension point.
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
				StatusManager.getManager().handle(exception, KimlLayoutPlugin.PLUGIN_ID);
			}
		}
	}

	/**
	 * Fetches the appropriate diagram layouter for a given diagram editor.
	 * 
	 * @param editorId
	 *            ID string for the editor
	 * @return an instance of the diagram layouter, or the Generic layouter
	 *         found in the ui.package, or no layouter is available at all
	 */
	public KimlAbstractLayoutGraphBuilder getLayoutGraphBuilder(String editorId) {
		KimlAbstractLayoutGraphBuilder layoutGraphBuilder = layoutGraphBuildersMap.get(editorId);
		if (layoutGraphBuilder != null)
			return layoutGraphBuilder;
		else
			return layoutGraphBuildersMap.get("*");
	}

}
