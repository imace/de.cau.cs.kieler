package de.cau.cs.kieler.synccharts.text.actions;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

import de.cau.cs.kieler.synccharts.text.actions.formatting.ActionsTransientValueService;
import de.cau.cs.kieler.synccharts.text.actions.formatting.ActionsValueConverter;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ActionsRuntimeModule extends de.cau.cs.kieler.synccharts.text.actions.AbstractActionsRuntimeModule {
    /* (non-Javadoc)
     * @see org.eclipse.xtext.service.DefaultRuntimeModule#bindITransientValueService()
     */
    @Override
    public Class<? extends ITransientValueService> bindITransientValueService() {
        return ActionsTransientValueService.class; 
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.xtext.service.DefaultRuntimeModule#bindIValueConverterService()
     */
    @Override
    public Class<? extends IValueConverterService> bindIValueConverterService() {
        return ActionsValueConverter.class;
    }
    
//    public Class<? extends IValueSerializer> bindIValueSerializer() {
//    	return ActionsValueSerializer.class;
//    }
}
