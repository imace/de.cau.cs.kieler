/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
 * 
 *****************************************************************************/
package de.cau.cs.kieler.synccharts.custom.contextMenu;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author haf
 *
 */
public class TestDiagramAction extends DiagramAction {

    public static final String ACTION_ID = "de.cau.cs.kieler.synccharts.custom.contextmenu.testdiagramaction";
    
    /**
     * @param workbenchPage
     */
    public TestDiagramAction(IWorkbenchPage workbenchPage) {
        super(workbenchPage);
        setId(ACTION_ID);
        setText("TestDiagramAction");
        setToolTipText("TestDiagramAction");
    }

    /* (non-Javadoc)
     * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
     */
    @Override
    protected Request createTargetRequest() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener()
     */
    @Override
    protected boolean isSelectionListener() {
        // TODO Auto-generated method stub
        return true;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#doRun(org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    protected void doRun(IProgressMonitor progressMonitor) {
        // TODO Auto-generated method stub
        super.doRun(progressMonitor);
        System.out.println("Test");
    }

}
