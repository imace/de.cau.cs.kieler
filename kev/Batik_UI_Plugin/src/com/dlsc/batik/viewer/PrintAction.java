/*
 * Created on 16.03.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dlsc.batik.viewer;

import java.awt.print.PrinterException;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.svg.SVGUserAgent;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.print.PrintTranscoder;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorPart;
import org.w3c.dom.svg.SVGDocument;
import com.dlsc.batik.editor.SVGMultiPageEditorPart;
import com.dlsc.batik.editor.SVGViewEditor;

/**
 * @author dlemmermann
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PrintAction extends Action {
	private SVGUserAgent userAgent;
	private JSVGCanvas svgCanvas;
	
	public PrintAction() {
		super(Messages.getString("PrintAction.PRINT"));		 //$NON-NLS-1$
		setToolTipText(Messages.getString("PrintAction.TOOLTIP")); //$NON-NLS-1$
	}
	
	public PrintAction(SVGComposite svg) {
		this();
		init(svg);
	}
	
	private void init(SVGComposite svg) {
		svgCanvas = svg.getSvgCanvas();
		userAgent= svg.getUserAgent();		
	}
	
	public void setEditor(IEditorPart part) {
		setEnabled(false);
		if (part instanceof SVGMultiPageEditorPart) {
			SVGMultiPageEditorPart multi = (SVGMultiPageEditorPart) part;
			SVGViewEditor view = multi.getSvgViewEditor();
			init(view.getSVGComposite());
			setEnabled(true);
		}
	}
	
	public void run() {
		SVGDocument svgDocument = svgCanvas.getSVGDocument();
		
		if (svgDocument != null) {
			final SVGDocument doc = svgDocument;
			new Thread() {
				public void run(){
					String uri = doc.getURL();
					String fragment = svgCanvas.getFragmentIdentifier();
					if (fragment != null) {
						uri += "#"+fragment; //$NON-NLS-1$
					}
					
					//
					// Build a PrintTranscoder to handle printing
					// of the svgDocument object
					//
					PrintTranscoder pt = new PrintTranscoder();
					
					//
					// Set transcoding hints
					//
					pt.addTranscodingHint(PrintTranscoder.KEY_XML_PARSER_CLASSNAME,
							userAgent.getXMLParserClassName());
					
					pt.addTranscodingHint(PrintTranscoder.KEY_SHOW_PAGE_DIALOG,
							Boolean.TRUE);
					
					
					pt.addTranscodingHint(PrintTranscoder.KEY_SHOW_PRINTER_DIALOG,
							Boolean.TRUE);
					
					//
					// Do transcoding now
					//
					pt.transcode(new TranscoderInput(uri), null);
					
					//
					// Print
					//
					try {
						pt.print();
					} catch (PrinterException ex) {
						userAgent.displayError(ex);
					}
				}
			}.start();
		}
	}
}
