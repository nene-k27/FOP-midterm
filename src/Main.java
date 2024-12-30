import java.util.Map;
import java.util.HashMap;



public class Main {


    private final Map<String, Integer> variables = new HashMap<>();
    private final Arithm arithm = new Arithm();
    private final VarAssign varAssign = new VarAssign();
    private final Printer printer = new Printer(variables);
    private final Conditional conditional = new Conditional();

    public void run(String code) {
        String[] lines = code.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) continue;

            if (line.contains("=")) {
                varAssign.handleAssignment(line, variables, arithm);
            } else if (line.startsWith("print")) {
                printer.handlePrint(line);
            } else if (line.startsWith("if")) {
                StringBuilder block = new StringBuilder();
                String conditionLine = line;


                i++;
                while (i < lines.length && lines[i].startsWith("    ")) {
                    block.append(lines[i].trim()).append("\n");
                    i++;
                }

                boolean conditionResult = conditional.handleConditional(conditionLine, variables, arithm, this);
                if (conditionResult) {

                    this.run(block.toString());
                }


                if (i < lines.length && lines[i].trim().equals("else:")) {
                    i++;
                    while (i < lines.length && lines[i].startsWith("    ")) {
                        i++;
                    }
                    i--;
                }
            }
        }
    }




}