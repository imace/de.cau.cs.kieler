package de.cau.cs.kieler.core.ui.examplewizard.datacollector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import de.cau.cs.kieler.core.ui.examplewizard.util.Example;
import de.cau.cs.kieler.core.ui.examplewizard.util.ExampleFile;
import de.cau.cs.kieler.core.ui.examplewizard.util.FTPCommunicator;

/**
 * The class extracts the example information from the online storage file.
 * 
 * @author omi
 */
public class ExampleOnlineDataRetriever implements IDataRetriever {

	/** Address of the storage */
	private static final String URL = "188.40.53.86";

	/** FTP login */
	private static final String LOGIN = "rabe_omi";

	/** FTP password */
	private static final String PASS = "Imu10iB";
	
	private static final String HTTPADDRESS = "http://www.rabe.bplaced.net/examplestore/";
	
	/** URL for the container xml file. */
	private static final String XML = "http://www.rabe.bplaced.net/examplestore/plugin.xml";

	/** Singleton instance of this class */
	public static final ExampleOnlineDataRetriever INSTANCE = new ExampleOnlineDataRetriever();

	/** list containing the online examples */
	private List<Example> examples;

	/** The XML-Document */
	private Document document;

	/** Document builder factory */
	private DocumentBuilderFactory factory;

	/** Document builder */
	private DocumentBuilder builder;

