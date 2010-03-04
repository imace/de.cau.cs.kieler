package de.cau.cs.kieler.core.ui.examplewizard.datacollector;

import java.io.IOException;
import java.net.URL;
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
import de.cau.cs.kieler.core.ui.examplewizard.util.IExampleAction;

/**
 * The class extracts the example information from the online storage file.
 * 
 * @author omi
 */
public class ExampleOnlineDataRetriever implements IDataRetriever {

	/** URL for the container xml file. */
	private static final String URL = "http://www.rabe.bplaced.net/examplestore/plugin.xml";
	
//	private static final URL url = new URL(URL);
	
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
			URL url = new URL(URL);
			Document document = builder.parse(url.openStream());
			NodeList examples = document.getElementsByTagName("example");
			System.out.println(examples.getLength());
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
				String action = null;
				Node node = null;
				NamedNodeMap map = example.getAttributes();
				node = map.getNamedItem("id");
				if(node != null) {
					id = node.getNodeValue();
				}
				node = map.getNamedItem("name");
				if(node!= null) {
					name = node.getNodeValue();
				}
				node = map.getNamedItem("packagename");
				if(node!= null) {
					packageName = node.getNodeValue();
				}
				node = map.getNamedItem("pluginid");
				if(node!= null) {
					pluginID = node.getNodeValue();
				}
				node = map.getNamedItem("pluginversion");
				if(node!= null) {
					pluginVersion = node.getNodeValue();
				}
				node = map.getNamedItem("version");
				if(node!= null) {
					version = node.getNodeValue();
				}
				node = map.getNamedItem("description");
				if(node!= null) {
					description = node.getNodeValue();
				}
				node = map.getNamedItem("category");
				if(node!= null) {
					category = node.getNodeValue();
				}
				node = map.getNamedItem("action");
				if(node!= null) {
					action = node.getNodeValue();
				}

			}
					if (element.equals("file")) {
						NodeList list = element.getChildNodes();
						for (int k = 0; k < list.getLength(); k++) {
							Node node = list.item(k);
							String fileName = null;
							String target = null;
							Boolean showInEditor = null;
							if (node.equals("fileName")) {
								fileName = node.getNodeValue();
							}
							if (node.equals("folder")) {
								target = node.getNodeValue();
							}
							if (node.equals("showineditor")) {
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
					if (element.equals("category")) {
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

	/**
	 * (non-Javadoc)
	 * 
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
		for (Example example : this.examples) {
			String id = example.getPluginId();
			if (!ids.contains(id)) {
				ids.add(id);
			}
		}
		return ids;
	}
}
