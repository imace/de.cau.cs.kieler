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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;

import de.cau.cs.kieler.core.ui.widgets.DefaultItemTree;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.layout.services.LayoutProviderData;
import de.cau.cs.kieler.kiml.layout.services.LayoutServices;

/**
 * The LayoutView is the main user interface to the layout capabilities of KIELER.
 * It shows a list of all installed and enabled layout engines and lets the user select 
 * one of them. It has view actions to trigger layout runs.
 * @author haf
 *
 */
public class LayoutView extends ViewPart {

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
        Collection<LayoutProviderData> layouters = LayoutServices.INSTANCE.getLayoutProviderData();
        List<String> types = new LinkedList<String>();
        for (LayoutProviderData provider : layouters) {
            if (!types.contains(provider.type))
                types.add(provider.type);
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
        for (String layoutType : types) {
            TreeItem typeTreeItem = new TreeItem(layoutTree.getTree(), SWT.NONE);
            typeTreeItem.setText(LayoutServices.INSTANCE.getLayoutTypeName(layoutType));
            typeTreeItem.setData(layoutType);
            
            for (LayoutProviderData layouter : layouters) {
                if (layouter.type.equals(layoutType) ){
                    TreeItem ti = new TreeItem(typeTreeItem, SWT.NONE);
                    ti.setText(layouter.name);
                    ti.setData(layouter);
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
        if (item != null) {
            if (item.getData() instanceof String) {
                // select some layouter for the selected type
                String typeid = (String)item.getData();
                Collection<LayoutProviderData> providerDatas = LayoutServices.INSTANCE.getLayoutProviderData();
                for (LayoutProviderData data : providerDatas) {
                    if (data.type.equals(typeid))
                        return data.instance;
                }
            }
            else if (item.getData() instanceof LayoutProviderData)
                return ((LayoutProviderData)item.getData()).instance; 
        }
        return null;
    }
    
}
