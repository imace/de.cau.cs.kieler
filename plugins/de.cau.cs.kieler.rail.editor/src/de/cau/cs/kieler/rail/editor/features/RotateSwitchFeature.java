package de.cau.cs.kieler.rail.editor.features;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import de.cau.cs.kieler.rail.Topologie.Basegraph.Port;
import de.cau.cs.kieler.rail.Topologie.SpecializedVertices.Weichenknoten;

public class RotateSwitchFeature extends AbstractCustomFeature {
 
    public RotateSwitchFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Rotate Switch";
    }
 
    @Override
    public String getDescription() {
        return "Ändert den Winkel der Weiche";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        // allow rename if exactly one pictogram element
        // representing a EClass is selected
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof Weichenknoten) {
                ret = true;
            }
        }
        return ret;
    }
 
    public void execute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof Weichenknoten) {
            	Weichenknoten weichenknoten = (Weichenknoten) bo;
                String currentName = weichenknoten.getName();
                
                PictogramElement pictogramElement = context.getInnerPictogramElement();
                ContainerShape cs = (ContainerShape) pictogramElement;
                
                updatePictogramElement(pictogramElement);
                
                // ask user for a new class name
                String newName =ExampleUtil.askString(getName(), getDescription(),
                        currentName);
                if (newName != null) {
                    weichenknoten.setName(newName);
                }
            }
        }
    }
    /*
              if (pictogramElement instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) pictogramElement;
            
            for(Anchor anchor : cs.getAnchors()){
            	if (anchor instanceof BoxRelativeAnchor){
            		Port port = (Port)getBusinessObjectForPictogramElement(anchor);
            		BoxRelativeAnchor box = (BoxRelativeAnchor) anchor.getGraphicsAlgorithm().getPictogramElement();
            		int boxWidth = anchor.getGraphicsAlgorithm().getWidth();
            		int boxHeight = anchor.getGraphicsAlgorithm().getWidth();
            		switch (port.getName()){
	            		case SPITZE:
	            			spitzeStammXY[0] = (int) (width*(box.getRelativeWidth())-boxWidth*2);
	            			spitzeStammXY[1] = (int) (width*(box.getRelativeHeight())+boxHeight/2);
	            			break;
	            		case STAMM:
	            			spitzeStammXY[2] = (int) (width*(box.getRelativeWidth())+boxWidth*2);
	            			spitzeStammXY[3] = (int) (width*(box.getRelativeHeight())+boxHeight/2);
	            			break;
	            		case ABZWEIG:
	            			mitteAbzweigXY[2] = (int) (width*(box.getRelativeWidth())+boxWidth*2);
	            			mitteAbzweigXY[3] = (int) (width*(box.getRelativeHeight())+boxHeight/2);
            		}
            	}
            }
     * 
     */
}
