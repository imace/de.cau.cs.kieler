package edu.unikiel.rtsys.kieler.kiml.layouter.zest;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.zest.layouts.*;
import org.eclipse.zest.layouts.constraints.BasicEntityConstraint;
import org.eclipse.zest.layouts.exampleStructures.SimpleGraph;
import org.eclipse.zest.layouts.exampleStructures.SimpleNode;
import org.eclipse.zest.layouts.exampleStructures.SimpleRelationship;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;

/**
 * Wrapper class that translates KIML layout graphs into the Zest graph
 * structure.
 * 
 * @author msp
 */
public class ZestAlgorithmWrapper {
	
	/** Name of the Zest layout algorithms collection */
	public static final String COLLECTION_NAME = "Zest Layout Algorithms";
	
	private LayoutAlgorithm layoutAlgorithm;
	private LayoutGraph layoutGraph; 
	
	private Map<KNodeGroup, LayoutEntity> nodeGroup2EntityMap = new HashMap<KNodeGroup, LayoutEntity>();
	
	/**
	 * Creates a wrapper for a given Zest layout algorithm.
	 * 
	 * @param theLayoutAlgorithm Zest layout algorithm to use
	 */
	public ZestAlgorithmWrapper(LayoutAlgorithm theLayoutAlgorithm)
	{
		this.layoutAlgorithm = theLayoutAlgorithm;
	}
	
	/**
	 * Applies the predefined algorithm on the given node group.
	 * 
	 * @param nodeGroup node group to be layouted
	 */
	public void doLayout(KNodeGroup nodeGroup) {
		layoutGraph = new SimpleGraph();
		LayoutEntity[] entities = buildEntities(nodeGroup);
		LayoutRelationship[] relationships = buildRelationships(nodeGroup);
		try
		{
			layoutAlgorithm.applyLayout(entities, relationships, 0, 0, 1000, 1000, false, false);
		}
		catch (Exception exception)
		{
			// TODO error handling
			exception.printStackTrace();
		}
		
		transferLayoutResult(entities, relationships);
	}
	
	/**
	 * Builds a list of entities of a parent node group.
	 * 
	 * @param parentGroup parent node group
	 * @return entities in that node group
	 */
	@SuppressWarnings("unchecked")
	private LayoutEntity[] buildEntities(KNodeGroup parentGroup)
	{
		for (KNodeGroup child : parentGroup.getSubNodeGroups())
		{
			float x = child.getLayout().getLocation().getX();
			float y = child.getLayout().getLocation().getY();
			float width = child.getLayout().getSize().getWidth();
			float height = child.getLayout().getSize().getHeight();
			SimpleNode entity = new SimpleNode(child, x, y, width, height);
			BasicEntityConstraint entityConstraint = new BasicEntityConstraint();
			entityConstraint.preferredWidth = width; 
			entityConstraint.preferredHeight = height;
			entityConstraint.hasPreferredSize = true;
			entityConstraint.hasPreferredLocation = false;
			entity.populateLayoutConstraint(entityConstraint);
			nodeGroup2EntityMap.put(child, entity);
			layoutGraph.addEntity(entity);
		}
		return (LayoutEntity[])layoutGraph.getEntities().toArray(new LayoutEntity[0]);
	}
	
	/**
	 * Builds a list of relationships of a parent node group.
	 * 
	 * @param parentGroup parent node group
	 * @return relationships in that node group
	 */
	@SuppressWarnings("unchecked")
	private LayoutRelationship[] buildRelationships(KNodeGroup parentGroup)
	{
		for (KNodeGroup sourceGroup : parentGroup.getSubNodeGroups())
		{
			for (KEdge edge : sourceGroup.getOutgoingEdges())
			{
				KNodeGroup targetGroup = edge.getTarget();
				if (targetGroup != null)
				{
					LayoutEntity sourceEntity = nodeGroup2EntityMap.get(sourceGroup);
					LayoutEntity targetEntity = nodeGroup2EntityMap.get(targetGroup);
					LayoutRelationship relationship = new SimpleRelationship(sourceEntity, targetEntity, false);
					relationship.setGraphData(edge);
					layoutGraph.addRelationship(relationship);
				}
			}
		}
		return (LayoutRelationship[])layoutGraph.getRelationships().toArray(
				new LayoutRelationship[0]);
	}
	
	/**
	 * Copies layout results back to the original layout graph.
	 * 
	 * @param entities list of layouted entities
	 * @param relationships list of layouted relationships
	 */
	private void transferLayoutResult(LayoutEntity[] entities, LayoutRelationship[] relationships)
	{
		// transfer entities layouts
		for (LayoutEntity entity : entities)
		{
			KNodeGroup nodeGroup = (KNodeGroup)entity.getGraphData();
			nodeGroup.getLayout().getLocation().setX((float)entity.getXInLayout());
			nodeGroup.getLayout().getLocation().setY((float)entity.getYInLayout());
		}
		// transfer relationships layouts
		for (LayoutRelationship relationship : relationships)
		{
			KEdge edge = (KEdge)relationship.getGraphData();
			edge.getLayout().getGridPoints().clear();
			for (LayoutBendPoint bendPoint : ((SimpleRelationship)relationship).getBendPoints())
			{
				KPoint point = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
				point.setX((float)bendPoint.getX());
				point.setY((float)bendPoint.getY());
				edge.getLayout().getGridPoints().add(point);
			}
		}
	}

}
