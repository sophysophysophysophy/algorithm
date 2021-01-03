package exam.uploaded;


//https://www.hackerrank.com/challenges/tree-preorder-traversal/problem

import exam.Node;

public class TreePreorderTraversal {

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node3 = new Node(3, null, node4);
        Node node6 = new Node(6);
        Node node5 = new Node(5, node3, node6);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, null, node2);
        preOrder(node1);
    }

    public static void preOrder(Node root) {
        System.out.print(root.val+" ");
        if(root.left != null) preOrder(root.left);
        if(root.right != null) preOrder(root.right);
    }
}
