package sj.examples;

import lejos.nxt.LCD;
import lejos.nxt.Button;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

import java.io.IOException;

import sj.EmbeddedPCLogger;
import sj.SJLogger;
import sj.Signal;
import sj.exceptions.SignalNotDeclaredException;
import sj.util.LinkedList;

public class EmbeddedABROMain2 {
	public static Signal string2Signal(String str, EmbeddedABRO abro) throws SignalNotDeclaredException {
		if (str.equalsIgnoreCase("a")) {
			return abro.a;
		} else if (str.equalsIgnoreCase("b")) {
			return abro.b;
		} else if (str.equalsIgnoreCase("r")) {
			return abro.r;
		}
		throw new SignalNotDeclaredException();
	}
	

	
	public static void main(String[] args) throws IOException {
		System.out.println("     ");
		System.out.println("Waiting for PC  connection...");
		BTConnection btc = Bluetooth.waitForConnection();
		SJLogger logger = new EmbeddedPCLogger(btc);
		EmbeddedABRO program = new EmbeddedABRO();
		program.setLogger(logger);
		System.out.println("     ");
		
		System.out.println("ABRO is running");
		System.out.println("     ");
		String in = "";
		while (!program.isTerminated()) {
			LCD.refresh();
			char[] signals = in.toCharArray();
			LinkedList<Signal> signalList = new LinkedList<Signal>();
			for (char s : signals) {
				try {
					signalList.add(string2Signal(s + "", program));
				} catch (SignalNotDeclaredException e){
					System.out.println("ERR3");
				}
			}
			System.out.println("Signals set to:");
			Signal[] sig1 = program.getSignals();
			for (Signal s : sig1) {
				System.out.println(s.toString());
			}
			Signal[] signalArray = new Signal[signalList.size()];
			int count = 0;
			for(Signal elem : signalList) {
				signalArray[count] = elem;
				count++;
			}
			program.doTick(signalArray);
			System.out.println("Signals after tick");
			Signal[] sig2 = program.getSignals();
			for (Signal s : sig2) {
				System.out.println(s.toString());
			}
			
			// ########################################################### //
			in = "";
			logger.log(SJLogger.LogMsgTyp.TICK_INFO, "EOT");
			System.out.println("DO NEXT STEP");
			String comm = logger.receiveCommandMessage().toString();
			System.out.println(comm);
			if( comm.substring(0, 4).equals("STEP") ) {
				System.out.println("NEXT STEP OK");
				if( comm.indexOf('A') > 3 || comm.indexOf('a') > 3 ) {
					System.out.println("GETTING SIGNAL A");
					in += "A";
				}
				if( comm.indexOf('B') > 3 || comm.indexOf('b') > 3 ) {
					System.out.println("GETTING SIGNAL B");
					in += "B";
				}
				if( comm.indexOf('R') > 3 || comm.indexOf('r') > 3 ) {
					System.out.println("GETTING SIGNAL R");
					in += "R";
				}
				try {
					java.lang.Thread.sleep(3000);
				} catch( Exception e) {;}
			} else if( comm.equals("STOP") ) {
				btc.close();
				LCD.clearDisplay();
				System.out.println("                ");
				System.out.println("                ");
				System.out.println("----------------");
				System.out.println("EXITING PROGRAM!");
				System.out.println("----------------");
				System.out.println("                ");
				System.out.println("                ");
				System.out.println("                ");
				try {
		            java.lang.Thread.sleep(1000);
				} catch( Exception e) {;}
				System.exit(0);
			} else {
				System.out.println("COMMAND ERROR");
				try {
		            java.lang.Thread.sleep(2000);
				} catch( Exception e) {;}
			}
			// ########################################################### //
		}
	}
}
