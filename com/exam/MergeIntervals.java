package exam;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 19}})));
//        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}, {8, 10}, {15, 19}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {0, 1}, {8, 10}, {15, 19}})));
    }

    public static int[][] merge(int[][] intervals) {

        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0 ; i < intervals.length; i++) {
            if(list.size() > 0  && list.get(list.size()-1)[1] >= intervals[i][0]) {
                int[] removeEle = list.remove(list.size() -1);
                int firstEle = Math.min(removeEle[0], intervals[i][0]);
                list.add(new int[] {firstEle,intervals[i][1]});
            } else list.add (new int[]{intervals[i][0], intervals[i][1]});
        }


        int[][] answer = new int[list.size()][2];
        int idx = 0;
        for (int[] e: list) answer[idx++] = e;
        return answer;
    }
}
