package hu.peterszabad.fibonacci.calculator.web.validation;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Péter Szabad
 */
public class FibonacciInputValidator implements ConstraintValidator<FibonacciInput, Integer> {

    @Value("${fibonacci.calculator.input.max}")
    private int maxNumber;

    @Override
    public void initialize(FibonacciInput constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = 0 <= value && value <= maxNumber;
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Fibonacci calculator input must be between 0 and " + maxNumber).addConstraintViolation();
        }
        return isValid;
    }

}
