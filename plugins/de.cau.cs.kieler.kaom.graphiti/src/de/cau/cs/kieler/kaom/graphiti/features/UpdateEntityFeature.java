/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kaom.graphiti.features;




//import java.util.Iterator;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.mm.pictograms.Text;

import de.cau.cs.kieler.kaom.Entity;

/**
 * 
 * @author atr
 * Update any changes made to Entity
 */
public class UpdateEntityFeature extends AbstractUpdateFeature {

    /**
     * 
     * @param fp
     * Constructor
     */
    public UpdateEntityFeature(final IFeatureProvider fp) {
        super(fp);
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     * {@inheritDoc}
     */
    public boolean canUpdate(final IUpdateContext context) {
        // TODO Auto-generated method stub
       Object obj = getBusinessObjectForPictogramElement(context.getPictogramElement());
       System.out.println("HeelKELKmnlekmnlkmncklmksldm");
       return (obj instanceof Entity);
    }

    /**
     * 
     * {@inheritDoc}
     */
    public boolean update(final IUpdateContext context) {
        // TODO Auto-generated method stub
        String businessName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        Object obj = getBusinessObjectForPictogramElement(pictogramElement);
        if (obj instanceof Entity) {
           businessName = ((Entity) obj).getName();
        }
        if (pictogramElement instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape)  pictogramElement;
      //      for(Iterator iter = cs.getChildren().iterator();iter.hasNext())
            for (int i = 0; i < cs.getChildren().size(); i++) {
                Shape shape = (Shape) cs.getChildren().get(i);
     
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    ((Text) shape.getGraphicsAlgorithm()).setValue(businessName);
                    
                    return true;
                }
            }
               
        }
                        
        return false;
    }

   
    /**
     * 
     * {@inheritDoc}
     */
    public IReason updateNeeded(final IUpdateContext context) {
        // TODO Auto-generated method stub
        String pictogramName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        if (pictogramElement instanceof ContainerShape) {
                ContainerShape cs = (ContainerShape) pictogramElement;
                for (int i = 0; i < cs.getChildren().size(); i++) {
                    Shape shape = (Shape) cs.getChildren().get(i);                    
                    if (shape.getGraphicsAlgorithm() instanceof Text) {
                        Text text = (Text) shape.getGraphicsAlgorithm();
                        pictogramName = text.getValue();
                   //    System.out.println("The pictogram name is " + pictogramName);
                    }
                }
            }
            
            String businessName = null;
            Object obj = getBusinessObjectForPictogramElement(pictogramElement);
            if (obj instanceof Entity) {
                businessName = ((Entity) obj).getName();
            }
            
            boolean updateRequired = false;
            if ((pictogramName == null && !(businessName == null))
                    || (!(pictogramName == null) && !pictogramName.equals(businessName))) {
                updateRequired = true;
            }
            if (updateRequired) {
                return Reason.createTrueReason("Name is out of Date");
            } else {
                return Reason.createFalseReason();
                }
            }

  
}


