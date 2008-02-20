#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "Elevator_types.h"
#include "Elevator_interface.h"
#include "SmuDefaults.h"

#define OBS_VAR(I) ((obs_var*) &obs_vars[I])
const int  rt_version = Srtv51; const char* version = "KCG Version 5.1.0 (build i4)";
const char* root_node = "Elevator";
const char* exp_mode = "noexp @ALL@";
const char* intern_suffix = "_Elevator";
const char* input_sig = "(B,B,B)";

const char* var_names[]={
  /* 0 */ "guiControlData",
  /* 1 */ "guDisplayData",
  /* 2 */ "_L5_Elevator",
  /* 3 */ "_L9_Elevator",
  /* 4 */ "_L15_Elevator",
  /* 5 */ "_L16_Elevator",
  /* 6 */ "_L17_Elevator",
  /* 7 */ "_L18_Elevator",
  /* 8 */ "_L19_Elevator",
  /* 9 */ "_L20_Elevator",
  /* 10 */ "_L23_Elevator",
  /* 11 */ "_L24_Elevator",
  /* 12 */ "_L25_Elevator",
  /* 13 */ "_L28_Elevator",
  /* 14 */ "_L27_Elevator",
  /* 15 */ "_L26_Elevator",
  /* 16 */ "_L33_Elevator",
  /* 17 */ "Second 1/Second",
  /* 18 */ "Second 1/_L2_Elevator",
  /* 19 */ "Second 1/_L3_Elevator",
  /* 20 */ "Second 1/_L4_Elevator",
  /* 21 */ "Second 1/ClockCounter 1/Reset",
  /* 22 */ "Second 1/ClockCounter 1/Count",
  /* 23 */ "Second 1/ClockCounter 1/_L1_Elevator",
  /* 24 */ "Second 1/ClockCounter 1/_L2_Elevator",
  /* 25 */ "Second 1/ClockCounter 1/_L7_Elevator",
  /* 26 */ "Second 1/ClockCounter 1/_L8_Elevator",
  /* 27 */ "Second 1/ClockCounter 1/_L11_Elevator",
  /* 28 */ "Second 1/ClockCounter 1/_L13_Elevator",
  /* 29 */ "Second 1/ClockCounter 1/_L16_Elevator",
  /* 30 */ "Position 1/Motor",
  /* 31 */ "Position 1/Position",
  /* 32 */ "Position 1/_L2_Elevator",
  /* 33 */ "Controller 1/ButtonUp",
  /* 34 */ "Controller 1/ButtonDown",
  /* 35 */ "Controller 1/ButtonAlarm",
  /* 36 */ "Controller 1/Second",
  /* 37 */ "Controller 1/IsUp",
  /* 38 */ "Controller 1/IsDown",
  /* 39 */ "Controller 1/Move",
  /* 40 */ "Controller 1/AlarmLamp",
  /* 41 */ "Controller 1/OpenDoor",
  /* 42 */ "Controller 1/_LE0_Elevator",
  /* 43 */ "Controller 1/_LE3_Elevator",
  /* 44 */ "Controller 1/_LE4_Elevator",
  /* 45 */ "Controller 1/_LE6_Elevator",
  /* 46 */ "Controller 1/_LE7_Elevator",
  /* 47 */ "Controller 1/_LE8_Elevator",
  /* 48 */ "Controller 1/_LE9_Elevator",
  /* 49 */ "Controller 1/_LE10_Elevator",
  /* 50 */ "Controller 1/_LE11_Elevator",
  /* 51 */ "Controller 1/_LE12_Elevator",
  /* 52 */ "Controller 1/_LE13_Elevator",
  /* 53 */ "Controller 1/_LE14_Elevator",
  /* 54 */ "Controller 1/_LE15_Elevator",
  /* 55 */ "Controller 1/_LE16_Elevator",
  /* 56 */ "Controller 1/_LE17_Elevator",
  /* 57 */ "Controller 1/_LE18_Elevator",
  /* 58 */ "Controller 1/_LE19_Elevator",
  /* 59 */ "Controller 1/_LE20_Elevator",
  /* 60 */ "Controller 1/_LE21_Elevator",
  /* 61 */ "Controller 1/_LE22_Elevator",
  /* 62 */ "Controller 1/_LE23_Elevator",
  /* 63 */ "Controller 1/_LE24_Elevator",
  /* 64 */ "Controller 1/_LE25_Elevator",
  /* 65 */ "Controller 1/_LE26_Elevator",
  /* 66 */ "Controller 1/_LE27_Elevator",
  /* 67 */ "Controller 1/_LE28_Elevator",
  /* 68 */ "Controller 1/_LVF0_Elevator",
  /* 69 */ "Controller 1/_LE29_Elevator",
  /* 70 */ "Controller 1/_LVF2_Elevator",
  /* 71 */ "Controller 1/_LVF4_Elevator",
  /* 72 */ "Controller 1/_LVF5_Elevator",
  /* 73 */ "Controller 1/_LVF6_Elevator",
  /* 74 */ "KeepDoorOpen 1/Second",
  /* 75 */ "KeepDoorOpen 1/OpenDoor",
  /* 76 */ "KeepDoorOpen 1/DoorIsOpen",
  /* 77 */ "KeepDoorOpen 1/_L1_Elevator",
  /* 78 */ "KeepDoorOpen 1/_L2_Elevator",
  /* 79 */ "KeepDoorOpen 1/_L17_Elevator"
};

