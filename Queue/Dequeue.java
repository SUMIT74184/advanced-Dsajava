package Queue;

public class Dequeue {

    int front;
    int rear;
    int size;
    int capacity;
    int []Dequeue;

    public Dequeue(int capacity){
        Dequeue=new int[capacity];
        this.capacity=capacity;
        size=0;
        rear=front=-1;
    }

    public boolean isEmpty(){
        if(front==-1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if((front==0 && rear==capacity-1) || (front!=0 && rear==(front-1)%(capacity))){
            return true;
        }
        return false;
    }

    public int peekFront(){
        if (isEmpty()){
            System.out.println("circular queue is empty");
            return -1;
        }
        return Dequeue[front];
    }

    public int peekRear(){
        if (isEmpty()){
            System.out.println("circular queue is empty");
            return -1;
        }
        return Dequeue[rear];
    }


    public void enqueue(int val){
        if(isFull()){
            System.out.println("circular queue is full");
            return;
        }
        if(isEmpty()){
            front=0;
            rear=0;

        } else if (rear==capacity-1 && front!=0) {//circular insertion
            rear=0;
        } else{
            rear++;
        }
        size++;
        Dequeue[rear]=val;
    }

    public void enqueueFront(int val){
        if(isFull()){
            System.out.println("DequeueFront is full");
            return;
        }
        if(isEmpty()){
            front=0;
            rear=0;
        } else if (front==0 && rear!=capacity-1) {
            front=capacity-1;
        }else{
          front--;
        }
        size++;
        Dequeue[front]=val;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("circular is empty cannot process the request");
            return -1;
        }
        int val=Dequeue[front];
        if(front==rear){
            front=-1;
            rear=-1;
        } else if (front==capacity-1) {//circular deletion
            front=0;
        }else{
            front++;
        }
        size--;
        return val;

    }

    public int dequeuerear(){
        if(isEmpty()){
            System.out.println("circular is empty cannot process the request");
            return -1;
        }
        int val=Dequeue[rear];
        if(front==rear){
            front=-1;
            rear=-1;
        } else if (rear==0) {//circular deletion
            rear=capacity-1;
        }else{
            rear--;
        }
        size--;
        return val;

    }


    public int Size(){
        return size;
    }


    public void printQueue(){
        if(isEmpty()){
            System.out.println("circular queue is Empty");
            return;
        }
        if(rear<=front){
            for(int i=front;i<capacity-1;i++){
                System.out.println(Dequeue[i]);
                System.out.println(",");
            }
            for (int i=front;i<=rear;i++){
                System.out.println(Dequeue[i]);
                if(i!=rear){
                    System.out.println(",");
                }
            }
        }else{
            for (int i=front;i<=rear;i++){
                System.out.println(Dequeue[i]);
                if(i!=rear){
                    System.out.println(",");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
      // Fixed object name and added semicolon

            Dequeue myDeque = new Dequeue(5); // Correct object reference

            System.out.println("Capacity is: " + 5);

            System.out.println("Print:");
            myDeque.printQueue();

            System.out.println("Insert element Front: 7");
            myDeque.enqueueFront(7);

            System.out.println("Peek Front element: " + myDeque.peekFront());

            System.out.println("Insert element Rear: 8");
            myDeque.enqueue(8); // Rear insertion uses enqueue()

            System.out.println("Peek Rear element: " + myDeque.peekRear());

            System.out.println("Insert element Front: 9");
            myDeque.enqueueFront(9);

            System.out.println("Peek Front element: " + myDeque.peekFront());

            System.out.println("Insert element Rear: 11");
            myDeque.enqueue(11);

            System.out.println("Insert element Front: 19");
            myDeque.enqueueFront(19);

            System.out.println("Insert element Rear: 9");
            myDeque.enqueue(9); // Should say queue is full

            System.out.println("Is deque full: " + myDeque.isFull());

            System.out.println("Print:");
            myDeque.printQueue();

            System.out.println("Delete element Front");
            myDeque.dequeue(); // Front deletion uses dequeue()

            System.out.println("Is deque full: " + myDeque.isFull());

            System.out.println("Print:");
            myDeque.printQueue();

            System.out.println("Insert element Rear: 19");
            myDeque.enqueue(19);

            System.out.println("Print:");
            myDeque.printQueue();

            System.out.println("Peek element Rear: " + myDeque.peekRear());

            System.out.println("Delete Front element");
            myDeque.dequeue();

            System.out.println("Peek element Rear: " + myDeque.peekRear());

            System.out.println("Is deque empty: " + myDeque.isEmpty());

            System.out.println("Print:");
            myDeque.printQueue();

            System.out.println("Delete Rear element");
            myDeque.dequeuerear();

            System.out.println("Delete Rear element");
            myDeque.dequeuerear();

            System.out.println("Delete Rear element");
            myDeque.dequeuerear();

            System.out.println("Delete Rear element");
            myDeque.dequeuerear();

            System.out.println("Is deque empty: " + myDeque.isEmpty());

            System.out.println("Print:");
            myDeque.printQueue();

            System.out.println("Delete Front element");
            myDeque.dequeue();
        }

}
