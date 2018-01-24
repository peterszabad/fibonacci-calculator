package hu.peterszabad.fibonacci.calculator.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Péter Szabad
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FibonacciCalculatorApplication.class)
@WebAppConfiguration
public class FibonacciCalculatorControllerTest {

    private static final String NTH_NUMBER_URI_TEMPLATE = "/fibonacci-calculator/nth-number?n={number}";
    private static final String VALIDATION_ERROR_RESPONSE = "{\"error\":[\"Fibonacci calculator input must be between 0 and 50\"]}";

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void repondsWithCalculationResult_WhenInputIsLowerBound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(NTH_NUMBER_URI_TEMPLATE, 0))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void repondsWithCalculationResult_WhenInputIsUpperBound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(NTH_NUMBER_URI_TEMPLATE, 50))
                .andExpect(status().isOk())
                .andExpect(content().string("12586269025"));
    }

    @Test
    public void respondsWithValidationError_WhenInputIsTooBig() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(NTH_NUMBER_URI_TEMPLATE, 51))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(VALIDATION_ERROR_RESPONSE));
    }

    @Test
    public void respondsWithValidationError_WhenInputIsTooSmall() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(NTH_NUMBER_URI_TEMPLATE, -1))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(VALIDATION_ERROR_RESPONSE));
    }
}