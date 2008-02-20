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

#ifndef _INCLUDE_SCADE_TYPES
#    include "scade_types.h"
#endif

#include "definitions.h"


/* ======================== */
/* CONTEXT for node Controller */
/* ======================== */

/* Type for context */
typedef struct {
bool _I0_ButtonUp;
bool _I1_ButtonDown;
bool _I2_ButtonAlarm;
bool _I3_Second;
bool _I4_IsUp;
bool _I5_IsDown;
_int _O0_Move;
bool _O1_AlarmLamp;
bool _O2_OpenDoor;
bool _LE9_Elevator;
bool _LE4_Elevator;
bool _LE19_Elevator;
bool _LE13_Elevator;
bool _LE24_Elevator;
bool _LE25_Elevator;
bool _LE0_Elevator;
bool _LE21_Elevator;
bool _LE16_Elevator;
bool _LE17_Elevator;
bool _LE23_Elevator;
bool _LE22_Elevator;
_int _L2_Elevator;
_int _LVF2_Elevator;
_int _LVF4_Elevator;
_int _LVF5_Elevator;
bool _LE15_Elevator;
bool _LE3_Elevator;
bool _LE10_Elevator;
_int _L0_Elevator;
bool _LE11_Elevator;
_int _L1_Elevator;
_int _LVF0_Elevator;
bool _LE29_Elevator;
bool _LE12_Elevator;
bool _LE6_Elevator;
bool _LE28_Elevator;
bool _LE7_Elevator;
bool _LE8_Elevator;
bool _LE18_Elevator;
bool _LE20_Elevator;
bool _LE14_Elevator;
bool _LE26_Elevator;
bool _LE27_Elevator;
_int _LVF6_Elevator;
bool _M_init_0_Elevator;
} _C_Controller;

/* ======================== */
/* CONTEXT for node Position */
/* ======================== */

/* Type for context */
typedef struct {
_int _I0_Motor;
_int _O0_Position;
_int _L2_Elevator;
} _C_Position;

/* ======================== */
/* CONTEXT for node ClockCounter */
/* ======================== */

/* Type for context */
typedef struct {
bool _I0_Reset;
_int _O0_Count;
_int _L11_Elevator;
_int _L16_Elevator;
bool _L13_Elevator;
_int _L8_Elevator;
_int _L7_Elevator;
_int _L2_Elevator;
_int _L1_Elevator;
bool _M_init_0_Elevator;
} _C_ClockCounter;

/* ======================== */
/* CONTEXT for node Second */
/* ======================== */

/* Type for context */
typedef struct {
bool _O0_Second;
_int _L2_Elevator;
_int _L4_Elevator;
bool _L3_Elevator;
_C_ClockCounter _C_1_ClockCounter;
} _C_Second;

/* ======================== */
/* CONTEXT for node KeepDoorOpen */
/* ======================== */

/* Type for context */
typedef struct {
bool _I0_Second;
bool _I1_OpenDoor;
_int _I2_Delay;
bool _O0_DoorIsOpen;
bool _L1_Elevator;
bool _L2_Elevator;
bool _L17_Elevator;
} _C_KeepDoorOpen;

/* ======================== */
/* CONTEXT for node Elevator */
/* ======================== */

/* Type for context */
typedef struct {
guiControlData *_I0_guiControlData;
guiDisplayData _O0_guDisplayData;
guiControlData _L25_Elevator;
bool _L26_Elevator;
bool _L27_Elevator;
bool _L28_Elevator;
bool _L15_Elevator;
_int _L19_Elevator;
bool _L16_Elevator;
_int _L18_Elevator;
bool _L17_Elevator;
_int _L5_Elevator;
bool _L20_Elevator;
bool _L23_Elevator;
_int _L9_Elevator;
bool _L24_Elevator;
guiDisplayData _L33_Elevator;
_C_Second _C_1_Second;
_C_Position _C_1_Position;
_C_Controller _C_1_Controller;
_C_KeepDoorOpen _C_1_KeepDoorOpen;
} _C_Elevator;

/* ============== */
/* INITIALISATION */
/* ============== */

extern void Controller_init (_C_Controller *);
extern void Position_init (_C_Position *);
extern void ClockCounter_init (_C_ClockCounter *);
extern void Second_init (_C_Second *);
extern void KeepDoorOpen_init (_C_KeepDoorOpen *);
extern void Elevator_init (_C_Elevator *);

/* ================ */
/* CYCLIC FUNCTIONS */
/* ================ */

extern bool Controller (_C_Controller *);
extern bool Position (_C_Position *);
extern bool ClockCounter (_C_ClockCounter *);
extern bool Second (_C_Second *);
extern bool KeepDoorOpen (_C_KeepDoorOpen *);
extern bool Elevator (_C_Elevator *);


/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** End of file Elevator.h
** End of generation (MM/DD/YYYY) : 01/16/2007 14:24:19
*******************************************************************$*/
