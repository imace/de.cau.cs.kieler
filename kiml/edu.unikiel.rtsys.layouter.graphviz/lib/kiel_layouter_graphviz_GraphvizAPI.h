/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class kiel_layouter_graphviz_GraphvizAPI */

#ifndef _Included_kiel_layouter_graphviz_GraphvizAPI
#define _Included_kiel_layouter_graphviz_GraphvizAPI
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    createGraph
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_createGraph
    (JNIEnv *, jclass, jstring);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    createNode
 * Signature: (ILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_createNode
    (JNIEnv *, jclass, jint, jstring);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    createEdge
 * Signature: (III)I
 */
JNIEXPORT jint JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_createEdge
    (JNIEnv *, jclass, jint, jint, jint);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    doDotLayout
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_doDotLayout
    (JNIEnv *, jclass, jint);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    doNeatoLayout
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_doNeatoLayout
    (JNIEnv *, jclass, jint);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    doTwopiLayout
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_doTwopiLayout
    (JNIEnv *, jclass, jint);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    doCircoLayout
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_doCircoLayout
    (JNIEnv *, jclass, jint);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    closeGraph
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_closeGraph
    (JNIEnv *, jclass, jint);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    dotCleanup
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_dotCleanup
    (JNIEnv *, jclass, jint);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    neatoCleanup
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_neatoCleanup
    (JNIEnv *, jclass, jint);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    twopiCleanup
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_twopiCleanup
    (JNIEnv *, jclass, jint);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    circoCleanup
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_circoCleanup
    (JNIEnv *, jclass, jint);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    setGraphAttribute
 * Signature: (ILjava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_setGraphAttribute
    (JNIEnv *, jclass, jint, jstring, jstring);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    setGlobalNodeAttribute
 * Signature: (ILjava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_setGlobalNodeAttribute
    (JNIEnv *, jclass, jint, jstring, jstring);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    setLocalNodeAttribute
 * Signature: (IILjava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_setLocalNodeAttribute
    (JNIEnv *, jclass, jint, jint, jstring, jstring);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    setGlobalEdgeAttribute
 * Signature: (ILjava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_setGlobalEdgeAttribute
    (JNIEnv *, jclass, jint, jstring, jstring);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    setLocalEdgeAttribute
 * Signature: (IILjava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_setLocalEdgeAttribute
    (JNIEnv *, jclass, jint, jint, jstring, jstring);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    getAttribute
 * Signature: (ILjava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_getAttribute
    (JNIEnv *, jclass, jint, jstring);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    attachAttributes
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_attachAttributes
    (JNIEnv *, jclass, jint);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    writeDOT
 * Signature: (ILjava/lang/String;)V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_writeDOT
    (JNIEnv *, jclass, jint, jstring);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    getVersionString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_getVersionString
    (JNIEnv *, jclass);

/*
 * Class:     kiel_layouter_graphviz_GraphvizAPI
 * Method:    initialize
 * Signature: ()V
 */
JNIEXPORT void JNICALL
  Java_kiel_layouter_graphviz_GraphvizAPI_initialize
    (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
