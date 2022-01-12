package exam.complete;

/**
 * https://app.codility.com/c/run/trainingAXCPF7-VYD/
 */
public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,3,1,5}));
    }
    public static int solution(int[] A) {
        int[] existNumberInArrayCheck = new int[A.length + 2];
        for (int i : A) existNumberInArrayCheck[i] = 1;
        for (int i = 1; i < existNumberInArrayCheck.length; i++) if (existNumberInArrayCheck[i] == 0) return i;
        return -1;
    }
}
