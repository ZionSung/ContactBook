import java.util.*;

class Search {
    public static void Birth ( ArrayList<Person> CB, ArrayList<String> RelationStore, int func ){

        // Search
        System.out.println("Please enter birth: ");
        Scanner s = new Scanner(System.in);
        String b = s.next();
        int[] index = new int[CB.size()];
        int indexCounter = 0;
        int counter = 0;
        for( Person p : CB ){
            if( p.birth.contains(b)){
                counter++;
                System.out.printf("%d. ", counter);
                System.out.printf("Name: %-4s", p.name );
                System.out.printf("Birthe: %-5s", p.birth );
                System.out.printf("Phone: %-12s", p.phone );
                System.out.printf("Relation: %-3s", p.relation );
                System.out.printf("Email: %-20s\n", p.email );
                index[indexCounter] = CB.indexOf(p);
                indexCounter++;
            }
        }

        // Change
        if( func == 2 ){
            int choose;
            while( true ){
                System.out.println("Which Person you want to change?");
                choose = s.nextInt();
                if( choose > 0 && choose <= indexCounter ){
                    break;
                }
            }

            Person p = CB.get(index[choose-1]);
            System.out.printf("Name: %-4s", p.name );
            System.out.printf("Birthe: %-5s", p.birth );
            System.out.printf("Phone: %-12s", p.phone );
            System.out.printf("Relation: %-3s", p.relation );
            System.out.printf("Email: %-20s\n", p.email );

            System.out.println("Which you want to change?");
            System.out.println("1.Name 2.Birth 3.Phone 4.Relation 5.Email ");
            String str = s.nextLine(); // skip nextInt()
            str = s.nextLine();
            String[] tokens = str.split("\\s+");
            for( String token : tokens ){
                switch(token){
                    case "1":
                        System.out.println("Change name to -> ");
                        String name = s.next();
                        p.name = name;
                        break;
                    case "2":
                        System.out.println("Change birth to -> ");
                        String birth = s.next();
                        p.birth = birth;
                        break;
                    case "3":
                        System.out.println("Change phone to -> ");
                        String phone = s.next();
                        p.phone = phone;
                        break;
                    case "4":
                        System.out.println("Change relation to -> ");
                        for( String r : RelationStore ){
                            System.out.println( (RelationStore.indexOf(r)+1) + ". " + r );
                        }
                        int relation = s.nextInt();
                        p.relation = RelationStore.get(relation-1);
                        break;
                    case "5":
                        System.out.println("Change email to -> ");
                        String email = s.next();
                        p.email = email;
                        break;
                    default:
                        break;
                }
            }

        }
        else if( func == 3 ){
            int choose;
            while( true ){
                System.out.println("Which Person you want to delete or all( enter number of index or 0 delet all)?");
                choose = s.nextInt();
                if( choose >= 0 && choose <= indexCounter ){
                    break;
                }
            }
            if( choose != 0 ){
                CB.remove(index[choose-1]);
            }
            else{
                for( int i = 0; i < indexCounter; i++ ){
                    CB.remove(index[i]);
                }
            }
        }


    }    
}
