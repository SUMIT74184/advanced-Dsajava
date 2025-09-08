package Linkedlist;
class DoublyNode<T>{
    T data;
    DoublyNode next;
    DoublyNode prev;

    DoublyNode(){
        this.next=null;
        this.prev=null;
    }
    DoublyNode(T data){
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}

public class doublylinkedlist {
    DoublyNode<Integer> head;
    DoublyNode<Integer> tail;
    int size;

    doublylinkedlist(){
        this.tail=null;
        this.head=null;
        this.size=0;
    }

    public void insertHead(int data){
        DoublyNode<Integer>newNode=new DoublyNode<>(data);
        if(head==null){
          head=newNode;
          tail=newNode;
            System.out.println("Insertion at head is successful");
            size++;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        System.out.println("Insertion at head is successful");
        size++;

    }

    @SuppressWarnings("unchecked")
    public void insertTail(int data){
        DoublyNode<Integer>newNode=new DoublyNode<>(data);

        if(head==null){
            head=newNode;
            tail=newNode;
            System.out.println("insertion at tail is successful");
            size++;
            return;

        }
        DoublyNode<Integer>temp=head;
        while(temp!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.prev=temp;
        tail=newNode;
        System.out.println("insertion at tail is successful");
        size++;

    }

    public void insertAtPosition(int data,int position){
        if(position>size+1 || position<=0){
            System.out.println("Wrong input");
            return;
        }
        if(position==1){
            insertHead(data);
        }
        else if(position==size+1){
            insertTail(data);
        }else {
            int counter=1;
            DoublyNode<Integer>temp=head;
            DoublyNode<Integer>newNode=new DoublyNode<>(data);

            DoublyNode<Integer>successor=temp.next;

            while(counter<position-1 && temp!=null){
                counter++;
                temp=temp.next;
            }
            newNode.next=successor;
            successor.prev=newNode;
            temp.next=newNode;
            newNode.prev=temp;

         //            temp.next.prev=newNode;
            size++;
        }
        System.out.println("Insert at any position is successful at " + position);
    }


    //deletion for the doubly linked list

    public void DeleteHead(){
    if(head==null){
        System.out.println("Linked list is empty");
        return;
    }
    DoublyNode<Integer> temp=head;
    head=head.next;
    temp.next=null;
    if(head==null){
        tail=null;
    }else{
        head.prev=null;

    }
    System.out.println("Deletion at head is successful");
    size--;
    }

    public void DeleteTail(){
        if(head==null){
            System.out.println("Linked list is empty");
            return;
        }
        if(head.next==null){
            head=null;
            tail=null;
            size--;
            System.out.println("Deletion at tail is successful");
            return;
        }
        DoublyNode<Integer>temp=head;
        DoublyNode<Integer>prevNode=null;

        while(temp.next!=null){
            prevNode=temp;
            temp=temp.next;
        }
        prevNode.next=null;
        temp.prev=null;
        tail=prevNode;
        System.out.println("Deletion at tail is successful");
        size--;


    }

    public void DeleteAtPosition(int position){
        if (position > size || position <= 0) {
            System.out.println("wrong input");
        }
        if (position == 1) {
            DeleteHead();
        } else if (position == size) {// last postion of the linkedlist
            DeleteTail();
        } else {
            int counter = 1;
            DoublyNode<Integer> prevNode = null;
            DoublyNode<Integer> temp = head;
            while (counter < position && temp != null) {
                counter++;
                prevNode = temp;
                temp = temp.next;
            }
            DoublyNode<Integer>nextNode=temp.next;
            prevNode.next=nextNode;
            nextNode.prev=prevNode;
            temp.prev=null;
            temp.next = null;
            size--;
            System.out.println("Deletion successfull at the position " + position);

        }
    }






    public void printList(){
        DoublyNode<Integer>temp=head;
        while(temp!=null){
            System.out.println("data is ->" +temp.data);
            temp=temp.next;
        }
    }


    public void printListInReverse(){
        DoublyNode<Integer>temp=tail;
        while(temp!=null){
            System.out.println("data is ->" +temp.data);
            temp=temp.prev;
        }
    }


    public static void main(String[] args) {
        
    }
    
}
