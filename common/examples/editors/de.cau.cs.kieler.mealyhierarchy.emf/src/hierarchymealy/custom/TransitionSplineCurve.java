package hierarchymealy.custom;

import org.eclipse.draw2d.PolygonDecoration;

import edu.unikiel.rtsys.layouter.gef.SplineCurveConnectionWithPrefs;

public class TransitionSplineCurve extends SplineCurveConnectionWithPrefs {
//public class TransitionSplineCurve extends BezierCurveConnection {
//                                           Bezier does not work yet
	public TransitionSplineCurve() {
		super();
		
		// PolylineDecoration pd = new PolylineDecoration();
		PolygonDecoration pd = new PolygonDecoration();
		//pd.setLineWidth(2);
		//pd.setSize(5, 5);
		this.setTargetDecoration(pd);
	}
	
	
}
