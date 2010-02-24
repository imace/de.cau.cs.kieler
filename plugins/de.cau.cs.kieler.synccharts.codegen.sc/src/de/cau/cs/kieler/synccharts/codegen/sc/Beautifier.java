package de.cau.cs.kieler.synccharts.codegen.sc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Beautifier {

    private static File inFile;
    private static File outFile;
    private static BufferedReader in;
    private static FileWriter fw;
    private static BufferedWriter bw;
    private static String seperator = "%_@__END_OF_LINE__@_%";

    public Beautifier(File input, File output) {
        inFile = input;
        outFile = output;
    }

    public void bueatify() {
        try {
            writeOutputFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeOutputFile() throws Exception {
        String[] lines = setNewLines().split("\n");
        fw = new FileWriter(outFile);
        bw = new BufferedWriter(fw);
        int tabNumber = 0;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (line.endsWith("}")) {
                tabNumber--;
            }
            newLineEnd(line, "TICKEND;");
            newLineBegin(line, "void");
            if (!line.startsWith("int valSigInt")) {
                newLineBegin(line, "int");
            }
            if (!line.endsWith(":")) {
                bw.write(tabs(tabNumber));
            } else {
                bw.newLine();
            }
            bw.write(line);
            bw.newLine();
            newLineEnd(line, "isInit){");
            newLineEnd(line, "misc.h\"");
            newLineEnd(line, "char*);");
            newLineEnd(line, "};");

            if (line.endsWith("{")) {
                tabNumber++;
            }
        }
        bw.close();
    }

    private static String setNewLines() throws Exception {
        String oneLine = getCleanString(inFile);
        oneLine = oneLine.replaceAll(";" + seperator, ";\n");
        oneLine = oneLine.replaceAll(":" + seperator, ":\n");
        oneLine = oneLine.replaceAll("\\{" + seperator, "{\n");
        oneLine = oneLine.replaceAll("\\}" + seperator, "}\n");
        oneLine = oneLine.replaceAll("\\*\\/" + seperator, "*/\n");
        oneLine = oneLine.replaceAll("h\"" + seperator, "h\"\n");
        oneLine = oneLine.replaceAll(">" + seperator, ">\n");
        oneLine = oneLine.replaceAll(";\\}", ";\n}");
        oneLine = oneLine.replaceAll("\\)\\{", ") {");
        oneLine = oneLine.replaceAll("\t", "");
        oneLine = oneLine.replaceAll("==", " ==");
        oneLine = oneLine.replaceAll("  ==", " ==");
        oneLine = oneLine.replaceAll("==", "== ");
        oneLine = oneLine.replaceAll("==  ", "== ");
        oneLine = oneLine.replaceAll(seperator, "");
        return oneLine;
    }

    private static String tabs(int tabNumber) {
        String out = "";
        for (int i = 0; i < tabNumber; i++) {
            out += "\t";
        }
        return out;
    }

    private static void newLineEnd(String line, String s) throws Exception {
        if (line.endsWith(s)) {
            bw.newLine();
        }
    }

    private static void newLineBegin(String line, String s) throws Exception {
        if (line.startsWith(s)) {
            bw.newLine();
        }
    }

    private static String removeLeadingWhitespaces(String line) {
        while (line.startsWith("\t") || line.startsWith(" ")) {
            line = line.substring(1);
        }
        return line;
    }

    private static String removeRetailWhitespaces(String line) {
        while (line.endsWith("\t") || line.endsWith(" ")) {
            line = line.substring(0, line.length() - 1);
        }
        return line;
    }

    private static String getCleanString(File fileName) throws Exception {
        String out = "";
        String line;

        in = new BufferedReader(new FileReader(fileName));

        while ((line = in.readLine()) != null) {
            System.out.println(line);
            line = removeLeadingWhitespaces(line);
            line = removeRetailWhitespaces(line);
            if (!line.isEmpty()) {
                out += line + seperator;
            }
        }
        return out;
    }
}
