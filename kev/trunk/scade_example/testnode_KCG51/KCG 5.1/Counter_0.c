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

#include "testnode_main.h"

#include "Counter_0.h"

/* ============== */
/* INITIALISATION */
/* ============== */

void Counter_0_init (_C_Counter_0 *_C_)
{
(_C_->_M_init_0_testnode) = true ;
}

/* ========= */
/* MAIN NODE */
/* ========= */

/* "Tracabilite_1" { Tracabilite = "Instantiate from Counter" } */
void Counter_0 (_C_Counter_0 *_C_)
{
_int _L45_testnode;
_int _L0_testnode;
_int _L1_testnode;
/*#code for node Counter_0 */
_L45_testnode = ((_C_->_I0_Incr) - (_C_->_I0_Incr));
if ((_C_->_M_init_0_testnode))
{
_L0_testnode = _L45_testnode;
}
else
{
_L0_testnode = (_C_->_O0_Count);
}
if ((_C_->_I1_Reset))
{
_L1_testnode = _L45_testnode;
}
else
{
_L1_testnode = _L0_testnode;
}
(_C_->_O0_Count) = (_L1_testnode + (_C_->_I0_Incr));
(_C_->_M_init_0_testnode) = false;
/*#end code for node Counter_0 */
}



/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** End of file Counter_0.c
** End of generation (MM/DD/YYYY) : 01/11/2007 17:45:53
*******************************************************************$*/
