package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem { // 각 item들은 3개의 member를 가지고있다.
    private String title;  // 제목
    private String desc;  // 내용
    private String current_date;  // item이 생성되는 시간


    public TodoItem(String title, String desc){  // constructor, item의 제목과 내용을 입력받아서 객체 생성
        this.title = title;
        this.desc = desc;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date = f.format(new Date());  // 자동으로 생성
    } 
    
    public void SetItem(String title, String desc, String time){ 
        this.title = title;
        this.desc = desc;
        this.current_date = time;
    } 
    
    // getter, setter
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
        return title + "##" + desc + "##" + current_date + "\n";
    }    

	@Override
	public String toString() {
		return "TodoListItem [ 제목 ] : " + title + ", [ 내용 ] : " + desc + ", [ item 생성시간 ] : " + current_date;	
	}
    
}
