package hu.peterszabad.fibonacci.calculator;

import java.math.BigInteger;

/**
 * Represents a pair of adjacent elements in the Fibonacci sequence
 *
 * @author Péter Szabad
 */
class FibonacciPair {

    private final BigInteger first;
    private final BigInteger second;

    FibonacciPair(BigInteger first, BigInteger second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Calculates the next pair of adjacent elements in the Fibonacci sequence
     *
     * @return the next Fibonacci pair
     */
    FibonacciPair next() {
        return new FibonacciPair(getSecond(), sum());
    }

    BigInteger getSecond() {
        return second;
    }

    private BigInteger sum() {
        return first.add(second);
    }
}
