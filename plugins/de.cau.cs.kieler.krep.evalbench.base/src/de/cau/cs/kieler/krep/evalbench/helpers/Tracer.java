/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 ******************************************************************************/
package de.cau.cs.kieler.krep.evalbench.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.PushbackReader;
import java.util.HashMap;
import java.util.Map;
import kiel.util.kit.lexer.Lexer;
import kiel.util.kit.lexer.LexerException;
import kiel.util.kit.node.Start;
import kiel.util.kit.parser.Parser;
import kiel.util.kit.parser.ParserException;

public class Tracer {

	public static Map<Integer, Integer> trace(String kitfile, String kasmfile)
			throws IOException, ParserException, LexerException {

		HashMap<Integer, Integer> sem2line = new HashMap<Integer, Integer>();
		BufferedReader br = new BufferedReader(new FileReader(kasmfile));
		PrintWriter pw = null;

		String read = "";
		int lineNumber = 0;
		int instrNumber = 0;

		String nextState = "";
		String nextTrans = "";

		HashMap<String, Integer> states = new HashMap<String, Integer>();
		try {
			pw = new PrintWriter(new FileWriter(kasmfile + ".trc"), true);
			String[] startState = { "BEGINSTARTUP", "BEGINSIMPLESTATEC",
					"BEGINAWAITSTATE", "SUBSTATESEND" };
			String[] execState = { "AWAIT", "GOTO", "HALT", "JOIN" };
			String[] execTrans = { "GOTO BEGINSTARTUP" };
			String[] instr = { "AWAIT", "ABORT", "EMIT", "GOTO", "HALT",
					"JOIN", "LOAD", "PAUSE", "PAR", "PRIO", "PRESENT",
					"SIGNAL", "SUSPEND", "WABORT" };

			while ((read = br.readLine()) != null) {
				read = read.toUpperCase().trim();
				pw.println("line " + lineNumber + ": " + read);
				if (!read.equals("")) {
					for (int i = 0; i < startState.length; i++) {
						if (read.startsWith(startState[i])) {
							nextState = read.substring(startState[i].length(),
									read.length() - 1);
							nextTrans = nextState;
							break;
						}
					}
					// if(nextState.length()>0){
					for (int i = 0; i < execState.length; i++) {
						if (read.startsWith(execState[i])) {
							if (nextState.length() > 0) {
								states.put(nextState, instrNumber);
							}
							nextState = "";
							break;
						}
					}
					// }

					for (int i = 0; i < execTrans.length; i++) {
						if (read.startsWith(execTrans[i])) {
							states.put(nextTrans
									+ "->"
									+ read.substring(execTrans[i].length(),
											read.length()), instrNumber);
							// nextState = "";
							break;
						}
					}

					for (int i = 0; i < instr.length; i++) {
						if (read.startsWith(instr[i])) {
							instrNumber++;
							break;
						}
					}
				}

			}
		} finally {
			br.close();
			pw.flush();
			pw.close();
		}
		Lexer lexer = new Lexer(new PushbackReader(new FileReader(kitfile)));
		Parser parser = new Parser(lexer);
		Start ast = parser.parse();
		LineScanner ls = new LineScanner(states, sem2line);
		ast.apply(ls);
		return sem2line;
	}

}
