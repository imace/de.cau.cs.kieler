/*** file modified for simulation purpose ***/
/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** Command :
** l2C        Elevator.lus -node Elevator
**     -noexp @ALL@
**     -keep_named_var
**     -const
**     -bitwise
**     -loc_ctx
**     -no_copy_mem
**     -debug
** date of generation (MM/DD/YYYY): 01/16/2007 14:24:19
** last modification date for Elevator.lus (MM/DD/YYYY): 01/16/2007 
*******************************************************************$*/

#include "Elevator.h"

/* ============== */
/* INITIALISATION */
/* ============== */

void Controller_init(_C_Controller * _C_)
{
    (_C_->_M_init_0_Elevator) = true;
}


void Position_init(_C_Position * _C_)
{
}


void ClockCounter_init(_C_ClockCounter * _C_)
{
    (_C_->_M_init_0_Elevator) = true;
}


void Second_init(_C_Second * _C_)
{
    ClockCounter_init(&(_C_->_C_1_ClockCounter));
}


void KeepDoorOpen_init(_C_KeepDoorOpen * _C_)
{
}


void Elevator_init(_C_Elevator * _C_)
{
    Second_init(&(_C_->_C_1_Second));
    Position_init(&(_C_->_C_1_Position));
    Controller_init(&(_C_->_C_1_Controller));
    KeepDoorOpen_init(&(_C_->_C_1_KeepDoorOpen));
}

/* ================================*/
/* MAIN NODE (AND UNEXPANDED NODES) */
/* ================================ */

bool Controller(_C_Controller * _C_)
{
/*#code for node Controller */
#ifdef SIM
    sim_callback(sim_breakpoint_begin, "Controller");
#endif
    if ((_C_->_M_init_0_Elevator)) {
	(_C_->_LE9_Elevator) = true;
    } else {
	(_C_->_LE9_Elevator) = (_C_->_LE8_Elevator);
    }
    (_C_->_LE4_Elevator) = (_C_->_I4_IsUp);
    if ((_C_->_M_init_0_Elevator)) {
	(_C_->_LE19_Elevator) = false;
    } else {
	(_C_->_LE19_Elevator) = (_C_->_LE18_Elevator);
    }
    (_C_->_LE13_Elevator) =
	((((_C_->_LE9_Elevator) ^ true) & (_C_->_LE4_Elevator)) & (_C_->
								   _LE19_Elevator));
    (_C_->_LE24_Elevator) = (_C_->_LE13_Elevator);
    (_C_->_LE25_Elevator) = (_C_->_LE24_Elevator);
    (_C_->_LE0_Elevator) = (_C_->_I0_ButtonUp);
    if ((_C_->_M_init_0_Elevator)) {
	(_C_->_LE21_Elevator) = false;
    } else {
	(_C_->_LE21_Elevator) = (_C_->_LE20_Elevator);
    }
    (_C_->_LE16_Elevator) = ((_C_->_LE9_Elevator) | (_C_->_LE21_Elevator));
    (_C_->_LE17_Elevator) = ((_C_->_LE0_Elevator) & (_C_->_LE16_Elevator));
    (_C_->_LE23_Elevator) = (_C_->_LE17_Elevator);
    (_C_->_LE22_Elevator) = (_C_->_LE9_Elevator);
    if ((_C_->_M_init_0_Elevator)) {
	(_C_->_L2_Elevator) = 0;
    } else {
	(_C_->_L2_Elevator) = (_C_->_LVF5_Elevator);
    }
    if ((_C_->_LE22_Elevator)) {
	(_C_->_LVF2_Elevator) = 0;
    } else {
	(_C_->_LVF2_Elevator) = (_C_->_L2_Elevator);
    }
    if ((_C_->_LE23_Elevator)) {
	(_C_->_LVF4_Elevator) = 1;
    } else {
	(_C_->_LVF4_Elevator) = (_C_->_LVF2_Elevator);
    }
    if ((_C_->_LE25_Elevator)) {
	(_C_->_LVF5_Elevator) = 0;
    } else {
	(_C_->_LVF5_Elevator) = (_C_->_LVF4_Elevator);
    }
    (_C_->_O0_Move) = (_C_->_LVF5_Elevator);
    if ((_C_->_M_init_0_Elevator)) {
	(_C_->_LE15_Elevator) = false;
    } else {
	(_C_->_LE15_Elevator) = (_C_->_LE14_Elevator);
    }
    (_C_->_LE3_Elevator) = (_C_->_I3_Second);
    (_C_->_LE10_Elevator) =
	((((_C_->_LE9_Elevator) ^ true) & (_C_->_LE15_Elevator)) & (_C_->
								    _LE3_Elevator));
    if ((_C_->_M_init_0_Elevator)) {
	(_C_->_L0_Elevator) = 0;
    } else {
	(_C_->_L0_Elevator) = (_C_->_LVF6_Elevator);
    }
    (_C_->_LE11_Elevator) = (_C_->_LE10_Elevator);
    if ((_C_->_M_init_0_Elevator)) {
	(_C_->_L1_Elevator) = 0;
    } else {
	(_C_->_L1_Elevator) = (_C_->_LVF6_Elevator);
    }
    if ((_C_->_LE11_Elevator)) {
	(_C_->_LVF0_Elevator) = ((_C_->_L0_Elevator) - 1);
	(_C_->_LE29_Elevator) = ((_C_->_LVF0_Elevator) <= 0);
    } else {
	(_C_->_LVF0_Elevator) = (_C_->_L1_Elevator);
	(_C_->_LE29_Elevator) = false;
    }
    (_C_->_LE12_Elevator) =
	((_C_->_LE10_Elevator) & (_C_->_LE29_Elevator));
    (_C_->_LE6_Elevator) = (_C_->_LE12_Elevator);
    (_C_->_O1_AlarmLamp) = (_C_->_LE6_Elevator);
    (_C_->_LE28_Elevator) = false;
    (_C_->_LE7_Elevator) = (_C_->_LE28_Elevator);
    (_C_->_O2_OpenDoor) = (_C_->_LE7_Elevator);
    (_C_->_LE8_Elevator) = false;
    (_C_->_LE18_Elevator) =
	((_C_->
	  _LE17_Elevator) | ((((_C_->_LE9_Elevator) ^ true) &
			      ((_C_->_LE4_Elevator) ^ true)) & (_C_->
								_LE19_Elevator)));
    (_C_->_LE20_Elevator) =
	(((_C_->_LE17_Elevator) ^ true) & (_C_->_LE16_Elevator));
    (_C_->_LE14_Elevator) =
	((_C_->
	  _LE13_Elevator) | ((((_C_->_LE9_Elevator) ^ true) &
			      (_C_->_LE15_Elevator)) & ((_C_->
							 _LE12_Elevator) ^
							true)));
    (_C_->_LE26_Elevator) = (_C_->_LE13_Elevator);
    (_C_->_LE27_Elevator) = (_C_->_LE26_Elevator);
    if ((_C_->_LE27_Elevator)) {
	(_C_->_LVF6_Elevator) = 3;
    } else {
	(_C_->_LVF6_Elevator) = (_C_->_LVF0_Elevator);
    }
    (_C_->_M_init_0_Elevator) = false;
#ifdef SIM
    sim_callback(sim_breakpoint_end, "Controller");
#endif
/*#end code for node Controller */
    return (true);
}

