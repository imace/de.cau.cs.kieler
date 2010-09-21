
/*
 * generated by Xtext
 */
package de.cau.cs.kieler.synccharts.text.kitsState.ui.internal;

import org.apache.log4j.Logger;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

import java.util.Map;
import java.util.HashMap;

/**
 * Generated
 */
public class KitsStateActivator extends AbstractUIPlugin {

	private Map<String,Injector> injectors = new HashMap<String,Injector>();
	private static KitsStateActivator INSTANCE;

	public Injector getInjector(String languageName) {
		return injectors.get(languageName);
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		try {
			
			injectors.put("de.cau.cs.kieler.synccharts.text.kitsState.KitsState", Guice.createInjector(
				Modules.override(Modules.override(getRuntimeModule("de.cau.cs.kieler.synccharts.text.kitsState.KitsState")).with(getUiModule("de.cau.cs.kieler.synccharts.text.kitsState.KitsState"))).with(getSharedStateModule())
			));
			
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}
	}
	
	public static KitsStateActivator getInstance() {
		return INSTANCE;
	}
	
	protected Module getRuntimeModule(String grammar) {
		
		if ("de.cau.cs.kieler.synccharts.text.kitsState.KitsState".equals(grammar)) {
		  return new de.cau.cs.kieler.synccharts.text.kitsState.KitsStateRuntimeModule();
		}
		
		throw new IllegalArgumentException(grammar);
	}
	protected Module getUiModule(String grammar) {
		
		if ("de.cau.cs.kieler.synccharts.text.kitsState.KitsState".equals(grammar)) {
		  return new de.cau.cs.kieler.synccharts.text.kitsState.ui.KitsStateUiModule(this);
		}
		
		throw new IllegalArgumentException(grammar);
	}
	
	protected Module getSharedStateModule() {
		return new org.eclipse.xtext.ui.shared.SharedStateModule();
	}
	
}
