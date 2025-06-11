package calculator;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @Before
    public void setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void basicSeparator() {
        assertThat(0).isEqualTo(stringCalculator.add(""));
        assertThat(3).isEqualTo(stringCalculator.add("1,2"));
        assertThat(6).isEqualTo(stringCalculator.add("1,2,3"));
        assertThat(6).isEqualTo(stringCalculator.add("1,2:3"));
    }

    @Test
    public void customSeparator() {
        assertThat(6).isEqualTo(stringCalculator.add("//;\n1;2;3"));
    }

    @Test
    public void negativeNumber() {
        assertThatThrownBy(() -> stringCalculator.add("-1,-2"))
                .isInstanceOf(RuntimeException.class);
    }
}
