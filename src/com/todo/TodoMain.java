package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		TodoUtil.loadList(l,"todolist.txt");
		boolean isList = false;
		boolean quit = false;
		Menu.displaymenu();
		do {
			Menu.displayPrompt();
			isList = false;
			String choice = sc.next();
			switch (choice) {

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

			case "ls_name_asc":
				l.sortByName();
				isList = true;
				break;

			case "ls_name_desc":
				l.sortByName();
				l.reverseList();
				isList = true;
				break;
				
			case "ls_date":
				l.sortByDate();
				isList = true;
				break;

			case "ls_date_desc":
				l.sortByDate();
				l.reverseList();
				isList = true;
				break;

			case "find":
				TodoUtil.searchList(l,sc.next());
				break;

			case "find_cate":
				TodoUtil.searchCate(l, sc.next());
				break;

			case "ls_cate":
				TodoUtil.listCat(l);
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
			
			if(isList) l.listAll();
		} while (!quit);
		TodoUtil.saveList(l,"todolist.txt");
	}
}
