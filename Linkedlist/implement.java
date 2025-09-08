package Linkedlist;
  class Node<T> {
        T data;
        Node next;

        Node() {
            this.next = null;

        }

        Node(T data) {
            this.next = null;
            this.data = data;

        }
    }

public class implement {
    Node<Integer> head;
    int size;

    implement() {
        this.head = null;
        this.size = 0;
    }

  

    public void insertNode(int data, int pos) {
        if (pos > size + 1 || pos <= 0) {
            System.out.println("Wrong input");
            return;
        }
        // head
        if (pos == 1) {
            insertHead(data);
            return;
        } else if (pos == size + 1) {
            insertTail(data);
            return;
        } else {
            int counter = 1;
            Node<Integer> newNode = new Node<>(data);
            Node<Integer> temp = head;

            while (counter < pos - 1 && temp != null) {
                counter++;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
            System.out.println("Insertion successful at pos " + pos);
        }

    }

    public void printList() {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.println("data  is -> " + temp.data);
            temp = temp.next;

        }
    }

    public void insertHead(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        System.out.println("Insertion at head is successfull");
        size++;
    }

    public void insertTail(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        Node<Integer> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Insertion at tail is successfull");
        size++;
    }

    // deletion of the linkedlist
    public void deleteHead() {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node<Integer> temp = head;
        head = head.next;
        temp.next = null;
        System.out.println("Deletion at head is successfull");
        size--;
    }

    public void deleteTail() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            System.out.println("Deletion at head is successfull");
            return;
        }
        Node<Integer> temp = head;
        Node<Integer> prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        System.out.println("deletion at tail is successfull");
        size--;

    }

    public void deletionNode(int position) {
        if (position > size || position <= 0) {
            System.out.println("wrong input");
        }
        if (position == 1) {
            deleteHead();
        } else if (position == size) {// last postion of the linkedlist
            deleteTail();
        } else {
            int counter = 1;
            Node<Integer> prev = null;
            Node<Integer> temp = head;
            while (counter < position && temp != null) {
                counter++;
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            temp.next = null;
            size--;
            System.out.println("Deletion successfull at the position " + position);

        }
    }


    // updation in linkedlist
    public void updateNode(int pos,int updatevalue){
        if(head==null){
            System.out.println("Linked list is empty");
            return;
        }
        int counter=1;
        Node<Integer>temp=head;
        while(counter<pos && temp!=null){
            counter++;
            temp=temp.next;
        }
        if(temp!=null && counter==pos){
            temp.data=updatevalue;
        }else{
            System.out.println("Size of linked list is smaller than position "+pos);
            return;
        }
        System.out.println("update at position " + pos + "was successful");
    }

    public static void main(String[] args) {
        implement obj = new implement();
        obj.insertTail(10);
        obj.printList();
        obj.insertHead(23);
        obj.printList();
        obj.insertNode(211, 3);
        obj.printList();
    }

}