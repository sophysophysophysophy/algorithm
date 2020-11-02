package exam;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
//TODO
public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[] {1,2,3,4,5}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();


        dfs(answer, nums, 0);

        return answer;
    }

    public static void dfs(List<List<Integer>> answer, int[] nums, int idx) {
        answer.add(new ArrayList<Integer>());

    }
}
