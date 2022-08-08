package exam.todo.line;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem3 implements Comparator, Comparable{


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
//        Collections.sort(bankbookList, Collections.reverseOrder());
        bankbookList.sort(Collections.reverseOrder());


        for (int i = 1; i < bankbookList.size(); i++) {
            if (bankbookList.get(0) + bankbookList.get(i) <= n) {
                int sum = bankbookList.get(0) + bankbookList.get(i);
                bankbookList.remove(i);
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

    public static int solutionByBfs(int n, int[] bankbook){
        int answer = bankbook.length;

        if (bankbook.length < 2) {
            return answer;
        }

        Queue<List<Integer>> queue = new LinkedList<>();
//        Queue<List<Integer>> queue1 = new ArrayList<>();      // 불가. type은 object 하위 클래스만 가능..
        Queue<List<Integer>> queue1 = new ArrayDeque<>();
        LinkedList<List<Integer>> queue2 = new LinkedList<>();


        initQueue(n, bankbook, answer, queue);


        while (queue.size() > 0) {
            List<Integer> nowList = queue.poll();

            for (int i = 0; i < nowList.size() -1 ; i++) {
                int nowNum = nowList.get(i);
                if (checkNumSizeEqual(n, nowNum)) continue;
                for (int j = 1; j < nowList.size(); j++) {
                    int nextNum = nowList.get(j);

                    if (!checkNumSizeOver(n, nowNum + nextNum)) {
                        ArrayList<Integer> list = getNewList(nowList, i,j);
                        queue.add(list);
                        answer = Math.min(answer, list.size());

                        if (answer <= 1) return answer;
                    }
                }
            }


        }




        return answer;
    }

    private static int initQueue(int n, int[] bankbook, int answer, Queue<List<Integer>> queue) {
        for (int i = 0; i < bankbook.length -1 ; i++) {
            int nowNum = bankbook[i];
            if (checkNumSizeEqual(n, nowNum)) continue;
            for (int j = 1; j < bankbook.length; j++) {
                int nextNum = bankbook[j];
                if (!checkNumSizeOver(n, nowNum + nextNum)) {
                    ArrayList<Integer> list = getNewList(bankbook, i,j);
                    queue.add(list);
                    answer = Math.min(answer, list.size());
                }
            }
        }
        return answer;
    }

    private static ArrayList<Integer> getNewList(List<Integer> beforeList, int i, int j) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(beforeList.get(i) + beforeList.get(j));
        for (int k = 0; k < beforeList.size(); k++) {
            if (k != i && k != j) list.add(beforeList.get(k));
        }
        return list;
    }

    private static ArrayList<Integer> getNewList(int[] bankbook, int i, int j) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(bankbook[i] + bankbook[j]);
        for (int k = 0; k < bankbook.length; k++) {
            if (k != i && k != j) list.add(bankbook[k]);
        }
        return list;
    }

    private static boolean checkNumSizeOver(int n, int plusNum) {
        return plusNum > n;
    }
    private static boolean checkNumSizeEqual(int n, int plusNum) {
        return plusNum >= n;
    }

    @Test
    void solutionTest() {
//        assertEquals(3, solution(10, new int[]{8, 4, 2, 5, 3, 7}));
//        assertEquals(2, solution(10, new int[]{1,2,3,3,3,8}));
//        assertEquals(1, solution(20, new int[]{1,2,3,3,3,8}));
//        assertEquals(2, solution(20, new int[]{8, 4, 2, 5, 3, 7}));
//        assertEquals(3, solution(11, new int[]{8, 4, 2, 5, 3, 7}));
//        assertEquals(3, solution(12, new int[]{8, 4, 10, 5, 2, 7}));
//        assertEquals(4, solution(12, new int[]{8, 4, 12, 5, 2, 7}));
//        assertEquals(1, solution(10, new int[] {10}));

        assertEquals(3, solutionByBfs(10, new int[]{8, 4, 2, 5, 3, 7}));
        assertEquals(2, solutionByBfs(10, new int[]{1,2,3,3,3,8}));
        assertEquals(1, solutionByBfs(20, new int[]{1,2,3,3,3,8}));
        assertEquals(2, solutionByBfs(20, new int[]{8, 4, 2, 5, 3, 7}));
        assertEquals(3, solutionByBfs(11, new int[]{8, 4, 2, 5, 3, 7}));
        assertEquals(3, solutionByBfs(12, new int[]{8, 4, 10, 5, 2, 7}));
        assertEquals(4, solutionByBfs(12, new int[]{8, 4, 12, 5, 2, 7}));
        assertEquals(1, solutionByBfs(10, new int[] {10}));

        assertEquals(6, solutionByBfs(1, new int[]{1, 1, 1, 1, 1, 1}));
        assertEquals(3, solutionByBfs(2, new int[]{1, 1, 1, 1, 1, 1}));
        assertEquals(3, solutionByBfs(20, new int[]{18, 20,  20, 1, 1}));
        assertEquals(8, solutionByBfs(20, new int[]{20, 20,  20,  20,  20,  20, 20, 20 }));

    }

//    comparator 구현시 구현해야하는 메소드
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return Math.max(o.hashCode(), this.hashCode());
    }
}
