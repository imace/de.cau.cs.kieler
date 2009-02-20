package ssm.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import ssm.diagram.providers.SsmElementTypes;

/**
 * @generated
 */
public class SsmPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createToolGroup1Group());
	}

	/**
	 * Creates "ToolGroup" palette tool group
	 * @generated
	 */
	private PaletteContainer createToolGroup1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.ToolGroup1Group_title);
		paletteContainer.add(createStateCreationTool1CreationTool());
		paletteContainer.add(createTransitionCreationTool2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStateCreationTool1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(SsmElementTypes.State_2002);
		types.add(SsmElementTypes.State_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StateCreationTool1CreationTool_title, null, types);
		entry.setSmallIcon(SsmElementTypes
				.getImageDescriptor(SsmElementTypes.State_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransitionCreationTool2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SsmElementTypes.Transition_4006);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.TransitionCreationTool2CreationTool_title,
				Messages.TransitionCreationTool2CreationTool_desc, types);
		entry.setSmallIcon(SsmElementTypes
				.getImageDescriptor(SsmElementTypes.Transition_4006));
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
