package com.todo.service.function;

import com.todo.dao.TodoList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        String str = sc.nextLine();
        int[] ids = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        if(Arrays.stream(ids).allMatch(x-> (x>=l.getMinId()&&x<=l.getMaxId()))) {
            if (Arrays.stream(ids).anyMatch(x->l.getById(x)==null))
                return Result.ITEM_NOT_FOUND;
            while(true){
                List<String> titles = new ArrayList<>();
                for(int id : ids)
                    titles.add(l.getById(id).getTitle());
                System.out.print(ids.length+"개 항목 ("+String.join(" , ",titles)+")을/를 삭제하시겠습니까? <y/n> : ");
                conf = sc.next().toLowerCase();
                if(conf.equals("y")) {
                    System.out.println(l.deleteItem(ids)+"개 항목이 제거되었습니다.");
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
            System.out.println(l.getMinId() + " ~ " + l.getMaxId() + "사이의 숫자를 입력해주세요.");
            return Result.OUT_OF_BOUND;
        }
    }
}
