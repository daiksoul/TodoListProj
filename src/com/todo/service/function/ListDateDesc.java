package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.List;

public class ListDateDesc extends ListList{
    public ListDateDesc(){
        command = "ls_date_desc";
        alias = new String[] {"l_d_d","ldd"};
        description = "역시간순으로 정렬";
    }

    @Override
    public List<TodoItem> sort(TodoList l) {
        return l.getOrderedList("due_date",1);
    }
}
