import java.util.Map;

public class Conditional {


    private int getVariableValue(String var, Map<String, Integer> variables, Arithm arithm) {

        var = var.trim();


        if (variables.containsKey(var)) {
            return variables.get(var);
        }


        try {
            return Integer.parseInt(var);
        } catch (NumberFormatException e) {

            return arithm.calc(var, variables);
        }
    }

    public boolean evaluateCondition(String condition, Map<String, Integer> variables, Arithm arithm) {
        condition = condition.trim();

        String[] parts;

        if (condition.contains(">")) {
            parts = condition.split(">");
            if (parts.length == 2) {
                String left = parts[0].trim();
                String right = parts[1].trim();
                int leftValue = getVariableValue(left, variables, arithm);
                int rightValue = getVariableValue(right, variables, arithm);
                return leftValue > rightValue;
            }
        } else if (condition.contains("<")) {
            parts = condition.split("<");
            if (parts.length == 2) {
                String left = parts[0].trim();
                String right = parts[1].trim();
                int leftValue = getVariableValue(left, variables, arithm);
                int rightValue = getVariableValue(right, variables, arithm);
                return leftValue < rightValue;
            }
        } else if (condition.contains("==")) {
            parts = condition.split("==");
            if (parts.length == 2) {
                String left = parts[0].trim();
                String right = parts[1].trim();
                int leftValue = getVariableValue(left, variables, arithm);
                int rightValue = getVariableValue(right, variables, arithm);
                return leftValue == rightValue;
            }
        } else if (condition.contains(">=")) {
            parts = condition.split(">=");
            if (parts.length == 2) {
                String left = parts[0].trim();
                String right = parts[1].trim();
                int leftValue = getVariableValue(left, variables, arithm);
                int rightValue = getVariableValue(right, variables, arithm);
                return leftValue >= rightValue;
            }
        } else if (condition.contains("<=")) {
            parts = condition.split("<=");
            if (parts.length == 2) {
                String left = parts[0].trim();
                String right = parts[1].trim();
                int leftValue = getVariableValue(left, variables, arithm);
                int rightValue = getVariableValue(right, variables, arithm);
                return leftValue <= rightValue;
            }
        }
        return false;
    }



    public boolean handleConditional(String line, Map<String, Integer> variables, Arithm arithm, Main main) {
        if (line.endsWith(":")) {
            String condition = line.substring(2, line.indexOf(":")).trim();
            boolean conditionResult = evaluateCondition(condition, variables, arithm);
            return conditionResult;
        }
        return false;
    }
}
