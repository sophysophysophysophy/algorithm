package exam.todo;
//https://www.hackerrank.com/challenges/array-left-rotation/problem

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int n = arr.size();
        if( d == n ) return arr;

        List<Integer> answerList = new ArrayList<>();
        for (int i = d ; i < n; i++) answerList.add(arr.get(i));
        for (int i = 0; i < d; i++) answerList.add(arr.get(i));


        return answerList;
    }
}
