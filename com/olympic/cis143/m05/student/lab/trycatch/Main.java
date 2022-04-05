package com.olympic.cis143.m05.student.lab.trycatch;

import javax.management.BadStringOperationException;

public class Main {

    public static void main (String[] a) throws BadStringOperationException, InterruptedException {
        Main main = new Main();
        main.testNeedsToBeModified();
        throw new RuntimeException();
    }

    public void testNeedsToBeModified() throws BadStringOperationException, InterruptedException {
        try {
            new ThrowsException().throwAnExceptionForMe();
        } catch (MyException ex) {
            System.out.println("Exception caught");
        }
    }
}
