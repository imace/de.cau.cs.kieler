
package de.cau.cs.kieler.core.expressions;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ExpressionsStandaloneSetup extends ExpressionsStandaloneSetupGenerated{

	public static void doSetup() {
		new ExpressionsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

