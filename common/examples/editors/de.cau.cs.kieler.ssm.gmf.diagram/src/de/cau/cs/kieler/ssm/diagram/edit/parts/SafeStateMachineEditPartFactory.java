package de.cau.cs.kieler.ssm.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import de.cau.cs.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry;


/**
 * @generated
 */
public class SafeStateMachineEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (SafeStateMachineVisualIDRegistry.getVisualID(view)) {

			case SafeStateMachineEditPart.VISUAL_ID:
				return new SafeStateMachineEditPart(view);

			case CompositeStateEditPart.VISUAL_ID:
				return new CompositeStateEditPart(view);

			case CompositeStateNameEditPart.VISUAL_ID:
				return new CompositeStateNameEditPart(view);

			case RegionEditPart.VISUAL_ID:
				return new RegionEditPart(view);

			case CompositeState2EditPart.VISUAL_ID:
				return new CompositeState2EditPart(view);

			case CompositeStateName2EditPart.VISUAL_ID:
				return new CompositeStateName2EditPart(view);

			case SimpleStateEditPart.VISUAL_ID:
				return new SimpleStateEditPart(view);

			case SimpleStateNameEditPart.VISUAL_ID:
				return new SimpleStateNameEditPart(view);

			case InitialStateEditPart.VISUAL_ID:
				return new InitialStateEditPart(view);

			case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
				return new CompositeStateCompositeStateCompartmentEditPart(view);

			case RegionRegionCompartmentEditPart.VISUAL_ID:
				return new RegionRegionCompartmentEditPart(view);

			case CompositeStateCompositeStateCompartment2EditPart.VISUAL_ID:
				return new CompositeStateCompositeStateCompartment2EditPart(
						view);

			case StrongAbortionEditPart.VISUAL_ID:
				return new StrongAbortionEditPart(view);

			case StrongAbortionIsImmediateStringTriggeEditPart.VISUAL_ID:
				return new StrongAbortionIsImmediateStringTriggeEditPart(view);

			case StrongAbortionPriorityEditPart.VISUAL_ID:
				return new StrongAbortionPriorityEditPart(view);

			case NormalTerminationEditPart.VISUAL_ID:
				return new NormalTerminationEditPart(view);

			case NormalTerminationEffectStringEditPart.VISUAL_ID:
				return new NormalTerminationEffectStringEditPart(view);

			case NormalTerminationPriorityEditPart.VISUAL_ID:
				return new NormalTerminationPriorityEditPart(view);

			case WeakAbortionEditPart.VISUAL_ID:
				return new WeakAbortionEditPart(view);

			case WeakAbortionIsImmediateStringTriggeEditPart.VISUAL_ID:
				return new WeakAbortionIsImmediateStringTriggeEditPart(view);

			case WeakAbortionPriorityEditPart.VISUAL_ID:
				return new WeakAbortionPriorityEditPart(view);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn()
					&& getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width,
						SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont())
					.getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
					SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
