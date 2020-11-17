package exam.todo;


import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(canFinish(2,new int[][] {{0,1}, {1,0}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean answer = true;
        boolean[] flag = new boolean[numCourses];
        List<Integer> list = new ArrayList<>();

        for (int[] intArray : prerequisites) {
            if (flag[intArray[0]] && flag[intArray[1]]) {

            } else if (flag[intArray[0]]) {

            } else if (flag[intArray[1]]) {

            } else {

            }
        }


        return answer;
    }
}
