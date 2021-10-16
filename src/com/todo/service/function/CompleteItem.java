package com.todo.service.function;

import com.todo.dao.TodoList;

import java.util.Arrays;
import java.util.Scanner;

public class CompleteItem extends TodoFunction{
    public CompleteItem(){
        command = "comp";
        alias = new String[] {"complete","fn","finish"};
        description = "완료로 변경";
    }

    @Override
    public Result run(TodoList l) {
        int index;
        Scanner sc = new Scanner(System.in);
        System.out.print("\n"
                + "========== 항목 완료\n"
                + "완료할 항목의 번호를 입력하세요. : ");
        String str = sc.nextLine();
        int[] ids;
        try {
            ids = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        }catch (NumberFormatException e){
            return Result.WRONG_FORMAT;
        }

        if(Arrays.stream(ids).anyMatch(x->(x<l.getMinId()||x>l.getMaxId()))){
            System.out.println(l.getMinId()+" ~ "+l.getMaxId()+"사이의 숫자를 입력해주세요.");
            return Result.OUT_OF_BOUND;
        }
        if(Arrays.stream(ids).anyMatch(x->l.getById(x)==null))
            return Result.ITEM_NOT_FOUND;

        if(l.completeItem(ids)>0) {
            System.out.println("완료되었습니다.");
            return Result.SUCCESS;
        }
        return Result.SQL_ERROR;
    }
}
