package de.cau.cs.kieler.krep.evalbench.program.kep;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;

import de.cau.cs.kieler.krep.evalbench.program.kep.Constants.*;

public class Program {
	public static Constants constants;

	int programCounter = 0;

	int max_watchers_needed;

	boolean debug;

	boolean info;

	String countCrit;

	ArrayList<Instruction> instructions = new ArrayList<Instruction>();

	Stack<Integer> watcher_list = new Stack<Integer>();

	HashMap<String, KepSignal> signals = new HashMap<String, KepSignal>();

	// HashMap<String, Signal> localSignals = new HashMap<String, Signal>();
	HashMap<String, Register> registers = new HashMap<String, Register>();

	HashMap<String, Label> labels = new HashMap<String, Label>();

	HashMap<String, ThreadID> threads = new HashMap<String, ThreadID>();

	public Program(boolean debug, boolean info, String countCrit) {
		this.debug = debug;
		this.info = info;
		this.countCrit = countCrit;
	}

	public Watcher getNewWatcher(int endAddr) {

		if (watcher_list.empty()) {
			watcher_list.push(endAddr);
			max_watchers_needed++;
			assert watcher_list.size() - 1 == 0 : "watcher Stack emty, but size!=0";
			return new Watcher(watcher_list.size() - 1);

		} else {
			// if (watcher_list.peek()>=endAddr){
			watcher_list.push(endAddr);
			max_watchers_needed++;
			return new Watcher(watcher_list.size() - 1);
		}
		/*
		 * else { watcher_list.pop(); max_watchers_needed--; return
		 * getNewWatcher(endAddr); } }
		 */
	}

	/*
	 * if (watcher_list.size()>max_watcher) max_watcher=watcher_list.size(); if
	 * (!watcher_list.empty() && watcher_list.peek()<programCounter){
	 * watcher_list.pop(); watcher_list.push(programCounter); return
	 * watcher_list.size(); } else { watcher_list.push(programCounter); return
	 * watcher_list.size(); } }
	 */
	public int getProgramCounter() {
		return this.programCounter;
	}

	public int getInstsize() {
		return this.instructions.size();
	}

	public int getRegSize() {
		return this.registers.size();
	}

	public ArrayList<Instruction> getInstructions() {
		return instructions;
	}

	public void addSignal(String name, SignalType t) throws Exception {
		if (this.signals.containsKey(name.trim().toUpperCase())) {
			KepSignal result = this.signals.get(name.trim().toUpperCase());
			if (result.type != Constants.SignalType.SIGNAL
					&& result.type != Constants.SignalType.SIGNAL_VAL)
				throw new Exception("Duplicate Signal\""
						+ name.trim().toUpperCase() + "\"+found!");
		} else
			this.signals.put(name.trim().toUpperCase(), new KepSignal(name
					.trim().toUpperCase(), t, this.signals.size()));
		if (signals.size() > Constants.max_sig)
			throw new Exception("Max Signals reached: " + signals.size());

	}

	public void addReg(String var) throws Exception {
		if (this.registers.put(var.trim(), new Register(var.trim(),
				this.registers.size())) != null)
			throw new Exception("Duplicate Label\"" + var.trim() + "\"+found!");
		if (registers.size() > Constants.max_reg)
			throw new Exception("Max Registers reached: " + registers.size());
	}

	public void addThread(ThreadID thread) throws Exception {

		// if (
		this.threads.put("" + thread.id, thread);
		// !=null) throw new
		// Exception("Duplicate Thread\""+thread.id+"\"+found!");
		if (threads.size() > Constants.max_threadId)
			throw new Exception("Max Threads reached: " + threads.size());
	}

	public void addLabel(String label) throws Exception {

		if (this.labels.put(label.trim(), new Label(label.trim(), this
				.getProgramCounter(), this.instructions.size())) != null)
			throw new Exception("Duplicate Label\"" + label.trim()
					+ "\"+found!");
		if (labels.size() >= Constants.max_addr)
			throw new Exception("Max Labels reached: " + labels.size());
		if (debug)
			System.out.println("added Label " + getLabel(label).print()
					+ " with id " + getLabel(label).line + "!");
	}

