package exam.todo.grammerStudy.sorting;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ArrayListTest {

    @Test
    void arrayListTest() {
        ArrayList<String> arrayListObj = new ArrayList<>();
        ArrayList<Integer> arrayListIntObj = new ArrayList<>();

        LinkedList<String> linkedListObj = new LinkedList<>();


        String[] arrayObj = new String[] {"java", "string"};

        arrayListObj.sort(null);       // 내부적으로 Arrays.sort 호출. (매커니즘 같음)
        Collections.sort(arrayListObj);
        arrayListIntObj.sort(Comparator.naturalOrder());
        linkedListObj.sort(Comparator.naturalOrder());

        Arrays.sort(arrayObj);      //TimSort... ??



//        cf) stream sorting?
        Arrays.stream(arrayObj).sorted();
    }
}
