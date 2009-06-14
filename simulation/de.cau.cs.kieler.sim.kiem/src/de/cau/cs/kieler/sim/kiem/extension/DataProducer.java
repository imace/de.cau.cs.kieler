package de.cau.cs.kieler.sim.kiem.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;


public abstract class DataProducer implements IExecutableExtension {
	
	private String name;
	private String ModelFile;
	
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		this.name = config.getAttribute("name");
	}
	
	public String getName() {
		return name;
	}
	
	public String getModelFile() {
		return ModelFile;
	}
	
	public void InitializeExecution() {
	}

	public void setModelFile(String ModelFile) {
		this.ModelFile = ModelFile;
		return;
	}
	
	public void MakeStep() {
		return;
	}
	
}
