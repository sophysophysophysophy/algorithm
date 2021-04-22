package exam.todo;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{ 2, 1, 3, 4, 1})));
    }
    public static int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

//        Arrays.stream(numbers).forEach({e, i} -> {
//            Arrays.stream(numbers).forEach(ee -> {
//                list.add(e + ee);
//            });
//        });

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }
        return list.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();

    }
}
