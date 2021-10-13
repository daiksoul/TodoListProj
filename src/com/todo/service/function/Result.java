package com.todo.service.function;

public enum Result {
    SUCCESS(""),
    OUT_OF_BOUND(""),
    UNKNOWN_COMMAND(""),
    END_PROGRAM(""),
    ;
    private String message;
    Result(String str){
        this.message = str;
    }
}
