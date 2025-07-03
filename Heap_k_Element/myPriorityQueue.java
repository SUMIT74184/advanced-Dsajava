package Heap_k_Element;

import java.util.Collections;
import java.util.PriorityQueue;

class NewStudent implements Comparable<NewStudent>{
    int marks;
    String name;
    NewStudent(String name,int marks){
        this.name=name;
        this.marks=marks;

    }

    @Override
    public int compareTo(NewStudent that) {
        //return this.marks-that.marks; // increasing order---min to max
        if(that.marks==this.marks){
            this.name.compareTo(that.name);
        }
        return that.marks-this.marks; // decreasing order

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  NewStudent){
            NewStudent that=(NewStudent) obj;
            boolean isNameSame=(this.name.compareTo(that.name))==0;
            if(this.marks == that.marks & isNameSame){
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return "NewStudent{" +
                "marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }
}

public class myPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer>mpq=new PriorityQueue<>();
        mpq.offer(1);
        mpq.offer(2);
        mpq.offer(10);
        mpq.offer(23);
        System.out.println("highest priority->" + mpq.peek());


        PriorityQueue<Integer>maxpq=new PriorityQueue<>(Collections.reverseOrder());
        maxpq.offer(1);
        maxpq.offer(2);
        maxpq.offer(10);
        maxpq.offer(23);
        System.out.println("highest priority->" + maxpq.peek());
        maxpq.poll();
        System.out.println("after removing the element-> " + maxpq.peek());
        System.out.println("checkout the elements  "  +maxpq.contains(23));


        PriorityQueue<NewStudent>minStudent=new PriorityQueue<>();
//        NewStudent ns =new NewStudent("sumit",451);
        minStudent.offer(new NewStudent("aimit",451));
        minStudent.offer(new NewStudent("shubham",451));
        minStudent.offer(new NewStudent("aman",56));
        minStudent.offer(new NewStudent("sushil",89));
        System.out.println(minStudent.peek());
//        System.out.println(minStudent.contains(ns));



    }


}



