package hu.peterszabad.fibonacci.calculator;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Calculator offering different calculation methods related to Fibonacci numbers
 *
 * @author Péter Szabad
 */
public final class FibonacciCalculator {

    /**
     * Calculates the Nth Fibonacci number
     *
     * @param number N
     * @return the Nth Fibonacci number
     */
    public static BigInteger calculate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format("Wrong input parameter: number=%d, must be non-negative", number));
        }
        if (number == 0) {
            return ZERO;
        }
        return Stream.iterate(new FibonacciPair(ZERO, ONE), FibonacciPair::next)
                .limit(number)
                .reduce((previous, last) -> last)
                .get()
                .getSecond();
    }

}
