package edu.unikiel.rtsys.kieler.kiml.layout.services;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kLayoutGraph;

/**
 * @author ars
 * 
 */
public class KimlLayoutProvider {
	IKimlLayouter layoutProvider = null;

	/**
	 * Root layouter class. Chooses the layouter from the contributed ones via
	 * the extension points.
	 */
	public void doLayout(kLayoutGraph layoutGraph) {
		loadLayouter(null);
		layoutProvider.doLayout(layoutGraph);
	}

	private void loadLayouter(String type) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = reg
				.getConfigurationElementsFor(IKimlLayouter.EXTENSION_POINT_ID);
		for (IConfigurationElement element : extensions) {
			System.out.println("extension: " + element.getName());
			try {
				layoutProvider = (IKimlLayouter) element
						.createExecutableExtension(IKimlLayouter.ATTRIBUTE_CLASS);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
