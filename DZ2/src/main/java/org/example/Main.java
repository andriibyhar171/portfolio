package org.example;
import java.util.Random;
import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

class Thread1 extends Thread{
    Thread1(String th1){
        super(th1);}
    Random rand = new Random();
    int[] thredarr = new int[5];

    public synchronized void run(){
        System.out.println("Thread1 started...");
        for (int i = 0; i < thredarr.length; i++) {
            thredarr[i] = rand.nextInt();
            System.out.println("Massive:" + thredarr[i]);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Thread2 extends Thread{
    Thread2(String th2){
        super(th2);}

    public synchronized void run(){
        System.out.println("Thread2 started...");
        Random rund = new Random();
        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rund.nextInt();
            sum = sum + arr[i];
        }
        System.out.println("Sum of threads: " + sum);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Thread3 extends Thread{
    Thread3(String th3){
        super(th3);}

    public synchronized void run(){
        System.out.println("Thread3 started...");
        Random ren = new Random();
        int[] arr3 = new int[5];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = ren.nextInt();
            IntStream.of(arr3[i]).average();
            for (int j =0; j < 1; j++){
                System.out.println("Average of massive: " + arr3[j]);
            }

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Threads:");
        new Thread1("Thread1").start();
        new Thread2("Thread2").start();
        new Thread3("Thread3").start();

    }
}