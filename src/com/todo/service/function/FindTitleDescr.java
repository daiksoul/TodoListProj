package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class FindTitleDescr extends Find{
    public FindTitleDescr(){
        command = "find";
        alias = new String[] {"fnd","search","sr"};
        description = "항목 검색";
    }

    @Override
    public boolean hasKeyw(TodoItem item, String str) {
        return item.getTitle().contains(str) || item.getDesc().contains(str);
    }
}
