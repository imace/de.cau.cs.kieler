/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node simulation::Simulation -target_dir U:/shared/modelgui/trunk/scade6_example/Simulation U:/shared/modelgui/trunk/scade6_example/Simulation/Simulation.scade
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */

#include "Counter_int_pwlinear.h"
void Counter_int_reset_pwlinear(outC_Counter_int_pwlinear *outC)
{
  outC->_init = kcg_true;
}
void Counter_int_pwlinear(
  kcg_int Incr /* pwlinear::Counter::Incr */,
  kcg_bool Reset /* pwlinear::Counter::Reset */,
  outC_Counter_int_pwlinear *outC)
{
  outC->_L46 = 0;
  if (outC->_init)
    {
      outC->_L18 = outC->_L46;
    }
  else
    {
      outC->_L18 = outC->_L9;
    }
  outC->_L3 = Reset;
  outC->_L2 = Incr;
  if (outC->_L3)
    {
      outC->_L4 = outC->_L46;
    }
  else
    {
      outC->_L4 = outC->_L18;
    }
  outC->_L9 = outC->_L4 + outC->_L2;
  outC->Count = outC->_L9;
  outC->_init = kcg_false;
}


/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Counter_int_pwlinear.c
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
