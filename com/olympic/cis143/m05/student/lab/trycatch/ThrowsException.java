package com.olympic.cis143.m05.student.lab.trycatch;

import javax.management.BadStringOperationException;

public class ThrowsException {

    public void throwAnExceptionForMe() throws BadStringOperationException, InterruptedException {
        this.thowMultipleExceptionsForMe();
    }

    private void thowMultipleExceptionsForMe() throws BadStringOperationException, InterruptedException {
        if ( 1 == 1 ) {
            throw new InterruptedException("Another exception that you will need to take care of.");
        }
        throw new BadStringOperationException("Simple exception that you will need to take care of");
    }
}
