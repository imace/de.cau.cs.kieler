/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node example::elevator -target_dir U:/shared/modelgui/trunk/scade6fcs-example/Simulation U:/shared/modelgui/trunk/scade6fcs-example/Simulation/elevator.scade
** Generation date: 2007-09-21T15:06:35
*************************************************************$ */
#ifndef _elevator_example_H_
#define _elevator_example_H_

#include "kcg_types.h"
#include "kcg_consts.h"
#include "kcg_sensors.h"
/* 
  ========================  input structure  ========================   */
typedef struct { input_example input /* example::elevator::input */; } inC_elevator_example;

/* 
  ========================== context type  ==========================   */
typedef struct {
  /* 
    ---------------------------  outputs  ---------------------------   */
  
  output_example output /* example::elevator::output */;
  /* 
    -----------------------  no local probes  -----------------------   */
  
  /* 
    ------------------- initialisation variables  -------------------   */
  
  kcg_bool _init;
  /* 
    ------------------------ local memories  ------------------------   */
  
  kcg_int _L5 /* example::elevator::_L5 */;
  output_example _L3 /* example::elevator::_L3 */;
  kcg_bool _L2 /* example::elevator::_L2 */;
  input_example _L1 /* example::elevator::_L1 */;
  kcg_bool _underscore_;
  kcg_int _L4 /* example::elevator::_L4 */;
  /* 
    -------------------- no sub nodes' contexts  --------------------   */
  
} outC_elevator_example;

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
  
  kcg_int _L5 /* example::elevator::_L5 */;
  output_example _L3 /* example::elevator::_L3 */;
  kcg_bool _L2 /* example::elevator::_L2 */;
  input_example _L1 /* example::elevator::_L1 */;
  kcg_bool _underscore_;
  kcg_int _L4 /* example::elevator::_L4 */;
  /* 
    -------------------- no sub nodes' contexts  --------------------   */
  
} elevator_SV_example;

/* macro for state saving and restoring */
#define copy_elevator_SV_example(x, y)                                          \
  do {                                                                          \
    {                                                                           \
      x._init = y._init;                                                        \
      x._L5 = y._L5;                                                            \
      copy_output_example ( x._L3 , y._L3 );                                    \
      x._L2 = y._L2;                                                            \
      copy_input_example ( x._L1 , y._L1 );                                     \
      x._underscore_ = y._underscore_;                                          \
      x._L4 = y._L4;                                                            \
    }                                                                           \
  } while(0)
/* 
  ============  node initialisation and cycle functions  ============   */
extern void elevator_reset_example(outC_elevator_example *outC);
extern void elevator_example(
  inC_elevator_example *inC,
  outC_elevator_example *outC);

#endif /* _elevator_example_H_ */

/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** elevator_example.h
** Generation date: 2007-09-21T15:06:35
*************************************************************$ */
