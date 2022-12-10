package org.example;

public class Main {
    private static  int counter;
    public static void main(String[] args){
        WriteThread writeThread = new WriteThread();
        ReaderThread readerThread = new ReaderThread();

        writeThread.start();
        readerThread.start();
    }

    static class WriteThread extends Thread{
        public void run(){
            while(counter<5){
                System.out.println("Increment couunter to" + (++counter));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ReaderThread extends Thread{
        public void run(){
            int localCounter = counter;
            while (localCounter< 5){
                if (localCounter != counter){
                    System.out.println("New value of counter = "+counter);
                    localCounter = counter;
                }
            }
        }
    }

}