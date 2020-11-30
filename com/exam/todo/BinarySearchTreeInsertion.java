package exam.todo;
//https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem

import exam.Node;

public class BinarySearchTreeInsertion {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2, node1, node3);
        Node node7 = new Node(7);
        Node node4 = new Node(4,node2, node7);
        insert(node4, 6);
        System.out.println(node4.val);
    }
    public static Node insert(Node root, int data) {
        insert(data, root);
        return root;
    }

    private static Node insert(int data, Node nowNode) {
        System.out.println(data);
        if(nowNode == null) return new Node(data);
        if(nowNode.val > data) nowNode.left = insert(data, nowNode.left);
        if(nowNode.val < data) nowNode.right = insert(data, nowNode.right);
        return nowNode;
    }
}
