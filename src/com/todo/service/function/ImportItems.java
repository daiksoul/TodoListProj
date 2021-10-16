package com.todo.service.function;

import com.todo.dao.TodoList;

import java.io.File;
import java.util.Scanner;

public class ImportItems extends TodoFunction{
    public ImportItems(){
        command = "imp";
        alias = new String[] {"import"};
        description = "Json형식의 파일로부터 항목 불러오기";
    }

    @Override
    public Result run(TodoList l) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n"
                + "========== 불러오기\n"
                + "파일명을 입력하세요. : ");
        String fname = sc.next();
        File file = new File(fname);
        if(!file.exists())
            return Result.FILE_NOT_FOUND;
        l.importJson(fname);
        return Result.SUCCESS;
    }
}
