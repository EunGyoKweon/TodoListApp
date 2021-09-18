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
	
	// item 새로 추가
	public static void createItem(TodoList list) {
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "========== [ item 추가 ] ==========\n");
		System.out.print("[ 제목 ] : ");
		title = sc.next();  // 제목은 단어로 입력받음.
		
		// 제목 중복체크
		if (list.isDuplicate(title)) {
			System.out.println("");
			System.out.printf("[ 경고 ] item의 제목은 중복될 수 없습니다.");
			System.out.println("");
			return;
		}
		
		sc.nextLine(); // 제목을 입력하고 enter치는거 제거
		
		System.out.print("[ 내용 ] : ");
		desc = sc.nextLine().trim(); // 내용은 line으로 입력받음 & trim => 좌우공백 제거
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
		System.out.println("[ 알림 ] : item이 정상적으로 추가되었습니다.");
		System.out.println("=======================================\n");
	}

	// item 삭제
	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n========== [ item 삭제 ] ==========\n");
		System.out.print("삭제할 item의 제목을 입력하세요 : ");
		String title = sc.next();
		
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println("[ 알림 ] : item이 정상적으로 삭제되었습니다.");
				System.out.println("=======================================\n");
				break;
			}
		}
	}


	// item update
	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "========== [ item 수정 ] ==========\n");
		System.out.print("수정하고싶은 item의 제목을 입력하세요 : ");
		String title = sc.next().trim();
		
		if (!l.isDuplicate(title)) {
			System.out.println("[ 경고 ] " + title + "이라는 제목을 가진 item이 존재하지않습니다.");
			System.out.println("=======================================\n");
			return;
		}
		

		System.out.print("item의 새로운 제목을 입력하세요 : ");
		String new_title = sc.next().trim(); // 단어단위로 입력받음.
		if (l.isDuplicate(new_title)) {
			System.out.println("[ 경고 ] 제목은 중복될 수 없습니다!");
			System.out.println();
			return;
		}
		
		sc.nextLine(); // enter키 제거
		
		System.out.print("item의 새로운 내용을 입력하세요 : ");
		String new_description = sc.nextLine().trim(); // line으로 입력받음.
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				String desc = item.getDesc();
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description);
				l.addItem(t);
				
				System.out.println("[ 알림 ] item이 정상적으로 업데이트 되었습니다.( [ 제목 ] " + title + " -> " + new_title + " , [ 내용 ] " + desc + " -> " + new_description + " )");
				System.out.println("");
			}
			
		}

	}

	// item들 모두 출력
	public static void listAll(TodoList l) {
		int num = 1;
		System.out.println("===================================== [ 전체 item 목록 ] =====================================");
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
			System.out.println("<<<<<<<<  " + count + "개의 item을 정상적으로 불러왔습니다." + "  >>>>>>>>");
			
		}catch(FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println();
			System.out.println("todolist.txt 파일이 없습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
