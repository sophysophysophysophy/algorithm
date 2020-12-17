package exam.uploaded;
//https://www.hackerrank.com/challenges/contacts/problem


import java.util.*;

public class Contacts {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(contacts(new String[][]{{"add", "hack" },
                {"add", "h" },
                {"add", "sfdsf" },
                {"find", "hac" },
                {"find", "s" }})));
    }
    static int[] contacts(String[][] queries) {
        List<Integer> answerList = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            if(queries[i][0].equals("add")){
                if (map.containsKey(queries[i][1].charAt(0))) map.get(queries[i][1].charAt(0)).add(queries[i][1]);
                else {
                    List<String> list = new ArrayList<>();
                    list.add(queries[i][1]);
                    map.put(queries[i][1].charAt(0), list);
                }
            } else {
                List<String> valueList = map.get(queries[i][1].charAt(0));
                if(valueList == null) answerList.add(0);
                else {
                    int cnt = 0;
                    for (String str : valueList)
                        if (queries[i][1].length() <= str.length() && queries[i][1].equals(str.substring(0, queries[i][1].length()))) cnt++;
                    answerList.add(cnt);
                }
            }
        }

        int[] returnArray = new int[answerList.size()];
        for (int i = 0; i < answerList.size() ; i++) returnArray[i] = answerList.get(i);
        return returnArray;
    }
}
