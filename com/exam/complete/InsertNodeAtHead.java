package exam.complete;

//https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem

import exam.SinglyLinkedListNode;

public class InsertNodeAtHead {

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        node.next = llist;
        return node;
    }
}
