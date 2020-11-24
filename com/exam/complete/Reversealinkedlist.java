package exam.complete;

import exam.SinglyLinkedListNode;

//https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
public class Reversealinkedlist {
    public static void main(String[] args) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(1);
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(2, node);
        SinglyLinkedListNode node2 = new SinglyLinkedListNode(3, node);

        reverse(node);
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {

        if(head.next == null) return head;
        SinglyLinkedListNode preNode = head;
        SinglyLinkedListNode headNode = head.next;
        SinglyLinkedListNode postNode= headNode.next;

        while (postNode != null) {
            headNode.next = preNode;
            preNode = headNode;
            headNode = postNode;
            postNode = headNode.next;
        }
        head.next = null;
        headNode.next = preNode;



        return headNode;
    }
}
