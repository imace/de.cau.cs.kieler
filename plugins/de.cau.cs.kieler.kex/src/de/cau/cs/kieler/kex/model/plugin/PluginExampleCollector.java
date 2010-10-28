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
package de.cau.cs.kieler.kex.model.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.kex.controller.ErrorMessage;
import de.cau.cs.kieler.kex.model.Example;
import de.cau.cs.kieler.kex.model.ExampleCollector;
import de.cau.cs.kieler.kex.model.ExampleResource;
import de.cau.cs.kieler.kex.model.SourceType;

/**
 * Contains all methods to collect example of plugin projects.
 * 
 * @author pkl
 * 
 */
public class PluginExampleCollector extends ExampleCollector {

    private static final int CATEGORY_MIN_LENGTH = 4;

    // leichter HashMap, da wir eine Pruefung auf enthalten sein machen.
    // und wir dann bei einer liste komplett ueber alle elemente iterieren
    // muessten
    // um die id abzugleichen.

    private final Map<String, Example> examplePool;

    private List<String> categoryPool;

    /**
     * Constructor for {@link PluginExampleCollector}.
     */
    public PluginExampleCollector() {
        examplePool = new HashMap<String, Example>();

    }

    /**
     * Loads examples of extenders.
     * 
     * @throws KielerException
     *             , if toExample(...) throws it.
     */
    @Override
    public void load() throws KielerException {
        if (this.categoryPool == null) {
            this.categoryPool = new ArrayList<String>();
            loadCategories();
        }
        IConfigurationElement[] configElements = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(PluginConstants.KEX_EXT_POINT);
        for (IConfigurationElement element : configElements) {
            try {
                String elementName = element.getName();
                if (PluginConstants.EXAMPLE.equals(elementName)) {
                    String exampleTitle = element.getAttribute(PluginConstants.TITLE);
                    if (getExamplePool().containsKey(exampleTitle)) {
                        // TODO darf eigentlich nicht passieren
                        // RUNTIME Exception schmei�en...
                        // oder einfach annehmen, dass dies nicht geschieht
                        continue;
                    }
                    Example example = null;
                    try {
                        example = toExample(element);
                    } catch (Exception e) {
                        continue;
                    }
                    this.examplePool.put(exampleTitle, example);
                } else if (PluginConstants.CATEGORY.equals(elementName)) {
                    collectCategory(element);
                }
            } catch (InvalidRegistryObjectException e) {
                throw new KielerException("Error while loading example \""
                        + element.getAttribute(PluginConstants.ID) + "\". "
                        + e.getLocalizedMessage());
            } catch (IllegalArgumentException e1) {
                throw new KielerException("Error while loading example \""
                        + element.getAttribute(PluginConstants.ID) + "\". "
                        + e1.getLocalizedMessage());
            }
            // catch (KielerException e2) {
            // throw new KielerException("Error while loading example \""
            // + element.getAttribute(PluginConstants.ID) + "\". "
            // + e2.getLocalizedMessage());
            // }
        }
    }

    /**
     * Collects all categories of plugin-projects.
     * 
     * @param categoryElement
     *            , {@link IConfigurationElement}
     */
    public void collectCategory(final IConfigurationElement categoryElement) {
        String categoryId = categoryElement.getAttribute(PluginConstants.ID);
        if (categoryId == null || categoryId.length() < CATEGORY_MIN_LENGTH) {
            // TODO undefined state, think about it.
        } else {
            if (!getCategories().contains(categoryId)) {
                getCategories().add(categoryId);
                // } else {
                // // TODO that should not happen
            }
        }
    }

    @Override
    public Map<String, Example> getExamplePool() {
        return this.examplePool;
    }

    /**
     * Returns the categorypool if it is not empty, otherwise loads categories.
     * 
     * @return {@link List} of {@link String}
     */
    public List<String> getCategories() {
        if (this.categoryPool == null) {
            this.categoryPool = new ArrayList<String>();
            loadCategories();
        }
        return categoryPool;
    }

