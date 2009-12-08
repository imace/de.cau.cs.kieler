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
package de.cau.cs.kieler.cakefeed.diagram.custom.handlers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
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
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
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

import bfbtype.BFBType;
import bfbtype.diagram.edit.parts.*;
import bfbtype.diagram.edit.parts.EventInputsEditPart;
import bfbtype.diagram.edit.parts.EventInputsEventInputsCompartmentEditPart;
import bfbtype.diagram.edit.parts.InterfaceListEditPart;
import bfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart;
import bfbtype.diagram.providers.BfbtypeElementTypes;

import cfbtype.diagram.edit.parts.*;
import cfbtype.diagram.providers.CfbtypeElementTypes;

import system.EventInputs;
import system.InterfaceList;
import system.SystemFactory;

import bfbtype.diagram.providers.BfbtypeElementTypes;

/**
 * Handler that adds an element to a specific element.
 * 
 * @author schm
 */
public class AddToTypeHandler extends AbstractHandler implements IHandler {

	/** parameter for type of element to add */
    public static final String TYPE_PARAM = "de.cau.cs.kieler.cakefeed.custom.parameters.type";
    
    private static final String VAL_INPUT_EVENT = "InputEvent";
    
    /** last compartment to which an element was added */
    private GraphicalEditPart lastEditCompartment;
    /** view adapter for the last edited compartment */
    private IAdaptable elementViewAdapter;
    
    /** lists of lists of containers for certain elements */
    public static final List<Class<? extends GraphicalEditPart>> INPUT_EVENT_CONTAINERS_1 = Arrays.asList(
    		bfbtype.diagram.edit.parts.BFBTypeEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		bfbtype.diagram.edit.parts.EventInputsEditPart.class,
    		bfbtype.diagram.edit.parts.EventInputsEventInputsCompartmentEditPart.class);
    
    public static final List<Class<? extends GraphicalEditPart>> INPUT_EVENT_CONTAINERS_2 = Arrays.asList(
    		cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.EventInputsEditPart.class,
    		cfbtype.diagram.edit.parts.EventInputsEventInputsCompartmentEditPart.class);
    
    public static final List<List<Class<? extends GraphicalEditPart>>> INPUT_EVENT_CONTAINERS = Arrays.asList(
    		INPUT_EVENT_CONTAINERS_1,
    		INPUT_EVENT_CONTAINERS_2);
    
    public static final List<Class<? extends GraphicalEditPart>> OUTPUT_EVENT_CONTAINERS_1 = Arrays.asList(
    		bfbtype.diagram.edit.parts.BFBTypeEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		bfbtype.diagram.edit.parts.EventOutputsEditPart.class,
    		bfbtype.diagram.edit.parts.EventOutputsEventOutputsCompartmentEditPart.class);
    
    public static final List<Class<? extends GraphicalEditPart>> OUTPUT_EVENT_CONTAINERS_2 = Arrays.asList(
    		cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.EventOutputsEditPart.class,
    		cfbtype.diagram.edit.parts.EventOutputsEventOutputsCompartmentEditPart.class);
    
    public static final List<List<Class<? extends GraphicalEditPart>>> OUTPUT_EVENT_CONTAINERS = Arrays.asList(
    		OUTPUT_EVENT_CONTAINERS_1,
    		OUTPUT_EVENT_CONTAINERS_2);
    
    public static final List<Class<? extends GraphicalEditPart>> INPUT_VAR_DECL_CONTAINERS_1 = Arrays.asList(
    		bfbtype.diagram.edit.parts.BFBTypeEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		bfbtype.diagram.edit.parts.InputVarsEditPart.class,
    		bfbtype.diagram.edit.parts.InputVarsInputVarsCompartmentEditPart.class);
    
    public static final List<Class<? extends GraphicalEditPart>> INPUT_VAR_DECL_CONTAINERS_2 = Arrays.asList(
    		cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.InputVarsEditPart.class,
    		cfbtype.diagram.edit.parts.InputVarsInputVarsCompartmentEditPart.class);
    
    public static final List<List<Class<? extends GraphicalEditPart>>> INPUT_VAR_DECL_CONTAINERS = Arrays.asList(
    		INPUT_VAR_DECL_CONTAINERS_1,
    		INPUT_VAR_DECL_CONTAINERS_2);
    
    public static final List<Class<? extends GraphicalEditPart>> OUTPUT_VAR_DECL_CONTAINERS_1 = Arrays.asList(
    		bfbtype.diagram.edit.parts.BFBTypeEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		bfbtype.diagram.edit.parts.OutputVarsEditPart.class,
    		bfbtype.diagram.edit.parts.OutputVarsOutputVarsCompartmentEditPart.class);
    
