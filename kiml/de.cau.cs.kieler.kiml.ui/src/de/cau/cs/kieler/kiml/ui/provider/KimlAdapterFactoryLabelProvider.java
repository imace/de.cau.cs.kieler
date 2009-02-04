/*******************************************************************************
 * Copyright (c) 2009 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.ui.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

/**
 * This label provider is an extension of the
 * {@link AdapterFactoryLabelProvider}. This KimlAdapterFactoryLabelProvider
 * supports the new {@link IKimlLabelProvider} interface to get access to KIELER
 * and KIML specific labels of the provided objects.
 * 
 * If now implementation of a provider is given for a certain object, than the
 * default {@link IItemLabelProvider} of the respective object is used.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see AdapterFactoryLabelProvider
 * @see IKimlLabelProvider
 */
public class KimlAdapterFactoryLabelProvider extends
		AdapterFactoryLabelProvider implements IKimlLabelProvider {

	/**
	 * Uses the super constructor of {@link AdapterFactoryLabelProvider}.
	 * 
	 * @param adapterFactory
	 */
	public KimlAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	private static final Class<?> IKimlLabelProviderClass = IKimlLabelProvider.class;
	private static final Class<?> IItemLabelProviderClass = IItemLabelProvider.class;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider#getKimlLongLabel
	 * (java.lang.Object)
	 */
	public String getKimlLongLabel(Object object) {
		// Get the adapter from the factory.
		IKimlLabelProvider kimlItemLabelProvider = (IKimlLabelProvider) adapterFactory
				.adapt(object, IKimlLabelProviderClass);

		/*
		 * if no IKimlLabelProvider is implemented and registered for the
		 * provided object, use the standard IItemLabelProvider
		 */
		if (kimlItemLabelProvider == null) {
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
					.adapt(object, IItemLabelProviderClass);
			return itemLabelProvider != null ? itemLabelProvider
					.getText(object) : object == null ? "" : object.toString();
		}
		return kimlItemLabelProvider != null ? kimlItemLabelProvider
				.getKimlLongLabel(object) : object == null ? "" : object
				.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider#getKimlShortLabel
	 * (java.lang.Object)
	 */
	public String getKimlShortLabel(Object object) {
		// Get the adapter from the factory.
		IKimlLabelProvider kimlItemLabelProvider = (IKimlLabelProvider) adapterFactory
				.adapt(object, IKimlLabelProviderClass);
		/*
		 * if no IKimlLabelProvider is implemented and registered for the
		 * provided object, use the standard IItemLabelProvider
		 */
		if (kimlItemLabelProvider == null) {
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
					.adapt(object, IItemLabelProviderClass);
			return itemLabelProvider != null ? itemLabelProvider
					.getText(object) : object == null ? "" : object.toString();
		}
		return kimlItemLabelProvider != null ? kimlItemLabelProvider
				.getKimlShortLabel(object) : object == null ? "" : object
				.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider#getKimlHeadLabel
	 * (java.lang.Object)
	 */
	public String getKimlHeadLabel(Object object) {
		// Get the adapter from the factory.
		IKimlLabelProvider kimlItemLabelProvider = (IKimlLabelProvider) adapterFactory
				.adapt(object, IKimlLabelProviderClass);
		/*
		 * if no IKimlLabelProvider is implemented and registered for the
		 * provided object, use the standard IItemLabelProvider
		 */
		if (kimlItemLabelProvider == null) {
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
					.adapt(object, IItemLabelProviderClass);
			return itemLabelProvider != null ? itemLabelProvider
					.getText(object) : object == null ? "" : object.toString();
		}
		return kimlItemLabelProvider != null ? kimlItemLabelProvider
				.getKimlHeadLabel(object) : object == null ? "" : object
				.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider#getKimlCenterLabel
	 * (java.lang.Object)
	 */
	public String getKimlCenterLabel(Object object) {
		// Get the adapter from the factory.
		IKimlLabelProvider kimlItemLabelProvider = (IKimlLabelProvider) adapterFactory
				.adapt(object, IKimlLabelProviderClass);
		/*
		 * if no IKimlLabelProvider is implemented and registered for the
		 * provided object, use the standard IItemLabelProvider
		 */
		if (kimlItemLabelProvider == null) {
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
					.adapt(object, IItemLabelProviderClass);
			return itemLabelProvider != null ? itemLabelProvider
					.getText(object) : object == null ? "" : object.toString();
		}
		return kimlItemLabelProvider != null ? kimlItemLabelProvider
				.getKimlCenterLabel(object) : object == null ? "" : object
				.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider#getKimlTailLabel
	 * (java.lang.Object)
	 */
	public String getKimlTailLabel(Object object) {
		// Get the adapter from the factory.
		IKimlLabelProvider kimlItemLabelProvider = (IKimlLabelProvider) adapterFactory
				.adapt(object, IKimlLabelProviderClass);
		/*
		 * if no IKimlLabelProvider is implemented and registered for the
		 * provided object, use the standard IItemLabelProvider
		 */
		if (kimlItemLabelProvider == null) {
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
					.adapt(object, IItemLabelProviderClass);
			return itemLabelProvider != null ? itemLabelProvider
					.getText(object) : object == null ? "" : object.toString();
		}
		return kimlItemLabelProvider != null ? kimlItemLabelProvider
				.getKimlTailLabel(object) : object == null ? "" : object
				.toString();
	}
}