	public void addInstruction(Instruction inst) {
		if (debug)
			System.out.println("addInst" + inst.getScource().errorMsg());
		this.instructions.add(inst);
		programCounter++;
	}

	public String printHeader() {
		return "" + printLabels() + "\n\r" + printVars() + "\n\r"
				+ printSignals();
	}

	private String printLabels() {
		String result = "----------------------------\n\r"
				+ "List of Labels: \n\r"
				+ "Ident \t CodePos \t BinCode \t [Line]\n\r";
		Set<Entry<String, Label>> jls = this.labels.entrySet();
		for (Entry<String, Label> entry : jls) {
			result += entry.getValue().print() + "\n\r";

		}
		return result;
	}

	private String printVars() {
		String result = "----------------------------\n\r"
				+ "List of Variables: \n\r" + "Name \t  BinCode\n\r";
		Set<Entry<String, Register>> regs = this.registers.entrySet();

		for (Entry<String, Register> entry : regs) {
			result += entry.getValue().print() + "\n\r";

		}
		return result;
	}

	private String printSignals() {
		String result = "----------------------------\n\r"
				+ "List of Signals: \n\r"
				+ "Name \t\t Type \t\t Num \t BinCode\n\r";
		Set<Entry<String, KepSignal>> sigs = this.signals.entrySet();
		for (Entry<String, KepSignal> entry : sigs) {
			result += entry.getValue().print() + "\n\r";

		}
		return result;
	}

	public KepSignal getSignalbyName(String name) throws NullPointerException {
		// System.out.println("getSig");
		if (this.signals.containsKey(name.trim()))
			return this.signals.get(name.trim());
		else {
			if (name.trim().toUpperCase().equals("TICK"))
				return new KepSignal("TICK", Constants.SignalType.INPUT, -1);
			else
				throw new NullPointerException("Signal \"" + name
						+ "\" not declared in Interface");
		}

	}

	public Register getRegisterByName(String name) throws NullPointerException {
		// System.out.println("getReg");
		if (this.registers.containsKey(name.trim()))
			return this.registers.get(name.trim());
		else
			throw new NullPointerException("Regsiter \"" + name
					+ "\" not declared in Interface");
	}

	public Label getLabel(String addr) throws NullPointerException {
		// System.out.println("getLabel");
		if (this.labels.containsKey(addr.trim()))
			return this.labels.get(addr.trim());
		else
			throw new NullPointerException("Label " + addr + " not found!");
	}

	public ThreadID getThread(String id) throws NullPointerException {
		// System.out.println("getThread");
		if (this.threads.containsKey(id.trim()))
			return this.threads.get(id.trim());
		else
			throw new NullPointerException("Thread " + id + " not found!");
	}

	public void postProcess() throws NullPointerException {
		System.out.print("Postprocessing ...");
		int i = 0;
		ArrayList<Instruction> result = new ArrayList<Instruction>();
		for (Instruction myinst : instructions) {
			if (myinst instanceof AddrInstruction) {
				if (((AddrInstruction) myinst).getAddr().id == null) {
					try {
						((AddrInstruction) myinst)
								.setAddr(this
										.getLabel(((AddrInstruction) myinst)
												.getAddr().name));
						if (myinst instanceof AddrSigWatchInstruction) {
							if (((AddrSigWatchInstruction) myinst).getWatch() == null) {
								((AddrSigWatchInstruction) myinst)
										.setWatch(getNewWatcher(((AddrInstruction) myinst)
												.getAddr().id));
								myinst
										.setSourceCode(myinst
												.getScource()
												.appendContent(
														","
																+ ((AddrSigWatchInstruction) myinst)
																		.getWatch().id));
							}
						}
						i++;
						result.add(myinst);
					} catch (NullPointerException e) {
						throw new NullPointerException(""
								+ myinst.getScource().errorMsg() + ": " + e);
					}
				} else
					result.add(myinst);
			} else
				result.add(myinst);
		}
		this.instructions = result;
		System.out.println("done! (" + i + " instr. modified)");
	}

