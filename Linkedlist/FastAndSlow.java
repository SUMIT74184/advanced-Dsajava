package Linkedlist;

class Node<T> {
    T data;
    @SuppressWarnings("rawtypes")
    Node next;

    Node() {
        this.next = null;

    }

    Node(T data) {
        this.next = null;
        this.data = data;
    }
}
// important pattern
public class FastAndSlow {

    Node<Integer> head;
    int size;

    FastAndSlow() {
        this.head = null;
        this.size = 0;
    }

    @SuppressWarnings("unused")
    public Node middleNode(Node head){
        Node fast=head;
        Node slow=head;

        //what if  there is only one node then 
        //that's why && operator

        while(fast.next==null && fast==null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

}
