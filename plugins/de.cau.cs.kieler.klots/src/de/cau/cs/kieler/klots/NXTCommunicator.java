package de.cau.cs.kieler.klots; 

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTConnector;
import lejos.pc.comm.NXTInfo;
import lejos.pc.comm.NXTComm;

import de.cau.cs.kieler.klots.util.KlotsConstants;

public class NXTCommunicator {
	
	private static boolean consolePrint;
	
	static NXTConnector conn;
	static DataOutputStream dos;
	static DataInputStream dis;
	private static boolean connected;
	private static NXTInfo nxtInfo;
	
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
		boolean connOK = false;
		if( nxtInfo == null ) {
			System.out.println("Searching for NXTs... ");
			connOK = conn.connectTo("btspp://", NXTComm.LCP);
		} else {
			System.out.println("Connecting to NXT >" + nxtInfo.name + "< ...");
			connOK = conn.connectTo(nxtInfo, NXTComm.LCP);
		}
		if (!connOK) {
			System.out.println();
			System.err.println("Failed to connect to any NXT!");
			return;
		}
		System.out.println("Connected to NXT >" + conn.getNXTInfo().name + "<!");
		nxtInfo = conn.getNXTInfo();
		dos = conn.getDataOut();
		dis = conn.getDataIn();
		connected = true;
		consolePrint = false;
	}
	
	
	public NXTInfo getNXTInfo() {
		return conn.getNXTInfo();
	}
	
	
	public NXTConnector getNXTConnector() {
		return conn;
	}
	
	
	public NXTInfo[] searchForNXTs() {
		return conn.search(null, null, NXTCommFactory.BLUETOOTH|NXTCommFactory.USB);
	}
	
	
	public NXTComm getNXTComm() {
		return conn.getNXTComm();
	}
	
	
	public int sendMessage(String msg) {
		System.out.println("[+][+][+][+][+][+][+][+][+] SENDING MESSAGE TO NXT: >" + msg + "<");
		try {
			dos.writeBytes(
					msg +
					KlotsConstants.MESSAGE_LINE_DELIMITER +
					KlotsConstants.END_OF_MESSAGE_COMMAND_KEY +
					KlotsConstants.MESSAGE_LINE_DELIMITER);
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
		while( !line.equals(KlotsConstants.END_OF_MESSAGE_COMMAND_KEY) ) {
			// do not process empty lines
			if( !line.equals(KlotsConstants.EMPTY_STRING) ) {
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
			
			// if in 'remote console print' mode
			if( consolePrint ) {
				line = KlotsConstants.PRINT_TAG + line;
				if( line.endsWith(KlotsConstants.PRINT_END_COMMAND_KEY) ) {
					line = line.substring( 0, line.lastIndexOf(KlotsConstants.PRINT_END_COMMAND_KEY) );
					consolePrint = false;
				}
				return line;
			}
			
			// if in 'normal' mode
			if( line.startsWith(KlotsConstants.SIGNALS_TAG) || line.startsWith(KlotsConstants.INSTRUCTION_TAG) ) {
				line = line.substring(line.indexOf(KlotsConstants.QUOTE_SIGN_CHAR));
			// if line is 'addedSignals:...' or 'removedSignals:...' do not process it
			// the newly added resp. removed signals are processed via the SIGNALS tag
			} else if(line.startsWith(KlotsConstants.PROGRAM_INFO_TAG)) {
				System.out.println(";;;;=======;;;; LINE CONTAINS THE PROGRAM_INFO TAG => DO NOT PROCESS IT");
				line = "";
			// initiate 'remote console print' mode
			} else if( line.startsWith(KlotsConstants.PRINT_START_COMMAND_KEY) ) {
				line = KlotsConstants.PRINT_TAG + line.substring( KlotsConstants.PRINT_START_COMMAND_KEY.length() );
				consolePrint = true;
				if( line.endsWith(KlotsConstants.PRINT_END_COMMAND_KEY) ) {
					line = line.substring( 0, line.lastIndexOf(KlotsConstants.PRINT_END_COMMAND_KEY) );
					consolePrint = false;
				}
			}
			
			return line;
		} catch (IOException ioe) {
			System.out.println(">>> IO Exception reading message bytes:");
			System.out.println(ioe.getMessage());
			return ioe.getMessage();
		}
	}
	
	public void closeTransmission(boolean notifyCommunicationPartner) {
		try {
			if( notifyCommunicationPartner ) {
				sendMessage(KlotsConstants.END_OF_TRANSMISSION_COMMAND_KEY);
			}
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
