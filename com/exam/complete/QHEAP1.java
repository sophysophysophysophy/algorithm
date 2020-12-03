package exam.complete;
//TODO UPLOAD
//https://www.hackerrank.com/challenges/qheap1/problem

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class QHEAP1 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
            int iterCnt = parseInt(bufferedReader.readLine());
            Queue<Integer> queue = new PriorityQueue<>();
            while (iterCnt-- > 0) {
                StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                int nowK = parseInt(tokenizer.nextToken());
                switch (nowK) {
                    case 1:
                        int nowValue = parseInt(tokenizer.nextToken());
                        queue.add(nowValue);
                        break;
                    case 2:
                        nowValue = parseInt(tokenizer.nextToken());
                        queue.remove(nowValue);
                        break;
                    default:
                        System.out.println(queue.peek());
                        break;
                }
            }
        }
    }
}
