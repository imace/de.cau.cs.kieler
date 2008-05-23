package edu.unikiel.informatik.aiw.generated.gctl.diagram.providers;

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

import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.part.GctlDiagramEditorPlugin;

/**
 * @generated
 */
public class EpcElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private EpcElementTypes() {
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
	public static final IElementType EPC_79 = getElementType("edu.unikiel.informatik.aiw.generated.gctl.diagram.EPC_79"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Function_1001 = getElementType("edu.unikiel.informatik.aiw.generated.gctl.diagram.Function_1001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Event_1002 = getElementType("edu.unikiel.informatik.aiw.generated.gctl.diagram.Event_1002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Information_1003 = getElementType("edu.unikiel.informatik.aiw.generated.gctl.diagram.Information_1003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EPC_1004 = getElementType("edu.unikiel.informatik.aiw.generated.gctl.diagram.EPC_1004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Implication_1005 = getElementType("edu.unikiel.informatik.aiw.generated.gctl.diagram.Implication_1005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType GCTLconnector_3001 = getElementType("edu.unikiel.informatik.aiw.generated.gctl.diagram.GCTLconnector_3001"); //$NON-NLS-1$

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
				return GctlDiagramEditorPlugin.getInstance()
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

			elements.put(EPC_79, EpcPackage.eINSTANCE.getEPC());

			elements.put(Function_1001, EpcPackage.eINSTANCE.getFunction());

			elements.put(Event_1002, EpcPackage.eINSTANCE.getEvent());

			elements.put(Information_1003, EpcPackage.eINSTANCE
					.getInformation());

			elements.put(EPC_1004, EpcPackage.eINSTANCE.getEPC());

			elements.put(Implication_1005, EpcPackage.eINSTANCE
					.getImplication());

			elements.put(GCTLconnector_3001, EpcPackage.eINSTANCE
					.getGCTLconnector());
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
			KNOWN_ELEMENT_TYPES.add(EPC_79);
			KNOWN_ELEMENT_TYPES.add(Function_1001);
			KNOWN_ELEMENT_TYPES.add(Event_1002);
			KNOWN_ELEMENT_TYPES.add(Information_1003);
			KNOWN_ELEMENT_TYPES.add(EPC_1004);
			KNOWN_ELEMENT_TYPES.add(Implication_1005);
			KNOWN_ELEMENT_TYPES.add(GCTLconnector_3001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
