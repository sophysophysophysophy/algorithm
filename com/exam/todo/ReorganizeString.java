package exam.todo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//https://leetcode.com/problems/reorganize-string/
public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString(
                "xogbmcjjie"));
    }

    public static String reorganizeString(String S) {

        char[] chars = S.toCharArray();
        boolean[] makeCharArray ;

        Set<String> list = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            makeCharArray = new boolean[chars.length];
            String nowStr = String.valueOf(chars[i]);
            makeCharArray[i] = true;
            String answer  = recursivelyMakeList(list, chars, makeCharArray, i, nowStr);
            if(!answer.equals("")) {
                return answer;
            }
        }


//        Optional : java8
        Optional<String> answer = list.stream().filter(ReorganizeString::checkValid).findFirst();
        return answer.orElse("");
    }

    private static boolean checkValid(String o) {
        char[] chars = o.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if(chars[i] == chars[i+1]) return false;
        }
        return true;
    }


    private static String recursivelyMakeList(Set<String> list, char[] chars, boolean[] makeCharArray, int i, String nowStr) {
        if(nowStr.length() == chars.length) {
            boolean flag = false;
            if(!list.contains(nowStr)) flag = checkValid(nowStr);
            if(flag) return nowStr;

        }
        else {
            for (int j = 0; j < chars.length; j++) {
                if(!makeCharArray[j]) {
                    makeCharArray[j] = true;
                    recursivelyMakeList(list, chars, makeCharArray, j, nowStr + chars[j]);
                    makeCharArray[j] = false;
                }
            }
        }

        return "";
    }
}
