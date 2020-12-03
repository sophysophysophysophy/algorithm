package exam.uploaded;

//https://leetcode.com/problems/diameter-of-binary-tree/

import exam.TreeNode;

import static java.lang.Math.max;

public class DiameterofBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(2, treeNode1, treeNode2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode = new TreeNode(1, treeNode3, treeNode4);


        System.out.println(diameterOfBinaryTree(treeNode));
    }


    static int answer;
    private static int diameterOfBinaryTree(TreeNode root) {

        if(root == null) return 0;
        answer = 0;
        diameterOfBinaryTreeDFS(root);
        return answer;
    }

    private static int diameterOfBinaryTreeDFS(TreeNode root) {
        if(root.left == null && root.right == null) return 1;
        int leftVal = root.left == null ? 0 : diameterOfBinaryTreeDFS(root.left);
        int rightVal = root.right == null ? 0 : diameterOfBinaryTreeDFS(root.right);
        answer = max(leftVal + rightVal , answer);

        return max(leftVal + 1, rightVal + 1);
    }
}
