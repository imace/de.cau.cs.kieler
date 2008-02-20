#ifndef _Elevator_INTERFACE_H_
#define _Elevator_INTERFACE_H_

#include "sim_types.h"

#include "Elevator.h"


extern bool Elevator(_C_Elevator* _C_);
extern void trace_step(void);
extern int HPJW(char *__str);

_C_Elevator input_ctxt;


/*
 * printing
 */

#define new_guiControlData( _v) _v->u.a_
#define new_guiDisplayData( _v) _v->u.a_
#define new_int( _v) _v->u.a_integer
#define new_real( _v) _v->u.a_real
#define new_bool( _v) _v->u.a_boolean
#define new_char( _v) _v->u.a_character
int print_value(char *var_name);
int set_value(char *var_name, value* __v);

/*
 * observable inputs
 */

#define get_0          ((input_ctxt._I0_guiControlData)) 

#define set_0(__v)     (*(input_ctxt._I0_guiControlData)=__v) 
#define get_21         ((input_ctxt._C_1_Second._C_1_ClockCounter._I0_Reset)) 
#define get_30         ((input_ctxt._C_1_Position._I0_Motor)) 
#define get_33         ((input_ctxt._C_1_Controller._I0_ButtonUp)) 
#define get_34         ((input_ctxt._C_1_Controller._I1_ButtonDown)) 
#define get_35         ((input_ctxt._C_1_Controller._I2_ButtonAlarm)) 
#define get_36         ((input_ctxt._C_1_Controller._I3_Second)) 
#define get_37         ((input_ctxt._C_1_Controller._I4_IsUp)) 
#define get_38         ((input_ctxt._C_1_Controller._I5_IsDown)) 
#define get_74         ((input_ctxt._C_1_KeepDoorOpen._I0_Second)) 
#define get_75         ((input_ctxt._C_1_KeepDoorOpen._I1_OpenDoor)) 

/*
 * observable outputs
 */

#define get_1          ((input_ctxt._O0_guDisplayData)) 
#define get_17         ((input_ctxt._C_1_Second._O0_Second)) 
#define get_22         ((input_ctxt._C_1_Second._C_1_ClockCounter._O0_Count)) 
#define get_31         ((input_ctxt._C_1_Position._O0_Position)) 
#define get_39         ((input_ctxt._C_1_Controller._O0_Move)) 
#define get_40         ((input_ctxt._C_1_Controller._O1_AlarmLamp)) 
#define get_41         ((input_ctxt._C_1_Controller._O2_OpenDoor)) 
#define get_76         ((input_ctxt._C_1_KeepDoorOpen._O0_DoorIsOpen)) 

/*
 * observable local variables
 */

