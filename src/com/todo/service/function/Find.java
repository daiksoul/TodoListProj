package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public abstract class Find extends TodoFunction{
    protected String keyw;

    public void setKeyw(String str){
        this.keyw = str;
    }

    public abstract boolean hasKeyw(TodoItem item, String str);

    @Override
    public void run(TodoList l){
        int n = 1, c = 0;
        for (TodoItem item : l.getList()) {
            if(hasKeyw(item,keyw)){
                System.out.println(n+". "+item.toString());
                c++;
            }
            n++;
        }
        System.out.print("총 "+c+"개 항목을 찾았습니다.");
    }
}
