package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("문자열을 쉼표를 기준으로 분리한다.")
    void split() {
        // given
        String preSeparationString = "1,2";
        // when
        String[] separationString = preSeparationString.split(",");
        // then
        Assertions.assertThat(separationString).contains("1","2");

        // ---

        // given
        String preSeparationStringV2 = "1";
        // when
        String[] separationStringV2 = preSeparationStringV2.split(",");
        // then
        Assertions.assertThat(separationStringV2).containsExactly("1");
    }

    @Test
    @DisplayName("괄호 안에 포함된 숫자를 substring 메소드를 활용해 숫자만 반환하도록 한다.")
    void subString() {
        // given
        String beforeRemoveParentheses = "(1,2)";
        // when
        String removeParentheses = beforeRemoveParentheses.substring(1, 4);
        // then
        assertThat(removeParentheses).isEqualTo("1,2");
    }
}
