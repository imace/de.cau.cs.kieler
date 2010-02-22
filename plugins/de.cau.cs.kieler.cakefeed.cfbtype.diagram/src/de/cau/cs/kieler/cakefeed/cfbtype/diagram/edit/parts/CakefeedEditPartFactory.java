package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts;

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

import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry;

/**
 * @generated
 */
public class CakefeedEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (CakefeedVisualIDRegistry.getVisualID(view)) {

			case CFBDiagramEditPart.VISUAL_ID:
				return new CFBDiagramEditPart(view);

			case CFBTypeEditPart.VISUAL_ID:
				return new CFBTypeEditPart(view);

			case CFBTypeNameEditPart.VISUAL_ID:
				return new CFBTypeNameEditPart(view);

			case IFInputEventEditPart.VISUAL_ID:
				return new IFInputEventEditPart(view);

			case IFInputEventNameEditPart.VISUAL_ID:
				return new IFInputEventNameEditPart(view);

			case IFOutputEventEditPart.VISUAL_ID:
				return new IFOutputEventEditPart(view);

			case IFOutputEventNameEditPart.VISUAL_ID:
				return new IFOutputEventNameEditPart(view);

			case IFInputVarEditPart.VISUAL_ID:
				return new IFInputVarEditPart(view);

			case IFInputVarNameEditPart.VISUAL_ID:
				return new IFInputVarNameEditPart(view);

			case IFOutputVarEditPart.VISUAL_ID:
				return new IFOutputVarEditPart(view);

			case IFOutputVarNameEditPart.VISUAL_ID:
				return new IFOutputVarNameEditPart(view);

			case FBEditPart.VISUAL_ID:
				return new FBEditPart(view);

			case FBNameEditPart.VISUAL_ID:
				return new FBNameEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case FBInputEventEditPart.VISUAL_ID:
				return new FBInputEventEditPart(view);

			case FBInputEventNameEditPart.VISUAL_ID:
				return new FBInputEventNameEditPart(view);

			case FBOutputEventEditPart.VISUAL_ID:
				return new FBOutputEventEditPart(view);

			case FBOutputEventNameEditPart.VISUAL_ID:
				return new FBOutputEventNameEditPart(view);

			case FBInputVarEditPart.VISUAL_ID:
				return new FBInputVarEditPart(view);

			case FBInputVarNameEditPart.VISUAL_ID:
				return new FBInputVarNameEditPart(view);

			case FBOutputVarEditPart.VISUAL_ID:
				return new FBOutputVarEditPart(view);

			case FBOutputVarNameEditPart.VISUAL_ID:
				return new FBOutputVarNameEditPart(view);

			case CFBTypeCFBTypeCompartmentEditPart.VISUAL_ID:
				return new CFBTypeCFBTypeCompartmentEditPart(view);

			case InputWithEditPart.VISUAL_ID:
				return new InputWithEditPart(view);

			case OutputWithEditPart.VISUAL_ID:
				return new OutputWithEditPart(view);

			case IFIFEventConnectionEditPart.VISUAL_ID:
				return new IFIFEventConnectionEditPart(view);

			case IFFBEventConnectionEditPart.VISUAL_ID:
				return new IFFBEventConnectionEditPart(view);

			case FBIFEventConnectionEditPart.VISUAL_ID:
				return new FBIFEventConnectionEditPart(view);

			case FBFBEventConnectionEditPart.VISUAL_ID:
				return new FBFBEventConnectionEditPart(view);

			case IFIFDataConnectionEditPart.VISUAL_ID:
				return new IFIFDataConnectionEditPart(view);

			case IFFBDataConnectionEditPart.VISUAL_ID:
				return new IFFBDataConnectionEditPart(view);

			case FBIFDataConnectionEditPart.VISUAL_ID:
				return new FBIFDataConnectionEditPart(view);

			case FBFBDataConnectionEditPart.VISUAL_ID:
				return new FBFBDataConnectionEditPart(view);

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
