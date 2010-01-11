package de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.LDEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OtherEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.STEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedDiagramUpdater;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedNodeDescriptor;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedVisualIDRegistry;

/**
 * @generated
 */
public class BFBTypeBFBTypeCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

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
		for (Iterator it = CakefeedDiagramUpdater
				.getBFBTypeBFBTypeCompartment_7005SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			result.add(((CakefeedNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = CakefeedVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case STEditPart.VISUAL_ID:
		case LDEditPart.VISUAL_ID:
		case OtherEditPart.VISUAL_ID:
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
			myFeaturesToSynchronize.add(CakefeedPackage.eINSTANCE
					.getBFBType_STs());
			myFeaturesToSynchronize.add(CakefeedPackage.eINSTANCE
					.getBFBType_LadderDiagrams());
			myFeaturesToSynchronize.add(CakefeedPackage.eINSTANCE
					.getBFBType_OtherAlgorithms());
		}
		return myFeaturesToSynchronize;
	}

}
