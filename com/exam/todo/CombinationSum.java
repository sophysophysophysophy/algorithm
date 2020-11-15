package exam.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO
//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {1,2,3,4,5,6,7}, 6));
    }


    static List<List<Integer>> answer = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        dfs
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
            dfs(validCand, nowList, validCand[i], target);
        }


        return answer;
    }


    public static void dfs(int[] validCand, List<Integer> nowList, int nowValue, int target) {
        if(nowValue == target) {
            ArrayList<Integer> answerList = new ArrayList<>(nowList);
            answer.add(answerList);
        } else if( nowValue < target) {
            for(int i = 0; i < validCand.length; i++) {
                if(validCand[i] + nowValue > target)  {
                    nowList.add(validCand[i]);
                    dfs(validCand, nowList, nowValue+validCand[i], target);
                }
            }
        }

    }
}
