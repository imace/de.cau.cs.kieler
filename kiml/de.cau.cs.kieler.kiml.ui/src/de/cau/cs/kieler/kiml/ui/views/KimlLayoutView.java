package de.cau.cs.kieler.kiml.ui.views;

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

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;

public class KimlLayoutView extends ViewPart {

    Tree layoutTree;
        
    public KimlLayoutView() {
        
    }

    @Override
    public void createPartControl(Composite parent) {
        
        List<KLayouterInfo> layouters = KimlLayoutServices.getInstance().getEnabledLayouterInfos();
        List<KLayoutType> types = KimlLayoutServices.getInstance().getEnabledLayoutTypes();
        
        Group layoutGroup = new Group(parent, SWT.NONE);
        layoutGroup.setText("Layouters");
        layoutGroup.setToolTipText("All available and enabled layouters.");
        layoutGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        layoutGroup.pack();
        
        layoutTree = new Tree(layoutGroup, SWT.BORDER);   
        
        for (KLayoutType layoutType : types) {
            TreeItem typeTreeItem = new TreeItem(layoutTree, SWT.NONE);
            typeTreeItem.setText(layoutType.getName());
            
            for (KLayouterInfo layouter : layouters) {
                if ( layouter.getLayoutType().equals(layoutType) ){
                    TreeItem ti = new TreeItem(typeTreeItem, SWT.NONE);
                    ti.setText(layouter.getLayouterName());
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
        // TODO Auto-generated method stub
    }
    
    void setExpanded(boolean state){
        for (TreeItem type : layoutTree.getItems()) {
            type.setExpanded(state);
        }
    }
    
    public KLayouterInfo getSelectedLayouter(){
        TreeItem items[] = layoutTree.getSelection();
        if(items.length >= 1){
            String layouterName = items[0].getText();
            KLayouterInfo info = KimlLayoutServices.getInstance().getLayouterInfoForLayouterName(layouterName); 
            if(info.getLayouterName() == null){
                List<KLayouterInfo> ls = KimlLayoutServices.getInstance().getLayouterInfosForType(layouterName);
                if(ls.size() >= 1)
                    info = ls.get(0); // select some layouter from the possible types
            }
            return info; 
        }
        return null;
    }
    
}
