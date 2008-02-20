/* Generated for simulation purpose ONLY */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "U:\shared\modelgui\trunk\scade6_example\Simulation\simulation__railway_type.h"
#include "SmuDefaults.h"

/*
/* State
 */

/*
/* Transition
 */

/*
/* Cond Block
 */
void print_active_branch(void* _v) {
kcg_bool v = *(kcg_bool*)(void*)_v;
if (v)
	print_string("then");
else
	print_string("else");
}
/*
/* User Types
 */

/* Print/Set function implementation for type ControlDataType__simulation */



struct SimTypeVTable* pSimControlDataType__simulationVTable;
void print_ControlDataType__simulation_value(void* p){
	if (pSimControlDataType__simulationVTable) {
		print_token (*(char**)(void*)pSimControlDataType__simulationVTable->m_pfnToType(SptString, p));
	}
	else {
		print_struct_1_value(p);
	}
}


int set_ControlDataType__simulation(value* _v, void* p){
	int SAO_ok = 0;
	if (pSimControlDataType__simulationVTable && pSimControlDataType__simulationVTable->m_pfnGetConvInfo(SptNone, SptString))
		SAO_ok = pSimControlDataType__simulationVTable->m_pfnFromType(SptString, &_v->u.a_token, p);
	else {
		struct_1 v = *(struct_1*)p;
		SAO_ok = set_struct_1( _v, &v);
		if (SAO_ok) *(struct_1*)p = v;
	}
	return SAO_ok;
}

void print_ControlDataType__simulation_type(void){
	print_string("ControlDataType__simulation");
}




/* Print/Set function implementation for type struct_1 */



struct SimTypeVTable* pSimstruct_1VTable;
void print_struct_1_value(void* p){
	if (pSimstruct_1VTable) {
		print_token (*(char**)(void*)pSimstruct_1VTable->m_pfnToType(SptString, p));
	}
	else {
		struct_1 v = *(struct_1*)p;
		print_char('(');
		print_bool_value(&v.buttonUp);
		print_char(',');
		print_bool_value(&v.buttonDown);
		print_char(',');
		print_bool_value(&v.buttonAlarm);
		print_char(')');
	}
}


int set_struct_1(value* _v, void* p){
	int SAO_ok = 0;
	if (pSimstruct_1VTable && pSimstruct_1VTable->m_pfnGetConvInfo(SptNone, SptString))
		SAO_ok = pSimstruct_1VTable->m_pfnFromType(SptString, &_v->u.a_token, p);
	else {
		struct_1 v = *(struct_1*)p;
		SAO_ok = (_v->u.a_tuple.count == 3);
		if (SAO_ok) SAO_ok = set_bool( _v->u.a_tuple.items[0], &v.buttonUp);
		if (SAO_ok) SAO_ok = set_bool( _v->u.a_tuple.items[1], &v.buttonDown);
		if (SAO_ok) SAO_ok = set_bool( _v->u.a_tuple.items[2], &v.buttonAlarm);
		if (SAO_ok) *(struct_1*)p = v;
	}
	return SAO_ok;
}

void print_struct_1_type(void){
	print_string("struct_1");
}




/* Print/Set function implementation for type DisplayDataType__simulation */



struct SimTypeVTable* pSimDisplayDataType__simulationVTable;
void print_DisplayDataType__simulation_value(void* p){
	if (pSimDisplayDataType__simulationVTable) {
		print_token (*(char**)(void*)pSimDisplayDataType__simulationVTable->m_pfnToType(SptString, p));
	}
	else {
		print_struct_2_value(p);
	}
}


int set_DisplayDataType__simulation(value* _v, void* p){
	int SAO_ok = 0;
	if (pSimDisplayDataType__simulationVTable && pSimDisplayDataType__simulationVTable->m_pfnGetConvInfo(SptNone, SptString))
		SAO_ok = pSimDisplayDataType__simulationVTable->m_pfnFromType(SptString, &_v->u.a_token, p);
	else {
		struct_2 v = *(struct_2*)p;
		SAO_ok = set_struct_2( _v, &v);
		if (SAO_ok) *(struct_2*)p = v;
	}
	return SAO_ok;
}

void print_DisplayDataType__simulation_type(void){
	print_string("DisplayDataType__simulation");
}




/* Print/Set function implementation for type struct_2 */



struct SimTypeVTable* pSimstruct_2VTable;
void print_struct_2_value(void* p){
	if (pSimstruct_2VTable) {
		print_token (*(char**)(void*)pSimstruct_2VTable->m_pfnToType(SptString, p));
	}
	else {
		struct_2 v = *(struct_2*)p;
		print_char('(');
		print_int_value(&v.direction);
		print_char(',');
		print_bool_value(&v.alarm);
		print_char(',');
		print_int_value(&v.position);
		print_char(',');
		print_bool_value(&v.doorClosed);
		print_char(')');
	}
}


