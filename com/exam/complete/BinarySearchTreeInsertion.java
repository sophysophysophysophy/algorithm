package exam.complete;
//https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem

import exam.Node;

public class BinarySearchTreeInsertion {
    public static void main(String[] args) {
        Node root = insert(null, 4);
        insert(root, 2);
        insert(root, 3);
        insert(root, 1);
        insert(root, 7);
        insert(root, 6);
    }
    public static Node insert(Node root, int data) {
        if(root == null) return new Node(data);
        insert(data, root);
        return root;
    }

    private static Node insert(int data, Node nowNode) {
        if(nowNode == null) return new Node(data);
        if(nowNode.val > data) nowNode.left = insert(data, nowNode.left);
        if(nowNode.val < data) nowNode.right = insert(data, nowNode.right);
        return nowNode;
    }
}
