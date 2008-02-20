/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node simulation::Simulation -target_dir U:/shared/modelgui/trunk/scade6_example/Simulation U:/shared/modelgui/trunk/scade6_example/Simulation/Simulation.scade
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
#ifndef _Simulation_simulation_H_
#define _Simulation_simulation_H_

#include "kcg_types.h"
#include "kcg_consts.h"
#include "kcg_sensors.h"
#include "elevator_elevator.h"
/* 
  ========================  input structure  ========================   */
typedef struct {
  ControlDataType_elevator controlData /* simulation::Simulation::controlData */;
} inC_Simulation_simulation;

/* 
  ========================== context type  ==========================   */
typedef struct {
  /* 
    ---------------------------  outputs  ---------------------------   */
  
  DisplayDataType_elevator displayData /* simulation::Simulation::displayData */;
  /* 
    -----------------------  no local probes  -----------------------   */
  
  /* 
    -----------------  no initialisation variables  -----------------   */
  
  /* 
    ------------------------ local memories  ------------------------   */
  
  DisplayDataType_elevator _L3 /* simulation::Simulation::_L3 */;
  ControlDataType_elevator _L2 /* simulation::Simulation::_L2 */;
  /* 
    ---------------------  sub nodes' contexts  ---------------------   */
  
  outC_elevator_elevator Context_elevator;
} outC_Simulation_simulation;

/* 
  =======================  state vector type  =======================   */
typedef struct {
  /* 
    --------------------- no memorised outputs  ---------------------   */
  
  /* 
    -----------------------  no local probes  -----------------------   */
  
  /* 
    -----------------  no initialisation variables  -----------------   */
  
  /* 
    ------------------------ local memories  ------------------------   */
  
  DisplayDataType_elevator _L3 /* simulation::Simulation::_L3 */;
  ControlDataType_elevator _L2 /* simulation::Simulation::_L2 */;
  /* 
    ---------------------  sub nodes' contexts  ---------------------   */
  
  outC_elevator_elevator Context_elevator;
} Simulation_SV_simulation;

/* macro for state saving and restoring */
#define copy_Simulation_SV_simulation(x_4, y_4)                                 \
  do {                                                                          \
    {                                                                           \
      copy_DisplayDataType_elevator ( x_4._L3 , y_4._L3 );                      \
      copy_ControlDataType_elevator ( x_4._L2 , y_4._L2 );                      \
      copy_elevator_SV_elevator ( x_4.Context_elevator , y_4.Context_elevator );\
    }                                                                           \
  } while(0)
/* 
  ============  node initialisation and cycle functions  ============   */
extern void Simulation_reset_simulation(outC_Simulation_simulation *outC);
extern void Simulation_simulation(
  inC_Simulation_simulation *inC,
  outC_Simulation_simulation *outC);

#endif /* _Simulation_simulation_H_ */

/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Simulation_simulation.h
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
