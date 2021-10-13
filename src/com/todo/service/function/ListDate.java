package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.List;

public class ListDate extends ListList {
    public ListDate(){
        command = "ls_date";
        alias = new String[] {"l_d","ld"};
        description = "시간순으로 정렬";
    }

    @Override
    public List<TodoItem> sort(TodoList l) {
        return l.getOrderedList("due_date",0);
    }
}
