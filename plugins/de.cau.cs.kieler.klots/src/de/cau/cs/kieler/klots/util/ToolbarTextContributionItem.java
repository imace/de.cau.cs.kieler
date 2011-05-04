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
package de.cau.cs.kieler.klots.util;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

/**
 * @author root
 *
 */
public class ToolbarTextContributionItem extends ContributionItem {
    
    private static final Font DEFAULT_FONT = new Font(Display.getDefault(), "Verdana", 7, SWT.BOLD);
    private static final int DEFAULT_WIDTH = 120;
    private String contributionItemText;
    
    
    
    /**
     * @param text 
     */
    public ToolbarTextContributionItem(final String text) {
        super(text);
        contributionItemText = text;
    }
    
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public final void fill(final ToolBar parent, final int index) {
        Label text = new Label(parent, SWT.RIGHT);
        text.setText(contributionItemText);
        text.setFont(DEFAULT_FONT);
        ToolItem ti = new ToolItem(parent, SWT.SEPARATOR, index);
        ti.setControl(text);
        ti.setWidth(DEFAULT_WIDTH);
    }
}
