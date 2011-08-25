/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.kwebs.client.kiml.layout;

//import java.io.ByteArrayInputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLConnection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
//import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.kiml.LayoutAlgorithmData;
import de.cau.cs.kieler.kiml.LayoutDataService;
import de.cau.cs.kieler.kiml.service.ServiceDataLayoutDataService;
import de.cau.cs.kieler.kwebs.client.ILayoutServiceClient;
import de.cau.cs.kieler.kwebs.client.kiml.activator.Activator;
//import de.cau.cs.kieler.kwebs.util.Resources;

/**
 * This class is designed for retrieving the layout capabilities of a
 * remote layout provider and make it available in the KIELER framework
 * so the user can annotate his model only with the server side available
 * options. At this moment the layout capabilities include available layout
 * algorithms and layout options only.
 *
 * @kieler.rating 2011-05-17 red
 * @author swe
 */
public final class RemoteLayoutDataService extends ServiceDataLayoutDataService {

    /**
     * This class needs to be instantiated through the {@link #create}
     * method.
     */
    private RemoteLayoutDataService() {
    }

    /**
     * Creates the singleton instance of this class. The layout capabilities
     * need to be retrieved afterwards through any client which implements the
     * {@link ILayoutServiceClient} interface
     * by calling {@link initializeWithClient} with the client as parameter.
     */
    public static synchronized void create() {
        RemoteLayoutDataService lds =
            LayoutDataService.getInstanceOf(
                LayoutDataService.REMOTEDATASERVICE
        );
        if (lds == null) {
            lds = new RemoteLayoutDataService();
            LayoutDataService.addService(lds);
        }
    }

    /**
     * 
     */
    public static synchronized void resetInstance() {
        RemoteLayoutDataService lds =
            LayoutDataService.getInstanceOf(
                LayoutDataService.REMOTEDATASERVICE
        );
        // Remember current mode
        String currentMode = LayoutDataService.getMode();
        if (lds != null) {          
            // Set the mode temporarily to local mode since the
            // RemoteLayoutDataService instance can only be removed
            // if it is not the currently active instance.
            LayoutDataService.setMode(ECLIPSEDATASERVICE);            
            LayoutDataService.removeService(lds);
        }
        // Create new RemoteLayoutDataService instance and register it
        create();
        // Switch back to original mode
        LayoutDataService.setMode(currentMode);
    }

    /**
     * Returns the singleton instance of this class.
     *
     * @return the singleton instance.
     */
    public static synchronized RemoteLayoutDataService getInstance() {
        return LayoutDataService.getInstanceOf(
            LayoutDataService.REMOTEDATASERVICE
        );
    }

    /**
     * Initializes the layout service meta data with the given web service client.
     *
     * @param client 
     *            the client.
     */
    public synchronized void initializeWithClient(final ILayoutServiceClient client) {
        if (!client.isAvailable()) {
            throw new ServiceUnavailableException(
                "The service on address "
                + client.getServerConfig().getAddress()
                + " is currently not reachable"
            );
        }
        try {
            previewImageClient = client;
            previewImageHostAvailable = true;
            //previewImageHost = client.getServerConfig().getAddress().getHost();  
            String capabilities = client.getServiceData();     
            super.initializeFromString(capabilities);
        } catch (Exception e) {
            StatusManager.getManager().handle(
                new Status(
                    IStatus.ERROR, 
                    Activator.PLUGIN_ID, 
                    "Server meta data could not be retrieved or correctly processed", 
                    null
                )
            );
            throw new IllegalStateException(
                "Server meta data could not be retrieved or correctly processed",
            e);
        }
    }

    /** name of the 'previewImagePath' attribute layout algorithms meta data. */
    public static final String ATTRIBUTE_PREVIEWIMAGEPATH 
        = "previewImagePath";

    /** name of the 'previewImagePath' attribute layout algorithms meta data. */
    //public static final String ATTRIBUTE_PREVIEWIMAGEPORT 
    //    = "previewImagePort";

    /** The layout service client used to retrieve the preview images. */
    private ILayoutServiceClient previewImageClient;
    
    /**
     *  If the host for the preview images is not available then we shall not further try
     *  to download images and show the unavailable image since otherwise the UI will remain
     *  unresponsive for the timeout when trying to download preview images. 
     */
    private boolean previewImageHostAvailable
        = true;
    
    /** Needed for getting the preview images. Necessary value is set by initializeWithClient(). */
    //private String previewImageHost;
    
    /** The image displayed if the preview images from the host are not available. */
    private ImageDescriptor unavailable
        = Activator.getImageDescriptor("images/unavailable.png");
    
    /** 
     *  The timeout for reading the preview image via HTTP connection. Do not set it to high
     *  since reading the preview images causes the UI to block. 
     */
    //private static final int PREVIEWIMAGE_CONNECTTIMEOUT
    //    = 2000;
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected LayoutAlgorithmData createLayoutAlgorithmData(final IConfigurationElement element) {
        RemoteLayoutAlgorithmData algoData = new RemoteLayoutAlgorithmData();
        String previewImagePath = element.getAttribute(ATTRIBUTE_PREVIEWIMAGEPATH);
        //String previewImagePort = element.getAttribute(ATTRIBUTE_PREVIEWIMAGEPORT);
        if (previewImageHostAvailable) {
            if (previewImagePath != null) {
                try {
                    algoData.setPreviewImage(new LayoutServiceImageDescriptor(
                        previewImageClient, previewImagePath
                    ));
                    /*
                    algoData.setPreviewImage(ImageDescriptor.createFromImageData(
                        new ImageData(new ByteArrayInputStream(
                            previewImageClient.getPreviewImage(previewImagePath)
                        ))
                    ));
                    */
                } catch (Exception e) {
                    previewImageHostAvailable = false;
                    reportError("Could not load preview image: " + previewImagePath, e);
                }
/*
                String address = "http://" + previewImageHost 
                                 + ":" + previewImagePort 
                                 + "/" + previewImagePath;
                // We try to preload the images instead of doing lazy loading when they are required
                // since then we have no chance of globally disable the download if the image host 
                // is not available. Unavailable preview images make the UI unresponsive 
                // for the time of the network timeout.
                try {                    
                    URL url = new URL(address);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(PREVIEWIMAGE_CONNECTTIMEOUT);
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.connect();                
                    //algoData.setPreviewImage(ImageDescriptor.createFromURL(new URL(address)));
                    algoData.setPreviewImage(ImageDescriptor.createFromImageData(
                        new ImageData(connection.getInputStream()))
                    );
                } catch (Exception e) {
                    previewImageHostAvailable = false;
                    reportError("Could not load preview image: " + address, e);
                }
*/
            }
        } else {
            algoData.setPreviewImage(unavailable);
        }
        return algoData;
    }

    /**
     * {@inheritDoc}
     */
    protected void reportError(final String message) {
        reportError(message, null);
    }

    /**
     * {@inheritDoc}
     */
    protected void reportError(final String message, final Throwable throwable) {
        StatusManager.getManager().handle(
            new Status(
                IStatus.ERROR, 
                Activator.PLUGIN_ID, 
                message,
                throwable
            )
        );
    }

}
