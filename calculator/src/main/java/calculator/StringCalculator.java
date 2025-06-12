package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    int sum = 0;

    public int add(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (text.isEmpty()) {
            return 0;
        } else if (m.find()) {
            String customDelimiter = m.group(1);
            return add(m.group(2).split(customDelimiter));
        } else {
            return add(text.split(",|:"));
        }
    }

    public int add(String[] texts) {
        for (String text : texts) {
            if (Integer.parseInt(text) >= 0) {
                sum += Integer.parseInt(text);
            } else {
                throw new RuntimeException();
            }
        }
        return sum;
    }
}