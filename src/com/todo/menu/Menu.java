package com.todo.menu;

import com.todo.service.TodoUtil;
import com.todo.service.function.TodoFunction;

public class Menu {
    public static void displaymenu()
    {
        System.out.println();
        int n = 1;
        for(TodoFunction f: TodoUtil.functions){
            System.out.printf("%2d. "+f.getCommand()+"\t- "+f.getDescription(),n++);
        }
    }
    public static void displayPrompt() {
        System.out.print("\n명령어를 입력하세요 > ");
    }
}
