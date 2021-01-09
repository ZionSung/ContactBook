import java.util.*;

class Controller{
    public static void Interface( ArrayList<Person> CB, ArrayList<String> RelationStore ){
        System.out.println("Login...");
        Authenticate();
        while(true){
            System.out.println("====================");
            System.out.println("Collection Interface");
            System.out.println("====================");
            System.out.println("1. Add Relation");
            System.out.println("2. Order and Reset ContactBook");
            System.out.println("3. Back");
            System.out.println("4. Exit");
            Scanner s = new Scanner(System.in);
            int choose = s.nextInt();
            if( choose == 1 ){
                Relation.addRelation(RelationStore);
                Relation.Update(RelationStore);
            }
            else if( choose == 2 ){
                orderCB(CB);
                Use.Relaod(CB);
            }
            else if( choose == 3 ){
                return;
            }
            else{
                System.out.println("Logout!");
                System.exit(0);
            }
        }
    }

    public static void orderCB( ArrayList<Person> CB ){

        while( true ){
            System.out.println("Which type you want to sort?");
            System.out.println("1.Name 2.Birth 3.Phone 4.Relation 5.Email");
            Scanner s = new Scanner(System.in);
            String choose = s.next();
            switch(choose){
                case "1":
                    if(Call.AscendingOrDescending() == 1){
                        Collections.sort( CB, Person.NameComparatorA );
                    }
                    else{
                        Collections.sort( CB, Person.NameComparatorD );
                    }
                    return;
                case "2":
                    if(Call.AscendingOrDescending() == 1){
                        Collections.sort( CB, Person.birthComparatorA );
                    }
                    else{
                        Collections.sort( CB, Person.birthComparatorD );
                    }
                    return;
                case "3":
                    if(Call.AscendingOrDescending() == 1){
                        Collections.sort( CB, Person.phoneComparatorA );
                    }
                    else{
                        Collections.sort( CB, Person.phoneComparatorD );
                    }
                    return;
                case "4":
                    if(Call.AscendingOrDescending() == 1){
                        Collections.sort( CB, Person.relationComparatorA );
                    }
                    else{
                        Collections.sort( CB, Person.relationComparatorD );
                    }
                    return;
                case "5":
                    if(Call.AscendingOrDescending() == 1){
                        Collections.sort( CB, Person.relationComparatorA );
                    }
                    else{
                        Collections.sort( CB, Person.relationComparatorD );
                    }
                    return;
                default:
                    break;
            }
            
        }
    }

    public static boolean Authenticate(){
        System.out.println("Question One:");
        // Random three num from 1~100
        int[] r = new int[3];
        r[0] = (int)(Math.random()*100)+1;
        r[1] = (int)(Math.random()*100)+1;
        r[2] = (int)(Math.random()*100)+1;

        System.out.println("Random Number => " + r[0] + " " + r[1] + " " + r[2] );

        Arrays.sort(r);

        System.out.println("Please order these three numbers with ascending");

        Scanner s = new Scanner(System.in);

        String str = s.nextLine();
        String[] tokens = str.split("\\s+");
        int counter = 0;
        for( String token : tokens ){
            if( Integer.valueOf(token) != r[counter]){
                System.out.println("Fail...");
                return false;
            }
            counter++;
        }
        System.out.println("Correct!");

        System.out.println("Question Two");
        int r1 = (int)(Math.random()*10)+1;
        int r2 = (int)(Math.random()*10)+1;
        int r3 = (int)(Math.random()*10)+1;

        r1 = r1 % 3;

        switch(r1){
            case 0: 
                System.out.println("=> " + r2 + " + " + r3 );
                int ans = s.nextInt();
                if( ans != (r2 + r3)){
                    System.out.println("Fail...");
                    return false;
                }
                break;
            case 1: 
                System.out.println("=> " + r2 + " - " + r3 );
                ans = s.nextInt();
                if( ans != (r2 - r3)){
                    System.out.println("Fail...");
                    return false;
                }
                break;
            case 2: 
                System.out.println("=> " + r2 + " * " + r3 );
                ans = s.nextInt();
                if( ans != (r2 * r3)){
                    System.out.println("Fail...");
                    return false;
                }
                break;
        }
        System.out.println("Correct!");
        return true;
    }
}