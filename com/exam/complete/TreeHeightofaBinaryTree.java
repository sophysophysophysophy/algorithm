package exam.complete;
//https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

import exam.Node;
public class TreeHeightofaBinaryTree {

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node3 = new Node(3, null, node4);
        Node node6 = new Node(6);
        Node node5 = new Node(5, node3, node6);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, null, node2);
        System.out.println(height(node1));
    }

    static int answer ;
    public static int height(Node root) {
        answer = 0;
        height(root, 1);
        return answer;
    }

    private static void height(Node root, int nowHeight) {
        answer = Math.max(answer, nowHeight);
        if(root.right != null) height(root.right, nowHeight + 1);
        if(root.left != null) height(root.left, nowHeight + 1);
    }
}
