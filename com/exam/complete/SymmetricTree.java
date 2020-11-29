package exam.complete;

//https://leetcode.com/problems/symmetric-tree/

import exam.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SymmetricTree {

//    recursive
    public static boolean isSymmetric(TreeNode root) {
        if(root == null ) return true;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        else if(left == null || right == null) return false;
        else if(left.val != right.val) return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left) ;
    }


//    iterative
    public static boolean isSymmetricIter(TreeNode root) {
        boolean answer = true;
        if(root == null) return true;

        Queue<NodeSet> queue = new ArrayDeque<>();
        queue.add(new NodeSet(root.left, root.right));

        while (queue.size() > 0) {
            NodeSet nowSet = queue.poll();
            if(nowSet.left == null && nowSet.right == null) continue;
            else if(nowSet.left == null || nowSet.right == null ) return false;
            else if(nowSet.left.val != nowSet.right.val) return false;
            queue.add(new NodeSet(nowSet.left.left, nowSet.right.right));
            queue.add(new NodeSet(nowSet.left.right, nowSet.right.left));
        }

        return answer;

    }

    private static class NodeSet {
        private TreeNode left;
        private TreeNode right;

        public NodeSet(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
