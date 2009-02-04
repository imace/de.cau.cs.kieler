/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package dataflow.diagram.layout.kimllabelprovider;

import org.eclipse.emf.common.notify.Adapter;

import dataflow.provider.DataflowItemProviderAdapterFactory;

public class KimlDataflowItemProviderAdapterFactory extends DataflowItemProviderAdapterFactory {


	/**
	 * This creates an adapter for a {@link dataflow.Box}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBoxAdapter() {
		if (boxItemProvider == null) {
			boxItemProvider = new KimlBoxItemProvider(this);
		}

		return boxItemProvider;
	}

	/**
	 * This creates an adapter for a {@link dataflow.Connection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConnectionAdapter() {
		if (connectionItemProvider == null) {
			connectionItemProvider = new KimlConnectionItemProvider(this);
		}

		return connectionItemProvider;
	}

	/**
	 * This creates an adapter for a {@link dataflow.DataflowModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataflowModelAdapter() {
		if (dataflowModelItemProvider == null) {
			dataflowModelItemProvider = new KimlDataflowModelItemProvider(this);
		}

		return dataflowModelItemProvider;
	}

	/**
	 * This creates an adapter for a {@link dataflow.Port}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPortAdapter() {
		if (portItemProvider == null) {
			portItemProvider = new KimlPortItemProvider(this);
		}

		return portItemProvider;
	}

	/**
	 * This creates an adapter for a {@link dataflow.InputPort}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInputPortAdapter() {
		if (inputPortItemProvider == null) {
			inputPortItemProvider = new KimlInputPortItemProvider(this);
		}

		return inputPortItemProvider;
	}

	/**
	 * This creates an adapter for a {@link dataflow.OutputPort}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOutputPortAdapter() {
		if (outputPortItemProvider == null) {
			outputPortItemProvider = new KimlOutputPortItemProvider(this);
		}

		return outputPortItemProvider;
	}
}
