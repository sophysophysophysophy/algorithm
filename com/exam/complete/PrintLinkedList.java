package exam.complete;

import exam.SinglyLinkedListNode;

//https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
public class PrintLinkedList {
    static void printLinkedList(SinglyLinkedListNode head) {
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
