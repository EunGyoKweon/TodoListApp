package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("======== [ TodoList 명령어 사용법 ] ========");
        System.out.println("1. item 추가 - add ");
        System.out.println("2. item 삭제 - del ");
        System.out.println("3. item 수정  - edit ");
        System.out.println("4. 전체 item들 보기 - ls ");
        System.out.println("5. item 제목순 정렬 - ls_name_asc ");
        System.out.println("6. item 제목역순 정렬 - ls_name_desc ");
        System.out.println("7. item 생성시간순 정렬 - ls_date ");
        System.out.println("8. item 생성시간역순 정렬 - ls_date_desc");
        System.out.println("9. 제목과 내용에서 키워드 찾기 - find <키워드>");
        System.out.println("10. 카테고리에서 키워드 찾기 - find_cate <키워드>");
        System.out.println("11. 카테고리 종류 출력 - ls_cate");
        System.out.println("12. 종료 - exit ");
        System.out.println();
    }
    
    public static void prompt() {
    	System.out.print("무엇을 할까요? : ");
    }
}
