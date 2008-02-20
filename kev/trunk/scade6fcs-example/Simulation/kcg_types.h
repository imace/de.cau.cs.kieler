/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node example::elevator -target_dir U:/shared/modelgui/trunk/scade6fcs-example/Simulation U:/shared/modelgui/trunk/scade6fcs-example/Simulation/elevator.scade
** Generation date: 2007-09-21T15:06:35
*************************************************************$ */
#ifndef _KCG_TYPES_H_
#define _KCG_TYPES_H_

#define MAPW_CPY

#ifndef kcg_bool
typedef int kcg_bool;
#endif /* kcg_bool */
#ifndef kcg_int
typedef int kcg_int;
#endif /* kcg_int */
#ifndef kcg_real
typedef double kcg_real;
#endif /* kcg_real */
#ifndef kcg_char
typedef unsigned char kcg_char;
#endif /* kcg_char */
#ifndef kcg_true
#define kcg_true (kcg_bool)1
#endif /* kcg_true */
#ifndef kcg_false
#define kcg_false (kcg_bool)0
#endif /* kcg_false */
#ifndef kcg_or
#define kcg_or |
#endif /* kcg_or */
#ifndef kcg_xor
#define kcg_xor ^
#endif /* kcg_xor */
#ifndef kcg_and
#define kcg_and &
#endif /* kcg_and */
#ifndef kcg_not
#define kcg_not !
#endif /* kcg_not */

typedef struct { kcg_bool button_up; } struct_1;

#ifndef kcg_assign
#include "string.h"
#define kcg_assign(C1, C2, size) (void)memcpy(C1, C2, size)
#endif /* kcg_assign */
#define copy_struct_1(C1, C2) kcg_assign(C1, C2, sizeof ( struct_1 ))
#define kcg_comp_struct_1(C1, C2)                                               \
((C1->button_up) == (C2->button_up))
#define comp_struct_1(C1, C2) kcg_comp_struct_1 ((C1), (C2))

typedef struct_1 input_example;
/* example::input */
#define copy_input_example(C1, C2) kcg_assign(C1, C2, sizeof ( input_example ))
#define kcg_comp_input_example(C1, C2) comp_struct_1((C1),(C2))
#define comp_input_example(C1, C2) kcg_comp_input_example ((C1), (C2))

typedef struct { kcg_int position; } struct_2;

#define copy_struct_2(C1, C2) kcg_assign(C1, C2, sizeof ( struct_2 ))
#define kcg_comp_struct_2(C1, C2)                                               \
((C1->position) == (C2->position))
#define comp_struct_2(C1, C2) kcg_comp_struct_2 ((C1), (C2))

typedef struct_2 output_example;
/* example::output */
#define copy_output_example(C1, C2) kcg_assign(C1, C2, sizeof ( output_example ))
#define kcg_comp_output_example(C1, C2) comp_struct_2((C1),(C2))
#define comp_output_example(C1, C2) kcg_comp_output_example ((C1), (C2))


#endif /* _KCG_TYPES_H_ */

/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** kcg_types.h
** Generation date: 2007-09-21T15:06:35
*************************************************************$ */
