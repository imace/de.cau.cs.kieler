
package de.cau.cs.kieler.ssm2.dsl.wizards;

import org.openarchitectureware.xtext.LanguageUtilities;
import org.openarchitectureware.xtext.editor.wizards.AbstractNewFileWizard;

import de.cau.cs.kieler.ssm2.dsl.Ssm2dlEditorPlugin;

public class NewSsm2dlFileWizard extends AbstractNewFileWizard {

	@Override
	protected LanguageUtilities getUtilities() {
		return Ssm2dlEditorPlugin.getDefault().getUtilities();
	}
}
