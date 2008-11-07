package edu.unikiel.rtsys.kieler.kiml.layout.services;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

/**
 * Controls existing extensions for the KIML Diagram Layouter extension point.
 * 
 * @author msp
 */
public final class DiagramLayouters {

	private static final DiagramLayouters INSTANCE = new DiagramLayouters();
	private HashMap<String, KimlAbstractLayouter> diagramLayouterMap = new HashMap<String, KimlAbstractLayouter>();

	/**
	 * @return the singleton instance of the DiagramLayouters class
	 */
	public static DiagramLayouters getInstance() {
		return INSTANCE;
	}

	/**
	 * On creation of the class all available extensions are loaded.
	 */
	private DiagramLayouters() {
		loadAvailableLayouters();
	};

	/**
	 * Loads available extensions and puts them into a local map.
	 */
	private void loadAvailableLayouters() {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = reg
				.getConfigurationElementsFor(KimlAbstractLayouter.EXTENSION_POINT_ID);

		for (IConfigurationElement element : extensions) {
			try {
				KimlAbstractLayouter diagramLayouter = (KimlAbstractLayouter) element
						.createExecutableExtension(KimlAbstractLayouter.ATTRIBUTE_CLASS);
				String editorId = element
						.getAttribute(KimlAbstractLayouter.ATTRIBUTE_EDITOR_ID);
				if (diagramLayouter != null && editorId != null) {
					diagramLayouterMap.put(editorId, diagramLayouter);
				}
			} catch (CoreException e) {
				// TODO error handling
				System.out
						.println("===================================================");
				System.out.println("Error creating diagram layouters.");
				e.printStackTrace();
				System.out
						.println("===================================================");
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
	public KimlAbstractLayouter getDiagramLayouter(String editorId) {
		KimlAbstractLayouter diagramLayouter = diagramLayouterMap.get(editorId);
		if (diagramLayouter != null)
			return diagramLayouter;
		else
			return diagramLayouterMap.get("*");
	}

}
