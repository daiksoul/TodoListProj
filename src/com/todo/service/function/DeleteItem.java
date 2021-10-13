package com.todo.service.function;

import com.todo.dao.TodoList;

import java.util.Scanner;

public class DeleteItem extends TodoFunction{
    public DeleteItem(){
        command = "del";
        alias = new String[] {"delete","remove","rm"};
        description = "항목제거";
    }

    @Override
    public Result run(TodoList l) {

        Scanner sc = new Scanner(System.in);
        String conf;
        System.out.print("\n"
                + "========== 항목 제거\n"
                + "제거할 항목의 번호를 입력하세요. : ");

        int index = sc.nextInt();
        if(index>0&&index<=l.getMaxId()) {
            if (l.getById(index)==null)
                return Result.ITEM_NOT_FOUND;
            while(true){
                System.out.print(index+"번 항목 ("+l.getById(index).getTitle()+")을/를 삭제하시겠습니까? <y/n> : ");
                conf = sc.next().toLowerCase();
                if(conf.equals("y")) {
                    l.deleteItem(index);
                    System.out.println("제거되었습니다.");
                    break;
                }else if(conf.equals("n")) {
                    System.out.println("취소되었습니다.");
                    break;
                }else
                    System.out.println("Y또는 N을 입력해주세요.");
            }
            return Result.SUCCESS;
        }
        else {
            System.out.println("1과 " + l.getMaxId() + "사이의 숫자를 입력해주세요.");
            return Result.OUT_OF_BOUND;
        }
    }
}
