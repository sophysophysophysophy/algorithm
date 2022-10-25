package exam.todo.grammerStudy;

import org.junit.jupiter.api.Test;

public class CallByValueTest {

    class TestDto {
        String testField;

        public TestDto(String testField) {
            this.testField = testField;
        }

        @Override
        public String toString() {
            return "TestDto{" +
                    "testField='" + testField + '\'' +
                    '}';
        }
    }

    void callByValueExample() {
        TestDto testDto = new TestDto("test");
        System.out.println("testDto = " + testDto);

        testDto = new TestDto("test2");

        System.out.println("testDto = " + testDto);

        setField(testDto);
        System.out.println("testDto = " + testDto);  //반영됨. 인스턴스의 참조 value 변경 가능

        setInstance(testDto);
        System.out.println("testDto = " + testDto);         // 반영되지 않음. 주소 자체를 넘기지 않기 때문
    }

    private void setInstance(TestDto testDto) {
        testDto = new TestDto("new Instance");
    }

    private void setField(TestDto testDto) {
        testDto.testField = "method call";
    }

    @Test
    void callByValueTest() {
        callByValueExample();
    }
}
