package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @Before
    public void setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_blank() {
        assertThat(0).isEqualTo(stringCalculator.add(""));
    }

    @Test
    public void add_oneNumber() {
        assertThat(1).isEqualTo(stringCalculator.add("1"));
    }

    @Test
    public void add_comma() {
        assertThat(6).isEqualTo(stringCalculator.add("1,2,3"));
    }

    @Test
    public void add_commaAndColon() {
        assertThat(6).isEqualTo(stringCalculator.add("1,2:3"));
    }

    @Test
    public void add_customDelimiter() {
        assertThat(6).isEqualTo(stringCalculator.add("//;\n1;2;3"));
    }

    @Test
    public void add_negative() {
        assertThatThrownBy(() -> stringCalculator.add("-1,-2"))
                .isInstanceOf(RuntimeException.class);
    }
}
