package exam.todo.grammerStudy.string;

import org.junit.jupiter.api.Test;

public class StringTest {
    
    
    @Test
    void stringTest() {
        String a = new String("test");
        System.out.println("a.hashCode() = " + a.hashCode());
        a = a + "confident";
        System.out.println("a.hashCode() = " + a.hashCode());
        String b = "testconfident";

        System.out.println("b.hashCode() = " + b.hashCode());
        System.out.println("b.equals(a) = " + b.equals(a));


//        String 객체 : immutable. 메모리 많이 사용.
//        가변(mutable)성을 가지는 StringBuffer / StringBuilder 클래스를 도입
//        append, delete 등으로 동일 객체 내에서 문자열 변경이 가능
        StringBuffer stringBuffer = new StringBuffer("hello");
        stringBuffer.append(" world");

//        StringBuilder vs StringBuffer
//        같은점 : heap 영역에 객체로 생성. 변경 가능 .
//        차이점 : 동기화 유무 ( 멀티쓰레드 안전성 ( thread-safe))
//        StringBuffer만이 thread-safety
//        StringBuilder는 동기화 하지 않기 때문에 일반적인 단일쓰레드 환경에서 성능이 가장 뛰어남

        StringBuilder builder = new StringBuilder("hello");

        builder.append("dpd~");
        System.out.println("builder.toString() = " + builder);
    }
}
