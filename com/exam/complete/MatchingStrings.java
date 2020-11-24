package exam.complete;

//https://www.hackerrank.com/challenges/sparse-arrays/problem

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatchingStrings {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(matchingStrings(new String[]{"aaa", "bb", "aaa", "c"}, new String[]{"aaa", "c", "ddf"})));
    }

    public static int[] matchingStrings(String[] strings, String[] queries) {
        int[] answer = new int[queries.length];
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(strings).forEach(o -> {
            if(map.containsKey(o)) map.replace(o, map.get(o) + 1);
            else map.put(o, 1);
        });

        for (int i = 0; i < queries.length; i++) if (map.containsKey(queries[i])) answer[i] = map.get(queries[i]);

        return answer;
    }
}
