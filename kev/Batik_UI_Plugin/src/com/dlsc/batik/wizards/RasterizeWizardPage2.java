/*
 * Created on 26.02.2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.dlsc.batik.wizards;

import java.util.LinkedList;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.dlsc.batik.viewer.BatikUIPlugin;
import com.dlsc.batik.viewer.Messages;

/**
 * @author A470132
 */
public class RasterizeWizardPage2 extends WizardPage {
	
	private RasterizeOptions rasterizeOptions;

	public RasterizeWizardPage2() {
		super(Messages.getString("RasterizeWizardPage2.RASTER_OPTIONS")); //$NON-NLS-1$
		setTitle(Messages.getString("RasterizeWizardPage2.OUTPUT_OPTIONS")); //$NON-NLS-1$
		setDescription(Messages.getString("RasterizeWizardPage2.DESCRIPTION")); //$NON-NLS-1$
		setImageDescriptor(BatikUIPlugin.getDefault().getImageDescriptor(BatikUIPlugin.IMG_EXPORTRASTER_WIZARD));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		rasterizeOptions = new RasterizeOptions(composite, this);
		setControl(composite);
	}
	
	public LinkedList getOptions() {
		return rasterizeOptions.getOptionsList();
	}
	
	public String getSuffix() {
		return rasterizeOptions.getSuffix();
	}
}
