package de.cau.cs.rtprak.graphs.diagram.providers;

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

import de.cau.cs.rtprak.graphs.GraphsPackage;
import de.cau.cs.rtprak.graphs.diagram.edit.parts.CompoundNode2EditPart;
import de.cau.cs.rtprak.graphs.diagram.edit.parts.CompoundNodeEditPart;
import de.cau.cs.rtprak.graphs.diagram.edit.parts.EdgeEditPart;
import de.cau.cs.rtprak.graphs.diagram.edit.parts.GraphEditPart;
import de.cau.cs.rtprak.graphs.diagram.edit.parts.Node2EditPart;
import de.cau.cs.rtprak.graphs.diagram.edit.parts.NodeEditPart;
import de.cau.cs.rtprak.graphs.diagram.part.GraphsDiagramEditorPlugin;

/**
 * @generated
 */
public class GraphsElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private GraphsElementTypes() {
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
	public static final IElementType Graph_1000 = getElementType("de.cau.cs.rtprak.graphs.diagram.Graph_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Node_2001 = getElementType("de.cau.cs.rtprak.graphs.diagram.Node_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType CompoundNode_2002 = getElementType("de.cau.cs.rtprak.graphs.diagram.CompoundNode_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Node_3001 = getElementType("de.cau.cs.rtprak.graphs.diagram.Node_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType CompoundNode_3002 = getElementType("de.cau.cs.rtprak.graphs.diagram.CompoundNode_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Edge_4001 = getElementType("de.cau.cs.rtprak.graphs.diagram.Edge_4001"); //$NON-NLS-1$

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
				return GraphsDiagramEditorPlugin.getInstance()
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

			elements.put(Graph_1000, GraphsPackage.eINSTANCE.getGraph());

			elements.put(Node_2001, GraphsPackage.eINSTANCE.getNode());

			elements.put(CompoundNode_2002, GraphsPackage.eINSTANCE
					.getCompoundNode());

			elements.put(Node_3001, GraphsPackage.eINSTANCE.getNode());

			elements.put(CompoundNode_3002, GraphsPackage.eINSTANCE
					.getCompoundNode());

			elements.put(Edge_4001, GraphsPackage.eINSTANCE.getEdge());
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
			KNOWN_ELEMENT_TYPES.add(Graph_1000);
			KNOWN_ELEMENT_TYPES.add(Node_2001);
			KNOWN_ELEMENT_TYPES.add(CompoundNode_2002);
			KNOWN_ELEMENT_TYPES.add(Node_3001);
			KNOWN_ELEMENT_TYPES.add(CompoundNode_3002);
			KNOWN_ELEMENT_TYPES.add(Edge_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case GraphEditPart.VISUAL_ID:
			return Graph_1000;
		case NodeEditPart.VISUAL_ID:
			return Node_2001;
		case CompoundNodeEditPart.VISUAL_ID:
			return CompoundNode_2002;
		case Node2EditPart.VISUAL_ID:
			return Node_3001;
		case CompoundNode2EditPart.VISUAL_ID:
			return CompoundNode_3002;
		case EdgeEditPart.VISUAL_ID:
			return Edge_4001;
		}
		return null;
	}

}
