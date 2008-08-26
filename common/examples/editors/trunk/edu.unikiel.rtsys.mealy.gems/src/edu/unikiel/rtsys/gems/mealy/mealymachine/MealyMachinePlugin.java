package edu.unikiel.rtsys.gems.mealy.mealymachine;

import org.eclipse.ui.plugin.*;
import org.osgi.framework.BundleContext;
import java.util.*;


public class MealyMachinePlugin extends AbstractUIPlugin {
	//The shared instance.
	private static MealyMachinePlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
  

	public MealyMachinePlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("edu.unikiel.rtsys.gems.mealy.mealymachine.MealyMachinePluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}


	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	public static MealyMachinePlugin getDefault() {
		return plugin;
	}


	public static String getResourceString(String key) {
		ResourceBundle bundle = MealyMachinePlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
}
