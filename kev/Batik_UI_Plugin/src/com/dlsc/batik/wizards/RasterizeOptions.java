package com.dlsc.batik.wizards;
import java.util.LinkedList;

import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.dlsc.batik.viewer.Messages;

public class RasterizeOptions implements SelectionListener {
	private Combo box;
	private Label qualityLabel;
	private Text qualityText;
	private Button onloadButton;
	private Text resText;
	private ColorSelector color;
	private Text maxHeightText;
	private Text heightText;
	private WizardPage page;
	private Text widthText;
	private Text maxWidthText;
	
	public RasterizeOptions(Composite parent, WizardPage page) {
		final WizardPage fPage = page;
		
		GridLayout gl = new GridLayout(4, false);
		gl.numColumns = 4;
		parent.setLayout(gl);

		VerifyListener verify = new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				boolean ok = !Character.isLetter(e.character);
				e.doit = ok;
				if (fPage != null && !ok) {
					fPage.setErrorMessage(Messages.getString("RasterizeOptions.ONLY_DIGITS")); //$NON-NLS-1$
				}
			}
		};
		
		Label mimeLabel = new Label(parent, SWT.HORIZONTAL | SWT.RIGHT);
		mimeLabel.setText(Messages.getString("RasterizeOptions.TYPE")); //$NON-NLS-1$
		
		box = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		box.add(RasterFormat.JPEG);
		box.add(RasterFormat.TIFF);
		box.add(RasterFormat.PNG);
		box.add(RasterFormat.PDF);
		box.select(0);
		box.addSelectionListener(this);
		
		GridData boxData = new GridData();
		boxData.horizontalSpan = 3;
		//boxData.horizontalAlignment = GridData.FILL;
		box.setLayoutData(boxData);

		// Quality
		qualityLabel = new Label(parent, SWT.HORIZONTAL | SWT.RIGHT);
		qualityLabel.setText(Messages.getString("RasterizeOptions.QUALITY")); //$NON-NLS-1$
		qualityText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		qualityText.setText("10"); //$NON-NLS-1$
		qualityText.setTextLimit(2);
		qualityText.setToolTipText(Messages.getString("RasterizeOptions.QUALITY_TOOLTIP")); //$NON-NLS-1$
		Label qualityFeedbackLabel = new Label(parent, SWT.HORIZONTAL | SWT.RIGHT);
		qualityFeedbackLabel.setText(Messages.getString("RasterizeOptions.RANGE")); //$NON-NLS-1$
		Label qualSpacer = new Label(parent, SWT.HORIZONTAL);
		
		// Width
		Label widthLabel = new Label(parent, SWT.HORIZONTAL | SWT.RIGHT);
		widthLabel.setText(Messages.getString("RasterizeOptions.WIDTH")); //$NON-NLS-1$
		widthText = new Text(parent, SWT.SINGLE | SWT.BORDER );
		widthText.setText("600"); //$NON-NLS-1$
		widthText.setTextLimit(4);
		
		// Max. Width
		Label maxWidthLabel = new Label(parent, SWT.HORIZONTAL | SWT.RIGHT);
		maxWidthLabel.setText(Messages.getString("RasterizeOptions.MAX_WIDTH")); //$NON-NLS-1$
		maxWidthText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		maxWidthText.setText("800"); //$NON-NLS-1$
		maxWidthText.setTextLimit(4);

		// Height
		Label widthLabel2 = new Label(parent, SWT.HORIZONTAL | SWT.RIGHT);
		widthLabel2.setText(Messages.getString("RasterizeOptions.HEIGHT")); //$NON-NLS-1$
		heightText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		heightText.setText("600"); //$NON-NLS-1$
		heightText.setTextLimit(4);

		// Max. Height
		Label widthLabel3 = new Label(parent, SWT.HORIZONTAL | SWT.RIGHT);
		widthLabel3.setText(Messages.getString("RasterizeOptions.MAX_HEIGHT")); //$NON-NLS-1$
		maxHeightText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		maxHeightText.setText("800"); //$NON-NLS-1$
		maxHeightText.setTextLimit(4);
		
		// Background Color
		Label colorLabel = new Label(parent, SWT.HORIZONTAL | SWT.RIGHT);
		colorLabel.setText(Messages.getString("RasterizeOptions.BACKGROUND")); //$NON-NLS-1$
		color = new ColorSelector(parent);
		color.setColorValue(new RGB(255,255,255));
		GridData colorData = new GridData();
		colorData.horizontalSpan = 3;
		color.getButton().setLayoutData(colorData);
				
		// Resolution
		Label resLabel = new Label(parent, SWT.HORIZONTAL | SWT.RIGHT);
		resLabel.setText(Messages.getString("RasterizeOptions.RESOLUTION")); //$NON-NLS-1$
		resText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		resText.setText("  72"); //$NON-NLS-1$
		resText.setTextLimit(4);
		
		Label dpiLabel = new Label(parent, SWT.HORIZONTAL | SWT.RIGHT);
		dpiLabel.setText(Messages.getString("RasterizeOptions.DPI")); //$NON-NLS-1$
		Label resSpacer = new Label(parent, SWT.HORIZONTAL);
		
		// On Load
		onloadButton = new Button(parent, SWT.CHECK);
		onloadButton.setSelection(true);
		onloadButton.setText(Messages.getString("RasterizeOptions.ONLOAD_EVENT")); //$NON-NLS-1$
		GridData onloadData = new GridData();
		onloadData.horizontalSpan = 4;
		onloadButton.setLayoutData(onloadData);

		widthText.addVerifyListener(verify);
		maxWidthText.addVerifyListener(verify);
		heightText.addVerifyListener(verify);
		maxHeightText.addVerifyListener(verify);
		qualityText.addVerifyListener(verify);
	}
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		
		new RasterizeOptions(shell, null);
		
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		int index = box.getSelectionIndex();
		Object obj = box.getItem(index);
		if (obj.toString().equals(RasterFormat.JPEG)) {
			enableJPEGControls();
		} else {
			disableJPEGControls();
		}
	}

	/**
	 * 
	 */
	private void disableJPEGControls() {
		qualityLabel.setEnabled(false);
		qualityText.setEnabled(false);		
	}

	/**
	 * 
	 */
	private void enableJPEGControls() {
		qualityLabel.setEnabled(true);
		qualityText.setEnabled(true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent arg0) {
	}
	
	public String getSuffix() {
		String format = box.getItem(box.getSelectionIndex());
		if (format.equals(RasterFormat.JPEG)) {
			return ".jpg"; //$NON-NLS-1$
		} else if (format.equals(RasterFormat.PDF)) {
			return ".pdf"; //$NON-NLS-1$
		} else if (format.equals(RasterFormat.PNG)) {
			return ".png"; //$NON-NLS-1$
		} else {
			return ".tif"; //$NON-NLS-1$
		}		
	}
	
	public LinkedList getOptionsList() {
		String mimeType = null;
		String format = box.getItem(box.getSelectionIndex());
		if (format.equals(RasterFormat.JPEG)) {
			mimeType = "image/jpeg"; //$NON-NLS-1$
		} else if (format.equals(RasterFormat.PDF)) {
			mimeType = "application/pdf"; //$NON-NLS-1$
		} else if (format.equals(RasterFormat.PNG)) {
			mimeType = "image/png"; //$NON-NLS-1$
		} else {
			mimeType = "image/tiff"; //$NON-NLS-1$
		}
		
		LinkedList list = new LinkedList();
		list.add("-m"); //$NON-NLS-1$
		list.add(mimeType);
		list.add("-w"); //$NON-NLS-1$
		list.add(widthText.getText());
		list.add("-h"); //$NON-NLS-1$
		list.add(heightText.getText());
		list.add("-maxw"); //$NON-NLS-1$
		list.add(maxWidthText.getText());
		list.add("-maxh"); //$NON-NLS-1$
		list.add(maxHeightText.getText());
		list.add("-bg"); //$NON-NLS-1$
		list.add(computeRGB());
		list.add("-q"); //$NON-NLS-1$
		
		String qText = qualityText.getText();
		double qDouble = Double.valueOf(qText).doubleValue() / 10d;
		qDouble = Math.min(0.99,qDouble);
		
		list.add(Double.toString(qDouble));
		list.add("-validate"); //$NON-NLS-1$
		
		if (onloadButton.getSelection()) {
			list.add("-onload"); //$NON-NLS-1$
		}
		
		list.add("-scriptSecurityOff"); //$NON-NLS-1$
		
		return list;
	}

	/**
	 * @return
	 */
	private String computeRGB() {
		RGB rgb = color.getColorValue();
		return "255." + rgb.red + "." + rgb.green + "." + rgb.blue; // Format: a.r.g.b (includes alpha channel) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
}
