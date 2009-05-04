package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;

import de.cau.cs.kieler.ssm2.Action;
import de.cau.cs.kieler.ssm2.SuspensionTrigger;

// A provider for the xText parser
public class XTextParserProvider extends AbstractProvider implements IParserProvider {
	
	// Return the xText parser
	public IParser getParser(IAdaptable hint) {
		if (hint instanceof ParserHintAdapter) {
			Object element = ((ParserHintAdapter) hint).getAdapter(EObject.class);
			if ((element != null) && (element instanceof Action)) {
				Action action = (Action) element;
				XTextParserWrapper wrapper = new XTextParserWrapper(action);
				return wrapper;
			}
			else if ((element != null) && (element instanceof SuspensionTrigger)) {
				SuspensionTrigger suspensionTrigger = (SuspensionTrigger) element;
				XTextParserWrapper wrapper = new XTextParserWrapper(suspensionTrigger);
				return wrapper;
			}
		}
		return null;
	}

	//
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			return getParser(hint) != null;
		}
		return false;
	}

}
