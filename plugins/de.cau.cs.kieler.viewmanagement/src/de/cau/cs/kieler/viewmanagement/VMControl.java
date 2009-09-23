package de.cau.cs.kieler.viewmanagement;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;



public class VMControl extends ViewPart {


        
        DataTableViewer viewer;

     public VMControl() {
                super();
              
        }

     public void init(IViewSite site) throws PartInitException {
                super.init(site);
            
        }


     @Override
     public void createPartControl(Composite parent) {
 		createViewer(parent);
 		viewer.setInput(new TableDataList(viewer));
// 		hookSideEffectActions();
 		hookContextMenu();
// 		contributeToActionBars();
// 		updateEnabled();			
 	}
  
            
        private void createViewer(Composite parent) {
		viewer = new DataTableViewer(parent,SWT.HIDE_SELECTION |
				SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		createColumns(viewer);
		viewer.setContentProvider(new TableDataContentProvider());
		viewer.setLabelProvider(new TableDataLabelProvider());
//		viewer.getControl().addKeyListener(new KeyListener(){
//			public void keyPressed(KeyEvent e) {
//				//if user pressed delete
//				if (e.keyCode == 127) {
//					getActionDelete().run();
//				}
//			}
//			public void keyReleased(KeyEvent e) {
//			}
		};
	

        private void createColumns(DataTableViewer viewer) {
    		String[] titles = { "Active", "Combination" };
    		String[] toolTip = { "Active/Inactive", "Name of Combination"};
    		int[] bounds = {52, 350};
    		
    		for (int i = 0; i < titles.length; i++) {
    			TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.NONE);
    			column.getColumn().setText(titles[i]);
    			column.getColumn().setWidth(bounds[i]);
    			column.getColumn().setToolTipText(toolTip[i]);
    			column.getColumn().setResizable(true);
    			column.getColumn().setMoveable(true);
    			if (i == 0)
    				column.getColumn().setResizable(false);
//    			else
//    				column.setEditingSupport(new TableDataEditing(viewer, i));
    		}
    		Tree tree = viewer.getTree();
    		tree.setHeaderVisible(true);
    		tree.setLinesVisible(true);
    	}
        
        private void hookContextMenu() {
    		MenuManager menuMgr = new MenuManager("#PopupMenu");
    		menuMgr.setRemoveAllWhenShown(true);
    		menuMgr.addMenuListener(new IMenuListener() {
    			public void menuAboutToShow(IMenuManager manager) {
//    				buildContextMenu(manager);
    			}
    		});
    		Menu menu = menuMgr.createContextMenu(viewer.getControl());
    		viewer.getControl().setMenu(menu);
    		getSite().registerContextMenu(menuMgr, viewer);
    	}
        
//        private void buildContextMenu(IMenuManager manager) {
////    		manager.add(getActionSignal());
////   		manager.add(getActionPermanent());
//    		manager.add(new Separator());
////    		manager.add(getActionAdd());
////    		manager.add(getActionDelete());
//    		// Other plug-ins can contribute there actions here
//    		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
//    	}
//        
//        private void contributeToActionBars() {
//    		IActionBars bars = getViewSite().getActionBars();
//    		IToolBarManager toolBarManager = bars.getToolBarManager();
////    		toolBarManager.add(getActionAdd());
////    		toolBarManager.add(getActionDelete());
//    		toolBarManager.add(new Separator());
////    		toolBarManager.add(getActionSignal());
////    		toolBarManager.add(getActionPermanent());
//    	}

		
        
        /**
         * @see WorkbenchPart#setFocus()
         */
        public void setFocus(){ 
                viewer.getControl().setFocus();
        }
        
}
	
