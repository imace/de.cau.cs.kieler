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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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

import org.eclipse.emf.common.util.EList;

/**
 * Handler that adds an element to a specific element.
 * 
 * @author schm
 */
public class AddToTypeHandler extends AbstractHandler implements IHandler {

	/** parameter for type of element to add */
    public static final String TYPE_PARAM = "de.cau.cs.kieler.cakefeed.custom.parameters.type";
    
    private static final String VAL_INPUT_EVENT = "InputEvent";
    private static final String VAL_OUTPUT_EVENT = "OutputEvent";
    private static final String VAL_INPUT_VAR_DECL = "InputVarDecl";
    private static final String VAL_OUTPUT_VAR_DECL = "OutputVarDecl";
    private static final String VAL_ECC = "ECC";
    private static final String VAL_HCECC = "HCECC";
    private static final String VAL_ALGORITHM = "Algorithm";
    private static final String VAL_ECTRANSITION = "ECTransition";
    private static final String VAL_ECSTATE = "ECState";
    private static final String VAL_ECACTION = "ECAction";
    private static final String VAL_HCECC_PAR_RELATION = "HCECCParallelRelation";
    private static final String VAL_HCECC_REF_RELATION = "HCECCRefinementRelation";
    private static final String VAL_FBD = "FBD";
    private static final String VAL_ST = "ST";
    private static final String VAL_LD = "LD";
    private static final String VAL_OTHER = "Other";
    private static final String VAL_FB = "FB";
    private static final String VAL_DATA_CONNECTION = "DataConnection";
    private static final String VAL_INPUT_WITH = "InputWith";
    private static final String VAL_OUTPUT_WITH = "OutputWith";
    private static final String VAL_RUNG = "Rung";
    private static final String VAL_EVENT_CONNECTION = "EventConnection";
    
    private static final String VAL_INPUT_EVENT_CFB = "InputEventCFB";
    private static final String VAL_OUTPUT_EVENT_CFB = "OutputEventCFB";
    private static final String VAL_INPUT_VAR_DECL_CFB = "InputVarDeclCFB";
    private static final String VAL_OUTPUT_VAR_DECL_CFB = "OutputVarDeclCFB";
    private static final String VAL_INPUT_WITH_CFB = "InputWithCFB";
    private static final String VAL_OUTPUT_WITH_CFB = "OutputWithCFB";
    private static final String VAL_ECC_2 = "ECC2";
    private static final String VAL_FB_CFB = "FBCFB";
    private static final String VAL_DATA_CONNECTION_CFB = "DataConnectionCFB";
    
    /** last compartment to which an element was added */
    private GraphicalEditPart lastEditCompartment;
    /** view adapter for the last edited compartment */
    private IAdaptable elementViewAdapter;
    
