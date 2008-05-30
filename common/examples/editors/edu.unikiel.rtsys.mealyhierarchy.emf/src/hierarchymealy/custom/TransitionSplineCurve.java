package hierarchymealy.custom;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineDecoration;

import edu.unikiel.rtsys.layouter.gef.SplineCurveConnection;
import edu.unikiel.rtsys.layouter.gef.SplineCurveConnectionWithPrefs;

public class TransitionSplineCurve extends SplineCurveConnectionWithPrefs {

	public TransitionSplineCurve() {
		super();
		
		// PolylineDecoration pd = new PolylineDecoration();
		PolygonDecoration pd = new PolygonDecoration();
		//pd.setLineWidth(2);
		//pd.setSize(5, 5);
		this.setTargetDecoration(pd);
	}
	
	
}
