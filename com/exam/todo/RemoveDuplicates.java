package exam.todo;


import exam.SinglyLinkedListNode;

//https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
public class RemoveDuplicates {
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode returnHead = head;
        int preValue = head.data;
        SinglyLinkedListNode preNode = head;
        int nowValue = 0;
        while (head.next != null) {
            nowValue = head.data;

            if (preValue == nowValue) {
                preNode.next = head.next;
            } else preValue = nowValue;

            head = head.next;
        }


        return returnHead;
    }
}
