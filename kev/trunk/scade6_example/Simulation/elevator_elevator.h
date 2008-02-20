/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node simulation::Simulation -target_dir U:/shared/modelgui/trunk/scade6_example/Simulation U:/shared/modelgui/trunk/scade6_example/Simulation/Simulation.scade
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
#ifndef _elevator_elevator_H_
#define _elevator_elevator_H_

#include "kcg_types.h"
#include "kcg_consts.h"
#include "kcg_sensors.h"
#include "RisingEdgeRetrigger_digital.h"
#include "Counter_int_pwlinear.h"
/* 
  ========================== context type  ==========================   */
typedef struct {
  /* 
    ---------------------------  outputs  ---------------------------   */
  
  DisplayDataType_elevator out_displayData /* elevator::elevator::out_displayData */;
  /* 
    -----------------------  no local probes  -----------------------   */
  
  /* 
    ------------------- initialisation variables  -------------------   */
  
  kcg_bool _init;
  /* 
    ------------------------ local memories  ------------------------   */
  
  kcg_bool _L40 /* elevator::elevator::_L40 */;
  kcg_bool _L39 /* elevator::elevator::_L39 */;
  kcg_int _L34 /* elevator::elevator::_L34 */;
  kcg_int _L33 /* elevator::elevator::_L33 */;
  kcg_int _L32 /* elevator::elevator::_L32 */;
  kcg_bool _L31 /* elevator::elevator::_L31 */;
  kcg_bool _L30 /* elevator::elevator::_L30 */;
  kcg_bool _L29 /* elevator::elevator::_L29 */;
  kcg_bool _L28 /* elevator::elevator::_L28 */;
  kcg_bool _L27 /* elevator::elevator::_L27 */;
  kcg_bool _L22 /* elevator::elevator::_L22 */;
  kcg_int _L20 /* elevator::elevator::_L20 */;
  kcg_int _L19 /* elevator::elevator::_L19 */;
  kcg_bool _L18 /* elevator::elevator::_L18 */;
  kcg_bool _L17 /* elevator::elevator::_L17 */;
  kcg_int _L15 /* elevator::elevator::_L15 */;
  kcg_int _L14 /* elevator::elevator::_L14 */;
  kcg_int _L13 /* elevator::elevator::_L13 */;
  kcg_int _L12 /* elevator::elevator::_L12 */;
  kcg_int _L11 /* elevator::elevator::_L11 */;
  kcg_int _L10 /* elevator::elevator::_L10 */;
  kcg_int _L8 /* elevator::elevator::_L8 */;
  kcg_int _L7 /* elevator::elevator::_L7 */;
  kcg_int _L6 /* elevator::elevator::_L6 */;
  kcg_bool _L4 /* elevator::elevator::_L4 */;
  DisplayDataType_elevator _L2 /* elevator::elevator::_L2 */;
  ControlDataType_elevator _L1 /* elevator::elevator::_L1 */;
  kcg_bool alarm /* elevator::elevator::alarm */;
  kcg_int direction /* elevator::elevator::direction */;
  kcg_bool buttonDown /* elevator::elevator::buttonDown */;
  kcg_bool buttonUp /* elevator::elevator::buttonUp */;
  kcg_int _L16 /* elevator::elevator::_L16 */;
  /* 
    ---------------------  sub nodes' contexts  ---------------------   */
  
  outC_Counter_int_pwlinear Context_Counter_int;
  outC_RisingEdgeRetrigger_digita Context_RisingEdgeRetrigger;
} outC_elevator_elevator;

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
  
  kcg_bool _L40 /* elevator::elevator::_L40 */;
  kcg_bool _L39 /* elevator::elevator::_L39 */;
  kcg_int _L34 /* elevator::elevator::_L34 */;
  kcg_int _L33 /* elevator::elevator::_L33 */;
  kcg_int _L32 /* elevator::elevator::_L32 */;
  kcg_bool _L31 /* elevator::elevator::_L31 */;
  kcg_bool _L30 /* elevator::elevator::_L30 */;
  kcg_bool _L29 /* elevator::elevator::_L29 */;
  kcg_bool _L28 /* elevator::elevator::_L28 */;
  kcg_bool _L27 /* elevator::elevator::_L27 */;
  kcg_bool _L22 /* elevator::elevator::_L22 */;
  kcg_int _L20 /* elevator::elevator::_L20 */;
  kcg_int _L19 /* elevator::elevator::_L19 */;
  kcg_bool _L18 /* elevator::elevator::_L18 */;
  kcg_bool _L17 /* elevator::elevator::_L17 */;
  kcg_int _L15 /* elevator::elevator::_L15 */;
  kcg_int _L14 /* elevator::elevator::_L14 */;
  kcg_int _L13 /* elevator::elevator::_L13 */;
  kcg_int _L12 /* elevator::elevator::_L12 */;
  kcg_int _L11 /* elevator::elevator::_L11 */;
  kcg_int _L10 /* elevator::elevator::_L10 */;
  kcg_int _L8 /* elevator::elevator::_L8 */;
  kcg_int _L7 /* elevator::elevator::_L7 */;
  kcg_int _L6 /* elevator::elevator::_L6 */;
  kcg_bool _L4 /* elevator::elevator::_L4 */;
  DisplayDataType_elevator _L2 /* elevator::elevator::_L2 */;
  ControlDataType_elevator _L1 /* elevator::elevator::_L1 */;
  kcg_bool alarm /* elevator::elevator::alarm */;
  kcg_int direction /* elevator::elevator::direction */;
  kcg_bool buttonDown /* elevator::elevator::buttonDown */;
  kcg_bool buttonUp /* elevator::elevator::buttonUp */;
  kcg_int _L16 /* elevator::elevator::_L16 */;
  /* 
    ---------------------  sub nodes' contexts  ---------------------   */
  
  outC_Counter_int_pwlinear Context_Counter_int;
  outC_RisingEdgeRetrigger_digita Context_RisingEdgeRetrigger;
} elevator_SV_elevator;

