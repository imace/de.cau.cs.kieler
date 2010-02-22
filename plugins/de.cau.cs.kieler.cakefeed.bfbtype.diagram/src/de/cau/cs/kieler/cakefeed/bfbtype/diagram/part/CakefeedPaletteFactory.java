package de.cau.cs.kieler.cakefeed.bfbtype.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class CakefeedPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createBFBTypeToolGroup1Group());
	}

	/**
	 * Creates "BFBTypeToolGroup" palette tool group
	 * @generated
	 */
	private PaletteContainer createBFBTypeToolGroup1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.BFBTypeToolGroup1Group_title);
		paletteContainer.setId("createBFBTypeToolGroup1Group"); //$NON-NLS-1$
		paletteContainer.add(createBFBType1CreationTool());
		paletteContainer.add(createInterface2Group());
		paletteContainer.add(createBasicFunctionBlock3Group());
		return paletteContainer;
	}

	/**
	 * Creates "Interface" palette tool group
	 * @generated
	 */
	private PaletteContainer createInterface2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Interface2Group_title);
		paletteContainer.setId("createInterface2Group"); //$NON-NLS-1$
		paletteContainer.add(createEvent1CreationTool());
		paletteContainer.add(createVariable2CreationTool());
		paletteContainer.add(createWith3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Basic Function Block" palette tool group
	 * @generated
	 */
	private PaletteContainer createBasicFunctionBlock3Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.BasicFunctionBlock3Group_title);
		paletteContainer.setId("createBasicFunctionBlock3Group"); //$NON-NLS-1$
		paletteContainer.add(createAlgorithm1CreationTool());
		paletteContainer.add(createFB2CreationTool());
		paletteContainer.add(createDataConnection3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBFBType1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(CakefeedElementTypes.BFBType_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.BFBType1CreationTool_title, null, types);
		entry.setId("createBFBType1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CakefeedElementTypes
				.getImageDescriptor(CakefeedElementTypes.BFBType_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEvent1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(CakefeedElementTypes.IFInputEvent_3024);
		types.add(CakefeedElementTypes.IFOutputEvent_3025);
		types.add(CakefeedElementTypes.FBInputEvent_3031);
		types.add(CakefeedElementTypes.FBOutputEvent_3032);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Event1CreationTool_title, null, types);
		entry.setId("createEvent1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CakefeedElementTypes
				.getImageDescriptor(CakefeedElementTypes.IFInputEvent_3024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariable2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(5);
		types.add(CakefeedElementTypes.IFInputVar_3026);
		types.add(CakefeedElementTypes.IFOutputVar_3027);
		types.add(CakefeedElementTypes.InternalVar_3028);
		types.add(CakefeedElementTypes.FBInputVar_3033);
		types.add(CakefeedElementTypes.FBOutputVar_3034);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Variable2CreationTool_title, null, types);
		entry.setId("createVariable2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CakefeedElementTypes
				.getImageDescriptor(CakefeedElementTypes.IFInputVar_3026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createWith3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(CakefeedElementTypes.InputWith_4001);
		types.add(CakefeedElementTypes.OutputWith_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.With3CreationTool_title, null, types);
		entry.setId("createWith3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CakefeedElementTypes
				.getImageDescriptor(CakefeedElementTypes.InputWith_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAlgorithm1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(CakefeedElementTypes.FBD_3029);
		types.add(CakefeedElementTypes.ST_3035);
		types.add(CakefeedElementTypes.LD_3036);
		types.add(CakefeedElementTypes.Other_3037);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Algorithm1CreationTool_title, null, types);
		entry.setId("createAlgorithm1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CakefeedElementTypes
				.getImageDescriptor(CakefeedElementTypes.FBD_3029));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFB2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(CakefeedElementTypes.FB_3030);
		NodeToolEntry entry = new NodeToolEntry(Messages.FB2CreationTool_title,
				null, types);
		entry.setId("createFB2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CakefeedElementTypes
				.getImageDescriptor(CakefeedElementTypes.FB_3030));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataConnection3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(CakefeedElementTypes.FBFBDataConnection_4005);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.DataConnection3CreationTool_title, null, types);
		entry.setId("createDataConnection3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(CakefeedElementTypes
						.getImageDescriptor(CakefeedElementTypes.FBFBDataConnection_4005));
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
