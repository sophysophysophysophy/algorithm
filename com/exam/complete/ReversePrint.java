package exam.complete;

import exam.SinglyLinkedListNode;

import java.util.ArrayList;
import java.util.List;
//https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem

public class ReversePrint {
    static void reversePrint(SinglyLinkedListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.data);
            head = head.next;
        }
        for(int i = list.size() -1 ; i >= 0 ; i--) System.out.println(list.get(i));
    }
}
