package de.cau.cs.kieler.kiml.ui.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

public class KimlAdapterFactoryLabelProvider extends
		AdapterFactoryLabelProvider implements IKimlLabelProvider {

	public KimlAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getKimlLongLabel(Object object) {
		// Get the adapter from the factory.
		//
		IKimlLabelProvider kimlItemLabelProvider = (IKimlLabelProvider) adapterFactory
				.adapt(object, IKimlLabelProvider.class);

		if (kimlItemLabelProvider == null){
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
			.adapt(object, IItemLabelProvider.class);
			return itemLabelProvider != null ? itemLabelProvider.getText(object)
					: object == null ? "" : object.toString();
		}
		return kimlItemLabelProvider != null ? kimlItemLabelProvider.getKimlLongLabel(object)
				: object == null ? "" : object.toString();
	}

	public String getKimlShortLabel(Object object) {
		// Get the adapter from the factory.
		//
		IKimlLabelProvider kimlItemLabelProvider = (IKimlLabelProvider) adapterFactory
				.adapt(object, IKimlLabelProvider.class);

		if (kimlItemLabelProvider == null){
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
			.adapt(object, IItemLabelProvider.class);
			return itemLabelProvider != null ? itemLabelProvider.getText(object)
					: object == null ? "" : object.toString();
		}
		return kimlItemLabelProvider != null ? kimlItemLabelProvider.getKimlShortLabel(object)
				: object == null ? "" : object.toString();
	}
	
	public String getKimlHeadLabel(Object object) {
		// Get the adapter from the factory.
		//
		IKimlLabelProvider kimlItemLabelProvider = (IKimlLabelProvider) adapterFactory
				.adapt(object, IKimlLabelProvider.class);

		if (kimlItemLabelProvider == null){
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
			.adapt(object, IItemLabelProvider.class);
			return itemLabelProvider != null ? itemLabelProvider.getText(object)
					: object == null ? "" : object.toString();
		}
		return kimlItemLabelProvider != null ? kimlItemLabelProvider.getKimlHeadLabel(object)
				: object == null ? "" : object.toString();
	}
	
	public String getKimlCenterLabel(Object object) {
		// Get the adapter from the factory.
		//
		IKimlLabelProvider kimlItemLabelProvider = (IKimlLabelProvider) adapterFactory
				.adapt(object, IKimlLabelProvider.class);

		if (kimlItemLabelProvider == null){
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
			.adapt(object, IItemLabelProvider.class);
			return itemLabelProvider != null ? itemLabelProvider.getText(object)
					: object == null ? "" : object.toString();
		}
		return kimlItemLabelProvider != null ? kimlItemLabelProvider.getKimlCenterLabel(object)
				: object == null ? "" : object.toString();
	}
	
	public String getKimlTailLabel(Object object) {
		// Get the adapter from the factory.
		//
		IKimlLabelProvider kimlItemLabelProvider = (IKimlLabelProvider) adapterFactory
				.adapt(object, IKimlLabelProvider.class);

		if (kimlItemLabelProvider == null){
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
			.adapt(object, IItemLabelProvider.class);
			return itemLabelProvider != null ? itemLabelProvider.getText(object)
					: object == null ? "" : object.toString();
		}
		return kimlItemLabelProvider != null ? kimlItemLabelProvider.getKimlTailLabel(object)
				: object == null ? "" : object.toString();
	}
}
