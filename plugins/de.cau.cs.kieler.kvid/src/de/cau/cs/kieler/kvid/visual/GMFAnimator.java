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
package de.cau.cs.kieler.kvid.visual;

import java.util.HashMap;
import java.util.List;

import muvitorkit.animation.AnimatingCommand;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

import de.cau.cs.kieler.sim.kiem.KiemPlugin;

/**
 * 
 * Class handling the animation of data figures in GMF.
 * 
 * @author jjc
 *
 */
public final class GMFAnimator {
    
    private GMFAnimator() { }
    
    /**
     * 
     * Call this method to animate the given objects.
     * 
     * @param figuresAndPath Hashmap holding the KViDFigures and the path to follow
     * @param diagram The diagram in which the animation should take place
     * @param animationTime The time an animation may use to perform
     */
    public static void animate(final HashMap<IKViDFigure, List<Point>> figuresAndPath,
                               final DiagramEditPart diagram,
                               final int animationTime) {

        AnimatingCommand anima = new AnimatingCommand();
        CompoundCommand cc = new CompoundCommand();
        boolean allPathsExeeded = false;
        int pathCounter = 0;
        
        while (!allPathsExeeded) {
            allPathsExeeded = true;
            for (IKViDFigure figure : figuresAndPath.keySet()) {
                if (pathCounter == 0) {
                    anima.initializeAnimatedElement(figure, diagram.getViewer());
                }
                if (pathCounter < figuresAndPath.get(figure).size()) {      
                    anima.specifyStep(figure, figuresAndPath.get(figure).get(pathCounter));
                    if ((pathCounter + 1) < figuresAndPath.get(figure).size()) {
                        allPathsExeeded = false;
                    }
                }
            }
            if (!allPathsExeeded) {
                anima.nextStep();
            }
            pathCounter++;
        }
        
        anima.setCompleteDuration(animationTime / 2);
        cc.add(anima);
        diagram.getDiagramEditDomain().getDiagramCommandStack().execute(cc);
    }
    
}
