package Queue;

public class ImplementingQueue{
    int capacity;
    int rear;
    int size;
    int front;
    int []queue;

    public ImplementingQueue(int capacity){
        queue=new int[capacity];
        this.capacity=capacity;
        size=0;
        rear=front=-1;
    }

    public boolean isEmpty(){
        if (front==-1 || rear==-1){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(rear==capacity-1){
            return true;
        }
        return false;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }
        return queue[front];

    }

    public void enqueue(int val){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(isEmpty()){
            front=0;
            rear=0;
        } else{
            rear++;
        }
        size++;
        queue[rear]=val;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is already empty");
            return -1;
        }
        int val=queue[front];
        if(front==rear){
            front=-1;
            rear=-1;

        } else {
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
            System.out.println("Queue is Empty");
        }
        for(int i=front;i<=rear;i++){
            System.out.println(queue[i]);
            if(i!=rear){
                System.out.println(",");
            }

        }
        System.out.print("");
    }

    public static void main(String[] args) {
        ImplementingQueue myQueue = new ImplementingQueue(5);

        // Enqueue elements
        System.out.println("Enqueueing 10, 20, 30, 40, 50");
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);
        myQueue.enqueue(40);
        myQueue.enqueue(50);

        // Trying to enqueue in full queue
        myQueue.enqueue(60); // Should print "Queue is full"

        // Print queue
        System.out.println("Current Queue:");
        myQueue.printQueue();

        // Peek front element
        System.out.println("Peek: " + myQueue.peek());

        // Check if queue is full
        System.out.println("Is queue full? " + myQueue.isFull());

        // Dequeue two elements
        System.out.println("Dequeued: " + myQueue.dequeue());
        System.out.println("Dequeued: " + myQueue.dequeue());

        // Print queue after dequeue
        System.out.println("Queue after two dequeues:");
        myQueue.printQueue();

        // Enqueue more after removing
        System.out.println("Enqueueing 60, 70");
        myQueue.enqueue(60);
        myQueue.enqueue(70); // This should fail because the current implementation does not support circular queue

        // Final queue state
        System.out.println("Final Queue:");
        myQueue.printQueue();

        // Size of the queue
        System.out.println("Current size: " + myQueue.Size());

        // Check if empty
        System.out.println("Is queue empty? " + myQueue.isEmpty());
    }

}
