package exam.complete.todo;

/**
 *
 * https://app.codility.com/programmers/lessons/1-iterations/
 *  Interations : Easy
 *
 */
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(9));
    }
    public static int solution(int N) {
        int maxBinaryGap = 0;
        char[] binaryCharArray = Integer.toBinaryString(N).toCharArray();

        int increaseCount = 0;
        for (char binaryChar : binaryCharArray) {
            if (binaryChar == '1') {
                maxBinaryGap = Math.max(maxBinaryGap, increaseCount);
                increaseCount = 0;
            } else increaseCount++;

        }



        return maxBinaryGap;
    }
}
