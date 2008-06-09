package hierarchymealy.diagram.part;

import hierarchymealy.diagram.providers.MealyMachineElementTypes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class MealyMachinePaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createMealy1Group());
	}

	/**
	 * Creates "mealy" palette tool group
	 * @generated
	 */
	private PaletteContainer createMealy1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Mealy1Group_title);
		paletteContainer.add(createState1CreationTool());
		paletteContainer.add(createCompositeState2CreationTool());
		paletteContainer.add(createEdge3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createState1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(MealyMachineElementTypes.State_2001);
		types.add(MealyMachineElementTypes.State_1002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.State1CreationTool_title,
				Messages.State1CreationTool_desc, types);
		entry.setSmallIcon(MealyMachineElementTypes
				.getImageDescriptor(MealyMachineElementTypes.State_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeState2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(MealyMachineElementTypes.CompositeState_1001);
		types.add(MealyMachineElementTypes.CompositeState_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CompositeState2CreationTool_title,
				Messages.CompositeState2CreationTool_desc, types);
		entry
				.setSmallIcon(MealyMachineElementTypes
						.getImageDescriptor(MealyMachineElementTypes.CompositeState_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEdge3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MealyMachineElementTypes.Edge_3001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Edge3CreationTool_title,
				Messages.Edge3CreationTool_desc, types);
		entry.setSmallIcon(MealyMachineElementTypes
				.getImageDescriptor(MealyMachineElementTypes.Edge_3001));
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
