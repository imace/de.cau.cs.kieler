/*
  File: /home/ctr/shared/kep/KEP/Esterel/development/kep-e/softkep/Code/softkep_strl.h
  Date: Mon Sep 28 20:53:28 2009

  Module: softkep

  Generated by eicc:
               version: v7_51i24
               released: 03/07/2008
               rcs name: p638r8
  With libraries: eic (p882r14), BigNum (p38r1)
*/

/* softkep STRL HEADER */

#ifndef softkep_STRL_HEADER
#define softkep_STRL_HEADER

#include "bignum_fct.h"

/* BASIC TYPES */

typedef char boolean;
typedef int integer;
#ifndef STRLEN
#define STRLEN 81
#endif
typedef char* string;
typedef unsigned int unsigned_int_type;
typedef signed int signed_int_type;


/* ENUM TYPES */



/* SYNONYM TYPES */

typedef unsigned_int_type addr_addr_type; /* BIT VECTOR TYPE WITH 12 BITS */
typedef bignum_t* instr_type; /* BIT VECTOR TYPE WITH 40 BITS */
typedef unsigned_int_type instr_data_type;
typedef unsigned_int_type rom_addr_type; /* BIT VECTOR TYPE WITH 6 BITS */
typedef unsigned_int_type delay_counter_type; /* BIT VECTOR TYPE WITH 4 BITS */
typedef unsigned_int_type program_counter_type;
typedef unsigned_int_type signal_addr_type; /* BIT VECTOR TYPE WITH 3 BITS */
typedef unsigned_int_type signal_value_type; /* BIT VECTOR TYPE WITH 4 BITS */
typedef unsigned_int_type signal_status_type; /* BIT VECTOR TYPE WITH 8 BITS */
typedef unsigned_int_type sig_type; /* BIT VECTOR TYPE WITH 4 BITS */
typedef unsigned_int_type sig_await_type; /* BIT VECTOR TYPE WITH 5 BITS */
typedef unsigned_int_type await_type; /* BIT VECTOR TYPE WITH 5 BITS */
typedef unsigned_int_type thread_id_type; /* BIT VECTOR TYPE WITH 2 BITS */
typedef unsigned_int_type thread_prio_type; /* BIT VECTOR TYPE WITH 3 BITS */
typedef unsigned_int_type thread_type; /* BIT VECTOR TYPE WITH 20 BITS */
typedef unsigned_int_type char_type;
typedef unsigned_int_type preemption_type; /* BIT VECTOR TYPE WITH 3 BITS */
typedef unsigned_int_type watcher_id_type;
typedef unsigned_int_type watcher_type; /* BIT VECTOR TYPE WITH 26 BITS */
typedef unsigned_int_type V7_bool_3_T19; /* BIT VECTOR TYPE WITH 3 BITS */
typedef unsigned_int_type data_type;
typedef unsigned_int_type sig_data_type; /* BIT VECTOR TYPE WITH 8 BITS */
typedef unsigned_int_type sig_reg_type; /* BIT VECTOR TYPE WITH 5 BITS */
typedef unsigned_int_type sig_addr_type; /* BIT VECTOR TYPE WITH 10 BITS */
typedef unsigned_int_type sig_addr_watcher_type; /* BIT VECTOR TYPE WITH 16 BITS */
typedef unsigned_int_type reg_reg_type; /* BIT VECTOR TYPE WITH 2 BITS */
typedef unsigned_int_type reg_data_type; /* BIT VECTOR TYPE WITH 5 BITS */
typedef unsigned_int_type par_type; /* BIT VECTOR TYPE WITH 11 BITS */
typedef unsigned_int_type pare_type; /* BIT VECTOR TYPE WITH 9 BITS */
typedef unsigned_int_type prio_type; /* BIT VECTOR TYPE WITH 5 BITS */
typedef unsigned_int_type V7_bool_8_T37; /* BIT VECTOR TYPE WITH 8 BITS */
typedef unsigned_int_type V7_bool_4_T45; /* BIT VECTOR TYPE WITH 4 BITS */
typedef unsigned_int_type V7_bool_7_T48; /* BIT VECTOR TYPE WITH 7 BITS */
typedef unsigned_int_type register_value_type; /* BIT VECTOR TYPE WITH 4 BITS */
typedef unsigned_int_type register_addr_type; /* BIT VECTOR TYPE WITH 1 BITS */
typedef unsigned_int_type trace_buffer_addr_type; /* BIT VECTOR TYPE WITH 5 BITS */
typedef unsigned_int_type two_chars_type; /* BIT VECTOR TYPE WITH 8 BITS */
typedef unsigned_int_type testdriver_sig_addr_type; /* BIT VECTOR TYPE WITH 12 BITS */
typedef unsigned_int_type testdriver_instr_addr_type; /* BIT VECTOR TYPE WITH 16 BITS */
typedef bignum_t* V7_bool_40_T65; /* BIT VECTOR TYPE WITH 40 BITS */
typedef unsigned_int_type V7_bool_6_T66; /* BIT VECTOR TYPE WITH 6 BITS */
typedef bignum_t* V7_bool_64_40_T84[64]; /* BIT VECTOR TYPE WITH 40 BITS */
typedef unsigned_int_type V7_bool_32_6_T85[32]; /* BIT VECTOR TYPE WITH 6 BITS */
typedef unsigned_int_type V7_bool_4_26_T86[4]; /* BIT VECTOR TYPE WITH 26 BITS */
typedef unsigned_int_type V7_bool_4_20_T87[4]; /* BIT VECTOR TYPE WITH 20 BITS */
typedef unsigned_int_type V7_bool_4_5_T88[4]; /* BIT VECTOR TYPE WITH 5 BITS */
typedef unsigned_int_type V7_bool_5_T90; /* BIT VECTOR TYPE WITH 5 BITS */
typedef unsigned_int_type V7_unsigned_1b_2_2_T91[2][2];
typedef unsigned_int_type V7_bool_2_T92; /* BIT VECTOR TYPE WITH 2 BITS */
typedef unsigned_int_type V7_unsigned_1b_2_T95[2];
typedef unsigned_int_type V7_bool_1_T97; /* BIT VECTOR TYPE WITH 1 BITS */
typedef bignum_t* V7_bool_64_T98; /* BIT VECTOR TYPE WITH 64 BITS */
typedef unsigned_int_type V7_bool_32_T99; /* BIT VECTOR TYPE WITH 32 BITS */


