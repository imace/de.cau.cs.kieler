package edu.unikiel.rtsys.kieler.kev.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;

public abstract class AnimationDataController extends DataChangeEventSource implements IExecutableExtension, ControlFlowChangeListener, DataChangeListener{

	private String name;
	
	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		this.name = config.getAttribute("name");
	}

	public String getName() {
		return name;
	}
	
	

}
