/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package net.ogdf.lib;

public class Ogdf implements OgdfConstants {
    
    public static void loadLibrary() {
        System.loadLibrary("ogdf");
    }
    
  public static void setG_memory(MemoryManager value) {
    OgdfJNI.g_memory_set(MemoryManager.getCPtr(value), value);
  }

  public static MemoryManager getG_memory() {
    long cPtr = OgdfJNI.g_memory_get();
    return (cPtr == 0) ? null : new MemoryManager(cPtr, false);
  }

  public static boolean DIsEqual(double a, double b, double eps) {
    return OgdfJNI.DIsEqual__SWIG_0(a, b, eps);
  }

  public static boolean DIsEqual(double a, double b) {
    return OgdfJNI.DIsEqual__SWIG_1(a, b);
  }

  public static boolean DIsGreaterEqual(double a, double b, double eps) {
    return OgdfJNI.DIsGreaterEqual__SWIG_0(a, b, eps);
  }

  public static boolean DIsGreaterEqual(double a, double b) {
    return OgdfJNI.DIsGreaterEqual__SWIG_1(a, b);
  }

  public static boolean DIsGreater(double a, double b, double eps) {
    return OgdfJNI.DIsGreater__SWIG_0(a, b, eps);
  }

  public static boolean DIsGreater(double a, double b) {
    return OgdfJNI.DIsGreater__SWIG_1(a, b);
  }

  public static boolean DIsLessEqual(double a, double b, double eps) {
    return OgdfJNI.DIsLessEqual__SWIG_0(a, b, eps);
  }

  public static boolean DIsLessEqual(double a, double b) {
    return OgdfJNI.DIsLessEqual__SWIG_1(a, b);
  }

  public static boolean DIsLess(double a, double b, double eps) {
    return OgdfJNI.DIsLess__SWIG_0(a, b, eps);
  }

  public static boolean DIsLess(double a, double b) {
    return OgdfJNI.DIsLess__SWIG_1(a, b);
  }

  public static double DRound(double d, int prec) {
    return OgdfJNI.DRound__SWIG_0(d, prec);
  }

  public static double DRound(double d) {
    return OgdfJNI.DRound__SWIG_1(d);
  }

  public static boolean test_forall_adj_edges(AdjElement adj, EdgeElement e) {
    return OgdfJNI.test_forall_adj_edges(AdjElement.getCPtr(adj), adj, EdgeElement.getCPtr(e), e);
  }

}
