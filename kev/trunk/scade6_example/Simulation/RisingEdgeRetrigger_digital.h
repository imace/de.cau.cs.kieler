/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node simulation::Simulation -target_dir U:/shared/modelgui/trunk/scade6_example/Simulation U:/shared/modelgui/trunk/scade6_example/Simulation/Simulation.scade
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
#ifndef _RisingEdgeRetrigger_digital_H_
#define _RisingEdgeRetrigger_digital_H_

#include "kcg_types.h"
#include "kcg_consts.h"
#include "kcg_sensors.h"
#include "count_down_digital.h"
/* 
  ========================== context type  ==========================   */
typedef struct {
  /* 
    ---------------------------  outputs  ---------------------------   */
  
  kcg_bool RER_Output /* digital::RisingEdgeRetrigger::RER_Output */;
  /* 
    -----------------------  no local probes  -----------------------   */
  
  /* 
    ------------------- initialisation variables  -------------------   */
  
  kcg_bool _init;
  /* 
    ------------------------ local memories  ------------------------   */
  
  kcg_int _L50 /* digital::RisingEdgeRetrigger::_L50 */;
  kcg_bool _L47 /* digital::RisingEdgeRetrigger::_L47 */;
  kcg_bool _L46 /* digital::RisingEdgeRetrigger::_L46 */;
  kcg_bool _L35 /* digital::RisingEdgeRetrigger::_L35 */;
  kcg_bool _L36 /* digital::RisingEdgeRetrigger::_L36 */;
  kcg_bool _L38 /* digital::RisingEdgeRetrigger::_L38 */;
  kcg_bool _L39 /* digital::RisingEdgeRetrigger::_L39 */;
  kcg_int _L41 /* digital::RisingEdgeRetrigger::_L41 */;
  kcg_int _L44 /* digital::RisingEdgeRetrigger::_L44 */;
  kcg_bool _L16 /* digital::RisingEdgeRetrigger::_L16 */;
  kcg_bool _L14 /* digital::RisingEdgeRetrigger::_L14 */;
  kcg_bool _L13 /* digital::RisingEdgeRetrigger::_L13 */;
  kcg_bool rew /* digital::RisingEdgeRetrigger::rewrite */;
  kcg_int _L48 /* digital::RisingEdgeRetrigger::_L48 */;
  kcg_bool _L43 /* digital::RisingEdgeRetrigger::_L43 */;
  kcg_bool _L31 /* digital::RisingEdgeRetrigger::_L31 */;
  /* 
    ---------------------  sub nodes' contexts  ---------------------   */
  
  outC_count_down_digital Context_count_down;
} outC_RisingEdgeRetrigger_digita;

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
  
  kcg_int _L50 /* digital::RisingEdgeRetrigger::_L50 */;
  kcg_bool _L47 /* digital::RisingEdgeRetrigger::_L47 */;
  kcg_bool _L46 /* digital::RisingEdgeRetrigger::_L46 */;
  kcg_bool _L35 /* digital::RisingEdgeRetrigger::_L35 */;
  kcg_bool _L36 /* digital::RisingEdgeRetrigger::_L36 */;
  kcg_bool _L38 /* digital::RisingEdgeRetrigger::_L38 */;
  kcg_bool _L39 /* digital::RisingEdgeRetrigger::_L39 */;
  kcg_int _L41 /* digital::RisingEdgeRetrigger::_L41 */;
  kcg_int _L44 /* digital::RisingEdgeRetrigger::_L44 */;
  kcg_bool _L16 /* digital::RisingEdgeRetrigger::_L16 */;
  kcg_bool _L14 /* digital::RisingEdgeRetrigger::_L14 */;
  kcg_bool _L13 /* digital::RisingEdgeRetrigger::_L13 */;
  kcg_bool rew /* digital::RisingEdgeRetrigger::rewrite */;
  kcg_int _L48 /* digital::RisingEdgeRetrigger::_L48 */;
  kcg_bool _L43 /* digital::RisingEdgeRetrigger::_L43 */;
  kcg_bool _L31 /* digital::RisingEdgeRetrigger::_L31 */;
  /* 
    ---------------------  sub nodes' contexts  ---------------------   */
  
  outC_count_down_digital Context_count_down;
} RisingEdgeRetrigger_SV_digital;

/* macro for state saving and restoring */
#define copy_RisingEdgeRetrigger_SV_digital(x_2, y_2)                           \
  do {                                                                          \
    {                                                                           \
      x_2._init = y_2._init;                                                    \
      x_2._L50 = y_2._L50;                                                      \
      x_2._L47 = y_2._L47;                                                      \
      x_2._L46 = y_2._L46;                                                      \
      x_2._L35 = y_2._L35;                                                      \
      x_2._L36 = y_2._L36;                                                      \
      x_2._L38 = y_2._L38;                                                      \
      x_2._L39 = y_2._L39;                                                      \
      x_2._L41 = y_2._L41;                                                      \
      x_2._L44 = y_2._L44;                                                      \
      x_2._L16 = y_2._L16;                                                      \
      x_2._L14 = y_2._L14;                                                      \
      x_2._L13 = y_2._L13;                                                      \
      x_2.rew = y_2.rew;                                                        \
      x_2._L48 = y_2._L48;                                                      \
      x_2._L43 = y_2._L43;                                                      \
      x_2._L31 = y_2._L31;                                                      \
      copy_count_down_SV_digital ( x_2.Context_count_down , y_2.Context_count_down );\
    }                                                                           \
  } while(0)
/* 
  ============  node initialisation and cycle functions  ============   */
extern void RisingEdgeRetrigger_reset_digit(
  outC_RisingEdgeRetrigger_digita *outC);
extern void RisingEdgeRetrigger_digital(
  kcg_bool RER_Input /* digital::RisingEdgeRetrigger::RER_Input */,
  kcg_int NumberOfCycle /* digital::RisingEdgeRetrigger::NumberOfCycle */,
  outC_RisingEdgeRetrigger_digita *outC);

#endif /* _RisingEdgeRetrigger_digital_H_ */

/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** RisingEdgeRetrigger_digital.h
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
