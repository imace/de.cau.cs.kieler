package de.cau.cs.kieler.ssm2.custom;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;

import de.cau.cs.kieler.ssm2.Ssm2Package;
import de.cau.cs.kieler.ssm2.TransitionKind;

public class AttributeAwareTransitionFigure extends AttributeAwareConnection {

	//Bei Gelegenheit durch Einsatz von Array optimieren
	public AttributeAwareTransitionFigure(EditPart e) {
		super();
		this.setModelElementAndRegisterFromEditPart(e);
		
		PolylineConnection weakAbortionFigure = new PolylineConnection();
		weakAbortionFigure.setLineWidth(2);
		weakAbortionFigure.setForegroundColor(ColorConstants.black);
		
		PolylineConnection strongAbortionFigure = new PolylineConnection();
		strongAbortionFigure.setLineWidth(2);
		strongAbortionFigure.setForegroundColor(ColorConstants.red);
		
		PolylineConnection normalTerminationFigure = new PolylineConnection();
		normalTerminationFigure.setLineWidth(2);
		normalTerminationFigure.setForegroundColor(ColorConstants.green);
		
		PolylineDecoration arrowDecoration = new PolylineDecoration();
		arrowDecoration.setLineWidth(2);
		arrowDecoration.setForegroundColor(ColorConstants.black);
		PointList arrowDecorationPoints = new PointList();
		arrowDecorationPoints.addPoint(-2, 2);
		arrowDecorationPoints.addPoint(0, 0);
		arrowDecorationPoints.addPoint(-2, -2);
		arrowDecoration.setTemplate(arrowDecorationPoints);
		strongAbortionFigure.setTargetDecoration(arrowDecoration);
		weakAbortionFigure.setTargetDecoration(arrowDecoration);
		normalTerminationFigure.setTargetDecoration(arrowDecoration);
		
		PolygonDecoration triangleDecoration = new PolygonDecoration();
		triangleDecoration.setLineWidth(2);
		triangleDecoration.setForegroundColor(ColorConstants.black);
		triangleDecoration.setBackgroundColor(ColorConstants.green);
		PointList triangleDecorationPoints = new PointList();
		triangleDecorationPoints.addPoint(0, 2);
		triangleDecorationPoints.addPoint(2, 0);
		triangleDecorationPoints.addPoint(0, -2);
		triangleDecoration.setTemplate(triangleDecorationPoints);
		normalTerminationFigure.setSourceDecoration(triangleDecoration);
		
		PolygonDecoration circleDecoration = new PolygonDecoration();
		circleDecoration.setLineWidth(2);
		circleDecoration.setForegroundColor(ColorConstants.black);
		circleDecoration.setBackgroundColor(ColorConstants.red);
		PointList circleDecorationPoints = new PointList();
		circleDecorationPoints.addPoint(0, 2);
		circleDecorationPoints.addPoint(2, 2);
		circleDecorationPoints.addPoint(2, -2);
		circleDecorationPoints.addPoint(0, -2);
		circleDecoration.setTemplate(circleDecorationPoints);
		strongAbortionFigure.setSourceDecoration(circleDecoration);
		
		this.setDefaultFigure(strongAbortionFigure);
		this.setCurrentFigure(strongAbortionFigure);
		
		Condition kindWeakAbort = new Condition(Ssm2Package.eINSTANCE.getTransition_TransitionKind(), TransitionKind.WEAKABORT);
		Condition kindStrongAbort = new Condition(Ssm2Package.eINSTANCE.getTransition_TransitionKind(), TransitionKind.STRONGABORT);
		Condition kindNormalTermination = new Condition(Ssm2Package.eINSTANCE.getTransition_TransitionKind(), TransitionKind.NORMALTERMINATION);
		
		List<Condition> weakAbortSF = new LinkedList<Condition>();
		weakAbortSF.add(kindWeakAbort);
		
		List<Condition> strongAbortSF = new LinkedList<Condition>();
		strongAbortSF.add(kindStrongAbort);
		
		List<Condition> normalTerminationSF = new LinkedList<Condition>();
		normalTerminationSF.add(kindNormalTermination);
		
		ConditionalFigure weakAbortCF = new ConditionalFigure(weakAbortSF, weakAbortionFigure);
		ConditionalFigure strongAbortCF = new ConditionalFigure(strongAbortSF, strongAbortionFigure);
		ConditionalFigure normalTerminationCF = new ConditionalFigure(normalTerminationSF, normalTerminationFigure);
		
		conditionalFigureList = new LinkedList<ConditionalFigure>();
		conditionalFigureList.add(weakAbortCF);
		conditionalFigureList.add(strongAbortCF);
		conditionalFigureList.add(normalTerminationCF);

	}
	
}
