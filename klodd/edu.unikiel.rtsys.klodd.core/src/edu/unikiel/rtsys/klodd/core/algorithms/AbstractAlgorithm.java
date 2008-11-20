package edu.unikiel.rtsys.klodd.core.algorithms;

/**
 * Superclass for algorithms used in the KLoDD project.
 * 
 * @author msp
 */
public abstract class AbstractAlgorithm implements IAlgorithm {

	/**
	 * This implementation of the reset method does nothing. It should
	 * be overridden by subclasses that need to do some work to reset their
	 * internal state.  
	 */
	public void reset() {
	}
	
}
