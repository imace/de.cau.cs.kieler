# $Id: Makefile.am,v 1.1.2.2 2008/10/07 23:44:03 ellson Exp $ $Revision: 1.1.2.2 $
# Process this file with automake to produce Makefile.in

AM_CPPFLAGS = @TCL_CFLAGS@ @TK_CFLAGS@ @TCL_INCLUDES@  @TK_INCLUDES@ @TK_XINCLUDES@
                                                                                
LIBS = @TK_STUB_LIB_SPEC@

if WITH_TK
noinst_LTLIBRARIES = libtkstubs_C.la
endif
noinst_HEADERS = tkInt.h

# tkStubLib.c is a dummy file just to fool automake
libtkstubs_C_la_SOURCES = tkStubLib.c tkStubImg.c

EXTRA_DIST =
