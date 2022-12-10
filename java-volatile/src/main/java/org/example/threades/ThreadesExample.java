package org.example.threades;

public class ThreadesExample {
    public static  void main(String[] args){
        for (int i=0; i<10;i++){
            Printer printer = new Printer();
            printer.start();
            try{
                if (i==0) {
                    printer.join();
                }
            }
            catch (InterruptedException e){
                throw new RuntimeException();
            }
        }
    }
}
class Printer extends Thread{
    @Override
    public void run(){
        System.out.println("Hello from" + getName());
    }
}
class TextPrinter implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from" + Thread.currentThread().getName());
    }
}
