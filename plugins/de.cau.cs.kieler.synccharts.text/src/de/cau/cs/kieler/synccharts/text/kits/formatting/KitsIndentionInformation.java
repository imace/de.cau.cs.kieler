package de.cau.cs.kieler.synccharts.text.kits.formatting;

import org.eclipse.xtext.formatting.IIndentationInformation;

public class KitsIndentionInformation implements IIndentationInformation {

	@Override
	public String getIndentString() {
		return "  ";
	}

}
