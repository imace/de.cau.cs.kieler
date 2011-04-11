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
			if( line.startsWith(SIGNALS_TAG) || line.startsWith(INSTRUCTION_TAG) ) {
				line = line.substring(line.indexOf('"'));
			// if line is 'addedSignals:...' or 'removedSignals:...' do not process it
			// the newly added resp. removed signals are processed via the SIGNALS tag
			} else if(line.startsWith(PROGRAM_INFO_TAG)) {
				System.out.println(";;;;=======;;;; LINE CONTAINS THE PROGRAM_INFO TAG => DO NOT PROCESS IT");
				line = "";
			}
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
