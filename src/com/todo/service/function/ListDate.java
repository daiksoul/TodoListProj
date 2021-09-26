package com.todo.service.function;

import com.todo.dao.TodoList;

public class ListDate extends ListList {
    public ListDate(){
        command = "ls_date";
        alias = new String[] {"l_d","ld"};
        description = "시간순으로 정렬";
    }

    @Override
    public void sort(TodoList l) {
        l.sortByDate();
    }
}
