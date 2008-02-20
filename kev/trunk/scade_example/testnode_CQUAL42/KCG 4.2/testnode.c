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

#include "testnode_main.h"

#include "testnode.h"

/* ============== */
/* INITIALISATION */
/* ============== */

void testnode_init(_C_testnode * _C_)
{
}

/* ========= */
/* MAIN NODE */
/* ========= */

void testnode(_C_testnode * _C_)
{
/*#code for node testnode */
    (_C_->_O0_out_int) = (_C_->_I0_in_int);
    (_C_->_O1_out_bool) = (_C_->_I1_in_bool);
    (_C_->_O2_out_real) = (_C_->_I2_in_real);
    (_C_->_O3_out_intarray) = (*(_C_->_I3_int_intarray));
    ((_C_->_O4_guiDisplayData).waterlevel) = 30;
/*#end code for node testnode */
}



/*$************* SCADE_KCG KCG Version 4.2.0 (build i20) **************
** End of file testnode.c
** End of generation (MM/DD/YYYY) : 01/11/2007 10:31:43
********************************************************************$*/
