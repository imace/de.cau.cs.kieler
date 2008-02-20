/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node simulation::Simulation -target_dir U:/shared/modelgui/trunk/scade6_example/Simulation U:/shared/modelgui/trunk/scade6_example/Simulation/Simulation.scade
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */

#include "Simulation_simulation.h"
void Simulation_reset_simulation(outC_Simulation_simulation *outC)
{
  elevator_reset_elevator(&outC->Context_elevator);
}
void Simulation_simulation(
  inC_Simulation_simulation *inC,
  outC_Simulation_simulation *outC)
{
  copy_struct_1 ( &outC->_L2 , &inC->controlData );
  elevator_elevator(&outC->_L2, &outC->Context_elevator);
  copy_struct_2 ( &outC->_L3 , &outC->Context_elevator.out_displayData );
  copy_struct_2 ( &outC->displayData , &outC->_L3 );
}


/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Simulation_simulation.c
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
