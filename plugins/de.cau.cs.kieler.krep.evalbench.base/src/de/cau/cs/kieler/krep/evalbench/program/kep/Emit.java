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



public class Emit extends SigDataInstruction {

	public Emit (KepSignal sig,  SCLine sc){
		super(Constants.EMIT.getOpcode(),Constants.EMIT.getInfo(),sig, sc);
	}
	public Emit (KepSignal sig,Data data , SCLine sc){
		super(Constants.EMIT.getOpcode(),Constants.EMIT.getInfo(),sig,data, sc);
	}
}
