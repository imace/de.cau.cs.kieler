package edu.unikiel.rtsys.kieler.kiml.layout.services;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;

/**
 * @author ars
 * 
 */
public class KimlRecursiveGroupLayouterEngine implements IKimlLayouterEngine {

	private IKimlLayoutProvider layoutProvider = null;

	/**
	 * Root layouter class. Chooses the layouter from the contributed ones via
	 * the extension points.
	 */
	public void layout(KLayoutGraph layoutGraph) {
		loadLayouter("");
		layoutRecursively(layoutGraph.getTopGroup());
	}

	private void layoutRecursively(KNodeGroup nodeGroup) {
		for (KNodeGroup subGroups : nodeGroup.getSubNodeGroups()) {
			layoutRecursively(subGroups);
		}
		if (nodeGroup.getSubNodeGroups().size() != 0) {
			layoutProvider.doLayout(nodeGroup, nodeGroup.getLayout()
					.getLayoutType(), nodeGroup.getLayout().getLayouterName());
		}
	}

	private void loadLayouter(String type) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = reg
				.getConfigurationElementsFor(IKimlLayoutProvider.EXTENSION_POINT_ID);
		for (IConfigurationElement element : extensions) {
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
