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
}
