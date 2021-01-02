package exam.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class modernjava_practice {

//    predicate function 생성
//    public static <T> Predicate<T> distinct(Function<? super T, S> key) {
//        return t -> (int) key % 2 == 0 ;
//    }
//    public static boolean distinct2(int key) {
//        return key % 2 == 0 ;
//    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(1));
        list.add(String.valueOf(2));
        list.add(String.valueOf(3));
        list.add(String.valueOf(4));
        list.add(String.valueOf(5));
        list.add(String.valueOf(6));
        list.add(String.valueOf(7));

//        stream 객체 생성
        Stream<String> stream = list.stream();

//        객체 최종연산
        System.out.println(stream.count());



//        StreamBuilderExam
        Stream.Builder<String> builder = Stream.builder();
//        builder.accept("1");
//        builder.accept("2");
//        builder.accept("3");
//        builder.accept("4");
//        builder.accept("5");
//        builder.accept("6");
//        Stream<String> stringStream = builder.build();
//        stringStream.forEach(System.out::println);

//        chaining
        builder.add("1")
                .add("2")
                .add("3")
                .add("4")
                .add("5")
                .add("6").build().forEach(System.out::println);




        Stream.Builder<Integer> builder2 = Stream.builder();

//        map
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);

        map.forEach((key, value) -> System.out.println(String.format("%s , %d", key, value)));


    }


}
