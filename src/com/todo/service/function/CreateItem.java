package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.Scanner;

public class CreateItem extends TodoFunction{
    public CreateItem(){
        command = "add";
        alias = new String[] {"ad","create","cr"};
        description = "항목 추가";
    }

    @Override
    public Result run(TodoList list) {
        String title, desc, cat, due;
        Scanner sc = new Scanner(System.in);

        System.out.print("\n"
                + "========== 항목 추가\n"
                + "제목을 입력하세요. : ");

        title = sc.next();
        if (list.isDuplicate(title)) {
            System.out.print("이미 같은 제목을 가진 항목이 존재합니다.");
            return Result.SUCCESS;
        }
        sc.nextLine();
        System.out.print("설명을 입력하세요. : ");
        desc = sc.nextLine().trim();

        System.out.print("카테고리를 입력하세요. : ");
        cat = sc.next();

        System.out.print("마감일자를 입력하세요. : ");
        due = sc.next();

        TodoItem t = new TodoItem(title, desc, cat, due);
        if(list.addItem(t)>0) {
            System.out.println("추가되었습니다.");
            return Result.SUCCESS;
        }
        return Result.SQL_ERROR;
    }
}
