package de.cau.cs.kieler.synccharts.custom;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

import de.cau.cs.kieler.synccharts.SyncchartsPackage;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.StateFlag;
import de.cau.cs.kieler.synccharts.StateKind;

public class AttributeAwareStateFigure extends AttributeAwareFigure {
	
	boolean containsRegions;
	boolean containsSignals;
	boolean containsVariables;
	boolean containsEntryActions;
	boolean containsInnerActions;
	boolean containsExitActions;
	boolean containsSuspensionTrigger;
	
	// This is the figure for states
	public AttributeAwareStateFigure(EditPart e) {
		super();
		
		// Register edit part
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
		Condition kindNormal = new Condition(SyncchartsPackage.eINSTANCE.getState_StateKind(), StateKind.NORMAL);
		Condition kindPseudo = new Condition(SyncchartsPackage.eINSTANCE.getState_StateKind(), StateKind.PSEUDO);
		Condition kindReference = new Condition(SyncchartsPackage.eINSTANCE.getState_StateKind(), StateKind.REFERENCE);
		Condition kindTextual = new Condition(SyncchartsPackage.eINSTANCE.getState_StateKind(), StateKind.TEXTUAL);
		
		Condition flagNormal = new Condition(SyncchartsPackage.eINSTANCE.getState_StateFlag(), StateFlag.NORMAL);
		Condition flagInitial = new Condition(SyncchartsPackage.eINSTANCE.getState_StateFlag(), StateFlag.INITIAL);
		Condition flagFinal = new Condition(SyncchartsPackage.eINSTANCE.getState_StateFlag(), StateFlag.FINAL);
		
		Condition noChildren = new SizeCondition(SyncchartsPackage.eINSTANCE.getState_Regions(), new Integer(0));
		Condition noSignals = new SizeCondition(SyncchartsPackage.eINSTANCE.getState_Signals(), new Integer(0));
		Condition noEntryActions = new SizeCondition(SyncchartsPackage.eINSTANCE.getState_EntryActions(), new Integer(0));
		Condition noInnerActions = new SizeCondition(SyncchartsPackage.eINSTANCE.getState_InnerActions(), new Integer(0));
		Condition noExitActions = new SizeCondition(SyncchartsPackage.eINSTANCE.getState_ExitActions(), new Integer(0));
		
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
	
	// The minimum size of a simple state is 40x40 pixels
	// The minimum height of complex states is the sum of 
	// all its children's minimum heights, while its minimum
	// width is the maximum of all its children's minimum sizes;
	// however, empty compartments are not considered.
	@Override
	public Dimension getMinimumSize(int hint, int hint2) {
		if (modelElement instanceof State) {
			State state = (State) modelElement;
			
			int prefWidth = super.getMinimumSize(hint, hint2).width;
			int prefHeight = 0;
			
			List<Object> children = getChildren();
			int numChildren = children.size();
			
			if (isSimple(state)) {
				if (children.get(0) instanceof WrappingLabel) {
					return new Dimension(((WrappingLabel) children.get(0)).getPreferredSize(hint, hint2).width, 40);
				}
				else {
					return new Dimension(super.getMinimumSize(hint, hint2).width, 40);
				}
			} else {
				
				// Lookup, which compartments contain contents
				retrieveContents(state);
				
				for (int i = 0; i < numChildren; i++) {
					Object child = children.get(i);
					if (child instanceof IFigure) {
						IFigure childFigure = (IFigure) child;
						prefHeight += childFigure.getPreferredSize().height;
						if (child instanceof ShapeCompartmentFigure) {
							// Empty compartments are not considered 
							if ((getName((ShapeCompartmentFigure) child).equals("Signal:") && (!containsSignals))
									|| (getName((ShapeCompartmentFigure) child).equals("Variable:") && (!containsVariables))
									|| (getName((ShapeCompartmentFigure) child).equals("OnEntryActions:") && (!containsEntryActions))
									|| (getName((ShapeCompartmentFigure) child).equals("OnInsideActions:") && (!containsInnerActions))
									|| (getName((ShapeCompartmentFigure) child).equals("OnExitActions:") && (!containsExitActions))
									|| (getName((ShapeCompartmentFigure) child).equals("Suspend:") && (!containsSuspensionTrigger))
									|| (getName((ShapeCompartmentFigure) child).equals("RegionCompartment") && (!containsRegions))) {
								prefHeight -= childFigure.getPreferredSize().height;
							}
						}
					}
				}
				return new Dimension(prefWidth, prefHeight);
			}
		}
		return super.getMinimumSize(hint, hint2);
	}
	
	// The preferred size is the same as the minimum size
	@Override
	public Dimension getPreferredSize(int hint, int hint2) {
		return getMinimumSize(hint, hint2);
	}
	
	// Method to retrieve a compartment's name
	private String getName(ShapeCompartmentFigure child) {
		if ((child.getChildren() != null) && (child.getChildren().size() > 0)
				&& (child.getChildren().get(0) instanceof IFigure)) {
			IFigure rcf = (IFigure) child.getChildren().get(0);
			if ((rcf.getChildren() != null) && (rcf.getChildren().size() > 0)
					&& (rcf.getChildren().get(0) instanceof WrappingLabel)) {
				WrappingLabel label = (WrappingLabel) rcf.getChildren().get(0);
				return label.getText();
			}
		}
		return "";
	}
	
	// Method to lookup which compartments have contents
	private void retrieveContents(State state) {
		containsRegions = false;
		containsSignals = false;
		containsVariables = false;
		containsEntryActions = false;
		containsInnerActions = false;
		containsExitActions = false;
		containsSuspensionTrigger = false;
		
		if ((state.getRegions() != null && state.getRegions().size() > 0)) {
			containsRegions = true;
		}
		if ((state.getSignals() != null && state.getSignals().size() > 0)) {
			containsSignals = true;
		}
		if ((state.getEntryActions() != null && state.getEntryActions().size() > 0)) {
			containsEntryActions = true;
		}
		if ((state.getInnerActions() != null && state.getInnerActions().size() > 0)) {
			containsInnerActions = true;
		}
		if ((state.getExitActions() != null && state.getExitActions().size() > 0)) {
			containsExitActions = true;
		}
		if ((state.getVariables() != null && state.getVariables().size() > 0)) {
			containsVariables = true;
		}
		if (state.getSuspensionTrigger() != null) {
			containsSuspensionTrigger = true;
		}
	}
	
	// Method to decide whether a state is simple
	private boolean isSimple(State state) {
		if ((state.getRegions() == null || state.getRegions().size() == 0)
				&& (state.getSignals() == null || state.getSignals().size() == 0)
				&& (state.getEntryActions() == null || state.getEntryActions().size() == 0)
				&& (state.getInnerActions() == null || state.getInnerActions().size() == 0)
				&& (state.getExitActions() == null || state.getExitActions().size() == 0)) {
		return true;	
		}
		return false;
	}
	
}
