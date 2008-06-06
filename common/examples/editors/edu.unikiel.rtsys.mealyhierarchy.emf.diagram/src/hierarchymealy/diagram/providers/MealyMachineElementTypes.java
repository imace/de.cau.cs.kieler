package hierarchymealy.diagram.providers;

import hierarchymealy.MealyPackage;
import hierarchymealy.diagram.part.MealyMachineDiagramEditorPlugin;

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

/**
 * @generated
 */
public class MealyMachineElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private MealyMachineElementTypes() {
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
	public static final IElementType HierarchyMealyMachine_1000 = getElementType("edu.unikiel.rtsys.mealyhierarchy.emf.diagram.HierarchyMealyMachine_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType CompositeState_2001 = getElementType("edu.unikiel.rtsys.mealyhierarchy.emf.diagram.CompositeState_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType State_2002 = getElementType("edu.unikiel.rtsys.mealyhierarchy.emf.diagram.State_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType State_3001 = getElementType("edu.unikiel.rtsys.mealyhierarchy.emf.diagram.State_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType CompositeState_3002 = getElementType("edu.unikiel.rtsys.mealyhierarchy.emf.diagram.CompositeState_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Edge_4001 = getElementType("edu.unikiel.rtsys.mealyhierarchy.emf.diagram.Edge_4001"); //$NON-NLS-1$

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
				return MealyMachineDiagramEditorPlugin.getInstance()
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

			elements.put(HierarchyMealyMachine_1000, MealyPackage.eINSTANCE
					.getHierarchyMealyMachine());

			elements.put(CompositeState_2001, MealyPackage.eINSTANCE
					.getCompositeState());

			elements.put(State_2002, MealyPackage.eINSTANCE.getState());

			elements.put(State_3001, MealyPackage.eINSTANCE.getState());

			elements.put(CompositeState_3002, MealyPackage.eINSTANCE
					.getCompositeState());

			elements.put(Edge_4001, MealyPackage.eINSTANCE.getEdge());
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
			KNOWN_ELEMENT_TYPES.add(HierarchyMealyMachine_1000);
			KNOWN_ELEMENT_TYPES.add(CompositeState_2001);
			KNOWN_ELEMENT_TYPES.add(State_2002);
			KNOWN_ELEMENT_TYPES.add(State_3001);
			KNOWN_ELEMENT_TYPES.add(CompositeState_3002);
			KNOWN_ELEMENT_TYPES.add(Edge_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
