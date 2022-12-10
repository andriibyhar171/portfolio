package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class Thread1 extends Thread{
    Thread1 (String th1){
        super(th1);
    }
    public synchronized void run(){
        try
        {
            File dir1 = new File ("D:\\Text1.txt");
            FileWriter writer = new FileWriter(dir1, false);
            int[] number = new int[10];
            Random rand = new Random ();
            System.out.println ( "Random numbers generated" );
            for (int i = 0; i < number.length; i++){
                number[i] = rand.nextInt ();
                writer.write(Integer.toString (number[i]) + "\n");
                System.out.println ("\nRandNum: " + number[i]);
                writer.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

class  Thread2 extends Thread{
    Thread2 (String th2){
        super(th2);
    }
    public synchronized void run(){
        try {
            File myObj = new File("D:\\Text1.txt");
            Scanner myReader = new Scanner(myObj);
            System.out.println ("Prime numbers generated");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int idata = Integer.parseInt (data);
                if(idata % 2 == 0) {  
                    try {
                        File newobj = new File("D:\\Text2.txt");
                        FileWriter wri = new FileWriter(newobj, false);
                        wri.write (Integer.toString (idata));
                        System.out.println ("\nPrimeNum: " + idata);
                        wri.flush();
                    } catch (IOException e) {
                        throw new RuntimeException (e);
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

class Thread3 extends Thread{
    Thread3 (String th3){
        super(th3);
    }
    public synchronized void run() {

        try {
            File myObj = new File("D:\\Text1.txt");
            Scanner myReader = new Scanner(myObj);
            System.out.println ("Factorial numbers generated");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int idatae =Integer.parseInt(data);
                int n =1;
                for(int i = 1; i <=n; i++){
                    try{
                        File newobjs = new File("D:\\Text3.txt");
                        FileWriter  wris = new FileWriter (newobjs, false);
                        idatae *= i;
                        wris.write (Integer.toString (idatae));
                        System.out.println ("\nFactorialNum: " + idatae);
                        wris.flush();
                    } catch (IOException e) {
                        throw new RuntimeException (e);
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        new Thread1 ("Thread1").start ();
        new Thread2 ("Thread2").start ();
        new Thread3 ("Thread3").start ();
    }
}
