package org.example;

import static org.example.Main.ByteColor.bytecolor;
import static org.example.Main.UIColor.uicolor;

public class Main {

    public static class UIColor{
        public static void uicolor(int rbi, int gbi, int bbi){
            byte r = (byte) rbi;
            byte g = (byte) gbi;
            byte b = (byte) bbi;
            int r1 = r & 0xFF;
            int g1 = g & 0xFF;
            int b1 = b & 0xFF;
            System.out.println("Byte to Int:");
            System.out.println("Byte:"  + r + "," + g + "," + b);
            System.out.println("Int:"  + r1 + "," + g1 + "," + b1);

        }
    }
    public static class ByteColor{
        public static void bytecolor(int r, int g, int b){
            byte r1 = (byte) r;
            byte g1 = (byte) g;
            byte b1 = (byte) b;
            System.out.println("Int to Byte:");
            System.out.println("Int:" + r + "," + g + "," + b);
            System.out.println("Byte:" + r1 + "," + g1 + "," +  b1);
        }
    }
    public static void main(String[] args){
        bytecolor(127,554,600);
        uicolor(146,132,156);
    }
}