bool Position(_C_Position * _C_)
{
/*#code for node Position */
#ifdef SIM
    sim_callback(sim_breakpoint_begin, "Position");
#endif
    (_C_->_L2_Elevator) = 50;
    (_C_->_O0_Position) = (_C_->_L2_Elevator);
#ifdef SIM
    sim_callback(sim_breakpoint_end, "Position");
#endif
/*#end code for node Position */
    return (true);
}

bool ClockCounter(_C_ClockCounter * _C_)
{
/*#code for node ClockCounter */
#ifdef SIM
    sim_callback(sim_breakpoint_begin, "ClockCounter");
#endif
    (_C_->_L11_Elevator) = 0;
    (_C_->_L16_Elevator) = 0;
    (_C_->_L13_Elevator) = (_C_->_I0_Reset);
    (_C_->_L8_Elevator) = 1;
    (_C_->_L7_Elevator) = ((_C_->_L8_Elevator) + (_C_->_L1_Elevator));
    if ((_C_->_L13_Elevator)) {
	(_C_->_L2_Elevator) = (_C_->_L16_Elevator);
    } else {
	(_C_->_L2_Elevator) = (_C_->_L7_Elevator);
    }
    if ((_C_->_M_init_0_Elevator)) {
	(_C_->_L1_Elevator) = (_C_->_L11_Elevator);
    } else {
	(_C_->_L1_Elevator) = (_C_->_L2_Elevator);
    }
    (_C_->_O0_Count) = (_C_->_L1_Elevator);
    (_C_->_M_init_0_Elevator) = false;
#ifdef SIM
    sim_callback(sim_breakpoint_end, "ClockCounter");
#endif
/*#end code for node ClockCounter */
    return (true);
}

bool Second(_C_Second * _C_)
{
/*#code for node Second */
#ifdef SIM
    sim_callback(sim_breakpoint_begin, "Second");
#endif
/* call to node not expanded ClockCounter */
/* occurrence number of the node ClockCounter : 1 */
    (_C_->_C_1_ClockCounter._I0_Reset) = (_C_->_L3_Elevator);
    if (!ClockCounter(&(_C_->_C_1_ClockCounter)))
	return (false);
    (_C_->_L2_Elevator) = (_C_->_C_1_ClockCounter._O0_Count);
    (_C_->_L4_Elevator) = 5;
    (_C_->_L3_Elevator) = ((_C_->_L2_Elevator) == (_C_->_L4_Elevator));
    (_C_->_O0_Second) = (_C_->_L3_Elevator);
#ifdef SIM
    sim_callback(sim_breakpoint_end, "Second");
#endif
/*#end code for node Second */
    return (true);
}

