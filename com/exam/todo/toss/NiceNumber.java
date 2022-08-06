package exam.todo.toss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NiceNumber {

    public static int solution(String s) {
        int answer = -1;
        boolean[] check = new boolean[10];
        char[] chars = s.toCharArray();
        StringBuilder builder;

        if (chars.length < 3) {
            return answer;
        }

        int cnt = 0;
        int beforeValue = Character.getNumericValue(chars[0]);
        for (int i = 1; i < chars.length; i++) {

            int numericValue = Character.getNumericValue(chars[i]);

            if (check[numericValue]) continue;

            if (numericValue == beforeValue) {
                cnt++;
            } else {
                cnt = 0;
                beforeValue = numericValue;
            }

            if (cnt >= 2) {
                check[numericValue] = true;
                answer = Math.max(answer, numericValue);
                cnt = 0;
            }
        }

        if (answer == 0 || answer == -1) {
            return answer;
        }
        int returnValue = (answer * 100) + (answer * 10) + answer ;
        return returnValue;
    }

    @Test
    void niceNumber() {
        Assertions.assertEquals(222, solution("12223"));
        Assertions.assertEquals(999, solution("111999333"));
        Assertions.assertEquals(-1, solution("123"));
        Assertions.assertEquals(-1, solution("0"));
        Assertions.assertEquals(111, solution("111111111111111111111111111111111111"));

        Assertions.assertEquals(0, solution("120003"));
        Assertions.assertEquals(-1, solution("1"));
        Assertions.assertEquals(-1, solution(""));

    }
}
