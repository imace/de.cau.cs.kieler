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

/* ===== */
/* TYPES */
/* ===== */

#include "config_types.h"

#define _INCLUDE_SCADE_TYPES

typedef struct {
bool button_up;
bool button_down;
bool button_alarm;
} _T0_Elevator;

typedef _T0_Elevator guiControlData;

typedef struct {
_int motor_dir;
bool alarm;
_int position;
bool doorIsOpen;
} _T1_Elevator;

typedef _T1_Elevator guiDisplayData;





/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** End of file scade_types.h
** End of generation (MM/DD/YYYY) : 01/16/2007 14:24:19
*******************************************************************$*/
