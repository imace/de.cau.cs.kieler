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
package de.cau.cs.kieler.kiml.ui.diagramlayouter;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;

/**
 * Controls all the KLayoutGraph appliers, which are loaded at startup. Realized
 * as a singleton to allow easy access from anywhere and a fast processing.
 * <p/>
 * Collects the KLayoutGraph appliers that extend
 * {@link KimlAbstractLayoutGraphApplier} and register themselves at the
 * <code>kimlKLayoutGraphAppliers</code> extension point.
 * <p/>
 * Provides a function to get a concrete KLayoutGraph appliers for a given
 * model/editor provider.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Spönemann</a>
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlAbstractLayoutGraphBuilder
 * @see KimlDiagramLayouter
 */
public final class LayoutGraphAppliers {

	/* singleton holder */
	private static final LayoutGraphAppliers INSTANCE = new LayoutGraphAppliers();

	/*
	 * maps the name of a KLayoutGraph applier to the instantiated KLayoutGraph
	 * applier object
	 */
	private HashMap<String, KimlAbstractLayoutGraphApplier> layoutGraphAppliersMap = new HashMap<String, KimlAbstractLayoutGraphApplier>();

	/**
	 * @return the singleton instance of the LayoutGraphAppliers class
	 */
	public static LayoutGraphAppliers getInstance() {
		return INSTANCE;
	}

	/**
	 * On creation of the class all available extensions are loaded.
	 */
	private LayoutGraphAppliers() {
		loadAvailableLayoutGraphAppliers();
	};

	/**
	 * does the actual loading of the KLayoutGraph applier, which need to
	 * register themselves through the kimlKLayoutGraphApplier extension point.
	 */
	private void loadAvailableLayoutGraphAppliers() {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = reg
				.getConfigurationElementsFor(KimlAbstractLayoutGraphApplier.EXTENSION_POINT_ID);

		for (IConfigurationElement element : extensions) {
			try {
				KimlAbstractLayoutGraphApplier layoutGraphAppliers = (KimlAbstractLayoutGraphApplier) element
						.createExecutableExtension(KimlAbstractLayoutGraphApplier.ATTRIBUTE_CLASS);
				String editorId = element
						.getAttribute(KimlAbstractLayoutGraphApplier.ATTRIBUTE_EDITOR_ID);
				if (layoutGraphAppliers != null && editorId != null) {
					layoutGraphAppliersMap.put(editorId, layoutGraphAppliers);
				}
			} catch (CoreException exception) {
				StatusManager.getManager().handle(exception,
						KimlUiPlugin.PLUGIN_ID);
			}
		}
	}

	/**
	 * Fetches the appropriate KLayoutGraph applier for a given diagram editor.
	 * 
	 * @param editorId
	 *            ID string for the editor
	 * @return an instance of the KLayoutGraph applier, or the Generic
	 *         KLayoutGraph applier found in the ui.package
	 */
	public KimlAbstractLayoutGraphApplier getLayoutGraphAppliers(String editorId) {
		KimlAbstractLayoutGraphApplier layoutGraphApplier = layoutGraphAppliersMap
				.get(editorId);
		if (layoutGraphApplier != null)
			return layoutGraphApplier;
		else
			return layoutGraphAppliersMap.get("*");
	}

}
