package exam.complete;

/**
 *
 * Codility
 * https://app.codility.com/c/run/trainingY4KNKZ-TXN/
 *
 */
public class CyclicRotation {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int[] solution(int[] A, int K) {
        CyclicRotation cyclicRotation = new CyclicRotation(A, K);

        cyclicRotation.rotate();
        return cyclicRotation.getResultArray();

    }

    private int[] inputArray;
    private int inputK;
    private int[] resultArray;

    public CyclicRotation(int[] inputArray, int inputK) {
        this.inputArray = inputArray;
        this.inputK = inputK;
    }

    public void rotate() {
        if(throwedException()) return;

        resultArray = new int[inputArray.length];
        int rotateCount = inputArray.length > inputK ? inputK : Math.floorMod(inputK, inputArray.length);

        for (int i = 0; i < inputArray.length; i++) {
            int resultIndex = Math.floorMod(i + rotateCount, inputArray.length);
            resultArray[resultIndex] = inputArray[i];
        }

    }


    private boolean throwedException() {
        if (inputArray.length == 0 || inputK == 0 ) return true;
        else return Math.floorMod(inputK, inputArray.length) == 0;
    }

    public int[] getResultArray() {
        return resultArray;
    }
}
