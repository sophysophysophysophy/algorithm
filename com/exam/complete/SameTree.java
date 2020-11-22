package exam.complete;


//https://leetcode.com/problems/same-tree/

import exam.TreeNode;

public class SameTree {
    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)  return true;
        else if(p == null || q == null) return false;
        else if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
