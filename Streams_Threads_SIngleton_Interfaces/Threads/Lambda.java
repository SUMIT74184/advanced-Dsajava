package Streams_Threads_SIngleton_Interfaces.Threads;

public class Lambda {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("Running using lambda");
        });

        t1.start();



        Thread t2 = new Thread(()->{
            for (int i =1;i<=3;i++){
                System.out.println(i);
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        });

        t2.start();
        t2.join(); // main waits for t1

        System.out.println("Main thread ends");
    }
}
