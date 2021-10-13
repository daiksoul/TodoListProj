package com.todo.service;

import java.io.*;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;
import com.todo.menu.Menu;

public class TodoUtil {
//
//	public static void createItem(TodoList list) {
//
//		String title, desc, cat, due;
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("\n"
//				+ "========== 항목 추가\n"
//				+ "제목을 입력하세요. : ");
//
//		title = sc.next();
//		if (list.isDuplicate(title)) {
//			System.out.print("이미 같은 제목을 가진 항목이 존재합니다.");
//			return;
//		}
//		sc.nextLine();
//		System.out.print("설명을 입력하세요. : ");
//		desc = sc.nextLine().trim();
//
//		System.out.print("카테고리를 입력하세요. : ");
//		cat = sc.next();
//
//		System.out.print("마감일자를 입력하세요. : ");
//		due = sc.next();
//
//		TodoItem t = new TodoItem(title, desc, cat, due);
//		if(list.addItem(t)>0)
//			System.out.println("추가되었습니다.");
//	}
//
//	public static void deleteItem(TodoList l) {
//
//		Scanner sc = new Scanner(System.in);
//		String conf;
//		System.out.print("\n"
//				+ "========== 항목 제거\n"
//				+ "제거할 항목의 번호를 입력하세요. : ");
//
//		int index = sc.nextInt();
//		if(index>0&&index<=l.getMaxId()) {
//			while(true) {
//				if (l.getById(index)==null){
//					System.out.println("존재하지 않는 항목입니다.");
//					return;
//				}
//				System.out.print(index + "번 항목 (" + l.getById(index).getTitle() + ")를 삭제하시겠습니까? <y/n> : ");
//				conf = sc.next();
//				if(conf.toLowerCase().equals("y")) {
//					l.deleteItem(index);
//					System.out.println("제거되었습니다.");
//					break;
//				}else if(conf.toLowerCase().equals("n")) {
//					System.out.println("취소되었습니다.");
//					break;
//				}else
//					System.out.println("y 또는 n을 입력해주세요.");
//			}
//		}
//		else
//			System.out.println("1과 "+l.getMaxId()+"사이의 숫자를 입력해주세요.");
//	}
//
//
//	public static void updateItem(TodoList l) {
//
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("\n"
//				+ "========== 항목 수정\n"
//				+ "수정할 항목의 번호를 입력하세요. :");
//		int index = sc.nextInt();
//
//		if(index<=0||index>l.getMaxId()){
//			if(l.getById(index)==null){
//				System.out.println("존재하지 않는 항목입니다.");
//				return;
//			}
//			System.out.println("1과 "+l.getMaxId()+"사이의 숫자를 입력해주세요.");
//			return;
//		}
//
//		System.out.print("새로운 제목을 입력하세요. : ");
//		String new_title = sc.next().trim();
//		if (l.isDuplicate(new_title)) {
//			System.out.println("이미 같은 제목을 가진 항목이 존재합니다.");
//			return;
//		}
//
//		sc.nextLine();
//		System.out.print("새로운 설명을 입력하세요. : ");
//		String new_description = sc.nextLine().trim();
//
//		System.out.print("새로운 카테고리를 입력하세요. : ");
//		String new_cat = sc.next();
//
//		System.out.print("새로운 마감일자를 입력하세요. : ");
//		String new_due = sc.next();
//
//		TodoItem t = new TodoItem(new_title,new_description,new_cat,new_due);
//		t.setId(index);
//		if(l.updateItem(t)>0)
//			System.out.println("수정되었습니다.");
//	}
//
//	public static void displayItem(TodoList l, int id){
//		int c = l.getCount();
//		if(id<=0||id>c) {
//			System.out.println("1과 " + c + "사이의 숫자를 입력해주세요.");
//		}else
//			Menu.displayItem(l.getById(id));
//	}
//
//	public static void completeItem(TodoList l, int id){
//		if(l.completeItem(id)>0)
//			System.out.println("완료되었습니다.");
//	}
//
//	public static void listAll(TodoList l) {
//		System.out.println("[목록, 총 "+l.getCount()+"개]");
//		for (TodoItem item : l.getList())
//			System.out.println(item.toShortString());
//	}
//
//	public static void listAll(TodoList l, String orderby, int rev){
//		System.out.println("[목록, 총 "+l.getCount()+"개]");
//		for (TodoItem item : l.getOrderedList(orderby,rev))
//			System.out.println(item.toShortString());
//	}
//
//	public static void listComp(TodoList l){
//		ArrayList<TodoItem> list = l.getListComp();
//		System.out.println("[목록, 총 "+list.size()+"개]");
//		for (TodoItem item : list)
//			System.out.println(item.toShortString());
//	}
//
//	public static void searchList(TodoList l, String keyw) {
//		ArrayList<TodoItem> list = l.getListTitleDesc(keyw);
//		for (TodoItem item : list)
//			System.out.println(item.toString());
//		System.out.println("총 "+list.size()+"개 항목을 찾았습니다.");
//	}
//
//	public static void searchCate(TodoList l, String keyw) {
//		ArrayList<TodoItem> list = l.getListCat(keyw);
//		for (TodoItem item : list)
//			System.out.println(item.toString());
//		System.out.println("총 "+list.size()+"개 항목을 찾았습니다.");
//	}
//
//	public static void listCat(TodoList l){
//		ArrayList<String> cat = l.getCategories();
//		System.out.println(String.join(" / ",cat));
//		System.out.println("총 "+cat.size()+"개의 카테고리가 등록되어 있습니다.");
	public static String NOCOMMANDERR ="존재하지 않는 명령어입니다. (help를 입력해 사용가능한 명령어를 볼 수 있습니다.)";
	public static ArrayList<TodoFunction> functions = new ArrayList<>(){{
		add(new CreateItem());
		add(new DeleteItem());
		add(new UpdateItem());
		add(new ListDefault());
		add(new ListNameAsc());
		add(new ListNameDesc());
		add(new ListDate());
		add(new ListDateDesc());
		add(new FindTitleDescr());
		add(new ListCate());
		add(new Help());
	}};

	public static void runFunction(TodoList list, String... args){
		if(args.length==1){
			for(TodoFunction function : functions){
				if(function.isCommand(args[0])) {
					function.run(list);
					return;
				}
			}
		}else if(args.length==2){
			FindTitleDescr f = (FindTitleDescr) functions.get(8);
			if(f.isCommand(args[0])) {
				f.setKeyw(args[1]);
				f.run(list);
				return;
			}
		}
		System.out.println(NOCOMMANDERR);

	}

	public static void saveList(TodoList l, String filename){
		try {
			Writer w = new FileWriter(filename);
			for(TodoItem item: l.getList())
				w.write(item.toSaveString());
			w.close();
			System.out.println("저장되었습니다.");
		}	catch (IOException e) { }
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
		} catch (IOException e) { }
	}
}
