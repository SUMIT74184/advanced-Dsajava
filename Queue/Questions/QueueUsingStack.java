package Queue.Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer>s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    public void enqueue(int val){
        //move all elements from stack 1 to stack 2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
      //insert value in s1
       s1.push(val);

        //move all elements from s2. to s1
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int dequeue(){
        if(s1.isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());

        }
        int val=s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return val;
    }

    public int peek(){
        if(s1.isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());

        }
        int val=s2.peek();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return val;
    }



    public static void main(String[] args) {

//        Queue<Integer>q1=new LinkedList<>();
        QueueUsingStack q1=new QueueUsingStack();
        q1.enqueue(12);
        q1.enqueue(13);
        q1.enqueue(14);
        System.out.println("peek is " + q1.peek());
        q1.dequeue();
        System.out.println("After deletion "+q1.peek());



    }
}
