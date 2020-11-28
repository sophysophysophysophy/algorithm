package exam.todo;


import exam.SinglyLinkedListNode;

//https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
public class RemoveDuplicates {
    public static void main(String[] args) {
        SinglyLinkedListNode node4 = new SinglyLinkedListNode(4, null);
        SinglyLinkedListNode node6 = new SinglyLinkedListNode(4, node4);
        SinglyLinkedListNode node3 = new SinglyLinkedListNode(3, node6);
        SinglyLinkedListNode node2 = new SinglyLinkedListNode(2, node3);
        SinglyLinkedListNode node7 = new SinglyLinkedListNode(2, node2);
        SinglyLinkedListNode node5 = new SinglyLinkedListNode(2, node7);
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(2, node5);
        removeDuplicates(node1);
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {

        if(head.next == null) return head;
        SinglyLinkedListNode prevNode = head;
        SinglyLinkedListNode startNode = head.next;

        while (startNode.next != null) {
            if (startNode.data != prevNode.data) {
                prevNode.next = startNode;
                prevNode = startNode;
            }
            startNode = startNode.next;
        }

        if (startNode.data == prevNode.data) prevNode.next = null;


        return head;
    }
}
