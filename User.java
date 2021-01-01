import java.util.*;

class User{
    public static void Interface(){
        Scanner s = new Scanner(System.in);
        ArrayList<Person> CB = new ArrayList<Person>();
        while( true ){
            System.out.println("0. 新增資料");
            System.out.println("1. 顯示所有資料");
            System.out.println("2. 顯示分類資料");
            System.out.println("3. 查詢資料");
            System.out.println("4. 修改資料");
            System.out.println("5. 刪除資料");
            System.out.println("6. 回上一頁");
            System.out.println("7. 登出");
            int choose = s.nextInt();
            switch(choose){
                case 0:
                    Person.addPerson(CB);
                case 1:
                    Person.showAllPerson(CB);
                    break;
                case 6:
                    return;
                case 7:
                    System.out.println("Log out!");
                    System.exit(0);
                default:
                    System.out.println("Log out!");
                    System.exit(0);
            }
        }
    }
}