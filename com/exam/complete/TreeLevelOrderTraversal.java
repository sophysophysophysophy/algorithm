package exam.complete;
//https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
//TODO UPLOAD

import exam.Node;

import java.util.ArrayList;
import java.util.List;

public class TreeLevelOrderTraversal {
    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node3 = new Node(3, null, node4);
        Node node6 = new Node(6);
        Node node5 = new Node(5, node3, node6);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, null, node2);
        levelOrder(node1);
    }

    public static void levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list, 0);

        for (List<Integer> nowList : list) for (int i : nowList) System.out.print(i+" ");
    }

    private static void levelOrder(Node nowNode, List<List<Integer>> list, int depth) {
        if(list.size() > depth ) {
            List<Integer> nowList = list.get(depth);
            nowList.add(nowNode.data);
        } else {
            List<Integer> firstList = new ArrayList<>();
            firstList.add(nowNode.data);
            list.add(depth, firstList);
        }
        if (nowNode.left != null) levelOrder(nowNode.left, list, depth + 1 );
        if(nowNode.right != null) levelOrder(nowNode.right, list , depth + 1);
    }


}
