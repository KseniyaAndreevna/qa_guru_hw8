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

    public static boolean isEvenNumber(int number) {
        if ( number % 2 == 0 ) {
            return true;
        }
        return false;
    }
}
