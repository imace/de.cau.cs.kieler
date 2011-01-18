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
import de.cau.cs.kieler.kex.model.Category;
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

    private final Map<String, Example> examplePool;

    private List<Category> categoryPool;

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
            this.categoryPool = new ArrayList<Category>();
            loadCategories();
        }
        // TODO rebuild,that first loadcategories and then loadexamples
        IConfigurationElement[] configElements = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(PluginConstants.KEX_EXT_POINT);
        for (IConfigurationElement element : configElements) {
            try {
                String elementName = element.getName();
                if (PluginConstants.Example.EXAMPLE.equals(elementName)) {
                    String exampleTitle = element.getAttribute(PluginConstants.Example.TITLE);
                    if (getExamplePool().containsKey(exampleTitle)) {
                        // TODO should normally not happen
                        // throw RUNTIME Exception...
                        // or simple assume that this does not happen.
                        continue;
                    }
                    Example example = null;
                    try {
                        example = toExample(element);
                    } catch (Exception e) {
                        continue;
                    }
                    this.examplePool.put(exampleTitle, example);
                } else if (PluginConstants.Category.CATEGORY.equals(elementName)) {
                    collectCategory(element);
                }
            } catch (InvalidRegistryObjectException e) {
                throw new KielerException("Error while loading example \""
                        + element.getAttribute(PluginConstants.Example.ID) + "\". "
                        + e.getLocalizedMessage());
            } catch (IllegalArgumentException e1) {
                throw new KielerException("Error while loading example \""
                        + element.getAttribute(PluginConstants.Example.ID) + "\". "
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
        // TODO think about id or title null or id shorter than cat min length,
        // should that cause a programm termination? NO. -> meaningful solve.
        // what is when the categories contains a category with id?,
        // that means a category was defined twice
        String id = categoryElement.getAttribute(PluginConstants.Category.ID);
        String title = categoryElement.getAttribute(PluginConstants.Category.TITLE);
        String description = categoryElement.getAttribute(PluginConstants.Category.DESCRIPTION);
        String iconPath = categoryElement.getAttribute(PluginConstants.Category.ICON);
        String parentId = categoryElement.getAttribute(PluginConstants.Category.PARENT);
        getCategories().add(new Category(id, title, description, iconPath, parentId));
    }

    @Override
    public Map<String, Example> getExamplePool() {
        return this.examplePool;
    }

    /**
     * Returns the categorypool if it is not empty, otherwise loads categories.
     * 
     * @return {@link List} of {@link Category}
     */
    public List<Category> getCategories() {
        if (this.categoryPool == null) {
            this.categoryPool = new ArrayList<Category>();
            loadCategories();
        }
        return categoryPool;
    }

    private void loadCategories() {
        IConfigurationElement[] configElements = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(PluginConstants.KEX_EXT_POINT);
        for (IConfigurationElement element : configElements) {
            if (PluginConstants.Category.CATEGORY.equals(element.getName())) {
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

        String idAttr = exampleElement.getAttribute(PluginConstants.Example.ID);
        String titleAttr = exampleElement.getAttribute(PluginConstants.Example.TITLE);
        String categoryIdAttr = exampleElement.getAttribute(PluginConstants.Example.CATEGORY);
        // a free string, min. default or better regex.
        Example example = new Example(idAttr, titleAttr, categoryIdAttr, SourceType.KIELER);
        example.setDescription(exampleElement.getAttribute(PluginConstants.Example.DESCRIPTION));
        example.setContact(exampleElement.getAttribute(PluginConstants.Example.CONTACT));
        example.setAuthor(exampleElement.getAttribute(PluginConstants.Example.AUTHOR));
        example.setOverviewPic(exampleElement.getAttribute(PluginConstants.Example.OVERVIEW_PIC));
        String exNamespaceId = exampleElement.getNamespaceIdentifier();
        example.setNamespaceId(exNamespaceId);
        example.setRootDir(exampleElement.getAttribute(PluginConstants.Example.ROOT_DIRECTORY));
        example.addResources(filterExampleResource(exampleElement));
        return example;
    }

    private static List<ExampleResource> filterExampleResource(
            final IConfigurationElement exampleElement) {
        List<ExampleResource> result = new ArrayList<ExampleResource>();
        for (IConfigurationElement configurationElement : exampleElement
                .getChildren(PluginConstants.Resource.EXAMPLE_RESOURCE)) {
            String resourceType = configurationElement
                    .getAttribute(PluginConstants.Resource.RESOURCE_TYPE);
            String localPath = configurationElement
                    .getAttribute(PluginConstants.Resource.LOCAL_PATH);
            if (resourceType != null && localPath != null) {
                ExampleResource exRe = new ExampleResource(localPath,
                        ExampleResource.Type.valueOf(resourceType.toUpperCase()));
                String directOpen = configurationElement
                        .getAttribute(PluginConstants.Resource.DIRECT_OPEN);
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
            if (PluginConstants.Example.EXAMPLE.equals(elementName)) {
                if (element.getAttribute(PluginConstants.Example.TITLE).equals(exampleTitle)) {
                    try {
                        return toExample(element);
                    } catch (InvalidRegistryObjectException e) {
                        throw new KielerException(ErrorMessage.LOAD_ERROR
                                + element.getAttribute(PluginConstants.Example.ID) + "\". "
                                + e.getLocalizedMessage());
                    } catch (IllegalArgumentException e1) {
                        throw new KielerException(ErrorMessage.LOAD_ERROR
                                + element.getAttribute(PluginConstants.Example.ID) + "\". "
                                + e1.getLocalizedMessage());
                    }
                }
            }
        }

        return null;
    }
}
