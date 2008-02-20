#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "testnode_types.h"
#include "testnode_interface.h"
#include "SmuDefaults.h"

#define OBS_VAR(I) ((obs_var*) &obs_vars[I])
const int  rt_version = Srtv51; const char* version = "KCG Version 4.2.0 (build i20)";
const char* root_node = "testnode";
const char* exp_mode = "noexp @ALL@";
const char* intern_suffix = "_testnode";
const char* input_sig = "I B R (I,I,I,I,I,I,I,I,I,I) (I,R,B,I)";

const char* var_names[]={
  /* 0 */ "in_int",
  /* 1 */ "in_bool",
  /* 2 */ "in_real",
  /* 3 */ "int_intarray",
  /* 4 */ "guiControlData",
  /* 5 */ "out_int",
  /* 6 */ "out_bool",
  /* 7 */ "out_real",
  /* 8 */ "out_intarray",
  /* 9 */ "guiDisplayData"
};

/*
 * Simulation context
 */

_C_testnode input_ctxt;
static _C_testnode input_ctxt0;


static intArray10 tmp_0;
static const intArray10 tmp_0_init;
static guiControlData tmp_1;
static const guiControlData tmp_1_init;


const context contexts[]={
    { &tmp_0, sizeof(tmp_0) },
    { &tmp_1, sizeof(tmp_1) },
    { &input_ctxt, sizeof(input_ctxt) },
    0,
};


obs_var obs_vars[]={
  { rootInputKind, 0, "_I0_in_int", 1, 31, 1, &get_0 },
  { rootInputKind, 1, "_I1_in_bool", 2, 31, 1, &get_1 },
  { rootInputKind, 2, "_I2_in_real", 3, 32, 1, &get_2 },
  { rootInputKind, 3, "_I3_int_intarray", 4, 32, 1, &tmp_0 },
  { rootInputKind, 4, "_I4_guiControlData", 5, 32, 1, &tmp_1 },
  { rootOutputKind, 5, "_O0_out_int", 1, 33, 1, &get_5 },
  { rootOutputKind, 6, "_O1_out_bool", 2, 33, 1, &get_6 },
  { rootOutputKind, 7, "_O2_out_real", 3, 34, 1, &get_7 },
  { rootOutputKind, 8, "_O3_out_intarray", 4, 34, 1, &get_8 },
  { rootOutputKind, 9, "_O4_guiDisplayData", 6, 34, 1, &get_9 },
};

const nodeStruct nodes[]={
  { "testnode", Node_notExpanded | Node_isRoot },
  { "_TO_guiDisplayData", Node_expanded },
  { "_FROM_guiControlData", Node_expanded }
};

const char* file_names[]={
  "scade_example.lus"
};

const char* type_signatures[]={
  "I",
  "B",
  "R",
  "(I,I,I,I,I,I,I,I,I,I)",
  "(I,R,B,I)",
  "(I)"
};

const int nb_nodes=3;
const int nb_obs_vars=10;
const int nb_root_inputs=5;
const int instrumentedCCode=0;

/*
 * Returns VTable reference from type name
 */
struct SimTypeVTable* SsmGetTypeVTable(const char* pszName){
  if (!strcmp("int", pszName)) return pSimLongVTable;
  else if (!strcmp("real", pszName)) return pSimDoubleVTable;
  else if (!strcmp("bool", pszName)) return pSimBoolVTable;
  else if (!strcmp("char", pszName)) return pSimCharVTable;
  else if (!strcmp("intArray10", pszName)) return pSimintArray10VTable;
  else if (!strcmp("guiControlData", pszName)) return pSimguiControlDataVTable;
  else if (!strcmp("states", pszName)) return pSimstatesVTable;
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
  OBS_VAR(0)->table = pSimLongVTable;
  OBS_VAR(1)->table = pSimBoolVTable;
  OBS_VAR(2)->table = pSimDoubleVTable;
  OBS_VAR(3)->table = pSimintArray10VTable;
  OBS_VAR(4)->table = pSimguiControlDataVTable;
  OBS_VAR(5)->table = pSimLongVTable;
  OBS_VAR(6)->table = pSimBoolVTable;
  OBS_VAR(7)->table = pSimDoubleVTable;
  OBS_VAR(8)->table = pSimintArray10VTable;
  OBS_VAR(9)->table = pSimguiDisplayDataVTable;
/*
 * Context initialization
 */
  input_ctxt = input_ctxt0;
  tmp_0 = tmp_0_init;
  input_ctxt._I3_int_intarray = &tmp_0;
  tmp_1 = tmp_1_init;
  input_ctxt._I4_guiControlData = &tmp_1;
  testnode_init(&input_ctxt);
}

