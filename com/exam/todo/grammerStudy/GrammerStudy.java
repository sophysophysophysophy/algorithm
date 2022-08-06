package exam.todo.grammerStudy;

import org.junit.jupiter.api.Test;

public class GrammerStudy {

    public static void grammerStudyFuc() {

    }

    static void myMehod(Class<String> tClass) {
        System.out.println("tClass.getName() = " + tClass.getName());
        System.out.println("tClass.getClass().getGenericSuperclass() = " + tClass.getClass().getGenericSuperclass());

    }

    @Test
    void testGrammerStudyFuc() {
        myMehod(String.class);
    }
}
