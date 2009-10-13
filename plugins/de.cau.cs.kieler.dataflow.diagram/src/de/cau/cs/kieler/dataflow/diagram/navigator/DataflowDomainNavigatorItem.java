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
package de.cau.cs.kieler.dataflow.diagram.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

/**
 * @generated
 */
public class DataflowDomainNavigatorItem extends PlatformObject {

    /**
     * @generated
     */
    static {
        final Class[] supportedTypes = new Class[] { EObject.class, IPropertySource.class };
        Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

            public Object getAdapter(Object adaptableObject, Class adapterType) {
                if (adaptableObject instanceof de.cau.cs.kieler.dataflow.diagram.navigator.DataflowDomainNavigatorItem) {
                    de.cau.cs.kieler.dataflow.diagram.navigator.DataflowDomainNavigatorItem domainNavigatorItem = (de.cau.cs.kieler.dataflow.diagram.navigator.DataflowDomainNavigatorItem) adaptableObject;
                    EObject eObject = domainNavigatorItem.getEObject();
                    if (adapterType == EObject.class) {
                        return eObject;
                    }
                    if (adapterType == IPropertySource.class) {
                        return domainNavigatorItem.getPropertySourceProvider().getPropertySource(
                                eObject);
                    }
                }

                return null;
            }

            public Class[] getAdapterList() {
                return supportedTypes;
            }
        }, de.cau.cs.kieler.dataflow.diagram.navigator.DataflowDomainNavigatorItem.class);
    }

    /**
     * @generated
     */
    private Object myParent;

    /**
     * @generated
     */
    private EObject myEObject;

    /**
     * @generated
     */
    private IPropertySourceProvider myPropertySourceProvider;

    /**
     * @generated
     */
    public DataflowDomainNavigatorItem(EObject eObject, Object parent,
            IPropertySourceProvider propertySourceProvider) {
        myParent = parent;
        myEObject = eObject;
        myPropertySourceProvider = propertySourceProvider;
    }

    /**
     * @generated
     */
    public Object getParent() {
        return myParent;
    }

    /**
     * @generated
     */
    public EObject getEObject() {
        return myEObject;
    }

    /**
     * @generated
     */
    public IPropertySourceProvider getPropertySourceProvider() {
        return myPropertySourceProvider;
    }

    /**
     * @generated
     */
    public boolean equals(Object obj) {
        if (obj instanceof de.cau.cs.kieler.dataflow.diagram.navigator.DataflowDomainNavigatorItem) {
            return EcoreUtil
                    .getURI(getEObject())
                    .equals(
                            EcoreUtil
                                    .getURI(((de.cau.cs.kieler.dataflow.diagram.navigator.DataflowDomainNavigatorItem) obj)
                                            .getEObject()));
        }
        return super.equals(obj);
    }

    /**
     * @generated
     */
    public int hashCode() {
        return EcoreUtil.getURI(getEObject()).hashCode();
    }

}
