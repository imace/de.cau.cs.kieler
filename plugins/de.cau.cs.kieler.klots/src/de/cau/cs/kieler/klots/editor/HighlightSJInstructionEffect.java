package de.cau.cs.kieler.klots.editor;

import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import de.cau.cs.kieler.core.kivi.AbstractEffect;


@SuppressWarnings("restriction")
public class HighlightSJInstructionEffect extends AbstractEffect {

    private CompilationUnitEditor editor;
    
    private int startOffset;
    private int textLength;

    private Color originalColor;
    private Color originalBackgroundColor;

    private Color color;
    private Color backgroundColor;


    
    public HighlightSJInstructionEffect(int startOffset, int textLength, Color color, Color backgroundColor, Color originalColor, Color originalBackgroundColor, CompilationUnitEditor editor) {
    	this.startOffset = startOffset;
    	this.textLength = textLength;
    	this.color = color;
    	this.backgroundColor = backgroundColor;
    	this.originalColor = originalColor;
    	this.originalBackgroundColor = originalBackgroundColor;
    	this.editor = editor;
    }
    


	public void execute() {
		try {
			if( backgroundColor != null ) {
				editor.getViewer().getTextWidget().setStyleRange( new StyleRange(startOffset, textLength, originalColor, backgroundColor) );
			}
			if( color != null ) {
				editor.getViewer().setTextColor(color, startOffset, textLength, true);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    
    @Override
    public void undo() {
    	try {
			if( originalBackgroundColor != null ) {
				editor.getViewer().getTextWidget().setStyleRange( new StyleRange(startOffset, textLength, originalColor, originalBackgroundColor) );
			}
			if( originalColor != null ) {
				editor.getViewer().setTextColor(originalColor, startOffset, textLength, true);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    

    @Override
    public boolean isMergeable() {
        return false;
    }

    
    @Override
    public HighlightSJInstructionEffect clone() {
    	return new HighlightSJInstructionEffect(startOffset, textLength, color, backgroundColor, color, backgroundColor, editor);
    }



	void setColor(Color color) {
		this.color = color;
	}



	void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

    
}