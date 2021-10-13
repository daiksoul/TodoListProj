package com.todo.service.function;

import com.todo.dao.TodoList;

public class Exit extends TodoFunction{
    public Exit(){
        command = "exit";
        alias = new String[] {"quit"};
        description = "프로그램을 종료합니다.";
    }

    @Override
    public Result run(TodoList l) {
        return Result.END_PROGRAM;
    }
}
