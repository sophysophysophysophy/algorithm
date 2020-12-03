package exam.uploaded;
//https://www.hackerrank.com/challenges/maximum-element/problem


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.util.Collections.reverseOrder;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
            int iterCnt = parseInt(bufferedReader.readLine());
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new PriorityQueue<>(reverseOrder());
            while (iterCnt-- > 0) {
                StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine()," ");
                int nowK = parseInt(tokenizer.nextToken());
                switch (nowK) {
                    case 1 -> {
                        int nowValue = parseInt(tokenizer.nextToken());
                        stack.push(nowValue);
                        queue.add(nowValue);
                    }
                    case 2 -> {
                        Integer pop = stack.pop();
                        queue.remove(pop);
                    }
                    default -> System.out.println(queue.peek());
                }
            }
        }
    }
}
