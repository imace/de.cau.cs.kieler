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
package de.cau.cs.kieler.krep.evalbench.ui.editors;

import de.cau.cs.kieler.krep.evalbench.comm.ICommunicationProtocol;
import de.cau.cs.kieler.krep.evalbench.program.KepAssembler;

/**
 * An editor for KEP assembler files that uses the functionality of the abstract
 * <code>AssemblerEditor</code>.
 * 
 * @author msp
 */
public class KasmEditor extends AssemblerEditor {

    /**
     * Creates a KASM editor using the external assembler.
     */
    public KasmEditor() {
        super();
        setAssembler(new KepAssembler());
    }

    /*
     * (non-Javadoc)
     * 
     * @see krep.evalbench.ui.editors.AssemblerEditor#getProtocolType()
     */
    @Override
    public String getProtocolType() {
        return ICommunicationProtocol.P_KEP;
    }

}
