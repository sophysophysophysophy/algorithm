package exam;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    List<Integer> list ;


    public Stack() {
        this.list = new ArrayList<>();
    }

    public void push(int data) {
        this.list.add(data);
    }

    public int pop(){
        if (this.list.size() > 0) {
            return this.list.remove(0);
        } else return -1;
    }
}
