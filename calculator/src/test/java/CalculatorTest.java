import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
        System.out.println("Before");
    }

    @Test
    public void add() {
        assertThat(9).isEqualTo(calculator.add(6, 3));
        System.out.println("add");
    }

    @Test
    public void subtract() {
        assertThat(3).isEqualTo(calculator.subtract(6, 3));
        System.out.println("subtract");
    }

    @After
    public void teardown() {
        System.out.println("Teardown");
    }
}