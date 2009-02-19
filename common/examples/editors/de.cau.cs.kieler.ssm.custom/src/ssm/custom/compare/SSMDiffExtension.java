/*******************************************************************************
 * Copyright (c) 2009 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package ssm.custom.compare;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.diff.merge.api.IMerger;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.AddReferenceValue;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.RemoveReferenceValue;
import org.eclipse.emf.compare.ui.util.EMFCompareEObjectUtils;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.cau.cs.kieler.ssm.AbstractState;
import de.cau.cs.kieler.ssm.Transition;

/**
 * SSM implementation of the {@link AbstractDiffExtension}.
 * <p/>
 * Alters the generic diff output of EMF Compare to address the special needs
 * for SSMs.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class SSMDiffExtension implements AbstractDiffExtension {

	public EList<DiffElement> getHideElements() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isIsCollapsed() {
		// TODO Auto-generated method stub
		return false;
	}

	public IMerger provideMerger() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setIsCollapsed(boolean value) {
		// TODO Auto-generated method stub

	}

	/**
	 * Wanders through the provided (generic) diff model and alters it to
	 * address the needs (and semantics) of Statecharts.
	 * 
	 * @see org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension#visit(org.eclipse.emf.compare.diff.metamodel.DiffModel)
	 */
	public void visit(DiffModel diffModel) {
		DiffElement diffElement = diffModel.getOwnedElements().get(0);
		EList<DiffElement> toRemove = new BasicEList<DiffElement>();
		TreeIterator<EObject> i = diffElement.eAllContents();

		// collect items to remove, must be done in two steps to prevent
		// inconsistency when deleting while iterating through it
		while (i.hasNext()) {
			DiffElement nextDiffElement = (DiffElement) i.next();
			if (removeChangeOfStateDiffGroupDueToTransitions(nextDiffElement))
				toRemove.add(nextDiffElement);
			if (removeChangeOfStateDueToTransitions(nextDiffElement))
				toRemove.add(nextDiffElement);
		}
		// now actually remove the elements
		for (DiffElement removeDiffElement : toRemove) {
			EcoreUtil.remove(removeDiffElement);
		}
	}

	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eGet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}

	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}

	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub

	}

	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub

	}

	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub

	}

	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub

	}

	/**
	 * Checks if the provided DiffElement should be deleted. This will be the
	 * case if the DiffElement is a State which has just changed Transitions.
	 * The here assumed SSM semantics is that added, deleted, or changed
	 * Transitions do not affect the state of the change. The Transitions are
	 * stored as references within the State.
	 * 
	 * @param diffElement
	 *            A DiffElement for which it should be checked if it shall be
	 *            deleted from the diff model.
	 * @return True, if the provided DiffElement should be deleted.
	 */
	private boolean removeChangeOfStateDiffGroupDueToTransitions(
			DiffElement diffElement) {
		boolean deleteThisDiffElement = false;
		
		if (EMFCompareEObjectUtils.getLeftElement(diffElement) instanceof AbstractState) {
			for (DiffElement subDiffElement : diffElement.getSubDiffElements()) {
				if (subDiffElement instanceof ReferenceChange) {
					deleteThisDiffElement = true;
				} else {
					deleteThisDiffElement = false;
					break;
				}
			}
		}
		return deleteThisDiffElement;
	}

	/**
	 * Checks if the provided DiffElement should be deleted. This will be the
	 * case if the DiffElement is just a changed Transition of a State. This
	 * Transition is stored as references within the State.
	 * 
	 * @param diffElement
	 *            A DiffElement for which it should be checked if it shall be
	 *            deleted from the diff model.
	 * @return True, if the provided DiffElement should be deleted.
	 */
	private boolean removeChangeOfStateDueToTransitions(DiffElement diffElement) {
		if (diffElement instanceof RemoveReferenceValue) {
			RemoveReferenceValue remove = (RemoveReferenceValue) diffElement;
			if (remove.getLeftRemovedTarget() instanceof Transition
					|| remove.getRightRemovedTarget() instanceof Transition)
				return true;
		} else if (diffElement instanceof AddReferenceValue) {
			AddReferenceValue add = (AddReferenceValue) diffElement;
			if (add.getLeftAddedTarget() instanceof Transition
					|| add.getRightAddedTarget() instanceof Transition)
				return true;
		}
		return false;
	}
}
