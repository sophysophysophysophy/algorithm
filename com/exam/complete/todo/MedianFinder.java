package exam.complete.todo;


//https://leetcode.com/problems/find-median-from-data-stream/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFinder {

    public static void main(String[] args) {



//        ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//[[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
    }

    private int sum ;
    private int cnt;
    private List<Integer> arr ;
    /** initialize your data structure here. */
    public MedianFinder() {
        sum = 0 ;
        cnt = 0;
        arr = new ArrayList<>();
    }

    public void addNum(int num) {
        sum += num;
        if (num != 0) {
            cnt++;
            arr.add(num);
            Collections.sort(arr);
        }
    }

    public double findMedian() {

        return cnt > 0 ? cnt % 2 == 0 ?  (double) sum / cnt  : arr.get(cnt/2) : 0;
    }
}

//[null,null,6.00000,null,8.00000,null,6.00000,null,6.00000,null,6.00000,null,5.50000,null,6.00000,null,5.50000,null,5.00000,null,4.00000,null,3.00000]