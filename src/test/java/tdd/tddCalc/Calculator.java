package tdd.tddCalc;

public class Calculator {

    public double add(int a, int b) {
        return a + b;
    }

    public double subtract(int a, int b) {
        return a - b;
    }

    public double multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0)
            throw new IllegalArgumentException("b is 0");

        return a / b;
    }
}
