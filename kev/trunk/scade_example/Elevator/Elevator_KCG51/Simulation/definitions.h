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

#ifdef SIM
#include "sim_types.h"
#endif

#define _copy_mem(t,d,s) Copy_mem(t,d,s)
extern int _copy_mem( int, void *, const void *);

#define _comp_mem(t,x,y) Comp_mem(t,x,y)
extern int _comp_mem( int, const void *, const void *);

#ifdef SIM
#define __assert(x) sim_callback(sim_assertion,x)
#else
extern int  printf(const char *, ...);
#define __assert(x) printf ("Violation of the assertion %s\n", x); return (false)
#endif


/*$************* SCADE_KCG KCG Version 5.1.0 (build i4) **************
** End of file definitions.h
** End of generation (MM/DD/YYYY) : 01/16/2007 14:24:19
*******************************************************************$*/
