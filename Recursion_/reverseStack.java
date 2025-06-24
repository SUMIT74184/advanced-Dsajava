package Recursion_;

import java.util.Arrays;
import java.util.Stack;

public class reverseStack {

  public static void reverse(Stack<Integer>s){
        //LOF
        if(s.size()==0){
            return;
        }
        int ele=s.pop();
        reverse(s);
        insertAtBottom(s,ele); //(s,6)
    }
    //this is for inserting the top element in bottom
  public static void insertAtBottom(Stack<Integer>s,int ele){
        if(s.isEmpty()){
            s.push(ele);
            return;
        }
        int newEle=s.pop();
        insertAtBottom(s,ele);
        s.push(newEle);
    }

    public static void main(String[] args) {
        Stack<Integer>s= new Stack<>();
        s.push(4);
        s.push(5);
        s.push(6);
        reverse(s);

    }
}
