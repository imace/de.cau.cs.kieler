package de.cau.cs.kieler.core.ui.examplewizard.util;

import java.util.List;

import org.osgi.framework.Version;


/**
 * Containing the information belonging to an example. 
 * 
 * @author omi
 * 
 */
public class Example {

	/** The id of the corresponding plugin */
	private String pluginId;

	/** The lowest needed version of the plugin to execute this example */
	private String pluginVersion;

	/** The example id */
	private String id;

	/** The example name */
	private String name;

	/** The example version */
	private String version;

	/** The name of the online package */
	private String packageName;

	/** Description for this example */
	private String description;

	/** GUI category for this example */ 
	private String category;

	/** Containing files */
	private List<ExampleFile> files;

	/** Additional action */
	private IExampleAction action;

	/**
	 * Constructor for {@code Example}.
	 * @param id example id
	 * @param name example name
	 * @param version example version
	 * @param packageName file name of the package
	 * @param pluginId associated plugin
	 * @param pluginVersion minimum plugin version
	 * @param description example description
	 * @param category gui category
	 * @param files containing files
	 * @param action additional actions
	 */
	public Example(String id, String name, String version, String packageName,
			String pluginId, String pluginVersion, String description,
			String category, List<ExampleFile> files, IExampleAction action) {
		this.id = id;
		this.name = name;
		this.version = version;
		this.packageName = packageName;
		this.pluginId = pluginId;
		this.pluginVersion = pluginVersion;
		this.category = category;
		this.description = description;
		this.files = files;
		this.action = action;
	}

	/**
	 * Returns the plugin id for the plugin needed for this example.
	 * @return
	 */
	public String getPluginId() {
		return this.pluginId;
	}

	/**
	 * Returns example id.
	 * @return
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Returns example name.
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns example description.
	 * @return
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Returns list of files associated with this example.
	 * @return
	 */
	public List<ExampleFile> getFiles() {
		return this.files;
	}

	/**
	 * Returns the additional action for this example. 
	 * @return
	 */
	public IExampleAction getAction() {
		return this.action;
	}

	/**
	 * Returns the minimum needed version number of the plugin needed to use this example
	 * @return
	 */
	public Version getPluginVersion() {
		return new Version(pluginVersion);
	}

	/**
	 * Returns the version number of this example.
	 * @return
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Returns the package file name.
	 * @return
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * Returns the category for this example.
	 * @return
	 */
	public String getCategory() {
		return category;
	}
}
