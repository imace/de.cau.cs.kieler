package de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class CakefeedPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createFBNetworkToolGroup1Group());
	}

	/**
	 * Creates "FBNetworkToolGroup" palette tool group
	 * @generated
	 */
	private PaletteContainer createFBNetworkToolGroup1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.FBNetworkToolGroup1Group_title);
		paletteContainer.setId("createFBNetworkToolGroup1Group"); //$NON-NLS-1$
		paletteContainer.add(createFB1CreationTool());
		paletteContainer.add(createConnection2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFB1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(CakefeedElementTypes.FB_2001);
		NodeToolEntry entry = new NodeToolEntry(Messages.FB1CreationTool_title,
				null, types);
		entry.setId("createFB1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CakefeedElementTypes
				.getImageDescriptor(CakefeedElementTypes.FB_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnection2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(CakefeedElementTypes.FBFBEventConnection_4001);
		types.add(CakefeedElementTypes.FBFBDataConnection_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Connection2CreationTool_title, null, types);
		entry.setId("createConnection2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(CakefeedElementTypes
						.getImageDescriptor(CakefeedElementTypes.FBFBEventConnection_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
