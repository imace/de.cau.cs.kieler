/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** Command:  s2c  -target C -O 0 -debug -probes -node simulation::Simulation -target_dir U:/shared/modelgui/trunk/scade6_example/Simulation U:/shared/modelgui/trunk/scade6_example/Simulation/Simulation.scade
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */

#include "elevator_elevator.h"
void elevator_reset_elevator(outC_elevator_elevator *outC)
{
  outC->_init = kcg_true;
  RisingEdgeRetrigger_reset_digit(&outC->Context_RisingEdgeRetrigger);
  Counter_int_reset_pwlinear(&outC->Context_Counter_int);
}
void elevator_elevator(
  ControlDataType_elevator *controlData /* elevator::elevator::controlData */,
  outC_elevator_elevator *outC)
{
  outC->_L34 = 1;
  outC->_L33 = -1;
  outC->_L20 = 0;
  outC->_L19 = 100;
  if (outC->_init)
    {
      outC->_L13 = 0;
    }
  else
    {
      outC->_L13 = outC->_L16;
    }
  outC->_L11 = 1;
  outC->_L7 = -1;
  outC->_L6 = 0;
  copy_struct_1 ( &outC->_L1 , controlData );
  outC->direction = outC->_L13;
  outC->buttonUp = outC->_L1.buttonUp;
  outC->buttonDown = outC->_L1.buttonDown;
  outC->_L4 = outC->_L1.buttonAlarm;
  outC->_L32 = outC->direction;
  outC->_L31 = outC->_L32 == outC->_L34;
  outC->_L30 = outC->_L32 == outC->_L33;
  RisingEdgeRetrigger_digital(outC->_L4, 10, &outC->Context_RisingEdgeRetrigger);
  outC->_L27 = outC->Context_RisingEdgeRetrigger.RER_Output;
  outC->alarm = outC->_L27;
  outC->_L15 = outC->direction;
  if (outC->buttonDown)
    {
      outC->_L12 = outC->_L7;
    }
  else
    {
      outC->_L12 = outC->_L15;
    }
  if (outC->buttonUp)
    {
      outC->_L10 = outC->_L11;
    }
  else
    {
      outC->_L10 = outC->_L12;
    }
  Counter_int_pwlinear(outC->_L15, kcg_false, &outC->Context_Counter_int);
  outC->_L8 = outC->Context_Counter_int.Count;
  outC->_L22 = outC->alarm;
  outC->_L18 = outC->_L8 >= outC->_L19;
  outC->_L17 = outC->_L8 <= outC->_L6;
  outC->_L39 = (outC->_L17) kcg_or (outC->_L18);
  outC->_L29 = (outC->_L31) kcg_and (outC->_L18);
  outC->_L28 = (outC->_L30) kcg_and (outC->_L17);
  if (outC->_L28)
    {
      outC->_L14 = outC->_L20;
    }
  else
    {
      outC->_L14 = outC->_L10;
    }
  outC->_L40 = kcg_not outC->_L39;
  if (outC->_L29)
    {
      outC->_L16 = outC->_L20;
    }
  else
    {
      outC->_L16 = outC->_L14;
    }
  outC->_L2.direction = outC->_L16;
  outC->_L2.alarm = outC->_L22;
  outC->_L2.position = outC->_L8;
  outC->_L2.doorClosed = outC->_L40;
  copy_struct_2 ( &outC->out_displayData , &outC->_L2 );
  outC->_init = kcg_false;
}


/* $************* KCG Version 6.0.0 FCS a (build i3) *******************************
** elevator_elevator.c
** Generation date: 2007-09-21T13:34:21
*************************************************************$ */
