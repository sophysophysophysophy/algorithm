package exam.todo;


//https://leetcode.com/problems/find-median-from-data-stream/

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

    /** initialize your data structure here. */
    public MedianFinder() {
        sum = 0 ;
        cnt = 0;
    }

    public void addNum(int num) {
        sum += num;
        if(num != 0 ) cnt++;

    }

    public double findMedian() {
        return cnt == 0 ? 0 : (double) sum / cnt;
    }
}
