package com.todo.service.function;

import com.todo.dao.TodoList;

import java.util.Arrays;
import java.util.Scanner;

public class ExportItems extends TodoFunction{
    public ExportItems(){
        command = "exp";
        alias = new String[] {"export"};
        description = "항목들을 json형식 파일로 내보내기";
    }

    @Override
    public Result run(TodoList l) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n"
                + "========== 내보내기\n"
                + "파일명을 입력하세요. : ");
        String fname = sc.next();
        sc.nextLine();
        System.out.print("내보낼 항목의 번호를 입력하세요. : ");
        String args = sc.nextLine();
        int c;
        try {
            if (args.equals("all"))
                c = l.exportJson(fname);
            else
                c = l.exportJson(fname, Arrays.stream(args.split(" ")).mapToInt(Integer::parseInt).toArray());
        }catch (NumberFormatException e){
            return Result.WRONG_FORMAT;
        }
        System.out.println(c+"개 항목을 내보냈습니다.");
        return Result.SUCCESS;
    }
}
