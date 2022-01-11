package exam.todo;


public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

//  DP
public static String longestPalindrome(String s) {
    int n = s.length();
    String res = null;

    boolean[][] dp = new boolean[n][n];

    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

            if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                res = s.substring(i, j + 1);
            }
        }
    }


//  debugging
    for(int i = 0; i < dp.length; i++) {
        for(int j = 0; j< dp[i].length ; j++) {
            if(dp[i][j]) {
                System.out.print(1);
            }else System.out.print(0);
        }
        System.out.println();
    }
    return res;
}

//    Time Limit Exceeded
    public static String longestPalindromeBruteForce(String s) {
        String answer = "";
        int length = s.length();

//        2-nested loop
//        O(n to the power of 2)
        for(int i = length; i >= 0 ; i--) { // length
            for(int j = 0 ; i + j < length; j++) {
                String nowString = s.substring(j,j +i +1);
                if(checkPalin(nowString)){
                    return nowString;
                }
            }
        }
        return answer;
    }


    public static boolean checkPalin(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
