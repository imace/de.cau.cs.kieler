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
package edu.unikiel.rtsys.kieler.kiml.layout.services;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

/**
 * Controls all the diagram layouters; which are loaded at startup. Realized as
 * a singleton to allow easy access from anywhere and a fast processing.
 * <p/>
 * Collects the diagram layouters that extend {@link KimlAbstractLayouter} and
 * register themselves at the <code>kimlDiagramLayouter</code> extension point.
 * <p/>
 * Provides a function to get a concrete diagram layouter for a given
 * model/editor provider.
 * <p/>
 * There is still no proper error handling, but that is a KIELER-wide issue.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Spönemann</a>
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlAbstractLayouter
 */
public final class DiagramLayouters {

	/* singleton holder */
	private static final DiagramLayouters INSTANCE = new DiagramLayouters();

	/*
	 * maps the name of a diagram layouter to the instantiated diagram layouter
	 * object
	 */
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

	/*
	 * does the actual loading of the diagram layouters, which need to register
	 * themselves through the kimlDiagramLayouter extension point.
	 * 
	 * TODO: Proper error handling, KIELER-wide
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
