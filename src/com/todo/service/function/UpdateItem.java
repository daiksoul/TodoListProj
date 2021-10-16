package com.todo.service.function;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.util.Scanner;

public class UpdateItem extends TodoFunction{
    public UpdateItem(){
        command = "edit";
        alias = new String[] {"ed","update","upd"};
        description = "항목 수정";
    }

    @Override
    public Result run(TodoList l) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n"
                + "========== 항목 수정\n"
                + "수정할 항목의 번호를 입력하세요. :");
        int index = sc.nextInt();

        if(index<=0||index>l.getMaxId()){
            System.out.println(l.getMinId()+" ~ "+l.getMaxId()+"사이의 숫자를 입력해주세요.");
            return Result.OUT_OF_BOUND;
        }
        if(l.getById(index)==null)
            return Result.ITEM_NOT_FOUND;

        System.out.print("새로운 제목을 입력하세요. : ");
        String new_title = sc.next().trim();
        if (l.isDuplicate(new_title)) {
            System.out.println("이미 같은 제목을 가진 항목이 존재합니다.");
            return Result.SUCCESS;
        }

        sc.nextLine();
        System.out.print("새로운 설명을 입력하세요. : ");
        String new_description = sc.nextLine().trim();

        System.out.print("새로운 카테고리를 입력하세요. : ");
        String new_cat = sc.next();

        System.out.print("새로운 마감일자를 입력하세요. : ");
        String new_due = sc.next();

        TodoItem t = new TodoItem(new_title,new_description,new_cat,new_due);
        t.setId(index);
        if(l.updateItem(t)>0) {
            System.out.println("수정되었습니다.");
            return Result.SUCCESS;
        }
        return Result.SQL_ERROR;
    }
}
