package de.cau.cs.kieler.ssm.diagram.layouter.provider;

import org.eclipse.emf.common.notify.Adapter;

import de.cau.cs.kieler.ssm.provider.ssmItemProviderAdapterFactory;

public class ssmKimlProviderAdapterFactory extends ssmItemProviderAdapterFactory{

	/**
	 * This creates an adapter for a {@link de.cau.cs.kieler.ssm.SimpleState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSimpleStateAdapter() {
		if (simpleStateItemProvider == null) {
			simpleStateItemProvider = new KimlSimpleStateItemProvider(this);
		}

		return simpleStateItemProvider;
	}

	
	/**
	 * This creates an adapter for a {@link de.cau.cs.kieler.ssm.SimpleState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompositeStateAdapter() {
		if (simpleStateItemProvider == null) {
			simpleStateItemProvider = new KimlCompositeStateItemProvider(this);
		}

		return simpleStateItemProvider;
	}
	
	/**
	 * This creates an adapter for a {@link de.cau.cs.kieler.ssm.Region}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRegionAdapter() {
		if (regionItemProvider == null) {
			regionItemProvider = new KimlRegionItemProvider(this);
		}

		return regionItemProvider;
	}
	
	/**
	 * This creates an adapter for a {@link de.cau.cs.kieler.ssm.InitialState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInitialStateAdapter() {
		if (initialStateItemProvider == null) {
			initialStateItemProvider = new KimlInitialStateItemProvider(this);
		}

		return initialStateItemProvider;
	}
	
	/**
	 * This creates an adapter for a {@link de.cau.cs.kieler.ssm.NormalTermination}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNormalTerminationAdapter() {
		if (normalTerminationItemProvider == null) {
			normalTerminationItemProvider = new KimlNormalTerminationItemProvider(this);
		}

		return normalTerminationItemProvider;
	}
	/**
	 * This creates an adapter for a {@link de.cau.cs.kieler.ssm.StrongAbortion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStrongAbortionAdapter() {
		if (strongAbortionItemProvider == null) {
			strongAbortionItemProvider = new KimlStrongAbortionItemProvider(this);
		}

		return strongAbortionItemProvider;
	}
	/**
	 * This creates an adapter for a {@link de.cau.cs.kieler.ssm.WeakAbortion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWeakAbortionAdapter() {
		if (weakAbortionItemProvider == null) {
			weakAbortionItemProvider = new KimlWeakAbortionItemProvider(this);
		}

		return weakAbortionItemProvider;
	}
	
}
