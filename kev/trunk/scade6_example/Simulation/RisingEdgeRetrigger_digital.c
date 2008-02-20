/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node simulation::Simulation -target_dir U:/shared/modelgui/trunk/scade6_example/Simulation U:/shared/modelgui/trunk/scade6_example/Simulation/Simulation.scade
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */

#include "RisingEdgeRetrigger_digital.h"
void RisingEdgeRetrigger_reset_digit(outC_RisingEdgeRetrigger_digita *outC)
{
  outC->_init = kcg_true;
  count_down_reset_digital(&outC->Context_count_down);
}
void RisingEdgeRetrigger_digital(
  kcg_bool RER_Input /* digital::RisingEdgeRetrigger::RER_Input */,
  kcg_int NumberOfCycle /* digital::RisingEdgeRetrigger::NumberOfCycle */,
  outC_RisingEdgeRetrigger_digita *outC)
{
  
  kcg_int tmp;
  
  outC->_L50 = 0;
  outC->_L47 = kcg_false;
  outC->_L36 = kcg_false;
  if (outC->_init)
    {
      outC->_L39 = outC->_L36;
    }
  else
    {
      outC->_L39 = outC->_L43;
    }
  outC->_L41 = NumberOfCycle;
  outC->_L44 = 0;
  outC->_L14 = outC->_L31;
  outC->_L13 = RER_Input;
  outC->_L31 = kcg_not outC->_L13;
  outC->_L16 = (outC->_L13) kcg_and (outC->_L14);
  if (outC->_init)
    {
      outC->_L46 = outC->_L47;
    }
  else
    {
      outC->_L46 = outC->_L16;
    }
  outC->_L38 = (outC->_L39) kcg_or (outC->_L46);
  outC->rew = outC->_L38;
  if (outC->rew)
    {
      count_down_digital(outC->_L46, outC->_L41, &outC->Context_count_down);
      if (outC->rew)
        {
          tmp = outC->Context_count_down.cpt;
        }
    }
  if (outC->rew)
    {
      if (outC->rew)
        {
          outC->_L48 = tmp;
        }
    }
  if (kcg_not outC->rew)
    {
      if (kcg_not outC->rew)
        {
          if (outC->_init)
            {
              outC->_L48 = outC->_L50;
            }
          else
            {
              outC->_L48 = outC->_L48;
            }
        }
    }
  outC->_L35 = outC->_L44 < outC->_L48;
  outC->_L43 = (outC->_L38) kcg_and (outC->_L35);
  outC->RER_Output = outC->_L43;
  outC->_init = kcg_false;
}


/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** RisingEdgeRetrigger_digital.c
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
