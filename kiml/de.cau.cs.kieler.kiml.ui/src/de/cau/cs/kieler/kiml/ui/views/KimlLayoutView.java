/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.kiml.ui.views;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;

import de.cau.cs.kieler.core.ui.widgets.DefaultItemTree;
import de.cau.cs.kieler.kiml.layout.options.LayoutType;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;

/**
 * The KimlLayoutView is the main user interface to the layout capabilities of KIELER.
 * It shows a list of all installed and enabled layout engines and lets the user select 
 * one of them. It has view actions to trigger layout runs.
 * @author haf
 *
 */
public class KimlLayoutView extends ViewPart {

    /**
     * The tree widget that shows the layouters
     */
    DefaultItemTree layoutTree;
      
    /* 
     * @see ViewPart.createPartControl()
     */
    @Override
    public void createPartControl(Composite parent) {
        
        // get information about the layouters
        List<AbstractLayoutProvider> layouters = KimlLayoutServices.getInstance().getEnabledProviders();
        List<LayoutType> types = new LinkedList<LayoutType>();
        for (AbstractLayoutProvider provider : layouters) {
            if (!types.contains(provider.getType()))
                types.add(provider.getType());
        }
        
        // create a new composite group and set a SWT layout
        Group layoutGroup = new Group(parent, SWT.NONE);
        layoutGroup.setText("Layouters");
        layoutGroup.setToolTipText("All available and enabled layouters.");
        layoutGroup.setLayout(new FillLayout());
        layoutGroup.pack();
        
        // init the tree
        layoutTree = new DefaultItemTree(layoutGroup, SWT.BORDER);   
        
        // set the items of the tree according to the installed layouters
        for (LayoutType layoutType : types) {
            TreeItem typeTreeItem = new TreeItem(layoutTree.getTree(), SWT.NONE);
            typeTreeItem.setText(layoutType.toString());
            
            for (AbstractLayoutProvider layouter : layouters) {
                if ( layouter.getType().equals(layoutType) ){
                    TreeItem ti = new TreeItem(typeTreeItem, SWT.NONE);
                    ti.setText(layouter.getName());
                }
            }
        }
        layoutTree.pack(true);
        layoutTree.debug();
    }

    @Override
    public void setFocus() {
        layoutTree.setFocus();
    }
    
    /**
     * Sets the expanded state of all tree items of the layouter
     * tree. Hence it will either expand or collapse everything.
     * @param state
     */
    public void setExpanded(boolean state){
        layoutTree.setExpanded(state);
    }
    
    /**
     * Returns the currently selected layouter. 
     * @return currently selected layouter, maybe null if no layouter is selected
     */
    public AbstractLayoutProvider getSelectedLayouter(){
        TreeItem item = layoutTree.getDeepChecked();
        if(item != null){
            String layouterName = item.getText();
            AbstractLayoutProvider provider = KimlLayoutServices.getInstance()
                    .getLayoutProvider(layouterName); 
            if(provider.getName() == null){
                List<AbstractLayoutProvider> ls = KimlLayoutServices.getInstance().getEnabledProviders(provider.getType());
                if(ls.size() >= 1)
                    provider = ls.get(0); // select some layouter from the possible types
            }
            return provider; 
        }
        return null;
    }
    
}