/*
 * Simulation context
 */

_C_Elevator input_ctxt;
static _C_Elevator input_ctxt0;


static guiControlData tmp_0;
static const guiControlData tmp_0_init;


const context contexts[]={
    { &tmp_0, sizeof(tmp_0) },
    { &input_ctxt, sizeof(input_ctxt) },
    0,
};


obs_var obs_vars[]={
  { rootInputKind, 0, "_I0_guiControlData", 1, 185, 1, &tmp_0 },
  { rootOutputKind, 1, "_O0_guDisplayData", 2, 186, 1, &get_1 },
  { inputKind, 21, "_I0_Reset", 3, 22, 1, &get_21 },
  { inputKind, 30, "_I0_Motor", 4, 258, 1, &get_30 },
  { inputKind, 33, "_I0_ButtonUp", 3, 58, 1, &get_33 },
  { inputKind, 34, "_I1_ButtonDown", 3, 58, 1, &get_34 },
  { inputKind, 35, "_I2_ButtonAlarm", 3, 59, 1, &get_35 },
  { inputKind, 36, "_I3_Second", 3, 59, 1, &get_36 },
  { inputKind, 37, "_I4_IsUp", 3, 59, 1, &get_37 },
  { inputKind, 38, "_I5_IsDown", 3, 60, 1, &get_38 },
  { inputKind, 74, "_I0_Second", 3, 237, 1, &get_74 },
  { inputKind, 75, "_I1_OpenDoor", 3, 237, 1, &get_75 },
  { outputKind, 17, "_O0_Second", 3, 277, 1, &get_17 },
  { outputKind, 22, "_O0_Count", 4, 23, 1, &get_22 },
  { outputKind, 31, "_O0_Position", 4, 259, 1, &get_31 },
  { outputKind, 39, "_O0_Move", 4, 61, 1, &get_39 },
  { outputKind, 40, "_O1_AlarmLamp", 3, 61, 1, &get_40 },
  { outputKind, 41, "_O2_OpenDoor", 3, 62, 1, &get_41 },
  { outputKind, 76, "_O0_DoorIsOpen", 3, 238, 1, &get_76 },
  { localKind, 2, "_L5_Elevator", 4, 189, 1, &get_2 },
  { localKind, 3, "_L9_Elevator", 4, 190, 1, &get_3 },
  { localKind, 4, "_L15_Elevator", 3, 191, 1, &get_4 },
  { localKind, 5, "_L16_Elevator", 3, 192, 1, &get_5 },
  { localKind, 6, "_L17_Elevator", 3, 193, 1, &get_6 },
  { localKind, 7, "_L18_Elevator", 4, 194, 1, &get_7 },
  { localKind, 8, "_L19_Elevator", 4, 195, 1, &get_8 },
  { localKind, 9, "_L20_Elevator", 3, 196, 1, &get_9 },
  { localKind, 10, "_L23_Elevator", 3, 198, 1, &get_10 },
  { localKind, 11, "_L24_Elevator", 3, 199, 1, &get_11 },
  { localKind, 12, "_L25_Elevator", 1, 200, 1, &get_12 },
  { localKind, 13, "_L28_Elevator", 3, 201, 1, &get_13 },
  { localKind, 14, "_L27_Elevator", 3, 202, 1, &get_14 },
  { localKind, 15, "_L26_Elevator", 3, 203, 1, &get_15 },
  { localKind, 16, "_L33_Elevator", 2, 204, 1, &get_16 },
  { localKind, 18, "_L2_Elevator", 4, 280, 1, &get_18 },
  { localKind, 19, "_L3_Elevator", 3, 281, 1, &get_19 },
  { localKind, 20, "_L4_Elevator", 4, 282, 1, &get_20 },
  { localKind, 23, "_L1_Elevator", 4, 26, 1, &get_23 },
  { localKind, 24, "_L2_Elevator", 4, 27, 1, &get_24 },
  { localKind, 25, "_L7_Elevator", 4, 29, 1, &get_25 },
  { localKind, 26, "_L8_Elevator", 4, 30, 1, &get_26 },
  { localKind, 27, "_L11_Elevator", 4, 31, 1, &get_27 },
  { localKind, 28, "_L13_Elevator", 3, 32, 1, &get_28 },
  { localKind, 29, "_L16_Elevator", 4, 33, 1, &get_29 },
  { localKind, 32, "_L2_Elevator", 4, 263, 1, &get_32 },
  { localKind, 42, "_LE0_Elevator", 3, 65, 1, &get_42 },
  { localKind, 43, "_LE3_Elevator", 3, 68, 1, &get_43 },
  { localKind, 44, "_LE4_Elevator", 3, 69, 1, &get_44 },
  { localKind, 45, "_LE6_Elevator", 3, 71, 1, &get_45 },
  { localKind, 46, "_LE7_Elevator", 3, 72, 1, &get_46 },
  { localKind, 47, "_LE8_Elevator", 3, 73, 1, &get_47 },
  { localKind, 48, "_LE9_Elevator", 3, 74, 1, &get_48 },
  { localKind, 49, "_LE10_Elevator", 3, 75, 1, &get_49 },
  { localKind, 50, "_LE11_Elevator", 3, 76, 1, &get_50 },
  { localKind, 51, "_LE12_Elevator", 3, 77, 1, &get_51 },
  { localKind, 52, "_LE13_Elevator", 3, 78, 1, &get_52 },
  { localKind, 53, "_LE14_Elevator", 3, 79, 1, &get_53 },
  { localKind, 54, "_LE15_Elevator", 3, 80, 1, &get_54 },
  { localKind, 55, "_LE16_Elevator", 3, 81, 1, &get_55 },
  { localKind, 56, "_LE17_Elevator", 3, 82, 1, &get_56 },
  { localKind, 57, "_LE18_Elevator", 3, 83, 1, &get_57 },
  { localKind, 58, "_LE19_Elevator", 3, 84, 1, &get_58 },
  { localKind, 59, "_LE20_Elevator", 3, 85, 1, &get_59 },
  { localKind, 60, "_LE21_Elevator", 3, 86, 1, &get_60 },
  { localKind, 61, "_LE22_Elevator", 3, 87, 1, &get_61 },
  { localKind, 62, "_LE23_Elevator", 3, 88, 1, &get_62 },
  { localKind, 63, "_LE24_Elevator", 3, 89, 1, &get_63 },
  { localKind, 64, "_LE25_Elevator", 3, 90, 1, &get_64 },
  { localKind, 65, "_LE26_Elevator", 3, 91, 1, &get_65 },
  { localKind, 66, "_LE27_Elevator", 3, 92, 1, &get_66 },
  { localKind, 67, "_LE28_Elevator", 3, 93, 1, &get_67 },
  { localKind, 68, "_LVF0_Elevator", 4, 94, 1, &get_68 },
  { localKind, 69, "_LE29_Elevator", 3, 95, 1, &get_69 },
  { localKind, 70, "_LVF2_Elevator", 4, 96, 1, &get_70 },
  { localKind, 71, "_LVF4_Elevator", 4, 98, 1, &get_71 },
  { localKind, 72, "_LVF5_Elevator", 4, 99, 1, &get_72 },
  { localKind, 73, "_LVF6_Elevator", 4, 100, 1, &get_73 },
  { localKind, 77, "_L1_Elevator", 3, 241, 1, &get_77 },
  { localKind, 78, "_L2_Elevator", 3, 242, 1, &get_78 },
  { localKind, 79, "_L17_Elevator", 3, 243, 1, &get_79 },
};

