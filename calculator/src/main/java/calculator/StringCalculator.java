package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(getSplit(text)));
    }

    private boolean isBlank(String text) {
        return text.isEmpty();
    }

    private String[] getSplit(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            // 원본 문자열이 m.group(0)
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split("[,:]");
    }

    private int[] toInts(String[] texts) {
        int[] numbers = new int[texts.length];
        for (int i = 0; i < texts.length; i++) {
            numbers[i] = toPositive(texts[i]);
        }
        return numbers;
    }

    private int toPositive(String text) {
        int number = parseInt(text);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}