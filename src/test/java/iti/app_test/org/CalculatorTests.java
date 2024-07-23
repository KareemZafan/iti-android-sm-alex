package iti.app_test.org;

import iti.app.org.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.lang.Float.NaN;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTests {
    // tests to test Calculator methods
    private static Calculator calc;


    private static Stream<Arguments> provideTestData() {
        return
                Stream.of(
                        Arguments.of(1, 2),
                        Arguments.of(-1, -2),
                        Arguments.of(-1, 0),
                        Arguments.of(1, 24),
                        Arguments.of(-1, 50),
                        Arguments.of(-1, 90)
                );
    }

    private static Stream<Arguments> provideTestDataForSubtraction() {
        return
                Stream.of(
                        Arguments.of(1, 2, -1),
                        Arguments.of(-1, -2, 1),
                        Arguments.of(-1, 0, -1),
                        Arguments.of(1, 24, -23),
                        Arguments.of(-1, 50, -51),
                        Arguments.of(-1, 90, -91)
                );
    }

    @BeforeAll
    static void beforeAll() {
        calc = new Calculator();
        System.out.println("Open Session with DB");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Closing DB Session");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Executed before each test");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Executed after each test");
    }

    @ParameterizedTest
    @DisplayName("Feature-123 Adding two numbers")
    // @Disabled("Not ready yet")
    @MethodSource("provideTestData")
    void testAddition(long a, long b) {
        System.out.println("in ADD test");
        assertEquals(Math.addExact(a, b), calc.add(a, b));
    }

    @ParameterizedTest
    @Tag("Feb")
    @MethodSource("provideTestDataForSubtraction")
    void testSubtraction(double a, double b, double res) {
        System.out.println("in Sub test");
        assertEquals(res, calc.sub(a, b));
    }

    @Test
    //@EnabledOnOs(OS.WINDOWS)
    void testMultiplication() {
        System.out.println("in Mul test");
        assertEquals(Math.multiplyExact(6, 8), calc.mul(6, 8));//pass
        assertEquals(48, calc.mul(-6, -8));//pass
        assertEquals(0, calc.mul(0, -8));
    }

    @Tag("Regression")
    @RepeatedTest(3)
    void testDivision() {
        System.out.println("in Div test");
        assertEquals(8, calc.div(64, 8));
        assertEquals(-6, calc.div(12, -2));
        assertEquals(0, calc.div(0, -8));
        System.out.println(calc);

        ArithmeticException ex = assertThrowsExactly(ArithmeticException.class, () -> calc.div(2, 0));
        assertEquals("Division by zero!!!", ex.getMessage());
    }

    @Test
    @Tag("Regression")
    void testSquareRoot() {
        System.out.println("in RootSquare test");
        assertEquals(8, calc.getSquareRoot(64));
        assertEquals(9, calc.getSquareRoot(81));
        assertEquals(25, calc.getSquareRoot(625));
        assertEquals(NaN, calc.getSquareRoot(-9));
    }

    @Test
    @Tag("Regression")
    @Timeout(value = 1, unit=TimeUnit.MINUTES)
    void testModulus() {
        System.out.println("in Modulus test");
        assertEquals(4, calc.getModulus(12, 8));
        assertEquals(4, calc.getModulus(20, 16));
        assertEquals(1, calc.getModulus(1, 32));
        System.out.println(calc);
        Exception ex = assertThrowsExactly(ArithmeticException.class, ()->calc.getModulus(40,0));
        assertTrue(ex.getMessage().contains("b cannot be zero"));
    }


}