const nodeStruct nodes[]={
  { "Elevator", Node_notExpanded | Node_isRoot },
  { "Controller", Node_notExpanded },
  { "Position", Node_notExpanded },
  { "Second", Node_notExpanded },
  { "ClockCounter", Node_notExpanded },
  { "KeepDoorOpen", Node_notExpanded },
  { "_FROM_guiControlData", Node_expanded },
  { "_TO_guiDisplayData", Node_expanded }
};

const char* file_names[]={
  "Elevator.lus"
};

const char* type_signatures[]={
  "(B,B,B)",
  "(I,B,I,B)",
  "B",
  "I"
};

const int nb_nodes=8;
const int nb_obs_vars=80;
const int nb_root_inputs=1;
const int instrumentedCCode=1;

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

const int primeNumber = 907;

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
  OBS_VAR(21)->table = pSimBoolVTable;
  OBS_VAR(30)->table = pSimLongVTable;
  OBS_VAR(33)->table = pSimBoolVTable;
  OBS_VAR(34)->table = pSimBoolVTable;
  OBS_VAR(35)->table = pSimBoolVTable;
  OBS_VAR(36)->table = pSimBoolVTable;
  OBS_VAR(37)->table = pSimBoolVTable;
  OBS_VAR(38)->table = pSimBoolVTable;
  OBS_VAR(74)->table = pSimBoolVTable;
  OBS_VAR(75)->table = pSimBoolVTable;
  OBS_VAR(17)->table = pSimBoolVTable;
  OBS_VAR(22)->table = pSimLongVTable;
  OBS_VAR(31)->table = pSimLongVTable;
  OBS_VAR(39)->table = pSimLongVTable;
  OBS_VAR(40)->table = pSimBoolVTable;
  OBS_VAR(41)->table = pSimBoolVTable;
  OBS_VAR(76)->table = pSimBoolVTable;
  OBS_VAR(2)->table = pSimLongVTable;
  OBS_VAR(3)->table = pSimLongVTable;
  OBS_VAR(4)->table = pSimBoolVTable;
  OBS_VAR(5)->table = pSimBoolVTable;
  OBS_VAR(6)->table = pSimBoolVTable;
  OBS_VAR(7)->table = pSimLongVTable;
  OBS_VAR(8)->table = pSimLongVTable;
  OBS_VAR(9)->table = pSimBoolVTable;
  OBS_VAR(10)->table = pSimBoolVTable;
  OBS_VAR(11)->table = pSimBoolVTable;
  OBS_VAR(12)->table = pSimguiControlDataVTable;
  OBS_VAR(13)->table = pSimBoolVTable;
  OBS_VAR(14)->table = pSimBoolVTable;
  OBS_VAR(15)->table = pSimBoolVTable;
  OBS_VAR(16)->table = pSimguiDisplayDataVTable;
  OBS_VAR(18)->table = pSimLongVTable;
  OBS_VAR(19)->table = pSimBoolVTable;
  OBS_VAR(20)->table = pSimLongVTable;
  OBS_VAR(23)->table = pSimLongVTable;
  OBS_VAR(24)->table = pSimLongVTable;
  OBS_VAR(25)->table = pSimLongVTable;
  OBS_VAR(26)->table = pSimLongVTable;
  OBS_VAR(27)->table = pSimLongVTable;
  OBS_VAR(28)->table = pSimBoolVTable;
  OBS_VAR(29)->table = pSimLongVTable;
  OBS_VAR(32)->table = pSimLongVTable;
  OBS_VAR(42)->table = pSimBoolVTable;
  OBS_VAR(43)->table = pSimBoolVTable;
  OBS_VAR(44)->table = pSimBoolVTable;
  OBS_VAR(45)->table = pSimBoolVTable;
  OBS_VAR(46)->table = pSimBoolVTable;
  OBS_VAR(47)->table = pSimBoolVTable;
  OBS_VAR(48)->table = pSimBoolVTable;
  OBS_VAR(49)->table = pSimBoolVTable;
  OBS_VAR(50)->table = pSimBoolVTable;
  OBS_VAR(51)->table = pSimBoolVTable;
  OBS_VAR(52)->table = pSimBoolVTable;
  OBS_VAR(53)->table = pSimBoolVTable;
  OBS_VAR(54)->table = pSimBoolVTable;
  OBS_VAR(55)->table = pSimBoolVTable;
  OBS_VAR(56)->table = pSimBoolVTable;
  OBS_VAR(57)->table = pSimBoolVTable;
  OBS_VAR(58)->table = pSimBoolVTable;
  OBS_VAR(59)->table = pSimBoolVTable;
  OBS_VAR(60)->table = pSimBoolVTable;
  OBS_VAR(61)->table = pSimBoolVTable;
  OBS_VAR(62)->table = pSimBoolVTable;
  OBS_VAR(63)->table = pSimBoolVTable;
  OBS_VAR(64)->table = pSimBoolVTable;
  OBS_VAR(65)->table = pSimBoolVTable;
  OBS_VAR(66)->table = pSimBoolVTable;
  OBS_VAR(67)->table = pSimBoolVTable;
  OBS_VAR(68)->table = pSimLongVTable;
  OBS_VAR(69)->table = pSimBoolVTable;
  OBS_VAR(70)->table = pSimLongVTable;
  OBS_VAR(71)->table = pSimLongVTable;
  OBS_VAR(72)->table = pSimLongVTable;
  OBS_VAR(73)->table = pSimLongVTable;
  OBS_VAR(77)->table = pSimBoolVTable;
  OBS_VAR(78)->table = pSimBoolVTable;
  OBS_VAR(79)->table = pSimBoolVTable;
