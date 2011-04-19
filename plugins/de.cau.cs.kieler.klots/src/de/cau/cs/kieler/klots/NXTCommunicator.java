package de.cau.cs.kieler.klots; 

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTConnector;

public class NXTCommunicator {
	
	public final String SIGNALS_TAG = "SIGNALS";
	public final String INSTRUCTION_TAG = "INSTRUCTION";
	public final String TICK_INFO_TAG = "TICK_INFO";
	public final String PROGRAM_INFO_TAG = "PROGRAM_INFO";
	
	private final String PRINT_START_COMMAND_KEY = "PRINT_START:";
	private final String PRINT_END_COMMAND_KEY = ":PRINT_END";
	public final String PRINT_TAG = "PRINT:";
	private static boolean consolePrint;
	
	static NXTConnector conn;
	static DataOutputStream dos;
	static DataInputStream dis;
	private static boolean connected;
	
	/** The instance of the distributor. */
    private static final NXTCommunicator INSTANCE = new NXTCommunicator();
	
	public NXTCommunicator() {
		NXTCommunicator.connectToNXT();
	}

	
	public static NXTCommunicator getInstance() {
		if( !connected ) {
			System.out.println("Reconnecting to NXT... ");
			connectToNXT();
		}
        return INSTANCE;
    }
	
	
	private static void connectToNXT() {
		// Connect to any NXT over Bluetooth
		conn = new NXTConnector();
		System.out.println("Searching for NXTs... ");
		boolean connOK = conn.connectTo("btspp://");
		if (!connOK) {
			System.out.println();
			System.err.println("Failed to connect to any NXT!");
			return;
		}
		System.out.println("Connected to NXT >" + conn.getNXTInfo().name + "<!");
		dos = conn.getDataOut();
		dis = conn.getDataIn();
		connected = true;
		consolePrint = false;
	}
	
	
	public int sendMessage(String msg) {
		System.out.println("[+][+][+][+][+][+][+][+][+] SENDING MESSAGE TO NXT: >" + msg + "<");
		try {
			dos.writeBytes(msg + "\nEOT\n");
			dos.flush();
			return 0;
		} catch (IOException ioe) {
			System.out.println("IO Exception writing message bytes:");
			System.out.println(ioe.getMessage());
			return 1;
		}
	}
	
	
	public StringBuffer receiveMessage() {
		StringBuffer buf = new StringBuffer();
		String line = this.receiveMessageLine();
		while( !line.equals("EOT") ) {
			// do not process empty lines
			if( !line.equals("") ) {
				buf.append("{" + line + "},\n");
			}
			line = this.receiveMessageLine();
		}
		return buf.replace(buf.length()-2, buf.length(), "]").insert(0, "[");
	}
	
	
	@SuppressWarnings("deprecation")
	public String receiveMessageLine() {
		try {
			String line = dis.readLine();   // FIXME: Find a way to use BufferedReader.readLine() instead!
			System.out.println(";;;;=======;;;; RECEIVED MESSAGE LINE = >" + line + "<");
			
			// ----------------------------------------------------------
			//XXX: REMOTE CONSOLE SUPPORT
			if( consolePrint ) {
				line = PRINT_TAG + line;
				if( line.endsWith(PRINT_END_COMMAND_KEY) ) {
					line = line.substring( 0, line.lastIndexOf(PRINT_END_COMMAND_KEY) );
					consolePrint = false;
				}
				return line;
			}
			// ----------------------------------------------------------
			
			if( line.startsWith(SIGNALS_TAG) || line.startsWith(INSTRUCTION_TAG) ) {
				line = line.substring(line.indexOf('"'));
			// if line is 'addedSignals:...' or 'removedSignals:...' do not process it
			// the newly added resp. removed signals are processed via the SIGNALS tag
			} else if(line.startsWith(PROGRAM_INFO_TAG)) {
				System.out.println(";;;;=======;;;; LINE CONTAINS THE PROGRAM_INFO TAG => DO NOT PROCESS IT");
				line = "";
			}
			
			// ----------------------------------------------------------
			//XXX: REMOTE CONSOLE SUPPORT
			else if( line.startsWith(PRINT_START_COMMAND_KEY) ) {
				line = PRINT_TAG + line.substring( PRINT_START_COMMAND_KEY.length() );
				consolePrint = true;
				if( line.endsWith(PRINT_END_COMMAND_KEY) ) {
					line = line.substring( 0, line.lastIndexOf(PRINT_END_COMMAND_KEY) );
					consolePrint = false;
				}
			}
			// ----------------------------------------------------------
			
			return line;
		} catch (IOException ioe) {
			System.out.println(">>> IO Exception reading message bytes:");
			System.out.println(ioe.getMessage());
			return ioe.getMessage();
		}
	}
	
	public void closeTransmission() {
		try {
			dis.close();
			dos.close();
			conn.close();
			connected = false;
		} catch (IOException ioe) {
			System.out.println("IOException closing connection:");
			System.out.println(ioe.getMessage());
		}
	}
	
}
