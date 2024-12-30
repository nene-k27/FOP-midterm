import java.util.Map;
public class Conditional {
    public boolean evaluateCondition(String condition, Map<String, Integer> variables, Arithm arithm) {
        condition = condition.trim();
        String[] parts = condition.split(">");
        if (parts.length == 2) {
            String left = parts[0].trim();
            String right = parts[1].trim();
            int leftValue = getVariableValue(left, variables, arithm);
            int rightValue = arithm.calc(right, variables);
            return leftValue > rightValue;
        }
        return false;
    }
    private int getVariableValue(String var, Map<String, Integer> variables, Arithm arithm) {
        if (variables.containsKey(var)) {
            return variables.get(var);
        }
        return arithm.calc(var, variables);
    }
    public boolean handleConditional(String line, Map<String, Integer> variables, Arithm arithm, Main main) {
        System.out.println("Handling conditional: " + line);

        if (line.endsWith(":")) {
            String condition = line.substring(2, line.indexOf(":")).trim();
            boolean conditionResult = evaluateCondition(condition, variables, arithm);
            System.out.println("Condition evaluated to: " + conditionResult);
            return conditionResult;
        } else {
            System.out.println("Syntax error: Expected ':' at the end of condition");
            return false;
        }
    }



}
