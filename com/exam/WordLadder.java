package exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/word-ladder/
//TODO
public class WordLadder {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int answer = 0;

//        Exception Handling
        if(wordList.size() < 1) return answer;
        else if(!wordList.contains(endWord)) return answer;

        Queue<StrSet> queue = new ArrayDeque();
        boolean[] flag = new boolean[wordList.size()];

//        Initialization
        char[] chars = beginWord.toCharArray();
        for(int i = 0 ; i < wordList.size(); i++) {
            char[] targetChar = wordList.get(i).toCharArray();
            for(int j = 0; j < chars.length; j++) {
                for(int r = 0 ; r < targetChar.length; r++) {
                    if(chars[i] == targetChar[j]) {

                    }
                }

            }
        }

        return answer;

    }

    private static class StrSet {
        private String word;
        private char[] charArray;
    }
}
