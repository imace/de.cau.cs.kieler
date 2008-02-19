/*
 * Created on 21.03.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dlsc.batik.preferences;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import com.dlsc.batik.viewer.BatikUIPlugin;
/**
 * @author dlemmermann
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DonateComposite extends Composite {

	private Label label1 = null;
	public DonateComposite(Composite parent, int style) {
		super(parent, style);
		initialize();
	}
	private void initialize() {
		GridLayout gridLayout3 = new GridLayout();
		GridData gridData1 = new GridData();
		label1 = new Label(this, SWT.NONE);
		label1.setLayoutData(gridData1);
		label1.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/com/dlsc/batik/viewer/donate.jpg"))); //$NON-NLS-1$
		label1.setCursor(new Cursor(getDisplay(), SWT.CURSOR_HAND));
		gridData1.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = false;
		gridData1.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		this.setLayout(gridLayout3);
		gridLayout3.verticalSpacing = 10;
		this.setSize(new org.eclipse.swt.graphics.Point(297,200));
		label1.addMouseListener(new org.eclipse.swt.events.MouseAdapter() { 
			public void mouseUp(org.eclipse.swt.events.MouseEvent e) {    
				Program.launch(BatikUIPlugin.DONATION_URL);
			}
		});
	}
	
 }  //  @jve:decl-index=0:visual-constraint="53,40"
