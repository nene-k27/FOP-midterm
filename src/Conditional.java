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

        if (line.endsWith(":")) {
            String condition = line.substring(2, line.indexOf(":")).trim();
            boolean conditionResult = evaluateCondition(condition, variables, arithm);

            return conditionResult;
        } else {

            return false;
        }
    }



}