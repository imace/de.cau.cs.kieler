/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.layout;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.DoubleValueStyle;
import org.eclipse.gmf.runtime.notation.IntValueStyle;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;


/**
 * Utility class for storage of layout hints in the GMF notation model.
 * 
 * @author msp
 */
public class GmfLayoutHints {

	/**
	 * Returns a string value for the given edit part. The value is
	 * retrieved from the GMF notation model.
	 * 
	 * @param editPart edit part
	 * @param id identifier of the layout option
	 * @return a string value for the corresponding layout option, or
	 *     the empty string if there is no such value
	 */
	public static String getStringValue(GraphicalEditPart editPart,
	        String id) {
		NamedStyle namedStyle = (NamedStyle) (editPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), id));

		if (namedStyle instanceof StringValueStyle)
			return ((StringValueStyle)namedStyle).getStringValue();
		else return "";
	}

	/**
	 * Returns an integer value for the given edit part. The value is
     * retrieved from the GMF notation model.
	 * 
	 * @param editPart edit part
	 * @param id identifier of the layout option
	 * @return an integer value for the corresponding layout option,
	 *     or 0 if there is no such value
	 */
	public static int getIntValue(GraphicalEditPart editPart,
	        String id) {
        NamedStyle namedStyle = (NamedStyle) (editPart
                .getNotationView().getNamedStyle(NotationPackage.eINSTANCE
                .getStringValueStyle(), id));

        if (namedStyle instanceof IntValueStyle)
            return ((IntValueStyle)namedStyle).getIntValue();
        else return 0;
	}
	
	/**
	 * Returns a double value for the given edit part. The value is
     * retrieved from the GMF notation model.
	 * 
	 * @param editPart edit part
	 * @param id identifier of the layout option
	 * @return a double value for the corresponding layout option,
	 *     or 0.0 if there is no such value
	 */
	public static double getDoubleValue(GraphicalEditPart editPart,
            String id) {
        NamedStyle namedStyle = (NamedStyle) (editPart
                .getNotationView().getNamedStyle(NotationPackage.eINSTANCE
                .getStringValueStyle(), id));

        if (namedStyle instanceof DoubleValueStyle)
            return ((DoubleValueStyle)namedStyle).getDoubleValue();
        else return 0.0;
    }

	/**
	 * Stores a string value for the given edit part. The value is
     * put into the GMF notation model.
	 * 
	 * @param editPart edit part
	 * @param id identifier of the layout option
	 * @param value the new value
	 */
	public static void setValue(final GraphicalEditPart editPart,
	        final String id, final String value) {
		final NamedStyle namedStyle = (NamedStyle) (editPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), id));

		if (namedStyle instanceof StringValueStyle) {
		    // store the new value in the existing named style
			editPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(editPart.getEditingDomain()) {
						protected void doExecute() {
							((StringValueStyle) (editPart.getNotationView()
							        .getNamedStyle(NotationPackage.eINSTANCE
							        .getStringValueStyle(), id)))
									.setStringValue(value);
						}
					});
		}
		else {
	        // create a new named style and store it into the notation view
            final StringValueStyle newStyle = NotationFactory.eINSTANCE
                    .createStringValueStyle();
            newStyle.setName(id);
            newStyle.setStringValue(value);
            editPart.getEditingDomain().getCommandStack().execute(
                    new RecordingCommand(editPart.getEditingDomain()) {
                        @SuppressWarnings("unchecked")
                        protected void doExecute() {
                            editPart.getNotationView().getStyles()
                                    .add(newStyle);
                        }
                    });
		}
	}

	/**
	 * Stores an integer value for the given edit part. The value is
     * put into the GMF notation model.
	 * 
	 * @param editPart edit part
	 * @param id identifier of the layout option
	 * @param value the new value
	 */
	public static void setValue(final GraphicalEditPart editPart,
            final String id, final int value) {
        final NamedStyle namedStyle = (NamedStyle) (editPart
                .getNotationView().getNamedStyle(NotationPackage.eINSTANCE
                .getStringValueStyle(), id));

        if (namedStyle instanceof IntValueStyle) {
            // store the new value in the existing named style
            editPart.getEditingDomain().getCommandStack().execute(
                    new RecordingCommand(editPart.getEditingDomain()) {
                        protected void doExecute() {
                            ((IntValueStyle) (editPart
                                    .getNotationView().getNamedStyle(
                                    NotationPackage.eINSTANCE
                                            .getStringValueStyle(), id)))
                                    .setIntValue(value);
                        }
                    });
        } else {
            // create a new named style and store it into the notation view
            final IntValueStyle newStyle = NotationFactory.eINSTANCE
                    .createIntValueStyle();
            newStyle.setName(id);
            newStyle.setIntValue(value);
            editPart.getEditingDomain().getCommandStack().execute(
                    new RecordingCommand(editPart.getEditingDomain()) {
                        @SuppressWarnings("unchecked")
                        protected void doExecute() {
                            editPart.getNotationView().getStyles()
                                    .add(newStyle);
                        }
                    });
        }
    }

    /**
     * Stores a double value for the given edit part. The value is
     * put into the GMF notation model.
     * 
     * @param editPart edit part
     * @param id identifier for the layout option
     * @param value the new value
     */
    public static void setValue(final GraphicalEditPart editPart,
            final String id, final double value) {
        final NamedStyle namedStyle = (NamedStyle) (editPart
                .getNotationView().getNamedStyle(NotationPackage.eINSTANCE
                .getStringValueStyle(), id));

        if (namedStyle instanceof DoubleValueStyle) {
            // store the new value in the existing named style
            editPart.getEditingDomain().getCommandStack().execute(
                    new RecordingCommand(editPart.getEditingDomain()) {
                        protected void doExecute() {
                            ((DoubleValueStyle) (editPart
                                    .getNotationView().getNamedStyle(
                                    NotationPackage.eINSTANCE
                                            .getStringValueStyle(), id)))
                                    .setDoubleValue(value);
                        }
                    });
        } else {
            // create a new named style and store it into the notation view
            final DoubleValueStyle newStyle = NotationFactory.eINSTANCE
                    .createDoubleValueStyle();
            newStyle.setName(id);
            newStyle.setDoubleValue(value);
            editPart.getEditingDomain().getCommandStack().execute(
                    new RecordingCommand(editPart.getEditingDomain()) {
                        @SuppressWarnings("unchecked")
                        protected void doExecute() {
                            editPart.getNotationView().getStyles()
                                    .add(newStyle);
                        }
                    });
        }
    }

}
