package exam.complete;
//https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem

import exam.SinglyLinkedListNode;

public class DeleteNode {
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if(position == 0) return head.next;
        SinglyLinkedListNode positionNode = head;
        for(int i = 0 ; i < position - 1 ; i++) positionNode = positionNode.next;
        positionNode.next = positionNode.next.next;
        return head;

    }
}
