package Linkedlist;

class Node1<T> {
    T data;
    Node1<T> next;          // use a typed next

    Node1() {
        this.next = null;
    }

    Node1(T data) {
        this.data = data;
        this.next = null;
    }
}

public class FastAndSlow {
    Node1<Integer> head;
    int size;

    FastAndSlow() {
        this.head = null;
        this.size = 0;
    }

    // returns the middle node (if even length -> returns second middle)
    public Node1<Integer> middleNode(Node1<Integer> head) {
        if (head == null) return null;

        Node1<Integer> slow = head;
        Node1<Integer> fast = head;

        // correct condition: check fast != null first, then fast.next != null
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // helper to append tail (for testing)  ....Inshort inserting in linked-list
    public void append(int val) {
        Node1<Integer> node = new Node1<>(val);
        if (head == null) {
            head = node;
        } else {
            Node1<Integer> t = head;
            while (t.next != null) t = t.next;
            t.next = node;
        }
        size++;
    }

    // test driver
    public static void main(String[] args) {
        FastAndSlow list = new FastAndSlow();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5); // odd length: 1,2,3,4,5

        Node1<Integer> mid = list.middleNode(list.head);
        System.out.println("Middle of 1..5 is: " + (mid != null ? mid.data : "null")); // 3

        FastAndSlow list2 = new FastAndSlow();
        list2.append(1);
        list2.append(2);
        list2.append(3);
        list2.append(4); // even length: 1,2,3,4

        Node1<Integer> mid2 = list2.middleNode(list2.head);
        System.out.println("Middle of 1..4 is (second middle): " + (mid2 != null ? mid2.data : "null")); // 3
    }
}
