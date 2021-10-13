package com.todo.service.function;

import com.todo.dao.TodoList;

import java.util.Arrays;

public abstract class TodoFunction {
    protected String command;
    protected String description;
    protected String[] alias;

    public boolean isCommand(String str){
        return command.equals(str) || Arrays.stream(alias).anyMatch(x->x.equals(str));
    }

    public String getCommand(){
        return command;
    }

    public String getDescription(){
        return description;
    }

    public abstract Result run(TodoList l);

}
