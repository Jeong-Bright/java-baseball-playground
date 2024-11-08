package study;

import calculator.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    @Test
    void CalculatorTest1() {
        String input = "2 + 3 * 4 / 2";
        inputHandling(input);

        Assertions.assertThat(stringCalculator.calculate()).isEqualTo(10);
    }

    @Test
    void CalculatorTest2() {
        String input = "3 + 5 / 2 * 8";
        inputHandling(input);

        Assertions.assertThat(stringCalculator.calculate()).isEqualTo(32);
    }

    @Test
    void CalculatorTest3() {
        String input = "2 / 0";
        inputHandling(input);

        Assertions.assertThat(stringCalculator.calculate()).isEqualTo(2);
    }
}