package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.List;

public abstract class ListList extends TodoFunction{

    public abstract List<TodoItem> sort(TodoList l);

    @Override
    public Result run(TodoList l) {
        System.out.println("[목록, 총 "+l.getCount()+"개]");
        for (TodoItem item : sort(l)) {
            System.out.println(item.toShortString());
        }
        return Result.SUCCESS;
    }
}

