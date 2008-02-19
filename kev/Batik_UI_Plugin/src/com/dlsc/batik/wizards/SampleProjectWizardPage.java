/*
 * Created on 08.03.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dlsc.batik.wizards;

import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import com.dlsc.batik.viewer.BatikUIPlugin;
import com.dlsc.batik.viewer.Messages;

/**
 * @author dlemmermann
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SampleProjectWizardPage extends WizardNewProjectCreationPage {

	public SampleProjectWizardPage() {
		super("SVGProjectName"); //$NON-NLS-1$
		setTitle(Messages.getString("SampleProjectWizardPage.TITLE")); //$NON-NLS-1$
		setDescription(Messages.getString("SampleProjectWizardPage.DESCRIPTION")); //$NON-NLS-1$
		setImageDescriptor(BatikUIPlugin.getDefault().getImageDescriptor(BatikUIPlugin.IMG_SAMPLE_WIZARD));
	}
}
