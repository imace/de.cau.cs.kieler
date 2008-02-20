/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node simulation::Simulation -target_dir U:/shared/modelgui/trunk/scade6_example/Simulation U:/shared/modelgui/trunk/scade6_example/Simulation/Simulation.scade
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
#ifndef _Counter_int_pwlinear_H_
#define _Counter_int_pwlinear_H_

#include "kcg_types.h"
#include "kcg_consts.h"
#include "kcg_sensors.h"
/* 
  ========================== context type  ==========================   */
typedef struct {
  /* 
    ---------------------------  outputs  ---------------------------   */
  
  kcg_int Count /* pwlinear::Counter::Count */;
  /* 
    -----------------------  no local probes  -----------------------   */
  
  /* 
    ------------------- initialisation variables  -------------------   */
  
  kcg_bool _init;
  /* 
    ------------------------ local memories  ------------------------   */
  
  kcg_int _L46 /* pwlinear::Counter::_L46 */;
  kcg_int _L18 /* pwlinear::Counter::_L18 */;
  kcg_int _L4 /* pwlinear::Counter::_L4 */;
  kcg_bool _L3 /* pwlinear::Counter::_L3 */;
  kcg_int _L2 /* pwlinear::Counter::_L2 */;
  kcg_int _L9 /* pwlinear::Counter::_L9 */;
  /* 
    -------------------- no sub nodes' contexts  --------------------   */
  
} outC_Counter_int_pwlinear;

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
  
  kcg_int _L46 /* pwlinear::Counter::_L46 */;
  kcg_int _L18 /* pwlinear::Counter::_L18 */;
  kcg_int _L4 /* pwlinear::Counter::_L4 */;
  kcg_bool _L3 /* pwlinear::Counter::_L3 */;
  kcg_int _L2 /* pwlinear::Counter::_L2 */;
  kcg_int _L9 /* pwlinear::Counter::_L9 */;
  /* 
    -------------------- no sub nodes' contexts  --------------------   */
  
} Counter_int_SV_pwlinear;

/* macro for state saving and restoring */
#define copy_Counter_int_SV_pwlinear(x, y)                                      \
  do {                                                                          \
    {                                                                           \
      x._init = y._init;                                                        \
      x._L46 = y._L46;                                                          \
      x._L18 = y._L18;                                                          \
      x._L4 = y._L4;                                                            \
      x._L3 = y._L3;                                                            \
      x._L2 = y._L2;                                                            \
      x._L9 = y._L9;                                                            \
    }                                                                           \
  } while(0)
/* 
  ============  node initialisation and cycle functions  ============   */
extern void Counter_int_reset_pwlinear(outC_Counter_int_pwlinear *outC);
extern void Counter_int_pwlinear(
  kcg_int Incr /* pwlinear::Counter::Incr */,
  kcg_bool Reset /* pwlinear::Counter::Reset */,
  outC_Counter_int_pwlinear *outC);

#endif /* _Counter_int_pwlinear_H_ */

/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Counter_int_pwlinear.h
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
