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
package de.cau.cs.kieler.esterel.cec;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.util.KonsoleExec;

/**
 * Wrapper class to execute CEC executables.
 * 
 * @author ctr
 * 
 */
public class CEC {

    /** all modules that are part of the CEC. The names match the names of the executables, but the */
    public enum MODULE {
        // TODO check names
        /** */
        ASTGRC("astgrc"),
        /** */
        BALASM("balasm"),
        /** */
        BLIFUTIL("blifutil"),
        /** */
        DISMANTLE("dismantle"),
        /** */
        EEC("eec"),
        /** */
        EXPANDMODULE("expandmodules"),
        /***/
        GRC3VAL("grc3val"),
        /***/
        GRCBAL("grcbal"),
        /***/
        GRCC2("grcc2"),
        /***/
        GRCDOT("grcdot"),
        /***/
        GRCOPT("grcopt"),
        /***/
        GRCPDG("grcpdg"),
        /***/
        GRCSIM("grcsim"),
        /***/
        PDGBLIF("pdgblif"),
        /***/
        PDGCCFG("pdgccfg"),
        /***/
        SCFGC("scfgc"),
        /***/
        SMBLIF("smblif"),
        /***/
        STRLXML("strlxml"),
        /***/
        V5CMAIN("v5-cmain"),
        /***/
        VM("vm"),
        /***/
        VMWRAPPER("vm-wrapper"),
        /***/
        XMLSTRL("xmlstrl");

        private String cmd;

        private MODULE(String c) {
            this.cmd = c;
        }

        public String toString() {
            return cmd;
        }
    }

    public static InputStream exec(MODULE module, InputStream input) throws KielerException {
        Bundle[] fragments = Platform.getFragments(Activator.getDefault().getBundle());

        if (fragments.length != 1) {
            throw new KielerException("cec compiler not found", null);
        }
        Bundle compiler = fragments[0];

        String path;
        try {
            path = FileLocator.toFileURL(FileLocator.find(compiler, new Path(""), null)).getPath();
        } catch (IOException e) {
            throw new KielerException("cannot load file", e);
        }

        String cmd = path + "cec-" + module;

        return KonsoleExec.exec(cmd, input, 500, 100, 10);
    }

    /**
     * Compile Esterel file to C. This is directly derived from the CEC script with the default
     * values.
     * 
     * @param strlFile
     *            name of the input File.
     * @return
     * @throws IOException
     * @throws KielerException
     */
    public static URI run(URI strlFile) throws IOException, KielerException {

        File outFile = File.createTempFile("strl", ".c");
        InputStream strl = new FileInputStream(strlFile.getPath());
        InputStream ast = exec(MODULE.STRLXML, strl);
        InputStream exp = exec(MODULE.EXPANDMODULE, ast);
        InputStream dis = exec(MODULE.DISMANTLE, exp);
        InputStream grc = exec(MODULE.ASTGRC, dis);
        InputStream opt = exec(MODULE.GRCOPT, grc);
        InputStream pdg = exec(MODULE.GRCPDG, opt);
        InputStream ccfg = exec(MODULE.PDGCCFG, pdg);
        InputStream scfg = exec(MODULE.EEC, ccfg);
        InputStream c = exec(MODULE.SCFGC, scfg);

        FileWriter out = new FileWriter(outFile);
        while (c.available() > 0) {
            out.append(new String(Character.toChars(c.read())));
        }
        out.flush();
        out.close();
        return outFile.toURI();
    }

}
