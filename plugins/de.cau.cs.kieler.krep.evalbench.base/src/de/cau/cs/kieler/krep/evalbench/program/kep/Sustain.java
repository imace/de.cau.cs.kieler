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


public class Sustain extends SigDataInstruction {

	public Sustain (KepSignal sig,  SCLine sc){
		super(Constants.SUSTAIN.getOpcode(),Constants.SUSTAIN.getInfo(),sig, sc);
	}
	public Sustain (KepSignal sig,Data data , SCLine sc){
		super(Constants.SUSTAIN.getOpcode(),Constants.SUSTAIN.getInfo(),sig,data, sc);
	}
}
