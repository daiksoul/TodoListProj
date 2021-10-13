package com.todo.service.function;

public abstract class MultiArgFunction extends TodoFunction{
    protected String[] arg;
    public void setArg(String... a) {
        this.arg = a;
    }
}
