package exam.todo.grammerStudy.generic.superType;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public class GenericSuperType {
    @Test
    void getGenericSuperClass_반환형인_Type_출력() {
        class Super<T> {
        }
        class MyClass extends Super<List<String>> {
        }   // 수퍼 클래스에 사용되는 파라미터 타입을 이용. -> 수퍼 타입 토큰
        class paraGenericClass<T> {
            T obj ;
            public paraGenericClass<T> build() {
                Class<?> aClass = this.obj.getClass();
                String name = aClass.getName();
                System.out.println(name);
                return new paraGenericClass();
            }
        }
        MyClass myClass = new MyClass();


//        파라미터 타입 정보가 포함된 수퍼 클래스의 타입 정보 구함
        Type typeOfGenericSuperclass = myClass.getClass().getGenericSuperclass();
        System.out.println("typeOfGenericSuperclass = " + typeOfGenericSuperclass);


//        수퍼 클래스가  ParameterizedType 이므로 ParameterizedType으로 캐스팅 가능
        //        ParameterizedType의 getActualArguments()으로 실제 타입 파라미터의 정보를 구함
        Type actualTypeArguments = ((ParameterizedType) typeOfGenericSuperclass).getActualTypeArguments()[0];

        System.out.println("actualTypeArguments = " + actualTypeArguments);

//        paraGenericClass paraGenericClass = new paraGenericClass<>();
//        paraGenericClass.<Integer>build();

//        익명 클래스 이용
        Type genericSuperclassAnonymous = new Super<List<Integer>>() {}.getClass().getGenericSuperclass();

        Type actualTypeArgument = ((ParameterizedType) genericSuperclassAnonymous).getActualTypeArguments()[0];
        System.out.println("actualTypeArgument = " + actualTypeArgument);

    }


    @Test
    void genericSuperTypeTest() {
        SampleDTO.sampleDTOInnerClass instance = SampleDTO.sampleDTOInnerClass.getInstance();
        Class<? extends SampleDTO.sampleDTOInnerClass> aClass = instance.getClass();
        Type genericSuperclass = aClass.getGenericSuperclass();
        Type actualTypeArgument = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];


    }
}
