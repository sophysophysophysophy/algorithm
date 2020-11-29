package exam.complete;

//https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem

import exam.SinglyLinkedListNode;

import java.util.ArrayList;
import java.util.List;

public class GetNodeValue {

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.data);
            head = head.next;
        }

        return list.get(list.size() - positionFromTail - 1);
    }
}
