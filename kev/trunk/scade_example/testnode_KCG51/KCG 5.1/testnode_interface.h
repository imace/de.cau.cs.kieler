#ifndef _testnode_INTERFACE_H_
#define _testnode_INTERFACE_H_

#include "sim_types.h"

#include "testnode_main.h"
#include "testnode.h"


extern void testnode(_C_testnode* _C_);
extern void trace_step(void);
extern int HPJW(char *__str);

_C_testnode input_ctxt;


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
#define get_2          ((input_ctxt._C_1_Counter_0._I0_Incr)) 
#define get_3          ((input_ctxt._C_1_Counter_0._I1_Reset)) 

/*
 * observable outputs
 */

#define get_1          ((input_ctxt._O0_guiDisplayData)) 
#define get_4          ((input_ctxt._C_1_Counter_0._O0_Count)) 

#endif