	/**
	 * Constructor.
	 */
	ExampleOnlineDataRetriever() {
		try {
			this.examples = new ArrayList<Example>();
			// URL
			URL url = new URL(XML);

			// Document
			this.factory = DocumentBuilderFactory.newInstance();
			this.builder = this.factory.newDocumentBuilder();
			this.document = this.builder.parse(url.openStream());

			// Example list from xml-file.
			NodeList examples = this.document.getElementsByTagName("example");
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
				List<ExampleFile> files = new ArrayList<ExampleFile>();
				// Example attributes
				NamedNodeMap exampleAttributesMap = example.getAttributes();
				Node exampleAttribute = null;
				exampleAttribute = exampleAttributesMap.getNamedItem("id");
				if (exampleAttribute != null) {
					id = exampleAttribute.getNodeValue();
				}
				exampleAttribute = exampleAttributesMap.getNamedItem("name");
				if (exampleAttribute != null) {
					name = exampleAttribute.getNodeValue();
				}
				exampleAttribute = exampleAttributesMap.getNamedItem("package");
				if (exampleAttribute != null) {
					packageName = exampleAttribute.getNodeValue();
				}
				exampleAttribute = exampleAttributesMap
						.getNamedItem("pluginid");
				if (exampleAttribute != null) {
					pluginID = exampleAttribute.getNodeValue();
				}
				exampleAttribute = exampleAttributesMap
						.getNamedItem("pluginversion");
				if (exampleAttribute != null) {
					pluginVersion = exampleAttribute.getNodeValue();
				}
				exampleAttribute = exampleAttributesMap.getNamedItem("version");
				if (exampleAttribute != null) {
					version = exampleAttribute.getNodeValue();
				}
				exampleAttribute = exampleAttributesMap
						.getNamedItem("description");
				if (exampleAttribute != null) {
					description = exampleAttribute.getNodeValue();
				}
				exampleAttribute = exampleAttributesMap
						.getNamedItem("category");
				if (exampleAttribute != null) {
					category = exampleAttribute.getNodeValue();
				}
				exampleAttribute = exampleAttributesMap.getNamedItem("action");
				if (exampleAttribute != null) {
					action = exampleAttribute.getNodeValue();
				}
				// file list
				NodeList children = example.getChildNodes();
				for (int j = 0; j < children.getLength(); j++) {
					String fileName = null;
					Boolean showInEditor = null;
					String target = null;
					Node child = children.item(j);
					if (child.getNodeName().equals("file")) {
						Node fileAttribute = null;
						NamedNodeMap fileAttributesMap = child.getAttributes();
						fileAttribute = fileAttributesMap.getNamedItem("name");
						if (fileAttribute != null) {
							fileName = fileAttribute.getNodeValue();
						}
						fileAttribute = fileAttributesMap
								.getNamedItem("folder");
						if (fileAttribute != null) {
							target = fileAttribute.getNodeValue();
						}
						fileAttribute = fileAttributesMap
								.getNamedItem("showineditor");
						if (fileAttribute != null) {
							showInEditor = Boolean
									.parseBoolean(exampleAttribute
											.getNodeValue());
						}
						// adding file to list
						if (fileName != null && showInEditor != null) {
							ExampleFile file = new ExampleFile(fileName,
									showInEditor, target);
							files.add(file);
						}
					}
				}
				// adding example to list
				if (id != null && name != null && version != null
						&& packageName != null && pluginID != null
						&& pluginVersion != null) {
					this.examples.add(new Example(id, name, version,
							packageName, pluginID, pluginVersion, description,
							category, files, null));
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		for (Example example : this.examples) {
			String id = example.getPluginId();
			if (!ids.contains(id)) {
				ids.add(id);
			}
		}
		return ids;
	}

	/**
	 * Removing the examples from the document and from Internet source.
	 * 
	 * @param examples
	 */
	public void remove(Object[] examples) {
		NodeList nodeList = this.document.getElementsByTagName("example");
		for (Object example : examples) {
			Example ex = (Example) example;
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				String id = node.getAttributes().getNamedItem("id")
						.getNodeValue();
				String version = node.getAttributes().getNamedItem("version")
						.getNodeValue();
				if (id.equals(ex.getId()) && version.equals(ex.getVersion())) {
					NodeList nodes = this.document
							.getElementsByTagName("extension");
					for (int j = 0; j < nodes.getLength(); j++) {
						Node extension = nodes.item(j);
						if (extension
								.getAttributes()
								.getNamedItem("point")
								.getNodeValue()
								.equals(
										"de.cau.cs.kieler.core.ui.examplewizard.examples")) {
							extension.removeChild(node);
						}
					}
				}
			}
			String packagefile = ex.getPackageName().substring(HTTPADDRESS.length());
			removeFile(packagefile); 
		}
		writeXmlFile(this.document, "plugin.xml");
	}
	
	public void add(Example example) {
		String[] filenames;
		Element element = document.createElement("example");
		element.setAttribute("name", example.getName());
		element.setAttribute("id", example.getId());
		element.setAttribute("version", example.getVersion());
		element.setAttribute("desrcription", example.getDescription());
		element.setAttribute("package", example.getPackageName());
		element.setAttribute("pluginid", example.getPluginId());
		element.setAttribute("pluginversion", example.getPluginVersion().toString());
		element.setAttribute("category", example.getCategory());
		element.setAttribute("action", "");
		// Add files to element
		List<ExampleFile> files = example.getFiles();
		filenames = new String[files.size()];
		for(int i = 0; i < files.size(); i++) { //ExampleFile file : files) {
			ExampleFile file = files.get(i);
			filenames[i] = file.getFile();
			Element fileElement = document.createElement("file");
			String[] fragmentedFile = file.getFile().replace('\\', '/').split("/");
			fileElement.setAttribute("name", fragmentedFile[fragmentedFile.length-1]);
			fileElement.setAttribute("folder", file.getTargetFolder());
			fileElement.setAttribute("showineditor", ((Boolean)file.isShowInDefaultEditor()).toString());
			element.appendChild(fileElement);
		}
		// Add element to extension tag
		NodeList nodes = this.document.getElementsByTagName("extension");
		for (int j = 0; j < nodes.getLength(); j++) {
			Node extension = nodes.item(j);
			if (extension.getAttributes().getNamedItem("point").getNodeValue().equals("de.cau.cs.kieler.core.ui.examplewizard.examples")) {
				extension.appendChild(element);
			}
		} // write xml file
		writeXmlFile(document, "plugin.xml");
		// build the package
		try {
			byte[] buf = new byte[1024];
			// Create the ZIP file
		    String outFilename = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + "/" + example.getPackageName();
		    File outfile = new File(outFilename);
		    System.out.println(outFilename);
		    ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outfile));
		    // Compress the files
		    for (int i=0; i<filenames.length; i++) {
		        FileInputStream in = new FileInputStream(filenames[i]);
		        // Add ZIP entry to output stream.
		        out.putNextEntry(new ZipEntry(filenames[i]));
		        // Transfer bytes from the file to the ZIP file
		        int len;
		        while ((len = in.read(buf)) > 0) {
		            out.write(buf, 0, len);
		        }
		        // Complete the entry
		        out.closeEntry();
		        in.close();
		    }
		    // Complete the ZIP file
		    out.close();
		    // send the file
		    FTPCommunicator.INSTANCE.sendFile(URL, LOGIN, PASS, "", outfile, example.getPackageName());
		    // remove the file
		    outfile.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write the document to the file.
	 * 
	 * @param doc
	 *            document containing the example information.
	 * @param filename
	 *            target file
	 */
	private void writeXmlFile(Document doc, String filename) {
		try {
			// Prepare the DOM document for writing
			Source source = new DOMSource(doc);
			
			// Prepare the output file
			IPath path = ResourcesPlugin.getWorkspace().getRoot().getLocation();
			File file = new File(path.toOSString() + "\\temp");
			Result result = new StreamResult(file);

			// Write the DOM document to the file
			Transformer xformer = TransformerFactory.newInstance()
					.newTransformer();
			xformer.transform(source, result);

			FTPCommunicator.INSTANCE.sendFile(URL, LOGIN, PASS, "", file, filename);
			
			file.delete();
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			// TODO
		} catch (TransformerException e) {
			e.printStackTrace();
			// TODO
		}
	}

	private void removeFile(String filename) {
		FTPCommunicator.INSTANCE.removeFile(URL, LOGIN, PASS, "", filename);
	}
}
