package exam.uploaded;

import exam.DoublyLinkedListNode;

//https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem

public class SortedInsert {
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if(head == null) {
            head.data = data;
            return head;
        }
        if(head.data > data) {
            DoublyLinkedListNode insertNode = new DoublyLinkedListNode(data);
            head.prev = insertNode;
            insertNode.next= head;

            return insertNode;
        }
        boolean flag = false;
        DoublyLinkedListNode nodeForLoop = head.next;

        while (nodeForLoop.next != null) {
            if (nodeForLoop.data > data) {
                DoublyLinkedListNode insertNode = new DoublyLinkedListNode(data);
                DoublyLinkedListNode prevNode = nodeForLoop.prev;
                prevNode.next = insertNode;
                insertNode.prev = prevNode;
                insertNode.next = nodeForLoop;
                nodeForLoop.prev = insertNode;
                flag = true;
                break;
            }

            nodeForLoop = nodeForLoop.next;
        }

        if(!flag) {
            if(nodeForLoop.data > data) {
                DoublyLinkedListNode insertNode = new DoublyLinkedListNode(data);
                DoublyLinkedListNode prevNode = nodeForLoop.prev;
                prevNode.next = insertNode;
                insertNode.prev = prevNode;
                insertNode.next = nodeForLoop;
                nodeForLoop.prev = insertNode;
            } else {
                DoublyLinkedListNode insertNode = new DoublyLinkedListNode(data);
                nodeForLoop.next = insertNode;
                insertNode.prev = nodeForLoop;
            }

        }

        return head;
    }
}
