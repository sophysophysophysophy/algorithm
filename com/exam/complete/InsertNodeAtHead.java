package exam.complete;

import exam.SinglyLinkedListNode;

public class InsertNodeAtHead {

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        node.next = llist;
        return node;
    }
}
