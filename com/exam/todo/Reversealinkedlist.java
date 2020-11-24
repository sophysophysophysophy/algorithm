package exam.todo;

import exam.SinglyLinkedListNode;

//https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
public class Reversealinkedlist {

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode preNode = head;
        SinglyLinkedListNode postNode = head.next;
        while(head.next != null) {
            head = head.next;
            postNode.next = preNode;
            preNode = postNode;
            postNode = head;

        }
        return head;
    }
}
