package hu.peterszabad.fibonacci.calculator.core;

import org.junit.Test;

import java.math.BigInteger;

import static java.math.BigInteger.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Péter Szabad
 */
public class FibonacciCalculatorTest {

    @Test
    public void calculate_ShouldReturnZero_WhenZeroIsPassed() throws Exception {
        BigInteger result = FibonacciCalculator.calculate(0);
        assertThat(result, equalTo(ZERO));
    }

    @Test
    public void calculate_ShouldReturnOne_WhenOneIsPassed() throws Exception {
        BigInteger result = FibonacciCalculator.calculate(1);
        assertThat(result, equalTo(ONE));
    }

    @Test
    public void calculate_ShouldReturn55_When10IsPassed() throws Exception {
        BigInteger result = FibonacciCalculator.calculate(10);
        assertThat(result, equalTo(valueOf(55L)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculate_ShouldThrowException_WhenNegativeNumberIsPassed() throws Exception {
        FibonacciCalculator.calculate(-1);
    }
}