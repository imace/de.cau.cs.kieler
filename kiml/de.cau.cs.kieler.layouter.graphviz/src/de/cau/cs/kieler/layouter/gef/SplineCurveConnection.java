package de.cau.cs.kieler.layouter.gef;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * A Spline Curve Connection extends a PolylineConnection and draws
 * a more or less smooth curve instead of a Polyline. It adds additional
 * spline bendpoints according to the cubic spline calculations. The number
 * off additional points can be configured (i.e. step size).
 * 
 * TODO: * handle selection correctly. selecting with mouse is only possible
 *         at the old polyline positions.
 *       * handle rotation of decoration correctly
 *       * use some really smooth curve drawing instead of draw-line, which
 *         is only a finer granular polyline.
 * 
 * @author Hauke Fuhrmann <haf@informatik.uni-kiel.de>
 *         Christian-Albrechts-University of Kiel
 * @version 0.1, 2008-05-30
 */

public class SplineCurveConnection extends PolylineConnection {

	/* enumeration to address coordinates */
	private static final int X0 = 0;
	private static final int Y0 = 1;
	private static final int X1 = 2;
	private static final int Y1 = 3;

	/** Splines for x and y coordinates */
	Spline splineX;
	Spline splineY;
	/** Bendpoints */
	double[] px;
	double[] py;
	/** step size */
	double stepSize = 0.25;
	/** Outermost points of this spline to calculate the bounds from */
	int[] watermark;

	/** Show debug infos, e.g. additional spline bendpoints */
	boolean debug = false;

	public SplineCurveConnection() {
		watermark = new int[4];
		this.resetWatermarks();
	}

	/**
	 * Set the spline interpolation step size to some small value
	 * between 0 and 1. Default is 0.01.
	 * @param stepSize
	 */
	public void setStepSize(double stepSize){
		this.stepSize = stepSize;
	}

	/*
	 * (non-Javadoc)
	 * The main drawing method. Here the magic happens.
	 * @see org.eclipse.draw2d.Polyline#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void outlineShape(Graphics g){
		double x0 = 0, y0 = 0, x1 = 0, y1 = 0;
		int ii = 1;
		resetWatermarks();
		createSplines();
		for(int i=0; i< px.length-1; i++){ // iterate over all bendpoints
			x0 = splineX.interpolate(i, 0);
			y0 = splineY.interpolate(i, 0);
			updateWatermarks((int)x0, (int)y0);
			double pos;
			for (pos = stepSize; pos <= 1; pos += stepSize){
				x1 = splineX.interpolate(i, pos);
				y1 = splineY.interpolate(i, pos);
				updateWatermarks((int)x1, (int)y1);
				// TODO: create a "real" spline made of perfect curves instead of a polyline
				g.drawLine((int)x0, (int)y0, (int)x1, (int)y1);
				if(debug) drawCross(g, 2, (int)x1, (int)y1);
				x0 = x1; y0 = y1;
				ii++;
			}
			if(pos > 1){ // to get the last piece if step Size does not fit
				x1 = splineX.interpolate(i, 1);
				y1 = splineY.interpolate(i, 1);
				g.drawLine((int)x0, (int)y0, (int)x1, (int)y1);
				updateWatermarks((int)x1, (int)y1);
			}
		}
		if(debug){
			this.drawBounds(g);
		}


	}

	/* watermarks are used to correctly set the bounds */
	private void updateWatermarks(int x, int y){
		if(watermark[X0] > x){
			watermark[X0] = x;
		}
		if(watermark[Y0] > y){
			watermark[Y0] = y;
		}
		if(watermark[X1] < x){
			watermark[X1] = x;
		}
		if(watermark[Y1] < y){
			watermark[Y1] = y;
		}
	}

	/* Initialize watermarks. Set them to the outermost bounds
	 * possible to start from.
	 */
	private void resetWatermarks(){
		watermark[X0] = Integer.MAX_VALUE;
		watermark[Y0] = Integer.MAX_VALUE;
		watermark[X1] = Integer.MIN_VALUE;
		watermark[Y1] = Integer.MIN_VALUE;
	}

	/* Create new Spline objects to work with on top of the
	 * bendpoint lists px and py.
	 */
	private void createSplines() {
		PointList bendpoints = this.getPoints();
		px = new double[bendpoints.size()];
		py = new double[bendpoints.size()];
		for(int i=0;i<px.length;i++){
			px[i] = bendpoints.getPoint(i).x;
			py[i] = bendpoints.getPoint(i).y;
		}
		splineX = new Spline(px);
		splineY = new Spline(py);
	}

