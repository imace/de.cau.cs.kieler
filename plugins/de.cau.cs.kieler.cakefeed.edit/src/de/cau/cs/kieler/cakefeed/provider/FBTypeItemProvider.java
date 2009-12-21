/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.provider;


import de.cau.cs.kieler.cakefeed.CakefeedFactory;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FBType;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.cau.cs.kieler.cakefeed.FBType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FBTypeItemProvider
	extends ItemProviderAdapter
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
	public FBTypeItemProvider(AdapterFactory adapterFactory) {
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

			addCommentPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Comment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCommentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FBType_Comment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FBType_Comment_feature", "_UI_FBType_type"),
				 CakefeedPackage.Literals.FB_TYPE__COMMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FBType_Name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FBType_Name_feature", "_UI_FBType_type"),
				 CakefeedPackage.Literals.FB_TYPE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(CakefeedPackage.Literals.FB_TYPE__IDENTIFICATION);
			childrenFeatures.add(CakefeedPackage.Literals.FB_TYPE__VERSION_INFO);
			childrenFeatures.add(CakefeedPackage.Literals.FB_TYPE__COMPILER_INFO);
			childrenFeatures.add(CakefeedPackage.Literals.FB_TYPE__INPUT_EVENTS);
			childrenFeatures.add(CakefeedPackage.Literals.FB_TYPE__OUTPUT_EVENTS);
			childrenFeatures.add(CakefeedPackage.Literals.FB_TYPE__INPUT_VARS);
			childrenFeatures.add(CakefeedPackage.Literals.FB_TYPE__OUTPUT_VARS);
			childrenFeatures.add(CakefeedPackage.Literals.FB_TYPE__SOCKETS);
			childrenFeatures.add(CakefeedPackage.Literals.FB_TYPE__PLUGS);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((FBType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_FBType_type") :
			getString("_UI_FBType_type") + " " + label;
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

		switch (notification.getFeatureID(FBType.class)) {
			case CakefeedPackage.FB_TYPE__COMMENT:
			case CakefeedPackage.FB_TYPE__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CakefeedPackage.FB_TYPE__IDENTIFICATION:
			case CakefeedPackage.FB_TYPE__VERSION_INFO:
			case CakefeedPackage.FB_TYPE__COMPILER_INFO:
			case CakefeedPackage.FB_TYPE__INPUT_EVENTS:
			case CakefeedPackage.FB_TYPE__OUTPUT_EVENTS:
			case CakefeedPackage.FB_TYPE__INPUT_VARS:
			case CakefeedPackage.FB_TYPE__OUTPUT_VARS:
			case CakefeedPackage.FB_TYPE__SOCKETS:
			case CakefeedPackage.FB_TYPE__PLUGS:
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
				(CakefeedPackage.Literals.FB_TYPE__IDENTIFICATION,
				 CakefeedFactory.eINSTANCE.createIdentification()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_TYPE__VERSION_INFO,
				 CakefeedFactory.eINSTANCE.createVersionInfo()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_TYPE__COMPILER_INFO,
				 CakefeedFactory.eINSTANCE.createCompilerInfo()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_TYPE__INPUT_EVENTS,
				 CakefeedFactory.eINSTANCE.createIFInputEvent()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_TYPE__OUTPUT_EVENTS,
				 CakefeedFactory.eINSTANCE.createIFOutputEvent()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_TYPE__INPUT_VARS,
				 CakefeedFactory.eINSTANCE.createIFInputVar()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_TYPE__OUTPUT_VARS,
				 CakefeedFactory.eINSTANCE.createIFOutputVar()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_TYPE__SOCKETS,
				 CakefeedFactory.eINSTANCE.createSocket()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_TYPE__PLUGS,
				 CakefeedFactory.eINSTANCE.createPlug()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CakefeedEditPlugin.INSTANCE;
	}

}
