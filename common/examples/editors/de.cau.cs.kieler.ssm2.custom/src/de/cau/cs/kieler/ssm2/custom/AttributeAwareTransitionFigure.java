package de.cau.cs.kieler.ssm2.custom;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;

import de.cau.cs.kieler.ssm2.Ssm2Package;
import de.cau.cs.kieler.ssm2.TransitionKind;

public class AttributeAwareTransitionFigure extends AttributeAwareConnection {

	// The attribute aware figure that is used for transitions
	public AttributeAwareTransitionFigure(EditPart e) {
		super();
		this.setModelElementAndRegisterFromEditPart(e);
		
		this.setForegroundColor(ColorConstants.black);
		this.setBackgroundColor(ColorConstants.black);
		this.setLineWidth(2);
		
		// Create all needed conditions
		Condition kindWeakAbort = new Condition(Ssm2Package.eINSTANCE.getTransition_TransitionKind(), TransitionKind.WEAKABORT);
		Condition kindStrongAbort = new Condition(Ssm2Package.eINSTANCE.getTransition_TransitionKind(), TransitionKind.STRONGABORT);
		Condition kindNormalTermination = new Condition(Ssm2Package.eINSTANCE.getTransition_TransitionKind(), TransitionKind.NORMALTERMINATION);
		
		// Combine them in lists
		List<Condition> weakAbortSF = new LinkedList<Condition>();
		weakAbortSF.add(kindWeakAbort);
		
		List<Condition> strongAbortSF = new LinkedList<Condition>();
		strongAbortSF.add(kindStrongAbort);
		
		List<Condition> normalTerminationSF = new LinkedList<Condition>();
		normalTerminationSF.add(kindNormalTermination);
		
		// Add the looks that are to be displayed when all the conditions in
		// the list are true
		ConditionalConnectionLook weakAbortCF = new ConditionalConnectionLook(weakAbortSF, createWeakAbortionDecoration(), createArrowDecoration());
		ConditionalConnectionLook strongAbortCF = new ConditionalConnectionLook(strongAbortSF, createStrongAbortionDecoration(), createArrowDecoration());
		ConditionalConnectionLook normalTerminationCF = new ConditionalConnectionLook(normalTerminationSF, createNormalTerminationDecoration(), createArrowDecoration());
		
		// Add all ConditionalConnectionLooks to the figure's list
		conditionalFigureList = new LinkedList<ConditionalConnectionLook>();
		conditionalFigureList.add(weakAbortCF);
		conditionalFigureList.add(strongAbortCF);
		conditionalFigureList.add(normalTerminationCF);
		
		// Set default and current look
		this.setDefaultLook(weakAbortCF);
		this.setLook(strongAbortCF);
	}
	
	// Methods to create the different decorations
	private RotatableDecoration createStrongAbortionDecoration() {
		PolygonDecoration circleDecoration = new CircleDecoration();
		circleDecoration.setLineWidth(2);
		circleDecoration.setForegroundColor(ColorConstants.black);
		circleDecoration.setBackgroundColor(ColorConstants.red);
		PointList circleDecorationPoints = new PointList();
		circleDecorationPoints.addPoint(1, 2);
		circleDecorationPoints.addPoint(-1, -2);
		circleDecoration.setTemplate(circleDecorationPoints);
		return circleDecoration;
	}
	
	private RotatableDecoration createWeakAbortionDecoration() {
		PolygonDecoration pointDecoration = new PolygonDecoration();
		pointDecoration.setForegroundColor(ColorConstants.black);
		PointList pointDecorationPoints = new PointList();
		pointDecorationPoints.addPoint(0, 0);
		pointDecoration.setTemplate(pointDecorationPoints);
		return pointDecoration;
	}
	
	private RotatableDecoration createNormalTerminationDecoration() {
		PolygonDecoration triangleDecoration = new PolygonDecoration();
		triangleDecoration.setLineWidth(2);
		triangleDecoration.setForegroundColor(ColorConstants.black);
		triangleDecoration.setBackgroundColor(ColorConstants.green);
		PointList triangleDecorationPoints = new PointList();
		triangleDecorationPoints.addPoint(0, 2);
		triangleDecorationPoints.addPoint(-2, 0);
		triangleDecorationPoints.addPoint(0, -2);
		triangleDecoration.setTemplate(triangleDecorationPoints);
		return triangleDecoration;
	}
	
	private RotatableDecoration createArrowDecoration() {
		PolylineDecoration arrowDecoration = new PolylineDecoration();
		arrowDecoration.setLineWidth(2);
		arrowDecoration.setForegroundColor(ColorConstants.black);
		PointList arrowDecorationPoints = new PointList();
		arrowDecorationPoints.addPoint(-2, 2);
		arrowDecorationPoints.addPoint(0, 0);
		arrowDecorationPoints.addPoint(-2, -2);
		arrowDecoration.setTemplate(arrowDecorationPoints);
		return arrowDecoration;
	}
}
