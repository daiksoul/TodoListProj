package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.HashSet;
import java.util.Set;

public class FindCate extends TodoFunction{
    public FindCate(){
        command = "find_cate";
        alias = new String[] {"fndc","fc","categories","cats"};
        description = "카테고리 표시";
    }

    @Override
    public void run(TodoList l) {
        if(l.getList().size() == 0){
            System.out.println("카테고리를 발견하지 못했습니다.");
            return;
        }

        Set<String> cat = new HashSet<>();
        for (TodoItem item : l.getList()){
            cat.add(item.getCategory());
        }
        System.out.println(String.join(" / ",cat.toArray(new String[0])));
        System.out.println("총 "+cat.size()+"개의 카테고리가 등록되어 있습니다.");
    }
}
