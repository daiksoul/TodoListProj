package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.List;

public class FindTitleDescr extends Find{
    public FindTitleDescr(){
        command = "find";
        alias = new String[] {"fnd","search","sr"};
        description = "항목 검색";
    }

    @Override
    protected List<TodoItem> searchedList(TodoList list) {
        return list.getListTitleDesc(arg[1]);
    }
}
