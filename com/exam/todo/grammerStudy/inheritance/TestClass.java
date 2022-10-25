package exam.todo.grammerStudy.inheritance;

import org.junit.jupiter.api.Test;

public class TestClass {


    public static class ClassParentToChildDI {
        ParentObj parentObj;

        public ClassParentToChildDI(ParentObj parentObj) {
            this.parentObj = parentObj;
        }

        public void testMethod() {
            parentObj.testMethod();
        }
    }

    public static class ClassChildToParentDI {
        ChildObj childObj;

        public ClassChildToParentDI(ChildObj childObj) {
            this.childObj = childObj;
        }

        public void testMethod() {
            childObj.testMethod();
        }
    }

    @Test
    void inheritanceTest() {
        ChildObj child = new ChildObj();
        ClassParentToChildDI classDI = new ClassParentToChildDI(child);
        classDI.testMethod();           // parent객체 자리 -> child 객체 주입 가능


        ParentObj parentObj = new ParentObj();

        // TODO child 객체 자리 -> parent 객체 주입 불가!!
//        ClassChildToParentDI classChildToParentDI = new ClassChildToParentDI(parentObj);

    }

}