void restore_context(void) {
  input_ctxt._I3_int_intarray = &tmp_0;
  input_ctxt._I4_guiControlData = &tmp_1;
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
    if(hashkey<=27){ /*[0,27]*/
      if(hashkey<=13){ /*[0,13]*/
        if(hashkey==13){
          if(!(strcmp(var_name, var_names[0]))){
            error = 0;
            print_int_value(get_0);
          }
        }
      }
      else{ /*[14,27]*/
        if(hashkey<=20){ /*[14,20]*/
          if(hashkey==15){
            if(!(strcmp(var_name, var_names[7]))){
              error = 0;
              print_real_value(get_7);
            }
          }
        }
        else{ /*[21,27]*/
          if(hashkey==27){
            if(!(strcmp(var_name, var_names[8]))){
              error = 0;
              print_intArray10_value(get_8);
            }
          }
        }
      }
    }
    else{ /*[28,54]*/
      if(hashkey==34){
        if(!(strcmp(var_name, var_names[5]))){
          error = 0;
          print_int_value(get_5);
        }
      }
    }
  }
  else{ /*[55,109]*/
    if(hashkey<=82){ /*[55,82]*/
      if(hashkey<=68){ /*[55,68]*/
        if(hashkey<=61){ /*[55,61]*/
          if(hashkey==60){
            if(!(strcmp(var_name, var_names[3]))){
              error = 0;
              print_intArray10_value(*get_3);
            }
          }
        }
        else{ /*[62,68]*/
          if(hashkey==68){
            if(!(strcmp(var_name, var_names[6]))){
              error = 0;
              print_bool_value(get_6);
            }
          }
        }
      }
      else{ /*[69,82]*/
        if(hashkey==70){
          if(!(strcmp(var_name, var_names[9]))){
            error = 0;
            print_guiDisplayData_value(get_9);
          }
        }
      }
    }
    else{ /*[83,109]*/
      if(hashkey<=96){ /*[83,96]*/
        if(hashkey<=89){ /*[83,89]*/
          if(hashkey<=86){ /*[83,86]*/
            if(hashkey>=85){ /*[85,86]*/
              if(hashkey==85){ /*[85]*/
                  if(!(strcmp(var_name, var_names[4]))){
                    error = 0;
                    print_guiControlData_value(*get_4);
                  }
              }
              else{ /*[86]*/
                  if(!(strcmp(var_name, var_names[1]))){
                    error = 0;
                    print_bool_value(get_1);
                  }
              }
            }
          }
          else{ /*[87,89]*/
          }
        }
        else{ /*[90,96]*/
        }
      }
      else{ /*[97,109]*/
        if(hashkey==99){
          if(!(strcmp(var_name, var_names[2]))){
            error = 0;
            print_real_value(get_2);
          }
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

  if(hashkey<=54){ /*[0,54]*/
    if(hashkey==13){
      if(!(strcmp(var_name, var_names[0]))){
        error = ! set_int(__v, &get_0);
        if(error){
          display_error (var_name, (void(*)(void))print_int_type, __v);
        }
      }
    }
  }
  else{ /*[55,109]*/
    if(hashkey<=82){ /*[55,82]*/
      if(hashkey==60){
        if(!(strcmp(var_name, var_names[3]))){
          error = ! set_intArray10(__v, get_3);
          if(error){
            display_error (var_name, (void(*)(void))print_intArray10_type, __v);
          }
        }
      }
    }
    else{ /*[83,109]*/
      if(hashkey<=96){ /*[83,96]*/
        if(hashkey<=89){ /*[83,89]*/
          if(hashkey<=86){ /*[83,86]*/
            if(hashkey>=85){ /*[85,86]*/
              if(hashkey==85){ /*[85]*/
                  if(!(strcmp(var_name, var_names[4]))){
                    error = ! set_guiControlData(__v, get_4);
                    if(error){
                      display_error (var_name, (void(*)(void))print_guiControlData_type, __v);
                    }
                  }
              }
              else{ /*[86]*/
                  if(!(strcmp(var_name, var_names[1]))){
                    error = ! set_bool(__v, &get_1);
                    if(error){
                      display_error (var_name, (void(*)(void))print_bool_type, __v);
                    }
                  }
              }
            }
          }
          else{ /*[87,89]*/
          }
        }
        else{ /*[90,96]*/
        }
      }
      else{ /*[97,109]*/
        if(hashkey==99){
          if(!(strcmp(var_name, var_names[2]))){
            error = ! set_real(__v, &get_2);
            if(error){
              display_error (var_name, (void(*)(void))print_real_type, __v);
            }
          }
        }
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

