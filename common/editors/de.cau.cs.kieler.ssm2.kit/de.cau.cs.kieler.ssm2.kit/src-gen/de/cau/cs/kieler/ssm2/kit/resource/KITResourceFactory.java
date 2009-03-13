package de.cau.cs.kieler.ssm2.kit.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.openarchitectureware.xtext.resource.IXtextResourceFactory;

public class KITResourceFactory extends ResourceFactoryImpl implements IXtextResourceFactory {
	@Override
	public Resource createResource(URI uri) {
		return new KITResource(uri);
	}
	
	public static void register() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("kit", new KITResourceFactory());
	}
}

