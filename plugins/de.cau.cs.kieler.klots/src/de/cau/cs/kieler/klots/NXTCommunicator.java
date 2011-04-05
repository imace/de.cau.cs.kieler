package de.cau.cs.kieler.klots; 

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTConnector;

public class NXTCommunicator {
	
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
			buf.append("{" + line + "},\n");
			line = this.receiveMessageLine();
		}
		return buf.replace(buf.length()-2, buf.length(), "]").insert(0, "[");
	}
	
	
	@SuppressWarnings("deprecation")
	public String receiveMessageLine() {
		try {
			String line = dis.readLine();   // FIXME: Find a way to use BufferedReader.readLine() instead!
			if( line.startsWith("SIGNALS") || line.startsWith("INSTRUCTION") ) {
				line = line.substring(line.indexOf('"'));
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
