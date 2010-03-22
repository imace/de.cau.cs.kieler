/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.synccharts.diagram.custom;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.gef.EditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.IWorkbenchPart;

import de.cau.cs.kieler.viewmanagement.effects.ShapeHighlightEffect;

/**
 * Manager for highlighting of edit parts.
 * 
 * @author soh
 */
public class HighlightingManager {

    /** Map containing all highlighting effects and highlighted edit parts. */
    private HashMap<IWorkbenchPart, HashMap<EditPart, ShapeHighlightEffect>> map;

    /** singleton instance. */
    private static HighlightingManager instance = new HighlightingManager();

    /** singleton pattern. */
    private HighlightingManager() {
        map = new HashMap<IWorkbenchPart, HashMap<EditPart, ShapeHighlightEffect>>();
    }

    /**
     * Highlight an edit part with the given colors. This will override any
     * highlighting effect currently in place on the particular edit part.
     * 
     * The highlighting can be reset by calling the reset methods.
     * 
     * @param editor
     *            the editor
     * @param editPart
     *            the edit part
     * @param foreground
     *            the foreground color
     * @param background
     *            the background color
     */
    public static void highlight(final IWorkbenchPart editor,
            final EditPart editPart, final Color foreground,
            final Color background) {
        HashMap<EditPart, ShapeHighlightEffect> parts = instance.map
                .get(editor);
        if (parts == null) {
            parts = new HashMap<EditPart, ShapeHighlightEffect>();
            instance.map.put(editor, parts);
        }
        ShapeHighlightEffect oldEffect = parts.remove(editPart);
        if (oldEffect != null) {
            oldEffect.undo();
        }

        ShapeHighlightEffect newEffect = new ShapeHighlightEffect();
        newEffect.setColors(foreground, background);
        newEffect.setTarget(editPart);
        parts.put(editPart, newEffect);
        newEffect.execute();
    }

    /**
     * Reset all highlighting effects on the given editor.
     * 
     * @param editor
     *            the editor
     */
    public static void reset(final IWorkbenchPart editor) {
        HashMap<EditPart, ShapeHighlightEffect> parts = instance.map
                .get(editor);

        if (parts != null) {
            Iterator<EditPart> iter = parts.keySet().iterator();
            while (iter.hasNext()) {
                EditPart part = iter.next();
                parts.get(part).undo();
            }
            instance.map.remove(editor);
        }
    }

    /**
     * Reset the highlighting on the given edit part.
     * 
     * @param editor
     *            the editor
     * @param editPart
     *            the edit part
     */
    public static void reset(final IWorkbenchPart editor,
            final EditPart editPart) {
        HashMap<EditPart, ShapeHighlightEffect> parts = instance.map
                .get(editor);

        if (parts != null && parts.containsKey(editPart)) {
            ShapeHighlightEffect effect = parts.remove(editPart);
            effect.undo();
        }
    }

    /**
     * Highlight the given edit part.
     * 
     * @param part
     *            the part
     * @param foreground
     *            the foreground color
     * @param background
     *            the background color
     */
    private static void highlightPart(final EditPart part,
            final Color foreground, final Color background) {
        ShapeHighlightEffect newEffect = new ShapeHighlightEffect();
        newEffect.setColors(foreground, background);
        newEffect.setTarget(part);
        newEffect.execute();
    }
}
