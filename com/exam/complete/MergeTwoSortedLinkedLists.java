package exam.complete;

//https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem

import exam.SinglyLinkedListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedLinkedLists {
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        List<Integer> list = new ArrayList<>();

        while (head1 != null) {
            list.add(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            list.add(head2.data);
            head2 = head2.next;
        }
        Collections.sort(list);

        SinglyLinkedListNode returnNode = new SinglyLinkedListNode(list.get(0));
        SinglyLinkedListNode nodeForLoop = returnNode;
        for (int i = 1; i < list.size(); i++) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(list.get(i));
            nodeForLoop.next = node;
            nodeForLoop = nodeForLoop.next;
        }


        return returnNode;
    }

}
