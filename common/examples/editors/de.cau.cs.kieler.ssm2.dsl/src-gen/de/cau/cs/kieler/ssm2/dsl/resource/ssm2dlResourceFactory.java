package de.cau.cs.kieler.ssm2.dsl.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.openarchitectureware.xtext.resource.IXtextResourceFactory;

public class ssm2dlResourceFactory extends ResourceFactoryImpl implements IXtextResourceFactory {
	@Override
	public Resource createResource(URI uri) {
		return new ssm2dlResource(uri);
	}
	
	public static void register() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ssm2dl", new ssm2dlResourceFactory());
	}
}

