package exam.uploaded;


import exam.SinglyLinkedListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
//TODO UPLOAD
//https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
public class RemoveDuplicates {
    public static void main(String[] args) {
        SinglyLinkedListNode node4 = new SinglyLinkedListNode(4, null);
        SinglyLinkedListNode node6 = new SinglyLinkedListNode(4, node4);
        SinglyLinkedListNode node3 = new SinglyLinkedListNode(3, node6);
        SinglyLinkedListNode node2 = new SinglyLinkedListNode(2, node3);
        SinglyLinkedListNode node7 = new SinglyLinkedListNode(3, node2);
        SinglyLinkedListNode node5 = new SinglyLinkedListNode(2, node7);
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(2, node5);
        removeDuplicates(node1);
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            set.add(head.data);
            head = head.next;
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        SinglyLinkedListNode startNode = new SinglyLinkedListNode(list.get(0));
        SinglyLinkedListNode loopNode = startNode;
        for (int i : list) {
            SinglyLinkedListNode nowNode = new SinglyLinkedListNode(list.get(i));
            loopNode.next = nowNode;
            loopNode = nowNode;

        }

        return startNode;
    }
}
