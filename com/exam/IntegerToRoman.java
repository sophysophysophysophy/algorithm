package exam;
//https://leetcode.com/problems/integer-to-roman/

import java.util.TreeMap;
import java.util.TreeSet;

public class IntegerToRoman {
    public static void main(String[] args) {

    }

//  greedy
    public static String intToRoman(int num) {
        String answer = "";
        String numStr = num + "";

//        Create combination treemap
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "I");
        treeMap.put(5, "V");
        treeMap.put(10, "X");
        treeMap.put(50, "L");
        treeMap.put(100, "C");
        treeMap.put(500, "D");
        treeMap.put(1000, "M");



//        Get closest number in set ( digits )


        return answer;
    }
}
