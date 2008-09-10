package edu.unikiel.rtsys.kieler.kiml.layout.services;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

/**
 * @author ars
 * 
 */
public class KimlLayouterEngine implements IKimlLayouterEngine {
	IKimlLayoutProvider layoutProvider = null;

	/**
	 * Root layouter class. Chooses the layouter from the contributed ones via
	 * the extension points.
	 */
	public void layout(KLayoutGraph layoutGraph) {
		loadLayouter(null);
		layoutProvider.doLayout(layoutGraph.getTopGroup());
	}

	private void loadLayouter(String type) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = reg
				.getConfigurationElementsFor(IKimlLayoutProvider.EXTENSION_POINT_ID);
		for (IConfigurationElement element : extensions) {
			System.out.println("extension: " + element.getName());
			try {
				layoutProvider = (IKimlLayoutProvider) element
						.createExecutableExtension(IKimlLayoutProvider.ATTRIBUTE_CLASS);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
