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
package de.cau.cs.kieler.kvid.dataprovider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.kvid.KvidPlugin;
import de.cau.cs.kieler.kvid.datadistributor.DataDistributor;
import de.cau.cs.kieler.kvid.datadistributor.IProviderListener;
import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.KiemPlugin;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;

/**
 * Data source which is a {@link IDataProvider} and uses CSV files 
 * to provide the data. 
 * 
 * @author jjc
 *
 */
public class KiemCsvDataProvider extends JSONObjectDataComponent implements
        IJSONObjectDataComponent {
    
    /** List of registered {@link IProviderListener}s. */
    private List<IProviderListener> listeners = new LinkedList<IProviderListener>();
    
    /** The CSV file to read from. */
    private IFile inputCsvFile;
    
    /** All lines of the CSV file. */
    private String[] csvLines;
    
    /** The URIs of the referred model elements. */
    private String[] uris;
    
    
    private String[] getCsvLines() {
        String cache = "";
        if (inputCsvFile != null) {
            try {
                String line = null;
                InputStream input = inputCsvFile.getContents();
                InputStreamReader reader = new InputStreamReader(input);
                BufferedReader buf = new BufferedReader(reader);
                while ((line = buf.readLine()) != null) {
                    cache += line + "\n";
                }
                cache = cache.trim();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            throw new RuntimeException("Please chose an existing CSV file as source.");
        }
        return cache.split("\n");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public KiemProperty[] provideProperties() {
        KiemProperty[] properties = new KiemProperty[1];
        properties[0] = new KiemProperty(
                        "Path to CSV file",
                        new KiemPropertyTypeFile(),
                        "/path/to/csv/file");
        return properties;
    }

    /**
     * {@inheritDoc}
     */
    public void initialize() throws KiemInitializationException {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot workspaceRoot = workspace.getRoot();
        
        IPath path = new Path(this.getProperties()[0].getFilePath());
        this.inputCsvFile = workspaceRoot.getFileForLocation(path);
        csvLines = getCsvLines();
        if (csvLines.length > 0) {
            uris = csvLines[0].split(";");
        } else {
            throw new RuntimeException("Loaded empty CSV file");
        }
        
        DataDistributor.getInstance().initialize();
        for (IProviderListener listener : listeners) {
            listener.triggerInitialization();
        }
    }

    /**
     * {@inheritDoc}
     */
    public void wrapup() throws KiemInitializationException {
        csvLines = null;
        inputCsvFile = null;
        uris = null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isProducer() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isObserver() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public JSONObject step(final JSONObject jSONObject)
            throws KiemExecutionException {
        String[] currentValues;
        if (KiemPlugin.getDefault().getExecution().getSteps() < csvLines.length) {
            currentValues = csvLines[(int) KiemPlugin.getDefault()
                                              .getExecution().getSteps()].split(";");
        } else {
            KiemPlugin.handleComponentError(this, new KiemExecutionException(
                    "No more lines in CSV file.", true, false, false, new RuntimeException(
                            "No more lines in CSV file.")));
            return null;
        }
        JSONObject stepData = new JSONObject();
        try {
            for (int i = 0; i < uris.length; i++) {
                stepData.accumulate(uris[i], currentValues[i]);
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return stepData;
    }

}
