package exam.todo.grammerStudy.exception;

import org.junit.jupiter.api.Test;

public class ObjectTest {


    @Test
    void objectTest() throws Exception {
        //            throw new ObjectTest(); // compile error : Throwable Interface 상속된 객체만 throw 가능
        throw new Exception();
    }
}
