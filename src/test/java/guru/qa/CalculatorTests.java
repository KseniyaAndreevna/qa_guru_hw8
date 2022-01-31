package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static guru.qa.Calculator.calculate;
import static guru.qa.Calculator.isEvenNumber;
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

    @ValueSource(ints = {-2, 4, 100500})
    @ParameterizedTest(name = "Verify that number {0} are even")
    void testEvenNumbers(int number) {
        Assertions.assertTrue(isEvenNumber(number));
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

    static Stream<Arguments> calculatorTestDataProvider() {
        return Stream.of(
                Arguments.of(1, 2, '+', 3),
                Arguments.of(-0.8, -1, '*', 0.8)
        );
    }

    @MethodSource("calculatorTestDataProvider")
    @ParameterizedTest(name = "Testing of calculator with data {0}, {1}, {2}, {3}")
    void testCalculatorWithMethodDataProvider(double a, double b, char operation, double expectedResult) {
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
