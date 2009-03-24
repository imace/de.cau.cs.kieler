package de.cau.cs.kieler.ssm2.dsl.parser;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.xtext.parser.impl.AbstractParserComponent;
import org.openarchitectureware.xtext.resource.IXtextResource;

import de.cau.cs.kieler.ssm2.dsl.resource.ssm2dlResourceFactory;

public class ParserComponent extends AbstractParserComponent {
	static {
		ssm2dlResourceFactory.register();
	}

	protected String getFileExtension() {
		return "ssm2dl";
	}

}
