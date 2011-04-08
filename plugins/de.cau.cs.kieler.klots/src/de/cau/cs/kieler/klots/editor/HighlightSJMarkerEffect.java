package de.cau.cs.kieler.klots.editor;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.ui.ide.IGotoMarker;
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

	
}