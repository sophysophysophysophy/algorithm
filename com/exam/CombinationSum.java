package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO
//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {1,2,3,4,5,6,7}, 6));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        dfs
        List<List<Integer>> answer = new ArrayList<>();


//        Filtering valid candidates
        int[] validCand = new int[0] ;
        for(int i = 0 ; i < candidates.length; i++) {
            if(candidates[i] > target) {
                validCand = Arrays.copyOfRange(candidates, 0, i);
                break;
            }
        }

//        Searching
        for(int i = 0 ; i < validCand.length; i++) {
            List<Integer> nowList = new ArrayList<>();
            dfs(answer, validCand, i, nowList, 0, target);
        }


        return answer;
    }


    public static void dfs(List<List<Integer>> list , int[] validCand, int idx, List<Integer> nowList, int nowValue, int target) {
        for(int i = idx; i < validCand.length; i++) {
            if(validCand[i] + nowValue > target)  {

            }
        }
    }
}
