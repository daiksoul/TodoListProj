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
			String choice = sc.nextLine();
			TodoUtil.runFunction(l,choice.split(" "));
			
			if(isList) l.listAll();
		} while (!quit);
		TodoUtil.saveList(l,"todolist.txt");
	}
}
