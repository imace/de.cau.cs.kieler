CC=cl
NODE_NAME=simulation__Simulation

TARGET= $(NODE_NAME).dll
# Localization of objects
NODE_OBJECTS = ./win32
# Localization of the sources
NODE_SOURCES = .
CFLAGS=  /nologo /D "WIN32" /D "_DEBUG" /D "_CONSOLE" /D "_MBCS"  /D "SIM" 
LDFLAGS= /machine:I386  /subsystem:console /nologo  /incremental:no 
LINKER=link

WORKDIR=U:/shared/modelgui/trunk/scade6_example
TARGET_DIR=U:/shared/modelgui/trunk/scade6_example/Simulation
BIN_DIR=C:/Programme/Esterel Technologies/Scade60b1/bin
LIB_DIR=C:/Programme/Esterel Technologies/Scade60b1/lib
INCLUDE_DIR=C:/Programme/Esterel Technologies/Scade60b1/include
INCLUDE_LIB_DIR=C:/Programme/Esterel Technologies/Scade60b1/lib/include
INCLUDE_CONFIG_DIR=C:/Programme/Esterel Technologies/Scade60b1/include/config
LIB_OS=
PROXY="$(LIB_DIR)/SmuProxy.c"
DEF_FILE="$(LIB_DIR)/SmuExport.def"
MAIN="$(LIB_DIR)/SmuMainWindows.c"
DEFAULT="$(LIB_DIR)/SmuDefaults.c"



# Objects files for external functions
EXTERNAL_FUNCTIONS = \

NODE_OBJ =  \
	$(NODE_OBJECTS)/kcg_consts.obj \
	$(NODE_OBJECTS)/Counter_0__pwlinear.obj \
	$(NODE_OBJECTS)/count_down__digital.obj \
	$(NODE_OBJECTS)/RisingEdgeRetrigger__digital.obj \
	$(NODE_OBJECTS)/elevator__elevator.obj \
	$(NODE_OBJECTS)/Simulation__simulation.obj \
	$(EXTERNAL_FUNCTIONS) \
	$(NODE_OBJECTS)/$(NODE_NAME)_interface.obj \
	$(NODE_OBJECTS)/$(NODE_NAME)_type.obj \
	$(NODE_OBJECTS)/SmuProxy.obj \
	$(NODE_OBJECTS)/SmuDefaults.obj

all :	$(TARGET)

clean:
	\del *.dll *.lib .\win32\*.obj

###########################################################
##
##  EXECUTABLE GENERATION FOR THE MAIN NODE
##
###########################################################


$(NODE_NAME).exe: $(NODE_OBJECTS)/SmuMainWindows.obj $(NODE_NAME)_dll.obj $(NODE_NAME).dll
	$(LINKER) $(NODE_OBJECTS)/SmuMainWindows.obj $(NODE_NAME)_dll.obj $(NODE_NAME).lib $(LDFLAGS) /out:$@ $(LIB_OS)

$(NODE_NAME).dll : $(NODE_OBJ) $(DEF_FILE)
	$(LINKER) @<<
$(NODE_OBJ)
$(LDFLAGS) /dll /def:$(DEF_FILE) /implib:"$(NODE_NAME).lib" /out:$@ $(LIB_OS)
<<


$(NODE_OBJECTS)/kcg_consts.obj : $(NODE_SOURCES)/kcg_consts.c
	$(CC) -I"."  -I"C:/Programme/Esterel Technologies/Scade60b1/libraries/libmathext" -I"$(LIB_DIR)" -I"$(WORKDIR)" -I"$(TARGET_DIR)" -I"$(INCLUDE_DIR)" -I"$(INCLUDE_CONFIG_DIR)" -I"$(INCLUDE_LIB_DIR)" $(CFLAGS) -c $(NODE_SOURCES)/kcg_consts.c /Fo$@

$(NODE_OBJECTS)/Counter_0__pwlinear.obj : $(NODE_SOURCES)/Counter_0__pwlinear.c
	$(CC) -I"."  -I"C:/Programme/Esterel Technologies/Scade60b1/libraries/libmathext" -I"$(LIB_DIR)" -I"$(WORKDIR)" -I"$(TARGET_DIR)" -I"$(INCLUDE_DIR)" -I"$(INCLUDE_CONFIG_DIR)" -I"$(INCLUDE_LIB_DIR)" $(CFLAGS) -c $(NODE_SOURCES)/Counter_0__pwlinear.c /Fo$@

$(NODE_OBJECTS)/count_down__digital.obj : $(NODE_SOURCES)/count_down__digital.c
	$(CC) -I"."  -I"C:/Programme/Esterel Technologies/Scade60b1/libraries/libmathext" -I"$(LIB_DIR)" -I"$(WORKDIR)" -I"$(TARGET_DIR)" -I"$(INCLUDE_DIR)" -I"$(INCLUDE_CONFIG_DIR)" -I"$(INCLUDE_LIB_DIR)" $(CFLAGS) -c $(NODE_SOURCES)/count_down__digital.c /Fo$@

