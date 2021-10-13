package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class CompleteItem extends MultiArgFunction{
    public CompleteItem(){
        command = "comp";
        alias = new String[] {"complete","fn","finish"};
        description = "완료로 변경";
    }

    @Override
    public Result run(TodoList l) {
        int index;
        try {
            index = Integer.parseInt(arg[1]);
        }catch (NumberFormatException e){
            return Result.WRONG_FORMAT;
        }

        if(index<1||index>l.getMaxId()){
            System.out.println("1과 "+l.getMaxId()+"사이의 숫자를 입력해주세요.");
            return Result.OUT_OF_BOUND;
        }
        if(l.getById(index)==null)
            return Result.ITEM_NOT_FOUND;

        if(l.completeItem(index)>0) {
            System.out.println("완료되었습니다.");
            return Result.SUCCESS;
        }
        return Result.SQL_ERROR;
    }
}
