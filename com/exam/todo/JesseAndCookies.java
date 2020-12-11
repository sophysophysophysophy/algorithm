package exam.todo;
//hackerrank.com/challenges/jesse-and-cookies/problem


import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class JesseAndCookies {

    static int cookies(int k, int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int i : A) list.add(i);
        int answer = 0;
        boolean flag = true;

        while (flag) {
            if(list.size() < 2) return -1;
            int firstValue = list.remove(0);
            int secondValue = list.remove(1);

//            Calculating
            int calVal = firstValue + secondValue * 2;
            list.add(calVal);
            sort(list);
            if(list.get(0) >= k) return answer + 1;

            answer++;
        }
        return answer;
    }
}
