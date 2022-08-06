package exam.todo.grammerStudy;

import org.junit.jupiter.api.Test;

import java.util.*;

public class EqualsTest extends GrammerStudy{

    public class InnerObjClass{

        int integerField1;
        int integerField2;
        int[] listField1;
        String stringField1;
        String strginField2;
        List list;

        public InnerObjClass(int integerField1, int integerField2, int[] listField1, String stringField1, String strginField2, List list) {
            this.integerField1 = integerField1;
            this.integerField2 = integerField2;
            this.listField1 = listField1;
            this.stringField1 = stringField1;
            this.strginField2 = strginField2;
            this.list = list;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InnerObjClass that = (InnerObjClass) o;
            System.out.println("Objects.equals(list, that.list); = " + Objects.equals(list, that.list));
            return integerField1 == that.integerField1 && integerField2 == that.integerField2 && Arrays.equals(listField1, that.listField1) && Objects.equals(stringField1, that.stringField1) && Objects.equals(strginField2, that.strginField2) && Objects.equals(list, that.list);
        }

        @Override
        public int hashCode() {
            Objects.hashCode(integerField1);
            int result = Objects.hash(integerField1, integerField2, stringField1, strginField2, list);
            result = 31 * result + Arrays.hashCode(listField1);

            return result;
        }
    }
    @Test
    void equalsTest() {
        new ArrayList<>();
        InnerObjClass testObj1 = new InnerObjClass(1, 2, new int[]{1, 2, 3}, "string", "string2", new ArrayList<Integer>());
        InnerObjClass testObj2 = new InnerObjClass(1, 2, new int[]{1, 2, 3}, "string", "string2", List.of(1, 2, 3));

        System.out.println("testObj2.getClass() = " + testObj2.getClass());
        System.out.println("GrammerStudy.class = " + GrammerStudy.class);
        System.out.println("new EqualsTest().getClass() = " + EqualsTest.class);
        EqualsTest a = new EqualsTest();
        System.out.println("a.getClass() = " + a.getClass());
        System.out.println("a instanceof GrammerStudy = " + (a instanceof GrammerStudy));
        System.out.println("testObj2.list == testObj1.list = " + (testObj2.list == testObj1.list));
        System.out.println("testObj2.equals(testObj1) = " + testObj2.equals(testObj1));
        //        Assertions.assertEquals(testObj1, testObj2);

    }
}
