package exam;

//https://leetcode.com/problems/longest-increasing-subsequence/
//TODO
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS(int[] nums) {
        int answer = 0 ;

//        Nested loop  O(n2)
//        for (int i = 0; i < nums.length; i++) {
//            int nowNum = nums[i];
//            int nowLength = 0 ;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nowNum < nums[j]) {
//                    nowLength++;
//                    nowNum = nums[j];
//                } else break;
//            }
//            answer = Math.max(answer, nowLength);
//        }



        return answer;
    }
}
