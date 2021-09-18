package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		boolean isList = false;
		boolean quit = false;
		
		TodoUtil.loadList(l, "todolist.txt"); // file load
		
		Menu.displaymenu();  // �޴� ���
		do {
			
			Menu.prompt();
			isList = false; // do while���� ������ �� isList�� true�� �Ǵ� ������ ���� ����.
			String choice = sc.next();
			switch (choice) {

			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;

			case "ls_name_asc":
				l.sortByName();
				System.out.println("��������� �����Ͽ����ϴ�.");
				isList = true;
				break;

			case "ls_name_desc":
				l.sortByName();
				l.reverseList();
				System.out.println("���񿪼����� �����Ͽ����ϴ�.");
				isList = true;  // ������ �Ϸ��ϰ��� isList���� ���� true�� ����
				break;
				
			case "ls_date":
				l.sortByDate();
				System.out.println("item ���� ������� �����Ͽ����ϴ�.");
				isList = true;
				break;

			case "exit":
				quit = true;
				System.out.println("���������� ����Ǿ����ϴ�.");
				break;
			
			case "help":
				Menu.displaymenu();
				break;

			default:
				System.out.println("��Ȯ�� ��ɾ �Է��ϼ���. (���� - help)");
				break;
			}
			
			if(isList) l.listAll();  // isList�� true�� ��� ��, List�� ������ �Ϸ�Ǹ� list�� �ִ� item���� ��� ���
		} while (!quit);
		TodoUtil.saveList(l, "todolist.txt");
	}
}
