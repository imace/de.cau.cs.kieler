/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package de.cau.cs.kieler.kiml.viewer.views;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Region snippet: Create non-rectangular shell from an image with transparency
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.2
 */
public class TransparentShell implements Runnable{
    
    Shell shell;
    Display display;
    Region region;
    ImageData imageData;
    Image image;
    
    GmfDebugCanvas canvas;
    
    /**
     * 
     */
    public TransparentShell(GmfDebugCanvas canvas) {
        this.canvas = canvas;
    }

    private void init() {
        display = PlatformUI.getWorkbench().getDisplay();
        final Point size = canvas.getSize();
        if(size.x == 0 || size.y == 0){
            size.x = 50;
            size.y = 50;
        }
        image = new Image(display, size.x, size.y);
        canvas.paintLayoutGraph(new GC(image), size);
        if (image == null)
            image = display.getSystemImage(SWT.ICON_INFORMATION);
        shell = new Shell (display, SWT.NO_TRIM);
        region = new Region();
        imageData = image.getImageData();
        if (imageData.alphaData != null) {
                Rectangle pixel = new Rectangle(0, 0, 1, 1);
                for (int y = 0; y < imageData.height; y++) {
                        for (int x = 0; x < imageData.width; x++) {
                                int p = imageData.getPixel(x, y);
                                if (imageData.getAlpha(x, y) == 255) {
                                        pixel.x = imageData.x + x;
                                        pixel.y = imageData.y + y;
                                        region.add(pixel);
                                } 
                        }
                }
        } else {
            Rectangle pixel = new Rectangle(0, 0, 1, 1);
            // assume the first pixel belongs to the background and is reference for transparency
            RGB[] rgb = imageData.getRGBs();
            int transparent = imageData.getPixel(0,0);
            System.out.println(Integer.toBinaryString(transparent));
            for (int y = 0; y < imageData.height; y++) {
                    for (int x = 0; x < imageData.width; x++) {
                            if (imageData.getPixel(x, y) != transparent) {
                                    int p1 = imageData.getPixel(x, y);
                                    String p1String = Integer.toBinaryString(p1);
                                    pixel.x = imageData.x + x;
                                    pixel.y = imageData.y + y;
                                    region.add(pixel);
                            } 
                    }
            }
//                ImageData mask = imageData.getTransparencyMask();
//                Rectangle pixel = new Rectangle(0, 0, 1, 1);
//                for (int y = 0; y < mask.height; y++) {
//                        for (int x = 0; x < mask.width; x++) {
//                                if (mask.getPixel(x, y) != 0) {
//                                        pixel.x = imageData.x + x;
//                                        pixel.y = imageData.y + y;
//                                        region.add(pixel);
//                                }
//                        }
//                }
        }
        shell.setRegion(region);

        Listener l = new Listener() {
                int startX, startY;
                public void handleEvent(Event e)  {
                        if (e.type == SWT.KeyDown && e.character == SWT.ESC) {
                                shell.dispose();
                        }
                        if (e.type == SWT.MouseDown && e.button == 1) {
                                startX = e.x;
                                startY = e.y; 
                        }
                        if (e.type == SWT.MouseMove && (e.stateMask & SWT.BUTTON1) != 0) {
                                Point p = shell.toDisplay(e.x, e.y);
                                p.x -= startX;
                                p.y -= startY;
                                shell.setLocation(p);
                        }
                        if (e.type == SWT.Paint) {
                                e.gc.drawImage(image, imageData.x, imageData.y);
                        }
                }
        };
        shell.addListener(SWT.KeyDown, l);
        shell.addListener(SWT.MouseDown, l);
        shell.addListener(SWT.MouseMove, l);
        shell.addListener(SWT.Paint, l);

        shell.setSize(imageData.x + imageData.width, imageData.y + imageData.height);
}

    void positionOverCanvas(){
        try{
        FigureCanvas gmfCanvas = (FigureCanvas)canvas.getGmfEditor().getDiagramGraphicalViewer().getControl();
        Point pos = gmfCanvas.toDisplay(0, 0);
        shell.setLocation(pos.x,pos.y);
        }catch(Exception e){/*nothing*/}
    }
    
 
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        init();
        positionOverCanvas();
        shell.open ();
        while (!shell.isDisposed ()) {
                if (!display.readAndDispatch ()) display.sleep ();
        }
        region.dispose();
        image.dispose ();
        //display.dispose ();
    }
}


