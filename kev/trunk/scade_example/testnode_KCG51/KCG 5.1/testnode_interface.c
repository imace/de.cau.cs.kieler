#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "testnode_types.h"
#include "testnode_interface.h"
#include "SmuDefaults.h"

#define OBS_VAR(I) ((obs_var*) &obs_vars[I])
const int  rt_version = Srtv51; const char* version = "KCG Version 5.1.0 (build i4)";
const char* root_node = "testnode";
const char* exp_mode = "noexp @ALL@";
const char* intern_suffix = "_testnode";
const char* input_sig = "(I,R,B)";

const char* var_names[]={
  /* 0 */ "guiControlData",
  /* 1 */ "guiDisplayData",
  /* 2 */ "Counter_0 1/Incr",
  /* 3 */ "Counter_0 1/Reset",
  /* 4 */ "Counter_0 1/Count"
};

/*
 * Simulation context
 */

_C_testnode input_ctxt;
static _C_testnode input_ctxt0;


static guiControlData tmp_0;
static const guiControlData tmp_0_init;


const context contexts[]={
    { &tmp_0, sizeof(tmp_0) },
    { &input_ctxt, sizeof(input_ctxt) },
    0,
};


obs_var obs_vars[]={
  { rootInputKind, 0, "_I0_guiControlData", 1, 46, 1, &tmp_0 },
  { rootOutputKind, 1, "_O0_guiDisplayData", 2, 47, 1, &get_1 },
  { inputKind, 2, "_I0_Incr", 3, 31, 1, &get_2 },
  { inputKind, 3, "_I1_Reset", 4, 31, 1, &get_3 },
  { outputKind, 4, "_O0_Count", 3, 32, 1, &get_4 },
};

const nodeStruct nodes[]={
  { "testnode", Node_notExpanded | Node_isRoot },
  { "_TO_guiDisplayData", Node_expanded },
  { "_FROM_guiControlData", Node_expanded },
  { "Counter_0", Node_notExpanded }
};

const char* file_names[]={
  "scade_example.lus"
};

const char* type_signatures[]={
  "(I,R,B)",
  "(I)",
  "I",
  "B"
};

const int nb_nodes=4;
const int nb_obs_vars=5;
const int nb_root_inputs=1;
const int instrumentedCCode=0;

/*
 * Returns VTable reference from type name
 */
struct SimTypeVTable* SsmGetTypeVTable(const char* pszName){
  if (!strcmp("int", pszName)) return pSimLongVTable;
  else if (!strcmp("real", pszName)) return pSimDoubleVTable;
  else if (!strcmp("bool", pszName)) return pSimBoolVTable;
  else if (!strcmp("char", pszName)) return pSimCharVTable;
  else if (!strcmp("guiControlData", pszName)) return pSimguiControlDataVTable;
  else if (!strcmp("guiDisplayData", pszName)) return pSimguiDisplayDataVTable;
  else return NULL;
}

const int primeNumber = 109;

int HPJW (char* s){
  char* p= NULL;
  unsigned h = 0, g;
  for(p=s;*p!='\0'; p++){
    h = (h<<4)+(*p);
    if((g=h & 0xF0000000)!=0){
      h = h^(g>>24);
      h = h^g;
    }
  }
  return h%primeNumber;
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
        if(i<__v->u.a_tuple.count-1)
          print_string(", ");
      }
      print_char(')');
      break;
    default:
      print_string("Unknown type\n");
      break;
  }
}

static void display_error(char* var_name, void(*print_type_fct)(void), value* __v){
   print_string("Type check error. Type of ");
   print_string(var_name);
   print_string(" is : ");
   print_type_fct();
   print_char('\n');
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
 * Link variables with translation function set
 */
  OBS_VAR(0)->table = pSimguiControlDataVTable;
  OBS_VAR(1)->table = pSimguiDisplayDataVTable;
  OBS_VAR(2)->table = pSimLongVTable;
  OBS_VAR(3)->table = pSimBoolVTable;
  OBS_VAR(4)->table = pSimLongVTable;
/*
 * Context initialization
 */
  input_ctxt = input_ctxt0;
  tmp_0 = tmp_0_init;
  input_ctxt._I0_guiControlData = &tmp_0;
  testnode_init(&input_ctxt);
}

void restore_context(void) {
  input_ctxt._I0_guiControlData = &tmp_0;
}

int SIM_step(void){
  testnode(&input_ctxt);
  trace_step();
  return 1;
}

#ifdef _MSC_VER
#pragma optimize( "", off )
#endif

int print_value(char *var_name){
  int index = -1;
  int error = 2;
  int hashkey = HPJW(var_name);

  if(hashkey<=54){ /*[0,54]*/
    if(hashkey==47){
      if(!(strcmp(var_name, var_names[4]))){
        error = 0;
        print_int_value(get_4);
      }
    }
  }
  else{ /*[55,109]*/
    if(hashkey<=82){ /*[55,82]*/
      if(hashkey<=68){ /*[55,68]*/
        if(hashkey==65){
          if(!(strcmp(var_name, var_names[2]))){
            error = 0;
            print_int_value(get_2);
          }
        }
      }
      else{ /*[69,82]*/
        if(hashkey<=75){ /*[69,75]*/
          if(hashkey==70){
            if(!(strcmp(var_name, var_names[1]))){
              error = 0;
              print_guiDisplayData_value(get_1);
            }
          }
        }
        else{ /*[76,82]*/
          if(hashkey==81){
            if(!(strcmp(var_name, var_names[3]))){
              error = 0;
              print_bool_value(get_3);
            }
          }
        }
      }
    }
    else{ /*[83,109]*/
      if(hashkey==85){
        if(!(strcmp(var_name, var_names[0]))){
          error = 0;
          print_guiControlData_value(*get_0);
        }
      }
    }
  }
  switch (error) {
    case 2 :
      print_string("Unknown or unobservable variable.");
    default :
      break;
    }

  return error;
}

#ifdef _MSC_VER
#pragma optimize( "", on )
#endif

/*
 * modifying
 */

#ifdef _MSC_VER
#pragma optimize( "", off )
#endif

int set_value(char *var_name, value* __v){
  int error = 2;
  int hashkey = HPJW(var_name);

  if(hashkey==85){
    if(!(strcmp(var_name, var_names[0]))){
      error = ! set_guiControlData(__v, get_0);
      if(error){
        display_error (var_name, (void(*)(void))print_guiControlData_type, __v);
      }
    }
  }
  if(error==2){
    print_string("Unknown or unobservable variable.");
  }

  return error;
}

#ifdef _MSC_VER
#pragma optimize( "", on )
#endif

