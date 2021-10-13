package com.todo.service.function;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;

public class Help extends TodoFunction{
    public Help(){
        command = "help";
        alias = new String[] {"h"};
        description = "명령어 표시";
    }

    @Override
    public Result run(TodoList l) {
        Menu.displaymenu();
        return Result.SUCCESS;
    }
}
