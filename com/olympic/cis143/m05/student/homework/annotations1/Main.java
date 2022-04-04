package com.olympic.cis143.m05.student.homework.annotations1;

public class Main {

    public static void main(String[] a) {
        Main main = new Main();
        main.callSayHello();
        main.callSayGoodBye();
    }

    private void callSayHello() {
        new HomeworkAnnotations().sayHello();
    }

    private void callSayGoodBye() {
        new HomeworkAnnotations().sayGoodBye();
    }
}
