package study;

import calculator.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void CalculatorTest4() {
        String input = "2 C 0";
        inputHandling(input);
        Assertions.assertThatThrownBy(() -> stringCalculator.calculate()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산자가 아닌 문자는 입력 불가능합니다.");


        inputHandling("");
        Assertions.assertThat(stringCalculator.calculate()).isEqualTo(0);
    }
}
