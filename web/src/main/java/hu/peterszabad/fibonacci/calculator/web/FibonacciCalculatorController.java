package hu.peterszabad.fibonacci.calculator.web;

import hu.peterszabad.fibonacci.calculator.core.FibonacciCalculator;
import hu.peterszabad.fibonacci.calculator.web.validation.FibonacciInput;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * @author Péter Szabad
 */
@RestController
@Validated
public class FibonacciCalculatorController {

    @GetMapping("/fibonacci-calculator/nth-number")
    public BigInteger calculateFibonacciNumber(@FibonacciInput @RequestParam int n) {
        return FibonacciCalculator.calculate(n);
    }

}
