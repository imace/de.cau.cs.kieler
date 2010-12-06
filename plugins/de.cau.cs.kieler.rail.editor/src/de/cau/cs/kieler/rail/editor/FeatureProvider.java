/**
 * 
 */
package de.cau.cs.kieler.rail.editor;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import de.cau.cs.kieler.rail.Topologie.Basegraph.Edge;
import de.cau.cs.kieler.rail.Topologie.SpecializedVertices.Einbruchsknoten;
import de.cau.cs.kieler.rail.Topologie.SpecializedVertices.Stumpfgleisknoten;
import de.cau.cs.kieler.rail.editor.features.AddBreachFeature;
import de.cau.cs.kieler.rail.editor.features.AddDeadEndVertexFeature;
import de.cau.cs.kieler.rail.editor.features.AddEdgeFeature;
import de.cau.cs.kieler.rail.editor.features.CreateBreachFeature;
import de.cau.cs.kieler.rail.editor.features.CreateDeadEndVertexFeature;
import de.cau.cs.kieler.rail.editor.features.CreateEdgeFeature;

/**
 * @author hdw
 *
 */
public class FeatureProvider extends DefaultFeatureProvider {

	/**
	 * 
	 */
	public FeatureProvider( IDiagramTypeProvider dtp) {
        super(dtp);
    }
	
    @Override
    public IAddFeature getAddFeature(IAddContext context) {
        // is object for add request a EClass or EReference?
        if (context.getNewObject() instanceof Einbruchsknoten) {
            return new AddBreachFeature(this);
        } else if (context.getNewObject() instanceof Stumpfgleisknoten) {
        	return new AddDeadEndVertexFeature(this);
        }
        else if (context.getNewObject() instanceof Edge) {
            return new AddEdgeFeature(this);
        }
        return super.getAddFeature(context);
    }


    @Override
    public ICreateFeature[] getCreateFeatures() {
    	//, new CreateDeadEndVertexFeature(this)
        return new ICreateFeature[] { new CreateBreachFeature(this) };
    }
    
    @Override
    public ICreateConnectionFeature[] getCreateConnectionFeatures() {
        return new ICreateConnectionFeature[] {
            new CreateEdgeFeature (this) };
    }

}
