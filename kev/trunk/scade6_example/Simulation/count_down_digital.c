/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node simulation::Simulation -target_dir U:/shared/modelgui/trunk/scade6_example/Simulation U:/shared/modelgui/trunk/scade6_example/Simulation/Simulation.scade
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */

#include "count_down_digital.h"
void count_down_reset_digital(outC_count_down_digital *outC)
{
  outC->_init = kcg_true;
}
void count_down_digital(
  kcg_bool Reset /* digital::count_down::Reset */,
  kcg_int N /* digital::count_down::N */,
  outC_count_down_digital *outC)
{
  outC->_L13 = outC->_L4;
  outC->_L7 = 1;
  outC->_L2 = N;
  outC->_L1 = Reset;
  if (outC->_init)
    {
      outC->_L8 = outC->_L2;
    }
  else
    {
      outC->_L8 = outC->_L13;
    }
  if (outC->_L1)
    {
      outC->_L3 = outC->_L2;
    }
  else
    {
      outC->_L3 = outC->_L8;
    }
  outC->cpt = outC->_L3;
  outC->_L4 = outC->_L3 - outC->_L7;
  outC->_init = kcg_false;
}


/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** count_down_digital.c
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
