/*
 * generated by Xtext
 */
package de.cau.cs.kieler.core.kexpressions.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class KExpressionsExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return de.cau.cs.kieler.core.kexpressions.ui.internal.KExpressionsActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return de.cau.cs.kieler.core.kexpressions.ui.internal.KExpressionsActivator.getInstance().getInjector("de.cau.cs.kieler.core.kexpressions.KExpressions");
	}
	
}
