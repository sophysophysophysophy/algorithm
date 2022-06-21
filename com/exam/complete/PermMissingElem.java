package exam.complete;

/**
 * https://app.codility.com/c/run/trainingAXCPF7-VYD/
 */

public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,3,1,5}));
    }
    public static int solution(int[] A) {
        int[] existNumberInArrayCheck = changeIdxToOneIfExist(A);

        return findNotExistNumber(A, existNumberInArrayCheck);

    }

    private static int findNotExistNumber(int[] a, int[] existNumberInArrayCheck) {
        for (int i = 1; i < existNumberInArrayCheck.length; i++) if (existElemInArray(i, a)) return i;
        return -1;
    }

    private static int[] changeIdxToOneIfExist(int[] A) {
        int[] array = new int[A.length + 2];
        for (int i : A) array[i] = 1;
        return array;
    }

    private static boolean existElemInArray(int i, int[] A) {
        return A[i] == 0;
    }
}
