/* Generated for simulation purpose ONLY */
#ifndef _SIMULATION__RAILWAY_TYPE_H_
#define _SIMULATION__RAILWAY_TYPE_H_
#include "sim_types.h"
#include "kcg_types.h"
extern void print_char(char __c);
extern void print_bool(int __b);
extern void print_int(int __i);
extern void print_real(float __f);
extern void print_string(char *__str);
extern void print_token(char *__str);
void init_stdtypes_table(void);

/* Print/Set functions declaration for type ControlDataType__simulation */
void print_ControlDataType__simulation_value(void* p);
int set_ControlDataType__simulation(value* _v, void* p);
void print_ControlDataType__simulation_type(void);
extern struct SimTypeVTable* pSimControlDataType__simulationVTable;



/* Print/Set functions declaration for type DisplayDataType__simulation */
void print_DisplayDataType__simulation_value(void* p);
int set_DisplayDataType__simulation(value* _v, void* p);
void print_DisplayDataType__simulation_type(void);
extern struct SimTypeVTable* pSimDisplayDataType__simulationVTable;



/* Print/Set functions declaration for type TruthTableValues__truthtables */
void print_TruthTableValues__truthtables_value(void* p);
int set_TruthTableValues__truthtables(value* _v, void* p);
void print_TruthTableValues__truthtables_type(void);
extern struct SimTypeVTable* pSimTruthTableValues__truthtablesVTable;



/* Print/Set functions declaration for type struct_2 */
void print_struct_2_value(void* p);
int set_struct_2(value* _v, void* p);
void print_struct_2_type(void);
extern struct SimTypeVTable* pSimstruct_2VTable;



/* Print/Set functions declaration for type struct_1 */
void print_struct_1_value(void* p);
int set_struct_1(value* _v, void* p);
void print_struct_1_type(void);
extern struct SimTypeVTable* pSimstruct_1VTable;


void print_int_value(void* p);
int set_int(value* _v, void* p);
void print_int_type(void);
extern struct SimTypeVTable* pSimLongVTable;
void print_real_value(void* p);
int set_real(value* _v, void* p);
void print_real_type(void);
extern struct SimTypeVTable* pSimDoubleVTable;
void print_bool_value(void* p);
int set_bool(value* _v, void* p);
void print_bool_type(void);
extern struct SimTypeVTable* pSimBoolVTable;
void print_char_value(void* p);
int set_char(value* _v, void* p);
void print_char_type(void);
extern struct SimTypeVTable* pSimCharVTable;
/* State serialization */
/* Transition serialization */
/* Cond Block serialization */
void print_active_branch(void* _v);
#endif /* _SIMULATION__RAILWAY_TYPE_H_ */
