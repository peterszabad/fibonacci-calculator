package hu.peterszabad.fibonacci.calculator.web;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author Péter Szabad
 */
@ControllerAdvice
@Component
public class FibonacciCalculatorExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    public Map handle(ConstraintViolationException exception) {
        return error(exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(toList()));
    }

    private Map error(Object message) {
        return Collections.singletonMap("error", message);
    }
}
