/**
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 * 
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 *
 * $Id$
 */
package de.cau.cs.kieler.synccharts.provider;


import de.cau.cs.kieler.synccharts.Signal;
import de.cau.cs.kieler.synccharts.SyncchartsFactory;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.cau.cs.kieler.synccharts.Signal} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SignalItemProvider
	extends ValuedObjectItemProvider
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
	public SignalItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addIsInputPropertyDescriptor(object);
			addIsOutputPropertyDescriptor(object);
			addCombineOperatorPropertyDescriptor(object);
			addHostCombineOperatorPropertyDescriptor(object);
			addParentScopePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Input feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsInputPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Signal_isInput_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Signal_isInput_feature", "_UI_Signal_type"),
				 SyncchartsPackage.Literals.SIGNAL__IS_INPUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Output feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsOutputPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Signal_isOutput_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Signal_isOutput_feature", "_UI_Signal_type"),
				 SyncchartsPackage.Literals.SIGNAL__IS_OUTPUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Combine Operator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCombineOperatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Signal_combineOperator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Signal_combineOperator_feature", "_UI_Signal_type"),
				 SyncchartsPackage.Literals.SIGNAL__COMBINE_OPERATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Host Combine Operator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHostCombineOperatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Signal_hostCombineOperator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Signal_hostCombineOperator_feature", "_UI_Signal_type"),
				 SyncchartsPackage.Literals.SIGNAL__HOST_COMBINE_OPERATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parent Scope feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentScopePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Signal_parentScope_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Signal_parentScope_feature", "_UI_Signal_type"),
				 SyncchartsPackage.Literals.SIGNAL__PARENT_SCOPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SyncchartsPackage.Literals.SIGNAL__VALUE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Signal.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Signal"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Signal)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Signal_type") :
			getString("_UI_Signal_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Signal.class)) {
			case SyncchartsPackage.SIGNAL__IS_INPUT:
			case SyncchartsPackage.SIGNAL__IS_OUTPUT:
			case SyncchartsPackage.SIGNAL__COMBINE_OPERATOR:
			case SyncchartsPackage.SIGNAL__HOST_COMBINE_OPERATOR:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SyncchartsPackage.SIGNAL__VALUE:
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
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createAction()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createComplexExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createEmission()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createTextualCode()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createRegion()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createValuedObject()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createSignal()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createSignalReference()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createState()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createVariableReference()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createValue()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createIntValue()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createFloatValue()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createBooleanValue()));

		newChildDescriptors.add
			(createChildParameter
				(SyncchartsPackage.Literals.SIGNAL__VALUE,
				 SyncchartsFactory.eINSTANCE.createOperatorExpression()));
	}

}
