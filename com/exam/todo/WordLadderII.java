package exam.todo;

import java.util.*;

//https://leetcode.com/problems/word-ladder-ii/
//TODO
public class WordLadderII {

    public static void main(String[] args) {
        System.out.println(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
//        System.out.println(findLadders("a","c", Arrays.asList("a","b", "c")));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ArrayList<List<String>> answer = new ArrayList<>();

//        Exception Handling
        if(wordList.size() < 1) return answer;
        else if(!wordList.contains(endWord)) return answer;

        Queue<StrSet> queue = new ArrayDeque<>();
        boolean[] flag = new boolean[wordList.size()];



//        Initialization
        if (beginWord.equals(endWord)) {
            answer.add(Arrays.asList(beginWord));
            return answer;
        }
        for(int i = 0 ; i < wordList.size(); i++) {
            String nowWord = wordList.get(i);
            if (checkVal(beginWord, nowWord)) {
                if (nowWord.equals(endWord)) {
                    answer.add(Arrays.asList(beginWord, nowWord));
                    return answer;
                }
                flag[i] = true;
                queue.add(new StrSet(nowWord, 2, Arrays.asList(beginWord, nowWord)));
            }
        }

        boolean minValFlag = false;
        int minValCnt = 0;

        while (true) {
            if (queue.size() < 1) {
                break;
            }

            StrSet nowSet = queue.poll();
            String nowWord = nowSet.getWord();
            for (int i = 0; i < wordList.size(); i++) {
                String nextWord = wordList.get(i);
                if(!flag[i] && checkVal(nowWord, nextWord)){
                    flag[i] = true;
                    if (nextWord.equals(endWord)) {
                        if(!minValFlag) {
                            minValFlag = true;
                            minValCnt = nowSet.circleVal + 1;
                            List<String> nowSetList = nowSet.getList();
                            nowSetList.add(nextWord);
                            answer.add(nowSetList);
                        } else if (minValCnt == nowSet.circleVal + 1) {
                            List<String> nowSetList = nowSet.getList();
                            nowSetList.add(nextWord);
                            answer.add(nowSetList);
                        }
                    }
                    if(minValFlag && nowSet.getCircleVal() + 1 < minValCnt) {
                        List<String> nowList = new ArrayList<>(nowSet.getList());
                        nowList.add(nextWord);
                        queue.add(new StrSet(nextWord, nowSet.circleVal + 1, nowList));
                    }
                }
            }

        }

        return answer;

    }


    public static boolean checkVal(String beginWord, String nowWord) {
        char[] beginWordArray = beginWord.toCharArray(), targetWordArray = nowWord.toCharArray();

        int sameCharCnt = 0 ;
        for (int i = 0; i < beginWordArray.length; i++) {
            if (beginWordArray[i] != targetWordArray[i]) {
                sameCharCnt++;
            }
        }

        return sameCharCnt == 1;
    }

    public static class StrSet {
        private String word;
        private int circleVal;
        private List<String> list;

        public StrSet(String word, int circleVal, List<String> list) {
            this.word = word;
            this.circleVal = circleVal;
            this.list = list;
        }

        public int getCircleVal() {
            return circleVal;
        }

        public void setCircleVal(int circleVal) {
            this.circleVal = circleVal;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
}
