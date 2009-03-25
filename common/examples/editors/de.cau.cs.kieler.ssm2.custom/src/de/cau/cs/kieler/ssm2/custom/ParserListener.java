package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class ParserListener implements Adapter{

	public static final ParserListener parserInstance = new ParserListener();
	
	private ParserListener() {
		
	}

	public Notifier getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAdapterForType(Object type) {
		// TODO Auto-generated method stub
		return false;
	}

	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	public void setTarget(Notifier newTarget) {
		// TODO Auto-generated method stub
		
	}
	
}
