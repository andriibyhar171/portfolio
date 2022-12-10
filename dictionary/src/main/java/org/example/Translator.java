package org.example;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Translator {

    public static void add() {
        try {

            File dir1 = new File ( "D:\\Text.txt" );
            FileWriter writer = new FileWriter ( dir1, true );
            Scanner scanner = new Scanner ( System.in );
            System.out.println("Add your word: ");
            String text = scanner.nextLine ();
            writer.write ( text );
            writer.append('\n');
            writer.flush ( );
            System.out.println ( "Word added" );
        } catch (IOException ignored) {

        }
    }
    public static void print () {
        File dir1 = new File ( "D:\\Text.txt" );
        if(dir1.length ()==0){
            System.out.println ( "File is empty." );
        }
        else {
            try
            {
                System.out.println("All word in dictionary:");
                FileReader reader = new FileReader(dir1);
                int c;
                while((c=reader.read())!=-1){

                    System.out.print((char)c);
                }
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
    }

    public static void delete(){
        File dir1 = new File ( "D:\\Text.txt" );
        Scanner scanner1 = new Scanner ( System.in );
        System.out.println("Type a word to delete:");
        String definiteString = scanner1.nextLine ();
        String string = null;
        StringBuilder stringBuffer = new StringBuilder ();

        try (BufferedReader reader = new BufferedReader(new FileReader(dir1))) {
            while ((string = reader.readLine()) != null) {
                if (!definiteString.equals(string)) {
                    stringBuffer.append(string).append("\n");
                }
            }
            string = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert string != null;
        char[] buffer = new char[string.length()];
        string.getChars(0, string.length(), buffer, 0);

        try (FileWriter writer = new FileWriter(dir1, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Word deleted");

    }
    public static void replace() throws IOException {
        String item = "D:\\Text.txt";
        Scanner scan1 = new Scanner ( System.in );
        Scanner scan2 = new Scanner ( System.in );
        System.out.println("Word which will be replaced: ");
        String search = scan1.nextLine ();
        System.out.println("Enter word to replace: ");
        String replace = scan2.nextLine ();

        Charset charset = StandardCharsets.UTF_8;
        Path path = Paths.get(item);
        Files.writeString (path,
                Files.readString (path, charset ).replace(search, replace), charset );
        System.out.println("Word replaced");
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner (System.in) ;
        System.out.println ( "What would you like to do?:\n add - Add the word\n print - Print all words\ndelete- delete the word\n replace - Replace a word\n exit - Exit the program\n");
        while (true){
            System.out.println("Your choice: ");
            switch (scanner.nextLine()){
                case "add":
                    add();
                    break;
                case "print":
                    print ();
                    break;
                case "delete":
                    delete ();
                    break;
                case "replace":
                    try {
                        replace ();
                    } catch (IOException e) {
                        throw new RuntimeException ( e );
                    }
                    break;
                case "exit":
                    System.out.println("Stopping program...");
                    System.exit ( 0 );
                    break;
            }
        }
    }
}


    
