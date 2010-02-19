/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.36
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package net.ogdf.lib;

public class EdgeLabelDouble {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected EdgeLabelDouble(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(EdgeLabelDouble obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      OgdfJNI.delete_EdgeLabelDouble(swigCPtr);
    }
    swigCPtr = 0;
  }

  public EdgeLabelDouble() {
    this(OgdfJNI.new_EdgeLabelDouble(), true);
  }

  public void setX(eLabelTyp arg0, double arg1) {
    OgdfJNI.EdgeLabelDouble_setX(swigCPtr, this, arg0.swigValue(), arg1);
  }

  public void setY(eLabelTyp arg0, double arg1) {
    OgdfJNI.EdgeLabelDouble_setY(swigCPtr, this, arg0.swigValue(), arg1);
  }

  public void setHeight(eLabelTyp arg0, double arg1) {
    OgdfJNI.EdgeLabelDouble_setHeight(swigCPtr, this, arg0.swigValue(), arg1);
  }

  public void setWidth(eLabelTyp arg0, double arg1) {
    OgdfJNI.EdgeLabelDouble_setWidth(swigCPtr, this, arg0.swigValue(), arg1);
  }

  public void setEdge(EdgeElement arg0) {
    OgdfJNI.EdgeLabelDouble_setEdge(swigCPtr, this, EdgeElement.getCPtr(arg0), arg0);
  }

  public void addType(eLabelTyp arg0) {
    OgdfJNI.EdgeLabelDouble_addType(swigCPtr, this, arg0.swigValue());
  }

  public double getX(eLabelTyp arg0) {
    return OgdfJNI.EdgeLabelDouble_getX(swigCPtr, this, arg0.swigValue());
  }

  public double getY(eLabelTyp arg0) {
    return OgdfJNI.EdgeLabelDouble_getY(swigCPtr, this, arg0.swigValue());
  }

  public double getWidth(eLabelTyp arg0) {
    return OgdfJNI.EdgeLabelDouble_getWidth(swigCPtr, this, arg0.swigValue());
  }

  public double getHeight(eLabelTyp arg0) {
    return OgdfJNI.EdgeLabelDouble_getHeight(swigCPtr, this, arg0.swigValue());
  }

  public EdgeElement theEdge() {
    long cPtr = OgdfJNI.EdgeLabelDouble_theEdge(swigCPtr, this);
    return (cPtr == 0) ? null : new EdgeElement(cPtr, false);
  }

  public boolean usedLabel(eLabelTyp arg0) {
    return OgdfJNI.EdgeLabelDouble_usedLabel__SWIG_0(swigCPtr, this, arg0.swigValue());
  }

  public int usedLabel() {
    return OgdfJNI.EdgeLabelDouble_usedLabel__SWIG_1(swigCPtr, this);
  }

}
