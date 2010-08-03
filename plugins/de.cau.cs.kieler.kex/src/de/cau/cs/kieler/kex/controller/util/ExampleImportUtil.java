package de.cau.cs.kieler.kex.controller.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.kex.model.Example;
import de.cau.cs.kieler.kex.model.ExampleResource;

public class ExampleImportUtil {

	public static void importExamples(IPath selectedResource,
			List<Example> selectedExamples) throws KielerException {
		for (Example example : selectedExamples) {

			List<ExampleResource> resources = example.getResources();
			// TODO pr�fen, ob parameter sinnvoll...
			// wenn mehrere examples mit gleichem namen laufen, brauchen wir
			// eine art index
			// bzw. den identifierer... als datei oder in project properties
			// oder im namen
			// src/Hankees.txt
			String localWorkspaceLocation = Platform.getLocation().toString();
			String destFolder = localWorkspaceLocation
					+ selectedResource.toString() + "/" + example.getName()
					+ "/";
			createFolder(destFolder);

			Bundle bundle = Platform.getBundle(example.getNamespaceId());

			for (ExampleResource exampleResource : resources) {
				for (URL resource : exampleResource.getResources()) {
					try {
						String path = resource.getPath();

						// searching for subfiles and folders.
						Enumeration<?> dict = bundle.findEntries(path, null,
								false);
						// TODO filter for .svn and .cvs files have to be added
						// properly you can set this to bundle.findEntries()...
						// adding subs

						// TODO hier ansetzen
						if (dict != null) {
							createFolder(destFolder);
						} else {
							String[] resourceSplits = path.split("/");
							writeFile(
									resource,
									destFolder
											+ resourceSplits[resourceSplits.length - 1],
									true);
						}
					} catch (FileNotFoundException e) {
						throw new KielerException("Can't import example!", e);
					} catch (IOException e1) {
						throw new KielerException("Can't import example!", e1);
					}
				}
			}
		}

	}

	/**
	 * 
	 * @param sourceUrl
	 *            , source url
	 * @param destFile
	 *            , destination file
	 * @param overwrite
	 *            , boolean
	 * @throws KielerException
	 * @throws IOException
	 */
	private static void writeFile(final URL sourceUrl, final String destFile,
			final boolean overwrite) throws IOException {
		File f2 = new File(destFile);
		// update test...
		if (f2.exists() && !overwrite) {
			return;
		}

		InputStream is = sourceUrl.openStream();
		OutputStream os = new FileOutputStream(f2, overwrite);
		byte[] buf = new byte[1024];
		int len;
		while ((len = is.read(buf)) > 0) {
			os.write(buf, 0, len);
		}

		is.close();
		os.close();
	}

	/**
	 * creates a folder with given parameter.
	 * 
	 * @param destFolder
	 *            , pathname of destination folder.
	 */
	private static void createFolder(final String destFolder) {
		(new File(destFolder)).mkdir();
	}

}
