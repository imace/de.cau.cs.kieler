package examples;

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

public class EmbeddedABROMain {
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
		// for reading signal from the terminal
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		// Creating a new instance of ABRO
		
		//ABRO program = new ABRO();
		System.out.println("     ");
		System.out.println("Waiting for PC  connection...");
		BTConnection btc = Bluetooth.waitForConnection();
		SJLogger logger = new EmbeddedPCLogger(btc);
		EmbeddedABRO program = new EmbeddedABRO();
		program.setLogger(logger);
		System.out.println("     ");
		
		System.out.println("ABRO is running");
		System.out.println("     ");
		while (!program.isTerminated()) {
			LCD.refresh();
			System.out.println("Input signals:");
			System.out.println("A B R");
			int i = 0;
			int j = 0;
			String disp = "";
			String in = "";
			while (i < 3) {
				j = Button.waitForPress();
				if( j == 8 ) {
					//program.getLogger().destroy();
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
				} else if( j == 1 ) {
					disp += "+ ";
				} else {
					disp += "- ";
				}
				LCD.drawString(disp, 0, 7);
				i++;
			}
			if (disp.charAt(0) == '+') {
				in += "A ";   // FIXME: DO NOT USE WHITESPACES!
			}
			if (disp.charAt(2) == '+') {
				in += "B ";   // FIXME: DO NOT USE WHITESPACES!
			}
			if (disp.charAt(4) == '+') {
				in += "R";
			}
			char[] signals = in.toCharArray();
			LinkedList<Signal> signalList = new LinkedList<Signal>();
//			System.out.println("STOP 1");
//			try {
//	            java.lang.Thread.sleep(1000);
//			} catch( Exception e) {;}
			for (char s : signals) {
				try {
					signalList.add(string2Signal(s + "", program));
				} catch (SignalNotDeclaredException e){
					System.out.println("ERR3");
				}
			}
//			System.out.println("STOP 2");
//			try {
//	            java.lang.Thread.sleep(1000);
//			} catch( Exception e) {;}
			System.out.println("Signals set to:");
			Signal[] sig1 = program.getSignals();
//			System.out.println("STOP 2++");
//			try {
//	            java.lang.Thread.sleep(1000);
//			} catch( Exception e) {;}
			for (Signal s : sig1) {
				System.out.println(s.toString());
			}
//			System.out.println("STOP 3");
//			try {
//	            java.lang.Thread.sleep(1000);
//			} catch( Exception e) {;}
			Signal[] signalArray = new Signal[signalList.size()];
//			System.out.println("STOP 4");
//			try {
//	            java.lang.Thread.sleep(1000);
//			} catch( Exception e) {;}
			int count = 0;
			for(Signal elem : signalList) {
				signalArray[count] = elem;
				count++;
			}
			program.doTick(/*signalList.toArray(signalArray)*/signalArray);
//			System.out.println("STOP 5");
//			try {
//	            java.lang.Thread.sleep(1000);
//			} catch( Exception e) {;}
			System.out.println("Signals after tick");
			Signal[] sig2 = program.getSignals();
			for (Signal s : sig2) {
				System.out.println(s.toString());
			}
			
			// ########################################################### //
			logger.log(SJLogger.LogMsgTyp.TICK_INFO, "EOT");
			System.out.print("DO NEXT STEP");
			String comm = logger.receiveCommandMessage().toString();
			if( comm.equals("STEP") ) {
				System.out.println("->OK");
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
		            java.lang.Thread.sleep(1000);
				} catch( Exception e) {;}
			}
			// ########################################################### //
		}
	}
}
