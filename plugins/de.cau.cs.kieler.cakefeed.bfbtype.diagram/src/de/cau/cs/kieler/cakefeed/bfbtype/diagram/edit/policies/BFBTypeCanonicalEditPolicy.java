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
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBDEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InternalVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedDiagramUpdater;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedNodeDescriptor;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedVisualIDRegistry;

/**
 * @generated
 */
public class BFBTypeCanonicalEditPolicy extends CanonicalEditPolicy {

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
				.getBFBType_2002SemanticChildren(viewObject).iterator(); it
				.hasNext();) {
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
		case IFInputEventEditPart.VISUAL_ID:
		case IFOutputEventEditPart.VISUAL_ID:
		case IFInputVarEditPart.VISUAL_ID:
		case IFOutputVarEditPart.VISUAL_ID:
		case InternalVarEditPart.VISUAL_ID:
		case FBDEditPart.VISUAL_ID:
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
					.getFBInterface_InputEvents());
			myFeaturesToSynchronize.add(CakefeedPackage.eINSTANCE
					.getFBInterface_OutputEvents());
			myFeaturesToSynchronize.add(CakefeedPackage.eINSTANCE
					.getFBInterface_InputVars());
			myFeaturesToSynchronize.add(CakefeedPackage.eINSTANCE
					.getFBInterface_OutputVars());
			myFeaturesToSynchronize.add(CakefeedPackage.eINSTANCE
					.getBFBType_InternalVars());
			myFeaturesToSynchronize.add(CakefeedPackage.eINSTANCE
					.getBFBType_FunctionBlockDiagrams());
		}
		return myFeaturesToSynchronize;
	}

}
