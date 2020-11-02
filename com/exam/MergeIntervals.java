package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//TODO
public class MergeIntervals {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 19}})));
    }

    public static int[][] merge(int[][] intervals) {
        int[][] answer = {} ;
        List<Integer>[][] myList = new ArrayList[][] {};
        int idx = 0;


        for(int i = 0 ; i < intervals.length; i++) {
//            if(answer.length > 0  && answer[idx][1] >= intervals[i][0]) {
//
//            }
        }


        return answer;
    }
}
