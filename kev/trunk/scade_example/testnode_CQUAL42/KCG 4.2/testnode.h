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

#define _INCLUDE_testnode

/* ======================== */
/* CONTEXT for node testnode */
/* ======================== */

/* Type for context */
typedef struct {
_int _I0_in_int;
bool _I1_in_bool;
real _I2_in_real;
intArray10 *_I3_int_intarray;
guiControlData *_I4_guiControlData;
_int _O0_out_int;
bool _O1_out_bool;
real _O2_out_real;
intArray10 _O3_out_intarray;
guiDisplayData _O4_guiDisplayData;
} _C_testnode;

/* ============== */
/* INITIALISATION */
/* ============== */
extern void testnode_init (_C_testnode *);

/* =============== */
/* CYCLIC FUNCTION */
/* =============== */
extern void testnode (_C_testnode *);



/*$************* SCADE_KCG KCG Version 4.2.0 (build i20) **************
** End of file testnode.h
** End of generation (MM/DD/YYYY) : 01/11/2007 10:31:43
********************************************************************$*/
