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
 * 
 */
package de.cau.cs.kieler.kex.controller.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.core.WrappedException;
import de.cau.cs.kieler.kex.KEXPlugin;
import de.cau.cs.kieler.kex.controller.ErrorMessage;
import de.cau.cs.kieler.kex.model.Example;
import de.cau.cs.kieler.kex.model.ExampleResource;

/**
 * Contains all Elements for an import of examples.
 * 
 * @author pkl
 * 
 */
public final class ExampleImport {

    private static final String WORKSPACE_LOCATION = Platform.getLocation().toString();

    private static final String EMPTY_PIC_PATH = "files/noPreview.png";
    private static final String KEX_NAMESPACE_ID = "de.cau.cs.kieler.kex";

    private ExampleImport() {
        // should not called
    }

    /**
     * This method contains all functions to import an example.
     * 
     * @param selectedResource
     *            , destination resource of type {@link IPath}.
     * @param selectedExamples
     *            , {@link List} of {@link Example}s.
     * @param checkDuplicate
     *            , flag for checking example duplication in project.
     * @return directopens, {@link List} of {@link String}.
     * @throws Exception
     */
    public static List<String> importExamples(final IPath selectedResource,
            final List<Example> selectedExamples, final boolean checkDuplicate) throws Exception {

        List<String> directOpens = new ArrayList<String>();
        List<String> finishedResources = new ArrayList<String>();

        StringBuilder destFolder = new StringBuilder();
        destFolder.append(WORKSPACE_LOCATION).append("/")
                .append((selectedResource != null ? selectedResource.toString() : "")).append("/");
        try {
            for (Example example : selectedExamples) {

                List<ExampleResource> resources = example.getResources();
                String rootDirectory = example.getRootDir();
                int exampleBeginIndex = 0;
                if (rootDirectory != null && rootDirectory.length() > 1) {
                    exampleBeginIndex = rootDirectory.length();
                }
                handleResources(directOpens, resources, destFolder.toString(),
                        example.getNamespaceId(), exampleBeginIndex, checkDuplicate,
                        finishedResources);
            }
        } catch (Exception e) {
            deleteResources(finishedResources);
            throw e;
        }
        return directOpens;
    }

    private static void deleteResources(final List<String> finishedResources) {
        for (String resourcePath : finishedResources) {
            IOHandler.deleteFile(new File(resourcePath));
        }
    }

    private static void handleResources(final List<String> directOpens,
            final List<ExampleResource> resources, final String destFolder,
            final String nameSpaceId, final int exampleBeginIndex, final boolean checkDuplicate,
            final List<String> finishedResources) {
        Bundle bundle = Platform.getBundle(nameSpaceId);
        String newDestFolder = new Path(destFolder).toPortableString();

        for (ExampleResource resource : resources) {
            try {
                String localPath = resource.getLocalPath();
                String destPath = localPath.substring(exampleBeginIndex);
                switch (resource.getResourceType()) {
                case PROJECT:
                    checkDuplicate(destPath);
                    IProgressMonitor progressMonitor = new NullProgressMonitor();
                    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
                    IProject project = root.getProject(destPath);
                    project.create(progressMonitor);
                    project.open(progressMonitor);
                    newDestFolder = root.getLocation().toPortableString();
                    break;

                case FOLDER:
                    File destFile = new File(newDestFolder + "/" + destPath);
                    finishedResources.add(destFile.getPath());
                    if (checkDuplicate && destFile.exists()) {
                        // FIXME throw a more specific exception
                        throw new RuntimeException(destFile.getName());
                    }
                    IOHandler.createFolder(newDestFolder + "/" + destPath);
                    break;

                case FILE:
                    URL entry = bundle.getEntry(localPath);
                    if (entry == null) {
                        // FIXME throw a more specific exception
                        throw new RuntimeException(ErrorMessage.NO_Import
                                + "Could not generate resource url from path: " + localPath);
                    }
                    String dest = newDestFolder + "/" + destPath;
                    finishedResources.add(dest);
                    IOHandler.writeFile(entry, dest, checkDuplicate);
                    if (resource.isDirectOpen()) {
                        directOpens.add(dest);
                    }
                    break;
                }
            } catch (FileNotFoundException e) {
                throw new WrappedException(e, ErrorMessage.NO_Import);
            } catch (IOException e1) {
                throw new WrappedException(e1, ErrorMessage.NO_Import);
            } catch (CoreException e2) {
                throw new WrappedException(e2, ErrorMessage.NO_Import);
            }
        }
    }

    private static void checkDuplicate(final String destPath) {
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(destPath);
        if (project != null && project.exists()) {
            // FIXME throw a more specific exception
            throw new RuntimeException("Duplicate Project, you maybe inserted it before.");
        }
    }

    /**
     * Loads the empty picture, often called when no example image exists.
     * 
     * @return {@link InputStream}
     */
    public static InputStream getEmptyPic() {
        Bundle bundle = Platform.getBundle(ExampleImport.KEX_NAMESPACE_ID);
        URL entry = bundle.getEntry(ExampleImport.EMPTY_PIC_PATH);
        try {
            return entry.openStream();
        } catch (IOException e) {
            IStatus status = new Status(IStatus.ERROR, KEXPlugin.PLUGIN_ID,
                    e.getLocalizedMessage(), e);
            StatusManager.getManager().handle(status, StatusManager.SHOW);
        }
        return null;
    }

    /**
     * validates the selected examples.
     * 
     * @param selectedResource
     *            , {@link IPath}
     * @param selectedExamples
     *            , {@link List} of {@link Example}
     * @param checkDuplicate
     *            , boolean
     */
    public static void validate(final IPath selectedResource, final List<Example> selectedExamples,
            final boolean checkDuplicate) {
        if (selectedExamples == null || selectedExamples.size() == 0) {
            // FIXME throw a more specific exception
            throw new RuntimeException(ErrorMessage.NO_EXAMPLE_SELECTED);
        }
        // could happen that user wants to import a project and a example in a
        // other project
        boolean allProjects = false;
        for (Example example : selectedExamples) {
            if (example.isProject()) {
                allProjects = true;
            } else {
                allProjects = false;
                break;
            }
        }

        // projects do not need a destinatin resource
        if (!allProjects) {
            if (selectedResource == null || selectedResource.segmentCount() == 0) {
                // FIXME throw a more specific exception
                throw new RuntimeException(ErrorMessage.NO_DEST_SET);
            }
        }
    }
}
