package sj;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


import lejos.nxt.comm.BTConnection;
//import lejos.nxt.comm.Bluetooth;


public class EmbeddedPCLogger implements SJLogger {
	//private BTConnection btc;
	private DataInputStream dis;
	private DataOutputStream dos;

	public EmbeddedPCLogger(BTConnection btc) {
		//btc = Bluetooth.waitForConnection();
		dis = btc.openDataInputStream();
		dos = btc.openDataOutputStream();
	}

	
	public void log(LogMsgTyp msgTyp, String message){
		if(msgTyp != LogMsgTyp.TICK_INFO){
			try {
				String s = msgTyp.name() + " --> " + message + "\n";
				dos.writeBytes(s);
				dos.flush();
			} catch (IOException e) {
				e.getMessage();
			}	
		}
		// ################################################################### //
	    // ########################## ADDED BY ME! ########################### //
	    // ################################################################### //
		else {
			try {
				dos.writeBytes(message + "\n");
				dos.flush();
			} catch (IOException e) {
				e.getMessage();
			}
		}
		// ################################################################### //
	    // ################################################################### //
	}
	
	
	public StringBuffer receiveCommandMessage() {
		StringBuffer buf = new StringBuffer();
		try {
			String line = dis.readLine();   // FIXME: Find a way to use BufferedReader.readLine() instead!
			while( !line.equals("EOT") ) {
				buf.append(line);
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
			dis.close();
			dos.close();
			Thread.sleep(100); // wait for data to drain
			//btc.close();
		} catch (IOException e) {
			e.getMessage();
		} catch (InterruptedException ie) {
			ie.getMessage();
		}
	}
}
