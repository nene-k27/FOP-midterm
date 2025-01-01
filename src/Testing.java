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

        String condition= """
                x = 5;
                if x > 3:
                    print(x);
                else:
                    print("3 is greater than x");
                """;
        interpreter.run(condition);

        String ref = """
                x = 3 + 5;
                y = x * 2;
                print(y); 
                """;
        interpreter.run(ref);

        String preassign = """
                print(z);
                """;
        interpreter.run(preassign);

        String multelif = """
                x = 2;
                if x > 3:
                    print("x is greater than 3")  
                elif x == 2:
                    print("x is equal to 2");
                """;
        interpreter.run(multelif);

        String test1 = """
                x = 2;
                if x < 3:
                    print("x is less than 3");
                else:
                    print("x is not less than 3");
                """;
        interpreter.run(test1);
    }

    public static void main(String[] args) {
        testRun();
    }
}
