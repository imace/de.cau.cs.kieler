package de.cau.cs.kieler.kex.controller.util;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.osgi.framework.Version;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.KielerModelException;
import de.cau.cs.kieler.kex.controller.ExampleElement;
import de.cau.cs.kieler.kex.model.Example;
import de.cau.cs.kieler.kex.model.ExampleCollector;
import de.cau.cs.kieler.kex.model.ExportResource;
import de.cau.cs.kieler.kex.model.SourceType;
import de.cau.cs.kieler.kex.model.extensionpoint.ExtPointExampleCreator;

public class ExampleExportUtil {

	/**
	 * mapping of properties onto an example.
	 * 
	 * @param properties
	 *            , Map<String, Object>
	 * @param rootResource
	 * @return Example
	 */
	@SuppressWarnings("unchecked")
	public static Example mapToExample(Map<ExampleElement, Object> properties,
			String rootResource) {
		Example result = new Example(
				(String) properties.get(ExampleElement.ID), (String) properties
						.get(ExampleElement.NAME), Version
						.parseVersion((String) properties
								.get(ExampleElement.VERSION)),
				(SourceType) properties.get(ExampleElement.SOURCETYPE));
		result.setDescription((String) properties
				.get(ExampleElement.DESCRIPTION));
		result.setContact((String) properties.get(ExampleElement.CONTACT));
		result.setCategories((List<String>) properties
				.get(ExampleElement.CATEGORIES));
		result.setRootResource(rootResource);
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
	public static void export(final Map<ExampleElement, Object> properties,
			ExtPointExampleCreator extensionCreator,
			final ExampleCollector... collectors) throws KielerException {

		Example mappedExample = ExampleExportUtil.mapToExample(properties,
				(String) properties.get(ExampleElement.DEST_LOCATION));
		ExampleExportUtil.checkDuplicate(mappedExample, collectors);

		File destFile = new File(mappedExample.getRootResource());
		// TODO that has to be made updatable.
		if (!destFile.exists())
			throw new KielerException(
					"There is no file at destination location:"
							+ mappedExample.getRootResource());

		List<ExportResource> resources = (List<ExportResource>) properties
				.get(ExampleElement.RESOURCES);
		boolean createExampleFolder = (Boolean) properties
				.get(ExampleElement.CREATE_EXAMPLE_FOLDER);
		List<IPath> destResources = extensionCreator
				.copyResources(destFile, resources,
						(createExampleFolder ? mappedExample.getId() : null));
		try {
			extensionCreator.addExtension(destFile, mappedExample,
					destResources, properties
							.get(ExampleElement.CREATE_CATEGORIES), properties
							.get(ExampleElement.DELETE_CATEGORIES));
		} catch (KielerModelException e) {
			if (e.getModelObject() instanceof List<?>) {
				extensionCreator.deleteExampleResource((List<IPath>) e
						.getModelObject());
			}
			throw e;
		}
	}
}
