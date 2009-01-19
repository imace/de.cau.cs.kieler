package de.cau.cs.kieler.ssm.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import de.cau.cs.kieler.ssm.diagram.providers.SafeStateMachineElementTypes;


/**
 * @generated
 */
public class SafeStateMachinePaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createStates1Group());
		paletteRoot.add(createTransitions2Group());
	}

	/**
	 * Creates "States" palette tool group
	 * @generated
	 */
	private PaletteContainer createStates1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.States1Group_title);
		paletteContainer.add(createRegion1CreationTool());
		paletteContainer.add(createInitialState2CreationTool());
		paletteContainer.add(createCompositeState3CreationTool());
		paletteContainer.add(createSimpleState4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Transitions" palette tool group
	 * @generated
	 */
	private PaletteContainer createTransitions2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Transitions2Group_title);
		paletteContainer.add(createNormalTermination1CreationTool());
		paletteContainer.add(createStrongAbortion2CreationTool());
		paletteContainer.add(createWeakAbortion3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRegion1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SafeStateMachineElementTypes.Region_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Region1CreationTool_title,
				Messages.Region1CreationTool_desc, types);
		entry.setSmallIcon(SafeStateMachineElementTypes
				.getImageDescriptor(SafeStateMachineElementTypes.Region_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitialState2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SafeStateMachineElementTypes.InitialState_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InitialState2CreationTool_title,
				Messages.InitialState2CreationTool_desc, types);
		entry
				.setSmallIcon(SafeStateMachineElementTypes
						.getImageDescriptor(SafeStateMachineElementTypes.InitialState_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeState3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(SafeStateMachineElementTypes.CompositeState_2001);
		types.add(SafeStateMachineElementTypes.CompositeState_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CompositeState3CreationTool_title,
				Messages.CompositeState3CreationTool_desc, types);
		entry
				.setSmallIcon(SafeStateMachineElementTypes
						.getImageDescriptor(SafeStateMachineElementTypes.CompositeState_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSimpleState4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SafeStateMachineElementTypes.SimpleState_3003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SimpleState4CreationTool_title,
				Messages.SimpleState4CreationTool_desc, types);
		entry
				.setSmallIcon(SafeStateMachineElementTypes
						.getImageDescriptor(SafeStateMachineElementTypes.SimpleState_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNormalTermination1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SafeStateMachineElementTypes.NormalTermination_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.NormalTermination1CreationTool_title,
				Messages.NormalTermination1CreationTool_desc, types);
		entry
				.setSmallIcon(SafeStateMachineElementTypes
						.getImageDescriptor(SafeStateMachineElementTypes.NormalTermination_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStrongAbortion2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SafeStateMachineElementTypes.StrongAbortion_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.StrongAbortion2CreationTool_title,
				Messages.StrongAbortion2CreationTool_desc, types);
		entry
				.setSmallIcon(SafeStateMachineElementTypes
						.getImageDescriptor(SafeStateMachineElementTypes.StrongAbortion_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createWeakAbortion3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SafeStateMachineElementTypes.WeakAbortion_4003);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.WeakAbortion3CreationTool_title,
				Messages.WeakAbortion3CreationTool_desc, types);
		entry
				.setSmallIcon(SafeStateMachineElementTypes
						.getImageDescriptor(SafeStateMachineElementTypes.WeakAbortion_4003));
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
