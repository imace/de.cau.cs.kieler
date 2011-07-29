/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 *
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *     + Department of Computer Science
 *         + Real-Time and Embedded Systems Group
 *
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.kwebs.servicedata.transformation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.cau.cs.kieler.kwebs.servicedata.ServiceData;
import de.cau.cs.kieler.kwebs.servicedata.ServiceDataPackage;

/**
 * Transformer for the KGraph model and XMI serialization.
 *
 * @kieler.rating 2011-05-04 red
 *
 * @author swe
 */
public class ServiceDataXmiTransformer {

    /**
     * 
     * @param serializedData
     * @return
     */
    public final ServiceData deserialize(final String serializedData) {
        ServiceData serviceMeta = null;
        try {
            ByteArrayInputStream inStream = new ByteArrayInputStream(serializedData.getBytes());
            URI uri = URI.createURI("inputstream://temp.serviceData");
            ResourceSet resourceSet = createResourceSet();
            Resource resource = resourceSet.createResource(uri);
            EObject eObject = null;
            try {
                resource.load(inStream, Collections.EMPTY_MAP);
                eObject = resource.getContents().get(0);
                if (eObject instanceof ServiceData) {
                    serviceMeta = (ServiceData) eObject;
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serviceMeta;
    }

    /**
     * 
     * @param serviceData
     * @return
     */
    public final String serialize(final ServiceData serviceData) {
        String serializedMeta = null;
        try {
            URI uri = URI.createURI("outputstream://temp.serviceData");
            ResourceSet resourceSet = createResourceSet();
            Resource resource = resourceSet.createResource(uri);
            resource.unload();
            resource.getContents().add(serviceData);            
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            resource.save(outStream, Collections.EMPTY_MAP);
            outStream.flush();
            serializedMeta = new String(outStream.toByteArray());
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serializedMeta;
    }

    /**
     * 
     * @return
     */
    private ResourceSet createResourceSet() {
        ResourceSet resourceset = new ResourceSetImpl();
        resourceset.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
            Resource.Factory.Registry.DEFAULT_EXTENSION,
            new XMIResourceFactoryImpl()
        );
        resourceset.getPackageRegistry().put(
            ServiceDataPackage.eNS_URI,
            ServiceDataPackage.eINSTANCE
        );
        return resourceset;
    }

}