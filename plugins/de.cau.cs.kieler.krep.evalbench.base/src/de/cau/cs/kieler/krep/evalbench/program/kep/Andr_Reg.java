/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright ${year} by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 ******************************************************************************/
package de.cau.cs.kieler.krep.evalbench.program.kep;

public class Andr_Reg extends RegisterRegInst {

	public Andr_Reg(Register target, Register source, SCLine sc) {
		super(Constants.ANDR_REG.getOpcode(), Constants.ANDR_REG.getInfo(),
				target, source, sc);
	}

}