	public void postProcessLegacy() throws NullPointerException {
		System.out.print("Postprocessing ...");
		int i = 0;
		ArrayList<Instruction> result = new ArrayList<Instruction>();
		for (Instruction myinst : instructions) {
			result.add(myinst);
		}
		this.instructions = result;
		System.out.println("done! (" + i + ")");
	}

	public String info() {
		String result = "";
		result += "\n\rNumber of instructions: " + instructions.size();
		result += "\n\rNumber of registers: " + registers.size();
		result += "\n\rNumber of signals (total): " + signals.size();
		Set<Entry<String, KepSignal>> sigs = this.signals.entrySet();
		int localSigVal = 0;
		int localSig = 0;
		for (Entry<String, KepSignal> entry : sigs) {
			if (entry.getValue().type == Constants.SignalType.SIGNAL)
				localSig++;
			if (entry.getValue().type == Constants.SignalType.SIGNAL_VAL)
				localSigVal++;
		}
		result += "\n\r    local Signals (Pure/Val): "
				+ (localSig + localSigVal) + " (" + localSig + "/"
				+ localSigVal + ")";
		result += "\n\rNumber of threads: " + threads.size();
		result += "\n\rNumber of labels " + labels.size();
		result += "\n\rCodesize : " + this.length() + " Byte\n\r";
		Set<Entry<String, Integer>> countSet = this.count(this.countCrit)
				.entrySet();
		for (Entry<String, Integer> entry : countSet) {
			String key = entry.getKey();
			while (key.length() < 10)
				key += " ";
			result += "# " + key + ": " + entry.getValue() + "\n\r";

		}
		return result;
	}

