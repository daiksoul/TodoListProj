package com.todo.service.function;

import com.todo.dao.TodoList;

import java.util.List;

public class ListCate extends TodoFunction{
    public ListCate(){
        command = "ls_cate";
        alias = new String[] {"lc","categories","cats"};
        description = "카테고리 표시";
    }

    @Override
    public Result run(TodoList l) {
        if(l.getCount() == 0){
            System.out.println("카테고리를 발견하지 못했습니다.");
            return Result.SUCCESS;
        }

        List<String> cat = l.getCategories();
        System.out.println(String.join(" / ",cat.toArray(new String[0])));
        System.out.println("총 "+cat.size()+"개의 카테고리가 등록되어 있습니다.");
        return Result.SUCCESS;
    }
}
