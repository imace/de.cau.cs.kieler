package de.cau.cs.kieler.kex.controller.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Version;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.KielerModelException;
import de.cau.cs.kieler.kex.controller.ExampleElement;
import de.cau.cs.kieler.kex.model.Example;
import de.cau.cs.kieler.kex.model.ExampleCollector;
import de.cau.cs.kieler.kex.model.ImportType;
import de.cau.cs.kieler.kex.model.extensionpoint.ExtPointExampleCreator;

public class ExampleExportUtil {

	/**
	 * mapping of properties onto an example.
	 * 
	 * @param properties
	 *            , Map<String, Object>
	 * @return Example
	 */
	public static Example mapToExample(Map<ExampleElement, Object> properties) {
		Example result = new Example(
				(String) properties.get(ExampleElement.ID),
				(String) properties.get(ExampleElement.NAME),
				Version.parseVersion((String) properties
						.get(ExampleElement.VERSION)),
				(ImportType) properties.get(ExampleElement.EXPORTTYPE));
		result.setDescription((String) properties
				.get(ExampleElement.DESCRIPTION));
		result.setContact((String) properties.get(ExampleElement.CONTACT));
		return result;
	}

	/**
	 * 
	 * @param example
	 * @throws KielerException
	 */
	public static void checkDuplicate(Example example,
			ExampleCollector... collectors) throws KielerException {
		if (example.getId() == null)
			throw new KielerException("ID of an example could not be null.");
		for (ExampleCollector collector : collectors) {
			if (collector.getExamplePool().containsKey(example.getId()))
				throw new KielerException(
						"Duplicate example id. Please choose an other one!");
		}
	}

	@SuppressWarnings("unchecked")
	public static void exportExample(
			final Map<ExampleElement, Object> properties,
			ExtPointExampleCreator extensionCreator,
			final ExampleCollector... collectors) throws KielerException {

		Example mappedExample = ExampleExportUtil.mapToExample(properties);
		ExampleExportUtil.checkDuplicate(mappedExample, collectors);

		String destLocation = (String) properties
				.get(ExampleElement.DEST_LOCATION);
		// TODO nullpointer check einbauen; �berall pr�fen, wenn ein File
		// erzeugt wird muss vorher ein nullcheck des strings erfolgen
		// ansonsten unerwartete exception...
		// muss schon vorher in der ui gepr�ft werden, sollte aber dennoch
		// hier
		// abgepr�ft werden.
		File destFile = new File(destLocation);
		if (!destFile.exists())
			throw new KielerException(
					"There is no file at destination location:" + destLocation);

		List<URL> resources = (List<URL>) properties
				.get(ExampleElement.RESOURCES);
		try {
			List<URL> destResources = copyResources(destFile, resources);
			mappedExample.addResources(destResources);
			extensionCreator.addExtension(destFile, mappedExample);
		} catch (KielerModelException e) {
			if (e.getModelObject() instanceof List<?>) {
				deleteExampleResource((List<URL>) e.getModelObject());
			}
			throw e;
		}
	}

	/**
	 * creates example files to given location
	 * 
	 * @param sourceProject
	 */
	private static List<URL> copyResources(File destFile, List<URL> resources)
			throws KielerException {
		List<URL> result = new ArrayList<URL>();
		for (URL relativeResource : resources) {
			result.add(copyFile(relativeResource, destFile.getPath()));
			// TODO muss das eine URL sein... geht da nicht auch ein
			// path, string oder file...
		}
		return result;
	}

	// TODO wenn der dialog resource anbietet zu dessen ordner es schon
	// TODO auch subdirs mit ansehen und hidden files ber�cksichtigen oder
	// nicht...
	// FIXME URLs ausbauen, das muss auch ohne gehen... logisch gesehen wird url
	// nur aus bundle.getResource() generiert
	// also nur beim Import, d.h. der export mechanismus k�nnte komplett ohne
	// urls laufen.

	private static URL copyFile(URL relativeResource, String destPath)
			throws KielerModelException {
		URL result = null;
		StringBuffer sb = new StringBuffer();
		try {
			Path resourcePath = (Path) Path.fromPortableString(relativeResource
					.getPath());

			sb.append(destPath).append(File.separatorChar)
					.append(resourcePath.removeFirstSegments(0));
			result = new URL("http", "localhost", sb.toString());
			Path workspacePath = (Path) ResourcesPlugin.getWorkspace()
					.getRoot().getLocation();

			String sourcePath = workspacePath.toPortableString()
					+ relativeResource.getPath();

			IOHandler.writeFile(new File(sourcePath), new File(sb.toString()));
		} catch (MalformedURLException e) {
			throw new KielerModelException("could not transform \" " + sb
					+ "\" to URL!", result);
		} catch (IOException e) {
			throw new KielerModelException("could not transform \" " + sb
					+ "\" to URL!", result);
		}
		return result;
	}

	private static void deleteExampleResource(List<URL> resources) {
		for (URL url : resources)
			IOHandler.deleteFile(new File(url.getPath()));
	}
}
