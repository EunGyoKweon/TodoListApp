package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("======== [ TodoList ��ɾ� ���� ] ========");
        System.out.println("1. item �߰� - add ");
        System.out.println("2. item ���� - del ");
        System.out.println("3. item ����  - edit ");
        System.out.println("4. ��ä item�� ���� - ls ");
        System.out.println("5. item ���� - ls_name_asc ");
        System.out.println("6. item ����� ���� - ls_name_desc ");
        System.out.println("7. item ���񿪼� ���� - ls_date ");
        System.out.println("8. ���� - exit ");
        System.out.println();
    }
    
    public static void prompt() {
    	System.out.print("������ �ұ��? : ");
    }
}
