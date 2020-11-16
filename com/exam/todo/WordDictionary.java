package exam.todo;


//https://leetcode.com/problems/design-add-and-search-words-data-structure/

import java.util.*;

public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

    }


    Set<String> set ;
    /** Initialize your data structure here. */
    public WordDictionary() {
        set = new HashSet<>();

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        set.add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        StringBuilder stringBuilder = new StringBuilder();

//        Creating a pattern


//        ArrayList<> char[] chars = ;


//        Creating a matcher obj

//        Finding in the set


    }
}