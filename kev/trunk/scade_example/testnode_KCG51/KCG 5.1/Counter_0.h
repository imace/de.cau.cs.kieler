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

#define _INCLUDE_Counter_0

/* ======================== */
/* CONTEXT for node Counter_0 */
/* ======================== */

/* Type for context */
typedef struct {
_int _I0_Incr;
bool _I1_Reset;
_int _O0_Count;
bool _M_init_0_testnode;
} _C_Counter_0;

/* ============== */
/* INITIALISATION */
/* ============== */
extern void Counter_0_init (_C_Counter_0 *);

/* =============== */
/* CYCLIC FUNCTION */
/* =============== */
extern void Counter_0 (_C_Counter_0 *);



/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** End of file Counter_0.h
** End of generation (MM/DD/YYYY) : 01/11/2007 17:45:53
*******************************************************************$*/
