#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "testnode_types.h"
#include "SmuDefaults.h"


void print_intArray10_value(intArray10 _v){
  if (pSimintArray10VTable) {
        print_token (*(char**)(void*)pSimintArray10VTable->m_pfnToType(SptString, &_v));
  }
  else {
    print_char('(');
    print_int_value((int) _v._F0);
    print_string(", ");
    print_int_value((int) _v._F1);
    print_string(", ");
    print_int_value((int) _v._F2);
    print_string(", ");
    print_int_value((int) _v._F3);
    print_string(", ");
    print_int_value((int) _v._F4);
    print_string(", ");
    print_int_value((int) _v._F5);
    print_string(", ");
    print_int_value((int) _v._F6);
    print_string(", ");
    print_int_value((int) _v._F7);
    print_string(", ");
    print_int_value((int) _v._F8);
    print_string(", ");
    print_int_value((int) _v._F9);
    print_char(')');
  }
}

int set_intArray10(value* _v, intArray10 *p){
  int SAO_ok = 0;
  if ( _v->kind == tokenType) {
    if (pSimintArray10VTable && pSimintArray10VTable->m_pfnGetConvInfo(SptNone, SptString)) {
      SAO_ok = pSimintArray10VTable->m_pfnFromType(SptString, &_v->u.a_token, p);
    }
  }
  else {
    SAO_ok = (_v->u.a_tuple.count == 10);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[0], &p->_F0);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[1], &p->_F1);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[2], &p->_F2);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[3], &p->_F3);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[4], &p->_F4);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[5], &p->_F5);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[6], &p->_F6);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[7], &p->_F7);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[8], &p->_F8);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[9], &p->_F9);
  }
  return SAO_ok;
}

void print_intArray10_type(void){
    print_char('(');
    print_string("int");
    print_string(", ");
    print_string("int");
    print_string(", ");
    print_string("int");
    print_string(", ");
    print_string("int");
    print_string(", ");
    print_string("int");
    print_string(", ");
    print_string("int");
    print_string(", ");
    print_string("int");
    print_string(", ");
    print_string("int");
    print_string(", ");
    print_string("int");
    print_string(", ");
    print_string("int");
    print_char(')');
}


struct SimTypeVTable* pSimintArray10VTable;

void print_guiControlData_value(guiControlData _v){
  if (pSimguiControlDataVTable) {
        print_token (*(char**)(void*)pSimguiControlDataVTable->m_pfnToType(SptString, &_v));
  }
  else {
    print_char('(');
    print_int_value((int) _v.integer_val);
    print_string(", ");
    print_real_value((real) _v.float_val);
    print_string(", ");
    print_bool_value((bool) _v.boolean_val);
    print_string(", ");
    print_states_value( _v.enumeration_val);
    print_char(')');
  }
}

int set_guiControlData(value* _v, guiControlData *p){
  int SAO_ok = 0;
  if ( _v->kind == tokenType) {
    if (pSimguiControlDataVTable && pSimguiControlDataVTable->m_pfnGetConvInfo(SptNone, SptString)) {
      SAO_ok = pSimguiControlDataVTable->m_pfnFromType(SptString, &_v->u.a_token, p);
    }
  }
  else {
    SAO_ok = (_v->u.a_tuple.count == 4);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[0], &p->integer_val);
    if (SAO_ok) SAO_ok = set_real( _v->u.a_tuple.items[1], &p->float_val);
    if (SAO_ok) SAO_ok = set_bool( _v->u.a_tuple.items[2], &p->boolean_val);
    if (SAO_ok) SAO_ok = set_states( _v->u.a_tuple.items[3], &p->enumeration_val);
  }
  return SAO_ok;
}

void print_guiControlData_type(void){
    print_char('(');
    print_string("int");
    print_string(", ");
    print_string("real");
    print_string(", ");
    print_string("bool");
    print_string(", ");
    print_string("int");
    print_char(')');
}


struct SimTypeVTable* pSimguiControlDataVTable;

void print_states_value(int _v){
  if (pSimstatesVTable) {
        print_token (*(char**)(void*)pSimstatesVTable->m_pfnToType(SptString, &_v));
  }
  else {
    print_int_value((_int) _v);
  }
}

