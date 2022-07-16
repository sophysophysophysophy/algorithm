package exam.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class littleFriends {
    public static String solution(int m, int n, String[] board) {
//        List<Character> answer = new ArrayList<>();
        List<Character> answer = new ArrayList<>();

        Collections.sort(answer);



        return null;
    }


    @Test
    void solutionTest() {
        String s = solution(3, 3, new String[]{"DBA", "C*A", "CDB"});
        Assertions.assertEquals(s, "ABCD");

    }
}
