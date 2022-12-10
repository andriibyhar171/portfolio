package org.example.sync.example;

public class SyncExample {
    private static int counter;
    public static void main(String[] args){
        try{
            runJobs();
        } catch (InterruptedException e){e.printStackTrace();}
    }
    public static synchronized void incrementCounter(){
        counter++;
        System.out.println("Counter = " + counter);
        System.out.println("App finished");
    }
    public static void runJobs() throws InterruptedException{
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

class MyThread extends Thread{
    public void run(){
        for (int i =0; i <= 100000; i++){
            System.out.println(Thread.currentThread().getName()+ ": Tick: " + i);
            SyncExample.incrementCounter();
        }
    }
}