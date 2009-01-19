package de.cau.cs.kieler.layouter.gef;

import kiel.layouter.graphviz.LayouterPlugin;

import org.eclipse.draw2d.Graphics;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.layouter.ui.WorkbenchPreferencePage;


public class SplineCurveConnectionWithPrefs extends SplineCurveConnection {

	/* read preferences and set internal variables to determine the spline setup */
	private void retrievePreferences(){
		IPreferenceStore prefs = LayouterPlugin.getDefault().getPreferenceStore();
		// get step size
		double s = prefs.getDouble(WorkbenchPreferencePage.PREF_CONNECTION_STEPSIZE);
		if(s <= 0 || s >= 1)
			s = prefs.getDefaultDouble(WorkbenchPreferencePage.PREF_CONNECTION_STEPSIZE);
		if(s > 0 || s < 1)
			stepSize = s;
		// get debug
		debug = prefs.getBoolean(WorkbenchPreferencePage.PREF_CONNECTION_DEBUG);
		
	}

	/*
	 * (non-Javadoc)
	 * The main drawing method. Here the magic happens.
	 * @see org.eclipse.draw2d.Polyline#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void outlineShape(Graphics g){
		retrievePreferences();
		super.outlineShape(g);
	}
}
