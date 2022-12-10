package org.example.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("App is started");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i<5; i++){
            PingRunner pingRunner = new PingRunner();
            pingRunner.setTaskId(i);
            executorService.submit(pingRunner);

            Thread.sleep(2000);
        }
        System.out.println("App is finished");
    }
}
class PingRunner implements Runnable{
    private Integer taskId;
    public void setTaskId(Integer taskId){
        this.taskId = taskId;
    }
    @Override
    public void run(){
        for (int i=0; i<5;i++){
            System.out.println(Thread.currentThread().getName() + "| Worker-" + (taskId+1) + " | tick" + (i+1));
        }
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
