package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		boolean quit = false;
		Menu.displaymenu();
		do {
			Menu.displayPrompt();
			String choice = sc.next();
			switch (choice) {
			case "info":
				TodoUtil.displayItem(l,sc.nextInt());
				break;

			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;

			case "ls_name":
				TodoUtil.listAll(l,"title",0);
				break;

			case "ls_name_desc":
				TodoUtil.listAll(l,"title",1);
				break;
				
			case "ls_date":
				TodoUtil.listAll(l,"due_date",0);
				break;

			case "ls_date_desc":
				TodoUtil.listAll(l,"due_date",1);
				break;

			case "find":
				TodoUtil.searchList(l, sc.next());
				break;

			case "find_cate":
				TodoUtil.searchCate(l, sc.next());
				break;

			case "ls_cate":
				TodoUtil.listCat(l);
				break;

			case "comp":
				TodoUtil.completeItem(l, sc.nextInt());
				break;

			case "ls_comp":
				TodoUtil.listComp(l);
				break;

			case "help":
				Menu.displaymenu();
				break;

			case "exit":
				quit = true;
				break;

			default:
				System.out.println("존재하지 않는 명령어입니다. (help를 입력해 사용가능한 명령어를 볼 수 있습니다.)");
				break;
			}
		} while (!quit);
	}
}
