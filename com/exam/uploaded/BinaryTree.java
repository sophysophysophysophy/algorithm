package exam.uploaded;


//BinrayTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node)와 dfs(Node node) 메소드를 구현하세요.
//DFS는 왼쪽, 루트, 오른쪽 순으로 순회하세요.

import exam.Node;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node BinaryTree(int data, Node nowNode) {
        if(nowNode == null) return new Node(data);
        if(nowNode.val > data) nowNode.left = BinaryTree(data, nowNode.left);
        if(nowNode.val < data) nowNode.right = BinaryTree(data, nowNode.right);
        return nowNode;
    }


    public List<List<Integer>> bfs(Node node) {
        List<List<Integer>> answer = new ArrayList<>();
        if(node == null) return answer;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(node.val);
        answer.add(list);

        levelOrder(node, 1, answer);
        return answer;
    }

    public void levelOrder(Node node, int depth, List<List<Integer>> answer) {
        if(answer.size() < depth + 1) {
            ArrayList<Integer> list = new ArrayList<>();
            if(node.left != null) list.add(node.left.val);
            if(node.right != null) list.add(node.right.val);
            if(list.size() != 0 ) answer.add(list);
        }else {
            List<Integer> list = answer.get(depth + 1);
            if(node.left != null) list.add(node.left.val);
            if(node.right != null) list.add(node.right.val);
        }
        if(node.left != null) levelOrder(node.left, depth + 1, answer);
        if(node.right != null) levelOrder(node.right, depth + 1, answer);
    }

    public void dfs(Node node) {
        if(node.left != null) dfs(node.left);
        System.out.print(node.val+" ");
        if(node.right != null) dfs(node.right);
    }
}
