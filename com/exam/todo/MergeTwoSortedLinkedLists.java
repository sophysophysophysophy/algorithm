package exam.todo;

//https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem

import exam.SinglyLinkedListNode;

public class MergeTwoSortedLinkedLists {
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode returnNode = new SinglyLinkedListNode(head1.data);

        mergeListsDFS(returnNode, head1);

        return returnNode;
    }

    private static void mergeListsDFS(SinglyLinkedListNode returnNode, SinglyLinkedListNode head) {
        if(head == null) return;

        mergeListsDFS(returnNode, head.next);
    }
}
