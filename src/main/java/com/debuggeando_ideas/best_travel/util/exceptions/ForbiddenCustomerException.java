package com.debuggeando_ideas.best_travel.util.exceptions;

public class ForbiddenCustomerException extends RuntimeException{

    public ForbiddenCustomerException() {
        super("This customer is blocked");
    }
}
