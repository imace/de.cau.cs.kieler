/* Generated for simulation purpose ONLY */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "U:\shared\modelgui\trunk\scade6_example\Simulation\simulation__railway_type.h"

#include "U:\shared\modelgui\trunk\scade6_example\Simulation\simulation__railway_interface.h"

#include "kcg_sensors.h"
#include "kcg_consts.h"

#include "SmuDefaults.h"

const int  rt_version = Srtv6;
const char* version = "L4sImkiLLer";
const char* root_node = "simulation__railway";
const char* input_sig = "(B,B,B)";

/*
 * Signature of model types
 */
const char* type_signatures[]={
{"I"},
{"B"},
{"I"},
{"(I,B,I,B)"},
{"(B,B,B)"}
};

/*
 * Simulation context
 */

C_railway__simulation input_ctx;
static C_railway__simulation input_ctx0;
static ControlDataType__simulation SAO_controlData_tmp;

const context contexts[]={
	{ &input_ctx, sizeof(input_ctx) },
	{ &SAO_controlData, sizeof(SAO_controlData) },
	0,
};
void restore_context(void) {
}

/*
 * Tree path
 */

/* kind name parent brother_count brother child var */

path_element path_elements[]={
	/* 1 */{ nodeKind, "simulation::railway", 0, 0, 0, 2, 1, valid },
	/* 2 */{ nodeKind, "digital::RisingEdgeRetrigger 1", 1, 2, 4, 3, 36, valid },
	/* 3 */{ nodeKind, "digital::count_down 11", 2, 1, 0, 0, 52, valid },
	/* 4 */{ nodeKind, "pwlinear::Counter 1", 1, 2, 0, 0, 60, valid }
};

const int nb_path_elements=4;

/*
 * Observables variables
 */

