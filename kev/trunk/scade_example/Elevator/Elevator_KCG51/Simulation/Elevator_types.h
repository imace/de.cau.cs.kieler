#ifndef _ELEVATOR_TYPE_H_
#define _ELEVATOR_TYPE_H_

#include "sim_types.h"

#ifndef _INCLUDE_SCADE_TYPES
# include "scade_types.h"
#endif


extern void print_char(char __c);
extern void print_bool(int __b);
extern void print_int(int __i);
extern void print_real(float __f);
extern void print_string(char *__str);
extern void print_token(char *__str);

void init_stdtypes_table(void);

void print_guiControlData_value(guiControlData _v);
int set_guiControlData(value* _v, guiControlData *p);
void print_guiControlData_type(void);
extern struct SimTypeVTable* pSimguiControlDataVTable;

void print_guiDisplayData_value(guiDisplayData _v);
int set_guiDisplayData(value* _v, guiDisplayData *p);
void print_guiDisplayData_type(void);
extern struct SimTypeVTable* pSimguiDisplayDataVTable;

void print_int_value(_int _v);
int set_int(value* _v, _int *p);
void print_int_type(void);
extern struct SimTypeVTable* pSimLongVTable;

void print_real_value(real _v);
int set_real(value* _v, real *p);
void print_real_type(void);
extern struct SimTypeVTable* pSimDoubleVTable;

void print_bool_value(bool _v);
int set_bool(value* _v, bool *p);
void print_bool_type(void);
extern struct SimTypeVTable* pSimBoolVTable;

void print_char_value(char _v);
int set_char(value* _v, char *p);
void print_char_type(void);
extern struct SimTypeVTable* pSimCharVTable;


#endif
