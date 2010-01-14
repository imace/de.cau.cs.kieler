package de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBDiagramEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBDEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InputWithEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InternalVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.LDEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OtherEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OutputWithEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.STEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedDiagramEditorPlugin;

/**
 * @generated
 */
public class CakefeedElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private CakefeedElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType BFBDiagram_1000 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.BFBDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType BFBType_2002 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.BFBType_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFInputEvent_3024 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.IFInputEvent_3024"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFOutputEvent_3025 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.IFOutputEvent_3025"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFInputVar_3026 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.IFInputVar_3026"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFOutputVar_3027 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.IFOutputVar_3027"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InternalVar_3028 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.InternalVar_3028"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBD_3029 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.FBD_3029"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FB_3030 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.FB_3030"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBInputEvent_3031 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.FBInputEvent_3031"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBOutputEvent_3032 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.FBOutputEvent_3032"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBInputVar_3033 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.FBInputVar_3033"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBOutputVar_3034 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.FBOutputVar_3034"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ST_3035 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.ST_3035"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LD_3036 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.LD_3036"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Other_3037 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.Other_3037"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InputWith_4001 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.InputWith_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OutputWith_4002 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.OutputWith_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBFBDataConnection_4005 = getElementType("de.cau.cs.kieler.cakefeed.bfbtype.diagram.FBFBDataConnection_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return CakefeedDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(BFBDiagram_1000, CakefeedPackage.eINSTANCE
					.getBFBDiagram());

			elements.put(BFBType_2002, CakefeedPackage.eINSTANCE.getBFBType());

			elements.put(IFInputEvent_3024, CakefeedPackage.eINSTANCE
					.getIFInputEvent());

			elements.put(IFOutputEvent_3025, CakefeedPackage.eINSTANCE
					.getIFOutputEvent());

			elements.put(IFInputVar_3026, CakefeedPackage.eINSTANCE
					.getIFInputVar());

			elements.put(IFOutputVar_3027, CakefeedPackage.eINSTANCE
					.getIFOutputVar());

			elements.put(InternalVar_3028, CakefeedPackage.eINSTANCE
					.getInternalVar());

			elements.put(FBD_3029, CakefeedPackage.eINSTANCE.getFBD());

			elements.put(FB_3030, CakefeedPackage.eINSTANCE.getFB());

			elements.put(FBInputEvent_3031, CakefeedPackage.eINSTANCE
					.getFBInputEvent());

			elements.put(FBOutputEvent_3032, CakefeedPackage.eINSTANCE
					.getFBOutputEvent());

			elements.put(FBInputVar_3033, CakefeedPackage.eINSTANCE
					.getFBInputVar());

			elements.put(FBOutputVar_3034, CakefeedPackage.eINSTANCE
					.getFBOutputVar());

			elements.put(ST_3035, CakefeedPackage.eINSTANCE.getST());

			elements.put(LD_3036, CakefeedPackage.eINSTANCE.getLD());

			elements.put(Other_3037, CakefeedPackage.eINSTANCE.getOther());

			elements.put(InputWith_4001, CakefeedPackage.eINSTANCE
					.getInputWith());

			elements.put(OutputWith_4002, CakefeedPackage.eINSTANCE
					.getOutputWith());

			elements.put(FBFBDataConnection_4005, CakefeedPackage.eINSTANCE
					.getFBFBDataConnection());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(BFBDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(BFBType_2002);
			KNOWN_ELEMENT_TYPES.add(IFInputEvent_3024);
			KNOWN_ELEMENT_TYPES.add(IFOutputEvent_3025);
			KNOWN_ELEMENT_TYPES.add(IFInputVar_3026);
			KNOWN_ELEMENT_TYPES.add(IFOutputVar_3027);
			KNOWN_ELEMENT_TYPES.add(InternalVar_3028);
			KNOWN_ELEMENT_TYPES.add(FBD_3029);
			KNOWN_ELEMENT_TYPES.add(FB_3030);
			KNOWN_ELEMENT_TYPES.add(FBInputEvent_3031);
			KNOWN_ELEMENT_TYPES.add(FBOutputEvent_3032);
			KNOWN_ELEMENT_TYPES.add(FBInputVar_3033);
			KNOWN_ELEMENT_TYPES.add(FBOutputVar_3034);
			KNOWN_ELEMENT_TYPES.add(ST_3035);
			KNOWN_ELEMENT_TYPES.add(LD_3036);
			KNOWN_ELEMENT_TYPES.add(Other_3037);
			KNOWN_ELEMENT_TYPES.add(InputWith_4001);
			KNOWN_ELEMENT_TYPES.add(OutputWith_4002);
			KNOWN_ELEMENT_TYPES.add(FBFBDataConnection_4005);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case BFBDiagramEditPart.VISUAL_ID:
			return BFBDiagram_1000;
		case BFBTypeEditPart.VISUAL_ID:
			return BFBType_2002;
		case IFInputEventEditPart.VISUAL_ID:
			return IFInputEvent_3024;
		case IFOutputEventEditPart.VISUAL_ID:
			return IFOutputEvent_3025;
		case IFInputVarEditPart.VISUAL_ID:
			return IFInputVar_3026;
		case IFOutputVarEditPart.VISUAL_ID:
			return IFOutputVar_3027;
		case InternalVarEditPart.VISUAL_ID:
			return InternalVar_3028;
		case FBDEditPart.VISUAL_ID:
			return FBD_3029;
		case FBEditPart.VISUAL_ID:
			return FB_3030;
		case FBInputEventEditPart.VISUAL_ID:
			return FBInputEvent_3031;
		case FBOutputEventEditPart.VISUAL_ID:
			return FBOutputEvent_3032;
		case FBInputVarEditPart.VISUAL_ID:
			return FBInputVar_3033;
		case FBOutputVarEditPart.VISUAL_ID:
			return FBOutputVar_3034;
		case STEditPart.VISUAL_ID:
			return ST_3035;
		case LDEditPart.VISUAL_ID:
			return LD_3036;
		case OtherEditPart.VISUAL_ID:
			return Other_3037;
		case InputWithEditPart.VISUAL_ID:
			return InputWith_4001;
		case OutputWithEditPart.VISUAL_ID:
			return OutputWith_4002;
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return FBFBDataConnection_4005;
		}
		return null;
	}

}
