package exam.todo;


import exam.TreeNode;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterofBinaryTree {
    public static void main(String[] args) {

    }


    static int answer;
    public int diameterOfBinaryTree(TreeNode root) {

        answer = 0 ;
        answer = diameterOfBinaryTree(root, root.left, root.right);

        return answer;
    }

//    private int diameterOfBinaryTree(TreeNode root, TreeNode left, TreeNode right) {
//        return
//    }
}
