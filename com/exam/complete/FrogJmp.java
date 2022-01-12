package exam.complete;

public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));

    }
    public static int solution(int X, int Y, int D) {
        return getTotalCount(X, Y, D);
    }

    private static int getTotalCount(int x, int y, int d) {
        return Math.floorDiv((y - x), d) + (Math.floorMod(y - x, d) > 0 ? 1 : 0);
    }

}
