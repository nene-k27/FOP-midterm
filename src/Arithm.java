public class Arithm {

    public int calc(String expr, Map<String, Integer> variables) {
        expr = expr.replace(" ", "");

        try {
            return Integer.parseInt(expr);
        } catch (NumberFormatException e) {
            // First handle *, /, and %
            if (expr.contains("*") || expr.contains("/") || expr.contains("%")) {
                // We will first handle *, /, and %
                if (expr.contains("*")) {
                    String[] parts = expr.split("\\*");
                    int left = calc(parts[0], variables);
                    int right = calc(parts[1], variables);
                    return left * right;
                } else if (expr.contains("/")) {
                    String[] parts = expr.split("/");
                    int left = calc(parts[0], variables);
                    int right = calc(parts[1], variables);
                    if (right == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    return left / right;
                } else if (expr.contains("%")) {
                    String[] parts = expr.split("%");
                    int left = calc(parts[0], variables);
                    int right = calc(parts[1], variables);
                    return left % right;
                }
            }

            // Then handle +, -
            if (expr.contains("+")) {
                String[] parts = expr.split("\\+");
                return calc(parts[0], variables) + calc(parts[1], variables);
            } else if (expr.contains("-")) {
                String[] parts = expr.split("-");
                return calc(parts[0], variables) - calc(parts[1], variables);
            } else {
                // If it's a variable, look it up
                if (variables.containsKey(expr)) {
                    return variables.get(expr);
                } else {
                    throw new IllegalArgumentException("Unknown variable: " + expr);
                }
            }
        }
    }
}
