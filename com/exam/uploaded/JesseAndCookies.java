package exam.uploaded;
//https://www.hackerrank.com/challenges/jesse-and-cookies/problem
//TODO UPLOAD
import java.util.PriorityQueue;
import java.util.Queue;

public class JesseAndCookies {
    static int cookies(int k, int[] A) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : A) queue.add(i);
        if(queue.peek() >= k ) return 0;
        int answer = 0;

        while (queue.size() > 1) {
            int firstValue = queue.poll();
            int secondValue = queue.poll();

//            Calculating
            int calVal = firstValue + secondValue * 2;

            queue.add(calVal);
            if(queue.peek() >= k) return answer + 1;
            answer++;
        }

        return -1;
    }
}
