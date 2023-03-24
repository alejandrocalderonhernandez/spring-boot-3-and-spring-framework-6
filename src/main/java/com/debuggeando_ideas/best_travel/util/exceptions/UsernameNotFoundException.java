package com.debuggeando_ideas.best_travel.util.exceptions;

public class UsernameNotFoundException extends RuntimeException{

    private static final String ERROR_MESSAGE = "User no exist in %s";

    public UsernameNotFoundException(String tableName) {
        super(String.format(ERROR_MESSAGE, tableName));
    }

}
