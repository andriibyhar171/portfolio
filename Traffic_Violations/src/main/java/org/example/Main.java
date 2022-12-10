package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void type_and_write() {
    File penalty = new File ( "D:\\Penalty.txt" );
        try(FileWriter writer = new FileWriter(penalty, false))
        {
            Date date = new Date (  );
            Scanner scan = new Scanner ( System.in );
            String line = "---------------------------------------------------------------------------------------------------------\n";
            System.out.println ( "----Заповніть штраф----" );
            writer.write ( "\t\t\tДата здійснення операції: " + date + "\n" +line );
            System.out.println ( "Введіть суму\n(Наприклад: 255,00):" );
            writer.write ( "\t\t\tСума: " + scan.nextLine ()  + " грн\n"+line );
            System.out.println ( "Введіть П.І.Б платника:" );
            String person = scan.nextLine ();
            writer.write ( "\t\t\tПлатник: " + person + "\n"+line );
            System.out.println ( "Введіть місце проживання\n(Наприклад: м.Київ, вул.Лукянівська, 62):" );
            writer.write ( "\t\t\tМісце проживання: " + scan.nextLine () + "\n"+line );
            writer.write ( "\t\t\t\t\tОтримувач\n"+line );
            System.out.println ( "Введіть назву\n(Наприклад: ГУДКСУ у Шевченківському районі м. Києва):" );
            writer.write ( "\t\t\tНазва: " + scan.nextLine () + "\n"+line );
            System.out.println ( "Введіть банк\n(Наприклад: ГУДКСУ у Шевченківському районі м. Києва):" );
            writer.write ( "\t\t\tБанк: " + scan.nextLine () + "\n"+line );
            System.out.println ( "Введіть: Код платежу --> Серію протоколу --> Номер протоколу про адмінправопорушення\n(Наприклад: 1-21081300 2-AA1 3-256123" );
            writer.write ( "\t\t\tПризначення платежу: " +"*;"+ scan.nextLine () +";"+ scan.nextLine ()+";" +scan.nextLine () + ";*" + person + "\n"+line );
            System.out.println ( "Введіть: Платника --> Бонтролера --> Бугалтера --> Касира" );
            writer.write ( "\t\t\tПлатник: " + scan.nextLine () +" Контролер: " + scan.nextLine ()+" Бугалтер: " + scan.nextLine ()+ " Касир: " + scan.nextLine ()+"\n"+line );
            System.out.println ( "----Штраф заповнений----\n" );
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void delete() {
        File file = new File("D:\\Penalty.txt");
        boolean result = file.delete();
        if (result) {
            System.out.println("File is successfully deleted.");
        }
        else {
            System.out.println("File deletion failed.");
        }
    }

    public static void main(String[] args) {
        Scanner user = new Scanner ( System.in );
        while (true){
            System.out.println ( "----ПДР Штрафи----\nВведіть:\nwrite - щоб додати штраф\ndelete - щоб видалити штраф\nexit - завершення програми");
            switch (user.nextLine ( )) {
                case "write" -> type_and_write ( );
                case "delete" -> delete ( );
                case "exit" -> {
                    System.out.println ( "Завершення програми..." );
                    System.exit ( 0 );
                }
            }
        }
    }
}
