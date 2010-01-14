/*
 * generated by Xtext
 */
package de.cau.cs.kieler.synccharts.dsl;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.resource.IFragmentProvider;

import de.cau.cs.kieler.synccharts.dsl.kits.resource.KitsFragmentProvider;
import de.cau.cs.kieler.synccharts.dsl.kits.serialization.KitsTransientValueService;
import de.cau.cs.kieler.synccharts.dsl.scoping.KitsScopeProvider;
import de.cau.cs.kieler.synccharts.labelparser.formatting.ActionLabelValueConverter;

/**
 * This class is the injector created also to setup the standalone Kits
 * application, to get the implementations injected. Use this class to register
 * components to be used within the IDE.
 * 
 * @author oba
 */
public class KitsRuntimeModule extends
		de.cau.cs.kieler.synccharts.dsl.AbstractKitsRuntimeModule {
//	// influence linking for target state creation
//	@Override
//	public java.lang.Class<? extends org.eclipse.xtext.resource.XtextResource> bindXtextResource() {
//		return de.cau.cs.kieler.synccharts.dsl.kits.linking.KitsLazyLinkingResource.class;
//	};

	/*
	 * binds the fragment provider. it is used for the Glue code
	 */
	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return KitsFragmentProvider.class;
	}

	/**
	 * delegates to custom scope provider if scope is undefined in
	 * KitsScopeProvider.
	 * 
	 * @see AbstractKitsRuntimeModule for the default binding
	 * @see KitsScopeProvider for the declarative scoping implementation
	 * 
	 * 
	 * @return custom implementation of the Scope Provider
	 */
	@Override
	public void configureIScopeProviderDelegate(com.google.inject.Binder binder) {
		binder
				.bind(org.eclipse.xtext.scoping.IScopeProvider.class)
				.annotatedWith(
						com.google.inject.name.Names
								.named("org.eclipse.xtext.scoping.IScopeProvider.delegate"))
				.to(
						de.cau.cs.kieler.synccharts.dsl.scoping.ReferenceByIdScopeProvider.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.service.DefaultRuntimeModule#bindITransientValueService
	 * ()
	 */
	// @Override
	// public Class<? extends ITransientValueService>
	// bindITransientValueService() {
	// return KitsTransientValueService.class;
	// }

	@Override
	public Class<? extends ITransientValueService> bindITransientValueService() {
		return KitsTransientValueService.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.service.DefaultRuntimeModule#bindIValueConverterService
	 * ()
	 */
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return ActionLabelValueConverter.class;
	}

}
