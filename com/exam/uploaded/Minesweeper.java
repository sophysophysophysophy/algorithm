package exam.uploaded;

//https://leetcode.com/problems/minesweeper/

import java.util.ArrayDeque;
import java.util.Queue;

public class Minesweeper {

    public static void main(String[] args) {
        char[][] chars = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        char[][] answer = updateBoard(chars, new int[]{3, 0});

    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        Queue<coorSet> q = new ArrayDeque<>();
        int colLength  = board.length;
        int rowLength = board[0].length;
        boolean[][] flag = new boolean[colLength][rowLength];

        q.add(new coorSet(click[0], click[1]));
        flag[click[0]][click[1]] = true;

        int[] arrX = {-1,-1,-1,0,0,1,1,1};
        int[] arrY = {1,0,-1,-1,1,-1,0,1};

        while (q.size() > 0) {
            coorSet nowSet = q.poll();
            int mineCnt = 0 ;
            for (int i = 0; i < arrX.length; i++) {
                int nextX = nowSet.getX() + arrX[i];
                int nextY = nowSet.getY() + arrY[i];
                if (nextX >= 0 && nextX < colLength && nextY >= 0 && nextY < rowLength) {
                    if (board[nextX][nextY] == 'M') {
                        mineCnt++;
                    }
                }
            }
            board[nowSet.getX()][nowSet.getY()] = mineCnt == 0 ? 'B' : Character.forDigit(mineCnt, 10) ;

            if (mineCnt == 0) {
                for (int i = 0; i < arrX.length; i++) {
                    int nextX = nowSet.getX() + arrX[i];
                    int nextY = nowSet.getY() + arrY[i];
                    if (nextX >= 0 && nextX < colLength && nextY >= 0 && nextY < rowLength) {
                        if(!flag[nextX][nextY]) {
                            q.add(new coorSet(nextX, nextY));
                            flag[nextX][nextY] = true;
                        }
                    }
                }
            }
        }
        return board;
    }


    private static class coorSet {
        private int x;
        private int y;

        public coorSet(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
