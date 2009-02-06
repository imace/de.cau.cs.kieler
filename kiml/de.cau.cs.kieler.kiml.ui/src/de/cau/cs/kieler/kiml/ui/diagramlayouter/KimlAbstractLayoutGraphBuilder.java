/*******************************************************************************
 * Copyright (c) 2009 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.ui.diagramlayouter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.jface.viewers.IStructuredSelection;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.kiml.ui.provider.KimlAdapterFactoryLabelProvider;

/**
 * The abstract base class for all LayoutGraphBuilders. <br/>
 * Implementing classes must extend <code>doBuildLayoutGraph</code> which uses
 * the information of the diagram to build up a KLayoutGraph,
 * <code>resetCustomMaps</code> to reset implementation dependent mappings of
 * elements, and <code>updatePreferences</code> to set preferences used during
 * the building step. <br/>
 * The final method <code>buildLayoutGraph</code> is responsible for the correct
 * collaboration of the single steps, and for the correct passing of the
 * information to the {@link KimlLayoutInformation} structure. <br/>
 * The implementation of <code>doBuildLayoutGraph</code> must use the globally
 * defined maps for the mapping of KLayoutGraph elements to EditParts, the
 * <code>layoutGraph</code> and the <code>layoutRootPart</code>.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * 
 */
public abstract class KimlAbstractLayoutGraphBuilder {

	/*
	 * some strings used when creating the concrete layout graph builders via
	 * the extension point mechanism
	 */
	public static final String EXTENSION_POINT_ID = "de.cau.cs.kieler.kiml.ui.kimlLayoutGraphBuilder";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_EDITOR_ID = "editor_id";
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_ICON = "icon";

	/* the mappings of KLayoutGraph LAYOUT elements to EditParts */
	protected Map<KLayoutNode, GraphicalEditPart> layoutNode2EditPart = new HashMap<KLayoutNode, GraphicalEditPart>();
	protected Map<KLayoutEdge, ConnectionEditPart> layoutEdge2EditPart = new HashMap<KLayoutEdge, ConnectionEditPart>();
	protected Map<KLayoutPort, GraphicalEditPart> layoutPort2EditPart = new HashMap<KLayoutPort, GraphicalEditPart>();

	/* the mappings of KLayoutGraph LABEL elements to LabelEditParts */
	protected Map<KNodeLabel, LabelEditPart> nodeLabel2EditPart = new HashMap<KNodeLabel, LabelEditPart>();
	protected Map<KEdgeLabel, LabelEditPart> edgeLabel2EditPart = new HashMap<KEdgeLabel, LabelEditPart>();
	protected Map<KPortLabel, LabelEditPart> portLabel2EditPart = new HashMap<KPortLabel, LabelEditPart>();

	/*
	 * the layoutRootPart where the layout should start with and an instance of
	 * the layout graph
	 */
	protected GraphicalEditPart layoutRootPart;
	protected KLayoutGraph layoutGraph;

