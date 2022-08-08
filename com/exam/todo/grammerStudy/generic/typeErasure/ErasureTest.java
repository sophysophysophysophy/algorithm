package exam.todo.grammerStudy.generic.typeErasure;

import org.junit.jupiter.api.Test;

public class ErasureTest {


    @Test
    void erasureTest() {
        GenericClass<String> test = new GenericClass<>("test");
        String obj = test.getObj();



        System.out.println("obj = " + obj);

    }
}
