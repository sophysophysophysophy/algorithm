package exam.uploaded;
//https://leetcode.com/problems/subrectangle-queries/
//TODO UPLOAD

public class SubrectangleQueries {

    public static void main(String[] args) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][] {{1,2,1},{4,3,4},{3,2,1},{1,1,1}});
        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
        subrectangleQueries.getValue(0, 0);
    }

    int[][] rectangle;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i < row2; i++) {
            for (int j = col1; j < col2; j++) {
                this.rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
