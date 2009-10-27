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
package de.cau.cs.kieler.krep.evalbench.program.kep;

public class Cmps_Reg extends RegisterRegInst {

    public Cmps_Reg(Register target, Register source, SCLine sc) {
        super(Constants.CMPS_REG.getOpcode(), Constants.CMPS_REG.getInfo(),
                target, source, sc);
    }

}
