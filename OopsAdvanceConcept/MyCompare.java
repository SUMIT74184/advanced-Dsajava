package OopsAdvanceConcept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{
  int maxMarks;
  int rollNumber;
  Student(int maxMarks,int rollNumber){
    this.rollNumber=rollNumber;
    this.maxMarks=maxMarks;

  }

  @Override
  public String toString(){
    System.out.println("Marks :"+ this.maxMarks  +","+this.rollNumber);
    return super.toString();

  }
}

public class MyCompare {
  //how we can compare the object
   public static void main(String[] args) {
    // ArrayList<Integer>arr=new ArrayList<>();
    // arr.add(10);
    // arr.add(70);
    // arr.add(51);
    // arr.add(21);
    // arr.add(17);
    // arr.add(15);
    // MyCompare c1=new MyCompare();
    // c1.display(arr);

    Comparator<Student>cmp=new Comparator<Student>() {
      public int compare(Student o1,Student o2){
        int mark1=o1.maxMarks;
        int mark2=o2.maxMarks;
        if(mark1==mark2){
          return o1.rollNumber-o2.rollNumber;//check marks if same then print the rollno wise in increasing order
        }
        else{
          return o2.maxMarks-o1.maxMarks;//check the marks in the decreasing order
        }

      }
    };

    ArrayList<Student>arr=new ArrayList<>();
    arr.add(new Student(23, 34));
    arr.add(new Student(32, 54));
    arr.add(new Student(65, 43));
    arr.add(new Student(11, 21));
    arr.add(new Student(24, 17));
    arr.add(new Student(89, 8));
    MyCompare c1=new MyCompare();

    // Comparator<Integer>cmp=new Comparator<Integer>() {
    //   public int compare(Integer o1,Integer o2){
    //    // if 1 then swap
    //    //if 0 or -1 then don't swap 
    //    int u1=o1%10;
    //    int u2=o2%10;
    //    if(u1==u2){
    //     return o1-o2;// for the increasing order
    //    }
    //    return u1-u2;
    //   //  if(u1<u2){
    //   //   return -1;
    //   //  }else if(u1>u2){
    //   //   return 1;
    //   //  }else{
    //   //   //both are same
    //   //   if(o1<o2){
    //   //     return -1;
    //   //    }else if(o1>o2){
    //   //     return 1;
    //   //    }
    //   //  }
    //     // return 0;
    //   }
    
   Collections.sort(arr,cmp);
   c1.display(arr);
  
  }
  public <T> void display(ArrayList<T> list){
    for(int i=0;i<list.size();i++){
      System.out.print(list.get(i));
      if(i!=list.size()-1){
        System.out.print(",");
      }
    }
    System.out.println();
  }
}

  //what if we have to sort on the basis of unit digit and
  //if unit digit is same then print the smaller number first
  

