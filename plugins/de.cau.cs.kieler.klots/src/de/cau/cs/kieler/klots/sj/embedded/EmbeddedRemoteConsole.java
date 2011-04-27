package de.cau.cs.kieler.klots.sj.embedded;

import de.cau.cs.kieler.klots.sj.embedded.EmbeddedConstants;


public class EmbeddedRemoteConsole {
	
	private EmbeddedPCCommunicator comm = null;
	private boolean standaloneMode = false;

	public EmbeddedRemoteConsole() {
	}

	
	public void print(String message){
		if( comm != null ) {
			comm.sendMessage(EmbeddedConstants.PRINT_START_COMMAND_KEY);
			comm.sendMessage(message);
			comm.sendMessage(EmbeddedConstants.PRINT_END_COMMAND_KEY +
					EmbeddedConstants.MESSAGE_LINE_DELIMITER);
		}
	}
	
	public void println(String message){
		print(message + EmbeddedConstants.MESSAGE_NEW_LINE +
				EmbeddedConstants.MESSAGE_LINE_DELIMITER);
	}
	
	
	public void open() {
		comm = EmbeddedPCCommunicator.getInstance();
		comm.sendMessage(EmbeddedConstants.STANDALONE_PROGRAM_MODE_COMMAND_KEY +
				EmbeddedConstants.MESSAGE_LINE_DELIMITER +
				EmbeddedConstants.END_OF_MESSAGE_COMMAND_KEY +
				EmbeddedConstants.MESSAGE_LINE_DELIMITER);
		standaloneMode = true;
		String reply = comm.receiveMessage().toString();
		if( reply.indexOf(EmbeddedConstants.STANDALONE_PROGRAM_MODE_COMMAND_KEY) < 0 ) {
			close();
		}
	}
	
	
	public void openSJMode() {
		comm = EmbeddedPCCommunicator.getInstance();
	}
	
	
	public void close() {
		if( standaloneMode ) {
			comm.sendMessage(EmbeddedConstants.END_OF_MESSAGE_COMMAND_KEY +
					EmbeddedConstants.MESSAGE_LINE_DELIMITER);
		}
		if( comm != null ) {
			comm.destroy();
		}
		comm = null;
	}
	
}
