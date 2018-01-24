package hu.peterszabad.fibonacci.calculator.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Péter Szabad
 */
@Documented
@Constraint(validatedBy = FibonacciInputValidator.class)
@Target( { METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface FibonacciInput {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
