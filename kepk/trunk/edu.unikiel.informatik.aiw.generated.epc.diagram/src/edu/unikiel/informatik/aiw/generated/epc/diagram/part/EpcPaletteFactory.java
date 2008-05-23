package edu.unikiel.informatik.aiw.generated.epc.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import edu.unikiel.informatik.aiw.generated.epc.diagram.providers.EpcElementTypes;

/**
 * @generated
 */
public class EpcPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createEpc1Group());
	}

	/**
	 * Creates "epc" palette tool group
	 * @generated
	 */
	private PaletteContainer createEpc1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Epc1Group_title);
		paletteContainer.add(createEPC1CreationTool());
		paletteContainer.add(createEvent2CreationTool());
		paletteContainer.add(createFunction3CreationTool());
		paletteContainer.add(createXOR4CreationTool());
		paletteContainer.add(createOR5CreationTool());
		paletteContainer.add(createAND6CreationTool());
		paletteContainer.add(createInformation7CreationTool());
		paletteContainer.add(createConnection8CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEPC1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.EPC_1006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EPC1CreationTool_title,
				Messages.EPC1CreationTool_desc, types);
		entry.setSmallIcon(EpcElementTypes
				.getImageDescriptor(EpcElementTypes.EPC_1006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEvent2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.Event_1005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Event2CreationTool_title,
				Messages.Event2CreationTool_desc, types);
		entry.setSmallIcon(EpcElementTypes
				.getImageDescriptor(EpcElementTypes.Event_1005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFunction3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.Function_1007);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Function3CreationTool_title,
				Messages.Function3CreationTool_desc, types);
		entry
				.setSmallIcon(EpcDiagramEditorPlugin
						.findImageDescriptor("/edu.unikiel.informatik.aiw.epc.custom/icons/FunctionIcon.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createXOR4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.XOR_1004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.XOR4CreationTool_title,
				Messages.XOR4CreationTool_desc, types);
		entry
				.setSmallIcon(EpcDiagramEditorPlugin
						.findImageDescriptor("/edu.unikiel.informatik.aiw.epc.custom/icons/XORIcon.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOR5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.OR_1002);
		NodeToolEntry entry = new NodeToolEntry(Messages.OR5CreationTool_title,
				Messages.OR5CreationTool_desc, types);
		entry
				.setSmallIcon(EpcDiagramEditorPlugin
						.findImageDescriptor("/edu.unikiel.informatik.aiw.epc.custom/icons/ORIcon.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAND6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.AND_1001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.AND6CreationTool_title,
				Messages.AND6CreationTool_desc, types);
		entry
				.setSmallIcon(EpcDiagramEditorPlugin
						.findImageDescriptor("/edu.unikiel.informatik.aiw.epc.custom/icons/ANDIcon.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInformation7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EpcElementTypes.Information_1003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Information7CreationTool_title,
				Messages.Information7CreationTool_desc, types);
		entry
				.setSmallIcon(EpcDiagramEditorPlugin
						.findImageDescriptor("/edu.unikiel.informatik.aiw.epc.custom/icons/InformationIcon.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnection8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(8);
		types.add(EpcElementTypes.TriggersEvent_3001);
		types.add(EpcElementTypes.ProvidesDataTo_3002);
		types.add(EpcElementTypes.WritesDataTo_3003);
		types.add(EpcElementTypes.ActivatesFunction_3004);
		types.add(EpcElementTypes.EventToOperatorConnection_3005);
		types.add(EpcElementTypes.FunctionToOperatorConnection_3006);
		types.add(EpcElementTypes.OperatorToEventConnection_3007);
		types.add(EpcElementTypes.OperatorToFunctionConnection_3008);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Connection8CreationTool_title,
				Messages.Connection8CreationTool_desc, types);
		entry
				.setSmallIcon(EpcDiagramEditorPlugin
						.findImageDescriptor("/edu.unikiel.informatik.aiw.epc.custom/icons/ConnectionIcon.png")); //$NON-NLS-1$
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
