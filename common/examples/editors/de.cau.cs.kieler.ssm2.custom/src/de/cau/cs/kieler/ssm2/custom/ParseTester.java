package de.cau.cs.kieler.ssm2.custom;

import java.io.ByteArrayInputStream;

import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EPackage;
import org.openarchitectureware.xtext.parser.parsetree.Node;

import de.cau.cs.kieler.ssm2.Ssm2Package;
import de.cau.cs.kieler.ssm2.dsl.parser.GenParser;
import de.cau.cs.kieler.ssm2.dsl.parser.XtextParser;

public class ParseTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EPackage.Registry.INSTANCE.put("http://www.informatik.uni-kiel.de/rtsys/ssm2", Ssm2Package.eINSTANCE);
		String string = "A and B / C";
		ByteArrayInputStream stream = new ByteArrayInputStream(string.getBytes());
		GenParser parser = new XtextParser(stream);
		try {
			Node node = parser.getParser().parse();
			System.out.println("parsing complete");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
