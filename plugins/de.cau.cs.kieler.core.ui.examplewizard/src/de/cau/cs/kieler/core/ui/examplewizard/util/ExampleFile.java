package de.cau.cs.kieler.core.ui.examplewizard.util;

import java.net.URL;

/**
 * File of an example. Containing its location and if it should be shown in its
 * default editor. A file can be bild with a locating url or a name in the
 * online package. The target folder is optional. Without a target folder the
 * file will be copied to root.
 * 
 * @author omi
 * 
 */
public class ExampleFile {

	/** The files location as URL. */
	private URL url;

	/** The files name in the online package. */
	private String file;

	/** The target folder to install the file to. */
	private String targetFolder;

	/** Should this file be loaded in its default editor. */
	private boolean showInDefaultEditor;

	/**
	 * Constructing the example file with an locating url. The file is null.
	 * 
	 * @param url
	 *            The loction of the file.
	 * @param showInDefaultEditor
	 *            Should this file be loaded in its default editor.
	 * @param targetFolder
	 *            The target folder to install the file to.
	 */
	public ExampleFile(URL url, boolean showInDefaultEditor, String targetFolder) {
		this.url = url;
		this.showInDefaultEditor = showInDefaultEditor;
		this.file = null;
		this.targetFolder = targetFolder;
	}

	/**
	 * Constructing the example file with a name corresponding to the one in the
	 * package. The url is null.
	 * 
	 * @param file
	 *            Name of the file.
	 * @param showInDefaultEditor
	 *            Should this file be loaded in its default editor.
	 * @param targetFolder
	 *            The target folder to install the file to.
	 */
	public ExampleFile(String file, boolean showInDefaultEditor,
			String targetFolder) {
		this.file = file;
		this.showInDefaultEditor = showInDefaultEditor;
		this.targetFolder = targetFolder;
		this.url = null;
	}

	/**
	 * Constructing the example file with an locating url. The file is null.
	 * 
	 * @param url
	 *            The location of the file.
	 * @param showInDefaultEditor
	 *            Should this file be loaded in its default editor.
	 */
	public ExampleFile(URL url, boolean showInDefaultEditor) {
		this(url, showInDefaultEditor, null);
	}

	/**
	 * Constructing the example file with a name corresponding to the one in the
	 * package. The url is null.
	 * 
	 * @param file
	 *            Name of the file.
	 * @param showInDefaultEditor
	 *            Should this file be loaded in its default editor.
	 */
	public ExampleFile(String file, boolean showInDefaultEditor) {
		this(file, showInDefaultEditor, null);
	}

	/**
	 * Returns the url of the file if it's in a plugin.
	 * 
	 * @return Location of the file.
	 */
	public URL getURL() {
		return this.url;
	}

	/**
	 * Returns the name of the file if it's in an online package.
	 * 
	 * @return Name of the file.
	 */
	public String getFile() {
		return this.file;
	}

	/**
	 * Returns the folder, where this file should be installed to. {@code null}
	 * is root.
	 * 
	 * @return folder
	 */
	public String getTargetFolder() {
		return this.targetFolder;
	}

	/**
	 * Returns whether the file should be opened in its default editor or not.
	 * 
	 * @return
	 */
	public boolean isShowInDefaultEditor() {
		return showInDefaultEditor;
	}
}