/*
 * Context initialization
 */
  input_ctxt = input_ctxt0;
  tmp_0 = tmp_0_init;
  input_ctxt._I0_guiControlData = &tmp_0;
  Elevator_init(&input_ctxt);
}

void restore_context(void) {
  input_ctxt._I0_guiControlData = &tmp_0;
}

int SIM_step(void){
  int result = 0;
  result = Elevator(&input_ctxt);
  if(result)
    trace_step();

  return result;
}

#ifdef _MSC_VER
#pragma optimize( "", off )
#endif

int print_value(char *var_name){
  int index = -1;
  int error = 2;
  int hashkey = HPJW(var_name);

  if(hashkey<=453){ /*[0,453]*/
    if(hashkey<=226){ /*[0,226]*/
      if(hashkey<=113){ /*[0,113]*/
        if(hashkey<=56){ /*[0,56]*/
          if(hashkey<=28){ /*[0,28]*/
            if(hashkey<=14){ /*[0,14]*/
              if(hashkey<=7){ /*[0,7]*/
                if(hashkey==7){
                  if(!(strcmp(var_name, var_names[70]))){
                    error = 0;
                    print_int_value(get_70);
                  }
                }
              }
              else{ /*[8,14]*/
                if(hashkey==13){
                  if(!(strcmp(var_name, var_names[38]))){
                    error = 0;
                    print_bool_value(get_38);
                  }
                }
              }
            }
            else{ /*[15,28]*/
            }
          }
          else{ /*[29,56]*/
            if(hashkey==54){ /*[54]*/
                if(!(strcmp(var_name, var_names[75]))){
                  error = 0;
                  print_bool_value(get_75);
                }
                else if(!(strcmp(var_name, var_names[11]))){
                  error = 0;
                  print_bool_value(get_11);
                }
            }
          }
        }
        else{ /*[57,113]*/
          if(hashkey<=85){ /*[57,85]*/
            if(hashkey<=71){ /*[57,71]*/
              if(hashkey==60){
                if(!(strcmp(var_name, var_names[22]))){
                  error = 0;
                  print_int_value(get_22);
                }
              }
            }
            else{ /*[72,85]*/
              if(hashkey>=79){ /*[79,85]*/
                if(hashkey<=82){ /*[79,82]*/
                  if(hashkey==81){
                    if(!(strcmp(var_name, var_names[60]))){
                      error = 0;
                      print_bool_value(get_60);
                    }
                  }
                }
                else{ /*[83,85]*/
                  if(hashkey==83){
                    if(!(strcmp(var_name, var_names[15]))){
                      error = 0;
                      print_bool_value(get_15);
                    }
                  }
                }
              }
            }
          }
          else{ /*[86,113]*/
            if(hashkey==112){
              if(!(strcmp(var_name, var_names[13]))){
                error = 0;
                print_bool_value(get_13);
              }
            }
          }
        }
      }
      else{ /*[114,226]*/
        if(hashkey<=170){ /*[114,170]*/
          if(hashkey<=142){ /*[114,142]*/
            if(hashkey<=128){ /*[114,128]*/
              if(hashkey<=121){ /*[114,121]*/
                if(hashkey==114){
                  if(!(strcmp(var_name, var_names[49]))){
                    error = 0;
                    print_bool_value(get_49);
                  }
                }
              }
              else{ /*[122,128]*/
                if(hashkey==127){
                  if(!(strcmp(var_name, var_names[23]))){
                    error = 0;
                    print_int_value(get_23);
                  }
                }
              }
            }
            else{ /*[129,142]*/
            }
          }
          else{ /*[143,170]*/
            if(hashkey<=156){ /*[143,156]*/
              if(hashkey<=149){ /*[143,149]*/
                if(hashkey<=146){ /*[143,146]*/
                  if(hashkey<=144){ /*[143,144]*/
                    if(hashkey==143){
                      if(!(strcmp(var_name, var_names[55]))){
                        error = 0;
                        print_bool_value(get_55);
                      }
                    }
                  }
                  else{ /*[145,146]*/
                    if(hashkey==145){
                      if(!(strcmp(var_name, var_names[43]))){
                        error = 0;
                        print_bool_value(get_43);
                      }
                    }
                  }
                }
                else{ /*[147,149]*/
                  if(hashkey==148){
                    if(!(strcmp(var_name, var_names[67]))){
                      error = 0;
                      print_bool_value(get_67);
                    }
                  }
                }
              }
              else{ /*[150,156]*/
                if(hashkey==155){
                  if(!(strcmp(var_name, var_names[19]))){
                    error = 0;
                    print_bool_value(get_19);
                  }
                }
              }
            }
            else{ /*[157,170]*/
            }
          }
        }
        else{ /*[171,226]*/
          if(hashkey<=198){ /*[171,198]*/
            if(hashkey<=184){ /*[171,184]*/
              if(hashkey<=177){ /*[171,177]*/
                if(hashkey<=174){ /*[171,174]*/
                  if(hashkey<=172){ /*[171,172]*/
                    if(hashkey==172){
                      if(!(strcmp(var_name, var_names[53]))){
                        error = 0;
                        print_bool_value(get_53);
                      }
                    }
                  }
                  else{ /*[173,174]*/
                    if(hashkey==173){ /*[173]*/
                        if(!(strcmp(var_name, var_names[31]))){
                          error = 0;
                          print_int_value(get_31);
                        }
                    }
                    else{ /*[174]*/
                        if(!(strcmp(var_name, var_names[48]))){
                          error = 0;
                          print_bool_value(get_48);
                        }
                    }
                  }
                }
                else{ /*[175,177]*/
                  if(hashkey==177){
                    if(!(strcmp(var_name, var_names[40]))){
                      error = 0;
                      print_bool_value(get_40);
                    }
                  }
                }
              }
              else{ /*[178,184]*/
              }
            }
            else{ /*[185,198]*/
              if(hashkey>=192){ /*[192,198]*/
                if(hashkey>=196){ /*[196,198]*/
                  if(hashkey<=197){ /*[196,197]*/
                    if(hashkey==196){ /*[196]*/
                        if(!(strcmp(var_name, var_names[37]))){
                          error = 0;
                          print_bool_value(get_37);
                        }
                    }
                    else{ /*[197]*/
                        if(!(strcmp(var_name, var_names[36]))){
                          error = 0;
                          print_bool_value(get_36);
                        }
                    }
                  }
                  else{ /*[198]*/
                  }
                }
              }
            }
          }
          else{ /*[199,226]*/
            if(hashkey<=212){ /*[199,212]*/
              if(hashkey==203){
                if(!(strcmp(var_name, var_names[46]))){
                  error = 0;
                  print_bool_value(get_46);
                }
              }
            }
            else{ /*[213,226]*/
              if(hashkey==215){
                if(!(strcmp(var_name, var_names[39]))){
                  error = 0;
                  print_int_value(get_39);
                }
              }
            }
          }
        }
      }
    }
    else{ /*[227,453]*/
      if(hashkey<=340){ /*[227,340]*/
        if(hashkey<=283){ /*[227,283]*/
          if(hashkey<=255){ /*[227,255]*/
            if(hashkey==228){
              if(!(strcmp(var_name, var_names[9]))){
                error = 0;
                print_bool_value(get_9);
              }
            }
          }
          else{ /*[256,283]*/
            if(hashkey==272){
              if(!(strcmp(var_name, var_names[72]))){
                error = 0;
                print_int_value(get_72);
              }
            }
          }
        }
        else{ /*[284,340]*/
          if(hashkey<=312){ /*[284,312]*/
            if(hashkey<=298){ /*[284,298]*/
              if(hashkey<=291){ /*[284,291]*/
                if(hashkey==290){
                  if(!(strcmp(var_name, var_names[4]))){
                    error = 0;
                    print_bool_value(get_4);
                  }
                }
              }
              else{ /*[292,298]*/
                if(hashkey==298){
                  if(!(strcmp(var_name, var_names[1]))){
                    error = 0;
                    print_guiDisplayData_value(get_1);
                  }
                }
              }
            }
            else{ /*[299,312]*/
            }
          }
          else{ /*[313,340]*/
            if(hashkey<=326){ /*[313,326]*/
              if(hashkey<=319){ /*[313,319]*/
                if(hashkey>=317){ /*[317,319]*/
                  if(hashkey<=318){ /*[317,318]*/
                    if(hashkey==317){
                      if(!(strcmp(var_name, var_names[51]))){
                        error = 0;
                        print_bool_value(get_51);
                      }
                    }
                  }
                  else{ /*[319]*/
                      if(!(strcmp(var_name, var_names[6]))){
                        error = 0;
                        print_bool_value(get_6);
                      }
                  }
                }
              }
              else{ /*[320,326]*/
                if(hashkey==326){
                  if(!(strcmp(var_name, var_names[29]))){
                    error = 0;
                    print_int_value(get_29);
                  }
                }
              }
            }
            else{ /*[327,340]*/
            }
          }
        }
      }
      else{ /*[341,453]*/
        if(hashkey<=397){ /*[341,397]*/
          if(hashkey<=369){ /*[341,369]*/
            if(hashkey<=355){ /*[341,355]*/
              if(hashkey<=348){ /*[341,348]*/
                if(hashkey>=345){ /*[345,348]*/
                  if(hashkey<=346){ /*[345,346]*/
                    if(hashkey==346){
                      if(!(strcmp(var_name, var_names[59]))){
                        error = 0;
                        print_bool_value(get_59);
                      }
                    }
                  }
                  else{ /*[347,348]*/
                    if(hashkey==348){
                      if(!(strcmp(var_name, var_names[8]))){
                        error = 0;
                        print_int_value(get_8);
                      }
                    }
                  }
                }
              }
              else{ /*[349,355]*/
              }
            }
            else{ /*[356,369]*/
              if(hashkey<=362){ /*[356,362]*/
                if(hashkey<=359){ /*[356,359]*/
                  if(hashkey==356){
                    if(!(strcmp(var_name, var_names[76]))){
                      error = 0;
                      print_bool_value(get_76);
                    }
                  }
                }
                else{ /*[360,362]*/
                  if(hashkey==360){
                    if(!(strcmp(var_name, var_names[17]))){
                      error = 0;
                      print_bool_value(get_17);
                    }
                  }
                }
              }
              else{ /*[363,369]*/
                if(hashkey==363){
                  if(!(strcmp(var_name, var_names[24]))){
                    error = 0;
                    print_int_value(get_24);
                  }
                }
              }
            }
          }
          else{ /*[370,397]*/
            if(hashkey<=383){ /*[370,383]*/
              if(hashkey<=376){ /*[370,376]*/
                if(hashkey==375){
                  if(!(strcmp(var_name, var_names[65]))){
                    error = 0;
                    print_bool_value(get_65);
                  }
                }
              }
              else{ /*[377,383]*/
                if(hashkey==379){
                  if(!(strcmp(var_name, var_names[34]))){
                    error = 0;
                    print_bool_value(get_34);
                  }
                }
              }
            }
            else{ /*[384,397]*/
            }
          }
        }
        else{ /*[398,453]*/
          if(hashkey<=425){ /*[398,425]*/
            if(hashkey<=411){ /*[398,411]*/
              if(hashkey==404){
                if(!(strcmp(var_name, var_names[63]))){
                  error = 0;
                  print_bool_value(get_63);
                }
              }
            }
            else{ /*[412,425]*/
              if(hashkey==423){
                if(!(strcmp(var_name, var_names[32]))){
                  error = 0;
                  print_int_value(get_32);
                }
              }
            }
          }
          else{ /*[426,453]*/
            if(hashkey<=439){ /*[426,439]*/
              if(hashkey==439){
                if(!(strcmp(var_name, var_names[47]))){
                  error = 0;
                  print_bool_value(get_47);
                }
              }
            }
            else{ /*[440,453]*/
              if(hashkey==450){
                if(!(strcmp(var_name, var_names[26]))){
                  error = 0;
                  print_int_value(get_26);
                }
              }
            }
          }
        }
      }
    }
  }
  else{ /*[454,907]*/
    if(hashkey<=680){ /*[454,680]*/
      if(hashkey<=567){ /*[454,567]*/
        if(hashkey<=510){ /*[454,510]*/
          if(hashkey<=482){ /*[454,482]*/
            if(hashkey==462){
              if(!(strcmp(var_name, var_names[57]))){
                error = 0;
                print_bool_value(get_57);
              }
            }
          }
          else{ /*[483,510]*/
            if(hashkey==493){
              if(!(strcmp(var_name, var_names[10]))){
                error = 0;
                print_bool_value(get_10);
              }
            }
          }
        }
        else{ /*[511,567]*/
          if(hashkey<=539){ /*[511,539]*/
            if(hashkey<=525){ /*[511,525]*/
              if(hashkey==522){
                if(!(strcmp(var_name, var_names[12]))){
                  error = 0;
                  print_guiControlData_value(get_12);
                }
              }
            }
            else{ /*[526,539]*/
              if(hashkey==527){
                if(!(strcmp(var_name, var_names[35]))){
                  error = 0;
                  print_bool_value(get_35);
                }
              }
            }
          }
          else{ /*[540,567]*/
            if(hashkey<=553){ /*[540,553]*/
              if(hashkey>=547){ /*[547,553]*/
                if(hashkey<=550){ /*[547,550]*/
                  if(hashkey==549){
                    if(!(strcmp(var_name, var_names[61]))){
                      error = 0;
                      print_bool_value(get_61);
                    }
                  }
                }
                else{ /*[551,553]*/
                  if(hashkey==551){
                    if(!(strcmp(var_name, var_names[14]))){
                      error = 0;
                      print_bool_value(get_14);
                    }
                  }
                }
              }
            }
            else{ /*[554,567]*/
            }
          }
        }
      }
      else{ /*[568,680]*/
        if(hashkey<=624){ /*[568,624]*/
          if(hashkey<=596){ /*[568,596]*/
            if(hashkey<=582){ /*[568,582]*/
              if(hashkey<=575){ /*[568,575]*/
                if(hashkey==574){
                  if(!(strcmp(var_name, var_names[2]))){
                    error = 0;
                    print_int_value(get_2);
                  }
                }
              }
              else{ /*[576,582]*/
                if(hashkey==582){
                  if(!(strcmp(var_name, var_names[54]))){
                    error = 0;
                    print_bool_value(get_54);
                  }
                }
              }
            }
            else{ /*[583,596]*/
              if(hashkey<=589){ /*[583,589]*/
                if(hashkey==584){
                  if(!(strcmp(var_name, var_names[45]))){
                    error = 0;
                    print_bool_value(get_45);
                  }
                }
              }
              else{ /*[590,596]*/
                if(hashkey==594){
                  if(!(strcmp(var_name, var_names[20]))){
                    error = 0;
                    print_int_value(get_20);
                  }
                }
              }
            }
          }
          else{ /*[597,624]*/
            if(hashkey<=610){ /*[597,610]*/
              if(hashkey>=604){ /*[604,610]*/
                if(hashkey>=608){ /*[608,610]*/
                  if(hashkey<=609){ /*[608,609]*/
                    if(hashkey==609){
                      if(!(strcmp(var_name, var_names[30]))){
                        error = 0;
                        print_int_value(get_30);
                      }
                    }
                  }
                  else{ /*[610]*/
                      if(!(strcmp(var_name, var_names[78]))){
                        error = 0;
                        print_bool_value(get_78);
                      }
                  }
                }
              }
            }
            else{ /*[611,624]*/
              if(hashkey<=617){ /*[611,617]*/
                if(hashkey<=614){ /*[611,614]*/
                  if(hashkey<=612){ /*[611,612]*/
                    if(hashkey==611){
                      if(!(strcmp(var_name, var_names[52]))){
                        error = 0;
                        print_bool_value(get_52);
                      }
                    }
                  }
                  else{ /*[613,614]*/
                    if(hashkey==613){
                      if(!(strcmp(var_name, var_names[44]))){
                        error = 0;
                        print_bool_value(get_44);
                      }
                    }
                  }
                }
                else{ /*[615,617]*/
                }
              }
              else{ /*[618,624]*/
                if(hashkey==623){
                  if(!(strcmp(var_name, var_names[41]))){
                    error = 0;
                    print_bool_value(get_41);
                  }
                }
              }
            }
          }
        }
        else{ /*[625,680]*/
          if(hashkey<=652){ /*[625,652]*/
            if(hashkey<=638){ /*[625,638]*/
              if(hashkey==632){
                if(!(strcmp(var_name, var_names[3]))){
                  error = 0;
                  print_int_value(get_3);
                }
              }
            }
            else{ /*[639,652]*/
              if(hashkey<=645){ /*[639,645]*/
                if(hashkey<=642){ /*[639,642]*/
                  if(hashkey==640){
                    if(!(strcmp(var_name, var_names[58]))){
                      error = 0;
                      print_bool_value(get_58);
                    }
                  }
                }
                else{ /*[643,645]*/
                  if(hashkey==645){
                    if(!(strcmp(var_name, var_names[74]))){
                      error = 0;
                      print_bool_value(get_74);
                    }
                  }
                }
              }
              else{ /*[646,652]*/
              }
            }
          }
          else{ /*[653,680]*/
            if(hashkey<=666){ /*[653,666]*/
              if(hashkey==654){
                if(!(strcmp(var_name, var_names[33]))){
                  error = 0;
                  print_bool_value(get_33);
                }
              }
            }
            else{ /*[667,680]*/
              if(hashkey==669){
                if(!(strcmp(var_name, var_names[56]))){
                  error = 0;
                  print_bool_value(get_56);
                }
              }
            }
          }
        }
      }
    }
    else{ /*[681,907]*/
      if(hashkey<=794){ /*[681,794]*/
        if(hashkey<=737){ /*[681,737]*/
          if(hashkey<=709){ /*[681,709]*/
            if(hashkey==691){
              if(!(strcmp(var_name, var_names[79]))){
                error = 0;
                print_bool_value(get_79);
              }
            }
          }
          else{ /*[710,737]*/
            if(hashkey<=723){ /*[710,723]*/
              if(hashkey==711){
                if(!(strcmp(var_name, var_names[68]))){
                  error = 0;
                  print_int_value(get_68);
                }
              }
            }
            else{ /*[724,737]*/
              if(hashkey==725){
                if(!(strcmp(var_name, var_names[16]))){
                  error = 0;
                  print_guiDisplayData_value(get_16);
                }
              }
            }
          }
        }
        else{ /*[738,794]*/
          if(hashkey<=766){ /*[738,766]*/
            if(hashkey<=752){ /*[738,752]*/
              if(hashkey<=745){ /*[738,745]*/
                if(hashkey<=741){ /*[738,741]*/
                  if(hashkey<=739){ /*[738,739]*/
                    if(hashkey==739){
                      if(!(strcmp(var_name, var_names[18]))){
                        error = 0;
                        print_int_value(get_18);
                      }
                    }
                  }
                  else{ /*[740,741]*/
                    if(hashkey==740){
                      if(!(strcmp(var_name, var_names[73]))){
                        error = 0;
                        print_int_value(get_73);
                      }
                    }
                  }
                }
                else{ /*[742,745]*/
                  if(hashkey==745){
                    if(!(strcmp(var_name, var_names[42]))){
                      error = 0;
                      print_bool_value(get_42);
                    }
                  }
                }
              }
              else{ /*[746,752]*/
              }
            }
            else{ /*[753,766]*/
              if(hashkey<=759){ /*[753,759]*/
                if(hashkey<=756){ /*[753,756]*/
                  if(hashkey==756){
                    if(!(strcmp(var_name, var_names[50]))){
                      error = 0;
                      print_bool_value(get_50);
                    }
                  }
                }
                else{ /*[757,759]*/
                  if(hashkey==758){
                    if(!(strcmp(var_name, var_names[5]))){
                      error = 0;
                      print_bool_value(get_5);
                    }
                  }
                }
              }
              else{ /*[760,766]*/
                if(hashkey==765){
                  if(!(strcmp(var_name, var_names[28]))){
                    error = 0;
                    print_bool_value(get_28);
                  }
                }
              }
            }
          }
          else{ /*[767,794]*/
            if(hashkey<=780){ /*[767,780]*/
              if(hashkey==769){
                if(!(strcmp(var_name, var_names[71]))){
                  error = 0;
                  print_int_value(get_71);
                }
              }
            }
            else{ /*[781,794]*/
              if(hashkey==787){
                if(!(strcmp(var_name, var_names[7]))){
                  error = 0;
                  print_int_value(get_7);
                }
              }
            }
          }
        }
      }
      else{ /*[795,907]*/
        if(hashkey<=851){ /*[795,851]*/
          if(hashkey<=823){ /*[795,823]*/
            if(hashkey<=809){ /*[795,809]*/
              if(hashkey==799){
                if(!(strcmp(var_name, var_names[0]))){
                  error = 0;
                  print_guiControlData_value(*get_0);
                }
              }
            }
            else{ /*[810,823]*/
              if(hashkey==814){
                if(!(strcmp(var_name, var_names[64]))){
                  error = 0;
                  print_bool_value(get_64);
                }
              }
            }
          }
          else{ /*[824,851]*/
            if(hashkey>=838){ /*[838,851]*/
              if(hashkey<=844){ /*[838,844]*/
                if(hashkey>=842){ /*[842,844]*/
                  if(hashkey<=843){ /*[842,843]*/
                    if(hashkey==843){
                      if(!(strcmp(var_name, var_names[62]))){
                        error = 0;
                        print_bool_value(get_62);
                      }
                    }
                  }
                  else{ /*[844]*/
                      if(!(strcmp(var_name, var_names[21]))){
                        error = 0;
                        print_bool_value(get_21);
                      }
                  }
                }
              }
              else{ /*[845,851]*/
                if(hashkey==846){
                  if(!(strcmp(var_name, var_names[77]))){
                    error = 0;
                    print_bool_value(get_77);
                  }
                }
              }
            }
          }
        }
        else{ /*[852,907]*/
          if(hashkey<=879){ /*[852,879]*/
            if(hashkey<=865){ /*[852,865]*/
              if(hashkey==852){
                if(!(strcmp(var_name, var_names[27]))){
                  error = 0;
                  print_int_value(get_27);
                }
              }
            }
            else{ /*[866,879]*/
              if(hashkey==872){
                if(!(strcmp(var_name, var_names[69]))){
                  error = 0;
                  print_bool_value(get_69);
                }
              }
            }
          }
          else{ /*[880,907]*/
            if(hashkey<=893){ /*[880,893]*/
              if(hashkey==889){
                if(!(strcmp(var_name, var_names[25]))){
                  error = 0;
                  print_int_value(get_25);
                }
              }
            }
            else{ /*[894,907]*/
              if(hashkey==901){
                if(!(strcmp(var_name, var_names[66]))){
                  error = 0;
                  print_bool_value(get_66);
                }
              }
            }
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

  if(hashkey==799){
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

