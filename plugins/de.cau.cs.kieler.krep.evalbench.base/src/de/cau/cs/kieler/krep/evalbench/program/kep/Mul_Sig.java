/******************************************************************************
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
 ******************************************************************************/
package de.cau.cs.kieler.krep.evalbench.program.kep;

public class Mul_Sig extends SigRegInst {

	public Mul_Sig(Register reg, KepSignal sig, SCLine sc) {
		super(Constants.MUL_SIG.getOpcode(), Constants.MUL_SIG.getInfo(), reg,
				sig, sc);

	}
}
