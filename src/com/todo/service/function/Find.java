package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.List;

public abstract class Find extends MultiArgFunction {

    protected abstract List<TodoItem> searchedList(TodoList list);

    @Override
    public Result run(TodoList l){
        List<TodoItem> list = searchedList(l);
        for (TodoItem item : list)
            System.out.println(item.toString());
        System.out.print("총 "+list.size()+"개 항목을 찾았습니다.");
        arg = null;
        return Result.SUCCESS;
    }
}
