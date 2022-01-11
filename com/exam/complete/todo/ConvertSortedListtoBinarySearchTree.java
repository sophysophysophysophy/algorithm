package exam.complete.todo;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

import exam.ListNode;
import exam.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {
    public static void main(String[] args) {

    }

    public TreeNode sortedListToBST(ListNode head) {

        if(head == null) return null;

//        1. Make a array
        List<Integer> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        if(list.size() == 1) return new TreeNode(list.get(0));


        boolean[] visit = new boolean[list.size()];
        TreeNode root = new TreeNode(list.get(list.size() / 2));
        visit[list.size() / 2] = true;

//        sortedListToBST(list, root, )
        return new TreeNode();
    }


}
