package de.cau.cs.kieler.klots.editor;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.texteditor.AbstractMarkerAnnotationModel;
import org.eclipse.ui.texteditor.MarkerUtilities;

import de.cau.cs.kieler.core.kivi.AbstractEffect;


@SuppressWarnings("restriction")
public class HighlightSJMarkerEffect extends AbstractEffect {

    private JavaEditor editor;
    
    private IMarker marker;
    private IGotoMarker gotoMarker;

    private Color originalColor;
    private Color originalBackgroundColor;

    private Color color;
    private Color backgroundColor;
    
    private TextStyle newTextStyle;
    private TextStyle oldTextStyle;


    
    public HighlightSJMarkerEffect(IMarker marker, Color color, Color backgroundColor, Color originalColor, Color originalBackgroundColor, JavaEditor editor) {
    	this.marker = marker;
    	this.gotoMarker = (IGotoMarker) editor.getAdapter(IGotoMarker.class);
    	this.color = color;
    	this.backgroundColor = backgroundColor;
    	this.originalColor = originalColor;
    	this.originalBackgroundColor = originalBackgroundColor;
    	this.editor = editor;
    	this.newTextStyle = null;
    	this.oldTextStyle = null;
    }
    
    
    public HighlightSJMarkerEffect(IMarker marker, TextStyle newTextStyle, TextStyle oldTextStyle, JavaEditor editor) {
    	this.marker = marker;
    	this.gotoMarker = (IGotoMarker) editor.getAdapter(IGotoMarker.class);
    	this.newTextStyle = newTextStyle;
    	this.oldTextStyle = oldTextStyle;
    	this.editor = editor;
    }
    


	public void execute() {
//		try {
//			gotoMarker(marker);
			if( gotoMarker != null ) {
				gotoMarker.gotoMarker(marker);
			}
			Point p = editor.getViewer().getTextWidget().getSelectionRange();
			StyleRange range;
			if( newTextStyle != null ) {
				range = new StyleRange(newTextStyle);
				range.start = p.x;
				range.length = p.y;
			} else {
				range = new StyleRange(p.x, p.y, color, backgroundColor);
			}
			editor.getViewer().getTextWidget().setStyleRange(range);
			editor.getViewer().getTextWidget().setSelectionRange(p.x, 0);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
    }

    
    @Override
    public void undo() {
//    	try {
//    		gotoMarker(marker);
			if( gotoMarker != null ) {
				gotoMarker.gotoMarker(marker);
			}
			Point p = editor.getViewer().getTextWidget().getSelectionRange();
			StyleRange range;
			if( oldTextStyle != null ) {
				range = new StyleRange(oldTextStyle);
				range.start = p.x;
				range.length = p.y;
			} else {
				range = new StyleRange(p.x, p.y, originalColor, originalBackgroundColor);
			}
			editor.getViewer().getTextWidget().setStyleRange(range);
			editor.getViewer().getTextWidget().setSelectionRange(p.x, 0);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
    }

    

    @Override
    public boolean isMergeable() {
        return false;
    }

    
    @Override
    public HighlightSJMarkerEffect clone() {
    	if( newTextStyle != null && oldTextStyle != null) {
    		return new HighlightSJMarkerEffect(marker, newTextStyle, oldTextStyle, editor);
    	} else {
    		return new HighlightSJMarkerEffect(marker, color, backgroundColor, color, backgroundColor, editor);
    	}
    }



	void setColor(Color color) {
		this.color = color;
	}



