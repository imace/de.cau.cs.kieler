/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
package de.cau.cs.kieler.synccharts.diagram.custom.handlers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import de.cau.cs.kieler.synccharts.diagram.edit.parts.State2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateOnEntryAction2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateOnEntryActionEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateOnExitAction2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateOnExitActionEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateOnInsideAction2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateOnInsideActionEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateRegionCompartment2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateRegionCompartmentEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateSignal2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateSignalEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateSuspend2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateSuspendEditPart;
import de.cau.cs.kieler.synccharts.diagram.providers.SyncchartsElementTypes;

/**
 * Handler that adds an element to a specific compartment.
 * 
 * @author msp
 */
public class AddToStateHandler extends AbstractHandler implements IHandler {

    /** parameter for type of element to add. */
    public static final String TYPE_PARAM = "de.cau.cs.kieler.synccharts.custom.parameters.type";

    private static final String VAL_ENTRY_ACTION = "OnEntryAction";
    private static final String VAL_EXIT_ACTION = "OnExitAction";
    private static final String VAL_INSIDE_ACTION = "OnInsideAction";
    private static final String VAL_REGION = "Region";
    private static final String VAL_SIGNAL = "Signal";
    private static final String VAL_VARIABLE = "Variable";
    private static final String VAL_SUSPENSION_TRIGGER = "SuspensionTrigger";

    /** last compartment to which an element was added. */
    private ShapeCompartmentEditPart lastEditCompartment;
    /** view adapter for the last edited compartment. */
    private IAdaptable elementViewAdapter;

    /**
     * 
     * {@inheritDoc}
     */
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        lastEditCompartment = null;
        IStructuredSelection selection = (IStructuredSelection) HandlerUtil
                .getActiveMenuSelection(event);
        if (selection == null) {
            selection = (IStructuredSelection) HandlerUtil
                    .getCurrentSelection(event);
        }
        String type = event.getParameter(TYPE_PARAM);
        if (selection != null && type != null) {

            // add an element to each selected node
            Iterator<?> selectionIter = selection.iterator();
            while (selectionIter.hasNext()) {
                Object nextObj = selectionIter.next();
                if (nextObj instanceof StateEditPart
                        || nextObj instanceof State2EditPart) {
                    addElement((ShapeNodeEditPart) nextObj, type);
                } else if (nextObj instanceof ShapeCompartmentEditPart
                        || nextObj instanceof ITextAwareEditPart) {
                    EditPart parent = ((EditPart) nextObj).getParent();
                    if (parent instanceof StateEditPart
                            || parent instanceof State2EditPart) {
                        addElement((ShapeNodeEditPart) parent, type);
                    }
                }
            }

            // set the last selected node into edit mode
            if (lastEditCompartment != null) {
                final EditPartViewer viewer = lastEditCompartment.getViewer();
                final EditPart elementPart = (EditPart) viewer
                        .getEditPartRegistry().get(
                                elementViewAdapter.getAdapter(View.class));
                if (elementPart != null) {
                    Display.getCurrent().asyncExec(new Runnable() {
                        public void run() {
                            viewer.setSelection(new StructuredSelection(
                                    elementPart));
                            Request der = new Request(
                                    RequestConstants.REQ_DIRECT_EDIT);
                            elementPart.performRequest(der);
                        }
                    });
                }
            }
        }
        return null;
    }

    /**
     * Adds an element of given type to the state edit part.
     * 
     * @param stateEditPart
     *            state edit part
     * @param type
     *            type of element to add
     */
    private void addElement(final ShapeNodeEditPart stateEditPart,
            final String type) {
        Class<?> class1 = null, class2 = null;
        IElementType elementType = null;
        if (type.equals(VAL_ENTRY_ACTION)) {
            class1 = StateOnEntryActionEditPart.class;
            class2 = StateOnEntryAction2EditPart.class;
            elementType = SyncchartsElementTypes.Action_3004;
        } else if (type.equals(VAL_EXIT_ACTION)) {
            class1 = StateOnExitActionEditPart.class;
            class2 = StateOnExitAction2EditPart.class;
            elementType = SyncchartsElementTypes.Action_3006;
        } else if (type.equals(VAL_INSIDE_ACTION)) {
            class1 = StateOnInsideActionEditPart.class;
            class2 = StateOnInsideAction2EditPart.class;
            elementType = SyncchartsElementTypes.Action_3005;
        } else if (type.equals(VAL_REGION)) {
            class1 = StateRegionCompartmentEditPart.class;
            class2 = StateRegionCompartment2EditPart.class;
            elementType = SyncchartsElementTypes.Region_3001;
        } else if (type.equals(VAL_SIGNAL)) {
            class1 = StateSignalEditPart.class;
            class2 = StateSignal2EditPart.class;
            elementType = SyncchartsElementTypes.Signal_3003;
        }
        // else if (type.equals(VAL_VARIABLE)) {
        // class1 = StateVariableCompartmentEditPart.class;
        // class2 = StateVariableCompartment2EditPart.class;
        // elementType = SyncchartsElementTypes.Variable_3007;
        // }
        else if (type.equals(VAL_SUSPENSION_TRIGGER)) {
            class1 = StateSuspendEditPart.class;
            class2 = StateSuspend2EditPart.class;
            elementType = SyncchartsElementTypes.Action_3008;
        } else {
            return;
        }

        // find compartment of given type
        ShapeCompartmentEditPart compartment = null;
        Iterator<?> compartmentIter = stateEditPart.getResizableCompartments()
                .iterator();
        while (compartmentIter.hasNext()) {
            EditPart editPart = (EditPart) compartmentIter.next();
            if (editPart.getClass().equals(class1)
                    || editPart.getClass().equals(class2)) {
                compartment = (ShapeCompartmentEditPart) editPart;
                break;
            }
        }

        if (compartment != null) {
            // create element in the chosen compartment
            CreateViewRequest createRequest = CreateViewRequestFactory
                    .getCreateShapeRequest(elementType, stateEditPart
                            .getDiagramPreferencesHint());
            Command createCmd = compartment.getCommand(createRequest);
            elementViewAdapter = (IAdaptable) ((List<?>) createRequest
                    .getNewObject()).get(0);
            compartment.getDiagramEditDomain().getDiagramCommandStack()
                    .execute(createCmd);
            lastEditCompartment = compartment;
        }
    }

}
