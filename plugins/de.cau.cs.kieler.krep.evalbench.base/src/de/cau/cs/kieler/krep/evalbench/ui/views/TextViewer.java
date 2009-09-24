package de.cau.cs.kieler.krep.evalbench.ui.views;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

/**
 * A Viewer for displaying some sort of text content.
 * 
 * @author msp
 */
public class TextViewer extends ContentViewer {

	/** Font name used for displayed text */
	private static final String FONT_NAME = "monospace";
	/** Font size used for displayed text */
	private static final int FONT_SIZE = 10;
	
	/** The text area used to display the text content */
	private Text text;
	
	/**
	 * Creates a new text viewer.
	 * @param parent component that contains the text
	 */
	public TextViewer(Composite parent) {
		super();
		text = new Text(parent, SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		text.setEditable(false);
		text.setFont(new Font(Display.getCurrent(), FONT_NAME, FONT_SIZE, SWT.NORMAL));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.Viewer#getControl()
	 */
	@Override
	public Control getControl() {
		return text;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.Viewer#getSelection()
	 */
	@Override
	public ISelection getSelection() {
		Point selection = text.getSelection();
		return new TextSelection(new Document(text.getText()),
				selection.x, selection.y - selection.x);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.Viewer#refresh()
	 */
	@Override
	public void refresh() {
		text.redraw();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.Viewer#setSelection(org.eclipse.jface.viewers.ISelection, boolean)
	 */
	@Override
	public void setSelection(ISelection selection, boolean reveal) {
		try {
			ITextSelection textSelection = (ITextSelection)selection;
			text.setSelection(textSelection.getOffset(),
					textSelection.getOffset() + textSelection.getLength());
		} catch (ClassCastException e) {
		    // Ignore silently
		}
	}
	
	/**
	 * Changes the displayed text to the given string.
	 * 
	 * @param s text to be displayed
	 */
	public void setText(String s) {
		text.setText(s);
	}
	
	/**
	 * Appends the given string to the currently displayed text.
	 * 
	 * @param s text to be appended
	 */
	public void append(String s) {
		text.append(s);
	}

}
