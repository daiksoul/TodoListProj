package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.List;

public class ListComp extends ListList{
    public ListComp(){
        command = "ls_comp";
        alias = new String[] {"list_complete"};
        description = "완료된 항목 표시";
    }

    @Override
    public List<TodoItem> sort(TodoList l) {
        return l.getListComp();
    }
}
