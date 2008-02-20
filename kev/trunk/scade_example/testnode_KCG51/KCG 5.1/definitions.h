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

#ifdef SIM
#include "sim_types.h"
#endif

#define _copy_mem(t,d,s) Copy_mem(t,d,s)
extern int _copy_mem( int, void *, const void *);

#define _comp_mem(t,x,y) Comp_mem(t,x,y)
extern int _comp_mem( int, const void *, const void *);



/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** End of file definitions.h
** End of generation (MM/DD/YYYY) : 01/11/2007 17:45:53
*******************************************************************$*/
