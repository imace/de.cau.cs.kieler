package de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBDiagramEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeBFBTypeCompartmentEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBDFBDCompartmentEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedDiagramEditorPlugin;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.Messages;

/**
 * @generated
 */
public class CakefeedModelingAssistantProvider extends
		ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof BFBTypeEditPart) {
			ArrayList types = new ArrayList(6);
			types.add(CakefeedElementTypes.IFInputEvent_3024);
			types.add(CakefeedElementTypes.IFOutputEvent_3025);
			types.add(CakefeedElementTypes.IFInputVar_3026);
			types.add(CakefeedElementTypes.IFOutputVar_3027);
			types.add(CakefeedElementTypes.InternalVar_3028);
			types.add(CakefeedElementTypes.FBD_3029);
			return types;
		}
		if (editPart instanceof FBEditPart) {
			ArrayList types = new ArrayList(4);
			types.add(CakefeedElementTypes.FBInputEvent_3031);
			types.add(CakefeedElementTypes.FBOutputEvent_3032);
			types.add(CakefeedElementTypes.FBInputVar_3033);
			types.add(CakefeedElementTypes.FBOutputVar_3034);
			return types;
		}
		if (editPart instanceof BFBTypeBFBTypeCompartmentEditPart) {
			ArrayList types = new ArrayList(3);
			types.add(CakefeedElementTypes.ST_3035);
			types.add(CakefeedElementTypes.LD_3036);
			types.add(CakefeedElementTypes.Other_3037);
			return types;
		}
		if (editPart instanceof FBDFBDCompartmentEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(CakefeedElementTypes.FB_3030);
			return types;
		}
		if (editPart instanceof BFBDiagramEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(CakefeedElementTypes.BFBType_2002);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof IFInputEventEditPart) {
			return ((IFInputEventEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof IFOutputEventEditPart) {
			return ((IFOutputEventEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FBOutputVarEditPart) {
			return ((FBOutputVarEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof IFInputVarEditPart) {
			return ((IFInputVarEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof IFOutputVarEditPart) {
			return ((IFOutputVarEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FBInputVarEditPart) {
			return ((FBInputVarEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof IFInputEventEditPart) {
			return ((IFInputEventEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof IFOutputEventEditPart) {
			return ((IFOutputEventEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FBOutputVarEditPart) {
			return ((FBOutputVarEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof IFInputVarEditPart) {
			return ((IFInputVarEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof IFOutputVarEditPart) {
			return ((IFOutputVarEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FBInputVarEditPart) {
			return ((FBInputVarEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof IFInputEventEditPart) {
			return ((IFInputEventEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof IFOutputEventEditPart) {
			return ((IFOutputEventEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FBOutputVarEditPart) {
			return ((FBOutputVarEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target,
				relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source,
				relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				CakefeedDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.CakefeedModelingAssistantProviderMessage);
		dialog.setTitle(Messages.CakefeedModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
