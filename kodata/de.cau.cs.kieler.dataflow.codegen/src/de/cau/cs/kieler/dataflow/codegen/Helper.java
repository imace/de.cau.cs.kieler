package de.cau.cs.kieler.dataflow.codegen;

import java.util.HashSet;

import dataflow.Port;

public class Helper {

	private static HashSet<String> defs = new HashSet<String>();
	
	public static boolean isDefined(Port p){
		boolean res = defs.contains(p.getName());
		if(!res){
			defs.add(p.getName());
		}
		return res;
	}
	
	public static boolean isDefined(String p){
		boolean res = defs.contains(p);
		if(!res){
			defs.add(p);
		}
		return res;
	}
	
	public static boolean huhu(){
		return false;
	}
	
	public static String timestamp() {
		return String.valueOf( System.currentTimeMillis() );
	}
}


