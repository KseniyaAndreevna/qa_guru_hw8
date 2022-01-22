package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static guru.qa.Calculator.calculate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTests {

    @BeforeAll
    static void beforeAll() {
        System.out.println("This is @BeforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("This is @BeforeEach");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("This is @AfterAll");
    }

    @CsvSource(value = {
            "1, 2, '+', 3",
            "0.5, 0.5, '-', 0",
            "-0.8, -1, '*', 0.8"
    })
    @ParameterizedTest(name = "Testing of calculator with data {0}, {1}, {2}, {3}")
    void testCalculator(double a, double b, char operation, double expectedResult) {
        double result = calculate(a, b, operation);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Disabled
    @Test
    void testDisabled() {
        assertThat(true).isEqualTo(true);
    }

    @DisplayName("A special test case")
    @Test
    void testNamed() {
        assertThat(8).isEqualTo(8);
    }
}
