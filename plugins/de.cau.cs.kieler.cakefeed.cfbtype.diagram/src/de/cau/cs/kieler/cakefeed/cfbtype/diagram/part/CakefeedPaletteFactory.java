package de.cau.cs.kieler.cakefeed.cfbtype.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class CakefeedPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createCFBTypeToolGroup1Group());
	}

	/**
	 * Creates "CFBTypeToolGroup" palette tool group
	 * @generated
	 */
	private PaletteContainer createCFBTypeToolGroup1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.CFBTypeToolGroup1Group_title);
		paletteContainer.setId("createCFBTypeToolGroup1Group"); //$NON-NLS-1$
		paletteContainer.add(createCFBType1CreationTool());
		paletteContainer.add(createInterface2Group());
		paletteContainer.add(createCompositeNetwork3Group());
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
	 * Creates "Composite Network" palette tool group
	 * @generated
	 */
	private PaletteContainer createCompositeNetwork3Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.CompositeNetwork3Group_title);
		paletteContainer.setId("createCompositeNetwork3Group"); //$NON-NLS-1$
		paletteContainer.add(createFB1CreationTool());
		paletteContainer.add(createConnection2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCFBType1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(CakefeedElementTypes.CFBType_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CFBType1CreationTool_title, null, types);
		entry.setId("createCFBType1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CakefeedElementTypes
				.getImageDescriptor(CakefeedElementTypes.CFBType_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEvent1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(CakefeedElementTypes.IFInputEvent_3012);
		types.add(CakefeedElementTypes.IFOutputEvent_3013);
		types.add(CakefeedElementTypes.FBInputEvent_3017);
		types.add(CakefeedElementTypes.FBOutputEvent_3018);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Event1CreationTool_title, null, types);
		entry.setId("createEvent1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CakefeedElementTypes
				.getImageDescriptor(CakefeedElementTypes.IFInputEvent_3012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariable2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(CakefeedElementTypes.IFInputVar_3014);
		types.add(CakefeedElementTypes.IFOutputVar_3015);
		types.add(CakefeedElementTypes.FBInputVar_3019);
		types.add(CakefeedElementTypes.FBOutputVar_3020);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Variable2CreationTool_title, null, types);
		entry.setId("createVariable2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CakefeedElementTypes
				.getImageDescriptor(CakefeedElementTypes.IFInputVar_3014));
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
	private ToolEntry createFB1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(CakefeedElementTypes.FB_3016);
		NodeToolEntry entry = new NodeToolEntry(Messages.FB1CreationTool_title,
				null, types);
		entry.setId("createFB1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CakefeedElementTypes
				.getImageDescriptor(CakefeedElementTypes.FB_3016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnection2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(8);
		types.add(CakefeedElementTypes.IFIFEventConnection_4007);
		types.add(CakefeedElementTypes.IFFBEventConnection_4008);
		types.add(CakefeedElementTypes.FBIFEventConnection_4009);
		types.add(CakefeedElementTypes.FBFBEventConnection_4010);
		types.add(CakefeedElementTypes.IFIFDataConnection_4011);
		types.add(CakefeedElementTypes.IFFBDataConnection_4012);
		types.add(CakefeedElementTypes.FBIFDataConnection_4013);
		types.add(CakefeedElementTypes.FBFBDataConnection_4014);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Connection2CreationTool_title, null, types);
		entry.setId("createConnection2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(CakefeedElementTypes
						.getImageDescriptor(CakefeedElementTypes.IFIFEventConnection_4007));
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
