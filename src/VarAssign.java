import java.util.Map;

public class VarAssign {
    public void handleAssignment(String line, Map<String, Integer> vars, VarAssign varAssign) {
        String[] parts = line.split("=");
        String varName = parts[0].trim();
        String expr = parts[1].trim();
        int value = varAssign.calc(expr, vars);
        vars.put(varName, value);
    }
}
