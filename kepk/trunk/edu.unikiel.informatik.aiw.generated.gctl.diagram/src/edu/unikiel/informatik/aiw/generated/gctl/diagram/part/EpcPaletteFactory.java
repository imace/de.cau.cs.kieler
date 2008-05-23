package edu.unikiel.informatik.aiw.generated.gctl.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import edu.unikiel.informatik.aiw.generated.gctl.diagram.providers.EpcElementTypes;

/**
 * @generated
 */
public class EpcPaletteFactory {

	/**
	 * @generated NOT
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createGctl1Group());
		//changed by sja
		//paletteRoot.add(createMisreferencedtools2Group());
	}

	/**
	 * Creates "gctl" palette tool group
	 * @generated
	 */
	private PaletteContainer createGctl1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Gctl1Group_title);
		paletteContainer.add(createGCTLconnector1CreationTool());
		paletteContainer.add(createImplication2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "-- Mis-referenced tools --" palette tool group
	 * @generated
	 */
	private PaletteContainer createMisreferencedtools2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Misreferencedtools2Group_title);
		paletteContainer.setDescription(Messages.Misreferencedtools2Group_desc);
		paletteContainer.add(createFunction1CreationTool());
		paletteContainer.add(createEvent2CreationTool());
		paletteContainer.add(createInformation3CreationTool());
		paletteContainer.add(createEPC4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGCTLconnector1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.GCTLconnector_3001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.GCTLconnector1CreationTool_title,
				Messages.GCTLconnector1CreationTool_desc, types);
		entry
				.setSmallIcon(GctlDiagramEditorPlugin
						.findImageDescriptor("/edu.unikiel.informatik.aiw.epc.custom/icons/GCTLConnectorIcon.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImplication2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.Implication_1005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Implication2CreationTool_title,
				Messages.Implication2CreationTool_desc, types);
		entry
				.setSmallIcon(GctlDiagramEditorPlugin
						.findImageDescriptor("/edu.unikiel.informatik.aiw.epc.custom/icons/ImplicationIcon.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFunction1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.Function_1001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Function1CreationTool_title,
				Messages.Function1CreationTool_desc, types);
		entry.setSmallIcon(EpcElementTypes
				.getImageDescriptor(EpcElementTypes.Function_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEvent2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.Event_1002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Event2CreationTool_title,
				Messages.Event2CreationTool_desc, types);
		entry.setSmallIcon(EpcElementTypes
				.getImageDescriptor(EpcElementTypes.Event_1002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInformation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.Information_1003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Information3CreationTool_title,
				Messages.Information3CreationTool_desc, types);
		entry.setSmallIcon(EpcElementTypes
				.getImageDescriptor(EpcElementTypes.Information_1003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEPC4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.EPC_1004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EPC4CreationTool_title,
				Messages.EPC4CreationTool_desc, types);
		entry.setSmallIcon(EpcElementTypes
				.getImageDescriptor(EpcElementTypes.EPC_1004));
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
