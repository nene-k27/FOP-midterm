import java.util.Map;

public class Printer {
    private final Map<String, Integer> vars;

    public Printer(Map<String, Integer> vars) {
        this.vars = vars;
    }

    public void handlePrint(String line) {
        String varName = line.substring(line.indexOf('(') + 1, line.indexOf(')')).trim();
        System.out.println(vars.get(varName));
    }
}