obs_var obs_vars[]={
	/* 1 */{ rootInputKind, "controlData", 1, (&SAO_controlData), 0, valid, print_ControlDataType__simulation_value, set_ControlDataType__simulation},
	/* 2 */{ rootOutputKind, "out_displayData", 1, (&input_ctx.out_displayData), 0, valid, print_DisplayDataType__simulation_value, set_DisplayDataType__simulation},
	/* 3 */{ localKind, "_L16", 1, (&input_ctx._L16), 0, valid, print_int_value, set_int},
	/* 4 */{ localKind, "buttonUp", 1, (&input_ctx.buttonUp), 1, valid, print_bool_value, set_bool},
	/* 5 */{ localKind, "buttonDown", 1, (&input_ctx.buttonDown), 1, valid, print_bool_value, set_bool},
	/* 6 */{ localKind, "direction", 1, (&input_ctx.direction), 0, valid, print_int_value, set_int},
	/* 7 */{ localKind, "alarm", 1, (&input_ctx.alarm), 1, valid, print_bool_value, set_bool},
	/* 8 */{ localKind, "_L1", 1, (&input_ctx._L1), 0, valid, print_ControlDataType__simulation_value, set_ControlDataType__simulation},
	/* 9 */{ localKind, "_L2", 1, (&input_ctx._L2), 0, valid, print_DisplayDataType__simulation_value, set_DisplayDataType__simulation},
	/* 10 */{ localKind, "_L4", 1, (&input_ctx._L4), 1, valid, print_bool_value, set_bool},
	/* 11 */{ localKind, "_L6", 1, (&input_ctx._L6), 0, valid, print_int_value, set_int},
	/* 12 */{ localKind, "_L7", 1, (&input_ctx._L7), 0, valid, print_int_value, set_int},
	/* 13 */{ localKind, "_L8", 1, (&input_ctx._L8), 0, valid, print_int_value, set_int},
	/* 14 */{ localKind, "_L10", 1, (&input_ctx._L10), 0, valid, print_int_value, set_int},
	/* 15 */{ localKind, "_L11", 1, (&input_ctx._L11), 0, valid, print_int_value, set_int},
	/* 16 */{ localKind, "_L12", 1, (&input_ctx._L12), 0, valid, print_int_value, set_int},
	/* 17 */{ localKind, "_L13", 1, (&input_ctx._L13), 0, valid, print_int_value, set_int},
	/* 18 */{ localKind, "_L14", 1, (&input_ctx._L14), 0, valid, print_int_value, set_int},
	/* 19 */{ localKind, "_L15", 1, (&input_ctx._L15), 0, valid, print_int_value, set_int},
	/* 20 */{ localKind, "_L17", 1, (&input_ctx._L17), 1, valid, print_bool_value, set_bool},
	/* 21 */{ localKind, "_L18", 1, (&input_ctx._L18), 1, valid, print_bool_value, set_bool},
	/* 22 */{ localKind, "_L19", 1, (&input_ctx._L19), 0, valid, print_int_value, set_int},
	/* 23 */{ localKind, "_L20", 1, (&input_ctx._L20), 0, valid, print_int_value, set_int},
	/* 24 */{ localKind, "_L22", 1, (&input_ctx._L22), 1, valid, print_bool_value, set_bool},
	/* 25 */{ localKind, "_L23", 1, (&input_ctx._L23), 1, valid, print_bool_value, set_bool},
	/* 26 */{ localKind, "_L27", 1, (&input_ctx._L27), 1, valid, print_bool_value, set_bool},
	/* 27 */{ localKind, "_L28", 1, (&input_ctx._L28), 1, valid, print_bool_value, set_bool},
	/* 28 */{ localKind, "_L29", 1, (&input_ctx._L29), 1, valid, print_bool_value, set_bool},
	/* 29 */{ localKind, "_L30", 1, (&input_ctx._L30), 1, valid, print_bool_value, set_bool},
	/* 30 */{ localKind, "_L31", 1, (&input_ctx._L31), 1, valid, print_bool_value, set_bool},
	/* 31 */{ localKind, "_L32", 1, (&input_ctx._L32), 0, valid, print_int_value, set_int},
	/* 32 */{ localKind, "_L33", 1, (&input_ctx._L33), 0, valid, print_int_value, set_int},
	/* 33 */{ localKind, "_L34", 1, (&input_ctx._L34), 0, valid, print_int_value, set_int},
	/* 34 */{ localKind, "_L35", 1, (&input_ctx._L35), 1, valid, print_bool_value, set_bool},
	/* 35 */{ localKind, "_L37", 1, (&input_ctx._L37), 1, valid, print_bool_value, set_bool},
	/* 36 */{ outputKind, "RER_Output", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0.RER_Output), 1, valid, print_bool_value, set_bool},
	/* 37 */{ localKind, "_L31", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L31), 1, valid, print_bool_value, set_bool},
	/* 38 */{ localKind, "_L43", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L43), 1, valid, print_bool_value, set_bool},
	/* 39 */{ localKind, "_L48", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L48), 0, valid, print_int_value, set_int},
	/* 40 */{ localKind, "_L13", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L13), 1, valid, print_bool_value, set_bool},
	/* 41 */{ localKind, "_L14", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L14), 1, valid, print_bool_value, set_bool},
	/* 42 */{ localKind, "_L16", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L16), 1, valid, print_bool_value, set_bool},
	/* 43 */{ localKind, "_L44", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L44), 0, valid, print_int_value, set_int},
	/* 44 */{ localKind, "_L41", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L41), 0, valid, print_int_value, set_int},
	/* 45 */{ localKind, "_L39", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L39), 1, valid, print_bool_value, set_bool},
	/* 46 */{ localKind, "_L38", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L38), 1, valid, print_bool_value, set_bool},
	/* 47 */{ localKind, "_L36", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L36), 1, valid, print_bool_value, set_bool},
	/* 48 */{ localKind, "_L35", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L35), 1, valid, print_bool_value, set_bool},
	/* 49 */{ localKind, "_L46", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L46), 1, valid, print_bool_value, set_bool},
	/* 50 */{ localKind, "_L47", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L47), 1, valid, print_bool_value, set_bool},
	/* 51 */{ localKind, "_L50", 2, (&input_ctx.C_RisingEdgeRetrigger__digital_0._L50), 0, valid, print_int_value, set_int},
	/* 52 */{ outputKind, "cpt", 3, (&input_ctx.C_RisingEdgeRetrigger__digital_0.C_count_down__digital_0.cpt), 0, valid, print_int_value, set_int},
	/* 53 */{ localKind, "_L4", 3, (&input_ctx.C_RisingEdgeRetrigger__digital_0.C_count_down__digital_0._L4), 0, valid, print_int_value, set_int},
	/* 54 */{ localKind, "_L1", 3, (&input_ctx.C_RisingEdgeRetrigger__digital_0.C_count_down__digital_0._L1), 1, valid, print_bool_value, set_bool},
	/* 55 */{ localKind, "_L2", 3, (&input_ctx.C_RisingEdgeRetrigger__digital_0.C_count_down__digital_0._L2), 0, valid, print_int_value, set_int},
	/* 56 */{ localKind, "_L3", 3, (&input_ctx.C_RisingEdgeRetrigger__digital_0.C_count_down__digital_0._L3), 0, valid, print_int_value, set_int},
	/* 57 */{ localKind, "_L7", 3, (&input_ctx.C_RisingEdgeRetrigger__digital_0.C_count_down__digital_0._L7), 0, valid, print_int_value, set_int},
	/* 58 */{ localKind, "_L8", 3, (&input_ctx.C_RisingEdgeRetrigger__digital_0.C_count_down__digital_0._L8), 0, valid, print_int_value, set_int},
	/* 59 */{ localKind, "_L13", 3, (&input_ctx.C_RisingEdgeRetrigger__digital_0.C_count_down__digital_0._L13), 0, valid, print_int_value, set_int},
	/* 60 */{ outputKind, "Count", 4, (&input_ctx.C_Counter_0__pwlinear_0.Count), 0, valid, print_int_value, set_int},
	/* 61 */{ localKind, "_L9", 4, (&input_ctx.C_Counter_0__pwlinear_0._L9), 0, valid, print_int_value, set_int},
	/* 62 */{ localKind, "_L2", 4, (&input_ctx.C_Counter_0__pwlinear_0._L2), 0, valid, print_int_value, set_int},
	/* 63 */{ localKind, "_L3", 4, (&input_ctx.C_Counter_0__pwlinear_0._L3), 1, valid, print_bool_value, set_bool},
	/* 64 */{ localKind, "_L4", 4, (&input_ctx.C_Counter_0__pwlinear_0._L4), 0, valid, print_int_value, set_int},
	/* 65 */{ localKind, "_L12", 4, (&input_ctx.C_Counter_0__pwlinear_0._L12), 0, valid, print_int_value, set_int},
	/* 66 */{ localKind, "_L18", 4, (&input_ctx.C_Counter_0__pwlinear_0._L18), 0, valid, print_int_value, set_int},
	/* 67 */{ localKind, "_L45", 4, (&input_ctx.C_Counter_0__pwlinear_0._L45), 0, valid, print_int_value, set_int}
};

