package edu.unikiel.rtsys.kieler.kiml.layout.services;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kPoint;

/**
 * @author ars
 * 
 */
public class KimlRecursiveGroupLayoutProvider {

	private IKimlLayouter layoutProvider = null;
	private kLayoutGraph layoutGraph = null;
	private NodeEditPart topNode = null;
	private Map<EditPart, kNodeGroup> editPart2Node = new HashMap<EditPart, kNodeGroup>();

	public KimlRecursiveGroupLayoutProvider() {
		super();
		this.layoutGraph = KimlLayoutGraphFactory.eINSTANCE
				.createkLayoutGraph();
	}

	public KimlRecursiveGroupLayoutProvider(NodeEditPart topNode) {
		super();
		this.topNode = topNode;
		this.layoutGraph = KimlLayoutGraphFactory.eINSTANCE
				.createkLayoutGraph();
	}

	public void setTopNode(NodeEditPart topNode) {
		this.topNode = topNode;
	}

	/**
	 * Root layouter class. Chooses the layouter from the contributed ones via
	 * the extension points.
	 */
	public void layout(NodeEditPart newTopNode) {
		if (newTopNode != null)
			this.topNode = newTopNode;
		if (this.topNode == null)
			return;
		System.out.println("Layout: layout.");
		buildLayoutGraph();
		performLayout();
	}

	private void performLayout() {
		loadLayouter("");
		for (kNodeGroup nodeGroup : layoutGraph.getTopGroup()
				.getSubNodeGroups()) {
			System.out.println(nodeGroup.toString());
			layoutProvider.doLayout(layoutGraph);
		}
	}

	private void buildLayoutGraph() {
		System.out.println("KRGL: buildLayoutGraph");
		kNodeGroup topNodeGroup = KimlLayoutGraphFactory.eINSTANCE
				.createkNodeGroup();

		kNodeGroupLayout topNodeGroupLayout = KimlLayoutGraphFactory.eINSTANCE
				.createkNodeGroupLayout();
		kPoint location = KimlLayoutGraphFactory.eINSTANCE.createkPoint();
		location.setX(topNode.getFigure().getBounds().getLocation().x);
		location.setY(topNode.getFigure().getBounds().getLocation().y);
		topNodeGroupLayout.setLocation(location);
		kDimension size = KimlLayoutGraphFactory.eINSTANCE.createkDimension();
		size.setHeight(topNode.getFigure().getSize().height);
		size.setWidth(topNode.getFigure().getSize().width);
		topNodeGroup.setNodeGroupLayout(topNodeGroupLayout);

		buildLayoutGraphRecursive(topNode, topNodeGroup);

		layoutGraph.setTopGroup(topNodeGroup);
	}

	private void buildLayoutGraphRecursive(GraphicalEditPart parent,
			kNodeGroup parentNodeGroup) {
		System.out.println("KRGL: buildLayoutGraphRecursive");

		for (Object obj : parent.getChildren()) {
			System.out.println("KRGL: buildLayoutGraphRecursive for: "
					+ obj.getClass());

			if (obj instanceof NodeEditPart) {
				System.out.println("KRGL: buildLayoutGraphRecursive: okay");
				NodeEditPart childNode = (NodeEditPart) obj;
				kNodeGroup childGroup = KimlLayoutGraphFactory.eINSTANCE
						.createkNodeGroup();
				kNodeGroupLayout childNodeGroupLayout = KimlLayoutGraphFactory.eINSTANCE
						.createkNodeGroupLayout();
				kPoint location = KimlLayoutGraphFactory.eINSTANCE
						.createkPoint();
				location.setX(childNode.getFigure().getBounds().getLocation().x);
				location.setY(childNode.getFigure().getBounds().getLocation().y);
				childNodeGroupLayout.setLocation(location);
				kDimension size = KimlLayoutGraphFactory.eINSTANCE
						.createkDimension();
				size.setHeight(childNode.getFigure().getSize().height);
				size.setWidth(childNode.getFigure().getSize().width);
				childGroup.setNodeGroupLayout(childNodeGroupLayout);
				
				parentNodeGroup.getSubNodeGroups().add(childGroup);
				buildLayoutGraphRecursive(childNode, childGroup);
			} else if (obj instanceof GraphicalEditPart) {
				GraphicalEditPart childPart = (GraphicalEditPart) obj;
				buildLayoutGraphRecursive(childPart, parentNodeGroup);
			}
		}
	}

	private void loadLayouter(String type) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = reg
				.getConfigurationElementsFor(IKimlLayouter.EXTENSION_POINT_ID);
		for (IConfigurationElement element : extensions) {
			System.out.println("extension: " + element.getName());
			try {
				layoutProvider = (IKimlLayouter) element
						.createExecutableExtension(IKimlLayouter.ATTRIBUTE_CLASS);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