int set_struct_2(value* _v, void* p){
	int SAO_ok = 0;
	if (pSimstruct_2VTable && pSimstruct_2VTable->m_pfnGetConvInfo(SptNone, SptString))
		SAO_ok = pSimstruct_2VTable->m_pfnFromType(SptString, &_v->u.a_token, p);
	else {
		struct_2 v = *(struct_2*)p;
		SAO_ok = (_v->u.a_tuple.count == 4);
		if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[0], &v.direction);
		if (SAO_ok) SAO_ok = set_bool( _v->u.a_tuple.items[1], &v.alarm);
		if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[2], &v.position);
		if (SAO_ok) SAO_ok = set_bool( _v->u.a_tuple.items[3], &v.doorClosed);
		if (SAO_ok) *(struct_2*)p = v;
	}
	return SAO_ok;
}

void print_struct_2_type(void){
	print_string("struct_2");
}




/* Print/Set function implementation for type TruthTableValues__truthtables */



struct SimTypeVTable* pSimTruthTableValues__truthtablesVTable;
static int TruthTableValues__truthtablesGetConvInfo(SimConvType nTo, SimConvType nFrom)
{
	int bTo = nTo == SptString || nTo == SptNone;
	int bFrom = nFrom == SptString || nFrom == SptNone;
	return bTo && bFrom;
}

static const void* TruthTableValues__truthtablesToType(SimConvType nTo, const void* pT)
{
	switch (nTo) {
		case SptString:
			{
			static char szValue[32];
			static char* pszValue = szValue;
			long v = (long) *(kcg_int*)pT;
			switch(v) {
				case T__truthtables:
					pszValue = "T__truthtables";
				break;
				case F__truthtables:
					pszValue = "F__truthtables";
				break;
				case X__truthtables:
					pszValue = "X__truthtables";
				break;
				default:
					return NULL;
				break;
			}
			return &pszValue;
				}
		break;
			default:
		return NULL;
	}
	return NULL;
}

static int TruthTableValues__truthtablesFromType(SimConvType nFrom, const void* pType, void* pT)
{
	switch (nFrom) {
		case SptString:
	{
		const char* p = *(const char**) pType;
		if (!strcmp(p, "T__truthtables")) {
			*(long*) pT = T__truthtables;
		} else if (!strcmp(p, "F__truthtables")) {
			*(long*) pT = F__truthtables;
		} else if (!strcmp(p, "X__truthtables")) {
			*(long*) pT = X__truthtables;
			} else {
				return 0;
			}
		}
		break;
			default:
		return 0;
	}
	/* value successfully compiled */
	return 1;
}

static struct SimTypeVTable simTruthTableValues__truthtablesVTable = {
    Scv43,
    TruthTableValues__truthtablesGetConvInfo,
    TruthTableValues__truthtablesToType,
    TruthTableValues__truthtablesFromType
};

struct SimTypeVTable* pSimTruthTableValues__truthtablesVTable = &simTruthTableValues__truthtablesVTable;

void print_TruthTableValues__truthtables_value(void* p){
	if (pSimTruthTableValues__truthtablesVTable) {
		print_token (*(char**)(void*)pSimTruthTableValues__truthtablesVTable->m_pfnToType(SptString, p));
	}
	else {
		print_int_value(p);
	}
}


int set_TruthTableValues__truthtables(value* _v, void* p){
	int SAO_ok = 0;
	if (pSimTruthTableValues__truthtablesVTable && pSimTruthTableValues__truthtablesVTable->m_pfnGetConvInfo(SptNone, SptString))
		SAO_ok = pSimTruthTableValues__truthtablesVTable->m_pfnFromType(SptString, &_v->u.a_token, p);
	else {
		int v;
		SAO_ok = set_int( _v, &v);
		if (SAO_ok)
			*(int*)p = v;
	}
	return SAO_ok;
}

void print_TruthTableValues__truthtables_type(void){
	print_string("TruthTableValues__truthtables");
}




/*
 * Predefined Types
 */
void print_int_value(void* p){
  if (pSimLongVTable) {
    long v = (long) *(kcg_int*)p;
    print_string (*(char**)(void*)pSimLongVTable->m_pfnToType(SptString, &v));
  }
  else {
    print_int(*(long*)(void*) p);
  }
}

int set_int(value* _v, void* p){
  int SAO_ok = 0;
  if (pSimLongVTable && pSimLongVTable->m_pfnGetConvInfo(SptNone, SptString)) {
      long v;
      SAO_ok = pSimLongVTable->m_pfnFromType(SptString, &_v->u.a_token, &v);
      if (SAO_ok) *(kcg_int*)p = v;
  }
  return SAO_ok;
}

void print_int_type(void){
    print_string("int");
}

struct SimTypeVTable* pSimLongVTable;

void print_real_value(void* p){
  if (pSimDoubleVTable) {
    double v = (double) *(kcg_real*)p;
    print_string (*(char**)(void*)pSimDoubleVTable->m_pfnToType(SptString, &v));
  }
  else {
    print_real((float)*(double*) p);
  }
}

