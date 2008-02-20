/*** file modified for simulation purpose ***/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "Elevator_types.h"
#include "SmuDefaults.h"


void print_guiControlData_value(guiControlData _v){
  if (pSimguiControlDataVTable) {
        print_token (*(char**)(void*)pSimguiControlDataVTable->m_pfnToType(SptString, &_v));
  }
  else {
    print_char('(');
    print_bool_value((bool) _v.button_up);
    print_string(", ");
    print_bool_value((bool) _v.button_down);
    print_string(", ");
    print_bool_value((bool) _v.button_alarm);
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
    SAO_ok = (_v->u.a_tuple.count == 3);
    if (SAO_ok) SAO_ok = set_bool( _v->u.a_tuple.items[0], &p->button_up);
    if (SAO_ok) SAO_ok = set_bool( _v->u.a_tuple.items[1], &p->button_down);
    if (SAO_ok) SAO_ok = set_bool( _v->u.a_tuple.items[2], &p->button_alarm);
  }
  return SAO_ok;
}

void print_guiControlData_type(void){
    print_char('(');
    print_string("bool");
    print_string(", ");
    print_string("bool");
    print_string(", ");
    print_string("bool");
    print_char(')');
}


struct SimTypeVTable* pSimguiControlDataVTable;

void print_guiDisplayData_value(guiDisplayData _v){
  if (pSimguiDisplayDataVTable) {
        print_token (*(char**)(void*)pSimguiDisplayDataVTable->m_pfnToType(SptString, &_v));
  }
  else {
    print_char('(');
    print_int_value((int) _v.motor_dir);
    print_string(", ");
    print_bool_value((bool) _v.alarm);
    print_string(", ");
    print_int_value((int) _v.position);
    print_string(", ");
    print_bool_value((bool) _v.doorIsOpen);
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
    SAO_ok = (_v->u.a_tuple.count == 4);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[0], &p->motor_dir);
    if (SAO_ok) SAO_ok = set_bool( _v->u.a_tuple.items[1], &p->alarm);
    if (SAO_ok) SAO_ok = set_int( _v->u.a_tuple.items[2], &p->position);
    if (SAO_ok) SAO_ok = set_bool( _v->u.a_tuple.items[3], &p->doorIsOpen);
  }
  return SAO_ok;
}

void print_guiDisplayData_type(void){
    print_char('(');
    print_string("int");
    print_string(", ");
    print_string("bool");
    print_string(", ");
    print_string("int");
    print_string(", ");
    print_string("bool");
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
