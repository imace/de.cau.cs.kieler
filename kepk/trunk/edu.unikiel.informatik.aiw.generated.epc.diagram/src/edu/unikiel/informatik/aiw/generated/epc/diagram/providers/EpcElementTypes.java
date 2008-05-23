package edu.unikiel.informatik.aiw.generated.epc.diagram.providers;

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
import edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcDiagramEditorPlugin;

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
	public static final IElementType EPC_79 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.EPC_79"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AND_1001 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.AND_1001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OR_1002 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.OR_1002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Information_1003 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.Information_1003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType XOR_1004 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.XOR_1004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Event_1005 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.Event_1005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EPC_1006 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.EPC_1006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Function_1007 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.Function_1007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TriggersEvent_3001 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.TriggersEvent_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ProvidesDataTo_3002 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.ProvidesDataTo_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType WritesDataTo_3003 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.WritesDataTo_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ActivatesFunction_3004 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.ActivatesFunction_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EventToOperatorConnection_3005 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.EventToOperatorConnection_3005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FunctionToOperatorConnection_3006 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.FunctionToOperatorConnection_3006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OperatorToEventConnection_3007 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.OperatorToEventConnection_3007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OperatorToFunctionConnection_3008 = getElementType("edu.unikiel.informatik.aiw.generated.epc.diagram.OperatorToFunctionConnection_3008"); //$NON-NLS-1$

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
				return EpcDiagramEditorPlugin.getInstance()
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

			elements.put(AND_1001, EpcPackage.eINSTANCE.getAND());

			elements.put(OR_1002, EpcPackage.eINSTANCE.getOR());

			elements.put(Information_1003, EpcPackage.eINSTANCE
					.getInformation());

			elements.put(XOR_1004, EpcPackage.eINSTANCE.getXOR());

			elements.put(Event_1005, EpcPackage.eINSTANCE.getEvent());

			elements.put(EPC_1006, EpcPackage.eINSTANCE.getEPC());

			elements.put(Function_1007, EpcPackage.eINSTANCE.getFunction());

			elements.put(TriggersEvent_3001, EpcPackage.eINSTANCE
					.getTriggersEvent());

			elements.put(ProvidesDataTo_3002, EpcPackage.eINSTANCE
					.getProvidesDataTo());

			elements.put(WritesDataTo_3003, EpcPackage.eINSTANCE
					.getWritesDataTo());

			elements.put(ActivatesFunction_3004, EpcPackage.eINSTANCE
					.getActivatesFunction());

			elements.put(EventToOperatorConnection_3005, EpcPackage.eINSTANCE
					.getEventToOperatorConnection());

			elements.put(FunctionToOperatorConnection_3006,
					EpcPackage.eINSTANCE.getFunctionToOperatorConnection());

			elements.put(OperatorToEventConnection_3007, EpcPackage.eINSTANCE
					.getOperatorToEventConnection());

			elements.put(OperatorToFunctionConnection_3008,
					EpcPackage.eINSTANCE.getOperatorToFunctionConnection());
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
			KNOWN_ELEMENT_TYPES.add(AND_1001);
			KNOWN_ELEMENT_TYPES.add(OR_1002);
			KNOWN_ELEMENT_TYPES.add(Information_1003);
			KNOWN_ELEMENT_TYPES.add(XOR_1004);
			KNOWN_ELEMENT_TYPES.add(Event_1005);
			KNOWN_ELEMENT_TYPES.add(EPC_1006);
			KNOWN_ELEMENT_TYPES.add(Function_1007);
			KNOWN_ELEMENT_TYPES.add(TriggersEvent_3001);
			KNOWN_ELEMENT_TYPES.add(ProvidesDataTo_3002);
			KNOWN_ELEMENT_TYPES.add(WritesDataTo_3003);
			KNOWN_ELEMENT_TYPES.add(ActivatesFunction_3004);
			KNOWN_ELEMENT_TYPES.add(EventToOperatorConnection_3005);
			KNOWN_ELEMENT_TYPES.add(FunctionToOperatorConnection_3006);
			KNOWN_ELEMENT_TYPES.add(OperatorToEventConnection_3007);
			KNOWN_ELEMENT_TYPES.add(OperatorToFunctionConnection_3008);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
