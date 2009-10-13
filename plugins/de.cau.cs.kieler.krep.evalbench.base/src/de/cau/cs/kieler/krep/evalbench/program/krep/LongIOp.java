///******************************************************************************
// * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
// *
// * http://www.informatik.uni-kiel.de/rtsys/kieler/
// * 
// * Copyright 2009 by
// * + Christian-Albrechts-University of Kiel
// *   + Department of Computer Science
// *     + Real-Time and Embedded Systems Group
// * 
// * This code is provided under the terms of the Eclipse Public License (EPL).
// * See the file epl-v10.html for the license text.
// ******************************************************************************/
//package de.cau.cs.kieler.krep.evalbench.program.krep;
//
//import java.util.Map;
//
///**
// * @author ctr immediate arithmetic operation
// */
//public class LongIOp extends Statement {
//	Operator kind;
//	String res;
//	String op1;
//	int op2;
//
//	Integer R_op1 = 0;
//	Integer R_res = 0;
//
//	/**
//	 * @param kind
//	 *            operator
//	 * @param res
//	 *            target register
//	 * @param op1
//	 *            first operand
//	 * @param op2
//	 *            second (immediate) operand
//	 */
//	public LongIOp(final Operator kind, final String res, final String op1,
//			final int op2) {
//		super();
//		this.kind = kind;
//		this.res = res;
//		this.op1 = op1;
//		this.op2 = op2;
//	}
//
//	@Override
//	public int[] getBytes() {
//		int[] b = { 0, R_res, R_op1, op2 };
//		switch (kind) {
//		case ADD:
//			b[0] = OPCODE.IADD;
//			break;
//		case AND:
//			b[0] = OPCODE.IAND;
//			break;
//		case DIV:
//			b[0] = OPCODE.IDIV;
//			break;
//		case MUL:
//			b[0] = OPCODE.IMUL;
//			break;
//		case NOT:
//			break;
//		case OR:
//			b[0] = OPCODE.IOR;
//			break;
//		case SUB:
//			b[0] = OPCODE.ISUB;
//			break;
//		default:
//			b[0] = OPCODE.IXOR;
//			break;
//		}
//		return b;
//	}
//
//	@Override
//	public String toString() {
//		String r = kind.toString();
//		String op = "";
//		switch (kind) {
//		case ADD:
//			op = "+";
//			break;
//		case SUB:
//			op = "-";
//			break;
//		case MUL:
//			op = "*";
//			break;
//		case DIV:
//			op = "/";
//			break;
//		case AND:
//			op = "and";
//			break;
//		case NOT:
//			break;
//		case OR:
//			op = "or";
//			break;
//		case XOR:
//			op = "xor";
//			break;
//		}
//		r += " " + R_res + " " + R_op1 + " " + op2;
//		r += "(" + res + "<-" + op1 + " " + op + " " + op2 + ")";
//		return r;
//	}
//
//	@Override
//	public void allocateRegs(Map<String, Integer> regs) {
//		R_res = regs.get(res);
//		if (R_res == null) {
//			R_res = regs.size() + 1;
//			regs.put(res, R_res);
//		}
//		R_op1 = regs.get(op1);
//		if (R_op1 == null) {
//			R_op1 = regs.size() + 1;
//			regs.put(op1, R_op1);
//		}
//	}
//
//}
