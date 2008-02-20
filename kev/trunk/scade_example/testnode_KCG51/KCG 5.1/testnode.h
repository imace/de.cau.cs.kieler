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

#ifndef _INCLUDE_Counter_0
#    include "Counter_0.h"
#endif

#define _INCLUDE_testnode

/* ======================== */
/* CONTEXT for node testnode */
/* ======================== */

/* Type for context */
typedef struct {
guiControlData *_I0_guiControlData;
guiDisplayData _O0_guiDisplayData;
bool _L1_testnode;
bool _M_init_0_testnode;
_C_Counter_0 _C_1_Counter_0;
} _C_testnode;

/* ============== */
/* INITIALISATION */
/* ============== */
extern void testnode_init (_C_testnode *);

/* =============== */
/* CYCLIC FUNCTION */
/* =============== */
extern void testnode (_C_testnode *);



/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** End of file testnode.h
** End of generation (MM/DD/YYYY) : 01/11/2007 17:45:53
*******************************************************************$*/
