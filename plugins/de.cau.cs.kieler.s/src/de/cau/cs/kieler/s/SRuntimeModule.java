/*
 * generated by Xtext
 */
package de.cau.cs.kieler.s;

import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension
 * registry.
 */
public class SRuntimeModule extends de.cau.cs.kieler.s.AbstractSRuntimeModule {
    public Class<? extends ITransientValueService> bindITransientValueService() {
        return de.cau.cs.kieler.s.formatting.STransientService.class;
    }

}
