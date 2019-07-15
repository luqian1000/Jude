package com.jude.test;

public class TestString {
    public void run(int i) {
        try {
            System.out.println(++i);
            return;
        } catch (Exception e) {

        } finally {
            i++;
        }
    }

    public static void main(String[] args) {
        int i = 2;
        TestString testString = new TestString();
        testString.run(i);
    }
}
