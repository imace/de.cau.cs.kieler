package de.cau.cs.kieler.viewmanagement;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class RunLogic {
	
	public void registerListeners (){
		System.out.println("Registering");
		IConfigurationElement[] myExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor("de.cau.cs.kieler.viewmanagement.effects");
		 for (int i = 0; i < myExtensions.length; i++) {
			try {
				myExtensions[i].createExecutableExtension("class");
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
	}

}
