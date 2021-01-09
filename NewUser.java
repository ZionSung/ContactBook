import java.util.*;

class NewUser{
    public static void Interface(ArrayList<Person> CB, ArrayList<String> RelationStore ){
        Scanner s = new Scanner(System.in);
        //ArrayList<Person> CB = new ArrayList<Person>();
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
                    Person.addPerson(CB, RelationStore);
                    break;
                case 1:
                    System.out.println("Show Person");
                    Call.ShowPerson(CB, RelationStore);
                    break;
                case 2:
                    System.out.println("Show Person");
                    Call.ShowPerson(CB, RelationStore);
                    break;
                case 3:
                    // search 
                    System.out.println("Searching ->");
                    System.out.println("1.依姓名");
                    System.out.println("2.依生日");
                    int searching = s.nextInt();
                    if(searching == 1){
                        Person.SeachingName(CB, 1);
                    }
                    else{
                        Search.Birth(CB, RelationStore, 1);
                    }
                    break;
                case 4:
                    // search 
                    System.out.println("Searching first and Set ->");
                    System.out.println("1.依姓名");
                    System.out.println("2.依生日");
                    int set = s.nextInt();
                    if(set == 1){
                        Person.SeachingName(CB, 2);
                    }
                    else{
                        Search.Birth(CB, RelationStore, 2);
                    }
                    break;
                case 5:
                    System.out.println("Searching first and Set ->");
                    System.out.println("1.依姓名");
                    System.out.println("2.依生日");
                    int delet = s.nextInt();
                    if(delet == 1){
                        Person.SeachingName(CB, 3);
                    }
                    else{
                        Search.Birth(CB, RelationStore, 3);
                    }
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
            Use.Relaod(CB);
        }
    }
}
