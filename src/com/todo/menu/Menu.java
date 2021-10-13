package com.todo.menu;

import com.todo.dao.TodoItem;

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
    public static void displayItem(TodoItem item){
        String compstr = item.getComplete()?"[V]":"[-]";
        System.out.printf("#%d \"%s\" %s\n",item.getId(),item.getTitle(),compstr);
        System.out.println("설명:");
        System.out.println("\t"+item.getDesc());
        System.out.println("마감일자: "+item.getDue_date());
        System.out.println("등록일시: "+item.getCurrent_date());
    }
}
