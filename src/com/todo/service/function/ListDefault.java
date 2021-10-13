package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.List;

public class ListDefault extends ListList {
    public ListDefault() {
        command = "ls";
        alias = new String[]{"list"};
        description = "모든 항목 나열";
    }

    @Override
    public List<TodoItem> sort(TodoList l) {
        return l.getList();
    }
}