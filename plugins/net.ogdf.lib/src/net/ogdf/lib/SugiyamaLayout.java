/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.36
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package net.ogdf.lib;

public class SugiyamaLayout extends LayoutModule {
  private long swigCPtr;

  protected SugiyamaLayout(long cPtr, boolean cMemoryOwn) {
    super(OgdfJNI.SWIGSugiyamaLayoutUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SugiyamaLayout obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      OgdfJNI.delete_SugiyamaLayout(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public void setLayout(HierarchyLayoutModule hlm) {
    hlm.setMemOwn(false);
    setLayout_(hlm);
  }

  public SugiyamaLayout() {
    this(OgdfJNI.new_SugiyamaLayout(), true);
  }

  public void call(GraphAttributes arg0) {
    OgdfJNI.SugiyamaLayout_call(swigCPtr, this, GraphAttributes.getCPtr(arg0), arg0);
  }

  public int fails() {
    return OgdfJNI.SugiyamaLayout_fails__SWIG_0(swigCPtr, this);
  }

  public void fails(int arg0) {
    OgdfJNI.SugiyamaLayout_fails__SWIG_1(swigCPtr, this, arg0);
  }

  public int runs() {
    return OgdfJNI.SugiyamaLayout_runs__SWIG_0(swigCPtr, this);
  }

  public void runs(int arg0) {
    OgdfJNI.SugiyamaLayout_runs__SWIG_1(swigCPtr, this, arg0);
  }

  public boolean transpose() {
    return OgdfJNI.SugiyamaLayout_transpose__SWIG_0(swigCPtr, this);
  }

  public void transpose(boolean arg0) {
    OgdfJNI.SugiyamaLayout_transpose__SWIG_1(swigCPtr, this, arg0);
  }

  public boolean arrangeCCs() {
    return OgdfJNI.SugiyamaLayout_arrangeCCs__SWIG_0(swigCPtr, this);
  }

  public void arrangeCCs(boolean arg0) {
    OgdfJNI.SugiyamaLayout_arrangeCCs__SWIG_1(swigCPtr, this, arg0);
  }

  public double minDistCC() {
    return OgdfJNI.SugiyamaLayout_minDistCC__SWIG_0(swigCPtr, this);
  }

  public void minDistCC(double arg0) {
    OgdfJNI.SugiyamaLayout_minDistCC__SWIG_1(swigCPtr, this, arg0);
  }

  public double pageRatio() {
    return OgdfJNI.SugiyamaLayout_pageRatio__SWIG_0(swigCPtr, this);
  }

  public void pageRatio(double arg0) {
    OgdfJNI.SugiyamaLayout_pageRatio__SWIG_1(swigCPtr, this, arg0);
  }

  public boolean alignBaseClasses() {
    return OgdfJNI.SugiyamaLayout_alignBaseClasses__SWIG_0(swigCPtr, this);
  }

  public void alignBaseClasses(boolean arg0) {
    OgdfJNI.SugiyamaLayout_alignBaseClasses__SWIG_1(swigCPtr, this, arg0);
  }

  public boolean alignSiblings() {
    return OgdfJNI.SugiyamaLayout_alignSiblings__SWIG_0(swigCPtr, this);
  }

  public void alignSiblings(boolean arg0) {
    OgdfJNI.SugiyamaLayout_alignSiblings__SWIG_1(swigCPtr, this, arg0);
  }

  public void setLayout_(HierarchyLayoutModule hlm) {
    OgdfJNI.SugiyamaLayout_setLayout_(swigCPtr, this, HierarchyLayoutModule.getCPtr(hlm), hlm);
  }

}
