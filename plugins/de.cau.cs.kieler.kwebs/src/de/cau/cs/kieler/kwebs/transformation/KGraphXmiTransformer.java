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

package de.cau.cs.kieler.kwebs.transformation;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.cau.cs.kieler.core.kgraph.KGraphData;
import de.cau.cs.kieler.core.kgraph.KGraphPackage;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.PersistentEntry;
import de.cau.cs.kieler.core.properties.IProperty;
import de.cau.cs.kieler.core.properties.Property;
import de.cau.cs.kieler.kiml.LayoutDataService;
import de.cau.cs.kieler.kiml.LayoutOptionData;
import de.cau.cs.kieler.kiml.klayoutdata.KLayoutDataPackage;
import de.cau.cs.kieler.kwebs.kstatistics.KStatisticsPackage;
import de.cau.cs.kieler.kwebs.util.Graphs;

/**
 * Transformer for the KGraph model and XMI serialization.
 *
 * @kieler.rating 2011-05-04 red
 *
 * @author swe
 */
public class KGraphXmiTransformer extends AbstractEmfTransformer<KNode> {

    /**
     * {@inheritDoc}
     */
    @Override
    public KNode deserialize(final String serializedGraph) {
        KNode graph = super.deserialize(serializedGraph);
        unpersistDataElements(graph);
        return graph;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String serialize(final KNode graph) {
        persistDataElements(graph);
        return super.serialize(graph);
    }

    /**
     * {@inheritDoc}
     */
    protected ResourceSet createResourceSet() {
        Map<String, Object> extensionMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
        if (!extensionMap.containsKey(getFileExtension())) {
            extensionMap.put(getFileExtension(), new XMIResourceFactoryImpl());
        }
        EPackage.Registry registry = EPackage.Registry.INSTANCE;
        if (!registry.containsKey(KGraphPackage.eNS_URI)) {
            registry.put(KGraphPackage.eNS_URI, KGraphPackage.eINSTANCE);
        }
        if (!registry.containsKey(KLayoutDataPackage.eNS_URI)) {
            registry.put(KLayoutDataPackage.eNS_URI, KLayoutDataPackage.eINSTANCE);
        }
        if (!registry.containsKey(KStatisticsPackage.eNS_URI)) {
            registry.put(KStatisticsPackage.eNS_URI, KStatisticsPackage.eINSTANCE);
        }
        return new ResourceSetImpl();
    }

    /**
     * {@inheritDoc}
     */
    protected String getFileExtension() {
        return "kgraph";
    }

    /**
     * {@inheritDoc}
     */
    public void deriveLayout(final TransformationData<KNode> transData) {
        KNode graph = transData.getSourceGraph();        
        // Make sure all graph elements are configured according to specs
        Graphs.validateAllElements(graph);
        // Forward the validated graph as layout graph
        transData.getLayoutGraphs().add(graph);
    }
    
    /**
     * {@inheritDoc}
     */
    public void applyLayout(final TransformationData<KNode> transData) {
        // Nothing to do since the given graph and layout are the same instance
    }

    /*--------- Private utility methods ----------*/

    /**
     * Persists all KGraphData elements of a KNode graph.
     *
     * @param graph
     *            the root element of the graph to persist elements of.
     */
    private void persistDataElements(final KNode graph) {
        if (graph != null) {
            TreeIterator<EObject> iterator = graph.eAllContents();
            EObject eObject = null;
            while (iterator.hasNext()) {
                eObject = iterator.next();
                if (eObject instanceof KGraphData) {
                    ((KGraphData) eObject).makePersistent();
                }
            }
        }
    }

    /**
     * Unpersists all KGraphData elements of a KNode graph.
     *
     * @param graph 
     *            the root element of the graph to unpersist elements of.
     */
    private void unpersistDataElements(final KNode graph) {
        if (graph != null) {
            TreeIterator<EObject> iterator = graph.eAllContents();
            EObject eObject  = null;
            EList<PersistentEntry> persistentEntries = null;
            LayoutDataService services = LayoutDataService.getInstance();
            KGraphData kgraphData = null;
            while (iterator.hasNext()) {
                eObject = iterator.next();
                if (eObject instanceof KGraphData) {
                    kgraphData = ((KGraphData) eObject);
                    persistentEntries = kgraphData.getPersistentEntries();
                    for (PersistentEntry persistentEntry : persistentEntries) {
                        String key = persistentEntry.getKey();
                        String value = persistentEntry.getValue();
                        if (key != null && value != null) {
                            LayoutOptionData<?> layoutOptionData = null;
                            // If we run inside of KIELER we try to get the layout option
                            // from the data service
                            if (services != null) { 
                                layoutOptionData = services.getOptionData(key);
                            }
                            // If we have a valid layout option, parse it's value and
                            // annotate graph
                            if (layoutOptionData != null) {
                                Object layoutOptionValue = layoutOptionData.
                                    parseValue(persistentEntry.getValue());
                                if (layoutOptionValue != null) {
                                    kgraphData.setProperty(layoutOptionData, layoutOptionValue);
                                }
                            // Unknown options are wrapped by a dynamically instantiated one
                            } else { 
                                IProperty<String> property = new Property<String>(key);
                                kgraphData.setProperty(property, value);
                            }
                            /*if (services != null) { // For use in KIELER
                                LayoutOptionData<?> layoutOptionData = services.getOptionData(key);
                                if (layoutOptionData != null) {
                                    Object layoutOptionValue = layoutOptionData.
                                        parseValue(persistentEntry.getValue());
                                    if (layoutOptionValue != null) {
                                        kgraphData.setProperty(layoutOptionData, layoutOptionValue);
                                    }
                                }
                            } else { // For use outside of KIELER
                                IProperty<String> property = new Property<String>(key);
                                kgraphData.setProperty(property, value);
                            }*/
                        }
                    }
                }
            }
        }
    }

}