$(NODE_OBJECTS)/RisingEdgeRetrigger__digital.obj : $(NODE_SOURCES)/RisingEdgeRetrigger__digital.c
	$(CC) -I"."  -I"C:/Programme/Esterel Technologies/Scade60b1/libraries/libmathext" -I"$(LIB_DIR)" -I"$(WORKDIR)" -I"$(TARGET_DIR)" -I"$(INCLUDE_DIR)" -I"$(INCLUDE_CONFIG_DIR)" -I"$(INCLUDE_LIB_DIR)" $(CFLAGS) -c $(NODE_SOURCES)/RisingEdgeRetrigger__digital.c /Fo$@

$(NODE_OBJECTS)/elevator__elevator.obj : $(NODE_SOURCES)/elevator__elevator.c
	$(CC) -I"."  -I"C:/Programme/Esterel Technologies/Scade60b1/libraries/libmathext" -I"$(LIB_DIR)" -I"$(WORKDIR)" -I"$(TARGET_DIR)" -I"$(INCLUDE_DIR)" -I"$(INCLUDE_CONFIG_DIR)" -I"$(INCLUDE_LIB_DIR)" $(CFLAGS) -c $(NODE_SOURCES)/elevator__elevator.c /Fo$@

$(NODE_OBJECTS)/Simulation__simulation.obj : $(NODE_SOURCES)/Simulation__simulation.c
	$(CC) -I"."  -I"C:/Programme/Esterel Technologies/Scade60b1/libraries/libmathext" -I"$(LIB_DIR)" -I"$(WORKDIR)" -I"$(TARGET_DIR)" -I"$(INCLUDE_DIR)" -I"$(INCLUDE_CONFIG_DIR)" -I"$(INCLUDE_LIB_DIR)" $(CFLAGS) -c $(NODE_SOURCES)/Simulation__simulation.c /Fo$@

$(NODE_OBJECTS)/$(NODE_NAME)_interface.obj : $(NODE_SOURCES)/$(NODE_NAME)_interface.c
	$(CC) -I"."  -I"C:/Programme/Esterel Technologies/Scade60b1/libraries/libmathext" -I"$(TARGET_DIR)" -I"$(LIB_DIR)" -I"$(WORKDIR)" -I"$(INCLUDE_DIR)" -I"$(INCLUDE_CONFIG_DIR)" -I"$(INCLUDE_LIB_DIR)" $(CFLAGS) -c $(NODE_SOURCES)/$(NODE_NAME)_interface.c /Fo$@

$(NODE_OBJECTS)/$(NODE_NAME)_type.obj : $(NODE_SOURCES)/$(NODE_NAME)_type.c
	$(CC) -I"."  -I"C:/Programme/Esterel Technologies/Scade60b1/libraries/libmathext" -I"$(TARGET_DIR)" -I"$(LIB_DIR)" -I"$(WORKDIR)" -I"$(INCLUDE_DIR)" -I"$(INCLUDE_CONFIG_DIR)" -I"$(INCLUDE_LIB_DIR)" $(CFLAGS) -c $(NODE_SOURCES)/$(NODE_NAME)_type.c /Fo$@

$(NODE_OBJECTS)/$(NODE_NAME)_dll.obj : $(NODE_NAME)_dll.c
	$(CC) $(CFLAGS) -c $(NODE_NAME)_dll.c /Fo$@

$(NODE_OBJECTS)/SmuDefaults.obj: $(DEFAULT)
	$(CC) $(CFLAGS)  -I"C:/Programme/Esterel Technologies/Scade60b1/libraries/libmathext" -I"$(TARGET_DIR)" -I"$(WORKDIR)" -I"$(INCLUDE_DIR)" -I"$(INCLUDE_CONFIG_DIR)" -I"$(INCLUDE_LIB_DIR)" -c $(DEFAULT) /Fo$@

$(NODE_OBJECTS)/SmuProxy.obj: $(PROXY)
	$(CC) $(CFLAGS)  -I"C:/Programme/Esterel Technologies/Scade60b1/libraries/libmathext" -I"$(TARGET_DIR)" -I"$(WORKDIR)" -I"$(INCLUDE_DIR)" -I"$(INCLUDE_CONFIG_DIR)" -I"$(INCLUDE_LIB_DIR)"  -c $(PROXY) /Fo$@

$(NODE_OBJECTS)/SmuMainWindows.obj: $(MAIN)
	$(CC) $(CFLAGS)  -I"C:/Programme/Esterel Technologies/Scade60b1/libraries/libmathext" -I"$(LIB_DIR)" -c $(MAIN) /Fo$@

