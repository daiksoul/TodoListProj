package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class Find extends TodoFunction{
    private String keyw;
    public Find(){
        command = "find";
        alias = new String[] {"fnd","search","sr"};
        description = "항목 검색";
    }

    public void setKeyw(String str){
        this.keyw = str;
    };

    @Override
    public void run(TodoList l) {
        int n = 1, c = 0;
        for (TodoItem item : l.getList()) {
            if(item.containsStr(keyw)){
                System.out.println(n+". "+item.toString());
                c++;
            }
            n++;
        }
        System.out.print("총 "+c+"개 항목을 찾았습니다.");
    }
}
