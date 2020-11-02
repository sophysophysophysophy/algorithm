package exam;
//https://leetcode.com/problems/minimum-path-sum/
//TODO
public class MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][] {
                                                    {1,3,1},
                                                      {1,5,1},
                                                      {4,2,1}
                                                                }));
    }

    public static int minPathSum(int[][] grid) {
        int answer = 0;
        int[][] sumGrid = new int[grid.length][grid[0].length];

        for(int i = 0 ; i < grid.length; i++) {
            for( int j = 0 ; j < grid[i].length; j++) {
                int min = 0;
                if(i - 1 >= 0) {
                    min = grid[i-1][j];
                }
                if(j - 1 >= 0) {
                    min = Math.min(min, grid[i][j-1]);
                }
                sumGrid[i][j] = min + grid[i][j];
            }
        }

        return answer;

    }
}
