package exam;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/word-search/
//TODO
public class WordSearch {
    public static void main(String[] args) {
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(chars, "ABCCED"));
    }

//    BFS
    public static boolean exist(char[][] board, String word) {
        boolean answer = false;

        Queue<String, Integer, Integer> queue = new ArrayDeque<>();

        int colLength = board.length;
        int rowLength = board[0].length;
        int[] neighborIdxListX = {-1,1,0,0};
        int[] neighborIdxListY = {0,0,-1,0};
        int idxX = 0;
        int idxY = 0;

        queue.add(String.valueOf(board[0][0]));
        while(true) {
            if(queue.size() < 1) return false;

            String nowString = queue.poll();
            System.out.println(nowString);
            if(nowString.equals(word)) return true;
            if(nowString.length() >= word.length()) continue;

            for(int i = 0 ; i < neighborIdxListX.length; i++) {
                int nextIdxX  = idxX + neighborIdxListX[i];
                int nextIdxY = idxY + neighborIdxListY[i];

                if(nextIdxX >= 0 && nextIdxX < colLength && nextIdxY >=0  && nextIdxY < rowLength) {
                    String nextValue = nowString + board[nextIdxX][nextIdxY];
                    if(nextValue.equals(word)) return true;
                    queue.add(nextValue);
                    idxX = nextIdxX;
                    idxY = nextIdxY;
                }
            }
        }
    }
}
