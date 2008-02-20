/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node simulation::Simulation -target_dir U:/shared/modelgui/trunk/scade6_example/Simulation U:/shared/modelgui/trunk/scade6_example/Simulation/Simulation.scade
** Generation date: 2007-09-21T13:34:21
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

typedef struct { kcg_bool buttonUp; kcg_bool buttonDown; kcg_bool buttonAlarm; } struct_1;

#ifndef kcg_assign
#include "string.h"
#define kcg_assign(C1, C2, size) (void)memcpy(C1, C2, size)
#endif /* kcg_assign */
#define copy_struct_1(C1, C2) kcg_assign(C1, C2, sizeof ( struct_1 ))
#define kcg_comp_struct_1(C1, C2)                                               \
((C1->buttonUp) == (C2->buttonUp) kcg_and                                       \
  (C1->buttonDown) == (C2->buttonDown) kcg_and                                  \
  (C1->buttonAlarm) == (C2->buttonAlarm))
#define comp_struct_1(C1, C2) kcg_comp_struct_1 ((C1), (C2))

typedef struct {
  kcg_int direction;
  kcg_bool alarm;
  kcg_int position;
  kcg_bool doorClosed;
} struct_2;

#define copy_struct_2(C1, C2) kcg_assign(C1, C2, sizeof ( struct_2 ))
#define kcg_comp_struct_2(C1, C2)                                               \
((C1->direction) == (C2->direction) kcg_and                                     \
  (C1->alarm) == (C2->alarm) kcg_and                                            \
  (C1->position) == (C2->position) kcg_and                                      \
  (C1->doorClosed) == (C2->doorClosed))
#define comp_struct_2(C1, C2) kcg_comp_struct_2 ((C1), (C2))

typedef struct_1 ControlDataType_elevator;
/* elevator::ControlDataType */
#define copy_ControlDataType_elevator(C1, C2) kcg_assign(C1, C2, sizeof ( ControlDataType_elevator ))
#define kcg_comp_ControlDataType_elevator(C1, C2) comp_struct_1((C1),(C2))
#define comp_ControlDataType_elevator(C1, C2) kcg_comp_ControlDataType_elevator ((C1), (C2))

typedef struct_2 DisplayDataType_elevator;
/* elevator::DisplayDataType */
#define copy_DisplayDataType_elevator(C1, C2) kcg_assign(C1, C2, sizeof ( DisplayDataType_elevator ))
#define kcg_comp_DisplayDataType_elevator(C1, C2) comp_struct_2((C1),(C2))
#define comp_DisplayDataType_elevator(C1, C2) kcg_comp_DisplayDataType_elevator ((C1), (C2))


#endif /* _KCG_TYPES_H_ */

/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** kcg_types.h
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
