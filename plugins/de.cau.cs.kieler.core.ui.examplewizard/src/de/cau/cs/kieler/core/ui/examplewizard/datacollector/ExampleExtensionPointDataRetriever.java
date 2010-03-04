package de.cau.cs.kieler.core.ui.examplewizard.datacollector;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.internal.util.BundleUtility;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.core.ui.examplewizard.Activator;
import de.cau.cs.kieler.core.ui.examplewizard.util.Example;
import de.cau.cs.kieler.core.ui.examplewizard.util.ExampleFile;
import de.cau.cs.kieler.core.ui.examplewizard.util.IExampleAction;

/**
 * Class that gathers extension data from the 'examples' extension point and
 * publishes this data using the singleton pattern.
 * 
 * @author omi
 */
@SuppressWarnings("restriction")
public class ExampleExtensionPointDataRetriever implements IDataRetriever {

	/** Identifier of the extension point */
	public final static String EXTENSION_POINT_ID = "de.cau.cs.kieler.core.ui.examplewizard.examples";

	/**
	 * The singleton instance of the {@code ExampleExtensionPointDataRetriever}
	 * class.
	 */
	public final static ExampleExtensionPointDataRetriever INSTANCE = new ExampleExtensionPointDataRetriever();

	// list of example ids with associated names
	private List<Example> examples;

	/**
	 * Creates an instance of this class and gathers extension data.
	 */
	@SuppressWarnings("restriction")
	ExampleExtensionPointDataRetriever() {
		examples = new ArrayList<Example>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT_ID);
		for (IConfigurationElement element : elements) {
			if ("example".equals(element.getName())) {
				try {
					String pluginId = "";
					String id = element.getAttribute("id");
					String name = element.getAttribute("name");
					String description = element.getAttribute("description");
					IExampleAction action = null;
					String actionString = element.getAttribute("action");
					if (actionString != null) {
						action = (IExampleAction) element
								.createExecutableExtension("action");
					}
					IConfigurationElement[] files = element.getChildren("file");
					ArrayList<ExampleFile> fileList = new ArrayList<ExampleFile>();
					if (files != null) {
						for (IConfigurationElement file : files) {
							String location = file.getAttribute("location");
							IExtension extension = file.getDeclaringExtension();
							pluginId = extension.getNamespaceIdentifier();
							Bundle bundle = Platform.getBundle(pluginId);
							URL url = BundleUtility.find(bundle, location);
							boolean showInDefaultEditor = Boolean
									.parseBoolean(file
											.getAttribute("showInDefaultEditor"));
							fileList.add(new ExampleFile(url,
									showInDefaultEditor));
						}
					}
					if (id != null && name != null) {
						examples.add(new Example(id, name, "default", null,
								pluginId, null, description, null, fileList,
								action));
					}
				} catch (CoreException exception) {
					StatusManager.getManager().handle(exception,
							Activator.PLUGIN_ID);
				}
			}
		}
	}

	/**
	 * @see de.cau.cs.kieler.core.ui.examplewizard.datacollector.IDataRetriever#getExamples()
	 */
	public List<Example> getExamples() {
		return this.examples;
	}

	/**
	 * @see de.cau.cs.kieler.core.ui.examplewizard.datacollector.IDataRetriever#getExampleById(java.lang.String)
	 */
	public Example getExampleById(String id) {
		// TODO think about versions
		Example example = null;
		for (Example temp : this.examples) {
			if (temp.getId().equals(id)) {
				example = temp;
			}
		}
		return example;
	}

	/**
	 * @see de.cau.cs.kieler.core.ui.examplewizard.datacollector.IDataRetriever#getExampleIds()
	 */
	public List<String> getExampleIds() {
		// TODO think about versions
		List<String> ids = new ArrayList<String>();
		for (Example example : this.examples) {
			ids.add(example.getId());
		}
		return ids;
	}

	/**
	 * @see de.cau.cs.kieler.core.ui.examplewizard.datacollector.IDataRetriever#getExamplesByPluginId(java.lang.String)
	 */
	public List<Example> getExamplesByPluginId(String pluginId) {
		List<Example> examples = new ArrayList<Example>();
		for (Example example : this.examples) {
			if (example.getPluginId().equals(pluginId)) {
				examples.add(example);
			}
		}
		return examples;
	}

	/**
	 * @see de.cau.cs.kieler.core.ui.examplewizard.datacollector.IDataRetriever#getPluginIds()
	 */
	public List<String> getPluginIds() {
		List<String> ids = new ArrayList<String>();
		for(Example example : this.examples) {
			String id = example.getPluginId();
			if(!ids.contains(id)) {
				ids.add(id);
			}
		}
		return ids;

	}

}
