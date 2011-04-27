package de.cau.cs.kieler.klots.sj.embedded;

import sj.SJLogger;


public class EmbeddedPCLogger implements SJLogger {
	private EmbeddedPCCommunicator comm;

	public EmbeddedPCLogger(EmbeddedPCCommunicator comm) {
		this.comm = comm;
	}

	
	public void log(LogMsgTyp msgTyp, String message){
		if(msgTyp != LogMsgTyp.TICK_INFO){
			comm.sendMessage(msgTyp.name() + " --> " + message +
					EmbeddedConstants.MESSAGE_LINE_DELIMITER);
		} else {
			comm.sendMessage(message + EmbeddedConstants.MESSAGE_LINE_DELIMITER);
		}
	}
}
