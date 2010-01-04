package de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers;

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
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBDiagramEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBIFDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBIFEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFIFDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFIFEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.InputWithEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.OutputWithEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedDiagramEditorPlugin;

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
	public static final IElementType CFBDiagram_1000 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.CFBDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType CFBType_2001 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.CFBType_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFInputEvent_3012 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.IFInputEvent_3012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFOutputEvent_3013 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.IFOutputEvent_3013"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFInputVar_3014 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.IFInputVar_3014"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFOutputVar_3015 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.IFOutputVar_3015"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FB_3016 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.FB_3016"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBInputEvent_3017 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.FBInputEvent_3017"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBOutputEvent_3018 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.FBOutputEvent_3018"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBInputVar_3019 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.FBInputVar_3019"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBOutputVar_3020 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.FBOutputVar_3020"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InputWith_4001 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.InputWith_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OutputWith_4002 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.OutputWith_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFIFEventConnection_4007 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.IFIFEventConnection_4007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFFBEventConnection_4008 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.IFFBEventConnection_4008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBIFEventConnection_4009 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.FBIFEventConnection_4009"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBFBEventConnection_4010 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.FBFBEventConnection_4010"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFIFDataConnection_4011 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.IFIFDataConnection_4011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IFFBDataConnection_4012 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.IFFBDataConnection_4012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBIFDataConnection_4013 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.FBIFDataConnection_4013"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FBFBDataConnection_4014 = getElementType("de.cau.cs.kieler.cakefeed.cfbtype.diagram.FBFBDataConnection_4014"); //$NON-NLS-1$

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

			elements.put(CFBDiagram_1000, CakefeedPackage.eINSTANCE
					.getCFBDiagram());

			elements.put(CFBType_2001, CakefeedPackage.eINSTANCE.getCFBType());

			elements.put(IFInputEvent_3012, CakefeedPackage.eINSTANCE
					.getIFInputEvent());

			elements.put(IFOutputEvent_3013, CakefeedPackage.eINSTANCE
					.getIFOutputEvent());

			elements.put(IFInputVar_3014, CakefeedPackage.eINSTANCE
					.getIFInputVar());

			elements.put(IFOutputVar_3015, CakefeedPackage.eINSTANCE
					.getIFOutputVar());

			elements.put(FB_3016, CakefeedPackage.eINSTANCE.getFB());

			elements.put(FBInputEvent_3017, CakefeedPackage.eINSTANCE
					.getFBInputEvent());

			elements.put(FBOutputEvent_3018, CakefeedPackage.eINSTANCE
					.getFBOutputEvent());

			elements.put(FBInputVar_3019, CakefeedPackage.eINSTANCE
					.getFBInputVar());

			elements.put(FBOutputVar_3020, CakefeedPackage.eINSTANCE
					.getFBOutputVar());

			elements.put(InputWith_4001, CakefeedPackage.eINSTANCE
					.getInputWith());

			elements.put(OutputWith_4002, CakefeedPackage.eINSTANCE
					.getOutputWith());

			elements.put(IFIFEventConnection_4007, CakefeedPackage.eINSTANCE
					.getIFIFEventConnection());

			elements.put(IFFBEventConnection_4008, CakefeedPackage.eINSTANCE
					.getIFFBEventConnection());

			elements.put(FBIFEventConnection_4009, CakefeedPackage.eINSTANCE
					.getFBIFEventConnection());

			elements.put(FBFBEventConnection_4010, CakefeedPackage.eINSTANCE
					.getFBFBEventConnection());

			elements.put(IFIFDataConnection_4011, CakefeedPackage.eINSTANCE
					.getIFIFDataConnection());

			elements.put(IFFBDataConnection_4012, CakefeedPackage.eINSTANCE
					.getIFFBDataConnection());

			elements.put(FBIFDataConnection_4013, CakefeedPackage.eINSTANCE
					.getFBIFDataConnection());

			elements.put(FBFBDataConnection_4014, CakefeedPackage.eINSTANCE
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
			KNOWN_ELEMENT_TYPES.add(CFBDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(CFBType_2001);
			KNOWN_ELEMENT_TYPES.add(IFInputEvent_3012);
			KNOWN_ELEMENT_TYPES.add(IFOutputEvent_3013);
			KNOWN_ELEMENT_TYPES.add(IFInputVar_3014);
			KNOWN_ELEMENT_TYPES.add(IFOutputVar_3015);
			KNOWN_ELEMENT_TYPES.add(FB_3016);
			KNOWN_ELEMENT_TYPES.add(FBInputEvent_3017);
			KNOWN_ELEMENT_TYPES.add(FBOutputEvent_3018);
			KNOWN_ELEMENT_TYPES.add(FBInputVar_3019);
			KNOWN_ELEMENT_TYPES.add(FBOutputVar_3020);
			KNOWN_ELEMENT_TYPES.add(InputWith_4001);
			KNOWN_ELEMENT_TYPES.add(OutputWith_4002);
			KNOWN_ELEMENT_TYPES.add(IFIFEventConnection_4007);
			KNOWN_ELEMENT_TYPES.add(IFFBEventConnection_4008);
			KNOWN_ELEMENT_TYPES.add(FBIFEventConnection_4009);
			KNOWN_ELEMENT_TYPES.add(FBFBEventConnection_4010);
			KNOWN_ELEMENT_TYPES.add(IFIFDataConnection_4011);
			KNOWN_ELEMENT_TYPES.add(IFFBDataConnection_4012);
			KNOWN_ELEMENT_TYPES.add(FBIFDataConnection_4013);
			KNOWN_ELEMENT_TYPES.add(FBFBDataConnection_4014);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case CFBDiagramEditPart.VISUAL_ID:
			return CFBDiagram_1000;
		case CFBTypeEditPart.VISUAL_ID:
			return CFBType_2001;
		case IFInputEventEditPart.VISUAL_ID:
			return IFInputEvent_3012;
		case IFOutputEventEditPart.VISUAL_ID:
			return IFOutputEvent_3013;
		case IFInputVarEditPart.VISUAL_ID:
			return IFInputVar_3014;
		case IFOutputVarEditPart.VISUAL_ID:
			return IFOutputVar_3015;
		case FBEditPart.VISUAL_ID:
			return FB_3016;
		case FBInputEventEditPart.VISUAL_ID:
			return FBInputEvent_3017;
		case FBOutputEventEditPart.VISUAL_ID:
			return FBOutputEvent_3018;
		case FBInputVarEditPart.VISUAL_ID:
			return FBInputVar_3019;
		case FBOutputVarEditPart.VISUAL_ID:
			return FBOutputVar_3020;
		case InputWithEditPart.VISUAL_ID:
			return InputWith_4001;
		case OutputWithEditPart.VISUAL_ID:
			return OutputWith_4002;
		case IFIFEventConnectionEditPart.VISUAL_ID:
			return IFIFEventConnection_4007;
		case IFFBEventConnectionEditPart.VISUAL_ID:
			return IFFBEventConnection_4008;
		case FBIFEventConnectionEditPart.VISUAL_ID:
			return FBIFEventConnection_4009;
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return FBFBEventConnection_4010;
		case IFIFDataConnectionEditPart.VISUAL_ID:
			return IFIFDataConnection_4011;
		case IFFBDataConnectionEditPart.VISUAL_ID:
			return IFFBDataConnection_4012;
		case FBIFDataConnectionEditPart.VISUAL_ID:
			return FBIFDataConnection_4013;
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return FBFBDataConnection_4014;
		}
		return null;
	}

}
