package exam.complete;

import java.util.Arrays;

/**
 * programmers
 * https://programmers.co.kr/learn/courses/30/lessons/77484?language=java#fnref1
 * 로또의 최고 순위와 최저 순위
 */
public class lotto {
    public static int[] solution(int[] lottos, int[] win_nums) {
//        1 -> 6
//        2 -> 5
//        3 -> 4
//        4 -> 3
//        5 -> 2
//        6 -> 0 ,1
        int[] grade = new int[]{6, 6, 5, 4, 3, 2, 1};


        int count = (int) Arrays.stream(lottos).filter(i -> i == 0).count();

        int sameNum = 0;
        sameNum += Arrays.stream(win_nums).filter(i -> Arrays.stream(lottos).filter(j -> i == j).count() > 0).count();

        int maxGrade = sameNum + count;
        int minGrade = sameNum;

        return new int[] {grade[maxGrade], grade[minGrade]};
    }
}
