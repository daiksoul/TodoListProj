package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.List;

public class ListNameDesc extends ListList{
    public ListNameDesc(){
        command = "ls_name_desc";
        alias = new String[] {"l_n_d","lnd"};
        description = "제목역순으로 정렬";
    }

    @Override
    public List<TodoItem> sort(TodoList l) {
        return l.getOrderedList("name",1);
    }
}
