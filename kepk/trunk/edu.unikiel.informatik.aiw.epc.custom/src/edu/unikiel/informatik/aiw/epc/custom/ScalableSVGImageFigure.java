package edu.unikiel.informatik.aiw.epc.custom;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;

public class ScalableSVGImageFigure extends ScalableImageFigure {

	private static String IMAGE_PATH = "/figures";
	
	public ScalableSVGImageFigure(){
		super(null, true,true,true);
		this.setMaintainAspectRatio(false);
		
	}
	
	public void setRenderedImage(String filename) {
		IPath imagefile = new Path(IMAGE_PATH + Path.SEPARATOR + filename);
		System.out.println(imagefile);
		URL imageURL = FileLocator.find(Activator.getDefault().getBundle(), imagefile, null);
		super.setRenderedImage(RenderedImageFactory.getInstance(imageURL));
	}
	
	
}
