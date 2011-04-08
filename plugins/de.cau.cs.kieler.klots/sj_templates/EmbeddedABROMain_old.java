package examples;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

import java.io.IOException;

import sj.EmbeddedPCLogger;
import sj.SJLogger;
import sj.Signal;
import sj.exceptions.SignalNotDeclaredException;
import sj.util.LinkedList;

import examples.EmbeddedABRO.StateLabel;


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
		System.out.println("     ");
		System.out.print("ENTER DEBUG MODE?");
		
		int buttonPressed = Button.waitForPress();
		if( buttonPressed == Button.ID_ESCAPE ) {
			System.out.println("  NO");
			normalMode();
		} else if( buttonPressed == Button.ID_ENTER ) {
			System.out.println("  YES");
			debugMode();
		}
	}

	
	
	// ######################################################################
	// ###################           DEBUG MODE           ###################
	// ######################################################################
	
	private static void debugMode() {
		// ----------------------- init debug mode --------------------------
		System.out.println("     ");
		System.out.println("|> DEBUG MODE <|");
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
		String comm = "";
		
		
//		logger.log(SJLogger.LogMsgTyp.TICK_INFO, "SYNCHRONIZED\nEOT");

		// NEW! Send all labels to PC!
		String s = "";
		for( StateLabel l : StateLabel.values() ) {
			s += l.name() + ";";
		}
		s = s.substring(0, s.length()-1);
		logger.log(SJLogger.LogMsgTyp.TICK_INFO, "SYNCHRONIZED\n" + s + "\nEOT");
		// ------------------------------------------------------------------
		
		while (!program.isTerminated()) {
			
			// ------------------ processing PC input -----------------------
			System.out.println("DO NEXT STEP");
			in = "";
			comm = logger.receiveCommandMessage().toString();
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
			// --------------------------------------------------------------
			
			// ------- supply input signals to program and run tick() -------
			doTick(program, in);
			logger.log(SJLogger.LogMsgTyp.TICK_INFO, "EOT");
			// --------------------------------------------------------------
			
		} // END while (!program.isTerminated())
	}
	
	
	
	// ######################################################################
	// ##################           NORMAL MODE           ###################
	// ######################################################################
	
	private static void normalMode() {
		// ----------------------- init normal mode -------------------------
		EmbeddedABRO program = new EmbeddedABRO();
		System.out.println("     ");
		System.out.println("ABRO is running");
		System.out.println("     ");
		int i = 0;
		int j = 0;
		String disp = "";
		String in = "";
		// ------------------------------------------------------------------
		
		while (!program.isTerminated()) {
			
			// ---------------- processing button input ---------------------
			LCD.refresh();
			System.out.println("Input signals:");
			System.out.println("A B R");
			i = 0;
			j = 0;
			disp = "";
			in = "";
			while (i < 3) {
				j = Button.waitForPress();
				if( j == 8 ) {
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
			// --------------------------------------------------------------
			
			// ------- supply input signals to program and run tick() -------			
			doTick(program, in);
			// --------------------------------------------------------------
			
		} // end while (!program.isTerminated())
	}

	
	
	// ######################################################################
	// #######           DO TICK (same for both run modes)           ########
	// ######################################################################
	
	private static void doTick(EmbeddedABRO program, String in) {
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
	}
	
}
