package exam.complete;


//https://www.hackerrank.com/challenges/compare-two-linked-lists/problem

import exam.SinglyLinkedListNode;

public class CompareTwoLinkedLists {
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1.data != head2.data) return false;
        if(head1.next == null && head2.next == null) return true;
        if(head1.next == null || head2.next == null) return false;

        return compareLists(head1.next, head2.next);
    }
}
