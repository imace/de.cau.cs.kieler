/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.synccharts.provider;

import de.cau.cs.kieler.synccharts.util.SyncchartsAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SyncchartsItemProviderAdapterFactory extends SyncchartsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SyncchartsItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.Action} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ActionItemProvider actionItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.Action}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createActionAdapter() {
        if (actionItemProvider == null) {
            actionItemProvider = new ActionItemProvider(this);
        }

        return actionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.Assignment} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AssignmentItemProvider assignmentItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.Assignment}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createAssignmentAdapter() {
        if (assignmentItemProvider == null) {
            assignmentItemProvider = new AssignmentItemProvider(this);
        }

        return assignmentItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.ComplexExpression} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComplexExpressionItemProvider complexExpressionItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.ComplexExpression}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createComplexExpressionAdapter() {
        if (complexExpressionItemProvider == null) {
            complexExpressionItemProvider = new ComplexExpressionItemProvider(this);
        }

        return complexExpressionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.Emission} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EmissionItemProvider emissionItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.Emission}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createEmissionAdapter() {
        if (emissionItemProvider == null) {
            emissionItemProvider = new EmissionItemProvider(this);
        }

        return emissionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.Expression} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExpressionItemProvider expressionItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.Expression}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createExpressionAdapter() {
        if (expressionItemProvider == null) {
            expressionItemProvider = new ExpressionItemProvider(this);
        }

        return expressionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.HostCode} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HostCodeItemProvider hostCodeItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.HostCode}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createHostCodeAdapter() {
        if (hostCodeItemProvider == null) {
            hostCodeItemProvider = new HostCodeItemProvider(this);
        }

        return hostCodeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.Region} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RegionItemProvider regionItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.Region}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createRegionAdapter() {
        if (regionItemProvider == null) {
            regionItemProvider = new RegionItemProvider(this);
        }

        return regionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.Signal} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SignalItemProvider signalItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.Signal}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createSignalAdapter() {
        if (signalItemProvider == null) {
            signalItemProvider = new SignalItemProvider(this);
        }

        return signalItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.SignalReference} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SignalReferenceItemProvider signalReferenceItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.SignalReference}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createSignalReferenceAdapter() {
        if (signalReferenceItemProvider == null) {
            signalReferenceItemProvider = new SignalReferenceItemProvider(this);
        }

        return signalReferenceItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.SignalRenaming} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SignalRenamingItemProvider signalRenamingItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.SignalRenaming}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createSignalRenamingAdapter() {
        if (signalRenamingItemProvider == null) {
            signalRenamingItemProvider = new SignalRenamingItemProvider(this);
        }

        return signalRenamingItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.State} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StateItemProvider stateItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.State}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createStateAdapter() {
        if (stateItemProvider == null) {
            stateItemProvider = new StateItemProvider(this);
        }

        return stateItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.Transition} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TransitionItemProvider transitionItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.Transition}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTransitionAdapter() {
        if (transitionItemProvider == null) {
            transitionItemProvider = new TransitionItemProvider(this);
        }

        return transitionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.ValuedObject} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValuedObjectItemProvider valuedObjectItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.ValuedObject}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createValuedObjectAdapter() {
        if (valuedObjectItemProvider == null) {
            valuedObjectItemProvider = new ValuedObjectItemProvider(this);
        }

        return valuedObjectItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.Variable} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariableItemProvider variableItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.Variable}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createVariableAdapter() {
        if (variableItemProvider == null) {
            variableItemProvider = new VariableItemProvider(this);
        }

        return variableItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.synccharts.VariableReference} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariableReferenceItemProvider variableReferenceItemProvider;

    /**
     * This creates an adapter for a {@link de.cau.cs.kieler.synccharts.VariableReference}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createVariableReferenceAdapter() {
        if (variableReferenceItemProvider == null) {
            variableReferenceItemProvider = new VariableReferenceItemProvider(this);
        }

        return variableReferenceItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void dispose() {
        if (actionItemProvider != null) actionItemProvider.dispose();
        if (assignmentItemProvider != null) assignmentItemProvider.dispose();
        if (complexExpressionItemProvider != null) complexExpressionItemProvider.dispose();
        if (emissionItemProvider != null) emissionItemProvider.dispose();
        if (expressionItemProvider != null) expressionItemProvider.dispose();
        if (hostCodeItemProvider != null) hostCodeItemProvider.dispose();
        if (regionItemProvider != null) regionItemProvider.dispose();
        if (signalItemProvider != null) signalItemProvider.dispose();
        if (signalReferenceItemProvider != null) signalReferenceItemProvider.dispose();
        if (signalRenamingItemProvider != null) signalRenamingItemProvider.dispose();
        if (stateItemProvider != null) stateItemProvider.dispose();
        if (transitionItemProvider != null) transitionItemProvider.dispose();
        if (valuedObjectItemProvider != null) valuedObjectItemProvider.dispose();
        if (variableItemProvider != null) variableItemProvider.dispose();
        if (variableReferenceItemProvider != null) variableReferenceItemProvider.dispose();
    }

}
