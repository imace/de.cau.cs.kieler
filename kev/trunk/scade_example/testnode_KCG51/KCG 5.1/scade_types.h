/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** Command :
** l2C        scade_example.lus -node testnode
**     -noexp @ALL@
**     -noassert
**     -const
**     -bitwise
**     -split
**     -no_copy_mem
** date of generation (MM/DD/YYYY): 01/11/2007 17:45:53
** last modification date for scade_example.lus (MM/DD/YYYY): 01/11/2007 
*******************************************************************$*/

/* ===== */
/* TYPES */
/* ===== */

#include "config_types.h"

#define _INCLUDE_SCADE_TYPES

typedef struct {
_int integer_val;
real float_val;
bool boolean_val;
} _T0_testnode;

typedef _T0_testnode guiControlData;

typedef struct {
_int waterlevel;
} _T1_testnode;

typedef _T1_testnode guiDisplayData;

typedef _int states;





/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** End of file scade_types.h
** End of generation (MM/DD/YYYY) : 01/11/2007 17:45:53
*******************************************************************$*/
