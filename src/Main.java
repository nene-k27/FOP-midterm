import java.util.HashMap;
import java.util.Map;

public class Main {
    private final Map<String, Integer> variables = new HashMap<>();
    private final Arithm arithm = new Arithm();
    private final VarAssign varAssign = new VarAssign();
    private final Printer printer = new Printer(variables);

    public void run(String code) {
        String[] lines = code.split(";");
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (line.contains("=")) {
                varAssign.handleAssignment(line, variables, arithm);
            } else if (line.startsWith("print")) {
                printer.handlePrint(line);
            }
        }
    }

}