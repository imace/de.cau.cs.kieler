package edu.unikiel.rtsys.kieler.kev.extension;

import java.util.Vector;

import edu.unikiel.rtsys.kieler.kev.helpers.Tools;

public class AnimationData {
	
	Vector<Object> data;
	
	public AnimationData(){
		data = new Vector<Object>();
	}
	
	/**
	 * Creates a clone of the passed data object.
	 * @param data
	 */
	public AnimationData(AnimationData origData){
		this.data = (Vector<Object>) origData.getData().clone();
	}
	
	public void addInt(int i){
		data.add(new Integer(i));
	}
	
	public void addDouble(double d){
		data.add(new Double(d));
	}
	
	public void addBool(boolean b){
		data.add(new Boolean(b));
	}
	
	public void addString(String s){
		data.add(s);
	}
	
	public Vector getData(){
		return data;
	}
	
	public void setData(int i, Object item){
		if(item instanceof Integer ||
				item instanceof Boolean ||
				item instanceof Double ||
				item instanceof String)
			data.set(i, item);
		else
			Tools.showDialog("Internal error: Data is of not supported format: "+item+". Supported Formats only: Integer, Boolean, Double, String", new NumberFormatException());
	}
	
	public String toString(){
		return data.toString();
	}
}
