/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.layout;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.kiml.layout.services.ILayoutListener;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.layout.services.LayoutProviderData;
import de.cau.cs.kieler.kiml.layout.services.LayoutServices;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;

/**
 * This class is responsible for reading all extension point elements
 * for layout services.
 * 
 * @author msp
 */
public class LayoutServiceBuilder {

	/**
	 * Build the layout services.
	 */
	public static void buildLayoutServices() {
		// create instance of layout service holder class
		LayoutServices.INSTANCE = new LayoutServices();
		// build layout services for all extension points
		loadLayoutProviderExtensions();
		loadLayoutListenerExtensions();
		loadLayoutInfoExtensions();
	}
	
	/**
	 * Loads and registers all layout providers from the extension point.
	 */
	private static void loadLayoutProviderExtensions() {
		IConfigurationElement[] extensions = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(LayoutServices.EXTP_ID_LAYOUT_PROVIDERS);

		for (IConfigurationElement element : extensions) {
		    if (LayoutServices.ELEMENT_LAYOUT_PROVIDER.equals(element.getName())) {
	            try {
			        // register a layout provider from the extension
    				AbstractLayoutProvider layoutProvider = (AbstractLayoutProvider)element
    						.createExecutableExtension(LayoutServices.ATTRIBUTE_CLASS);
    				if (layoutProvider != null) {
    				    LayoutProviderData providerData = new LayoutProviderData();
    				    providerData.instance = layoutProvider;
    				    providerData.id = element.getAttribute(LayoutServices.ATTRIBUTE_ID);
    				    providerData.name = element.getAttribute(LayoutServices.ATTRIBUTE_NAME);
    				    providerData.type = element.getAttribute(LayoutServices.ATTRIBUTE_TYPE);
    				    providerData.collection = element.getAttribute(LayoutServices.ATTRIBUTE_COLLECTION);
    				    for (IConfigurationElement child : element.getChildren()) {
    				        if (LayoutServices.ELEMENT_KNOWN_OPTION.equals(child.getName())) {
    				            String option = child.getAttribute(LayoutServices.ATTRIBUTE_OPTION);
    				            if (option != null)
    				                providerData.knownOptions.add(option);
    				        }
    				        else if (LayoutServices.ELEMENT_SUPPORTED_DIAGRAM.equals(child.getName())) {
    				            String type = child.getAttribute(LayoutServices.ATTRIBUTE_TYPE);
    				            if (type != null)
    				                providerData.supportedDiagrams.add(type);
    				        }
    				    }
    					LayoutServices.INSTANCE.addLayoutProvider(providerData);
    				}
    			} catch (CoreException exception) {
    				StatusManager.getManager().handle(exception, KimlUiPlugin.PLUGIN_ID);
    			}
		    }
		    else if (LayoutServices.ELEMENT_LAYOUT_TYPE.equals(element.getName())) {
		        // register a layout type from the extension
		        LayoutServices.INSTANCE.addLayoutType(
		                element.getAttribute(LayoutServices.ATTRIBUTE_ID),
		                element.getAttribute(LayoutServices.ATTRIBUTE_NAME));
		    }
		    else if (LayoutServices.ELEMENT_COLLECTION.equals(element.getName())) {
		        // TODO collections are not supported yet 
		    }
		    else if (LayoutServices.ELEMENT_LAYOUT_OPTION.equals(element.getName())) {
		        // TODO layout options are not supported yet
		    }
		}
	}
	
	/**
	 * Loads and registers all layout listeners from the extension point.
	 */
	private static void loadLayoutListenerExtensions() {
		IConfigurationElement[] extensions = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(LayoutServices.EXTP_ID_LAYOUT_LISTENERS);

		for (IConfigurationElement element : extensions) {
		    if (LayoutServices.ELEMENT_LAYOUT_LISTENER.equals(element.getName())) {
    			try {
    				ILayoutListener layoutListener = (ILayoutListener) element
    						.createExecutableExtension(LayoutServices.ATTRIBUTE_CLASS);
    				if (layoutListener != null) {
    					LayoutServices.INSTANCE.addLayoutListener(layoutListener);
    				}
    			} catch (CoreException exception) {
    				StatusManager.getManager().handle(exception, KimlUiPlugin.PLUGIN_ID);
    			}
		    }
		}
	}
	
	/**
     * Loads and registers all layout information from the extension point.
     */
    private static void loadLayoutInfoExtensions() {
        IConfigurationElement[] extensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(LayoutServices.EXTP_ID_LAYOUT_INFO);

        for (IConfigurationElement element : extensions) {
            if (LayoutServices.ELEMENT_ELEMENT_TYPE.equals(element.getName())) {
                // TODO element types are not supported yet
            }
            else if (LayoutServices.ELEMENT_BINDING.equals(element.getName())) {
                // TODO bindings are not supported yet
            }
        }
    }
	
}
