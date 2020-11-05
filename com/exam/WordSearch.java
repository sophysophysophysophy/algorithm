package exam;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/word-search/
//TODO
public class WordSearch {
    public static void main(String[] args) {
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(chars, "ABCE"));
    }

//    BFS
    public static boolean exist(char[][] board, String word) {
        boolean answer = false;

        Queue<IdxSet> queue = new ArrayDeque<>();

        int colLength = board.length;
        int rowLength = board[0].length;
        int[] neighborIdxListX = {-1,1,0,0};
        int[] neighborIdxListY = {0,0,-1,1};
        int idxX = 0;
        int idxY = 0;

        for(int i = 0 ; i < colLength; i++) {
            for(int j = 0 ; j < rowLength; j++) {
                String nowStr =board[i][j]+"";
                if(nowStr.equals(word)) return true;
                queue.add(new IdxSet(nowStr, i, j, -1));

            }
        }

        while(true) {
            if(queue.size() < 1) return false;

            IdxSet nowSet =  queue.poll();
            String nowString = nowSet.getWord();

            System.out.println(nowString);

            if(nowString.equals(word)) return true;
            if(nowString.length() >= word.length()) continue;

            for(int i = 0 ; i < neighborIdxListX.length; i++) {
                int nextIdxX  = nowSet.getIdxX() + neighborIdxListX[i];
                int nextIdxY = nowSet.getIdxY() + neighborIdxListY[i];

                if(nextIdxX >= 0 && nextIdxX < colLength && nextIdxY >=0  && nextIdxY < rowLength && nowSet.getDirec() != i) {
                    String nextValue = nowString + board[nextIdxX][nextIdxY];
                    if(nextValue.equals(word)) return true;
                    queue.add(new IdxSet(nextValue, idxX, idxY, i));
                }
            }
        }
    }

    private static class IdxSet {
        private String word;
        private int idxX ;
        private int idxY;

        private int direc;

        public IdxSet(String word, int idxX, int idxY, int direc) {
            this.word = word;
            this.idxX = idxX;
            this.idxY = idxY;
            this.direc = direc;
        }

        public String getWord() {
            return word;
        }

        public int getIdxX() {
            return idxX;
        }

        public int getIdxY() {
            return idxY;
        }

        public int getDirec() {
            return direc;
        }
    }
}
