package edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcVisualIDRegistry;

/**
 * @generated
 */
public class EpcEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (EpcVisualIDRegistry.getVisualID(view)) {

			case EPCEditPart.VISUAL_ID:
				return new EPCEditPart(view);

			case ANDEditPart.VISUAL_ID:
				return new ANDEditPart(view);

			case OREditPart.VISUAL_ID:
				return new OREditPart(view);

			case InformationEditPart.VISUAL_ID:
				return new InformationEditPart(view);

			case InformationNameEditPart.VISUAL_ID:
				return new InformationNameEditPart(view);

			case XOREditPart.VISUAL_ID:
				return new XOREditPart(view);

			case EventEditPart.VISUAL_ID:
				return new EventEditPart(view);

			case EventNameEditPart.VISUAL_ID:
				return new EventNameEditPart(view);

			case EPC2EditPart.VISUAL_ID:
				return new EPC2EditPart(view);

			case EPCNameEditPart.VISUAL_ID:
				return new EPCNameEditPart(view);

			case FunctionEditPart.VISUAL_ID:
				return new FunctionEditPart(view);

			case FunctionNameEditPart.VISUAL_ID:
				return new FunctionNameEditPart(view);

			case TriggersEventEditPart.VISUAL_ID:
				return new TriggersEventEditPart(view);

			case ProvidesDataToEditPart.VISUAL_ID:
				return new ProvidesDataToEditPart(view);

			case WritesDataToEditPart.VISUAL_ID:
				return new WritesDataToEditPart(view);

			case ActivatesFunctionEditPart.VISUAL_ID:
				return new ActivatesFunctionEditPart(view);

			case EventToOperatorConnectionEditPart.VISUAL_ID:
				return new EventToOperatorConnectionEditPart(view);

			case FunctionToOperatorConnectionEditPart.VISUAL_ID:
				return new FunctionToOperatorConnectionEditPart(view);

			case OperatorToEventConnectionEditPart.VISUAL_ID:
				return new OperatorToEventConnectionEditPart(view);

			case OperatorToFunctionConnectionEditPart.VISUAL_ID:
				return new OperatorToFunctionConnectionEditPart(view);
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
		if (source.getFigure() instanceof WrapLabel)
			return new TextCellEditorLocator((WrapLabel) source.getFigure());
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
		private WrapLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrapLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrapLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapped()
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
