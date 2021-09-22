package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("1. add\t- 항목 추가");
        System.out.println("2. del\t- 항목 제거");
        System.out.println("3. edit\t- 항목 수정");
        System.out.println("4. ls\t- 모든 항목 나열");
        System.out.println("5. ls_name_asc\t- 제목순으로 정렬");
        System.out.println("6. ls_name_desc\t- 제목역순으로 정렬");
        System.out.println("7. ls_date\t- 시간순으로 정렬");
        System.out.println("8. help\t- 명령어 표시");
        System.out.println("9. exit 또는 ESC 키\t- 종료");
    }
    public static void displayPrompt() {
        System.out.print("\n명령어를 입력하세요 > ");
    }
}
