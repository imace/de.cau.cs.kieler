package edu.unikiel.rtsys.kieler.ssm.diagram.providers;

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

import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineDiagramEditorPlugin;

/**
 * @generated
 */
public class SafeStateMachineElementTypes extends ElementInitializers {

    /**
     * @generated
     */
    private SafeStateMachineElementTypes() {
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
    public static final IElementType SafeStateMachine_1000 = getElementType("edu.unikiel.rtsys.kieler.ssm.gmf.diagram.SafeStateMachine_1000"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType CompositeState_2001 = getElementType("edu.unikiel.rtsys.kieler.ssm.gmf.diagram.CompositeState_2001"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType Region_3001 = getElementType("edu.unikiel.rtsys.kieler.ssm.gmf.diagram.Region_3001"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType CompositeState_3002 = getElementType("edu.unikiel.rtsys.kieler.ssm.gmf.diagram.CompositeState_3002"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType SimpleState_3003 = getElementType("edu.unikiel.rtsys.kieler.ssm.gmf.diagram.SimpleState_3003"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType InitialState_3004 = getElementType("edu.unikiel.rtsys.kieler.ssm.gmf.diagram.InitialState_3004"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType StrongAbortion_4001 = getElementType("edu.unikiel.rtsys.kieler.ssm.gmf.diagram.StrongAbortion_4001"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType NormalTermination_4002 = getElementType("edu.unikiel.rtsys.kieler.ssm.gmf.diagram.NormalTermination_4002"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType WeakAbortion_4003 = getElementType("edu.unikiel.rtsys.kieler.ssm.gmf.diagram.WeakAbortion_4003"); //$NON-NLS-1$

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
                return SafeStateMachineDiagramEditorPlugin.getInstance()
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

            elements.put(SafeStateMachine_1000,
                    edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                            .getSafeStateMachine());

            elements.put(CompositeState_2001,
                    edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                            .getCompositeState());

            elements.put(Region_3001,
                    edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                            .getRegion());

            elements.put(CompositeState_3002,
                    edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                            .getCompositeState());

            elements.put(SimpleState_3003,
                    edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                            .getSimpleState());

            elements.put(InitialState_3004,
                    edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                            .getInitialState());

            elements.put(StrongAbortion_4001,
                    edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                            .getStrongAbortion());

            elements.put(NormalTermination_4002,
                    edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                            .getNormalTermination());

            elements.put(WeakAbortion_4003,
                    edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                            .getWeakAbortion());
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
            KNOWN_ELEMENT_TYPES.add(SafeStateMachine_1000);
            KNOWN_ELEMENT_TYPES.add(CompositeState_2001);
            KNOWN_ELEMENT_TYPES.add(Region_3001);
            KNOWN_ELEMENT_TYPES.add(CompositeState_3002);
            KNOWN_ELEMENT_TYPES.add(SimpleState_3003);
            KNOWN_ELEMENT_TYPES.add(InitialState_3004);
            KNOWN_ELEMENT_TYPES.add(StrongAbortion_4001);
            KNOWN_ELEMENT_TYPES.add(NormalTermination_4002);
            KNOWN_ELEMENT_TYPES.add(WeakAbortion_4003);
        }
        return KNOWN_ELEMENT_TYPES.contains(elementType);
    }

}