    public static final List<Class<? extends GraphicalEditPart>> OUTPUT_VAR_DECL_CONTAINERS_2 = Arrays.asList(
    		cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.OutputVarsEditPart.class,
    		cfbtype.diagram.edit.parts.OutputVarsOutputVarsCompartmentEditPart.class);
    
    public static final List<List<Class<? extends GraphicalEditPart>>> OUTPUT_VAR_DECL_CONTAINERS = Arrays.asList(
    		OUTPUT_VAR_DECL_CONTAINERS_1,
    		OUTPUT_VAR_DECL_CONTAINERS_2);
    
    public static final List<Class<? extends GraphicalEditPart>> ECC_CONTAINERS_1 = Arrays.asList(
    		bfbtype.diagram.edit.parts.BFBTypeEditPart.class,
    		bfbtype.diagram.edit.parts.BasicFBEditPart.class,
    		bfbtype.diagram.edit.parts.BasicFBBasicFBCompartmentEditPart.class);
    
    public static final List<List<Class<? extends GraphicalEditPart>>> ECC_CONTAINERS = Arrays.asList(
    		ECC_CONTAINERS_1);
    
    public static final List<List<Class<? extends GraphicalEditPart>>> HCECC_CONTAINERS = ECC_CONTAINERS;
    
    public static final List<List<Class<? extends GraphicalEditPart>>> ALGORITHM_CONTAINERS = ECC_CONTAINERS;
    
