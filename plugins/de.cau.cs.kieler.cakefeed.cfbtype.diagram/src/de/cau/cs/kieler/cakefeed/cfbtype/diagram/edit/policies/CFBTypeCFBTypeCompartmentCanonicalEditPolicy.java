package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedDiagramUpdater;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedNodeDescriptor;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry;

/**
 * @generated
 */
public class CFBTypeCFBTypeCompartmentCanonicalEditPolicy extends
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
				.getCFBTypeCFBTypeCompartment_7005SemanticChildren(viewObject)
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
		case FBEditPart.VISUAL_ID:
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
					.getFBNetwork_FBs());
		}
		return myFeaturesToSynchronize;
	}

}