    /** lists of lists of containers for certain elements */
    private static final List<Class<?>> INPUT_EVENT_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.BFBTypeEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		bfbtype.diagram.edit.parts.EventInputsEditPart.class,
    		bfbtype.diagram.edit.parts.EventInputsEventInputsCompartmentEditPart.class);
    
    private static final List<Class<?>> INPUT_EVENT_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.EventInputsEditPart.class,
    		cfbtype.diagram.edit.parts.EventInputsEventInputsCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> INPUT_EVENT_CONTAINERS = Arrays.asList(
    		INPUT_EVENT_CONTAINERS_1);
    
    private static final List<List<Class<?>>> INPUT_EVENT_CONTAINERS_CFB = Arrays.asList(
    		INPUT_EVENT_CONTAINERS_2);
    
    private static final List<Class<?>> OUTPUT_EVENT_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.BFBTypeEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		bfbtype.diagram.edit.parts.EventOutputsEditPart.class,
    		bfbtype.diagram.edit.parts.EventOutputsEventOutputsCompartmentEditPart.class);
    
    private static final List<Class<?>> OUTPUT_EVENT_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.EventOutputsEditPart.class,
    		cfbtype.diagram.edit.parts.EventOutputsEventOutputsCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> OUTPUT_EVENT_CONTAINERS = Arrays.asList(
    		OUTPUT_EVENT_CONTAINERS_1);
    
    private static final List<List<Class<?>>> OUTPUT_EVENT_CONTAINERS_CFB = Arrays.asList(
    		OUTPUT_EVENT_CONTAINERS_2);
    
    private static final List<Class<?>> INPUT_VAR_DECL_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.BFBTypeEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		bfbtype.diagram.edit.parts.InputVarsEditPart.class,
    		bfbtype.diagram.edit.parts.InputVarsInputVarsCompartmentEditPart.class);
    
    private static final List<Class<?>> INPUT_VAR_DECL_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.InputVarsEditPart.class,
    		cfbtype.diagram.edit.parts.InputVarsInputVarsCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> INPUT_VAR_DECL_CONTAINERS = Arrays.asList(
    		INPUT_VAR_DECL_CONTAINERS_1);
    
    private static final List<List<Class<?>>> INPUT_VAR_DECL_CONTAINERS_CFB = Arrays.asList(
    		INPUT_VAR_DECL_CONTAINERS_2);
    
    private static final List<Class<?>> OUTPUT_VAR_DECL_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.BFBTypeEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		bfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		bfbtype.diagram.edit.parts.OutputVarsEditPart.class,
    		bfbtype.diagram.edit.parts.OutputVarsOutputVarsCompartmentEditPart.class);
    
    private static final List<Class<?>> OUTPUT_VAR_DECL_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListEditPart.class,
    		cfbtype.diagram.edit.parts.InterfaceListInterfaceListCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.OutputVarsEditPart.class,
    		cfbtype.diagram.edit.parts.OutputVarsOutputVarsCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> OUTPUT_VAR_DECL_CONTAINERS = Arrays.asList(
    		OUTPUT_VAR_DECL_CONTAINERS_1);
    
    private static final List<List<Class<?>>> OUTPUT_VAR_DECL_CONTAINERS_CFB = Arrays.asList(
    		OUTPUT_VAR_DECL_CONTAINERS_2);
    
    private static final List<Class<?>> ECC_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.BFBTypeEditPart.class,
    		bfbtype.diagram.edit.parts.BasicFBEditPart.class,
    		bfbtype.diagram.edit.parts.BasicFBBasicFBCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> ECC_CONTAINERS = Arrays.asList(
    		ECC_CONTAINERS_1);
    
    private static final List<List<Class<?>>> HCECC_CONTAINERS = ECC_CONTAINERS;
    
    private static final List<List<Class<?>>> ALGORITHM_CONTAINERS = ECC_CONTAINERS;
    
    private static final List<Class<?>> ECTRANSITION_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.ECCEditPart.class,
    		bfbtype.diagram.edit.parts.ECCECCCompartmentEditPart.class);
    
    private static final List<Class<?>> ECTRANSITION_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.ECC2EditPart.class,
    		bfbtype.diagram.edit.parts.ECCECCCompartment2EditPart.class);
    
    private static final List<List<Class<?>>> ECTRANSITION_CONTAINERS = Arrays.asList(
    		ECTRANSITION_CONTAINERS_1,
    		ECTRANSITION_CONTAINERS_2);
    
    private static final List<List<Class<?>>> ECSTATE_CONTAINERS = ECTRANSITION_CONTAINERS;
    
    private static final List<Class<?>> ECACTION_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.ECStateEditPart.class,
    		bfbtype.diagram.edit.parts.ECStateECStateCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> ECACTION_CONTAINERS = Arrays.asList(
    		ECACTION_CONTAINERS_1);
    
    private static final List<Class<?>> HCECC_PAR_RELATION_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.HCECCEditPart.class,
    		bfbtype.diagram.edit.parts.HCECCHCECCCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> HCECC_PAR_RELATION_CONTAINERS = Arrays.asList(
    		HCECC_PAR_RELATION_CONTAINERS_1);
    
    private static final List<List<Class<?>>> HCECC_REF_RELATION_CONTAINERS = HCECC_PAR_RELATION_CONTAINERS;
    
    private static final List<Class<?>> FBD_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.AlgorithmEditPart.class,
    		bfbtype.diagram.edit.parts.AlgorithmAlgorithmCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> FBD_CONTAINERS = Arrays.asList(
    		FBD_CONTAINERS_1);
    
    private static final List<List<Class<?>>> ST_CONTAINERS = FBD_CONTAINERS;
    
    private static final List<List<Class<?>>> LD_CONTAINERS = FBD_CONTAINERS;
    
    private static final List<List<Class<?>>> OTHER_CONTAINERS = FBD_CONTAINERS;
    
    private static final List<Class<?>> FB_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.FBDEditPart.class,
    		bfbtype.diagram.edit.parts.FBDFBDCompartmentEditPart.class);
    
    private static final List<Class<?>> FB_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkFBNetworkCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> FB_CONTAINERS = Arrays.asList(
    		FB_CONTAINERS_1);
    
    private static final List<List<Class<?>>> FB_CONTAINERS_CFB = Arrays.asList(
    		FB_CONTAINERS_2);
    
    private static final List<Class<?>> DATA_CONNECTION_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.FBDEditPart.class,
    		bfbtype.diagram.edit.parts.FBDFBDCompartmentEditPart.class,
    		bfbtype.diagram.edit.parts.DataConnectionsEditPart.class,
    		bfbtype.diagram.edit.parts.DataConnectionsDataConnectionsCompartmentEditPart.class);
    
    private static final List<Class<?>> DATA_CONNECTION_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkFBNetworkCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.DataConnectionsEditPart.class,
    		cfbtype.diagram.edit.parts.DataConnectionsDataConnectionsCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> DATA_CONNECTION_CONTAINERS = Arrays.asList(
    		DATA_CONNECTION_CONTAINERS_1);
    
    private static final List<List<Class<?>>> DATA_CONNECTION_CONTAINERS_CFB = Arrays.asList(
    		DATA_CONNECTION_CONTAINERS_2);
    
    private static final List<Class<?>> EVENT_CONNECTION_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.CFBTypeEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkEditPart.class,
    		cfbtype.diagram.edit.parts.FBNetworkFBNetworkCompartmentEditPart.class,
    		cfbtype.diagram.edit.parts.EventConnectionsEditPart.class,
    		cfbtype.diagram.edit.parts.EventConnectionsEventConnectionsCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> EVENT_CONNECTION_CONTAINERS = Arrays.asList(
    		EVENT_CONNECTION_CONTAINERS_1);
    
    private static final List<Class<?>> INPUT_WITH_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.InputEventEditPart.class,
    		bfbtype.diagram.edit.parts.InputEventInputEventCompartmentEditPart.class);
    
    private static final List<Class<?>> INPUT_WITH_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.InputEventEditPart.class,
    		cfbtype.diagram.edit.parts.InputEventInputEventCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> INPUT_WITH_CONTAINERS = Arrays.asList(
    		INPUT_WITH_CONTAINERS_1);
    
    private static final List<List<Class<?>>> INPUT_WITH_CONTAINERS_CFB = Arrays.asList(
    		INPUT_WITH_CONTAINERS_2);
    
    private static final List<Class<?>> OUTPUT_WITH_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.OutputEventEditPart.class,
    		bfbtype.diagram.edit.parts.OutputEventOutputEventCompartmentEditPart.class);
    
    private static final List<Class<?>> OUTPUT_WITH_CONTAINERS_2 = Arrays.asList(
    		(Class<?>)cfbtype.diagram.edit.parts.OutputEventEditPart.class,
    		cfbtype.diagram.edit.parts.OutputEventOutputEventCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> OUTPUT_WITH_CONTAINERS = Arrays.asList(
    		OUTPUT_WITH_CONTAINERS_1);
    
    private static final List<List<Class<?>>> OUTPUT_WITH_CONTAINERS_CFB = Arrays.asList(
    		OUTPUT_WITH_CONTAINERS_2);
    
    private static final List<Class<?>> RUNG_CONTAINERS_1 = Arrays.asList(
    		(Class<?>)bfbtype.diagram.edit.parts.LDEditPart.class,
    		bfbtype.diagram.edit.parts.LDLDCompartmentEditPart.class);
    
    private static final List<List<Class<?>>> RUNG_CONTAINERS = Arrays.asList(
    		RUNG_CONTAINERS_1);
    
    // Map hierarchy lists to parameter values
    private static final Map<String, List<List<Class<?>>>> hierarchyMapping = new HashMap<String, List<List<Class<?>>>>(){{
        put(VAL_INPUT_EVENT, INPUT_EVENT_CONTAINERS);
        put(VAL_OUTPUT_EVENT, OUTPUT_EVENT_CONTAINERS);
        put(VAL_INPUT_VAR_DECL, INPUT_VAR_DECL_CONTAINERS);
        put(VAL_OUTPUT_VAR_DECL, OUTPUT_VAR_DECL_CONTAINERS);
        put(VAL_ECC, ECC_CONTAINERS);
        put(VAL_HCECC, HCECC_CONTAINERS);
        put(VAL_ALGORITHM, ALGORITHM_CONTAINERS);
        put(VAL_ECTRANSITION, ECTRANSITION_CONTAINERS);
        put(VAL_ECSTATE, ECSTATE_CONTAINERS);
        put(VAL_ECACTION, ECACTION_CONTAINERS);
        put(VAL_HCECC_PAR_RELATION, HCECC_PAR_RELATION_CONTAINERS);
        put(VAL_HCECC_REF_RELATION, HCECC_REF_RELATION_CONTAINERS);
        put(VAL_FBD, FBD_CONTAINERS);
        put(VAL_ST, ST_CONTAINERS);
        put(VAL_LD, LD_CONTAINERS);
        put(VAL_OTHER, OTHER_CONTAINERS);
        put(VAL_FB, FB_CONTAINERS);
        put(VAL_DATA_CONNECTION, DATA_CONNECTION_CONTAINERS);
        put(VAL_INPUT_WITH, INPUT_WITH_CONTAINERS);
        put(VAL_OUTPUT_WITH, OUTPUT_WITH_CONTAINERS);
        put(VAL_RUNG, RUNG_CONTAINERS);
        put(VAL_EVENT_CONNECTION, EVENT_CONNECTION_CONTAINERS);
        
        put(VAL_INPUT_EVENT_CFB, INPUT_EVENT_CONTAINERS_CFB);
        put(VAL_OUTPUT_EVENT_CFB, OUTPUT_EVENT_CONTAINERS_CFB);
        put(VAL_INPUT_VAR_DECL_CFB, INPUT_VAR_DECL_CONTAINERS_CFB);
        put(VAL_OUTPUT_VAR_DECL_CFB, OUTPUT_VAR_DECL_CONTAINERS_CFB);
        put(VAL_INPUT_WITH_CFB, INPUT_WITH_CONTAINERS_CFB);
        put(VAL_OUTPUT_WITH_CFB, OUTPUT_WITH_CONTAINERS_CFB);
        put(VAL_ECC_2, ECC_CONTAINERS); //TODO: kann sein dass ECC2 andere container hat
        put(VAL_FB_CFB, FB_CONTAINERS_CFB);
        put(VAL_DATA_CONNECTION_CFB, DATA_CONNECTION_CONTAINERS_CFB);
    }};
    
    // Map TYPE_PARAM values to classes
    private static final Map<String, Class<?>> paramMapping = new HashMap<String, Class<?>>(){{
    	put(VAL_INPUT_EVENT, bfbtype.diagram.edit.parts.InputEventEditPart.class);
    	put(VAL_OUTPUT_EVENT, bfbtype.diagram.edit.parts.OutputEventEditPart.class);
        put(VAL_INPUT_VAR_DECL, bfbtype.diagram.edit.parts.InputVarDeclarationEditPart.class);
        put(VAL_OUTPUT_VAR_DECL, bfbtype.diagram.edit.parts.OutputVarDeclarationEditPart.class);
        put(VAL_ECC, bfbtype.diagram.edit.parts.ECCEditPart.class);
        put(VAL_HCECC, bfbtype.diagram.edit.parts.HCECCEditPart.class);
        put(VAL_ALGORITHM, bfbtype.diagram.edit.parts.AlgorithmEditPart.class);
        put(VAL_ECTRANSITION, bfbtype.diagram.edit.parts.ECTransitionEditPart.class);
        put(VAL_ECSTATE, bfbtype.diagram.edit.parts.ECStateEditPart.class);
        put(VAL_ECACTION, bfbtype.diagram.edit.parts.ECActionEditPart.class);
        put(VAL_HCECC_PAR_RELATION, bfbtype.diagram.edit.parts.HCECCParallelRelationEditPart.class);
        put(VAL_HCECC_REF_RELATION, bfbtype.diagram.edit.parts.HCECCRefinementRelationEditPart.class);
        put(VAL_FBD, bfbtype.diagram.edit.parts.FBDEditPart.class);
        put(VAL_ST, bfbtype.diagram.edit.parts.STEditPart.class);
        put(VAL_LD, bfbtype.diagram.edit.parts.LDEditPart.class);
        put(VAL_OTHER, bfbtype.diagram.edit.parts.OtherEditPart.class);
        put(VAL_FB, bfbtype.diagram.edit.parts.FBEditPart.class);
        put(VAL_DATA_CONNECTION, bfbtype.diagram.edit.parts.DataConnectionEditPart.class);
        put(VAL_INPUT_WITH, bfbtype.diagram.edit.parts.InputWithEditPart.class);
        put(VAL_OUTPUT_WITH, bfbtype.diagram.edit.parts.OutputWithEditPart.class);
        put(VAL_RUNG, bfbtype.diagram.edit.parts.RungEditPart.class);
        put(VAL_EVENT_CONNECTION, cfbtype.diagram.edit.parts.EventConnectionEditPart.class);
        
        put(VAL_INPUT_EVENT_CFB, cfbtype.diagram.edit.parts.InputEventEditPart.class);
        put(VAL_OUTPUT_EVENT_CFB, cfbtype.diagram.edit.parts.OutputEventEditPart.class);
        put(VAL_INPUT_VAR_DECL_CFB, cfbtype.diagram.edit.parts.InputVarDeclarationEditPart.class);
        put(VAL_OUTPUT_VAR_DECL_CFB, cfbtype.diagram.edit.parts.OutputVarDeclarationEditPart.class);
        put(VAL_INPUT_WITH_CFB, cfbtype.diagram.edit.parts.InputWithEditPart.class);
        put(VAL_OUTPUT_WITH_CFB, cfbtype.diagram.edit.parts.OutputWithEditPart.class);
        put(VAL_ECC_2, bfbtype.diagram.edit.parts.ECC2EditPart.class);
        put(VAL_FB_CFB, cfbtype.diagram.edit.parts.FBEditPart.class);
        put(VAL_DATA_CONNECTION_CFB, cfbtype.diagram.edit.parts.DataConnectionEditPart.class);
    }};
    
    private static final Map<String, IElementType> typeMapping = new HashMap<String, IElementType>(){{
    	put(VAL_INPUT_EVENT, BfbtypeElementTypes.InputEvent_3003);
    	put(VAL_OUTPUT_EVENT, BfbtypeElementTypes.OutputEvent_3006);
        put(VAL_INPUT_VAR_DECL, BfbtypeElementTypes.InputVarDeclaration_3009);
        put(VAL_OUTPUT_VAR_DECL, BfbtypeElementTypes.OutputVarDeclaration_3011);
        put(VAL_ECC, BfbtypeElementTypes.ECC_3019);
        put(VAL_HCECC, BfbtypeElementTypes.HCECC_3023);
        put(VAL_ALGORITHM, BfbtypeElementTypes.Algorithm_3026);
        put(VAL_ECTRANSITION, BfbtypeElementTypes.ECTransition_3020);
        put(VAL_ECSTATE, BfbtypeElementTypes.ECState_3021);
        put(VAL_ECACTION, BfbtypeElementTypes.ECAction_3022);
        put(VAL_HCECC_PAR_RELATION, BfbtypeElementTypes.HCECCParallelRelation_3040);
        put(VAL_HCECC_REF_RELATION, BfbtypeElementTypes.HCECCRefinementRelation_3041);
        put(VAL_FBD, BfbtypeElementTypes.FBD_3027);
        put(VAL_ST, BfbtypeElementTypes.ST_3032);
        put(VAL_LD, BfbtypeElementTypes.LD_3033);
        put(VAL_OTHER, BfbtypeElementTypes.Other_3035);
        put(VAL_FB, BfbtypeElementTypes.FB_3028);
        put(VAL_DATA_CONNECTION, BfbtypeElementTypes.DataConnection_3031);
        put(VAL_INPUT_WITH, BfbtypeElementTypes.InputWith_3004);
        put(VAL_OUTPUT_WITH, BfbtypeElementTypes.OutputWith_3007);
        put(VAL_RUNG, BfbtypeElementTypes.Rung_3034);
        put(VAL_EVENT_CONNECTION, CfbtypeElementTypes.EventConnection_3020);
        
        put(VAL_INPUT_EVENT_CFB, CfbtypeElementTypes.InputEvent_3003);
        put(VAL_OUTPUT_EVENT_CFB, CfbtypeElementTypes.OutputEvent_3006);
        put(VAL_INPUT_VAR_DECL_CFB, CfbtypeElementTypes.InputVarDeclaration_3009);
        put(VAL_OUTPUT_VAR_DECL_CFB, CfbtypeElementTypes.OutputVarDeclaration_3011);
        put(VAL_INPUT_WITH_CFB, CfbtypeElementTypes.InputWith_3004);
        put(VAL_OUTPUT_WITH_CFB, CfbtypeElementTypes.OutputWith_3007);
        put(VAL_ECC_2, BfbtypeElementTypes.ECC_3024);
        put(VAL_FB_CFB, CfbtypeElementTypes.FB_3017);
        put(VAL_DATA_CONNECTION_CFB, CfbtypeElementTypes.DataConnection_3022);
    }};
    
    /* (non-Javadoc)
     * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// get selected elements
		IStructuredSelection selection = (IStructuredSelection)HandlerUtil.getActiveMenuSelection(event);
        if (selection == null)
            selection = (IStructuredSelection)HandlerUtil.getCurrentSelection(event);
        String type = event.getParameter(TYPE_PARAM);
        if (selection != null && type != null) {
		
        	// get class hierarchy, depending on TYPE_PARAM
        	List<List<Class<?>>> hierarchy = hierarchyMapping.get(type);
        	
        	// search selection for an object which is 
        	// an instance of a class in the hierarchy
        	for (Object object : selection.toList()) {
        		
        		// if one has been found and has no parent in the selection
        		// then create a new object in it
				if (objectMatchesClassInHierarchy(object, hierarchy ) && objectHasNoParentInSelection(object, selection)) {
					insertNewElementInContainer(type, object);
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
    
	private void insertNewElementInContainer(String typeParam, Object object) {
		
		if (object instanceof GraphicalEditPart) {
			GraphicalEditPart editPart = (GraphicalEditPart) object;
			if (hasFeatureOfType(editPart, /*paramMapping.get(*/typeParam/*)*/)) {
				if (getCompartmentOf(editPart) != null) {
					createElement(typeMapping.get(typeParam), getCompartmentOf(editPart));
				}
			}
			else { // hier alle children durchsuchen! Abbruchbedingung? waere oberstes if
				for (Object child : editPart.getChildren()) {
					insertNewElementInContainer(typeParam, child);
				}
				
			}
		}
	}

	private GraphicalEditPart getCompartmentOf(GraphicalEditPart editPart) {
		for (Object child : editPart.getChildren()) {
			if (child instanceof ShapeCompartmentEditPart){
				return (ShapeCompartmentEditPart) child;
			}
		}
		return null;
	}

	private boolean hasFeatureOfType(GraphicalEditPart editPart, String typeParam) {
		/*Field[] fields = ((View)(editPart.getModel())).getElement().getClass().getFields();
		Method[] methods = ((View)(editPart.getModel())).getElement().getClass().getMethods();
		
		for (Field field : fields) {
			if (field.getType().equals(class1)) {
				return true;
			}
		}
		
		for (Method method : methods) {
			if ((method.getReturnType().equals(class1)) 
					|| (method.getReturnType().equals(EList.class)
							&& method.getReturnType().)) {
				return true;
			}
		}*/
		EObject element = ((View)editPart.getModel()).getElement();
		EList<EReference> references = element.eClass().getEReferences();
		for (EReference eReference : references) {
			if (eReference.getEType().getName().equals(typeParam)) {
				return true;
			}
		}
		
		return false;
	}

	private boolean objectHasNoParentInSelection(Object object,
			IStructuredSelection selection) {
		
		for (Object element : selection.toList()) {
			if (isAParentOf(element, object)) {
				return false;
			}
		}
		return true;
	}

	private boolean isAParentOf(Object element, Object object) {
		if (object instanceof EObject) {
			EObject container = ((EObject)object).eContainer();
			if (container.equals(element)) {
				return true;
			} else {
				return isAParentOf(element, container);
			}
		}
		return false;
	}

	private boolean objectMatchesClassInHierarchy(Object object,
			List<List<Class<?>>> hierarchy) {
		
		for (List<Class<?>> list : hierarchy) {
			for (Class<?> class1 : list) {
				if (object.getClass().equals(class1)) {
					return true;
				}
			}
		}
		return false;
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
	
