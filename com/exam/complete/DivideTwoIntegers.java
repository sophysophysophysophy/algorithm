package exam.complete;
//https://leetcode.com/problems/divide-two-integers/
//TODO UPLOAD
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648
                ,-1));
        System.out.println(divide(-1,-1));
        System.out.println(Integer.MIN_VALUE);
    }

    public static int divide(int dividend, int divisor) {
        if((long) dividend / divisor > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return dividend / divisor ;
    }
}
