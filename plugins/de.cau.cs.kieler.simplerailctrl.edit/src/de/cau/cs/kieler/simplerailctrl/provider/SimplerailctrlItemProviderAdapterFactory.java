/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.simplerailctrl.provider;

import de.cau.cs.kieler.simplerailctrl.util.SimplerailctrlAdapterFactory;

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
public class SimplerailctrlItemProviderAdapterFactory extends SimplerailctrlAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public SimplerailctrlItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

	/**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.simplerailctrl.EventWait} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EventWaitItemProvider eventWaitItemProvider;

	/**
     * This creates an adapter for a {@link de.cau.cs.kieler.simplerailctrl.EventWait}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createEventWaitAdapter() {
        if (eventWaitItemProvider == null) {
            eventWaitItemProvider = new EventWaitItemProvider(this);
        }

        return eventWaitItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.simplerailctrl.Node} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NodeItemProvider nodeItemProvider;

	/**
     * This creates an adapter for a {@link de.cau.cs.kieler.simplerailctrl.Node}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createNodeAdapter() {
        if (nodeItemProvider == null) {
            nodeItemProvider = new NodeItemProvider(this);
        }

        return nodeItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.simplerailctrl.Transition} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TransitionItemProvider transitionItemProvider;

	/**
     * This creates an adapter for a {@link de.cau.cs.kieler.simplerailctrl.Transition}.
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
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.simplerailctrl.EventContact} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EventContactItemProvider eventContactItemProvider;

	/**
     * This creates an adapter for a {@link de.cau.cs.kieler.simplerailctrl.EventContact}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createEventContactAdapter() {
        if (eventContactItemProvider == null) {
            eventContactItemProvider = new EventContactItemProvider(this);
        }

        return eventContactItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.simplerailctrl.SetSpeed} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SetSpeedItemProvider setSpeedItemProvider;

	/**
     * This creates an adapter for a {@link de.cau.cs.kieler.simplerailctrl.SetSpeed}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createSetSpeedAdapter() {
        if (setSpeedItemProvider == null) {
            setSpeedItemProvider = new SetSpeedItemProvider(this);
        }

        return setSpeedItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.simplerailctrl.SetPoint} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SetPointItemProvider setPointItemProvider;

	/**
     * This creates an adapter for a {@link de.cau.cs.kieler.simplerailctrl.SetPoint}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createSetPointAdapter() {
        if (setPointItemProvider == null) {
            setPointItemProvider = new SetPointItemProvider(this);
        }

        return setPointItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.simplerailctrl.RailController} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected RailControllerItemProvider railControllerItemProvider;

	/**
     * This creates an adapter for a {@link de.cau.cs.kieler.simplerailctrl.RailController}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createRailControllerAdapter() {
        if (railControllerItemProvider == null) {
            railControllerItemProvider = new RailControllerItemProvider(this);
        }

        return railControllerItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.simplerailctrl.SetSignal} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SetSignalItemProvider setSignalItemProvider;

	/**
     * This creates an adapter for a {@link de.cau.cs.kieler.simplerailctrl.SetSignal}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createSetSignalAdapter() {
        if (setSignalItemProvider == null) {
            setSignalItemProvider = new SetSignalItemProvider(this);
        }

        return setSignalItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.cau.cs.kieler.simplerailctrl.EventOccupied} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EventOccupiedItemProvider eventOccupiedItemProvider;

	/**
     * This creates an adapter for a {@link de.cau.cs.kieler.simplerailctrl.EventOccupied}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createEventOccupiedAdapter() {
        if (eventOccupiedItemProvider == null) {
            eventOccupiedItemProvider = new EventOccupiedItemProvider(this);
        }

        return eventOccupiedItemProvider;
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
        if (eventWaitItemProvider != null) eventWaitItemProvider.dispose();
        if (nodeItemProvider != null) nodeItemProvider.dispose();
        if (transitionItemProvider != null) transitionItemProvider.dispose();
        if (eventContactItemProvider != null) eventContactItemProvider.dispose();
        if (setSpeedItemProvider != null) setSpeedItemProvider.dispose();
        if (setPointItemProvider != null) setPointItemProvider.dispose();
        if (railControllerItemProvider != null) railControllerItemProvider.dispose();
        if (setSignalItemProvider != null) setSignalItemProvider.dispose();
        if (eventOccupiedItemProvider != null) eventOccupiedItemProvider.dispose();
    }

}
