package exam.complete;
//https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem

import exam.Node;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeLowestCommonAncestor {

    public static Node lca(Node root, int v1, int v2) {
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        findAncestor(v1, root, list1);
        findAncestor(v2, root, list2);

        for(int i = list1.size() - 1 ; i >= 0 ; i--){
            for (int j = list2.size() - 1; j >= 0; j--) {
                if(list1.get(i).val == list2.get(j).val) return list1.get(i);
            }
        }

        return null;
    }

    private static void findAncestor(int value, Node nowNode, List<Node> list) {
        list.add(nowNode);
        if (nowNode.val != value) {
            if(nowNode.val > value) findAncestor(value, nowNode.left, list);
            else findAncestor(value, nowNode.right, list);
        }
    }
}
