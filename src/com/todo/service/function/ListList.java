package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public abstract class ListList extends TodoFunction{

    public abstract void sort(TodoList l);

    @Override
    public void run(TodoList l) {
        sort(l);
        System.out.println("[목록, 총 "+l.getList().size()+"개]");
        int c = 1;
        for (TodoItem item : l.getList()) {
            System.out.println((c++)+". "+item.toString());
        }
    }
}

