package Streams_Threads_SIngleton_Interfaces;

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread running using thread classes");
    }
}

class MyRunnable implements Runnable{
    private String name;

    MyRunnable(String name){
        this.name = name;
    }


    @Override
    public void run(){
        for(int i=0;i<=3;i++){
            System.out.println("Thread running using Runnable" +name+ " "+  i);
        }

    }
}

public class Jvm {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

//        MyRunnable t2 = new MyRunnable();
//        Thread t3 = new Thread(t2);
//        t3.start();

        Thread t2 = new Thread(new MyRunnable("starts"));
        t2.start();
    }
}
