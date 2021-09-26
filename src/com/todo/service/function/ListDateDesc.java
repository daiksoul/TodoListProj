package com.todo.service.function;

import com.todo.dao.TodoList;

public class ListDateDesc extends ListList{
    public ListDateDesc(){
        command = "ls_date_desc";
        alias = new String[] {"l_d_d","ldd"};
        description = "역시간순으로 정렬";
    }

    @Override
    public void sort(TodoList l) {
        l.sortByDate();
        l.reverseList();
    }
}
