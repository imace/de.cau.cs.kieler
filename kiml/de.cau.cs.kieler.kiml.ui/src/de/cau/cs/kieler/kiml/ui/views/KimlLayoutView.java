package de.cau.cs.kieler.kiml.ui.views;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;

import de.cau.cs.kieler.kiml.layout.options.LayoutType;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;

public class KimlLayoutView extends ViewPart {

    Tree layoutTree;
        
    public KimlLayoutView() {
        
    }

    @Override
    public void createPartControl(Composite parent) {
        
        List<AbstractLayoutProvider> layouters = KimlLayoutServices.getInstance().getEnabledProviders();
        List<LayoutType> types = new LinkedList<LayoutType>();
        for (AbstractLayoutProvider provider : layouters) {
            if (!types.contains(provider.getType()))
                types.add(provider.getType());
        }
        
        Group layoutGroup = new Group(parent, SWT.NONE);
        layoutGroup.setText("Layouters");
        layoutGroup.setToolTipText("All available and enabled layouters.");
        layoutGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        layoutGroup.pack();
        
        layoutTree = new Tree(layoutGroup, SWT.BORDER);   
        
        for (LayoutType layoutType : types) {
            TreeItem typeTreeItem = new TreeItem(layoutTree, SWT.NONE);
            typeTreeItem.setText(layoutType.toString());
            
            for (AbstractLayoutProvider layouter : layouters) {
                if (layouter.getType().equals(layoutType) ){
                    TreeItem ti = new TreeItem(typeTreeItem, SWT.NONE);
                    ti.setText(layouter.getName());
                }
            }
        }
        this.setExpanded(true);
        layoutTree.pack();
        
        final Button expandButton = new Button(layoutGroup, SWT.TOGGLE);
        expandButton.setText("Expand all");
        expandButton.setSelection(false);
        expandButton.addSelectionListener(new SelectionAdapter(){
            public void widgetSelected(SelectionEvent e){
                setExpanded(expandButton.getSelection());
                layoutTree.pack();
            }
        });
    }

    @Override
    public void setFocus() {
        layoutTree.setFocus();
    }
    
    void setExpanded(boolean state){
        for (TreeItem type : layoutTree.getItems()) {
            type.setExpanded(state);
        }
    }
    
    public AbstractLayoutProvider getSelectedLayouter(){
        TreeItem items[] = layoutTree.getSelection();
        if(items.length >= 1){
            String layouterName = items[0].getText();
            AbstractLayoutProvider provider = KimlLayoutServices.getInstance()
                    .getLayoutProvider(layouterName); 
            if (provider.getName() == null) {
                List<AbstractLayoutProvider> ls = KimlLayoutServices.getInstance()
                        .getEnabledProviders(provider.getType());
                if(ls.size() >= 1)
                    provider = ls.get(0); // select some layouter from the possible types
            }
            return provider; 
        }
        return null;
    }
    
}
