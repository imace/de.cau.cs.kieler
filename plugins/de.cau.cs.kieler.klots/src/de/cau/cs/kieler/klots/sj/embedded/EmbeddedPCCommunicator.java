package de.cau.cs.kieler.klots.sj.embedded;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

import de.cau.cs.kieler.klots.sj.embedded.EmbeddedConstants;


public class EmbeddedPCCommunicator {
	private BTConnection btc;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	private boolean closeTransmissionRequest = false;
	
	private final static EmbeddedPCCommunicator INSTANCE = new EmbeddedPCCommunicator();

	
	public EmbeddedPCCommunicator() {
		btc = Bluetooth.waitForConnection();
		dis = btc.openDataInputStream();
		dos = btc.openDataOutputStream();
	}
	
	
	public static EmbeddedPCCommunicator getInstance() {
		return INSTANCE;
	}

	
	public void sendMessage(String message) {
		try {
			dos.writeBytes(message);
			dos.flush();
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	
	public StringBuffer receiveMessage() {
		StringBuffer buf = new StringBuffer();
		try {
			String line = dis.readLine();   // FIXME: Find a way to use BufferedReader.readLine() instead!
			while( !line.equals(EmbeddedConstants.END_OF_MESSAGE_COMMAND_KEY) ) {
				buf.append(line);
				if( line.equals(EmbeddedConstants.END_OF_TRANSMISSION_COMMAND_KEY) ) {
					closeTransmissionRequest = true;
					destroy();
					return buf;
				}
				line = dis.readLine();   // FIXME: Find a way to use BufferedReader.readLine() instead!
			}
			//return buf.append( dis.readLine() );   // FIXME: Find a way to use BufferedReader.readLine() instead!
		} catch (IOException ioe) {
			System.out.println("COMM ERR");
		}
		return buf;
	}

	
	public void destroy() {
		try {
			if( !closeTransmissionRequest ) {
				sendMessage(EmbeddedConstants.END_OF_TRANSMISSION_COMMAND_KEY +
					EmbeddedConstants.MESSAGE_LINE_DELIMITER);
			}
			dis.close();
			dos.close();
			Thread.sleep(100); // wait for data to drain
			btc.close();
		} catch (IOException e) {
			e.getMessage();
		} catch (InterruptedException ie) {
			ie.getMessage();
		}
	}
}
