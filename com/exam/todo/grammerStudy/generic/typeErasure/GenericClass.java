package exam.todo.grammerStudy.generic.typeErasure;

public class GenericClass<T> {

    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
