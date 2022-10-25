package exam.todo.grammerStudy.inheritance;

public class ChildObj extends ParentObj {

    private String field1;
    @Override
    public void testMethod() {
        field1 = "childField";
        System.out.println("ChildObj.testMethod.field1 = " + field1);
    }
}
