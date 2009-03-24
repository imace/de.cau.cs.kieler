package de.cau.cs.kieler.ssm2.dsl.resource;

import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.openarchitectureware.workflow.util.ResourceLoaderImpl;
import org.openarchitectureware.xtext.parser.IXtextParser;
import org.openarchitectureware.xtext.resource.AbstractXtextResource;

import de.cau.cs.kieler.ssm2.dsl.parser.XtextParser;

public class ssm2dlResource extends AbstractXtextResource {
	public ssm2dlResource(URI uri) {
		super(uri);
		setFormattingExtension("de::cau::cs::kieler::ssm2::dsl::Formatting");
		setResourceLoader(new ResourceLoaderImpl(XtextParser.class.getClassLoader()));
	}

	@Override
	protected IXtextParser createParser(InputStream inputStream) {
		return new XtextParser(inputStream);
	}

}

