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

#define new_intArray10( _v) _v->u.a_
#define new_guiControlData( _v) _v->u.a_
#define new_states( _v) _v->u.a_integer
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

#define get_0          ((input_ctxt._I0_in_int)) 
#define get_1          ((input_ctxt._I1_in_bool)) 
#define get_2          ((input_ctxt._I2_in_real)) 
#define get_3          ((input_ctxt._I3_int_intarray)) 
#define get_4          ((input_ctxt._I4_guiControlData)) 

#define set_0(__v)     ((input_ctxt._I0_in_int)=__v) 
#define set_1(__v)     ((input_ctxt._I1_in_bool)=__v) 
#define set_2(__v)     ((input_ctxt._I2_in_real)=__v) 
#define set_3(__v)     (*(input_ctxt._I3_int_intarray)=__v) 
#define set_4(__v)     (*(input_ctxt._I4_guiControlData)=__v) 

/*
 * observable outputs
 */

#define get_5          ((input_ctxt._O0_out_int)) 
#define get_6          ((input_ctxt._O1_out_bool)) 
#define get_7          ((input_ctxt._O2_out_real)) 
#define get_8          ((input_ctxt._O3_out_intarray)) 
#define get_9          ((input_ctxt._O4_guiDisplayData)) 

#endif
