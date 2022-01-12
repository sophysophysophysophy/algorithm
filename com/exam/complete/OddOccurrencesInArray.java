package exam.complete;

import java.util.HashMap;
import java.util.Map;

/**
 * https://app.codility.com/c/run/trainingWMT7BQ-U3V/
 */

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {9,3,22,9,3,9,7,9,7}));
    }

    public static int solution(int[] A) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        Map<Integer, Integer> map = oddOccurrencesInArray.getMapIncludeNumbers(A);

        return oddOccurrencesInArray.getOddNumber(map);
    }


    private int getOddNumber(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> oddNumberTestEntry : map.entrySet()) {
            if(oddNumberTestEntry.getValue() % 2 != 0 ) return oddNumberTestEntry.getKey();
        }
        return -1;
    }

    private Map<Integer, Integer> getMapIncludeNumbers(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            Integer isExistTargetNumber = map.get(i);
            if (isExistTargetNumber != null) map.put(i, isExistTargetNumber + 1);
            else map.put(i, 1);
        }
        return map;
    }

    public static int useStreamAndMergeSolution(int[] A) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        Map<Integer, Integer> map = oddOccurrencesInArray.getMapIncludeNumbersMerge(A);
        return oddOccurrencesInArray.getOddNumberInMapUseStream(map);
    }
    private Map<Integer, Integer> getMapIncludeNumbersMerge(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) map.merge(i, 1, Integer::sum);
        return map;
    }
    private Integer getOddNumberInMapUseStream(Map<Integer, Integer> map) {
        return map.entrySet().stream()
                .filter(oddNumberTestEntry -> oddNumberTestEntry.getValue() % 2 != 0)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }


}
