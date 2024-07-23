package iti.app_test.org;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTests {

    private static Stream<Arguments> provideTestData() {
        return
                Stream.of(
                        Arguments.of("Ahmed", "Mahmoud", "Ahmed Mahmoud"),
                        Arguments.of("Amany", "Mahmoud", "Amany Mahmoud"),
                        Arguments.of("Amany", "Ali", "Amany Ali"),
                        Arguments.of("Test1", "Test2", "Test1 Test2")
                );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void testStringConcatenation1(String firstName, String lastName, String fullName) {
        assertEquals(fullName, firstName.concat(" " + lastName));
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testStringConcatenation2(String firstName, String lastName, String fullName) {
        assertEquals(fullName, firstName.concat(" " + lastName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"level", "madam", "racecar", "rotor", "radar", "refer"})
    void testPalindromeStrings3(String text) {
        StringBuilder builder = new StringBuilder(text);
        String reversedText = builder.reverse().toString();
        System.out.println(reversedText);
        assertEquals(text, reversedText);

    }
}
