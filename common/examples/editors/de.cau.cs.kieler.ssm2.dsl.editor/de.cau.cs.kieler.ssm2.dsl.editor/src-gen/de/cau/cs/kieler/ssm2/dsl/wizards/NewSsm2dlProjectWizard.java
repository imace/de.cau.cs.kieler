package de.cau.cs.kieler.ssm2.dsl.wizards;

import org.openarchitectureware.xtext.LanguageUtilities;
import org.openarchitectureware.xtext.editor.wizards.AbstractNewProjectWizard;

import de.cau.cs.kieler.ssm2.dsl.Ssm2dlEditorPlugin;

public class NewSsm2dlProjectWizard extends AbstractNewProjectWizard {

	public NewSsm2dlProjectWizard() {
		super();
		setLangName("ssm2dl");
		setGeneratorProjectName("de.cau.cs.kieler.ssm2.dsl.generator");
		setDslProjectName("de.cau.cs.kieler.ssm2.dsl");
		setFileExtension("ssm2dl");
		setPackageName("de/cau/cs/kieler/ssm2/dsl/");
	}
	
	@Override
	protected LanguageUtilities getUtilities() {
		return Ssm2dlEditorPlugin.getDefault().getUtilities();
	}
}

