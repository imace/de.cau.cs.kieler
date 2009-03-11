package de.cau.cs.kieler.ssm2.custom;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.EditPart;

import de.cau.cs.kieler.ssm2.Ssm2Package;

public class AttributeAwareSignalFigure extends AttributeAwareFigure {
	
	//Bei Gelegenheit durch Einsatz von Array optimieren
	public AttributeAwareSignalFigure(EditPart e) {
		super();
		this.setModelElementAndRegisterFromEditPart(e);
		
		SignalFigure NNNF = new SignalFigure(false, false, false);
		SignalFigure INNF = new SignalFigure(true, false, false);
		SignalFigure NONF = new SignalFigure(false, true, false);
		SignalFigure NNLF = new SignalFigure(false, false, true);
		SignalFigure IONF = new SignalFigure(true, true, false);
		SignalFigure INLF = new SignalFigure(true, false, true);
		SignalFigure NOLF = new SignalFigure(false, true, true);
		SignalFigure IOLF = new SignalFigure(true, true, true);
					
		this.setDefaultFigure(NNNF);
		this.setCurrentFigure(NNNF);
		
		Condition isInput = new Condition(Ssm2Package.eINSTANCE.getSignal_IsInput(), true);
		Condition isOutput = new Condition(Ssm2Package.eINSTANCE.getSignal_IsOutput(), true);
		Condition isLocal = new Condition(Ssm2Package.eINSTANCE.getSignal_IsLocal(), true);
		Condition isNotInput = new Condition(Ssm2Package.eINSTANCE.getSignal_IsInput(), false);
		Condition isNotOutput = new Condition(Ssm2Package.eINSTANCE.getSignal_IsOutput(), false);
		Condition isNotLocal = new Condition(Ssm2Package.eINSTANCE.getSignal_IsLocal(), false);
		
		List<Condition> NNN = new LinkedList<Condition>();
		NNN.add(isNotInput);
		NNN.add(isNotOutput);
		NNN.add(isNotLocal);
		
		List<Condition> INN = new LinkedList<Condition>();
		INN.add(isInput);
		INN.add(isNotOutput);
		INN.add(isNotLocal);
		
		List<Condition> NON = new LinkedList<Condition>();
		NON.add(isNotInput);
		NON.add(isOutput);
		NON.add(isNotLocal);
		
		List<Condition> NNL = new LinkedList<Condition>();
		NNL.add(isNotInput);
		NNL.add(isNotOutput);
		NNL.add(isLocal);
		
		List<Condition> ION = new LinkedList<Condition>();
		ION.add(isInput);
		ION.add(isOutput);
		ION.add(isNotLocal);
		
		List<Condition> INL = new LinkedList<Condition>();
		INL.add(isInput);
		INL.add(isNotOutput);
		INL.add(isLocal);
		
		List<Condition> NOL = new LinkedList<Condition>();
		NOL.add(isNotInput);
		NOL.add(isOutput);
		NOL.add(isLocal);
		
		List<Condition> IOL = new LinkedList<Condition>();
		IOL.add(isInput);
		IOL.add(isOutput);
		IOL.add(isLocal);
		
		ConditionalFigure NNNCF = new ConditionalFigure(NNN, NNNF);
		ConditionalFigure INNCF = new ConditionalFigure(INN, INNF);
		ConditionalFigure NONCF = new ConditionalFigure(NON, NONF);
		ConditionalFigure NNLCF = new ConditionalFigure(NNL, NNLF);
		ConditionalFigure IONCF = new ConditionalFigure(ION, IONF);
		ConditionalFigure INLCF = new ConditionalFigure(INL, INLF);
		ConditionalFigure NOLCF = new ConditionalFigure(NOL, NOLF);
		ConditionalFigure IOLCF = new ConditionalFigure(IOL, IOLF);
		
		conditionalFigureList = new LinkedList<ConditionalFigure>();
		conditionalFigureList.add(NNNCF);
		conditionalFigureList.add(INNCF);
		conditionalFigureList.add(NONCF);
		conditionalFigureList.add(NNLCF);
		conditionalFigureList.add(IONCF);
		conditionalFigureList.add(INLCF);
		conditionalFigureList.add(NOLCF);
		conditionalFigureList.add(IOLCF);
	}
}
