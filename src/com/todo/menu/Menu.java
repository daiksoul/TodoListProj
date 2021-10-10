package com.todo.menu;

import com.todo.dao.TodoItem;

public class Menu {
    public static String[] helps = {
        "info\t- 항목 자세히보기",
        "add\t- 항목 추가",
        "del\t- 항목 제거",
        "edit\t- 항목 수정",
        "ls\t- 모든 항목 나열",
        "ls_name\t- 제목순으로 정렬",
        "ls_name_desc\t- 제목역순으로 정렬",
        "ls_date\t- 시간순으로 정렬",
        "ls_date_desc\t- 역시간순으로 정렬",
        "find\t- 항목 검색",
        "find_cate\t- 카테고리 검색",
        "ls_cate\t- 카테고리 표시",
        "comp\t- 완료로 변경",
        "ls_comp\t- 완료된 항목 표시",
        "help\t- 명령어 표시",
        "exit 또는 ESC 키\t- 종료"
    };
    public static void displaymenu()
    {
        System.out.println();
        int n = 1;
        for(String str : helps) {
            System.out.printf("%2d. "+str+"\n",n++);
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
