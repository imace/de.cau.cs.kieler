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

#include "testnode.h"

/* ============== */
/* INITIALISATION */
/* ============== */

void testnode_init(_C_testnode * _C_)
{
    (_C_->_M_init_0_testnode) = true;
    Counter_0_init(&(_C_->_C_1_Counter_0));
}

/* ========= */
/* MAIN NODE */
/* ========= */

void testnode(_C_testnode * _C_)
{
    bool _L0_testnode;
/*#code for node testnode */
    if ((_C_->_M_init_0_testnode)) {
	_L0_testnode = true;
    } else {
	_L0_testnode = (_C_->_L1_testnode);
    }
/* call to node not expanded Counter_0 */
/* occurrence number of the node Counter_0 : 1 */
    (_C_->_C_1_Counter_0._I0_Incr) = 1;
    (_C_->_C_1_Counter_0._I1_Reset) = _L0_testnode;
    Counter_0(&(_C_->_C_1_Counter_0));
    ((_C_->_O0_guiDisplayData).waterlevel) =
	(_C_->_C_1_Counter_0._O0_Count);
    (_C_->_L1_testnode) = ((_C_->_C_1_Counter_0._O0_Count) >= 100);
    (_C_->_M_init_0_testnode) = false;
/*#end code for node testnode */
}



/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** End of file testnode.c
** End of generation (MM/DD/YYYY) : 01/11/2007 17:45:53
*******************************************************************$*/
