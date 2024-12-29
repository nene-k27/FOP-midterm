
public class Testing {
    public static void testRun() {
        Main interpreter = new Main();

        String addittion = """
                x = 3 + 5;
                print(x);
               """;
        interpreter.run(addittion);

        String subtract = """
                y = 3 - 5;
                print(y);
                """;
        interpreter.run(subtract);

        String divide = """
                a = 10 / 2;
                print(a);
                """;
        interpreter.run(divide);

        String multiply = """
                b = 7 * 5;
                print(b);
                """;
        interpreter.run(multiply);


        String modulo = """
                c = 8 % 5;
                print(c);
                """;
        interpreter.run(modulo);

    }

    public static void main(String[] args) {
        testRun();
    }
}