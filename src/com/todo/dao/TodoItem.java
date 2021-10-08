package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
    private int id;
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private String due_date;
    private boolean complete = false;
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");

    public TodoItem(String title, String desc){
        this.title=title;
        this.desc=desc;
        this.current_date= format.format(new Date());
    }

    public TodoItem(String cat, String title, String desc, String date, String due){
        this.title = title;
        this.desc = desc;
        this.current_date = date;
        this.category = cat;
        this.due_date = due;
    }

    public TodoItem(String title, String desc, String cat, String due){
        this.title = title;
        this.desc = desc;
        this.category = cat;
        this.due_date = due;
        this.current_date = format.format(new Date());
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }

    public String toSaveString() {
        return category+"##"+title+"##"+desc+"##"+current_date+"##"+due_date+"\n";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public boolean getComplete(){
        return this.complete;
    }

    public void setComplete(boolean b){
        this.complete = b;
    }

    @Override
    public String toString(){
        return id+". ["+category+"]\t\""+title+"\""+(complete?"[V]":"")+"\t"+desc+"\t"+due_date+" - "+current_date;
    }
}
