import java.util.Map;

public class Printer {
    private final Map<String, Integer> variables;

    public Printer(Map<String, Integer> variables) {
        this.variables = variables;
    }

    public void handlePrint(String line) {
        int start = line.indexOf("(") + 1;
        int end = line.lastIndexOf(")");
        if (start < 0 || end < 0 || start >= end) {
            System.out.println("Syntax error in print statement: " + line);
            return;
        }
        String content = line.substring(start, end).trim();

        if (content.startsWith("\"") && content.endsWith("\"")) {
            System.out.println(content.substring(1, content.length() - 1));
        } else if (variables.containsKey(content)) {
            System.out.println(variables.get(content));
        } else {
            System.out.println("Error: Variable \"" + content + "\" not found.");
        }
    }
}


