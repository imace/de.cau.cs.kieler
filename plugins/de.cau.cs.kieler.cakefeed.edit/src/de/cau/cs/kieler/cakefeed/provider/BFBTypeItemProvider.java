/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.provider;


import de.cau.cs.kieler.cakefeed.BFBType;
import de.cau.cs.kieler.cakefeed.CakefeedFactory;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;

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
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.cau.cs.kieler.cakefeed.BFBType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BFBTypeItemProvider
	extends FBTypeItemProvider
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
	public BFBTypeItemProvider(AdapterFactory adapterFactory) {
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

			addSyncChartPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Sync Chart feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSyncChartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BFBType_syncChart_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BFBType_syncChart_feature", "_UI_BFBType_type"),
				 CakefeedPackage.Literals.BFB_TYPE__SYNC_CHART,
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
			childrenFeatures.add(CakefeedPackage.Literals.BFB_TYPE__SERVICE);
			childrenFeatures.add(CakefeedPackage.Literals.BFB_TYPE__INTERNAL_VARS);
			childrenFeatures.add(CakefeedPackage.Literals.BFB_TYPE__FUNCTION_BLOCK_DIAGRAMS);
			childrenFeatures.add(CakefeedPackage.Literals.BFB_TYPE__STS);
			childrenFeatures.add(CakefeedPackage.Literals.BFB_TYPE__LADDER_DIAGRAMS);
			childrenFeatures.add(CakefeedPackage.Literals.BFB_TYPE__OTHER_ALGORITHMS);
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
	 * This returns BFBType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BFBType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((BFBType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_BFBType_type") :
			getString("_UI_BFBType_type") + " " + label;
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

		switch (notification.getFeatureID(BFBType.class)) {
			case CakefeedPackage.BFB_TYPE__SERVICE:
			case CakefeedPackage.BFB_TYPE__INTERNAL_VARS:
			case CakefeedPackage.BFB_TYPE__FUNCTION_BLOCK_DIAGRAMS:
			case CakefeedPackage.BFB_TYPE__STS:
			case CakefeedPackage.BFB_TYPE__LADDER_DIAGRAMS:
			case CakefeedPackage.BFB_TYPE__OTHER_ALGORITHMS:
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
				(CakefeedPackage.Literals.BFB_TYPE__SERVICE,
				 CakefeedFactory.eINSTANCE.createService()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.BFB_TYPE__INTERNAL_VARS,
				 CakefeedFactory.eINSTANCE.createInternalVar()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.BFB_TYPE__FUNCTION_BLOCK_DIAGRAMS,
				 CakefeedFactory.eINSTANCE.createFBD()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.BFB_TYPE__STS,
				 CakefeedFactory.eINSTANCE.createST()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.BFB_TYPE__LADDER_DIAGRAMS,
				 CakefeedFactory.eINSTANCE.createLD()));

		newChildDescriptors.add
			(createChildParameter
				(CakefeedPackage.Literals.BFB_TYPE__OTHER_ALGORITHMS,
				 CakefeedFactory.eINSTANCE.createOther()));
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

}
