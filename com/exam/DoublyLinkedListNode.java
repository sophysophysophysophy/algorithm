package exam;

public class DoublyLinkedListNode {
     public int data;
     public DoublyLinkedListNode next;
     public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data, DoublyLinkedListNode next, DoublyLinkedListNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DoublyLinkedListNode(DoublyLinkedListNode prev) {
         this.next= prev;
    }

    public DoublyLinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }

    public DoublyLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedListNode prev) {
        this.prev = prev;
    }
}
