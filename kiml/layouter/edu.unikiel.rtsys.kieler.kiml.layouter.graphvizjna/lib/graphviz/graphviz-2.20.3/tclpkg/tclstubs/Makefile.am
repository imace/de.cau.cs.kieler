# $Id: Makefile.am,v 1.1.2.2 2008/10/07 23:44:03 ellson Exp $ $Revision: 1.1.2.2 $
## Process this file with automake to produce Makefile.in

AM_CPPFLAGS = @TCL_CFLAGS@ @TCL_INCLUDES@

LIBS = @TCL_STUB_LIB_SPEC@

if WITH_TCL
noinst_LTLIBRARIES = libtclstubs_C.la
endif
noinst_HEADERS = tclInt.h

# tclStubLib.c is a dummy file just to fool automake
libtclstubs_C_la_SOURCES = tclStubLib.c

EXTRA_DIST = Makefile.old
