package de.cau.cs.kieler.kiml.layouter.zest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.zest.layouts.*;
import org.eclipse.zest.layouts.constraints.BasicEntityConstraint;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.*;
import de.cau.cs.kieler.kiml.layouter.zest.graph.*;
import de.cau.cs.kieler.kiml.layouter.zest.preferences.ZestLayouterPreferencePage;


/**
 * Wrapper class that translates KIML layout graphs into the Zest graph
 * structure.
 * 
 * @author msp
 */
public class ZestAlgorithmWrapper {
	
	/** Name of the Zest layout algorithms collection */
	public static final String COLLECTION_NAME = "Zest Layout Algorithms";
	
	// value added to the size of each parent node
	private static final float SIZE_ADDITION = 20.0f;
	
	// layout algorithm used internally
	private LayoutAlgorithm layoutAlgorithm;
	
	// mapping of layout nodes to layout entities
	private Map<KLayoutNode, LayoutEntity> layoutNode2EntityMap = new HashMap<KLayoutNode, LayoutEntity>();
	// sum of the widths of all nodes
	private float totalWidth = 0.0f;
	// sum of the heights of all nodes
	private float totalHeight = 0.0f;
	
	/**
	 * Creates a wrapper for a given Zest layout algorithm.
	 * 
	 * @param theLayoutAlgorithm Zest layout algorithm to use
	 */
	public ZestAlgorithmWrapper(LayoutAlgorithm theLayoutAlgorithm) {
		this.layoutAlgorithm = theLayoutAlgorithm;
	}
	
	/**
	 * Applies the predefined algorithm on the given layout node.
	 * 
	 * @param layoutNode layout node to be layouted
	 */
	public void doLayout(KLayoutNode layoutNode) {
		// build layout entities and relationships
		LayoutEntity[] entities = buildEntities(layoutNode);
		LayoutRelationship[] relationships = buildRelationships(layoutNode);
		
		// compute preferred height and width of the graph
		float scaleBase = Activator.getDefault().getPreferenceStore()
				.getFloat(ZestLayouterPreferencePage.SCALE_BASE);
		float width = (float)Math.sqrt(totalWidth / entities.length) * scaleBase;
		float height = (float)Math.sqrt(totalHeight / entities.length) * scaleBase;
		
		// executes the layout algorithm
		try {
			layoutAlgorithm.applyLayout(entities, relationships,
					SIZE_ADDITION, SIZE_ADDITION, width, height, false, false);
		}
		catch (InvalidLayoutConfiguration exception) {
			Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"Failed to execute Zest layout algorithm.", exception);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		}
		
		// transfer layout results to the original graph
		transferLayoutResult(layoutNode, entities, relationships);
	}
	
	/**
	 * Builds a list of entities of a parent layout node.
	 * 
	 * @param parentNode parent layout node
	 * @return entities in that layout node
	 */
	private LayoutEntity[] buildEntities(KLayoutNode parentNode) {
		for (KLayoutNode child : parentNode.getChildNodes()) {
			float x = child.getLayout().getLocation().getX();
			float y = child.getLayout().getLocation().getY();
			float width = child.getLayout().getSize().getWidth();
			float height = child.getLayout().getSize().getHeight();
			AdvancedEntity entity = new AdvancedEntity(child, x, y, width, height);
			totalWidth += width;
			totalHeight += height;
			BasicEntityConstraint entityConstraint = new BasicEntityConstraint();
			entityConstraint.preferredWidth = width; 
			entityConstraint.preferredHeight = height;
			entityConstraint.hasPreferredSize = true;
			entityConstraint.hasPreferredLocation = false;
			entity.populateLayoutConstraint(entityConstraint);
			layoutNode2EntityMap.put(child, entity);
		}
		return layoutNode2EntityMap.values().toArray(new LayoutEntity[0]);
	}
	
	/**
	 * Builds a list of relationships of a parent layout node.
	 * 
	 * @param parentNode parent layout node
	 * @return relationships in that layout node
	 */
	private LayoutRelationship[] buildRelationships(KLayoutNode parentNode) {
		LinkedList<LayoutRelationship> edgeList = new LinkedList<LayoutRelationship>();
		for (KLayoutNode sourceGroup : parentNode.getChildNodes()) {
			for (KLayoutEdge edge : sourceGroup.getOutgoingEdges()) {
				KLayoutNode targetGroup = edge.getTarget();
				if (targetGroup != null) {
					LayoutEntity sourceEntity = layoutNode2EntityMap.get(sourceGroup);
					LayoutEntity targetEntity = layoutNode2EntityMap.get(targetGroup);
					LayoutRelationship relationship = new AdvancedRelationship(edge, sourceEntity, targetEntity);
					edgeList.add(relationship);
				}
			}
		}
		return edgeList.toArray(new LayoutRelationship[0]);
	}
	
	/**
	 * Copies layout results back to the original layout graph.
	 * 
	 * @param entities list of layouted entities
	 * @param relationships list of layouted relationships
	 */
	private void transferLayoutResult(KLayoutNode parentNode,
			LayoutEntity[] entities, LayoutRelationship[] relationships) {
		float maxX = 0.0f, maxY = 0.0f;
		
		// transfer entities layouts
		for (LayoutEntity entity : entities) {
			KLayoutNode layoutNode = (KLayoutNode)((AdvancedEntity)entity).getRealObject();
			float x = (float)entity.getXInLayout();
			float y = (float)entity.getYInLayout();
			float width = layoutNode.getLayout().getSize().getWidth();
			float height = layoutNode.getLayout().getSize().getHeight();
			if (x + width > maxX) maxX = x + width;
			if (y + height > maxY) maxY = y + height;
			layoutNode.getLayout().getLocation().setX(x);
			layoutNode.getLayout().getLocation().setY(y);
		}
		
		// transfer relationships layouts
		for (LayoutRelationship relationship : relationships) {
			KLayoutEdge edge = (KLayoutEdge)((AdvancedRelationship)relationship).getRealObject();
			edge.getLayout().getBendPoints().clear();
			for (LayoutBendPoint bendPoint : ((AdvancedRelationship)relationship).getBendPoints()) {
				KPoint point = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
				float x = (float)bendPoint.getX();
				float y = (float)bendPoint.getY();
				if (x > maxX) maxX = x;
				if (y > maxY) maxY = y;
				point.setX(x);
				point.setY(y);
				edge.getLayout().getBendPoints().add(point);
			}
		}
		
		// determine size of the parent group
		KInsets insets = parentNode.getLayout().getInsets();
		parentNode.getLayout().getSize().setWidth(maxX + insets.getLeft()
				+ insets.getRight() + SIZE_ADDITION);
		parentNode.getLayout().getSize().setHeight(maxY + insets.getTop()
				+ insets.getBottom() + SIZE_ADDITION);
	}

}
