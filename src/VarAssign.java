import java.util.Map;

public class VarAssign {

    public void handleAssignment(String line, Map<String, Integer> variables, Arithm arithm) {
        String[] parts = line.split("=", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid assignment: " + line);
        }
        String varName = parts[0].trim();
        String expr = parts[1].trim();

        if (expr.endsWith(";")) {
            expr = expr.substring(0, expr.length() - 1);
        }

        int value = arithm.calc(expr, variables);

        variables.put(varName, value);
        System.out.println("Assigning variable '" + varName + "' with expression '" + expr + "'");
    }
}


