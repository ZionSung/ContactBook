import java.util.*;

class User{
    public static void Interface(ArrayList<Person> CB){
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
                    Person.addPerson(CB);
                    break;
                case 1:
                    Person.showAllPerson(CB);
                    break;
                case 2:
                    System.out.println("1.姓名 2.生日 3.電話 4.關係 5.Email");
                    String digit = s.nextLine(); // delet nextInt() /r
                    digit = s.nextLine();

                    String[] tokens = digit.split("\\s+"); 
                    // choose ascending or descending 
                    System.out.println("1. 由小到大");
                    System.out.println("2. 由大到小");
                    int ad = s.nextInt();
                    String selet = tokens[0];
                    if( ad == 1 ){
                        switch(selet){
                            case "1":
                                Collections.sort(CB, Person.NameComparatorA);
                                break;
                            case "2":
                                Collections.sort(CB, Person.birthComparatorA);
                                break;
                            case "3":
                                Collections.sort(CB, Person.phoneComparatorA);
                                break;
                            case "4":
                                Collections.sort(CB, Person.relationComparatorA);
                                break;
                            case "5":
                                Collections.sort( CB, Person.emailComparatorA);
                                break;
                        }
                    }
                    else{
                        switch(selet){
                            case "1":
                                Collections.sort(CB, Person.NameComparatorD);
                                break;
                            case "2":
                                Collections.sort(CB, Person.birthComparatorD);
                                break;
                            case "3":
                                Collections.sort(CB, Person.phoneComparatorD);
                                break;
                            case "4":
                                Collections.sort(CB, Person.relationComparatorD);
                                break;
                            case "5":
                                Collections.sort(CB, Person.emailComparatorD);
                                break;
                        }
                    }
                    Person.showSpecific(CB, tokens );
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
                        Person.SearchingBirth(CB, 1);
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
                        Person.SearchingBirth(CB, 2);
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
                        Person.SearchingBirth(CB, 3);
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