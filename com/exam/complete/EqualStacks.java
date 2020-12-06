package exam.complete;
//https://www.hackerrank.com/challenges/equal-stacks/problem
//TODO UPLOAD
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class EqualStacks {
    public static void main(String[] args) {
        System.out.println(equalStacks(Arrays.asList(3,2,1,1,1), Arrays.asList(2,3,4), Arrays.asList(1, 4,1,1)));
    }
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

//        Reversing lists
        Collections.reverse(h1);
        Collections.reverse(h2);
        Collections.reverse(h3);

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

        if(h1Height == h2Height && h1Height == h3Height) return h1Height;

        while(stack1.size() >= 0) {
            int nowMaxHeight = (h1Height >= h2Height && h1Height >= h3Height) ? 1 :
                    ((h2Height >= h1Height && h2Height >= h3Height) ? 2 : 3 );

            int now;
            switch (nowMaxHeight) {
                case 1 -> {
                    now = stack1.pop();
                    h1Height -= now;
                }
                case 2 -> {
                    now = stack2.pop();
                    h2Height -= now;
                }
                default -> {
                    now = stack3.pop();
                    h3Height -= now;
                }
            }

            if (h1Height == h2Height && h1Height == h3Height) return h1Height;
        }
        return 0;
    }
}
