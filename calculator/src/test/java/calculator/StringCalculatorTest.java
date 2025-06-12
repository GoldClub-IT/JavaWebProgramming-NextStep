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
    public void basicSeparator1() {
        assertThat(0).isEqualTo(stringCalculator.add(""));
    }

    @Test
    public void basicSeparator2() {
        assertThat(3).isEqualTo(stringCalculator.add("1,2"));
    }

    @Test
    public void basicSeparator3() {
        assertThat(6).isEqualTo(stringCalculator.add("1,2,3"));
    }

    @Test
    public void basicSeparator4() {
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
