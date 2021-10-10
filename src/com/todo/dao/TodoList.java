package com.todo.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.*;

import com.todo.service.DbConnect;

public class TodoList {
	private Connection conn;

	public TodoList() {
		this.conn = DbConnect.getConnection();
	}

	public int addItem(TodoItem t){
		String sql = "insert into list (title, memo, category, current_date, due_date)"
				+" values (?,?,?,?,?)";
		PreparedStatement ppstmt;
		int c = 0;
		try{
			ppstmt = conn.prepareStatement(sql);
			ppstmt.setString(1,t.getTitle());
			ppstmt.setString(2,t.getDesc());
			ppstmt.setString(3,t.getCategory());
			ppstmt.setString(4,t.getCurrent_date());
			ppstmt.setString(5,t.getDue_date());
			c = ppstmt.executeUpdate();
			ppstmt.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return c;
	}

	public int updateItem(TodoItem t){
		String sql = "update list set title=?, memo=?, category=?, current_date=?, due_date=?"
				+" where id = ?";
		PreparedStatement ppstmt;
		int c = 0;
		try{
			ppstmt = conn.prepareStatement(sql);
			ppstmt.setString(1,t.getTitle());
			ppstmt.setString(2,t.getDesc());
			ppstmt.setString(3,t.getCategory());
			ppstmt.setString(4,t.getCurrent_date());
			ppstmt.setString(5,t.getDue_date());
			ppstmt.setString(6,""+t.getId());
			c = ppstmt.executeUpdate();
			ppstmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return c;
	}

	public int deleteItem(int index) {
		String sql = "delete from list where id = ?";
		PreparedStatement ppstmt;
		int c = 0;
		try{
			ppstmt = conn.prepareStatement(sql);
			ppstmt.setString(1,""+index);
			c = ppstmt.executeUpdate();
			ppstmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return c;
	}

	public ArrayList<TodoItem> getList(String keyw, String... col){
		ArrayList<TodoItem> list = new ArrayList<>();
		keyw = "%"+keyw+"%";
		PreparedStatement ppstmt;
		String sql = "select * from list where";
		String[] strs = col;
		for(int i = 0; i<strs.length; i++)
			strs[i] = strs[i]+" like ?";
		sql += " "+String.join(" or ",strs);

		try{
			ppstmt = conn.prepareStatement(sql);
			for(int i = 1; i<= col.length; i++)
				ppstmt.setString(i,keyw);
			ResultSet rs = ppstmt.executeQuery();
			listFromRS(list,rs);
			ppstmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return list;
	}

	public ArrayList<TodoItem> getList() {
		ArrayList<TodoItem> list = new ArrayList<>();

		Statement stmt;
		try{
			stmt = conn.createStatement();
			String sql = "select * from list";
			ResultSet rs = stmt.executeQuery(sql);

			listFromRS(list,rs);
			stmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return list;
	}

	public ArrayList<TodoItem> getListTitleDesc(String keyw) {
		return getList(keyw,"title","memo");
	}

	public ArrayList<TodoItem> getListCat(String keyw) {
		return getList(keyw,"category");
	}

	public ArrayList<TodoItem> getListComp(){
		ArrayList<TodoItem> list = new ArrayList<>();
		Statement stmt;
		try{
			stmt = conn.createStatement();
			String sql = "select * from list where is_completed = 1";
			ResultSet rs = stmt.executeQuery(sql);
			listFromRS(list,rs);
			stmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return list;
	}

	public ArrayList<TodoItem> getOrderedList(String orderby, int desc){
		ArrayList<TodoItem> list = new ArrayList<>();
		Statement stmt;
		try{
			stmt = conn.createStatement();
			String sql = "select * from list order by "+orderby;
			if(desc==1) sql+=" desc";
			ResultSet rs = stmt.executeQuery(sql);
			listFromRS(list,rs);
			stmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return list;
	}

	public ArrayList<String> getCategories(){
		ArrayList<String> list = new ArrayList<>();
		Statement stmt;
		try{
			stmt = conn.createStatement();
			String sql = "select distinct category from list";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				list.add(rs.getString("category"));
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return list;
	}

	public int getCount(){
		Statement stmt;
		int c = 0;
		try{
			stmt = conn.createStatement();
			String sql = "select count(id) from list";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			c = rs.getInt("count(id)");
			stmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return c;
	}

	public int getMaxId(){
		Statement stmt;
		int c = 0;
		try{
			stmt = conn.createStatement();
			String sql = "select max(id) from list";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			c = rs.getInt("max(id)");
			stmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return c;
	}

	public TodoItem getById(int id){
		Statement stmt;
		TodoItem item = null;
		try{
			stmt = conn.createStatement();
			String sql = "select * from list where id = "+id;
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.next())
				return item;
			item = new TodoItem(
					rs.getString("category"),
					rs.getString("title"),
					rs.getString("memo"),
					rs.getString("current_date"),
					rs.getString("due_date")
					);
			item.setId(id);
			item.setComplete(rs.getInt("is_completed") == 1);
			stmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return item;
	}

	public int completeItem(int id){
		Statement stmt;
		int c = 0;
		try{
			stmt = conn.createStatement();
			String sql = "update list set is_completed=1 where id = "+id;
			c = stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return c;
	}

	public Boolean isDuplicate(String title) {
		Statement stmt;
		int c = 0;
		try{
			stmt = conn.createStatement();
			String sql = "select count(id) from list where title = '"+title+"'";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			c = rs.getInt("count(id)");
			stmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return c>0;
	}

	public void importData(String filename){
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			String sql = "insert into list (category, title, memo, current_date, due_date)"
					+"values(?,?,?,?,?)";

			int records = 0;

			while((line = br.readLine())!=null){
				StringTokenizer st = new StringTokenizer(line,"##");
				PreparedStatement ppstmt = conn.prepareStatement(sql);
				ppstmt.setString(1,st.nextToken());
				ppstmt.setString(2,st.nextToken());
				ppstmt.setString(3,st.nextToken());
				ppstmt.setString(4,st.nextToken());
				ppstmt.setString(5,st.nextToken());

				int c= ppstmt.executeUpdate();
				if(c>0) records++;
				ppstmt.close();
			}
			System.out.println(records+" records read!!");
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void listFromRS(ArrayList<TodoItem> list,ResultSet rs) throws SQLException {
		while (rs.next()){
			TodoItem t = new TodoItem(
					rs.getString("category"),
					rs.getString("title"),
					rs.getString("memo"),
					rs.getString("current_date"),
					rs.getString("due_date")
			);
			t.setId(rs.getInt("id"));
			t.setComplete(rs.getInt("is_completed") == 1);
			list.add(t);
		}
	}
}
