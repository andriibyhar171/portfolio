package org.example;

import java.io.File;

public class Main {
    private static String fileLocation = "D:\\Files\\JAVA\\java-io-streams\\sec\\main\\resources\\test1.txt";

    public static void main(String[] args){

        System.out.println("Hello world");

        File file1 = new File(fileLocation);
        System.out.println("File 1 exist => " + file1.exists());
        System.out.println("File 1 is dictionary => " + file1.isDirectory());


        File file2 = new File("D:\\Files\\JAVA\\java-io-streams\\sec\\main\\resources\\test2.txt");
        System.out.println("File 2 exist => " + file2.exists());
        System.out.println("File 2 is dictionary => " + file2.isDirectory());

        File file3 = new File("D:\\Files\\JAVA\\java-io-streams\\sec\\main\\resources\\folder1\\innerFolder");
        System.out.println("File 3 exist => " + file3.exists());
        System.out.println("File 3 is dictionary => " + file3.isDirectory());

        if(!file3.exists()){
            file3.mkdirs();
        }
    }
}