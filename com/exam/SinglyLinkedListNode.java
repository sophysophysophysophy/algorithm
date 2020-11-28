package exam;

public class SinglyLinkedListNode {
     public int data;
     public SinglyLinkedListNode next;


    public SinglyLinkedListNode() {
    }

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }
}