	void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

    
	
	
	
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	
//	protected void selectAndReveal(int selectionStart, int selectionLength, int revealStart, int revealLength) {
//		ISourceViewer fSourceViewer = editor.getViewer();
//		if (fSourceViewer == null)
//			return;
//
//		ISelection selection= editor.getSelectionProvider().getSelection();
//		if (selection instanceof ITextSelection) {
//			ITextSelection textSelection= (ITextSelection) selection;
//			if (textSelection.getOffset() != 0 || textSelection.getLength() != 0)
//				markInNavigationHistory();
//		}
//
//		StyledText widget= fSourceViewer.getTextWidget();
//		widget.setRedraw(false);
//		{
//			adjustHighlightRange(revealStart, revealLength);
//			
//			// ----------------------------------------------------
//			// XXX: COMMENTED OUT BY ME!
//			fSourceViewer.revealRange(revealStart, revealLength);
//			// ----------------------------------------------------
//
//			fSourceViewer.setSelectedRange(selectionStart, selectionLength);
//			
//			// --------------------------------------------------------------
//			// XXX: ADDED BY ME!
////			if( fSourceViewer.getTopIndexStartOffset() > selectionStart || fSourceViewer.getBottomIndexEndOffset() < selectionStart ) {
////				System.out.println("ZZZZZZZZZZZZZZZZZZZZ>>>> instruction name = " + marker.getAttribute("instructionName", "NO NAME"));
////				System.out.println("ZZZZZZZZZZZZZZZZZZZZ>>>> fSourceViewer.getTopIndexStartOffset() = " + fSourceViewer.getTopIndexStartOffset());
////				System.out.println("ZZZZZZZZZZZZZZZZZZZZ>>>> selectionStart = " + selectionStart);
////				System.out.println("ZZZZZZZZZZZZZZZZZZZZ>>>> fSourceViewer.getBottomIndexEndOffset() = " + fSourceViewer.getBottomIndexEndOffset());
////				fSourceViewer.revealRange(revealStart, revealLength);
////			}
//			// --------------------------------------------------------------
//
//			markInNavigationHistory();
//		}
//		widget.setRedraw(true);
//	}
//	
//	
//	
//	public void gotoMarker(IMarker marker) {
//		// ----------------------------------------------------
//		// XXX: COMMENTED OUT BY ME!
////		if (fIsUpdatingMarkerViews)
////			return;
////		
////		if (getSourceViewer() == null)
////			return;
//		// ----------------------------------------------------
//
//		int start= MarkerUtilities.getCharStart(marker);
//		int end= MarkerUtilities.getCharEnd(marker);
//		
//		boolean selectLine= start < 0 || end < 0;
//
//		// look up the current range of the marker when the document has been edited
//		IAnnotationModel model= editor.getDocumentProvider().getAnnotationModel(editor.getEditorInput());
//		if (model instanceof AbstractMarkerAnnotationModel) {
//
//			AbstractMarkerAnnotationModel markerModel= (AbstractMarkerAnnotationModel) model;
//			Position pos= markerModel.getMarkerPosition(marker);
//			if (pos != null && !pos.isDeleted()) {
//				// use position instead of marker values
//				start= pos.getOffset();
//				end= pos.getOffset() + pos.getLength();
//			}
//
//			if (pos != null && pos.isDeleted()) {
//				// do nothing if position has been deleted
//				return;
//			}
//		}
//
//		IDocument document= editor.getDocumentProvider().getDocument(editor.getEditorInput());
//
//		if (selectLine) {
//			int line;
//			try {
//				if (start >= 0)
//					line= document.getLineOfOffset(start);
//				else {
//					line= MarkerUtilities.getLineNumber(marker);
//					// Marker line numbers are 1-based
//					-- line;
//					start= document.getLineOffset(line);
//				}
//				end= start + document.getLineLength(line) - 1;
//			} catch (BadLocationException e) {
//				return;
//			}
//		}
//
//		int length= document.getLength();
//		if (end - 1 < length && start < length)
//			selectAndReveal(start, end - start, start, end - start);
//	}
//	
//	
//	
//	protected void adjustHighlightRange(int offset, int length) {
//		ISourceViewer fSourceViewer = editor.getViewer();
//		if (fSourceViewer == null)
//			return;
//
//		if (fSourceViewer instanceof ITextViewerExtension5) {
//			ITextViewerExtension5 extension= (ITextViewerExtension5) fSourceViewer;
//			extension.exposeModelRange(new Region(offset, length));
//		} else if (!isVisible(fSourceViewer, offset, length)) {
//			fSourceViewer.resetVisibleRegion();
//		}
//	}
//	
//	
//	
//	protected static final boolean isVisible(ISourceViewer viewer, int offset, int length) {
//		if (viewer instanceof ITextViewerExtension5) {
//			ITextViewerExtension5 extension= (ITextViewerExtension5) viewer;
//			IRegion overlap= extension.modelRange2WidgetRange(new Region(offset, length));
//			return overlap != null;
//		}
//		return viewer.overlapsWithVisibleRegion(offset, length);
//	}
//	
//	
//	
//	protected void markInNavigationHistory() {
//		editor.getSite().getPage().getNavigationHistory().markLocation(editor);
//	}
	
}