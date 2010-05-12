package de.cau.cs.kieler.viewmanagement.effects;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.core.KielerModelException;
import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * This Effect collapses or expands compartments. The execute() method expands
 * while the undo method collapses.
 * 
 * @author haf
 */
public class CompartmentCollapseExpandEffect extends AEffect {

    private int compartmentLevel = 0;

    /**
     * The compartment level gives the hierarchy to which to search for compartments to collapse.
     * @param theCompartmentLevel hierarchy level. 0 means only exactly the given EditPart.
     */
    public CompartmentCollapseExpandEffect(final int theCompartmentLevel) {
        this.compartmentLevel = theCompartmentLevel;
    }

    @Override
    public void execute() {
        if (this.getAffectedObject() instanceof GraphicalEditPart) {
            try {
                GraphicalEditPart ep = (GraphicalEditPart) this.getAffectedObject();
                setCollapsed(ep, true);
                ep.refresh();

            } catch (KielerModelException e) {
                // TODO: log
                e.printStackTrace();
            }
        }
    }

    /**
     * Undo the effect, i.e. expand a collapsed compartment.
     */
    public void undo() {
        if (this.getAffectedObject() instanceof GraphicalEditPart) {
            try {
                GraphicalEditPart ep = (GraphicalEditPart) this.getAffectedObject();
                setCollapsed(ep, false);
                ep.refresh();
            } catch (KielerModelException e) {
                // TODO: log
                e.printStackTrace();
            }
        }
    }

    /**
     * Set the collapsed state of all compartments---including nested ones.
     * 
     * @param editPart
     *            the input editPart
     * @param value
     *            true iff should get collapsed, false if expanded
     * @throws KielerModelException
     */
    private void setCollapsed(final GraphicalEditPart editPart, final boolean value)
            throws KielerModelException {
        final View view = (View) editPart.getModel();
        try {
            final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(view);

            AbstractEMFOperation op = new AbstractEMFOperation(domain,
                    "Viewmanagement set collapsed state") {

                @Override
                protected IStatus doExecute(final IProgressMonitor monitor, final IAdaptable info)
                        throws ExecutionException {

                    List<BasicCompartment> compartments = getNestedCompartments(view, compartmentLevel);
                    for (BasicCompartment compartment : compartments) {
                        ViewUtil.setStructuralFeatureValue(compartment, NotationPackage.eINSTANCE
                                .getDrawerStyle_Collapsed(), value);
                    }
                    return Status.OK_STATUS;
                }
            };
            op.execute(null, null);
        } catch (ExecutionException e0) {
            throw new KielerModelException("Could change collapsed state of compartments.", view
                    .getElement(), e0);
        }
    }

    /**
     * Give all compartments of a view. The list will also contain the input
     * view itself if it is a compartment. Additionally it traverses the whole
     * child tree and also returns all nested child compartments. The list is
     * ordered from root following a dfs.
     * 
     * @param view
     *            input view where search is started
     * @param level
     *            how deep to go into hierarchy: 0 will return only the view itself if it is a compartment
     * @return a List of all compartments of the view
     */
    private static List<BasicCompartment> getNestedCompartments(final View view, final int level) {
        List<BasicCompartment> compartments = new ArrayList<BasicCompartment>();
        if (view instanceof BasicCompartment) {
            compartments.add((BasicCompartment) view);
        }
        // recursively call method for all children
        if (level > 0) {
            List<?> childViews = view.getChildren();
            for (Object child : childViews) {
                if (child instanceof View) {
                    compartments.addAll(getNestedCompartments((View) child, (level - 1)));
                }
            }
        }
        return compartments;
    }

    @Override
    public void setTarget(final EditPart target) {
        // TODO Auto-generated method stub
        super.setTarget(target);
    }
}
