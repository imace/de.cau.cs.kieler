package edu.unikiel.informatik.aiw.gctl.edit.customs;

import org.eclipse.ui.IStartup;



public class GCTLEditCustomsPlugin implements IStartup{

	ForeignModelLoader loader;
	
	@Override
	public void earlyStartup() {
		new ForeignModelLoader();
	}
}
