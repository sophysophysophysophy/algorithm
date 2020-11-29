package exam.complete;

//https://leetcode.com/problems/combination-sum/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {1,2,3,4,5,6,7}, 6));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(candidates);
//        dfs
//        Filtering valid candidates
        int[] validCand = candidates;
        for(int i = 0 ; i < candidates.length; i++) {
            if(candidates[i] > target) {
                validCand = Arrays.copyOfRange(candidates, 0, i);
                break;
            }
        }

//        Searching
        for(int i = 0 ; i < validCand.length; i++) {
            List<Integer> nowList = new ArrayList<>();
            nowList.add(validCand[i]);
            dfs(validCand, nowList, validCand[i], target,answer);
        }


        return answer;
    }


    public static void dfs(int[] validCand, List<Integer> nowList, int nowValue, int target, List<List<Integer>> answer) {
        if(nowValue == target) {
            ArrayList<Integer> answerList = new ArrayList<>(nowList);
            Collections.sort(answerList);
            if(!answer.contains(answerList)) answer.add(answerList);
        } else if( nowValue < target) {
            for(int i = 0; i < validCand.length; i++) {
                if(validCand[i] + nowValue <= target)  {
                    nowList.add(validCand[i]);
                    dfs(validCand, nowList, nowValue+validCand[i], target, answer);
                    nowList.remove(Integer.valueOf(validCand[i]));
                }
            }
        }

    }
}
