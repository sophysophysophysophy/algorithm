package exam.todo;

import org.junit.jupiter.api.Test;

class MatrixRotationTest {

    private static int apply(int i, int j) {
        return j;
    }

    @Test
    void solutionTest() {
        int[] answer = MatrixRotation.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});


    }
}