#define get_2          ((input_ctxt._L5_Elevator)) 
#define get_3          ((input_ctxt._L9_Elevator)) 
#define get_4          ((input_ctxt._L15_Elevator)) 
#define get_5          ((input_ctxt._L16_Elevator)) 
#define get_6          ((input_ctxt._L17_Elevator)) 
#define get_7          ((input_ctxt._L18_Elevator)) 
#define get_8          ((input_ctxt._L19_Elevator)) 
#define get_9          ((input_ctxt._L20_Elevator)) 
#define get_10         ((input_ctxt._L23_Elevator)) 
#define get_11         ((input_ctxt._L24_Elevator)) 
#define get_12         ((input_ctxt._L25_Elevator)) 
#define get_13         ((input_ctxt._L28_Elevator)) 
#define get_14         ((input_ctxt._L27_Elevator)) 
#define get_15         ((input_ctxt._L26_Elevator)) 
#define get_16         ((input_ctxt._L33_Elevator)) 
#define get_18         ((input_ctxt._C_1_Second._L2_Elevator)) 
#define get_19         ((input_ctxt._C_1_Second._L3_Elevator)) 
#define get_20         ((input_ctxt._C_1_Second._L4_Elevator)) 
#define get_23         ((input_ctxt._C_1_Second._C_1_ClockCounter._L1_Elevator)) 
#define get_24         ((input_ctxt._C_1_Second._C_1_ClockCounter._L2_Elevator)) 
#define get_25         ((input_ctxt._C_1_Second._C_1_ClockCounter._L7_Elevator)) 
#define get_26         ((input_ctxt._C_1_Second._C_1_ClockCounter._L8_Elevator)) 
#define get_27         ((input_ctxt._C_1_Second._C_1_ClockCounter._L11_Elevator)) 
#define get_28         ((input_ctxt._C_1_Second._C_1_ClockCounter._L13_Elevator)) 
#define get_29         ((input_ctxt._C_1_Second._C_1_ClockCounter._L16_Elevator)) 
#define get_32         ((input_ctxt._C_1_Position._L2_Elevator)) 
#define get_42         ((input_ctxt._C_1_Controller._LE0_Elevator)) 
#define get_43         ((input_ctxt._C_1_Controller._LE3_Elevator)) 
#define get_44         ((input_ctxt._C_1_Controller._LE4_Elevator)) 
#define get_45         ((input_ctxt._C_1_Controller._LE6_Elevator)) 
#define get_46         ((input_ctxt._C_1_Controller._LE7_Elevator)) 
#define get_47         ((input_ctxt._C_1_Controller._LE8_Elevator)) 
#define get_48         ((input_ctxt._C_1_Controller._LE9_Elevator)) 
#define get_49         ((input_ctxt._C_1_Controller._LE10_Elevator)) 
#define get_50         ((input_ctxt._C_1_Controller._LE11_Elevator)) 
#define get_51         ((input_ctxt._C_1_Controller._LE12_Elevator)) 
#define get_52         ((input_ctxt._C_1_Controller._LE13_Elevator)) 
#define get_53         ((input_ctxt._C_1_Controller._LE14_Elevator)) 
#define get_54         ((input_ctxt._C_1_Controller._LE15_Elevator)) 
#define get_55         ((input_ctxt._C_1_Controller._LE16_Elevator)) 
#define get_56         ((input_ctxt._C_1_Controller._LE17_Elevator)) 
#define get_57         ((input_ctxt._C_1_Controller._LE18_Elevator)) 
#define get_58         ((input_ctxt._C_1_Controller._LE19_Elevator)) 
#define get_59         ((input_ctxt._C_1_Controller._LE20_Elevator)) 
#define get_60         ((input_ctxt._C_1_Controller._LE21_Elevator)) 
#define get_61         ((input_ctxt._C_1_Controller._LE22_Elevator)) 
#define get_62         ((input_ctxt._C_1_Controller._LE23_Elevator)) 
#define get_63         ((input_ctxt._C_1_Controller._LE24_Elevator)) 
#define get_64         ((input_ctxt._C_1_Controller._LE25_Elevator)) 
#define get_65         ((input_ctxt._C_1_Controller._LE26_Elevator)) 
#define get_66         ((input_ctxt._C_1_Controller._LE27_Elevator)) 
#define get_67         ((input_ctxt._C_1_Controller._LE28_Elevator)) 
#define get_68         ((input_ctxt._C_1_Controller._LVF0_Elevator)) 
#define get_69         ((input_ctxt._C_1_Controller._LE29_Elevator)) 
#define get_70         ((input_ctxt._C_1_Controller._LVF2_Elevator)) 
#define get_71         ((input_ctxt._C_1_Controller._LVF4_Elevator)) 
#define get_72         ((input_ctxt._C_1_Controller._LVF5_Elevator)) 
#define get_73         ((input_ctxt._C_1_Controller._LVF6_Elevator)) 
#define get_77         ((input_ctxt._C_1_KeepDoorOpen._L1_Elevator)) 
#define get_78         ((input_ctxt._C_1_KeepDoorOpen._L2_Elevator)) 
#define get_79         ((input_ctxt._C_1_KeepDoorOpen._L17_Elevator)) 

#endif
