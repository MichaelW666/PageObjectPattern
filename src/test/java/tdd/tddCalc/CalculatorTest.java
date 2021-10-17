package tdd.tddCalc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void twoPlusTwo_ShouldEqualFour() {
        // arrange
        Calculator calculator = new Calculator();

        // act
        double result = calculator.add(2,2);

        // assert
        Assertions.assertEquals(4, result);
    }

    @Test
    public void twoMinusTwo_ShouldEqualZero() {
        // arrange
        Calculator calculator = new Calculator();

        // act
        double result = calculator.subtract(2,2);

        // assert
        Assertions.assertEquals(0, result);
    }

    @Test
    public void fiveTimesFive_ShouldEqualTwentyFive() {
        //
        Calculator calculator = new Calculator();

        // act
        double result = calculator.multiply(5,5);

        // assert
        Assertions.assertEquals(25, result);
    }

    @Test
    public void fivePerFive_ShouldEqualOne() {
        //
        Calculator calculator = new Calculator();

        // act
        double result = calculator.divide(5,5);

        // assert
        Assertions.assertEquals(1, result);
    }
}
