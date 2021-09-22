package com.todo.service;

import java.io.*;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"
				+ "========== 항목 추가\n"
				+ "제목을 입력하세요. : ");
		
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.printf("이미 같은 제목을 가진 항목이 존재합니다.");
			return;
		}
		sc.nextLine();
		System.out.print("설명을 입력하세요. : ");
		desc = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
		System.out.println("추가되었습니다.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("\n"
				+ "========== 항목 제거\n"
				+ "제거할 항목의 제목을 입력하세요. : ");

		String title = sc.next();
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println("제거되었습니다.");
				break;
			}
		}
		System.out.println("항목이 존재하지 않습니다.");
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"
				+ "========== 항목 수정\n"
				+ "수정할 항목의 제목을 입력하세요. :");
		String title = sc.next().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("제목이 \""+title+"\"인 항목이 존재 하지 않습니다.");
			return;
		}

		System.out.print("새로운 제목을 입력하세요. : ");
		String new_title = sc.next().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("이미 같은 제목을 가진 항목이 존재합니다.");
			return;
		}

		sc.nextLine();
		System.out.print("새로운 설명을 입력하세요. : ");
		String new_description = sc.nextLine().trim();
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description);
				l.addItem(t);
				System.out.println("수정되었습니다.");
			}
		}

	}

	public static void listAll(TodoList l) {
		System.out.println("[목록]");
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}

	public static void saveList(TodoList l, String filename){
		try {
			Writer w = new FileWriter(filename);
			for(TodoItem item: l.getList())
				w.write(item.toSaveString());
			w.close();
			System.out.println("저장되었습니다.");
		}	catch (IOException e) {

		}

	}

	public static void loadList(TodoList l, String filename){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String str;
			while((str = reader.readLine())!=null){
				StringTokenizer token = new StringTokenizer(str,"##");
				l.addItem(new TodoItem(token.nextToken(),token.nextToken(),token.nextToken()));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
		} catch (IOException e) {

		}
	}
}
