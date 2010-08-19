package de.cau.cs.kieler.kex.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.kex.controller.util.ExampleExportUtil;
import de.cau.cs.kieler.kex.controller.util.ExampleImportUtil;
import de.cau.cs.kieler.kex.model.Example;
import de.cau.cs.kieler.kex.model.SourceType;
import de.cau.cs.kieler.kex.model.database.DBExampleCollector;
import de.cau.cs.kieler.kex.model.extensionpoint.ExtPointExampleCollector;
import de.cau.cs.kieler.kex.model.extensionpoint.ExtPointExampleCreator;

public class ExampleManager {

	private static ExampleManager instance;

	private boolean isLoaded;

	private final ExtPointExampleCollector extensionCollector;
	private final DBExampleCollector databaseCollector;

	private final ExtPointExampleCreator extensionCreator;

	// in bachelor arbeit eine einfuehrung ueber kieler geben;
	// wie ein zitat/ witz der vorweg kommt.
	// siehe projekt seite

	// TODO wenn in ui ein editor offen ist, dann macht er den wizard nicht auf.

	// TODO Thesis, begr�nden weshalb hier instance genommen wurde.
	// da wir den Examplepool nicht jedes mal erneut laden wollen, wenn
	// wir darauf zugreifen wollen, k�nnen unter anderem viele werden.

	// TODO category refactoring, das wird so alles nicht mehr gebraucht...
	// da wir die kategorien aus den examples filtern.

	private ExampleManager() {
		this.extensionCollector = new ExtPointExampleCollector();
		this.extensionCreator = new ExtPointExampleCreator();
		this.databaseCollector = new DBExampleCollector();
	}

	public synchronized static ExampleManager get() {
		if (instance == null)
			instance = new ExampleManager();
		return instance;
	}

	/**
	 * loads examples, if not loaded before.
	 */
	public void load(boolean forceLoad) {
		if (!this.isLoaded || forceLoad) {
			loadExamples();
			// after completely loaded
			this.isLoaded = true;
		}
	}

	private void loadExamples() {
		this.extensionCollector.loadExamples();
		this.databaseCollector.loadExamples();
	}

	public Map<String, Example> getExamples() {
		Map<String, Example> result = this.extensionCollector.getExamplePool();
		result.putAll(databaseCollector.getExamplePool());
		return result;
	}

	public List<String> getCategories() {
		List<String> result = new ArrayList<String>();
		result.addAll(databaseCollector.getCategories());
		result.addAll(extensionCollector.getCategories());
		return result;
	}

	public void importExamples(IPath selectedResource,
			List<Example> selectedExamples) throws KielerException {
		ExampleImportUtil.importExamples(selectedResource, selectedExamples);
	}

	public void exportExample(Map<ExampleElement, Object> properties)
			throws KielerException {
		// TODO validate von ui zu service verlegen.
		if (SourceType.KIELER.equals(properties.get(ExampleElement.SOURCETYPE)))
			ExampleExportUtil.exportExample(properties, this.extensionCreator,
					this.extensionCollector, this.databaseCollector);
		else if (SourceType.PUBLIC.equals(properties
				.get(ExampleElement.SOURCETYPE))) {
			// TODO online schnittstelle bauen...
		} else
			throw new KielerException("No ExportType was set.");
	}

}
