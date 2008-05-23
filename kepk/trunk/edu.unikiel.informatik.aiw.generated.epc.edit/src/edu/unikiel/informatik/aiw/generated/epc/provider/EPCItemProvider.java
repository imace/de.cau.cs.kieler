/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc.provider;


import edu.unikiel.informatik.aiw.generated.epc.EPC;
import edu.unikiel.informatik.aiw.generated.epc.EpcFactory;
import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.unikiel.informatik.aiw.generated.epc.EPC} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EPCItemProvider
	extends FunctionItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPCItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EpcPackage.Literals.EPC__CONNECTORS);
			childrenFeatures.add(EpcPackage.Literals.EPC__OBJECTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns EPC.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EPC"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((EPC)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_EPC_type") :
			getString("_UI_EPC_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(EPC.class)) {
			case EpcPackage.EPC__CONNECTORS:
			case EpcPackage.EPC__OBJECTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__CONNECTORS,
				 EpcFactory.eINSTANCE.createTriggersEvent()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__CONNECTORS,
				 EpcFactory.eINSTANCE.createActivatesFunction()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__CONNECTORS,
				 EpcFactory.eINSTANCE.createProvidesDataTo()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__CONNECTORS,
				 EpcFactory.eINSTANCE.createWritesDataTo()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__CONNECTORS,
				 EpcFactory.eINSTANCE.createFunctionToOperatorConnection()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__CONNECTORS,
				 EpcFactory.eINSTANCE.createEventToOperatorConnection()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__CONNECTORS,
				 EpcFactory.eINSTANCE.createOperatorToFunctionConnection()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__CONNECTORS,
				 EpcFactory.eINSTANCE.createOperatorToEventConnection()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__CONNECTORS,
				 EpcFactory.eINSTANCE.createGCTLconnector()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__OBJECTS,
				 EpcFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__OBJECTS,
				 EpcFactory.eINSTANCE.createEPC()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__OBJECTS,
				 EpcFactory.eINSTANCE.createEvent()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__OBJECTS,
				 EpcFactory.eINSTANCE.createXOR()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__OBJECTS,
				 EpcFactory.eINSTANCE.createOR()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__OBJECTS,
				 EpcFactory.eINSTANCE.createAND()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__OBJECTS,
				 EpcFactory.eINSTANCE.createInformation()));

		newChildDescriptors.add
			(createChildParameter
				(EpcPackage.Literals.EPC__OBJECTS,
				 EpcFactory.eINSTANCE.createImplication()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return EpcEditPlugin.INSTANCE;
	}

}
