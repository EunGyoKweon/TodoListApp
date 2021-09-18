package com.todo.dao;

import java.util.*;

import com.todo.service.TodoSortByDate;
import com.todo.service.TodoSortByName;

public class TodoList {
	private List<TodoItem> list; // TodoItem ��ü���� List�� ������ list

	public TodoList() {
		this.list = new ArrayList<TodoItem>(); // �� list�� ArrayList�̴�.
	}
	
	// item �߰�
	public void addItem(TodoItem t) {
		list.add(t);
	}

	// item ����
	public void deleteItem(TodoItem t) {
		list.remove(t);
	}

	// item ����
	void editItem(TodoItem t, TodoItem updated) {
		int index = list.indexOf(t);
		list.remove(index);
		list.add(updated);
	}

	// ��ü list�� ������ return
	public ArrayList<TodoItem> getList() {
		return new ArrayList<TodoItem>(list);
	}

	// item name�� �������� sort
	public void sortByName() {
		Collections.sort(list, new TodoSortByName());

	}
	
	// list item�� ��� ���
	public void listAll() {
		System.out.println("\n"
				+ "[ ��ü item �� ]\n");
		for (TodoItem myitem : list) {
			System.out.println("[ ���� ] : " + myitem.getTitle() + ", [ ���� ] : " + myitem.getDesc() + ", [ item �����ð� ] : " + myitem.getCurrent_date());
		}
	}
	
	// list item�� ���� ���
	public void reverseList() {
		Collections.reverse(list);
	}
	
	// item �����ð��� ���� sort
	public void sortByDate() {
		Collections.sort(list, new TodoSortByDate());
	}

	// Ư���� item�� ��ġ(����)�� return
	public int indexOf(TodoItem t) {
		return list.indexOf(t);
	}
	
	// item ���� �ߺ�üũ
	public Boolean isDuplicate(String title) {
		for (TodoItem item : list) {
			if (title.equals(item.getTitle())) return true;
		}
		return false;
	}
}
