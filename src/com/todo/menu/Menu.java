package com.todo.menu;

import com.todo.service.TodoUtil;
import com.todo.service.function.TodoFunction;

public class Menu {
    public static String[] helps = {
        "add\t- 항목 추가",
        "del\t- 항목 제거",
        "edit\t- 항목 수정",
        "ls\t- 모든 항목 나열",
        "ls_name_asc\t- 제목순으로 정렬",
        "ls_name_desc\t- 제목역순으로 정렬",
        "ls_date\t- 시간순으로 정렬",
        "ls_date_desc\t- 역시간순으로 정렬",
        "find\t- 항목 검색",
        "find_cate\t- 카테고리 표시",
        "help\t- 명령어 표시",
        "exit 또는 ESC 키\t- 종료"
    };
    public static void displaymenu()
    {
        System.out.println();
        int n = 1;
//        for(String str : helps) {
//            System.out.printf("%2d. "+str+"\n",n++);
//        }
        for(TodoFunction f: TodoUtil.functions){
            System.out.printf("%2d. "+f.getCommand()+"\t- "+f.getDescription(),n++);
        }
    }
    public static void displayPrompt() {
        System.out.print("\n명령어를 입력하세요 > ");
    }
}
