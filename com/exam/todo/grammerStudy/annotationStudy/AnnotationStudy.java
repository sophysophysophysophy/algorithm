package exam.todo.grammerStudy.annotationStudy;

//어노테이션의 용도는 다양한 목적이 있지만 메타 데이터의 비중이 가장 크다 할 수 있습니다.

//@SuppressWarnings
//선언한 곳의 컴파일 경고를 무시하도록 합니다.

//@SafeVarargs
//Java7 부터 지원하며, 제너릭 같은 가변인자의 매개변수를 사용할 때의 경고를 무시합니다.

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

//@FunctionalInterface
//Java8 부터 지원하며, 함수형 인터페이스를 지정하는 어노테이션입니다.
//        만약 메서드가 존재하지 않거나, 1개 이상의 메서드(default 메서드 제외)가 존재할 경우 컴파일 오류를 발생 시킵니다.
public class AnnotationStudy {

    private <T> void checkAnnotation(T targetObj, Class<T> objClassName) throws NoSuchMethodException {


        Method testMethod = objClassName.getDeclaredMethod("testMethod");
        CustomAnnotation declaredAnnotation = testMethod.getDeclaredAnnotation(CustomAnnotation.class);
        boolean check = declaredAnnotation.isCheck();

        if (check) {
            System.out.println("check processing...");
        } else {
            System.out.println("do not check ");
        }
    }



    @Test
    void annotationStudyTest() throws NoSuchMethodException {
//        AnnotatonExam annotatonExam = new AnnotatonExam();
//        checkAnnotation(annotatonExam, AnnotatonExam.class);

//        Moja moja = new Moja(); //annotation processor를 통해 생성해 낼 클래스
//        System.out.println(moja
    }

}