/* UNIVERSAL REACTIVE API */

/* INPUT FUNCTIONS */
extern void softkep_I_ExtIn (int);
extern void softkep_I_rx_raw_data (char_type);

#ifndef _NO_EXTERN_DEFINITIONS

/* INPUT VALUE-ONLY FUNCTIONS */

/* OUTPUT FUNCTIONS */
#ifndef _NO_OUTPUT_FUNCTION_DEFINITIONS
#ifndef softkep_O_ExtOut
extern void softkep_O_ExtOut (int);
#endif
#ifndef softkep_O_tick_warn
extern void softkep_O_tick_warn (void);
#endif
#ifndef softkep_O_tx_data
extern void softkep_O_tx_data (char_type);
#endif
#ifndef softkep_O_no_rx_error
extern void softkep_O_no_rx_error (void);
#endif
#ifndef softkep_O_tx_busy
extern void softkep_O_tx_busy (void);
#endif
#ifndef softkep_O_no_tx_error
extern void softkep_O_no_tx_error (void);
#endif
#endif

#endif

/* OUTPUT VALUE-ONLY FUNCTIONS */

/* INIT FUNCTION */
extern int softkep_init (void);

/* END FUNCTION */
extern int softkep_end (void);

/* RESET FUNCTION */
extern int softkep_reset (void);

/* REACTION FUNCTION */
extern int softkep (void);


#endif
