package de.cau.cs.kieler.core.ui.examplewizard.manager;

import org.eclipse.jface.wizard.Wizard;

public class ExampleManager extends Wizard {

	/** Example management page */
	private ExampleManagementPage exampleManagementPage;
	
	public ExampleManager() {
		super();
	}
	
	public void addPages() {
		setWindowTitle("Example Manager");
		this.exampleManagementPage = new ExampleManagementPage();
		addPage(this.exampleManagementPage);
	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}
}