    public static final List<Class<?>> ECTRANSITION_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.ECCEditPart.class,
    		bfbtype.diagram.edit.parts.ECCECCCompartmentEditPart.class);
    
    public static final List<Class<?>> ECTRANSITION_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.ECC2EditPart.class,
    		bfbtype.diagram.edit.parts.ECCECCCompartment2EditPart.class);
    
    public static final List<List<Class<?>>> ECTRANSITION_CONTAINERS = Arrays.asList(
    		ECTRANSITION_CONTAINERS_1,
    		ECTRANSITION_CONTAINERS_2);
    
    public static final List<List<Class<?>>> ECSTATE_CONTAINERS = ECTRANSITION_CONTAINERS;
    
    public static final List<Class<?>> ECACTION_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.ECStateEditPart.class,
    		bfbtype.diagram.edit.parts.ECStateECStateCompartmentEditPart.class);
    
    public static final List<List<Class<?>>> ECACTION_CONTAINERS = Arrays.asList(
    		ECACTION_CONTAINERS_1);
    
    public static final List<Class<?>> HCECC_PAR_RELATION_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.HCECCEditPart.class,
    		bfbtype.diagram.edit.parts.HCECCHCECCCompartmentEditPart.class);
    
    public static final List<List<Class<?>>> HCECC_PAR_RELATION_CONTAINERS = Arrays.asList(
    		HCECC_PAR_RELATION_CONTAINERS_1);
    
    public static final List<List<Class<?>>> HCECC_REF_RELATION_CONTAINERS_1 = HCECC_PAR_RELATION_CONTAINERS;
    
    public static final List<Class<?>> FBD_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.AlgorithmEditPart.class,
    		bfbtype.diagram.edit.parts.AlgorithmAlgorithmCompartmentEditPart.class);
    
    public static final List<List<Class<?>>> FBD_CONTAINERS = Arrays.asList(
    		FBD_CONTAINERS_1);
    
    public static final List<List<Class<?>>> ST_CONTAINERS = FBD_CONTAINERS;
    
    public static final List<List<Class<?>>> LD_CONTAINERS = FBD_CONTAINERS;
    
    public static final List<List<Class<?>>> OTHER_CONTAINERS = FBD_CONTAINERS;
    
    public static final List<Class<?>> FB_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.FBDEditPart.class,
    		bfbtype.diagram.edit.parts.FBDFBDCompartmentEditPart.class);
    
    public static final List<Class<?>> FB_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkFBNetworkCompartmentEditPart.class);
    
    public static final List<List<Class<?>>> FB_CONTAINERS = Arrays.asList(
    		FB_CONTAINERS_1,
    		FB_CONTAINERS_2);
    
    public static final List<Class<?>> DATA_CONNECTION_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.FBDEditPart.class,
    		bfbtype.diagram.edit.parts.FBDFBDCompartmentEditPart.class,
    		bfbtype.diagram.edit.parts.DataConnectionsEditPart.class,
    		bfbtype.diagram.edit.parts.DataConnectionsDataConnectionsCompartmentEditPart.class);
    
    public static final List<Class<?>> DATA_CONNECTION_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkFBNetworkCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.DataConnectionsEditPart.class,
    		cfbtype.diagram.edit.parts.DataConnectionsDataConnectionsCompartmentEditPart.class);
    
    public static final List<List<Class<?>>> DATA_CONNECTION_CONTAINERS = Arrays.asList(
    		DATA_CONNECTION_CONTAINERS_1,
    		DATA_CONNECTION_CONTAINERS_2);
    
    public static final List<Class<?>> EVENT_CONNECTION_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkFBNetworkCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.EventConnectionsEditPart.class,
    		cfbtype.diagram.edit.parts.EventConnectionsEventConnectionsCompartmentEditPart.class);
    
    public static final List<List<Class<?>>> EVENT_CONNECTION_CONTAINERS = Arrays.asList(
    		EVENT_CONNECTION_CONTAINERS_1);
    
    public static final List<Class<?>> INPUT_WITH_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.InputEventEditPart.class,
    		bfbtype.diagram.edit.parts.InputEventInputEventCompartmentEditPart.class);
    
    public static final List<Class<?>> INPUT_WITH_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.InputEventEditPart.class,
    		cfbtype.diagram.edit.parts.InputEventInputEventCompartmentEditPart.class);
    
    public static final List<List<Class<?>>> INPUT_WITH_CONTAINERS = Arrays.asList(
    		INPUT_WITH_CONTAINERS_1,
    		INPUT_WITH_CONTAINERS_2);
    
    public static final List<Class<?>> OUTPUT_WITH_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.OutputEventEditPart.class,
    		bfbtype.diagram.edit.parts.OutputEventOutputEventCompartmentEditPart.class);
    
    public static final List<Class<?>> OUTPUT_WITH_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.OutputEventEditPart.class,
    		cfbtype.diagram.edit.parts.OutputEventOutputEventCompartmentEditPart.class);
    
    public static final List<List<Class<?>>> OUTPUT_WITH_CONTAINERS = Arrays.asList(
    		OUTPUT_WITH_CONTAINERS_1,
    		OUTPUT_WITH_CONTAINERS_2);
    
    public static final List<Class<?>> RUNG_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.LDEditPart.class,
    		bfbtype.diagram.edit.parts.LDLDCompartmentEditPart.class);
    
    public static final List<List<Class<?>>> RUNG_CONTAINERS = Arrays.asList(
    		RUNG_CONTAINERS_1);
    
    /* (non-Javadoc)
     * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IStructuredSelection selection = (IStructuredSelection)HandlerUtil.getActiveMenuSelection(event);
        if (selection == null)
            selection = (IStructuredSelection)HandlerUtil.getCurrentSelection(event);
        String type = event.getParameter(TYPE_PARAM);
        if (selection != null && type != null) {
		
        	// add an element to each selected node
            Iterator<?> selectionIter = selection.iterator();
            while (selectionIter.hasNext()) {
                Object nextObj = selectionIter.next();
                // TODO: hier kommen noch mehr andere EditParts rein
                if (nextObj instanceof BFBTypeEditPart
                        || nextObj instanceof CFBTypeEditPart)
                    addElement((GraphicalEditPart)nextObj, type);
                else if (nextObj instanceof ShapeCompartmentEditPart
                        || nextObj instanceof ITextAwareEditPart) {
                    EditPart parent = ((EditPart)nextObj).getParent();
                    if (parent instanceof BFBTypeEditPart
                            || parent instanceof CFBTypeEditPart)
                        addElement((GraphicalEditPart)parent, type);
                }
            }
            // set the last selected node into edit mode
            if (lastEditCompartment != null) {
                final EditPartViewer viewer = lastEditCompartment.getViewer();
                final EditPart elementPart = (EditPart)viewer.getEditPartRegistry()
                        .get(elementViewAdapter.getAdapter(View.class));
                if (elementPart != null) {
                    Display.getCurrent().asyncExec(new Runnable() {
                        public void run() {
                            viewer.setSelection(new StructuredSelection(elementPart));
                            Request der = new Request(RequestConstants.REQ_DIRECT_EDIT);
                            elementPart.performRequest(der);
                        }
                    });
                }
            }
		}
        return null;
	}
    
	/**
     * Adds an element of given type to the edit part.
     * 
     * @param editPart edit part
     * @param type type of element to add
     */
    private void addElement(GraphicalEditPart editPart, String type) {
    	
    	// Am besten sollte man erstmal von JEDEM editPart nach oben zum BFBType gehen
    	// Dann gucken, ob Container vorhanden sind. falls nicht, erzeugen.
    	// Dann element einfuegen
    	
    	// Moment mal: vielleicht lieber von unten nach oben und Container REKURSIV erzeugen!
    	
    	// Ich brauche eine generische Klasse oder Methode, der ich ihre Containerstruktur uebergebe 
    	// und die dann entsprechend sucht
    	
    	// Erstmal gucke ich, ob ich eine spezielle loesung hinkriege:
    	
    	if (editPart instanceof BFBTypeEditPart) {
    		
    		// Vorsicht: Es muessen spaeter InterfaceList, EventInputs, usw.
    		// sowohl von BFB als auch von CFB beachtet werden!
    		
    		InterfaceListEditPart interfaceListEditPart = null;
    		EventInputsEditPart eventInputsEditPart = null;
    		InterfaceListInterfaceListCompartmentEditPart interfaceListCompartmentEditPart = null;
    		EventInputsEventInputsCompartmentEditPart eventInputsCompartmentEditPart = null;
    		
    		Iterator<?> selectionIter = editPart.getChildren().iterator();
    		while (selectionIter.hasNext()) {
    			Object nextObj = selectionIter.next();
    			if (nextObj instanceof InterfaceListEditPart) {
    				interfaceListEditPart = (InterfaceListEditPart) nextObj;
    				break;
    			}
    		}
    		if (interfaceListEditPart == null) {
    			createElement(BfbtypeElementTypes.InterfaceList_2004, editPart);
    			selectionIter = editPart.getChildren().iterator();
        		while (selectionIter.hasNext()) {
        			Object nextObj = selectionIter.next();
        			if (nextObj instanceof InterfaceListEditPart) {
        				interfaceListEditPart = (InterfaceListEditPart) nextObj;
        				break;
        			}
        		}
    		}
    		
    		selectionIter = interfaceListEditPart.getChildren().iterator();
    		while (selectionIter.hasNext()) {
    			Object nextObj = selectionIter.next();
    			if (nextObj instanceof InterfaceListInterfaceListCompartmentEditPart) {
    				interfaceListCompartmentEditPart = (InterfaceListInterfaceListCompartmentEditPart) nextObj;
    				break;
    			}
    		}
    		
    		// Hier sollte nichtsdestotrotz eine Ueberpruefung auf Null-Referenz hin!
    		
    		/*if (interfaceListCompartmentEditPart == null) {
    			createElement(BfbtypeElementTypes.EventInputs_3002, interfaceListEditPart);
    			selectionIter = interfaceListEditPart.getChildren().iterator();
        		while (selectionIter.hasNext()) {
        			Object nextObj = selectionIter.next();
        			if (nextObj instanceof EventInputsEditPart) {
        				eventInputsEditPart = (EventInputsEditPart) nextObj;
        				break;
        			}
        		}
    		}*/
    		
    		selectionIter = interfaceListCompartmentEditPart.getChildren().iterator();
    		while (selectionIter.hasNext()) {
    			Object nextObj = selectionIter.next();
    			if (nextObj instanceof EventInputsEditPart) {
    				eventInputsEditPart = (EventInputsEditPart) nextObj;
    				break;
    			}
    		}
    		if (eventInputsEditPart == null) {
    			createElement(BfbtypeElementTypes.EventInputs_3002, interfaceListEditPart);
    			selectionIter = interfaceListCompartmentEditPart.getChildren().iterator();
        		while (selectionIter.hasNext()) {
        			Object nextObj = selectionIter.next();
        			if (nextObj instanceof EventInputsEditPart) {
        				eventInputsEditPart = (EventInputsEditPart) nextObj;
        				break;
        			}
        		}
    		}
    		
    		selectionIter = eventInputsEditPart.getChildren().iterator();
    		while (selectionIter.hasNext()) {
    			Object nextObj = selectionIter.next();
    			if (nextObj instanceof EventInputsEventInputsCompartmentEditPart) {
    				eventInputsCompartmentEditPart = (EventInputsEventInputsCompartmentEditPart) nextObj;
    				break;
    			}
    		}
    		
    		createElement(BfbtypeElementTypes.InputEvent_3003, eventInputsCompartmentEditPart);
    	}
    }
    
    // creates element of type elementType in container editPart
    private void createElement(IElementType elementType, GraphicalEditPart editPart) {
    	CreateViewRequest inputEventRequest = CreateViewRequestFactory.getCreateShapeRequest(
                elementType, editPart.getDiagramPreferencesHint());
        Command createInputEventCmd = editPart.getCommand(inputEventRequest);
        elementViewAdapter = (IAdaptable)((List<?>)inputEventRequest.getNewObject()).get(0);
        editPart.getDiagramEditDomain().getDiagramCommandStack().execute(createInputEventCmd);
        lastEditCompartment = editPart;
    }
    
}
	