const int nb_obs_vars=67;
const int nb_root_inputs=1;
const int nb_root_outputs=1;
/*
 * States & Transitions
 */
const void* dummy = 0;

automaton_var automaton_vars[]={
	0};

const int nb_automaton_vars=0;

/*
 * Conditionnal Blocks
 */

condblock_var condblock_vars[]={
	0};

const int nb_condblock_vars=0;

/*
 * Returns VTable reference from type name
 */
struct SimTypeVTable* SsmGetTypeVTable(const char* pszName){
  if (!strcmp("int", pszName)) return pSimLongVTable;
  else if (!strcmp("real", pszName)) return pSimDoubleVTable;
  else if (!strcmp("bool", pszName)) return pSimBoolVTable;
  else if (!strcmp("char", pszName)) return pSimCharVTable;
	else if (!strcmp("ControlDataType", pszName)) return pSimControlDataType__simulationVTable;
	else if (!strcmp("DisplayDataType", pszName)) return pSimDisplayDataType__simulationVTable;
	else if (!strcmp("struct_2", pszName)) return pSimstruct_2VTable;
	else if (!strcmp("struct_1", pszName)) return pSimstruct_1VTable;
  else return NULL;
}

static void print_value_type(value* __v){
  int i =0 ;
  switch(__v->kind){
    case intType:
      print_string("int");
      break;
    case charType:
      print_string("char");
      break;
    case boolType:
      print_string("bool");
      break;
    case realType:
      print_string("real");
      break;
    case tupleType:
      print_char('(');
      for(i=0;i<__v->u.a_tuple.count;i++){
        print_value_type(__v->u.a_tuple.items[i]);
        if (i<__v->u.a_tuple.count-1)
          print_string(", ");
      }
      print_char(')');
      break;
    default:
      print_string("Unknown type\n");
      break;
  }
}

void print_undefined(void){
    print_string("n/a");
}


/*
 * Cyclic function encapsulation
 */

void SIM_init(void){
/*
 * Initialise the base type tanslation function set table
 */
  init_stdtypes_table();

/*
 * Context initialization
 */
  input_ctx = input_ctx0;
	SAO_controlData = SAO_controlData_tmp;
railway__simulation_init(&input_ctx);
}

int SIM_step(void){

  railway__simulation_cycle(&SAO_controlData,  &input_ctx);
  trace_step();
  return 1;

}

