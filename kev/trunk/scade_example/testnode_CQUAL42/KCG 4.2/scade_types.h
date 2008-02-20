/*$************* SCADE_KCG KCG Version 4.2.0 (build i20) **************
** Command :
** l2C        scade_example.lus -node testnode
**     -noexp @ALL@
**     -noassert
**     -const
**     -bitwise
**     -split
**     -no_copy_mem
** date of generation (MM/DD/YYYY): 01/11/2007 10:31:43
** last modification date for scade_example.lus (MM/DD/YYYY): 01/11/2007 
********************************************************************$*/

/* ===== */
/* TYPES */
/* ===== */

#include "config_types.h"

#define _INCLUDE_SCADE_TYPES

typedef struct {
_int _F0;
_int _F1;
_int _F2;
_int _F3;
_int _F4;
_int _F5;
_int _F6;
_int _F7;
_int _F8;
_int _F9;
} _T0_testnode;

typedef _T0_testnode intArray10;

typedef _int states;

typedef struct {
_int integer_val;
real float_val;
bool boolean_val;
states enumeration_val;
} _T1_testnode;

typedef _T1_testnode guiControlData;

typedef struct {
_int waterlevel;
} _T2_testnode;

typedef _T2_testnode guiDisplayData;





/*$************* SCADE_KCG KCG Version 4.2.0 (build i20) **************
** End of file scade_types.h
** End of generation (MM/DD/YYYY) : 01/11/2007 10:31:43
********************************************************************$*/
