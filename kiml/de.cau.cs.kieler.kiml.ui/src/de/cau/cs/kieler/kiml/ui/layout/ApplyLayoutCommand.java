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
package de.cau.cs.kieler.kiml.ui.layout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;

import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutData;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;

/**
 * Command used to apply layout.
 * 
 * @author haf, msp
 * @see org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand
 * @see org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand
 * @see org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand
 */
public class ApplyLayoutCommand extends AbstractTransactionalCommand {

    /** adapter for the view of the base diagram */
    private IAdaptable diagramViewAdapter;
    /** list of views with associated layout data */
    private List<Pair<View, KLayoutData>> layoutDataList = new LinkedList<Pair<View, KLayoutData>>();
    
    /**
     * Creates a command to apply layout.
     * 
     * @param domain the editing domain through which model changes are made
     * @param label the command label
     * @param adapter an adapter to the {@code View} of the base diagram
     */
    public ApplyLayoutCommand(TransactionalEditingDomain domain, String label,
            IAdaptable adapter) {
        super(domain, label, null);
        this.diagramViewAdapter = adapter;
    }
    
    /**
     * Adds the given layout data as new layout for the given view.
     * 
     * @param view view from the GMF notation model
     * @param layoutData new layout data for the view
     */
    public void addLayoutData(View view, KLayoutData layoutData) {
        layoutDataList.add(new Pair<View, KLayoutData>(view, layoutData));
    }

    /* (non-Javadoc)
     * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
            IAdaptable info) throws ExecutionException {
        for (Pair<View, KLayoutData> layoutPair : layoutDataList) {
            if (layoutPair.second instanceof KShapeLayout) {
                View view = layoutPair.first;
                KShapeLayout shapeLayout = (KShapeLayout)layoutPair.second;
                // set new location of the element
                ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X(),
                        new Integer(Math.round(shapeLayout.getXpos())));
                ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y(),
                        new Integer(Math.round(shapeLayout.getYpos())));
                // set new size of the element
                ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width(),
                        new Integer(Math.round(shapeLayout.getWidth())));
                ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height(),
                        new Integer(Math.round(shapeLayout.getHeight())));
            }
            else if (layoutPair.second instanceof KEdgeLayout) {
                Edge edge = (Edge)layoutPair.first;
                KEdgeLayout edgeLayout = (KEdgeLayout)layoutPair.second;
                // set new bend points of the edge
                List<RelativeBendpoint> newBendpoints = new ArrayList<RelativeBendpoint>(
                        edgeLayout.getBendPoints().size());
                KPoint sourcePoint = edgeLayout.getSourcePoint();
                KPoint targetPoint = edgeLayout.getTargetPoint();
                for (KPoint bendPoint : edgeLayout.getBendPoints()) {
                    newBendpoints.add(new RelativeBendpoint(
                            Math.round(bendPoint.getX() - sourcePoint.getX()),
                            Math.round(bendPoint.getY() - sourcePoint.getY()),
                            Math.round(bendPoint.getX() - targetPoint.getX()),
                            Math.round(bendPoint.getY() - targetPoint.getY())));
                }
                RelativeBendpoints points = (RelativeBendpoints) edge.getBendpoints();
                points.setPoints(newBendpoints);
                // set new anchor points of the edge
            }
        }
        
        return CommandResult.newOKCommandResult();
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#getAffectedFiles()
     */
    @Override
    public List<?> getAffectedFiles() {
        if (diagramViewAdapter != null) {
            View view = (View)diagramViewAdapter.getAdapter(View.class);
            if (view != null) {
                return getWorkspaceFiles(view);
            }
        }
        return super.getAffectedFiles();
    }

}
