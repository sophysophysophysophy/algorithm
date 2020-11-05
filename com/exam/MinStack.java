package exam;

import java.util.Stack;
import java.util.TreeSet;

//https://leetcode.com/problems/min-stack/
//TODO
public class MinStack {

    private Stack<Integer> stack;
    private TreeSet<Integer> set;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(1);
        minStack.push(5);
        minStack.pop();
        minStack.push(7);
        minStack.push(0);
        minStack.pop();
        minStack.push(-1);
        minStack.push(10);

        System.out.println(minStack.getMin());
    }

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        set = new TreeSet<>();
    }

    public void push(int x) {
        stack.push(x);
        set.add(x);
    }

    public void pop() {
        int pop = stack.pop();
        set.remove(pop);
    }

    public int top() {
        int top = stack.pop();
        set.remove(top);
        stack.push(top);
        return top;
    }

    public int getMin() {
//  min
        return set.first();


    }
}
