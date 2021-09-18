package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem { // �� item���� 3���� member�� �������ִ�.
    private String title;  // ����
    private String desc;  // ����
    private String current_date;  // item�� �����Ǵ� �ð�


    public TodoItem(String title, String desc){  // constructor, item�� ����� ������ �Է¹޾Ƽ� ��ü ����
        this.title = title;
        this.desc = desc;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date = f.format(new Date());  // �ڵ����� ����
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
		return "TodoListItem [ ���� ] : " + title + ", [ ���� ] : " + desc + ", [ item �����ð� ] : " + current_date;	
	}
    
}
