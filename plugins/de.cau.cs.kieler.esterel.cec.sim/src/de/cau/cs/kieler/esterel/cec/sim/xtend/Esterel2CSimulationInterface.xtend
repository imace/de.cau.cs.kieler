package de.cau.cs.kieler.esterel.cec.sim.xtend

import de.cau.cs.kieler.synccharts.*
import de.cau.cs.kieler.kies.esterel.EsterelFactory
import de.cau.cs.kieler.kies.esterel.Module
import de.cau.cs.kieler.core.kexpressions.*
import java.util.*
import com.google.inject.Inject

// Transformation of Esterel code into a c simulation interface wrapper
// that is able to deal with JSON signals and can interface with
// the signal funtions generated by the CEC
//
// author: cmot
// (original transormation xtend (1.0) ctr)
class Esterel2CSimulationInterface {

    // Generale method to create the c simulation interface
	def createCSimulationInterface (Module module) {
	    // Generate the C header
		esterelHeader();
	    
	    // Generate output functions for each Esterel signal 
		for (interfaceSignalDecl : module.interface.intSignalDecls)  {
			 interfaceSignalDecl.outputFunctions(module.name);
		}
		
		// Generate input functions that are then called my the main function's
		// tick function of the module
		esterelSetInputsFunction(module);
		
		// Generate the generic C main function
		mainFunction(module);
	} 	

   // -------------------------------------------------------------------------   
   
   // Generate the C header
   def esterelHeader() {
   	'''
/* Generated CSimulationInterface Wrapper */
	
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include "cJSON.h"

cJSON* output = 0;
cJSON* value = 0;

cJSON* output = 0;
cJSON* value = 0;
	''' 
   }
   
   // -------------------------------------------------------------------------   
   
   // Generate input functions that are then called my the main function's
   // tick function of the module
   def esterelSetInputsFunction(Module module) {
'''
void setInputs(){
  char buffer[2048];
  int i=0;
  char c;
  // read next line
  for (i=0; (c=getchar())!='\n'; i++){
    buffer[i]=c;
  }
  buffer[i]=0;
  
	cJSON* object = 0;
	cJSON* child = 0;
	cJSON* present = 0;
	cJSON* value = 0;

	object = cJSON_Parse(buffer);'''
	
		for (interfaceSignalDecl : module.interface.intSignalDecls)  {
			 interfaceSignalDecl.callInputs(module.name);
		}
	
'''}'''   	
   }
   
   // -------------------------------------------------------------------------   
   
   // Generate the generic C main function
   def mainFunction(Module it) {
   	'''int main(){''' name '''_reset();
  output = cJSON_CreateObject();
  while(1){
    setInputs();
	''' name ''''();
	char* outString = cJSON_Print(output);
	strip_white_spaces(outString);
	printf("%s\n", outString);
	fflush(stdout);
	output = cJSON_CreateObject();
  }  	
}'''
   }
   
   // -------------------------------------------------------------------------   

   // Define output functions to return JSON for each Esterel signal 
   def outputFunctions(Output it, String moduleName) {
   	  for (signal : signals)  {
   	  	moduleName +  '''_O_''' + signal.name + '''('''
   	  	if (signal.type == "int") {
   	  		'''int i'''
   	  	}
   	  	'''){  	value = cJSON_CreateObject();
				cJSON_AddTrueToObject(value, "present");'''
   	  	if (signal.type == "int") {
   	  		'''cJSON_AddNumberToObject(value, "value", i);'''
   	  	} 
   	  	'''cJSON_AddItemToObject(output, "''' signal.name '''", value);}'''
   	  }// next signal
   }
   
   // -------------------------------------------------------------------------   

   def outputFunctions(InterfaceSignalDecl it, String moduleName) {
   }   
   
   // -------------------------------------------------------------------------   
   
   // Call Esterel input functions for each JSON signal that is present
   def callInputs(Input it, String moduleName) {
   	for (signal : signals)  {
   	   	'''child = cJSON_GetObjectItem(object, "''' signal.name '''");
	if (child != NULL){
		present = cJSON_GetObjectItem(child, "present");
		value = cJSON_GetObjectItem(child, "value");
		if (present != NULL && present->type==cJSON_True) {'''
			moduleName + '''_I_''' + signal.name + '''();
		}
	}'''
   	} // next signal
   }
   
   // -------------------------------------------------------------------------   

   def callInputs(InterfaceSignalDecl it, String moduleName) {
   }
   

}













