import java.util.Map;

public class Arithm {

    public int calc(String expr, Map<String, Integer> variables) {
        expr = expr.replace(" ", "");
        try {
            return Integer.parseInt(expr);
        } catch (NumberFormatException e) {

            if (expr.contains("+")) {
                String[] parts = expr.split("\\+");
                return calc(parts[0], variables) + calc(parts[1], variables);
            }
            else if (expr.contains("-")) {
                String[] parts = expr.split("-");
                return calc(parts[0], variables) - calc(parts[1], variables);
            }
            else if (expr.contains("*")) {
                String[] parts = expr.split("\\*");
                return calc(parts[0], variables) * calc(parts[1], variables);
            }
            else if (expr.contains("/")) {
                String[] parts = expr.split("/");
                return calc(parts[0], variables) / calc(parts[1], variables);
            }
            else if (expr.contains("%")) {
                String[] parts = expr.split("%");
                return calc(parts[0], variables) % calc(parts[1], variables);
            }
            else {
                if (variables.containsKey(expr)) {
                    return variables.get(expr);
                } else {
                    throw new IllegalArgumentException("Unknown variable: " + expr);
                }
            }
        }
    }
}