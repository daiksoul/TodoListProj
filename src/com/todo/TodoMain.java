package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		Menu.displaymenu();
		do {
			Menu.displayPrompt();
			String choice = sc.nextLine();
			TodoUtil.runFunction(l,choice.split(" "));
		} while (true);
	}
}
