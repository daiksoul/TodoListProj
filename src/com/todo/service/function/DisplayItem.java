package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;
import com.todo.menu.Menu;

public class DisplayItem extends MultiArgFunction{
    public DisplayItem(){
        command = "info";
        alias = new String[] {"information"};
        description = "항목 자세히보기";
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

        TodoItem item = l.getById(index);
        if(item==null)
            return Result.ITEM_NOT_FOUND;
        Menu.displayItem(item);
        return Result.SUCCESS;
    }
}
