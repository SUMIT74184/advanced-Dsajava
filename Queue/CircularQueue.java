package Queue;

public class CircularQueue {
    int front;
    int rear;
    int size;
    int capacity;
    int []circularQueue;

    public CircularQueue(int capacity){
        circularQueue=new int[capacity];
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

    public int peek(){
        if (isEmpty()){
            System.out.println("circular queue is empty");
            return -1;
        }
        return circularQueue[front];
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
        circularQueue[rear]=val;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("circular is empty cannot process the request");
            return -1;
        }
        int val=circularQueue[front];
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
                System.out.println(circularQueue[i]);
                System.out.println(",");
            }
            for (int i=front;i<=rear;i++){
                System.out.println(circularQueue[i]);
                if(i!=rear){
                    System.out.println(",");
                }
            }
        }else{
            for (int i=front;i<=rear;i++){
                System.out.println(circularQueue[i]);
                if(i!=rear){
                    System.out.println(",");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue myCircularQueue = new CircularQueue(5); // Fixed object name and added semicolon

        System.out.println("Capacity is: " + 5);

        System.out.println("Print:");
        myCircularQueue.printQueue();

        System.out.println("Insert element: 7");
        myCircularQueue.enqueue(7);
        System.out.println("Peek element: " + myCircularQueue.peek());

        System.out.println("Insert element: 8");
        myCircularQueue.enqueue(8);
        System.out.println("Peek element: " + myCircularQueue.peek());

        System.out.println("Insert element: 9");
        myCircularQueue.enqueue(9);
        System.out.println("Peek element: " + myCircularQueue.peek());

        System.out.println("Insert element: 11");
        myCircularQueue.enqueue(11);

        System.out.println("Insert element: 19");
        myCircularQueue.enqueue(19);

        System.out.println("Insert element: 9 (overflow test)");
        myCircularQueue.enqueue(9); // Should print "Queue is full" if implemented correctly

        System.out.println("Is CircularQueue full: " + myCircularQueue.isFull());

        System.out.println("Print:");
        myCircularQueue.printQueue();

        System.out.println("Delete element");
        myCircularQueue.dequeue();

        System.out.println("Is CircularQueue full: " + myCircularQueue.isFull());

        System.out.println("Print:");
        myCircularQueue.printQueue();

        System.out.println("Insert element: 19");
        myCircularQueue.enqueue(19);

        System.out.println("Print:");
        myCircularQueue.printQueue();

        System.out.println("Peek element: " + myCircularQueue.peek());

        System.out.println("Delete element");
        myCircularQueue.dequeue();

        System.out.println("Peek element: " + myCircularQueue.peek());

        System.out.println("Is CircularQueue empty: " + myCircularQueue.isEmpty());

        System.out.println("Print:");
        myCircularQueue.printQueue();

        System.out.println("Delete element");
        myCircularQueue.dequeue();
        System.out.println("Delete element");
        myCircularQueue.dequeue();
        System.out.println("Delete element");
        myCircularQueue.dequeue();
        System.out.println("Delete element");
        myCircularQueue.dequeue();

        System.out.println("Is CircularQueue empty: " + myCircularQueue.isEmpty());

        System.out.println("Print:");
        myCircularQueue.printQueue();

        System.out.println("Delete element");
        myCircularQueue.dequeue(); // Should print "Queue is already empty"
    }

}