bool KeepDoorOpen(_C_KeepDoorOpen * _C_)
{
/*#code for node KeepDoorOpen */
#ifdef SIM
    sim_callback(sim_breakpoint_begin, "KeepDoorOpen");
#endif
    (_C_->_L1_Elevator) = (_C_->_I0_Second);
    (_C_->_L2_Elevator) = (_C_->_I1_OpenDoor);
    (_C_->_L17_Elevator) = ((_C_->_L1_Elevator) & (_C_->_L2_Elevator));
    (_C_->_O0_DoorIsOpen) = (_C_->_L17_Elevator);
#ifdef SIM
    sim_callback(sim_breakpoint_end, "KeepDoorOpen");
#endif
/*#end code for node KeepDoorOpen */
    return (true);
}

bool Elevator(_C_Elevator * _C_)
{
/*#code for node Elevator */
#ifdef SIM
    sim_callback(sim_breakpoint_begin, "Elevator");
#endif
    (_C_->_L25_Elevator) = (*(_C_->_I0_guiControlData));
    (_C_->_L26_Elevator) = (((_C_->_L25_Elevator)).button_up);
    (_C_->_L27_Elevator) = (((_C_->_L25_Elevator)).button_down);
    (_C_->_L28_Elevator) = (((_C_->_L25_Elevator)).button_alarm);
/* call to node not expanded Second */
/* occurrence number of the node Second : 1 */
    if (!Second(&(_C_->_C_1_Second)))
	return (false);
    (_C_->_L15_Elevator) = (_C_->_C_1_Second._O0_Second);
    (_C_->_L19_Elevator) = 100;
    (_C_->_L16_Elevator) = ((_C_->_L19_Elevator) == (_C_->_L9_Elevator));
    (_C_->_L18_Elevator) = 0;
    (_C_->_L17_Elevator) = ((_C_->_L18_Elevator) == (_C_->_L9_Elevator));
/* call to node not expanded Controller */
/* occurrence number of the node Controller : 1 */
    (_C_->_C_1_Controller._I0_ButtonUp) = (_C_->_L26_Elevator);
    (_C_->_C_1_Controller._I1_ButtonDown) = (_C_->_L27_Elevator);
    (_C_->_C_1_Controller._I2_ButtonAlarm) = (_C_->_L28_Elevator);
    (_C_->_C_1_Controller._I3_Second) = (_C_->_L15_Elevator);
    (_C_->_C_1_Controller._I4_IsUp) = (_C_->_L16_Elevator);
    (_C_->_C_1_Controller._I5_IsDown) = (_C_->_L17_Elevator);
    if (!Controller(&(_C_->_C_1_Controller)))
	return (false);
    (_C_->_L5_Elevator) = (_C_->_C_1_Controller._O0_Move);
    (_C_->_L20_Elevator) = (_C_->_C_1_Controller._O1_AlarmLamp);
    (_C_->_L23_Elevator) = (_C_->_C_1_Controller._O2_OpenDoor);
/* call to node not expanded Position */
/* occurrence number of the node Position : 1 */
    (_C_->_C_1_Position._I0_Motor) = (_C_->_L5_Elevator);
    if (!Position(&(_C_->_C_1_Position)))
	return (false);
    (_C_->_L9_Elevator) = (_C_->_C_1_Position._O0_Position);
/* call to node not expanded KeepDoorOpen */
/* occurrence number of the node KeepDoorOpen : 1 */
    (_C_->_C_1_KeepDoorOpen._I0_Second) = (_C_->_L15_Elevator);
    (_C_->_C_1_KeepDoorOpen._I1_OpenDoor) = (_C_->_L23_Elevator);
    (_C_->_C_1_KeepDoorOpen._I2_Delay) = 30;
    if (!KeepDoorOpen(&(_C_->_C_1_KeepDoorOpen)))
	return (false);
    (_C_->_L24_Elevator) = (_C_->_C_1_KeepDoorOpen._O0_DoorIsOpen);
    ((_C_->_L33_Elevator).motor_dir) = (_C_->_L5_Elevator);
    ((_C_->_L33_Elevator).alarm) = (_C_->_L20_Elevator);
    ((_C_->_L33_Elevator).position) = (_C_->_L9_Elevator);
    ((_C_->_L33_Elevator).doorIsOpen) = (_C_->_L24_Elevator);
    (_C_->_O0_guDisplayData) = (_C_->_L33_Elevator);
#ifdef SIM
    sim_callback(sim_breakpoint_end, "Elevator");
#endif
/*#end code for node Elevator */
    return (true);
}



/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** End of file Elevator.c
** End of generation (MM/DD/YYYY) : 01/16/2007 14:24:19
*******************************************************************$*/
