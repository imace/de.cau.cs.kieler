package de.cau.cs.kieler.ssm2.custom;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.gef.EditPart;

import de.cau.cs.kieler.ssm2.Ssm2Package;
import de.cau.cs.kieler.ssm2.StateFlag;
import de.cau.cs.kieler.ssm2.StateKind;

public class AttributeAwareStateFigure extends AttributeAwareFigure {
	
	// This is the figure figure for states
	public AttributeAwareStateFigure(EditPart e) {
		super();
		this.setModelElementAndRegisterFromEditPart(e);
		layout = new StateLayout();
		
		// Create all needed figures
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
		
		// Set default and current figure
		this.setDefaultFigure(normalStateFigure);
		this.setCurrentFigure(normalNChildrenStateFigure);
		
		// Create all needed conditions
		Condition kindNormal = new Condition(Ssm2Package.eINSTANCE.getState_StateKind(), StateKind.NORMAL);
		Condition kindPseudo = new Condition(Ssm2Package.eINSTANCE.getState_StateKind(), StateKind.PSEUDO);
		Condition kindReference = new Condition(Ssm2Package.eINSTANCE.getState_StateKind(), StateKind.REFERENCE);
		Condition kindTextual = new Condition(Ssm2Package.eINSTANCE.getState_StateKind(), StateKind.TEXTUAL);
		
		Condition flagNormal = new Condition(Ssm2Package.eINSTANCE.getState_StateFlag(), StateFlag.NORMAL);
		Condition flagInitial = new Condition(Ssm2Package.eINSTANCE.getState_StateFlag(), StateFlag.INITIAL);
		Condition flagFinal = new Condition(Ssm2Package.eINSTANCE.getState_StateFlag(), StateFlag.FINAL);
		
		Condition noChildren = new SizeCondition(Ssm2Package.eINSTANCE.getState_Regions(), new Integer(0));
		Condition noSignals = new SizeCondition(Ssm2Package.eINSTANCE.getState_Signals(), new Integer(0));
		Condition noEntryActions = new SizeCondition(Ssm2Package.eINSTANCE.getState_EntryActions(), new Integer(0));
		Condition noInnerActions = new SizeCondition(Ssm2Package.eINSTANCE.getState_InnerActions(), new Integer(0));
		Condition noExitActions = new SizeCondition(Ssm2Package.eINSTANCE.getState_ExitActions(), new Integer(0));
		
		// Combine conditions in lists
		List<Condition> normalNCSF = new LinkedList<Condition>();
		normalNCSF.add(kindNormal);
		normalNCSF.add(flagNormal);
		normalNCSF.add(noChildren);
		normalNCSF.add(noSignals);
		normalNCSF.add(noEntryActions);
		normalNCSF.add(noInnerActions);
		normalNCSF.add(noExitActions);
		
		List<Condition> initialNCSF = new LinkedList<Condition>();
		initialNCSF.add(kindNormal);
		initialNCSF.add(flagInitial);
		initialNCSF.add(noChildren);
		initialNCSF.add(noSignals);
		initialNCSF.add(noEntryActions);
		initialNCSF.add(noInnerActions);
		initialNCSF.add(noExitActions);
		
		List<Condition> finalNCSF = new LinkedList<Condition>();
		finalNCSF.add(kindNormal);
		finalNCSF.add(flagFinal);
		finalNCSF.add(noChildren);
		finalNCSF.add(noSignals);
		finalNCSF.add(noEntryActions);
		finalNCSF.add(noInnerActions);
		finalNCSF.add(noExitActions);
		
		List<Condition> initialSF = new LinkedList<Condition>();
		initialSF.add(flagInitial);
		
		List<Condition> finalSF = new LinkedList<Condition>();
		finalSF.add(flagFinal);
		
		List<Condition> pseudoSF = new LinkedList<Condition>();
		pseudoSF.add(kindPseudo);
		
		// Add the figures that are to be drawn, when all the conditions
		// in the list are fulfilled
		ConditionalFigure normalNCCF = new ConditionalFigure(normalNCSF, normalNChildrenStateFigure);
		ConditionalFigure initialNCCF = new ConditionalFigure(initialNCSF, initialNChildrenStateFigure);
		ConditionalFigure finalNCCF = new ConditionalFigure(finalNCSF, finalNChildrenStateFigure);
		ConditionalFigure initialCF = new ConditionalFigure(initialSF, initialStateFigure);
		ConditionalFigure finalCF = new ConditionalFigure(finalSF, finalStateFigure);
		ConditionalFigure pseudoCF = new ConditionalFigure(pseudoSF, pseudoStateFigure);
		
		// Add all ConditionalFigures to the figure's list
		conditionalFigureList = new LinkedList<ConditionalFigure>();
		conditionalFigureList.add(pseudoCF);
		conditionalFigureList.add(initialNCCF);
		conditionalFigureList.add(initialCF);
		conditionalFigureList.add(finalNCCF);
		conditionalFigureList.add(finalCF);
		conditionalFigureList.add(normalNCCF);
		
		// check conditions
		notifyChanged(null);
	}
}
