package exam.complete;
//https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem

import exam.DoublyLinkedListNode;

public class ReverseADoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedListNode node4 = new DoublyLinkedListNode(4, null, null);
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(3, node4, null);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(2, node3, null);
        DoublyLinkedListNode node1 = new DoublyLinkedListNode(1, node2, null);
        node2.prev = node1;
        node3.prev = node2;
        node4.prev = node3;

        DoublyLinkedListNode node = reverse(node1);
        System.out.println(node.data);
    }
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode nextNode = head.next;
        while (head.next != null) {
            DoublyLinkedListNode temp = head.prev;
            head.prev = head.next;
            head.next = temp;
            head = nextNode;
            nextNode = nextNode.next;
        }

        DoublyLinkedListNode temp  = head.prev;
        head.prev = null;
        head.next = temp;
        return head;
    }

}
