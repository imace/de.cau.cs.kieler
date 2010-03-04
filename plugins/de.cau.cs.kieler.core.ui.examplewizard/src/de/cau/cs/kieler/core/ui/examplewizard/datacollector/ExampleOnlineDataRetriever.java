package de.cau.cs.kieler.core.ui.examplewizard.datacollector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import de.cau.cs.kieler.core.ui.examplewizard.util.Example;
import de.cau.cs.kieler.core.ui.examplewizard.util.ExampleFile;

/**
 * The class extracts the example information from the online storage file.
 * 
 * @author omi
 */
public class ExampleOnlineDataRetriever implements IDataRetriever{

	/** URL for the container xml file. */
	private static final String URL = "/resources/examplestore.xml";

	/** Singleton instance of this class */
	public static final ExampleOnlineDataRetriever INSTANCE = new ExampleOnlineDataRetriever();

	/** list containing the online examples */
	private List<Example> examples;

	/**
	 * Constructor.
	 */
	ExampleOnlineDataRetriever() {
		try {
			this.examples = new ArrayList<Example>();
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(URL));
			NodeList examples = document.getElementsByTagName("Example");
			for (int i = 0; i < examples.getLength(); i++) {
				Node example = examples.item(i);
				String id = null;
				String name = null;
				String packageName = null;
				String pluginID = null;
				String pluginVersion = null;
				String version = null;
				String description = null;
				String category = null;
				List<ExampleFile> files = new ArrayList<ExampleFile>();
				NodeList elements = example.getChildNodes();
				for (int j = 0; j < elements.getLength(); j++) {
					Node element = elements.item(j);

					if (element.equals("ID")) {
						id = element.getNodeValue();
					}
					if (element.equals("Name")) {
						name = element.getNodeValue();
					}
					if (element.equals("PackageName")) {
						packageName = element.getNodeValue();
					}
					if (element.equals("PluginID")) {
						pluginID = element.getNodeValue();
						NamedNodeMap attributes = element.getAttributes();
						pluginVersion = attributes.getNamedItem("Version")
								.getNodeValue();
					}
					if (element.equals("Version")) {
						version = element.getNodeValue();
					}
					if (element.equals("Description")) {
						description = element.getNodeValue();
					}
					if (element.equals("File")) {
						NodeList list = element.getChildNodes();
						for (int k = 0; k < list.getLength(); k++) {
							Node node = list.item(k);
							String fileName = null;
							String target = null;
							Boolean showInEditor = null;
							if (node.equals("FileName")) {
								fileName = node.getNodeValue();
							}
							if (node.equals("TargetFolder")) {
								target = node.getNodeValue();
							}
							if (node.equals("ShowInEditor")) {
								showInEditor = Boolean.parseBoolean(node
										.getNodeValue());
							}
							if (fileName != null && showInEditor != null) {
								ExampleFile file = new ExampleFile(fileName,
										showInEditor, target);
								files.add(file);
							}
						}
					}
					if (element.equals("Category")) {
						category = element.getNodeValue();
					}
				}
				if (id != null && name != null && version != null
						&& packageName != null && pluginID != null) {
					this.examples.add(new Example(id, name, version,
							packageName, pluginID, pluginVersion, description,
							category, files, null));
				}
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// extract Data
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** (non-Javadoc)
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
		for(Example temp:this.examples) {
			if(temp.getId().equals(id)) {
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
		for(Example example : this.examples) {
			ids.add(example.getId());
		}
		return ids;
	}

	/**
	 * @see de.cau.cs.kieler.core.ui.examplewizard.datacollector.IDataRetriever#getExamplesByPluginId(java.lang.String)
	 */
	public List<Example> getExamplesByPluginId(String pluginId) {
		List<Example> examples = new ArrayList<Example>();
		for(Example example : this.examples) {
			if(example.getPluginId().equals(pluginId)) {
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
