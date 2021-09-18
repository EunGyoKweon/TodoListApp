package com.todo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	// item ���� �߰�
	public static void createItem(TodoList list) {
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "========== [ item �߰� ] ==========\n");
		System.out.print("[ ���� ] : ");
		title = sc.next();  // ������ �ܾ�� �Է¹���.
		
		// ���� �ߺ�üũ
		if (list.isDuplicate(title)) {
			System.out.println("");
			System.out.printf("[ ��� ] item�� ������ �ߺ��� �� �����ϴ�.");
			System.out.println("");
			return;
		}
		
		sc.nextLine(); // ������ �Է��ϰ� enterġ�°� ����
		
		System.out.print("[ ���� ] : ");
		desc = sc.nextLine().trim(); // ������ line���� �Է¹��� & trim => �¿���� ����
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
		System.out.println("[ �˸� ] : item�� ���������� �߰��Ǿ����ϴ�.");
		System.out.println("=======================================\n");
	}

	// item ����
	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n========== [ item ���� ] ==========\n");
		System.out.print("������ item�� ������ �Է��ϼ��� : ");
		String title = sc.next();
		
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println("[ �˸� ] : item�� ���������� �����Ǿ����ϴ�.");
				System.out.println("=======================================\n");
				break;
			}
		}
	}


	// item update
	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "========== [ item ���� ] ==========\n");
		System.out.print("�����ϰ���� item�� ������ �Է��ϼ��� : ");
		String title = sc.next().trim();
		
		if (!l.isDuplicate(title)) {
			System.out.println("[ ��� ] " + title + "�̶�� ������ ���� item�� ���������ʽ��ϴ�.");
			System.out.println("=======================================\n");
			return;
		}
		

		System.out.print("item�� ���ο� ������ �Է��ϼ��� : ");
		String new_title = sc.next().trim(); // �ܾ������ �Է¹���.
		if (l.isDuplicate(new_title)) {
			System.out.println("[ ��� ] ������ �ߺ��� �� �����ϴ�!");
			System.out.println();
			return;
		}
		
		sc.nextLine(); // enterŰ ����
		
		System.out.print("item�� ���ο� ������ �Է��ϼ��� : ");
		String new_description = sc.nextLine().trim(); // line���� �Է¹���.
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				String desc = item.getDesc();
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description);
				l.addItem(t);
				
				System.out.println("[ �˸� ] item�� ���������� ������Ʈ �Ǿ����ϴ�.( [ ���� ] " + title + " -> " + new_title + " , [ ���� ] " + desc + " -> " + new_description + " )");
				System.out.println("");
			}
			
		}

	}

	// item�� ��� ���
	public static void listAll(TodoList l) {
		int num = 1;
		System.out.println("===================================== [ ��ü item ��� ] =====================================");
		for (TodoItem item : l.getList()) {
			System.out.println(num + ". " + item.toString());
			num++;
		}
		num = 0;
		System.out.println("============================================================================================");
		System.out.println();
	}
	
	public static void saveList(TodoList l, String filename) {
		try {
			
			Writer w = new FileWriter(filename);
			
			for(TodoItem item: l.getList()) {
				w.write(item.toSaveString());
	        }
			w.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadList(TodoList l, String filename) {
		try {			
			BufferedReader in = new BufferedReader(new FileReader(filename));
			
			String str;
			int count = 0;
			
			
			while((str=in.readLine()) != null) {
				
				StringTokenizer st = new StringTokenizer(str,"##");
				String title = st.nextToken();
				String des = st.nextToken();
				String time = st.nextToken();
				
				TodoItem t = new TodoItem(title, des);
				t.setCurrent_date(time);
				
				l.addItem(t);
				count ++;
			}
			
			in.close();
			System.out.println("<<<<<<<<  " + count + "���� item�� ���������� �ҷ��Խ��ϴ�." + "  >>>>>>>>");
			
		}catch(FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println();
			System.out.println("todolist.txt ������ �����ϴ�.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
