/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package net.ogdf.lib;

public class ELabelInterfaceDouble {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected ELabelInterfaceDouble(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ELabelInterfaceDouble obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      OgdfJNI.delete_ELabelInterfaceDouble(swigCPtr);
    }
    swigCPtr = 0;
  }

  public ELabelInterfaceDouble(GraphAttributes arg0) {
    this(OgdfJNI.new_ELabelInterfaceDouble(GraphAttributes.getCPtr(arg0), arg0), true);
  }

  public void setLabel(EdgeElement arg0, EdgeLabelDouble arg1) {
    OgdfJNI.ELabelInterfaceDouble_setLabel(swigCPtr, this, EdgeElement.getCPtr(arg0), EdgeLabelDouble.getCPtr(arg1), arg1);
  }

  public EdgeLabelDouble getLabel(EdgeElement arg0) {
    return new EdgeLabelDouble(OgdfJNI.ELabelInterfaceDouble_getLabel(swigCPtr, this, EdgeElement.getCPtr(arg0), arg0), false);
  }

}
