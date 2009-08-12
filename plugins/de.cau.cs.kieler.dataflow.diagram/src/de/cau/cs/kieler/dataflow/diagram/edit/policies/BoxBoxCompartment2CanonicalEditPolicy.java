package de.cau.cs.kieler.dataflow.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.dataflow.DataflowPackage;
import de.cau.cs.kieler.dataflow.diagram.edit.parts.Box2EditPart;
import de.cau.cs.kieler.dataflow.diagram.part.DataflowDiagramUpdater;
import de.cau.cs.kieler.dataflow.diagram.part.DataflowNodeDescriptor;
import de.cau.cs.kieler.dataflow.diagram.part.DataflowVisualIDRegistry;

/**
 * @generated
 */
public class BoxBoxCompartment2CanonicalEditPolicy extends CanonicalEditPolicy {

    /**
     * @generated
     */
    Set myFeaturesToSynchronize;

    /**
     * @generated
     */
    protected List getSemanticChildrenList() {
        View viewObject = (View) getHost().getModel();
        List result = new LinkedList();
        for (Iterator it = DataflowDiagramUpdater.getBoxBoxCompartment_7002SemanticChildren(
                viewObject).iterator(); it.hasNext();) {
            result.add(((DataflowNodeDescriptor) it.next()).getModelElement());
        }
        return result;
    }

    /**
     * @generated
     */
    protected boolean isOrphaned(Collection semanticChildren, final View view) {
        int visualID = DataflowVisualIDRegistry.getVisualID(view);
        switch (visualID) {
        case Box2EditPart.VISUAL_ID:
            if (!semanticChildren.contains(view.getElement())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @generated
     */
    protected String getDefaultFactoryHint() {
        return null;
    }

    /**
     * @generated
     */
    protected Set getFeaturesToSynchronize() {
        if (myFeaturesToSynchronize == null) {
            myFeaturesToSynchronize = new HashSet();
            myFeaturesToSynchronize.add(DataflowPackage.eINSTANCE.getBox_Boxes());
        }
        return myFeaturesToSynchronize;
    }

}
