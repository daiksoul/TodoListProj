package com.todo.service.function;

public enum Result {
    SUCCESS(),
    OUT_OF_BOUND("잘못된 숫자입니다!"){

    },
    UNKNOWN_COMMAND("알 수 없는 명령어입니다."),
    END_PROGRAM("프로그램이 종료됩니다."),
    ITEM_NOT_FOUND("존재하지 않는 항목입니다."),
    SQL_ERROR(),
    ARGUMENT_MISSING("매개변수가 부족합니다."),
    WRONG_FORMAT("잘못된 형식입니다."),
    ;

    private String message;
    public void print(){
        System.out.println(message);
    };
    Result(String str){
        this.message = str;
    }
    Result(){
        message = "";
    }
}
