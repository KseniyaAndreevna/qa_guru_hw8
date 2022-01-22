package guru.qa;

public class Calculator {

    public static double calculate(double a, double b, char operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
