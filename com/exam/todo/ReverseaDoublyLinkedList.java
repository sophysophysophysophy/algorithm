package exam.todo;
//https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem

import exam.DoublyLinkedListNode;

public class ReverseaDoublyLinkedList {
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

        head = head.next;
        while (head.next != null) {

            DoublyLinkedListNode temp = head.next;
            head.prev = head.next;
            head.next = temp;
        }

        return head;
    }

}
