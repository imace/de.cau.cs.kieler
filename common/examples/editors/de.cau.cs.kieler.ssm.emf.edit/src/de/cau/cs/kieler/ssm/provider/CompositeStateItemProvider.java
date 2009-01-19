/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.ssm.provider;


import de.cau.cs.kieler.ssm.CompositeState;
import de.cau.cs.kieler.ssm.ssmFactory;
import de.cau.cs.kieler.ssm.ssmPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.cau.cs.kieler.ssm.CompositeState} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositeStateItemProvider
    extends SimpleStateItemProvider
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
    public CompositeStateItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(ssmPackage.Literals.COMPOSITE_STATE__REGIONS);
			childrenFeatures.add(ssmPackage.Literals.COMPOSITE_STATE__LOCAL_SIGNALS);
			childrenFeatures.add(ssmPackage.Literals.COMPOSITE_STATE__INPUT_SIGNALS);
			childrenFeatures.add(ssmPackage.Literals.COMPOSITE_STATE__OUTPUT_SIGNALS);
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
	 * This returns CompositeState.gif.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CompositeState"));
	}

    /**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String getText(Object object) {
		String label = ((CompositeState)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_CompositeState_type") :
			getString("_UI_CompositeState_type") + " " + label;
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

		switch (notification.getFeatureID(CompositeState.class)) {
			case ssmPackage.COMPOSITE_STATE__REGIONS:
			case ssmPackage.COMPOSITE_STATE__LOCAL_SIGNALS:
			case ssmPackage.COMPOSITE_STATE__INPUT_SIGNALS:
			case ssmPackage.COMPOSITE_STATE__OUTPUT_SIGNALS:
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
				(ssmPackage.Literals.COMPOSITE_STATE__REGIONS,
				 ssmFactory.eINSTANCE.createRegion()));

		newChildDescriptors.add
			(createChildParameter
				(ssmPackage.Literals.COMPOSITE_STATE__LOCAL_SIGNALS,
				 ssmFactory.eINSTANCE.createSignal()));

		newChildDescriptors.add
			(createChildParameter
				(ssmPackage.Literals.COMPOSITE_STATE__LOCAL_SIGNALS,
				 ssmFactory.eINSTANCE.createIntegerSignal()));

		newChildDescriptors.add
			(createChildParameter
				(ssmPackage.Literals.COMPOSITE_STATE__INPUT_SIGNALS,
				 ssmFactory.eINSTANCE.createSignal()));

		newChildDescriptors.add
			(createChildParameter
				(ssmPackage.Literals.COMPOSITE_STATE__INPUT_SIGNALS,
				 ssmFactory.eINSTANCE.createIntegerSignal()));

		newChildDescriptors.add
			(createChildParameter
				(ssmPackage.Literals.COMPOSITE_STATE__OUTPUT_SIGNALS,
				 ssmFactory.eINSTANCE.createSignal()));

		newChildDescriptors.add
			(createChildParameter
				(ssmPackage.Literals.COMPOSITE_STATE__OUTPUT_SIGNALS,
				 ssmFactory.eINSTANCE.createIntegerSignal()));
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
			childFeature == ssmPackage.Literals.COMPOSITE_STATE__LOCAL_SIGNALS ||
			childFeature == ssmPackage.Literals.COMPOSITE_STATE__INPUT_SIGNALS ||
			childFeature == ssmPackage.Literals.COMPOSITE_STATE__OUTPUT_SIGNALS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
