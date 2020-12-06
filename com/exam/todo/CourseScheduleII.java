package exam.todo;


//https://leetcode.com/problems/course-schedule-ii/

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII {

    public static void main(String[] args) {

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courseRelList = new ArrayList<>();
        boolean canFin = canFinish(numCourses, prerequisites, courseRelList);
        int[] answer = new int[numCourses - 1];
        if (!canFin) return new int[]{0};


        for (int i = 0; i < numCourses; i++) {
//             i == startIdx
            List<Integer> list = new ArrayList<>();
            makeAnswerByRecur(list, i, courseRelList);
        }


        return answer;
    }

    private static void makeAnswerByRecur(List<Integer> list, int i, List<List<Integer>> courseRelList) {

    }


    static boolean answerFlag ;
    public static boolean canFinish(int numCourses, int[][] prerequisites, List<List<Integer>> courseRelList) {
        for (int i = 0; i < numCourses; i++) {
            List<Integer> list = new ArrayList<>();
            courseRelList.add(list);
        }


        for (int[] nowCourse : prerequisites) {
            int postCourse = nowCourse[0];
            int preCourse = nowCourse[1];
            answerFlag = true;
            checkCanFinish(preCourse,courseRelList, postCourse);
            if (!answerFlag) return false;
            else courseRelList.get(postCourse).add(preCourse);
        }

        return true;
    }

    private static void checkCanFinish(int preCourse, List<List<Integer>> courseRelList, int target) {
        List<Integer> nowList = courseRelList.get(preCourse);
        for (int i : nowList) {
            if (i == target) answerFlag = false;
            checkCanFinish(i, courseRelList, target);
        }
    }
}
