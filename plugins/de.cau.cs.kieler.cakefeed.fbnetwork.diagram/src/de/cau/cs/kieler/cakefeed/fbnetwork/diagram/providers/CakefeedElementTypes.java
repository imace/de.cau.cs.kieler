package de.cau.cs.kieler.cakefeed.fbnetwork.diagram.providers;

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
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBNetworkEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part.CakefeedDiagramEditorPlugin;

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
	public static final IElementType FBNetwork_1000 = getElementType("de.cau.cs.kieler.cakefeed.fbnetwork.diagram.FBNetwork_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FB_2001 = getElementType("de.cau.cs.kieler.cakefeed.fbnetwork.diagram.FB_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBInputEvent_3001 = getElementType("de.cau.cs.kieler.cakefeed.fbnetwork.diagram.FBInputEvent_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBOutputEvent_3002 = getElementType("de.cau.cs.kieler.cakefeed.fbnetwork.diagram.FBOutputEvent_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBInputVar_3003 = getElementType("de.cau.cs.kieler.cakefeed.fbnetwork.diagram.FBInputVar_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBOutputVar_3004 = getElementType("de.cau.cs.kieler.cakefeed.fbnetwork.diagram.FBOutputVar_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBFBEventConnection_4001 = getElementType("de.cau.cs.kieler.cakefeed.fbnetwork.diagram.FBFBEventConnection_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBFBDataConnection_4002 = getElementType("de.cau.cs.kieler.cakefeed.fbnetwork.diagram.FBFBDataConnection_4002"); //$NON-NLS-1$

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

			elements.put(FBNetwork_1000, CakefeedPackage.eINSTANCE
					.getFBNetwork());

			elements.put(FB_2001, CakefeedPackage.eINSTANCE.getFB());

			elements.put(FBInputEvent_3001, CakefeedPackage.eINSTANCE
					.getFBInputEvent());

			elements.put(FBOutputEvent_3002, CakefeedPackage.eINSTANCE
					.getFBOutputEvent());

			elements.put(FBInputVar_3003, CakefeedPackage.eINSTANCE
					.getFBInputVar());

			elements.put(FBOutputVar_3004, CakefeedPackage.eINSTANCE
					.getFBOutputVar());

			elements.put(FBFBEventConnection_4001, CakefeedPackage.eINSTANCE
					.getFBFBEventConnection());

			elements.put(FBFBDataConnection_4002, CakefeedPackage.eINSTANCE
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
			KNOWN_ELEMENT_TYPES.add(FBNetwork_1000);
			KNOWN_ELEMENT_TYPES.add(FB_2001);
			KNOWN_ELEMENT_TYPES.add(FBInputEvent_3001);
			KNOWN_ELEMENT_TYPES.add(FBOutputEvent_3002);
			KNOWN_ELEMENT_TYPES.add(FBInputVar_3003);
			KNOWN_ELEMENT_TYPES.add(FBOutputVar_3004);
			KNOWN_ELEMENT_TYPES.add(FBFBEventConnection_4001);
			KNOWN_ELEMENT_TYPES.add(FBFBDataConnection_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case FBNetworkEditPart.VISUAL_ID:
			return FBNetwork_1000;
		case FBEditPart.VISUAL_ID:
			return FB_2001;
		case FBInputEventEditPart.VISUAL_ID:
			return FBInputEvent_3001;
		case FBOutputEventEditPart.VISUAL_ID:
			return FBOutputEvent_3002;
		case FBInputVarEditPart.VISUAL_ID:
			return FBInputVar_3003;
		case FBOutputVarEditPart.VISUAL_ID:
			return FBOutputVar_3004;
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return FBFBEventConnection_4001;
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return FBFBDataConnection_4002;
		}
		return null;
	}

}
