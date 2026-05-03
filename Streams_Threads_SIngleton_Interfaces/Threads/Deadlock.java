package Streams_Threads_SIngleton_Interfaces.Threads;



public class Deadlock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

  void method1(){
        synchronized (lock1){
            synchronized (lock2){
                System.out.println("Method1");
            }
        }
    }

    void Method2(){
        synchronized (lock2){
            synchronized (lock1){
                System.out.println("Method2");
            }
        }
    }


    public static void main(String[] args) {

    }
}