    private void loadCategories() {
        IConfigurationElement[] configElements = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(PluginConstants.KEX_EXT_POINT);
        for (IConfigurationElement element : configElements) {
            if (PluginConstants.CATEGORY.equals(element.getName())) {
                collectCategory(element);
            }
        }
    }

    @Override
    public SourceType getSourceType() {
        return SourceType.KIELER;
    }

    /**
     * filters out of a {@link IConfigurationElement} a {@link Example}.
     * 
     * @param exampleElement
     *            , {@link IConfigurationElement}
     * @return {@link Example}
     */
    public static Example toExample(final IConfigurationElement exampleElement) {

        String titleAttr = exampleElement.getAttribute(PluginConstants.TITLE);
        // ein freier string, min. default besser noch regex.
        Example example = new Example(titleAttr, SourceType.KIELER);
        example.setDescription(exampleElement.getAttribute(PluginConstants.DESCRIPTION));
        example.setContact(exampleElement.getAttribute(PluginConstants.CONTACT));
        example.setAuthor(exampleElement.getAttribute(PluginConstants.AUTHOR));
        example.setOverviewPic(exampleElement.getAttribute(PluginConstants.OVERVIEW_PIC));
        String exNamespaceId = exampleElement.getNamespaceIdentifier();
        example.setNamespaceId(exNamespaceId);
        example.setRootDir(exampleElement.getAttribute(PluginConstants.ROOT_DIRECTORY));

        List<String> categories = filterElement(exampleElement, PluginConstants.CATEGORY,
                PluginConstants.ID);
        example.addCategories(categories);
        example.addResources(filterExampleResource(exampleElement));
        return example;
    }

    private static List<String> filterElement(final IConfigurationElement exampleElement,
            final String elementName, final String attributeName) {
        List<String> result = new ArrayList<String>();
        for (IConfigurationElement configurationElement : exampleElement.getChildren(elementName)) {
            String catName = configurationElement.getAttribute(attributeName);
            if (catName != null) {
                result.add(catName);
            }
        }
        return result;
    }

    private static List<ExampleResource> filterExampleResource(
            final IConfigurationElement exampleElement) {
        List<ExampleResource> result = new ArrayList<ExampleResource>();
        for (IConfigurationElement configurationElement : exampleElement
                .getChildren(PluginConstants.EXAMPLE_RESOURCE)) {
            String resourceType = configurationElement.getAttribute(PluginConstants.RESOURCE_TYPE);
            String localPath = configurationElement.getAttribute(PluginConstants.LOCAL_PATH);
            if (resourceType != null && localPath != null) {
                ExampleResource exRe = new ExampleResource(localPath,
                        ExampleResource.Type.valueOf(resourceType.toUpperCase()));
                String directOpen = configurationElement.getAttribute(PluginConstants.DIRECT_OPEN);
                if (directOpen != null) {
                    exRe.setDirectOpen(Boolean.parseBoolean(directOpen));
                }
                result.add(exRe);
            }
        }
        return result;
    }

    /**
     * 
     * @param exampleTitle
     *            , {@link String}
     * @return {@link Example}
     * @throws KielerException
     *             , if a {@link InvalidRegistryObjectException} or a
     *             {@link IllegalArgumentException} has been thrown.
     */
    public static Example getExample(final String exampleTitle) throws KielerException {
        IConfigurationElement[] configElements = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(PluginConstants.KEX_EXT_POINT);
        for (IConfigurationElement element : configElements) {
            String elementName = element.getName();
            if (PluginConstants.EXAMPLE.equals(elementName)) {
                if (element.getAttribute(PluginConstants.TITLE).equals(exampleTitle)) {
                    try {
                        return toExample(element);
                    } catch (InvalidRegistryObjectException e) {
                        throw new KielerException(ErrorMessage.LOAD_ERROR
                                + element.getAttribute(PluginConstants.ID) + "\". "
                                + e.getLocalizedMessage());
                    } catch (IllegalArgumentException e1) {
                        throw new KielerException(ErrorMessage.LOAD_ERROR
                                + element.getAttribute(PluginConstants.ID) + "\". "
                                + e1.getLocalizedMessage());
                    }
                }
            }
        }

        return null;
    }
}
