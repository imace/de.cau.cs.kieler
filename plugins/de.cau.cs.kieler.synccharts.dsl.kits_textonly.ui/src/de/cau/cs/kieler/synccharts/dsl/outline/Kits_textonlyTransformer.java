/*
 * generated by Xtext
 */
package de.cau.cs.kieler.synccharts.dsl.outline;

import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.transformer.AbstractDeclarativeSemanticModelTransformer;

import de.cau.cs.kieler.synccharts.dsl.kits_textonly.State;

/**
 * customization of the default outline structure
 * 
 */
public class Kits_textonlyTransformer extends
		AbstractDeclarativeSemanticModelTransformer {
//	public ContentOutlineNode createNode(State semanticState,
//			ContentOutlineNode parentNode) {
//		ContentOutlineNode node = super.newOutlineNode(semanticState,
//				parentNode);
//		String myStateType = null;
//		String myStateName = null;
//		String myStateLabel = null;
//		String nodeLabel = "";
//
//		/**
//		 * init myState "myStateLabel" --> init myState:"myStateLabel"
//		 */
//		if (semanticState.getType() != null
//				&& semanticState.getType().getName() != "NORMAL") {
//			myStateType = semanticState.getType().getName();
//			nodeLabel = myStateType + " state";
//		}
//		if (semanticState.getId() != null) {
//			myStateName = semanticState.getId();
//			nodeLabel = nodeLabel + myStateName;
//		} else {
//			myStateName = "anonymous state";
//			nodeLabel = nodeLabel + myStateName;
//		}
//
//		if (semanticState.getLabel() != null) {
//			myStateLabel = semanticState.getLabel();
//			nodeLabel = nodeLabel + ": \" " + myStateLabel + "\"";
//		}
//		node.setLabel(nodeLabel);
//		return node;
//	}

}
