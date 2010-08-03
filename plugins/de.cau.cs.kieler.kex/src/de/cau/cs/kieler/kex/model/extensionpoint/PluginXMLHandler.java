package de.cau.cs.kieler.kex.model.extensionpoint;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.kex.model.Example;

/**
 * manages plugin.xml changes.
 * 
 * @author pkl
 */
class PluginXMLHandler {

	private Document parsedXML = null;
	private static final String PLUGIN_XML = "plugin.xml";

	private File filterPluginXML(final String location) {
		// TODO filter mechanismus bauen... abfangen falls mehrere gefunden
		// wurden... fehlermeldung zurueckgeben

		File pluginXML = new File(PLUGIN_XML);
		return pluginXML;

	}

	/**
	 * parses the given file.
	 * 
	 * @param file
	 *            , which will be parsed
	 * @return Document, parsed document
	 * @throws SAXException
	 *             , could be thrown by DOM framework
	 * @throws IOException
	 *             , could be thrown by DOM framework
	 * @throws ParserConfigurationException
	 *             , could be thrown by DOM framework
	 */
	private Document parserPluginXML(final File file) throws SAXException,
			IOException, ParserConfigurationException {
		return DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(file);
	}

	public void addExtension(String projectId, String location, Example example)
			throws KielerException {
		try {
			// FIXME mit projectId wird das nicht gehen, brauche externen
			// pfad...
			File file = filterPluginXML(location);
			parsedXML = parserPluginXML(file);
			// TODO think about a exampleName.meta for informations of example
			// instead of this example here.
			extendPluginXML(parsedXML, example);
			// TODO plugin.xml erweitern... mit geparstem file
		} catch (ParserConfigurationException e) {
			// TODO KexConstants einfuehren, d.h. eigene Klasse und diese
			// meldungen hier drin sammeln. (siehe visor constants)
			String msg = "Error appears while parsing plugin.xml of project: "
					+ projectId;
			throw new KielerException(msg, e);
		} catch (SAXException e) {
			String msg = "Error appears while parsing plugin.xml of project: "
					+ projectId;
			throw new KielerException(msg, e);
		} catch (IOException e) {
			String msg = "Error appears while parsing plugin.xml of project: "
					+ projectId;
			throw new KielerException(msg, e);
		}
	}

	private void extendPluginXML(Document pluginXML, final Example example) {
		// parsedXML nun nutzen und aufloesen...
		// TODO Beispiel f�r doc zugriff nun erweitern...
		// NodeList nl = node.getChildNodes();
		//
		// for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
		// System.out.println("[" + nl.item(i) + "]");
		//
		// visit(nl.item(i), level + 1);
		// }
	}

}
