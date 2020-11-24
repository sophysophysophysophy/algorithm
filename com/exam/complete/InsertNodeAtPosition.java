package exam.complete;
//https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem

import exam.SinglyLinkedListNode;

public class InsertNodeAtPosition {
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode returnHead = head;
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        for (int i = 0; i < position - 1; i++) head = head.next;
        node.next = head.next;
        head.next = node;
        return returnHead;
    }
}
