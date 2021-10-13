package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.List;

public class FindCate extends Find{
    public FindCate(){
        command = "find_cate";
        alias = new String[] {"fndc","fc","search_cate","sc"};
        description = "카테고리 검색";
    }

    @Override
    protected List<TodoItem> searchedList(TodoList list) {
        return list.getListCat(arg[1]);
    }
}
