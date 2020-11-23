package exam.complete;


import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(canFinish(2,new int[][] {{0,1}, {1,0}}));
        System.out.println(canFinish(6,new int[][] {{0,1}, {2,3}, {3,5}, {4,5}, {4,2}, {3,4}}));
    }


    static boolean answerFlag ;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean answer = true;
        boolean[] flag = new boolean[numCourses];
        List<List<Integer>> courseRelList = new ArrayList<>();
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

        return answer;
    }

    private static void checkCanFinish(int preCourse, List<List<Integer>> courseRelList, int target) {
        List<Integer> nowList = courseRelList.get(preCourse);
        for (int i : nowList) {
            if (i == target) answerFlag = false;
            checkCanFinish(i, courseRelList, target);
        }
    }
}
