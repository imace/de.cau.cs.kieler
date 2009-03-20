package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class ParserListener implements Adapter{

	public static final ParserListener parserInstance = new ParserListener();
	
	private ParserListener() {
		
	}

	@Override
	public Notifier getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTarget(Notifier newTarget) {
		// TODO Auto-generated method stub
		
	}
	
}
