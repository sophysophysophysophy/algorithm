package exam.complete;

//https://leetcode.com/problems/game-of-life/

import java.util.Arrays;

public class GameofLife {
    public static void main(String[] args) {
        gameOfLife(new int[][] {
                                {0,1,0},
                                  {0,0,1},
                                  {1,1,1},
                                  {0,0,0}
                                });
    }

//    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
//    Any live cell with two or three live neighbors lives on to the next generation.
//    Any live cell with more than three live neighbors dies, as if by over-population..
//    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    public static void gameOfLife(int[][] board) {
        boolean[][] flag = new boolean[board.length][board[0].length];

        int[] arrX = {1, 1, 1, -1, -1, -1, 0, 0};
        int[] arrY = {0, 1, -1, 0, 1, -1, -1, 1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveCell  = 0 ;
                for (int r = 0; r < arrX.length; r++) {
                    int nextX = i + arrX[r];
                    int nextY = j + arrY[r];
                    if(nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[i].length) {
                        if(board[nextX][nextY] == 1) liveCell++;
                    }
                }

                if(board[i][j] == 1) {
                    if(liveCell < 2) flag[i][j] = false;
                    else if(liveCell < 4) flag[i][j] = true;
                    else flag[i][j] = false;
                }else {
                    if(liveCell == 3) flag[i][j] = true;
                }

            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(flag[i][j]) board[i][j] = 1;
                else board[i][j] = 0 ;
            }
        }


        System.out.println(Arrays.deepToString(board));
    }
}