	public HashMap<String, Integer> count(String crit) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		return result;

	}

	public void toListingFile(String file) throws IOException {
		FileWriter fw=null;
		try {
			fw = new FileWriter(file + "lst");
			System.out.print("Writing " + file + "lst ...");
			fw.write(this.toLst());
			fw.close();
			System.out.println(" done.");
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		} finally {
			fw.close();
		}

	}

	public void toFile(String file) throws IOException {
		FileWriter fw;
		try {
			fw = new FileWriter(file + "txt");
			System.out.print("Writing " + file + "txt ...");
			fw.write(this.toString());
			fw.close();
			System.out.println(" done.");
		} catch (IOException e) {
			throw new IOException(e.getMessage());

		}

	}

	public void toEsi(String file) throws IOException {
		FileWriter fw;
		try {
			fw = new FileWriter(file + "esi");
			System.out.print("Writing " + file + "esi ...");
			fw.write(this.toEsi());
			fw.close();
			System.out.println(" done.");
		} catch (IOException e) {
			throw new IOException(e.getMessage());

		}
	}

	public int length() {
		int result = 0;
		for (Instruction line : instructions) {
			assert line.length() == line.encode().length() : line.getScource()
					.errorMsg()
					+ ": Encodinglength is "
					+ line.encode().length()
					+ " but should be " + line.length() + ": " + line;
			String inst = line.encode();
			result += inst.length();
		}
		return result / 8;
	}

	public String toString() {
		int addr = 0;
		System.out.print("Gen ");
		System.out.print(" Code ...");
		if (info)
			System.out.println(this.info());
		String result = this.printHeader() + "\n\r";
		result += "---opcode---\n\r";
		result += "Label\tSC-Line\t            SourceCode(KASM)               \t#\t7..ID..015.............0\r\n";

		for (Instruction myinst : instructions) {
			Set<Entry<String, Label>> jls = this.labels.entrySet();
			String label = "";
			for (Entry<String, Label> entry : jls)
				if (entry.getValue().line == addr)
					label = entry.getValue().printLabel();
				else
					while (label.length() < Constants.max_LabelPrint)
						label += " ";
			result += label + myinst.getScource() + "\t" + (addr) + "\t"
					+ myinst + "\n\r";
			addr++;

		}
		System.out.println("done!");
		return result;
	}

	public String toEsi() {
		int i = 0;
		String result = "!reset;\n\r;\n\r";
		for (Instruction myinst : this.instructions) {
			Set<Entry<String, Label>> jls = this.labels.entrySet();
			String label = "";
			for (Entry<String, Label> entry : jls)
				if (entry.getValue().id == i)
					label = entry.getKey() + ":";

			try {
				String tmpinst = myinst.toString();
				result += "instr_from_esi='b" + tmpinst + "; %" + (i) + "\t"
						+ label + "\t" + myinst.getScource() + "\n\r";
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
		return result + "done_loading;";
	}

	public String toLst() {
		int addr = 0;
		String result = "";
		result += "% ------------------------------------------------------------";
		String inputsV = "";
		String inputs = "";
		String outputsV = "";
		String outputs = "";

		// Set<Entry<String,Signal>> sigs = this.signals.entrySet();
		// Collection<Signal> sigs = this.signals.values();
		ArrayList<KepSignal> sigs = new ArrayList<KepSignal>(this.signals
				.values());
		// Collections.sort(sigs,new IDComparator());
		for (KepSignal mySig : sigs) {
			// Signal mySig = entry.getValue();
			if (mySig.getValidName().length() != 0) {
				switch (mySig.getType()) {
				case INPUT_VAL:
					inputsV += " " + mySig.getValidName();
					break;
				case INPUT:
					inputs += " " + mySig.getValidName();
					break;
				case OUTPUT_VAL:
					outputsV += " " + mySig.getValidName();
					break;
				case OUTPUT:
					outputs += " " + mySig.getValidName();
					break;
				default:
					break;

				}
			}
		}
		result += "\n% ------------------------------------------------------------";
		if (inputsV.length() != 0)
			result += "\nINPUTV" + inputsV;
		if (inputs.length() != 0)
			result += "\nINPUT" + inputs;
		if (outputsV.length() != 0)
			result += "\nOUTPUTV" + outputsV;
		if (outputs.length() != 0)
			result += "\nOUTPUT" + outputs;

		Set<Entry<String, Register>> regs = this.registers.entrySet();
		String vars = "";
		for (Entry<String, Register> entry : regs) {
			if (entry.getValue().getValidName().length() != 0)
				vars += " " + entry.getValue().getValidName();

		}
		if (vars.length() != 0)
			result += "\nVAR" + vars;
		result += "\n";
		result += "\n" + "% Signal codes";
		result += "\n";
		result += "\n";
		int input_count = 0;
		int input_val_count = 0;
		int output_count = 0;
		int output_val_count = 0;
		int local_count = 0;
		int local_val_count = 0;
		inputs = "% Input ports (include local signals)";
		outputs = "% Output ports (include local signals)";
		for (KepSignal mySig : sigs) {
			// Signal mySig = entry.getValue();
			if (mySig.getValidName().length() != 0) {
				switch (mySig.getType()) {
				case INPUT_VAL:
					inputs += "\n" + mySig.printlst() + " (VALUED)";
					input_count++;
					input_val_count++;
					break;
				case INPUT:
					inputs += "\n" + mySig.printlst();
					input_count++;
					break;
				case OUTPUT_VAL:
					outputs += "\n" + mySig.printlst() + " (VALUED)";
					output_count++;
					output_val_count++;
					break;
				case OUTPUT:
					outputs += "\n" + mySig.printlst();
					output_count++;
					break;
				case SIGNAL:
					inputs += "\n" + mySig.printlst() + " %signal";
					outputs += "\n" + mySig.printlst() + " %signal";
					local_count++;
					break;
				case SIGNAL_VAL:
					inputs += "\n" + mySig.printlst() + " (VALUED)"
							+ " %signal";
					outputs += "\n" + mySig.printlst() + " (VALUED)"
							+ " %signal";
					local_count++;
					local_val_count++;
					break;
				default:
					break;
				}
			}
		}
		result += "\n" + inputs;
		result += "\n";
		result += "\n" + outputs;
		result += "\n";
		vars = "% Variable";
		int var_count = 0;
		for (Entry<String, Register> entry : regs) {
			if (entry.getValue().getValidName().length() != 0) {
				vars += "\n" + entry.getValue().printlst();
				var_count++;
			}

		}
		result += "\n" + vars;
		result += "\n";
		result += "\n% Summary:";
		result += "\n% Input signals  :  " + input_count + " (Pure: "
				+ (input_count - input_val_count) + ", Valued: "
				+ input_val_count + ")";
		result += "\n% Output signals :  " + output_count + " (Pure: "
				+ (output_count - output_val_count) + ", Valued: "
				+ output_val_count + ")";
		result += "\n% Local signals  :  " + local_count + " (Pure: "
				+ (local_count - local_val_count) + ", Valued: "
				+ local_val_count + ")";
		result += "\n% Variables      :  " + var_count;

		result += "\n%";
		result += "\n% RAM Usage (in byte): "
				+ ((registers.size() * constants.data_width) / 8);
		result += "\n% Code size (in byte): "
				+ ((instructions.size() * Constants.instr_width) / 8);
		result += "\n% Code size (in word): "
				+ ((instructions.size() * Constants.instr_width) / 32);
		result += "\n%";
		result += "\n% Watchers needed:        " + max_watchers_needed;
		result += "\n% LWatchers needed:       0";
		result += "\n% Preemption by TWatcher: 0";
		result += "\n%";
		result += "\n% Threads needed:   " + threads.size();
		result += "\n%";
		result += "\n";
		result += "\n% Instruction code:";
		result += "\n%---------------------------------------------------------------------------------";
		result += "\n% Addr  {Hex   code} {   ID             Binary Code              } Label: Mnemonic";
		result += "\n%---------------------------------------------------------------------------------";
		result += "\n%---------------------------------------------------------------------------------";
		String result_listing = "";
		for (Instruction myinst : instructions) {
			String addrString = "" + addr;
			while (addrString.length() < 5)
				addrString = "0" + addrString;
			assert myinst.length() == myinst.encode().length() : myinst
					.getScource().errorMsg()
					+ ": Encodinglength is "
					+ myinst.encode().length()
					+ " but should be " + myinst.length() + ": " + myinst;
			String inst = myinst.encode();
			String hexInstr = "";
			for (int i = 0; i < inst.length() / 4; i++) {
				hexInstr += toHex(inst.substring(i * 4, (i * 4) + 4));
			}

			result_listing += "\n[" + addrString + "] {" + hexInstr + "}";
			inst = myinst.toString();
			while (inst.length() < Constants.instr_width + 3)
				inst += " ";
			result_listing += " {" + inst + "} ";
			Set<Entry<String, Label>> jls = this.labels.entrySet();
			String label = "";
			for (Entry<String, Label> entry : jls)
				if (entry.getValue().line == addr)
					label += entry.getValue().printLabel().trim() + ":";
			while (label.length() < Constants.max_LabelPrint)
				label = " " + label;
			result_listing += label + myinst.getScource().toString().trim()
					+ " %";
			addr++;

		}
		result += result_listing;
		result += "\n";
		return result;
	}

	private String toHex(String bin) {

		int intVal = 0;
		for (int i = 0; i < bin.length(); i++) {
			assert bin.charAt(i) == '1' | bin.charAt(i) == '0' : "binary String is not binary:"
					+ bin.charAt(i);
			if (bin.charAt(i) == '1')
				intVal += Math.pow(2, 3 - i);
		}

		return Integer.toHexString(intVal).toUpperCase();

	}
}
