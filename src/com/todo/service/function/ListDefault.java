package com.todo.service.function;

import com.todo.dao.TodoList;

public class ListDefault extends ListList {
    public ListDefault() {
        command = "ls";
        alias = new String[]{"list"};
        description = "모든 항목 나열";
    }

    @Override
    public void sort(TodoList l) {
    }
}