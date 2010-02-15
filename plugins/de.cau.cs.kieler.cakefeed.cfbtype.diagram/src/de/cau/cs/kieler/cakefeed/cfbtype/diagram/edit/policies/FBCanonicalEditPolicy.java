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
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedDiagramUpdater;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedNodeDescriptor;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry;

/**
 * @generated
 */
public class FBCanonicalEditPolicy extends CanonicalEditPolicy {

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
		for (Iterator it = CakefeedDiagramUpdater.getFB_3025SemanticChildren(
				viewObject).iterator(); it.hasNext();) {
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
		case FBInputEventEditPart.VISUAL_ID:
		case FBOutputEventEditPart.VISUAL_ID:
		case FBInputVarEditPart.VISUAL_ID:
		case FBOutputVarEditPart.VISUAL_ID:
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
					.getFB_InputEvents());
			myFeaturesToSynchronize.add(CakefeedPackage.eINSTANCE
					.getFB_OutputEvents());
			myFeaturesToSynchronize.add(CakefeedPackage.eINSTANCE
					.getFB_InputVars());
			myFeaturesToSynchronize.add(CakefeedPackage.eINSTANCE
					.getFB_OutputVars());
		}
		return myFeaturesToSynchronize;
	}

}
