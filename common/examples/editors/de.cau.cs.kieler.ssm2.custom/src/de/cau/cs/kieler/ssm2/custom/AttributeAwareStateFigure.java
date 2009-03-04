package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.gef.EditPart;

import ssm2.Ssm2Package;
import ssm2.StateFlag;

import java.util.LinkedList;
import java.util.List;

public class AttributeAwareStateFigure extends AttributeAwareFigure {
		
	public AttributeAwareStateFigure(EditPart e) {
		super();
		this.setModelElementAndRegisterFromEditPart(e);
		
		Figure normalFigure = new RoundedRectangle();
		normalFigure.setSize(32, 32);
		Figure circleFigure = new Ellipse();
		circleFigure.setSize(32, 32);
		
		this.setDefaultFigure(normalFigure);
		this.setCurrentFigure(normalFigure);
		
		Condition FlagInit = new Condition(Ssm2Package.eINSTANCE.getState_StateFlag(), StateFlag.INITIAL);
		Condition KindNormal = new Condition(Ssm2Package.eINSTANCE.getState_StateKind(), StateFlag.NORMAL);
		List<Condition> conds = new LinkedList<Condition>();
		conds.add(FlagInit);
		conds.add(KindNormal);
		ConditionalFigure circleCF = new ConditionalFigure(conds, circleFigure);
		conditionalFigureList = new LinkedList<ConditionalFigure>();
		conditionalFigureList.add(circleCF);
	}
	
}
