package exam.todo;
//https://www.hackerrank.com/challenges/equal-stacks/problem

import java.util.List;
import java.util.Stack;

public class EqualStacks {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int h1Height = 0, h2Height = 0 , h3Height = 0 ;
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>(), stack3 = new Stack<>();

        for (int i : h1) {
            h1Height += i;
            stack1.push(i);
        }
        for (int i : h2) {
            h2Height += i;
            stack2.push(i);
        }
        for (int i : h3) {
            h3Height += i;
            stack3.push(i);
        }

        return 0;
    }
}
