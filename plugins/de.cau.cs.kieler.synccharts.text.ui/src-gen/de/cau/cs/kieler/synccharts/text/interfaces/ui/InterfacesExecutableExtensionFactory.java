
/*
 * generated by Xtext
 */
 
package de.cau.cs.kieler.synccharts.text.interfaces.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 *@generated
 */
public class InterfacesExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return de.cau.cs.kieler.synccharts.text.interfaces.ui.internal.InterfacesActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return de.cau.cs.kieler.synccharts.text.interfaces.ui.internal.InterfacesActivator.getInstance().getInjector("de.cau.cs.kieler.synccharts.text.interfaces.Interfaces");
	}
	
}
