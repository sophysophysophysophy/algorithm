package exam.todo.grammerStudy.classLoader;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ClassLoaderTest {

    public static void main(String[] args) {
        System.out.println("ClassLoaderTestClass.class.getClassLoader() in psvm = " + ClassLoaderTestClass.class.getClassLoader());
        System.out.println("args.getClass().getClassLoader() = " + ClassLoaderTest.class.getClassLoader());
        System.out.println("System.class.getClassLoader() = " + System.class.getClassLoader());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        System.out.println("ArrayList.class.getClassLoader() = " + strings.getClass().getClassLoader());

    }
    @Test
    void classLoaderTest() {
        System.out.println("ClassLoaderTestClass.class.getClassLoader() = " + ClassLoaderTestClass.class.getClassLoader());
    }
}
