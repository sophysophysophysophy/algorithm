package exam.todo.grammerStudy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeTest {

    @Test
    void treeTest() {

//        - null 입력은 가능하지만 한 번만 저장 가능하고 중복될 수 없습니다.
//        - 객체(데이터)를 중복 저장할 수 없지만 오름차순으로 데이터를 정렬합니다.
//        - 내부적으로 TreeMap을 사용합니다.
        Set<String> treeSet = new TreeSet<>();

        //- null 입력은 가능하지만 한 번만 저장 가능하고 중복될 수 없습니다.
        //- 객체(데이터)를 중복 저장할 수 없고, 순서를 보장하지 않습니다.
        //- 내부적으로 HashMap을 사용합니다.
        Set<String> hashSet = new HashSet<>();



//        - null 입력은 가능하지만 한 번만 저장 가능하고 중복될 수 없습니다.
//        - 객체(데이터)를 중복 저장할 수 없지만 입력한 순서대로 데이터를 정렬합니다.
//        - 내부적으로 LinkedHashMap을 사용합니다.
        Set<String> linkedHashSet = new LinkedHashSet<>();




    }
}
