/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.provider;


import de.cau.cs.kieler.cakefeed.CakefeedFactory;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FBInterface;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.cau.cs.kieler.cakefeed.FBInterface} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FBInterfaceItemProvider
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
	public FBInterfaceItemProvider(AdapterFactory adapterFactory) {
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
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CakefeedPackage.Literals.FB_INTERFACE__INPUT_EVENTS);
			childrenFeatures.add(CakefeedPackage.Literals.FB_INTERFACE__OUTPUT_EVENTS);
			childrenFeatures.add(CakefeedPackage.Literals.FB_INTERFACE__INPUT_VARS);
			childrenFeatures.add(CakefeedPackage.Literals.FB_INTERFACE__OUTPUT_VARS);
			childrenFeatures.add(CakefeedPackage.Literals.FB_INTERFACE__SOCKETS);
			childrenFeatures.add(CakefeedPackage.Literals.FB_INTERFACE__PLUGS);
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
	 * This returns FBInterface.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FBInterface"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_FBInterface_type");
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

		switch (notification.getFeatureID(FBInterface.class)) {
			case CakefeedPackage.FB_INTERFACE__INPUT_EVENTS:
			case CakefeedPackage.FB_INTERFACE__OUTPUT_EVENTS:
			case CakefeedPackage.FB_INTERFACE__INPUT_VARS:
			case CakefeedPackage.FB_INTERFACE__OUTPUT_VARS:
			case CakefeedPackage.FB_INTERFACE__SOCKETS:
			case CakefeedPackage.FB_INTERFACE__PLUGS:
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
				(CakefeedPackage.Literals.FB_INTERFACE__INPUT_EVENTS,
				 CakefeedFactory.eINSTANCE.createIFInputEvent()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_INTERFACE__OUTPUT_EVENTS,
				 CakefeedFactory.eINSTANCE.createIFOutputEvent()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_INTERFACE__INPUT_VARS,
				 CakefeedFactory.eINSTANCE.createIFInputVar()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_INTERFACE__OUTPUT_VARS,
				 CakefeedFactory.eINSTANCE.createIFOutputVar()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_INTERFACE__SOCKETS,
				 CakefeedFactory.eINSTANCE.createSocket()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_INTERFACE__SOCKETS,
				 CakefeedFactory.eINSTANCE.createPlug()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_INTERFACE__PLUGS,
				 CakefeedFactory.eINSTANCE.createSocket()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.FB_INTERFACE__PLUGS,
				 CakefeedFactory.eINSTANCE.createPlug()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == CakefeedPackage.Literals.FB_INTERFACE__SOCKETS ||
			childFeature == CakefeedPackage.Literals.FB_INTERFACE__PLUGS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
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
