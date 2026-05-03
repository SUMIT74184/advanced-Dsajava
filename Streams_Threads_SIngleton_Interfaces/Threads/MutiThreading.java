package Streams_Threads_SIngleton_Interfaces.Threads;


class Ta1 implements Runnable{
    private String name;

    Ta1(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i =0;i<=3;i++){
            System.out.println(name+ " - " + i);
        }
    }
}

public class MutiThreading {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Ta1("Thread-1"));
        Thread t2 = new Thread(new Ta1("Thread-2"));


        t1.start();;
        t2.start();

    }
}
