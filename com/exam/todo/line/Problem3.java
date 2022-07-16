package exam.todo.line;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3 {


//    여러개의 예금 통장
//    금액을 옮겨 없앤다
//    한번에 모든 금액 이동만 가능
//    예금액이 최대한 적어지도록


    static int answer;
    public static int solution(int n, int[] bankbook) {
        answer = bankbook.length;
//        DFS
        ArrayList<Integer> bankbookList = new ArrayList<>();
        for (int amount : bankbook) {
            bankbookList.add(amount);
        }
        Collections.sort(bankbookList, Collections.reverseOrder());


        for (int i = 1; i < bankbookList.size(); i++) {
            if (bankbookList.get(0) + bankbookList.get(i) <= n) {
                int sum = bankbookList.get(0) + bankbookList.get(i);
                bankbookList.remove(i );
                bankbookList.remove(0);
                bankbookList.add(sum);
                dfs(0, bankbookList, n);
            }
        }


        return answer;
    }

    static void dfs(int nowidx, List<Integer> list, int n ) {
        for (int i = nowidx + 1; i < list.size(); i++) {
            if (list.get(nowidx) + list.get(i) <= n) {
                int sum = list.get(nowidx) + list.get(i);
                list.remove(nowidx);
                list.remove(i -1);
                list.add(sum);
                Collections.sort(list, Collections.reverseOrder());
                dfs(nowidx, list, n);
                if (list.size() <= answer ) answer = list.size();
            }
            else {
                dfs(nowidx + 1, list, n);
            }
        }

        if (list.size() <= answer ) answer = list.size();

    }

    @Test
    void solutionTest() {
        int answerTest = solution(10, new int[]{8, 4, 2, 5, 3, 7});
        Assertions.assertEquals(answer, 3);

        answerTest = solution(10, new int[]{1,2,3,3,3,8});
        Assertions.assertEquals(2, answerTest);

        answerTest = solution(20, new int[]{1,2,3,3,3,8});
        Assertions.assertEquals(1, answerTest);


    }

}
