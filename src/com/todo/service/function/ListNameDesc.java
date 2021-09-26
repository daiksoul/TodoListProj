package com.todo.service.function;

import com.todo.dao.TodoList;

public class ListNameDesc extends ListList{
    public ListNameDesc(){
        command = "ls_name_desc";
        alias = new String[] {"l_n_d","lnd"};
        description = "제목역순으로 정렬";
    }

    @Override
    public void sort(TodoList l) {
        l.sortByName();
        l.reverseList();
    }
}
