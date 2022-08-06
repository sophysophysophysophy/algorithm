package exam.todo.line;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] splitInput = input.split(" ");
        ArrayList<Integer> inputList = new ArrayList<>();
        for (String s : splitInput) {
            inputList.add(Integer.parseInt(s));
        }

        ;
        int num = 0;
        System.out.println(num == -1 ? "ERROR" : num);

//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
//            String input = br.readLine();
//            String[] splitInput = input.split(" ");
//            ArrayList<Integer> inputList = new ArrayList<>();
//            for (String s : splitInput) {
//                inputList.add(Integer.parseInt(s));
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }
    }
    public static int solution(List<Integer> array) {
        List<Integer> answerList = new ArrayList<>();


        for (int i = 0; i < array.size(); i++) {
            int nowData = array.get(i);
            if (nowData >= -200 && nowData <= 200) {
                // 2분 전, 2분 후 값 체크
                int[] checkTemperArray = {-2, -1, 1, 2};
                for (int compareIndex : checkTemperArray) {
                    if (i + compareIndex >= 0 && i + compareIndex < array.size()) {
                        if (Math.abs(nowData - array.get(i + compareIndex)) < 3) {
                            answerList.add(nowData);
                            break;
                        }
                    }
                }
            }
        }


        return answerList.size() == 0 ? -1 : (answerList.parallelStream().mapToInt(Integer::intValue).sum()) / answerList.size();
    }

    @Test
    void solutionTest() {
        int answer = solution(List.of(10, 16, 13, 12, 15, 14, 12, 201));
        assertEquals(answer, 13);

        answer =solution(List.of(10, 12));
        assertEquals(answer, 11);

        answer = solution(List.of(10, 13, 9));
        assertEquals(answer, 9);

        answer = solution(List.of(1,2,3,100,100, 1, 2));
        assertEquals(answer, 29);

        answer = solution(List.of(10, 13));
        assertEquals(answer, -1);

    }
}
