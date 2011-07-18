/*
 * generated by Xtext
 */
package de.cau.cs.kieler.kies;

import org.eclipse.xtext.conversion.IValueConverterService;

import de.cau.cs.kieler.kies.formatting.EsterelValueConverter;

/**
 * Use this class to register components to be used within the IDE.
 */
public class EsterelRuntimeModule extends de.cau.cs.kieler.kies.AbstractEsterelRuntimeModule {

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<? extends IValueConverterService> bindIValueConverterService() {
        return EsterelValueConverter.class;
    }

    // contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
    public void configureIResourceDescriptions(com.google.inject.Binder binder) {
        binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).to(
                org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
    }

    // contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
//    public void configureIResourceDescriptionsBuilderScope(com.google.inject.Binder binder) {
//        binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class)
//                .annotatedWith(
//                        com.google.inject.name.Names
//                                .named(org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider.NAMED_BUILDER_SCOPE))
//                .to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
//    }

//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Class<? extends IFormatter> bindIFormatter() {
//        return EsterelFormatter.class;
//    }

}
