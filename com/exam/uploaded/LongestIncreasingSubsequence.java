package exam.uploaded;

//https://leetcode.com/problems/longest-increasing-subsequence/

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS(int[] nums) {
        int answer = 0 ;
        int[] result = new int[nums.length];

        result[0] = 1;
//        Nested loop  O(n2)
        for (int i = 1; i < nums.length; i++) {
            int nowCnt = 1;
            for (int j = 0; j < i; j++) if(nums[i] > nums[j]) nowCnt = Math.max(nowCnt, result[j] + 1);
            result[i] = nowCnt;
            answer = Math.max(nowCnt, answer);
        }

        return answer;
    }
}
