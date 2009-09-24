package de.cau.cs.kieler.krep.evalbench.comm;

import java.util.LinkedList;

import org.eclipse.core.runtime.IProgressMonitor;

import de.cau.cs.kieler.krep.evalbench.exceptions.CommunicationException;
import de.cau.cs.kieler.krep.evalbench.exceptions.LoadException;
import de.cau.cs.kieler.krep.evalbench.program.IAssembler;


/**
 * Interface for communication protocol layers used between the common layer and
 * connection protocols.
 * 
 * @author msp
 */
public interface ICommunicationProtocol {

    /** Identifier for the KEP protocol */
    public static final String P_KEP = "kep";
    /** Identifier for the KReP protocol */
    public static final String P_KREP = "krep";

    /**
     * Adds a communication listener that is notified of all transferred data.
     * 
     * @param listener
     *            listener to be added
     */
    public void addCommunicationListener(ICommunicationListener listener);

    /**
     * Removes a communication listener from the list.
     * 
     * @param listener
     *            listener to be removed
     */
    public void removeCommunicationListener(ICommunicationListener listener);

    /**
     * Verifies communication by sending a command and receiving a return
     * string.
     * 
     * @return readable text describing verification result
     * @throws CommunicationException
     *             when the return string is invalid
     */
    public String verifyCommunication() throws CommunicationException;

    /**
     * Requests target information from the target and translates the received
     * return string.
     * 
     * @return readable target information
     * @throws CommunicationException
     *             when the return string is invalid
     */
    public String getTargetInfo() throws CommunicationException;

    /**
     * Loads a program onto the connected target.
     * 
     * @param program
     *            array of hex encoded instructions
     * @param monitor
     *            progress-monitor, null if nothing shall be displayed
     * @return true iff loading was successful
     * @throws CommunicationException
     *             when the program string has an invalid length
     * @throws LoadException
     *             cannot execute this program
     */
    public boolean loadProgram(IAssembler program, IProgressMonitor monitor)
	    throws CommunicationException, LoadException;

    /**
     * Resets the current program on the target.
     * 
     * @throws CommunicationException
     *             when an invalid reply was received
     */
    public void resetStatus() throws CommunicationException;

    /**
     * Performs a program tick by sending the global input signal status,
     * executing the tick command and reading the global output signal status.
     * 
     * @param maxSignals
     *            number of signals in the current program. This is need
     * @param inputs
     *            input signals
     * @param outputs
     *            output signals
     * @return number of instruction cycles to compute the tick
     * @throws CommunicationException
     *             when an invalid reply was received
     */
    public int tick(int maxSignals, LinkedList<Signal> inputs,
	    LinkedList<Signal> outputs) throws CommunicationException;

    /**
     * Requests the valid tick length for the last tick command.
     * 
     * @return number of instruction cycles used for the last tick
     * @throws CommunicationException
     *             when the return string is invalid
     */
    // public int getTickLength() throws CommunicationException;
    /**
     * Requests an execution trace for the last tick command.
     * 
     * @return list of addresses of executed instructions
     * @throws CommunicationException
     *             when the received trace is invalid
     */
    public int[] getExecutionTrace() throws CommunicationException;

    /**
     * When executed the target is set to continuous mode. Only external inputs
     * and outputs are used in this mode.
     * 
     * @throws CommunicationException
     *             when an exception occurs while sending the command
     */
    public void continuousRun() throws CommunicationException;

    /**
     * Stops continuous mode and returns to single tick mode.
     * 
     * @throws CommunicationException
     *             when an invalid reply was received
     */
    public void stopContinuous() throws CommunicationException;

    /**
     * add a comment to the communication trace. This is useful, if an esi-File
     * is automatically generated
     * 
     * @param string comment to the next operation
     */
    public void comment(String string);

    public void dumpRom();

}
