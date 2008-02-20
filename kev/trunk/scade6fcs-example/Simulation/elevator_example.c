/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node example::elevator -target_dir U:/shared/modelgui/trunk/scade6fcs-example/Simulation U:/shared/modelgui/trunk/scade6fcs-example/Simulation/elevator.scade
** Generation date: 2007-09-21T15:06:35
*************************************************************$ */

#include "elevator_example.h"
void elevator_reset_example(outC_elevator_example *outC)
{
  outC->_init = kcg_true;
}
void elevator_example(inC_elevator_example *inC, outC_elevator_example *outC)
{
  if (outC->_init)
    {
      outC->_L5 = 30;
    }
  else
    {
      outC->_L5 = outC->_L4;
    }
  outC->_L4 = 30;
  outC->_L3.position = outC->_L5;
  copy_struct_2 ( &outC->output , &outC->_L3 );
  copy_struct_1 ( &outC->_L1 , &inC->input );
  outC->_L2 = outC->_L1.button_up;
  outC->_underscore_ = outC->_L2;
  outC->_init = kcg_false;
}


/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** elevator_example.c
** Generation date: 2007-09-21T15:06:35
*************************************************************$ */
