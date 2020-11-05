package exam;


//https://leetcode.com/problems/validate-binary-search-tree/
//TODO
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(20);
        TreeNode node4 = new TreeNode(6);
        TreeNode node3 = new TreeNode(15, node4,node5);
        TreeNode node2 = new TreeNode(5);

        TreeNode root = new TreeNode(2,node2,node3);
        System.out.println(isValidBST(root));
    }

    public static boolean answer;
//    dfs
    public static boolean isValidBST(TreeNode root) {
        answer = true;
        if(root != null) {
             dfsBST(null, root);
        }

        return answer;
    }

    public static void dfsBST(TreeNode parent, TreeNode root) {
        if(!answer) return;
        if(root.left != null) {
//            Compare
            if(root.left.val < root.val) {
                if(parent != null) {
//                    if(root.left.val > parent.val) {
                        dfsBST(root, root.left);
//                    } else answer = false;
                }
            } else {
                answer = false;
            }
        }
        if(root.right != null) {
//            Compare
            if(root.right.val > root.val) {
                if(parent != null) {
//                    if(root.right.val < parent.val) {
                        dfsBST(root, root.right);
//                    } else answer = false;
                }
            } else {
                answer = false;
            }
        }
    }
}
