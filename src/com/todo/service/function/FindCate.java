package com.todo.service.function;

import com.todo.dao.TodoItem;

public class FindCate extends Find{
    public FindCate(){
        command = "find_cate";
        alias = new String[] {"fndc","fc","search_cate","sc"};
        description = "카테고리 검색";
    }
    @Override
    public boolean hasKeyw(TodoItem item, String str) {
        return item.containsStr(str);
    }
}