	/**
	 * Draw a cross for debugging purposes.
	 * @param g
	 * @param size Length of the cross lines
	 * @param x
	 * @param y
	 */
	static private void drawCross(Graphics g, int size, int x, int y){
		int offset = size /2;
		Color oldColor = g.getForegroundColor();
		g.setForegroundColor(ColorConstants.green);
		g.drawLine(x-offset, y-offset , x+offset , y+offset);
		g.drawLine(x-offset, y+offset , x+offset , y-offset);
		g.setForegroundColor(oldColor);
	}

	/**
	 * Draw the bounds of this figure for debugging purposes.
	 * @param g
	 */
	private void drawBounds(Graphics g){
		Color cOld= g.getForegroundColor();
		g.setForegroundColor(ColorConstants.cyan);
		Rectangle b1 = super.getBounds();
		g.drawRectangle(b1.x, b1.y, b1.width-1, b1.height-1);
		System.out.println("super.getBounds():"+b1);
		g.setForegroundColor(ColorConstants.lightBlue);
		Rectangle b2 = this.getBounds();
		g.drawRectangle(b2.x+1, b2.y+1, b2.width-4, b2.height-4);
		System.out.println("this.getBounds():"+b2);
		g.setForegroundColor(ColorConstants.darkGreen);
		g.drawRectangle(watermark[X0]+1, watermark[Y0]+1, (watermark[X1]-watermark[X0])-2,(watermark[Y1]-watermark[Y0])-2);
		System.out.println("watermarks:"+watermark[X0] + " " + watermark[Y0] + " " + watermark[X1] + " " + watermark[Y1]);
		g.setForegroundColor(cOld);
	}

	/**
	 * Calculate the bounds of this connection. PolylineConnection bounds are calulated only from
	 * the bendpoints, which might result in bounds too small, because a Spline curve can
	 * bend beyond the outermost bendpoints.
	 */
	@Override
	public Rectangle getBounds(){
		super.getBounds(); // calc polyline Bounds
		if(watermark != null){
			int splineWidth = watermark[X1] - watermark[X0];
			int splineHeight = watermark[Y1] - watermark[Y0];
			int offset = 1 + (this.lineWidth / 2);
			Rectangle splineBounds = new Rectangle(	watermark[X0]-offset,
					watermark[Y0]-offset,
					(watermark[X1]-watermark[X0])+ 3*offset,
					(watermark[Y1]-watermark[Y0])+ 3*offset);
			this.bounds.union(splineBounds);
		}
		return bounds;
	}

	/**
	 * Internal class representing a cubic spline function. As this is only
	 * one dimensional, you need multiple Spline objects to calculate
	 * multiple dimension positions.
	 * @author haf
	 *
	 */
	private class Spline {
		private double y[];
		private double y2[];

		/**
		 * The constructor calculates the second derivatives of the interpolating function
		 * at the tabulated points xi, with xi = (i, y[i]).
		 * @param y Array of y coordinates for cubic-spline interpolation.
		 */
		public Spline(double y[]) {
			this.y = y;
			int n = y.length;
			y2 = new double[n];
			double u[] = new double[n];
			for (int i = 1; i < n - 1; i++) {
				y2[i] = -1.0 / (4.0 + y2[i - 1]);
				u[i] = (6.0 * (y[i + 1] - 2.0 * y[i] + y[i - 1]) - u[i - 1]) / (4.0 + y2[i - 1]);
			}
			for (int i = n - 2; i >= 0; i--) {
				y2[i] = y2[i] * y2[i + 1] + u[i];
			}
		}

		/**
		 * Returns a cubic-spline interpolated value y for the point between
		 * point (n, y[n]) and (n+1, y[n+1), with t ranging from 0 for (n, y[n])
		 * to 1 for (n+1, y[n+1]).
		 * @param n The start point.
		 * @param t The distance to the next point (0..1).
		 * @return A cubic-spline interpolated value.
		 */
		public double interpolate(int n, double t) {
			return t * y[n + 1] - ((t - 1.0) * t * ((t - 2.0) * y2[n] - (t + 1.0) * y2[n + 1])) / 6.0 + y[n] - t * y[n];
		}
	}


}
