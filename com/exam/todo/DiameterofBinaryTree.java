package exam.todo;


import exam.TreeNode;

//https://leetcode.com/problems/diameter-of-binary-tree/
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
    public static int diameterOfBinaryTree(TreeNode root) {

        answer = diameterOfBinaryTreeDFS(root);
        return answer;
    }

    private static int diameterOfBinaryTreeDFS(TreeNode root) {
        if(root.left == null && root.right == null) return 0;
        int leftVal = root.left == null ? 0 : diameterOfBinaryTree(root.left);
        int rightVal = root.right == null ? 0 : diameterOfBinaryTree(root.right);
        answer = Math.max(leftVal + rightVal + 1, answer);

        return Math.max(leftVal + 1, rightVal + 1);
    }
}