int set_states(value* _v, int *p){
  int SAO_ok = 0;
  if (pSimstatesVTable && pSimstatesVTable->m_pfnGetConvInfo(SptNone, SptString))
      SAO_ok = pSimstatesVTable->m_pfnFromType(SptString, &_v->u.a_token, p);
  else {
    int SAO_tmp;
    SAO_ok = set_int( _v, &SAO_tmp);
    if (SAO_ok)
      *p = SAO_tmp;
  }
  return SAO_ok;
}

void print_states_type(void){
    print_string("int");
}


struct SimTypeVTable* pSimstatesVTable;

void print_guiDisplayData_value(guiDisplayData _v){
  if (pSimguiDisplayDataVTable) {
        print_token (*(char**)(void*)pSimguiDisplayDataVTable->m_pfnToType(SptString, &_v));
  }
  else {
    print_char('(');
    print_int_value((int) _v.waterlevel);
    print_char(')');
  }
}

int set_guiDisplayData(value* _v, guiDisplayData *p){
  int SAO_ok = 0;
  if ( _v->kind == tokenType) {
    if (pSimguiDisplayDataVTable && pSimguiDisplayDataVTable->m_pfnGetConvInfo(SptNone, SptString)) {
      SAO_ok = pSimguiDisplayDataVTable->m_pfnFromType(SptString, &_v->u.a_token, p);
    }
  }
  else {
    SAO_ok = (_v->u.a_tuple.count == 1);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[0], &p->waterlevel);
  }
  return SAO_ok;
}

void print_guiDisplayData_type(void){
    print_char('(');
    print_string("int");
    print_char(')');
}


struct SimTypeVTable* pSimguiDisplayDataVTable;

void print_int_value(_int _v){
  if (pSimLongVTable) {
    long v = (long)_v;
    print_string (*(char**)(void*)pSimLongVTable->m_pfnToType(SptString, &v));
  }
  else {
    print_int((int) _v);
  }
}

int set_int(value* _v, _int *p){
  int SAO_ok = 0;
  if (pSimLongVTable && pSimLongVTable->m_pfnGetConvInfo(SptNone, SptString)) {
      long v;
      SAO_ok = pSimLongVTable->m_pfnFromType(SptString, &_v->u.a_token, &v);
      if (SAO_ok) *p = (_int) v;
  }
  return SAO_ok;
}

void print_int_type(void){
    print_string("int");
}


struct SimTypeVTable* pSimLongVTable;

void print_real_value(real _v){
  if (pSimDoubleVTable) {
    double v = (double)_v;
    print_string (*(char**)(void*)pSimDoubleVTable->m_pfnToType(SptString, &v));
  }
  else {
    print_real((real) _v);
  }
}

int set_real(value* _v, real *p){
  int SAO_ok = 0;
  if (pSimDoubleVTable && pSimDoubleVTable->m_pfnGetConvInfo(SptNone, SptString)) {
      double v;
      SAO_ok = pSimDoubleVTable->m_pfnFromType(SptString, &_v->u.a_token, &v);
      if (SAO_ok) *p = (real) v;
  }
  return SAO_ok;
}

void print_real_type(void){
    print_string("real");
}


struct SimTypeVTable* pSimDoubleVTable;

void print_bool_value(bool _v){
  if (pSimBoolVTable) {
    SimBool v = (SimBool)_v;
    print_string (*(char**)(void*)pSimBoolVTable->m_pfnToType(SptString, &v));
  }
  else {
    print_bool((bool) _v);
  }
}

int set_bool(value* _v, bool *p){
  int SAO_ok = 0;
  if (pSimBoolVTable && pSimBoolVTable->m_pfnGetConvInfo(SptNone, SptString)) {
      SimBool v;
      SAO_ok = pSimBoolVTable->m_pfnFromType(SptString, &_v->u.a_token, &v);
      if (SAO_ok) *p = (bool) v;
  }
  return SAO_ok;
}

void print_bool_type(void){
    print_string("bool");
}


struct SimTypeVTable* pSimBoolVTable;

void print_char_value(char _v){
  if (pSimCharVTable) {
    char v = (char)_v;
    print_string (*(char**)(void*)pSimCharVTable->m_pfnToType(SptString, &v));
  }
  else {
    print_char((char) _v);
  }
}

int set_char(value* _v, char *p){
  int SAO_ok = 0;
  if (pSimCharVTable && pSimCharVTable->m_pfnGetConvInfo(SptNone, SptString)) {
      char v;
      SAO_ok = pSimCharVTable->m_pfnFromType(SptString, &_v->u.a_token, &v);
      if (SAO_ok) *p = (char) v;
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
