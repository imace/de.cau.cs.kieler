/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node simulation::Simulation -target_dir U:/shared/modelgui/trunk/scade6_example/Simulation U:/shared/modelgui/trunk/scade6_example/Simulation/Simulation.scade
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
#ifndef _count_down_digital_H_
#define _count_down_digital_H_

#include "kcg_types.h"
#include "kcg_consts.h"
#include "kcg_sensors.h"
/* 
  ========================== context type  ==========================   */
typedef struct {
  /* 
    ---------------------------  outputs  ---------------------------   */
  
  kcg_int cpt /* digital::count_down::cpt */;
  /* 
    -----------------------  no local probes  -----------------------   */
  
  /* 
    ------------------- initialisation variables  -------------------   */
  
  kcg_bool _init;
  /* 
    ------------------------ local memories  ------------------------   */
  
  kcg_int _L13 /* digital::count_down::_L13 */;
  kcg_int _L8 /* digital::count_down::_L8 */;
  kcg_int _L7 /* digital::count_down::_L7 */;
  kcg_int _L3 /* digital::count_down::_L3 */;
  kcg_int _L2 /* digital::count_down::_L2 */;
  kcg_bool _L1 /* digital::count_down::_L1 */;
  kcg_int _L4 /* digital::count_down::_L4 */;
  /* 
    -------------------- no sub nodes' contexts  --------------------   */
  
} outC_count_down_digital;

/* 
  =======================  state vector type  =======================   */
typedef struct {
  /* 
    --------------------- no memorised outputs  ---------------------   */
  
  /* 
    -----------------------  no local probes  -----------------------   */
  
  /* 
    ------------------- initialisation variables  -------------------   */
  
  kcg_bool _init;
  /* 
    ------------------------ local memories  ------------------------   */
  
  kcg_int _L13 /* digital::count_down::_L13 */;
  kcg_int _L8 /* digital::count_down::_L8 */;
  kcg_int _L7 /* digital::count_down::_L7 */;
  kcg_int _L3 /* digital::count_down::_L3 */;
  kcg_int _L2 /* digital::count_down::_L2 */;
  kcg_bool _L1 /* digital::count_down::_L1 */;
  kcg_int _L4 /* digital::count_down::_L4 */;
  /* 
    -------------------- no sub nodes' contexts  --------------------   */
  
} count_down_SV_digital;

/* macro for state saving and restoring */
#define copy_count_down_SV_digital(x_1, y_1)                                    \
  do {                                                                          \
    {                                                                           \
      x_1._init = y_1._init;                                                    \
      x_1._L13 = y_1._L13;                                                      \
      x_1._L8 = y_1._L8;                                                        \
      x_1._L7 = y_1._L7;                                                        \
      x_1._L3 = y_1._L3;                                                        \
      x_1._L2 = y_1._L2;                                                        \
      x_1._L1 = y_1._L1;                                                        \
      x_1._L4 = y_1._L4;                                                        \
    }                                                                           \
  } while(0)
/* 
  ============  node initialisation and cycle functions  ============   */
extern void count_down_reset_digital(outC_count_down_digital *outC);
extern void count_down_digital(
  kcg_bool Reset /* digital::count_down::Reset */,
  kcg_int N /* digital::count_down::N */,
  outC_count_down_digital *outC);

#endif /* _count_down_digital_H_ */

/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** count_down_digital.h
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
