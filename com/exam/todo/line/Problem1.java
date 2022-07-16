package exam.todo.line;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem1 {
    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char nowChar = s.charAt(i);

            if (nowChar == 'z') {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == 'z') {
                        break;
                    }
                    if (s.charAt(j) == 'a') {
                        answer++;
                        break;
                    }
                }
            }
            if (nowChar == 'a') {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == 'a') {
                        break;
                    }
                    if (s.charAt(j) == 'z') {
                        answer++;
                        break;
                    }
                }
            }

        }

        return answer;
    }
    @Test
    void solutionTest() {
        int answer = solution("abcz");
        Assertions.assertEquals(answer, 1);

        answer = solution("zabzczxa");
        Assertions.assertEquals(answer, 3);

        answer = solution("abcd");
        Assertions.assertEquals(answer, 0);
    }
}
