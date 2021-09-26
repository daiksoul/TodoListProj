package com.todo.service;

import java.io.*;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;
import com.todo.service.function.*;

public class TodoUtil {
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