int set_real(value* _v, void* p){
  int SAO_ok = 0;
  if (pSimDoubleVTable && pSimDoubleVTable->m_pfnGetConvInfo(SptNone, SptString)) {
      double v;
      SAO_ok = pSimDoubleVTable->m_pfnFromType(SptString, &_v->u.a_token, &v);
      if (SAO_ok) *(kcg_real*)p = v;
  }
  return SAO_ok;
}

void print_real_type(void){
    print_string("real");
}

struct SimTypeVTable* pSimDoubleVTable;

void print_bool_value(void* p){
  if (pSimBoolVTable) {
    SimBool v = (SimBool) *(kcg_bool*)p;
    print_string (*(char**)(void*)pSimBoolVTable->m_pfnToType(SptString, &v));
  }
  else {
    print_bool(*(SimBool*)(void*) p);
  }
}

int set_bool(value* _v, void* p){
  int SAO_ok = 0;
  if (pSimBoolVTable && pSimBoolVTable->m_pfnGetConvInfo(SptNone, SptString)) {
      SimBool v;
      SAO_ok = pSimBoolVTable->m_pfnFromType(SptString, &_v->u.a_token, &v);
      if (SAO_ok) *(kcg_bool*)p = v;
  }
  return SAO_ok;
}

void print_bool_type(void){
    print_string("bool");
}

struct SimTypeVTable* pSimBoolVTable;

void print_char_value(void* p){
  if (pSimCharVTable) {
    char v = (char) *(char*)p;
    print_string (*(char**)(void*)pSimCharVTable->m_pfnToType(SptString, &v));
  }
  else {
    print_char(*(char*)(void*) p);
  }
}

int set_char(value* _v, void* p){
  int SAO_ok = 0;
  if (pSimCharVTable && pSimCharVTable->m_pfnGetConvInfo(SptNone, SptString)) {
      char v;
      SAO_ok = pSimCharVTable->m_pfnFromType(SptString, &_v->u.a_token, &v);
      if (SAO_ok) *(char*)p = v;
  }
  return SAO_ok;
}

void print_char_type(void){
    print_string("char");
}

struct SimTypeVTable* pSimCharVTable;

/*
 * Init the BaseType translation function set
 */
void init_stdtypes_table(){
  if (!pSimLongVTable) pSimLongVTable = pSimLongDefaultVTable;
  else {
    if (!pSimLongVTable->m_pfnGetConvInfo) pSimLongVTable->m_pfnGetConvInfo = pSimLongDefaultVTable->m_pfnGetConvInfo;
    if (!pSimLongVTable->m_pfnFromType) pSimLongVTable->m_pfnFromType = pSimLongDefaultVTable->m_pfnFromType;
    if (!pSimLongVTable->m_pfnToType) pSimLongVTable->m_pfnToType = pSimLongDefaultVTable->m_pfnToType;
  }

  if (!pSimDoubleVTable) pSimDoubleVTable = pSimDoubleDefaultVTable;
  else {
    if (!pSimDoubleVTable->m_pfnGetConvInfo) pSimDoubleVTable->m_pfnGetConvInfo = pSimDoubleDefaultVTable->m_pfnGetConvInfo;
    if (!pSimDoubleVTable->m_pfnFromType) pSimDoubleVTable->m_pfnFromType = pSimDoubleDefaultVTable->m_pfnFromType;
    if (!pSimDoubleVTable->m_pfnToType) pSimDoubleVTable->m_pfnToType = pSimDoubleDefaultVTable->m_pfnToType;
  }

  if (!pSimBoolVTable) pSimBoolVTable = pSimBoolDefaultVTable;
  else {
    if (!pSimBoolVTable->m_pfnGetConvInfo) pSimBoolVTable->m_pfnGetConvInfo = pSimBoolDefaultVTable->m_pfnGetConvInfo;
    if (!pSimBoolVTable->m_pfnFromType) pSimBoolVTable->m_pfnFromType = pSimBoolDefaultVTable->m_pfnFromType;
    if (!pSimBoolVTable->m_pfnToType) pSimBoolVTable->m_pfnToType = pSimBoolDefaultVTable->m_pfnToType;
  }

  if (!pSimCharVTable) pSimCharVTable = pSimCharDefaultVTable;
  else {
    if (!pSimCharVTable->m_pfnGetConvInfo) pSimCharVTable->m_pfnGetConvInfo = pSimCharDefaultVTable->m_pfnGetConvInfo;
    if (!pSimCharVTable->m_pfnFromType) pSimCharVTable->m_pfnFromType = pSimCharDefaultVTable->m_pfnFromType;
    if (!pSimCharVTable->m_pfnToType) pSimCharVTable->m_pfnToType = pSimCharDefaultVTable->m_pfnToType;
  }
}
