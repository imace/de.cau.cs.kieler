package de.cau.cs.kieler.layouter.gef;

import static org.junit.Assert.fail;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Before;
import org.junit.Test;

public class SplineCurveConnectionTest {

	Shell shell;
	Figure parent;
	
	@Before
	public void setUp() throws Exception {
		shell = new Shell();
	    LightweightSystem lws = new LightweightSystem(shell);
	    parent = new Figure();
	    parent.setLayoutManager(new XYLayout());
	    lws.setContents(parent);
	}

	@Test
	public void testOutlineShapeGraphics() {
		SplineCurveConnection spline = new SplineCurveConnection();
		PointList pl = new PointList();
		pl.addPoint(new Point(10,10));
		pl.addPoint(new Point(30,10));
		pl.addPoint(new Point(50,50));
		pl.addPoint(new Point(100,50));
		pl.addPoint(new Point(50,100));
		pl.addPoint(new Point(200,100));
		pl.addPoint(new Point(220,120));
		pl.addPoint(new Point(245,140));
		pl.addPoint(new Point(260,165));
		pl.addPoint(new Point(285,180));
		spline.setPoints(pl);
		parent.add(spline);
		eventLoop();
	}
	
	private void eventLoop(){
		shell.setSize(300, 300);
	    shell.open();
	    shell.setText("Example");
	    Display display = Display.getDefault();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	}

}
