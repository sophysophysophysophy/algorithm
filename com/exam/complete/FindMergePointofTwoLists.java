package exam.complete;

//https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem


import exam.SinglyLinkedListNode;

public class FindMergePointofTwoLists {
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
//        Find the duplicate node
//        nested loop
        SinglyLinkedListNode head2NodeForLoop;
        while (head1 != null) {
            head2NodeForLoop = head2;
            while (head2NodeForLoop != null) {
                if (head1 == head2NodeForLoop) {
                    return head1.data;
                }
                head2NodeForLoop = head2NodeForLoop.next;
            }

            head1 = head1.next;
        }
        return 0;
    }
}
