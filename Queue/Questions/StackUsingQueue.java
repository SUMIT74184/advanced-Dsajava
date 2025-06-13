package Queue.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer>q1=new LinkedList<>();
    Queue<Integer>q2=new LinkedList<>();

    public void push(int val){
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        q1.offer(val);
     //pushing inside the q1 again from q2
     while(!q2.isEmpty()){
         q1.offer(q2.poll());
     }

    }
    public int peek(){
        if(q1.isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        return q1.peek();

    }

    public int pop(){
        if(q1.isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        return q1.poll();
    }


    public static void main(String[] args) {
        StackUsingQueue s1=new StackUsingQueue();
        s1.push(10);
        s1.peek();
        System.out.println( s1.peek());
        s1.push(20);
        s1.push(30);
        s1.push(40);
        System.out.println(s1.peek());
        System.out.println(s1.pop());
        System.out.println(s1.peek());

    }
}
