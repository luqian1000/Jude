package com.jude.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) {
//        Integer a=333;
//        Integer b=333;
//        System.out.println(a.equals(b));
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(new File("D:\\program files\\jude\\src\\main\\java\\com\\jude\\test\\a.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                int cc = fileReader.read();
                System.out.println(cc);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }
}
