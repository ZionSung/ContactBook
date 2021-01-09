import java.util.*;

import javax.swing.plaf.SliderUI;

class Call {
    public static void ShowPerson( ArrayList<Person> CB, ArrayList<String> RelationStore ){

        while(true){
            System.out.println("1. Show all person");
            System.out.println("2. Show specific column");
            System.out.println("3. Show only one relation");
            Scanner s = new Scanner(System.in);
            int choose = s.nextInt();
            if( choose == 1 ){
                ShowAllPerson(CB);
                break;
            }else if( choose == 2 ){
                showSpecificPerson(CB);
                break;
            }
            else if( choose == 3 ){
                showOnlyRel(CB,RelationStore);
                break;
            }
            else{
                continue;
            }
        }
    }

    public static void showOnlyRel( ArrayList<Person> CB , ArrayList<String> RelationStore ){
        System.out.println("Which Relation you want to show?");
        for( String rel : RelationStore ){
            System.out.println((RelationStore.indexOf(rel)+1) + ". " + rel );   
        }

        Scanner s = new Scanner(System.in);
        String selet = s.nextLine();
        String[] tokens = selet.split("\\s+"); 
        ArrayList<String> selectedRelation = new ArrayList<String>();
        for( String token : tokens ){
            int point = Integer.valueOf(token)-1;
            selectedRelation.add(RelationStore.get(point));
        }

        ArrayList<Person> temp = new ArrayList<Person>();
        for( Person p : CB ){
            if( selectedRelation.contains(p.relation)){
                temp.add(p);
            }
        }



        System.out.println("Which tpyes you want to show?");
        System.out.println("1.Name 2.Birth 3.Phone 4.Relation 5.Email");


        String selets = s.nextLine();
        String[] newtokens = selets.split("\\s+");

        System.out.println("Do you want sort the ContactBook?(y/n)");
        String choose = s.next();
        if( choose.equals("y")){
            temp = Sort(temp);
        }

        for( Person p : temp ){
            System.out.print( (CB.indexOf(p)+1) + ". ");
            for( String token : newtokens ){
                switch(token){
                    case "1":
                        System.out.printf("Name: %-4s", p.name );
                        break;
                    case "2":
                        System.out.printf("Birthe: %-5s", p.birth );
                        break;
                    case "3":
                        System.out.printf("Phone: %-12s", p.phone );
                        break;
                    case "4":
                        System.out.printf("Relation: %-3s", p.relation );
                        break;
                    case "5":
                        System.out.printf("Email: %-20s\n", p.email );
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }

        

    }

    public static void showSpecificPerson( ArrayList<Person> CB ){
        System.out.println("Which tpyes you want to show?");
        System.out.println("1.Name 2.Birth 3.Phone 4.Relation 5.Email");
        Scanner s = new Scanner(System.in);
        String selets = s.nextLine();
        String[] tokens = selets.split("\\s+");
        for( Person p : CB ){
            System.out.print( (CB.indexOf(p)+1) + ". ");
            for( String token : tokens ){
                switch(token){
                    case "1":
                        System.out.printf("Name: %-4s", p.name );
                        break;
                    case "2":
                        System.out.printf("Birthe: %-5s", p.birth );
                        break;
                    case "3":
                        System.out.printf("Phone: %-12s", p.phone );
                        break;
                    case "4":
                        System.out.printf("Relation: %-3s", p.relation );
                        break;
                    case "5":
                        System.out.printf("Email: %-20s\n", p.email );
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }
    }
    
    public static void ShowAllPerson( ArrayList<Person> CB ){
        ArrayList<Person> temp = new ArrayList<>(CB);
        System.out.println("Do you want sort the ContactBook?(y/n)");
        Scanner s = new Scanner(System.in);
        String choose = s.next();
        if( choose.equals("y")){
            temp = Sort(temp);
        }
        Show(temp);
    }

    public static void Show( ArrayList<Person> contactbook ){
        for( Person p : contactbook ){
            System.out.print( (contactbook.indexOf(p)+1) + ". ");
            System.out.printf("Name: %-4s", p.name );
            System.out.printf("Birthe: %-5s", p.birth );
            System.out.printf("Phone: %-12s", p.phone );
            System.out.printf("Relation: %-3s", p.relation );
            System.out.printf("Email: %-20s\n", p.email );
        }
    }

    public static ArrayList<Person> Sort( ArrayList<Person> CB ){
        ArrayList<Person> hasSort = new ArrayList<>(CB);
        while( true ){
            System.out.println("Which type you want to sort?");
            System.out.println("1.Name 2.Birth 3.Phone 4.Relation 5.Email");
            Scanner s = new Scanner(System.in);
            String choose = s.next();
            switch(choose){
                case "1":
                    if(AscendingOrDescending() == 1){
                        Collections.sort( hasSort, Person.NameComparatorA );
                    }
                    else{
                        Collections.sort( hasSort, Person.NameComparatorD );
                    }
                    return hasSort;
                case "2":
                    if(AscendingOrDescending() == 1){
                        Collections.sort( hasSort, Person.birthComparatorA );
                    }
                    else{
                        Collections.sort( hasSort, Person.birthComparatorD );
                    }
                    return hasSort;
                case "3":
                    if(AscendingOrDescending() == 1){
                        Collections.sort( hasSort, Person.phoneComparatorA );
                    }
                    else{
                        Collections.sort( hasSort, Person.phoneComparatorD );
                    }
                    return hasSort;
                case "4":
                    if(AscendingOrDescending() == 1){
                        Collections.sort( hasSort, Person.relationComparatorA );
                    }
                    else{
                        Collections.sort( hasSort, Person.relationComparatorD );
                    }
                    return hasSort;
                case "5":
                    if(AscendingOrDescending() == 1){
                        Collections.sort( hasSort, Person.relationComparatorA );
                    }
                    else{
                        Collections.sort( hasSort, Person.relationComparatorD );
                    }
                    return hasSort;
                default:
                    break;
            }
            
        }
    }

    public static int AscendingOrDescending(){
        while(true){
        System.out.println("Ascending or Descending (a/d)");
        Scanner s = new Scanner(System.in);
        String choose = s.next();
        if( choose.equals("a")){
            //s.close();
            return 1;
        }
        else if( choose.equals("d")){
            //s.close();
            return 2;
        }

        }
    }
}