	/*
	 * can be used during the building of the KLayoutGraph to obtain nicer
	 * labels than with the standard label functions
	 */
	protected KimlAdapterFactoryLabelProvider kimlAdapterLabelProvider = new KimlAdapterFactoryLabelProvider(
			new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	/**
	 * Implementation must reset implementation dependent mappings of elements.
	 */
	protected abstract void resetCustomMaps();

	/**
	 * Implementation should fetch preference settings needed during the
	 * doApplyLayout step.
	 */
	protected abstract void updatePreferences();

	/**
	 * Implementation should build a KLayoutGraph from the information of the
	 * diagram. <br/>
	 * The globally defined maps for the mapping of KLayoutGraph elements to
	 * EditParts, the <code>layoutGraph</code> and the
	 * <code>layoutRootPart</code> must be used. <br/>
	 */
	protected abstract void doBuildLayoutGraph();

	/**
	 * Is responsible for the correct collaboration of the single steps, and for
	 * the correct passing of the information to the
	 * {@link KimlLayoutInformation} class.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @return The KimlLayoutInformation structure with the KLayoutGraph, the
	 *         layoutRootPart and the mapping of EditParts to the KLayoutGraph
	 */
	protected final KimlLayoutInformation buildLayoutGraph(Object target) {

		updatePreferences();
		resetCustomMaps();

		layoutNode2EditPart.clear();
		layoutEdge2EditPart.clear();
		layoutPort2EditPart.clear();
		nodeLabel2EditPart.clear();
		edgeLabel2EditPart.clear();
		portLabel2EditPart.clear();
		layoutRootPart = getLayoutRootPart(target);
		layoutGraph = KimlLayoutUtil.createInitializedLayoutGraph();

		doBuildLayoutGraph();

		KimlLayoutInformation layoutInformation = new KimlLayoutInformation();
		layoutInformation.layoutNode2EditPart = layoutNode2EditPart;
		layoutInformation.layoutEdge2EditPart = layoutEdge2EditPart;
		layoutInformation.layoutPort2EditPart = layoutPort2EditPart;
		layoutInformation.nodeLabel2EditPart = nodeLabel2EditPart;
		layoutInformation.edgeLabel2EditPart = edgeLabel2EditPart;
		layoutInformation.portLabel2EditPart = portLabel2EditPart;
		layoutInformation.layoutRootPart = layoutRootPart;
		layoutInformation.layoutGraph = layoutGraph;

		return layoutInformation;
	}

	/**
	 * Overrideable function to obtain the layoutRootPart with which the layout
	 * process should start out of the provided object, which is typically an
	 * IEditorPart or a StructuredSelection.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @return A GraphicalEditPart with which the layout should start
	 */
	protected GraphicalEditPart getLayoutRootPart(Object target) {
		GraphicalEditPart root = null;

		// no matter how much was selected, get the first element
		if (target instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) target;

			Object selectedObject = selection.getFirstElement();
			// if just one element was selected, use this, if NodeEditPart
			if (selection.size() == 1) {
				if (selectedObject instanceof NodeEditPart) {
					root = (NodeEditPart) selectedObject;
				} else if (selectedObject instanceof DiagramEditPart) {
					root = (GraphicalEditPart) ((DiagramEditPart) selectedObject)
							.getChildren().get(0);
				} else if (selectedObject instanceof CompartmentEditPart) {
					root = (GraphicalEditPart) ((CompartmentEditPart) selectedObject)
							.getParent();
				}
			}
			// more selected, find parent thereof
			else {
				root = findParentNode(selectedObject);
			}

		}

		if (target instanceof DiagramGraphicalViewer) {
			DiagramGraphicalViewer viewer = (DiagramGraphicalViewer) target;
			root = (GraphicalEditPart) viewer.getRootEditPart().getChildren()
					.get(0);
		}
		if (target instanceof DiagramEditor) {
			DiagramEditor editor = (DiagramEditor) target;
			root = (GraphicalEditPart) editor.getDiagramEditPart()
					.getChildren().get(0);
		}
		if (target instanceof DiagramEditPart) {
			DiagramEditPart dep = (DiagramEditPart) target;
			root = (GraphicalEditPart) dep.getChildren().get(0);
		}
		if (target instanceof GraphicalEditPart) {
			root = (GraphicalEditPart) root;
		}

		return root;
	}

	/*
	 * Recursive helper function to get a GraphicalEditPart parent for an
	 * object.
	 */
	private GraphicalEditPart findParentNode(Object current) {
		if (current instanceof GraphicalEditPart) {
			GraphicalEditPart aep = (GraphicalEditPart) current;
			if (aep.getParent() instanceof NodeEditPart)
				return (NodeEditPart) aep.getParent();
			else {
				GraphicalEditPart parent = findParentNode(aep.getParent());
				if (parent == null) {
					DiagramGraphicalViewer viewer = (DiagramGraphicalViewer) aep
							.getViewer();
					return (GraphicalEditPart) viewer.getRootEditPart()
							.getChildren().get(0);
				} else
					return parent;
			}
		} else
			return null;
	}

}