/* macro for state saving and restoring */
#define copy_elevator_SV_elevator(x_3, y_3)                                     \
  do {                                                                          \
    {                                                                           \
      x_3._init = y_3._init;                                                    \
      x_3._L40 = y_3._L40;                                                      \
      x_3._L39 = y_3._L39;                                                      \
      x_3._L34 = y_3._L34;                                                      \
      x_3._L33 = y_3._L33;                                                      \
      x_3._L32 = y_3._L32;                                                      \
      x_3._L31 = y_3._L31;                                                      \
      x_3._L30 = y_3._L30;                                                      \
      x_3._L29 = y_3._L29;                                                      \
      x_3._L28 = y_3._L28;                                                      \
      x_3._L27 = y_3._L27;                                                      \
      x_3._L22 = y_3._L22;                                                      \
      x_3._L20 = y_3._L20;                                                      \
      x_3._L19 = y_3._L19;                                                      \
      x_3._L18 = y_3._L18;                                                      \
      x_3._L17 = y_3._L17;                                                      \
      x_3._L15 = y_3._L15;                                                      \
      x_3._L14 = y_3._L14;                                                      \
      x_3._L13 = y_3._L13;                                                      \
      x_3._L12 = y_3._L12;                                                      \
      x_3._L11 = y_3._L11;                                                      \
      x_3._L10 = y_3._L10;                                                      \
      x_3._L8 = y_3._L8;                                                        \
      x_3._L7 = y_3._L7;                                                        \
      x_3._L6 = y_3._L6;                                                        \
      x_3._L4 = y_3._L4;                                                        \
      copy_DisplayDataType_elevator ( x_3._L2 , y_3._L2 );                      \
      copy_ControlDataType_elevator ( x_3._L1 , y_3._L1 );                      \
      x_3.alarm = y_3.alarm;                                                    \
      x_3.direction = y_3.direction;                                            \
      x_3.buttonDown = y_3.buttonDown;                                          \
      x_3.buttonUp = y_3.buttonUp;                                              \
      x_3._L16 = y_3._L16;                                                      \
      copy_Counter_int_SV_pwlinear ( x_3.Context_Counter_int , y_3.Context_Counter_int );\
      copy_RisingEdgeRetrigger_SV_digital ( x_3.Context_RisingEdgeRetrigger , y_3.Context_RisingEdgeRetrigger );\
    }                                                                           \
  } while(0)
/* 
  ============  node initialisation and cycle functions  ============   */
extern void elevator_reset_elevator(outC_elevator_elevator *outC);
extern void elevator_elevator(
  ControlDataType_elevator *controlData /* elevator::elevator::controlData */,
  outC_elevator_elevator *outC);

#endif /* _elevator_elevator_H_ */

/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** elevator_elevator.h
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
