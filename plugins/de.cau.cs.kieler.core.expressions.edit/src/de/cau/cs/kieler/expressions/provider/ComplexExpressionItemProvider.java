/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.expressions.provider;


import de.cau.cs.kieler.expressions.ComplexExpression;
import de.cau.cs.kieler.expressions.ExpressionsFactory;
import de.cau.cs.kieler.expressions.ExpressionsPackage;

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
 * This is the item provider adapter for a {@link de.cau.cs.kieler.expressions.ComplexExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComplexExpressionItemProvider
    extends ExpressionItemProvider
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
    public ComplexExpressionItemProvider(AdapterFactory adapterFactory) {
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
            childrenFeatures.add(ExpressionsPackage.Literals.COMPLEX_EXPRESSION__SUB_EXPRESSIONS);
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
     * This returns ComplexExpression.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ComplexExpression"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        return getString("_UI_ComplexExpression_type");
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

        switch (notification.getFeatureID(ComplexExpression.class)) {
            case ExpressionsPackage.COMPLEX_EXPRESSION__SUB_EXPRESSIONS:
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
                (ExpressionsPackage.Literals.COMPLEX_EXPRESSION__SUB_EXPRESSIONS,
                 ExpressionsFactory.eINSTANCE.createExpression()));

        newChildDescriptors.add
            (createChildParameter
                (ExpressionsPackage.Literals.COMPLEX_EXPRESSION__SUB_EXPRESSIONS,
                 ExpressionsFactory.eINSTANCE.createComplexExpression()));

        newChildDescriptors.add
            (createChildParameter
                (ExpressionsPackage.Literals.COMPLEX_EXPRESSION__SUB_EXPRESSIONS,
                 ExpressionsFactory.eINSTANCE.createSignalReference()));

        newChildDescriptors.add
            (createChildParameter
                (ExpressionsPackage.Literals.COMPLEX_EXPRESSION__SUB_EXPRESSIONS,
                 ExpressionsFactory.eINSTANCE.createVariableReference()));

        newChildDescriptors.add
            (createChildParameter
                (ExpressionsPackage.Literals.COMPLEX_EXPRESSION__SUB_EXPRESSIONS,
                 ExpressionsFactory.eINSTANCE.createValue()));

        newChildDescriptors.add
            (createChildParameter
                (ExpressionsPackage.Literals.COMPLEX_EXPRESSION__SUB_EXPRESSIONS,
                 ExpressionsFactory.eINSTANCE.createIntValue()));

        newChildDescriptors.add
            (createChildParameter
                (ExpressionsPackage.Literals.COMPLEX_EXPRESSION__SUB_EXPRESSIONS,
                 ExpressionsFactory.eINSTANCE.createFloatValue()));

        newChildDescriptors.add
            (createChildParameter
                (ExpressionsPackage.Literals.COMPLEX_EXPRESSION__SUB_EXPRESSIONS,
                 ExpressionsFactory.eINSTANCE.createBooleanValue()));

        newChildDescriptors.add
            (createChildParameter
                (ExpressionsPackage.Literals.COMPLEX_EXPRESSION__SUB_EXPRESSIONS,
                 ExpressionsFactory.eINSTANCE.createOperatorExpression()));

        newChildDescriptors.add
            (createChildParameter
                (ExpressionsPackage.Literals.COMPLEX_EXPRESSION__SUB_EXPRESSIONS,
                 ExpressionsFactory.eINSTANCE.createTextExpression()));
    }

}
