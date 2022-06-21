package exam.complete;

import org.junit.jupiter.api.Test;

import static exam.complete.lotto.solution;
import static org.junit.jupiter.api.Assertions.*;

class lottoTest {

    @Test
    void lottoTest() {
        int[] answer = solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        assertEquals(answer[0], 3);
        assertEquals(answer[1], 5);
        answer = solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35});
        assertEquals(answer[0], 1);
        assertEquals(answer[1], 1);
    }

}