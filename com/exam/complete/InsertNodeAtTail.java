package exam.complete;

import exam.SinglyLinkedListNode;
//https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem

public class InsertNodeAtTail {

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode nowLinkedList = new SinglyLinkedListNode(data);
        if(head == null) head = nowLinkedList;
        else {
            SinglyLinkedListNode tail = head;
            while (tail.next != null) tail = tail.next;
            tail.next = nowLinkedList;
        }
        return head;

    }
}
