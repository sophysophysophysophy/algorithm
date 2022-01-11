package exam.todo;
//https://www.hackerrank.com/challenges/tree-top-view/problem

import exam.Node;

public class TreeTopView {
    public static void topView(Node root) {
        System.out.print(root.val+" ");
        if(root.right != null) topView(root.right);
    }
}
