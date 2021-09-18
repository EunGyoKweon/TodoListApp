package com.todo.dao;

import java.util.*;

import com.todo.service.TodoSortByDate;
import com.todo.service.TodoSortByName;

public class TodoList {
	private List<TodoItem> list; // TodoItem 객체들을 List로 가지는 list

	public TodoList() {
		this.list = new ArrayList<TodoItem>(); // 이 list는 ArrayList이다.
	}
	
	// item 추가
	public void addItem(TodoItem t) {
		list.add(t);
	}

	// item 삭제
	public void deleteItem(TodoItem t) {
		list.remove(t);
	}

	// item 수정
	void editItem(TodoItem t, TodoItem updated) {
		int index = list.indexOf(t);
		list.remove(index);
		list.add(updated);
	}

	// 전체 list를 가지고 return
	public ArrayList<TodoItem> getList() {
		return new ArrayList<TodoItem>(list);
	}

	// item name을 기준으로 sort
	public void sortByName() {
		Collections.sort(list, new TodoSortByName());

	}
	
	// list item들 모두 출력
	public void listAll() {
		System.out.println("\n"
				+ "[ 전체 item 목룍 ]\n");
		for (TodoItem myitem : list) {
			System.out.println("[ 제목 ] : " + myitem.getTitle() + ", [ 내용 ] : " + myitem.getDesc() + ", [ item 생성시간 ] : " + myitem.getCurrent_date());
		}
	}
	
	// list item들 역순 출력
	public void reverseList() {
		Collections.reverse(list);
	}
	
	// item 생성시간에 따라서 sort
	public void sortByDate() {
		Collections.sort(list, new TodoSortByDate());
	}

	// 특정한 item의 위치(순서)를 return
	public int indexOf(TodoItem t) {
		return list.indexOf(t);
	}
	
	// item 제목 중복체크
	public Boolean isDuplicate(String title) {
		for (TodoItem item : list) {
			if (title.equals(item.getTitle())) return true;
		}
		return false;
	}
}
