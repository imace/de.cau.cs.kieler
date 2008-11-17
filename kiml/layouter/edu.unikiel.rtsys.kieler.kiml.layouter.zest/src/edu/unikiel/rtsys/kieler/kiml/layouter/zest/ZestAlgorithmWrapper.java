package edu.unikiel.rtsys.kieler.kiml.layouter.zest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.zest.layouts.*;
import org.eclipse.zest.layouts.constraints.BasicEntityConstraint;
import org.eclipse.zest.layouts.dataStructures.DisplayIndependentDimension;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;
import edu.unikiel.rtsys.kieler.kiml.layouter.zest.graph.*;
import edu.unikiel.rtsys.kieler.kiml.layouter.zest.preferences.ZestLayouterPreferencePage;

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
	
	private Map<KNodeGroup, LayoutEntity> nodeGroup2EntityMap = new HashMap<KNodeGroup, LayoutEntity>();
	private float totalWidth = 0.0f;
	private float totalHeight = 0.0f;
	
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
		LayoutEntity[] entities = buildEntities(nodeGroup);
		LayoutRelationship[] relationships = buildRelationships(nodeGroup);
		DisplayIndependentDimension parentSize = determineTopGroupSize(nodeGroup);
		try
		{
			layoutAlgorithm.applyLayout(entities, relationships, 0, 0,
					parentSize.width, parentSize.height, false, false);
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
	private LayoutEntity[] buildEntities(KNodeGroup parentGroup)
	{
		for (KNodeGroup child : parentGroup.getSubNodeGroups())
		{
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
			nodeGroup2EntityMap.put(child, entity);
		}
		return nodeGroup2EntityMap.values().toArray(new LayoutEntity[0]);
	}
	
	/**
	 * Builds a list of relationships of a parent node group.
	 * 
	 * @param parentGroup parent node group
	 * @return relationships in that node group
	 */
	private LayoutRelationship[] buildRelationships(KNodeGroup parentGroup)
	{
		LinkedList<LayoutRelationship> edgeList = new LinkedList<LayoutRelationship>();
		for (KNodeGroup sourceGroup : parentGroup.getSubNodeGroups())
		{
			for (KEdge edge : sourceGroup.getOutgoingEdges())
			{
				KNodeGroup targetGroup = edge.getTarget();
				if (targetGroup != null)
				{
					LayoutEntity sourceEntity = nodeGroup2EntityMap.get(sourceGroup);
					LayoutEntity targetEntity = nodeGroup2EntityMap.get(targetGroup);
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
	private void transferLayoutResult(LayoutEntity[] entities, LayoutRelationship[] relationships)
	{
		// transfer entities layouts
		for (LayoutEntity entity : entities)
		{
			KNodeGroup nodeGroup = (KNodeGroup)((AdvancedEntity)entity).getRealObject();
			float x = (float)entity.getXInLayout();
			float y = (float)entity.getYInLayout();
			nodeGroup.getLayout().getLocation().setX(x);
			nodeGroup.getLayout().getLocation().setY(y);
		}
		
		// transfer relationships layouts
		for (LayoutRelationship relationship : relationships)
		{
			KEdge edge = (KEdge)((AdvancedRelationship)relationship).getRealObject();
			edge.getLayout().getGridPoints().clear();
			for (LayoutBendPoint bendPoint : ((AdvancedRelationship)relationship).getBendPoints())
			{
				KPoint point = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
				float x = (float)bendPoint.getX();
				float y = (float)bendPoint.getY();
				point.setX(x);
				point.setY(y);
				edge.getLayout().getGridPoints().add(point);
			}
		}
	}
	
	/**
	 * Calculates the size of the parent group by the summed width and
	 * height of all child nodes.
	 * 
	 * @param parentGroup parent node group
	 * @return height and width of the total graph
	 */
	private DisplayIndependentDimension determineTopGroupSize(KNodeGroup parentGroup)
	{
		float scaleBase = Activator.getDefault().getPreferenceStore()
				.getFloat(ZestLayouterPreferencePage.SCALE_BASE);
		float width = (float)Math.sqrt(totalWidth) * scaleBase;
		float height = (float)Math.sqrt(totalHeight) * scaleBase;
		KInsets insets = parentGroup.getLayout().getInsets();
		parentGroup.getLayout().getSize().setWidth(width + insets.getLeft() + insets.getRight());
		parentGroup.getLayout().getSize().setHeight(height + insets.getTop() + insets.getBottom());
		return new DisplayIndependentDimension(width, height);
	}

}
