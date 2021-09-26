package com.todo.service;

import java.io.*;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {

		String title, desc, cat, due;
		Scanner sc = new Scanner(System.in);

		System.out.print("\n"
				+ "========== 항목 추가\n"
				+ "제목을 입력하세요. : ");

		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.print("이미 같은 제목을 가진 항목이 존재합니다.");
			return;
		}
		sc.nextLine();
		System.out.print("설명을 입력하세요. : ");
		desc = sc.nextLine().trim();

		System.out.print("카테고리를 입력하세요. : ");
		cat = sc.next();

		System.out.print("마감일자를 입력하세요. : ");
		due = sc.next();

		TodoItem t = new TodoItem(title, desc, cat, due);
		list.addItem(t);
		System.out.println("추가되었습니다.");
	}

	public static void deleteItem(TodoList l) {

		Scanner sc = new Scanner(System.in);

		System.out.print("\n"
				+ "========== 항목 제거\n"
				+ "제거할 항목의 번호를 입력하세요. : ");

		int index = sc.nextInt();
		if(index>0&&index<=l.getList().size()) {
			l.deleteItem(index-1);
			System.out.println("제거되었습니다.");
		}
		else
			System.out.println("1과 "+l.getList().size()+"사이의 숫자를 입력해주세요.");
	}


	public static void updateItem(TodoList l) {

		Scanner sc = new Scanner(System.in);

		System.out.print("\n"
				+ "========== 항목 수정\n"
				+ "수정할 항목의 번호를 입력하세요. :");
		int index = sc.nextInt();

		if(index<=0||index>l.getList().size()){
			System.out.println("1과 "+l.getList().size()+"사이의 숫자를 입력해주세요.");
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

		System.out.print("새로운 카테고리를 입력하세요. : ");
		String new_cat = sc.next();

		System.out.print("새로운 마감일자를 입력하세요. : ");
		String new_due = sc.next();

		l.deleteItem(index-1);
		l.addItem(new TodoItem(new_title,new_description,new_cat,new_due));
		System.out.println("수정되었습니다.");

	}

	public static void listAll(TodoList l) {
		System.out.println("[목록, 총 "+l.getList().size()+"개]");
		int c = 1;
		for (TodoItem item : l.getList()) {
			System.out.println((c++)+". "+item.toString());
		}
	}

	public static void searchList(TodoList l, String keyw) {
		int n = 1, c = 0;
		for (TodoItem item : l.getList()) {
			if(item.containsStr(keyw)){
				System.out.println(n+". "+item.toString());
				c++;
			}
			n++;
		}
		System.out.print("총 "+c+"개 항목을 찾았습니다.");
	}

	public static void listCat(TodoList l){
		Set<String> cat = new HashSet<>();
		for (TodoItem item : l.getList()){
			cat.add(item.getCategory());
		}
		System.out.println(String.join(" / ",cat.toArray(new String[0])));
		System.out.println("총 "+cat.size()+"개의 카테고리가 등록되어 있습니다.");
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
				l.addItem(new TodoItem(token.nextToken(),token.nextToken(),token.nextToken(), token.nextToken(), token.nextToken()));
			}
			System.out.println(l.getList().size()+"개 항목을 불러왔습니다.");
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
		} catch (IOException e) {

		}
	}
}
