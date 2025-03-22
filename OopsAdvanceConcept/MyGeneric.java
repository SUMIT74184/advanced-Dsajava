package OopsAdvanceConcept;

public class MyGeneric {
  public static void main(String[] args) {
    IntegerDisplayer obj=new IntegerDisplayer();
    obj.setNum(23);
    obj.display();

    // Displayer<Integer>obj1=new Displayer<Integer>();
    // obj1.setNum(234);
    // obj1.display();


    Displayer<College>obj2=new Displayer<College>();
    obj2.setNum(new College());
    obj2.display();

  }
}
class IntegerDisplayer{
  Integer num;
  public void setNum(Integer num){
    this.num=num;
  }
  public void display(){
    System.out.println("element ->" + this.num);
  }
}

//now what if we want to change for the different variable in the problems

 class Displayer<T extends College>{//T is reference variable
  T num;
  public void setNum(T num){
    this.num=num;
  }
  public void display(){
    System.out.println("element ->" + this.num);
  }
}

class Student extends College{
  void printName(){
    System.out.println("name printed");
  }
}

class Teacher extends College{
  void printTeacherName(){
    System.out.println("Teacher name is printed");
  }
}

class College{
  void printCollegeName(){
    System.out.println("IIT BOMBAY ");
  }
}

