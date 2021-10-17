package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.List;

public class ListNameAsc extends ListList {
    public ListNameAsc(){
        command = "ls_name_asc";
        alias = new String[] {"lna","l_n_a"};
        description = "제목순으로 정렬";
    }

    @Override
    public List<TodoItem> sort(TodoList l) {
        return l.getOrderedList("title",0);
    }
}
