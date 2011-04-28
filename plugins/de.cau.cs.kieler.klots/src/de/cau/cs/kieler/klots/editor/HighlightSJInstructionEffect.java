/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klots.editor;

import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import de.cau.cs.kieler.core.kivi.AbstractEffect;


/**
 * @author root
 *
 */
@SuppressWarnings("restriction")
public class HighlightSJInstructionEffect extends AbstractEffect {

    private CompilationUnitEditor editor;

    private int startOffset;
    private int textLength;

    private Color originalColor;
    private Color originalBackgroundColor;

    private Color color;
    private Color backgroundColor;



    /**
     * @param startOffset 
     * @param textLength 
     * @param color 
     * @param backgroundColor 
     * @param originalColor 
     * @param originalBackgroundColor 
     * @param editor 
     */
    public HighlightSJInstructionEffect(final int startOffset, final int textLength,
            final Color color, final Color backgroundColor,
            final Color originalColor, final Color originalBackgroundColor,
            final CompilationUnitEditor editor) {
        this.startOffset = startOffset;
        this.textLength = textLength;
        this.color = color;
        this.backgroundColor = backgroundColor;
        this.originalColor = originalColor;
        this.originalBackgroundColor = originalBackgroundColor;
        this.editor = editor;
    }



    /**
     * {@inheritDoc}
     */
    public void execute() {
        try {
            if (backgroundColor != null) {
                editor.getViewer().getTextWidget().setStyleRange(
                        new StyleRange(startOffset, textLength, originalColor, backgroundColor));
            }
            if (color != null) {
                editor.getViewer().setTextColor(color, startOffset, textLength, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    @Override
    public void undo() {
        try {
            if (originalBackgroundColor != null) {
                editor.getViewer().getTextWidget().setStyleRange(
                        new StyleRange(startOffset, textLength, originalColor, originalBackgroundColor));
            }
            if (originalColor != null) {
                editor.getViewer().setTextColor(originalColor, startOffset, textLength, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public boolean isMergeable() {
        return false;
    }


    
    @Override
    public HighlightSJInstructionEffect clone() {
        return new HighlightSJInstructionEffect(startOffset, textLength, color, backgroundColor,
                color, backgroundColor, editor);
    }



    void setColor(final Color color) {
        this.color = color;
    }



    void setBackgroundColor(final Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }


}