package com.olnester;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world !");
        String a = "hello";
        String b = new String("hello");
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
