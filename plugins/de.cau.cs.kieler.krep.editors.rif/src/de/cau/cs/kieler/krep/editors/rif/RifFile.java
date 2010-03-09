/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.krep.editors.rif;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import de.cau.cs.kieler.krep.editors.rif.rif.Trace;
import de.cau.cs.kieler.sim.trace.ITraceProvider;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;

/**
 * @author ctr
 * 
 */
public class RifFile implements ITraceProvider {

    private static final String[] EXTENSIONS = { "rif" };

    /** {@inheritDoc} */
    public LinkedList<RifTrace> loadTrace(final String fileName) throws KiemInitializationException {
        LinkedList<RifTrace> res = new LinkedList<RifTrace>();
        ISetup setup = new RifStandaloneSetup();
        Injector injector = setup.createInjectorAndDoEMFRegistration();
        XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
        rs.setClasspathURIContext(getClass());

        IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
        // setup.doSetup();
        URI uri = URI.createURI("de.cau.cs.kieler.krep.editors.rif"); // Activator.PLUGIN_ID);
        XtextResource resource = (XtextResource) resourceFactory.createResource(uri);
        rs.getResources().add(resource);

        InputStream in;
        try {
            if (fileName != null && fileName.length() > 0) {
                in = new FileInputStream(fileName);
            } else {
                throw new KiemInitializationException(
                        "EsiComponent is activated but no trace file is set", false, null);
            }

            Injector inj = new RifStandaloneSetup().createInjectorAndDoEMFRegistration();
            IAntlrParser parser = inj.getInstance(IAntlrParser.class);
            IParseResult parseResult = parser.parse(in);
            if (!parseResult.getParseErrors().isEmpty()) {
                throw new KiemInitializationException("Parse error: "
                        + parseResult.getParseErrors().get(0).getMessage(), true, null);
            }
            res.add(new RifTrace((Trace) parseResult.getRootASTElement()));
        } catch (FileNotFoundException e) {
            throw new KiemInitializationException("File not found", false, e);
        }
        return res;
    }

    /**
     * {@inheritDoc}
     */
    public String[] getExtensions() {
        return EXTENSIONS;
    }

}
