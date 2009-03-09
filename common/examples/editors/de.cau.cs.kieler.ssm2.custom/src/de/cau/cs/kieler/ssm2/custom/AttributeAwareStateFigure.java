package de.cau.cs.kieler.ssm2.custom;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.gef.EditPart;

import ssm2.Ssm2Package;
import ssm2.StateFlag;
import ssm2.StateKind;

public class AttributeAwareStateFigure extends AttributeAwareFigure {
	
	//Bei Gelegenheit durch Einsatz von Array optimieren
	public AttributeAwareStateFigure(EditPart e) {
		super();
		this.setModelElementAndRegisterFromEditPart(e);
		layout = new StateLayout();
		
		RoundedRectangle normalStateFigure = new RoundedRectangle();
		normalStateFigure.setFill(false);
		normalStateFigure.setLineWidth(2);
		normalStateFigure.setForegroundColor(ColorConstants.black);
		
		Ellipse normalNChildrenStateFigure = new Ellipse();
		normalNChildrenStateFigure.setFill(false);
		normalNChildrenStateFigure.setLineWidth(2);
		normalNChildrenStateFigure.setForegroundColor(ColorConstants.black);
		
		RoundedRectangle initialStateFigure = new RoundedRectangle();
		initialStateFigure.setFill(false);
		initialStateFigure.setLineWidth(6);
		initialStateFigure.setForegroundColor(ColorConstants.black);
		
		Ellipse initialNChildrenStateFigure = new Ellipse();
		initialNChildrenStateFigure.setFill(false);
		initialNChildrenStateFigure.setLineWidth(6);
		initialNChildrenStateFigure.setForegroundColor(ColorConstants.black);
		
		RoundedRectangle finalStateFigure = new DoubleRoundedRectangle();
		finalStateFigure.setFill(false);
		finalStateFigure.setLineWidth(2);
		finalStateFigure.setForegroundColor(ColorConstants.black);
		
		Ellipse finalNChildrenStateFigure = new DoubleEllipse();
		finalNChildrenStateFigure.setFill(false);
		finalNChildrenStateFigure.setLineWidth(2);
		finalNChildrenStateFigure.setForegroundColor(ColorConstants.black);
		
		PseudoStateFigure pseudoStateFigure = new PseudoStateFigure();
		pseudoStateFigure.setFill(true);
		pseudoStateFigure.setLineWidth(2);
		pseudoStateFigure.setForegroundColor(ColorConstants.black);
		pseudoStateFigure.setBackgroundColor(ColorConstants.lightGray);
					
		this.setDefaultFigure(normalStateFigure);
		this.setCurrentFigure(normalNChildrenStateFigure);
		
		Condition kindNormal = new Condition(Ssm2Package.eINSTANCE.getState_StateKind(), StateKind.NORMAL);
		Condition kindPseudo = new Condition(Ssm2Package.eINSTANCE.getState_StateKind(), StateKind.PSEUDO);
		Condition kindReference = new Condition(Ssm2Package.eINSTANCE.getState_StateKind(), StateKind.REFERENCE);
		Condition kindTextual = new Condition(Ssm2Package.eINSTANCE.getState_StateKind(), StateKind.TEXTUAL);
		
		Condition flagNormal = new Condition(Ssm2Package.eINSTANCE.getState_StateFlag(), StateFlag.NORMAL);
		Condition flagInitial = new Condition(Ssm2Package.eINSTANCE.getState_StateFlag(), StateFlag.INITIAL);
		Condition flagFinal = new Condition(Ssm2Package.eINSTANCE.getState_StateFlag(), StateFlag.FINAL);
		
		Condition noChildren = new SizeCondition(Ssm2Package.eINSTANCE.getState_InnerStates(), new Integer(0));
		
		List<Condition> normalNCSF = new LinkedList<Condition>();
		normalNCSF.add(kindNormal);
		normalNCSF.add(flagNormal);
		normalNCSF.add(noChildren);
		
		List<Condition> initialNCSF = new LinkedList<Condition>();
		initialNCSF.add(kindNormal);
		initialNCSF.add(flagInitial);
		initialNCSF.add(noChildren);
		
		List<Condition> finalNCSF = new LinkedList<Condition>();
		finalNCSF.add(kindNormal);
		finalNCSF.add(flagFinal);
		finalNCSF.add(noChildren);
		
		List<Condition> initialSF = new LinkedList<Condition>();
		initialSF.add(flagInitial);
		
		List<Condition> finalSF = new LinkedList<Condition>();
		finalSF.add(flagFinal);
		
		List<Condition> pseudoSF = new LinkedList<Condition>();
		pseudoSF.add(kindPseudo);
		
		
		ConditionalFigure normalNCCF = new ConditionalFigure(normalNCSF, normalNChildrenStateFigure);
		ConditionalFigure initialNCCF = new ConditionalFigure(initialNCSF, initialNChildrenStateFigure);
		ConditionalFigure finalNCCF = new ConditionalFigure(finalNCSF, finalNChildrenStateFigure);
		ConditionalFigure initialCF = new ConditionalFigure(initialSF, initialStateFigure);
		ConditionalFigure finalCF = new ConditionalFigure(finalSF, finalStateFigure);
		ConditionalFigure pseudoCF = new ConditionalFigure(pseudoSF, pseudoStateFigure);
		
		conditionalFigureList = new LinkedList<ConditionalFigure>();
		conditionalFigureList.add(pseudoCF);
		conditionalFigureList.add(initialNCCF);
		conditionalFigureList.add(initialCF);
		conditionalFigureList.add(finalNCCF);
		conditionalFigureList.add(finalCF);
		conditionalFigureList.add(normalNCCF);
	}
}
