import java.util.*;
import java.io.*;

public class Person{
    String name;
    String birth;
    String phone;
    String relation;
    String email;

    public static void showAllPerson( ArrayList<Person> CB ){
        System.out.println("================================================================================");
        System.out.println("                                SHOW ALL PERSON");
        System.out.println("================================================================================");
        for( int i = 0; i < CB.size(); i++ ){
            Person p = CB.get(i);
            System.out.printf("Name: %-4s", p.name );
            System.out.printf("Birthe: %-5s", p.birth );
            System.out.printf("Phone: %-12s", p.phone );
            System.out.printf("Relation: %-3s", p.relation );
            System.out.printf("Email: %-20s\n", p.email );
            //System.out.println("Name: "+p.name+" Birth: "+ p.birth + " Phone: " + p.phone+" Relation: " + p.relation + " Email: "+ p.email);
        }
    }

    /* 
        Comparator Section
    */
    public static Comparator<Person> NameComparatorA = new Comparator<Person>(){
        public int compare( Person p1, Person p2 ){
            String PersonName1 = p1.name;
            String PersonName2 = p2.name;

            // ascending order
            return PersonName1.compareTo(PersonName2); 

        }
    };

    public static Comparator<Person> NameComparatorD = new Comparator<Person>(){
        public int compare( Person p1, Person p2 ){
            String PersonName1 = p1.name;
            String PersonName2 = p2.name;

            // descending order
            return PersonName2.compareTo(PersonName1); 

        }
    };

    public static Comparator<Person> birthComparatorA = new Comparator<Person>(){
        public int compare( Person p1, Person p2 ){
            String PersonBirth1 = p1.birth;
            String PersonBirth2 = p2.birth;

            return PersonBirth1.compareTo(PersonBirth2);
        }
    };

    public static Comparator<Person> birthComparatorD = new Comparator<Person>(){
        public int compare( Person p1, Person p2 ){
            String PersonBirth1 = p1.birth;
            String PersonBirth2 = p2.birth;
            return PersonBirth2.compareTo(PersonBirth1);
        }
    };

    public static Comparator<Person> phoneComparatorA = new Comparator<Person>(){
        public int compare( Person p1, Person p2 ){
            String PersonPhone1 = p1.phone;
            String PersonPhone2 = p2.phone;
            return PersonPhone1.compareTo(PersonPhone2);
        }
    };

    public static Comparator<Person> phoneComparatorD = new Comparator<Person>(){
        public int compare( Person p1, Person p2 ){
            String PersonPhone1 = p1.phone;
            String PersonPhone2 = p2.phone;
            return PersonPhone2.compareTo(PersonPhone1);
        } 
    };

    public static Comparator<Person> relationComparatorA = new Comparator<Person>(){
        public int compare( Person p1, Person p2 ){
            String relation1 = p1.relation;
            String relation2 = p2.relation;
            return relation1.compareTo(relation2);
        }
    };

    public static Comparator<Person> relationComparatorD = new Comparator<Person>(){
        public int compare( Person p1, Person p2 ){
            String relation1 = p1.relation;
            String relation2 = p2.relation;
            return relation2.compareTo(relation1);
        }
    };

    public static Comparator<Person> emailComparatorA = new Comparator<Person>(){
        public int compare( Person p1, Person p2 ){
            String email1 = p1.email;
            String email2 = p2.email;
            return email2.compareTo(email1);
        }
    };

    public static Comparator<Person> emailComparatorD = new Comparator<Person>(){
        public int compare( Person p1, Person p2 ){
            String email1 = p1.email;
            String email2 = p2.email;
            return email2.compareTo(email1);
        }
    };

    /*
        Searching Section
    */
    public static void SeachingName(ArrayList<Person> CB, int SearchOrSet ){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter name: ");
        String searchingName = s.nextLine();
        searchingName = checkName(searchingName);
        System.out.println("==========================================================================================");
        System.out.println("                                 Searching According to Name");
        System.out.println("==========================================================================================");
        for( Person p : CB ){
            if(p.name != null && p.name.contains(searchingName)){
                System.out.printf("Name: %-4s", p.name );
                System.out.printf("Birthe: %-5s", p.birth );
                System.out.printf("Phone: %-12s", p.phone );
                System.out.printf("Relation: %-3s", p.relation );
                System.out.printf("Email: %-20s\n", p.email );
            }
        }
        System.out.println("==========================================================================================");

    }

    public static void SearchingBirth( ArrayList<Person> CB, int SearchOrSet ){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter birth: ");
        String searchingBirth = s.next();
        int[] index = new int[CB.size()];
        int i = 0;
        int counter = 1;
        System.out.println("==========================================================================================");
        System.out.println("                                 Searching According to Name");
        System.out.println("==========================================================================================");
        for( Person p : CB ){
            if( p.birth != null && p.birth.contains(searchingBirth)){
                System.out.printf("%d. ", counter);
                System.out.printf("Name: %-4s", p.name );
                System.out.printf("Birthe: %-5s", p.birth );
                System.out.printf("Phone: %-12s", p.phone );
                System.out.printf("Relation: %-3s", p.relation );
                System.out.printf("Email: %-20s\n", p.email );
                counter++;
                if( SearchOrSet == 2 ){
                    index[i] = CB.indexOf(p);
                    i++;
                }
            }
        }

        if( SearchOrSet == 2 ){
            System.out.println("==========================================================================================");
            System.out.println("Which one you want to change");
            int setNum = s.nextInt();
            int point = index[setNum-1];
            Person setPerson = CB.get(point);
            System.out.printf("Name: %-4s", setPerson.name );
            System.out.printf("Birthe: %-5s", setPerson.birth );
            System.out.printf("Phone: %-12s", setPerson.phone );
            System.out.printf("Relation: %-3s", setPerson.relation );
            System.out.printf("Email: %-20s\n", setPerson.email );
            System.out.println("想要修改的項目");
            System.out.println("1.姓名 2.生日 3.手機 4.關係 5.Email");
            String setChoose = s.nextLine(); // skip nextInt /r
            setChoose = s.nextLine();
            String[] tokens = setChoose.split("\\s+");
            for( String token : tokens ){
                switch(token){
                    case "1":
                        System.out.print("Change Name to -> ");
                        String setNewName = s.nextLine();
                        setNewName = checkName(setNewName);
                        CB.get(point).name = setNewName;
                        break;
                    case "2":
                        System.out.print("Change birth to -> ");
                        String setNewbirth = s.next();
                        CB.get(point).birth = setNewbirth;
                        break;
                    case "3":
                        System.out.print("Change phone to -> ");
                        String setNewPhone = s.next();
                        CB.get(point).phone = setNewPhone;
                        break;
                    case "4":
                        System.out.print("Change relation to -> ");
                        String setNewRelation = s.next();
                        CB.get(point).relation = setNewRelation;
                        break;
                    case "5":
                        System.out.print("Change email to -> ");
                        String setNewEmail = s.next();
                        CB.get(point).email = setNewEmail;
                        break;
                }
            }
        }

    }

    

    public static void showSpecific( ArrayList<Person> CB, String[] tokens ){

        System.out.println("================================================================================");
        System.out.println("                                Show Specific Colume");
        System.out.println("================================================================================");

        for( int i = 0; i < CB.size(); i++ ){
            Person p = CB.get(i);
            for( String token : tokens ){
                switch(token){
                    case "1":
                        System.out.printf("Name: %-4s  ", p.name );
                        break;
                    case "2":
                        System.out.printf("Birth: %-4s  ", p.birth );
                        break;
                    case "3":
                        System.out.printf("Phone: %-4s  ", p.phone );
                        break;
                    case "4":
                        System.out.printf("Relation: %-4s  ", p.relation );
                        break;
                    case "5":
                        System.out.printf("Email: %-4s  ", p.email );
                        break;
                }
            }
            System.out.println();
        }
        System.out.println("================================================================================\n");
    }


    public static void addPerson( ArrayList<Person> CB ){
        try{
            FileWriter writer = new FileWriter("contactbook.txt", true );
            Scanner s = new Scanner(System.in);
            Person p = new Person();
            // Name
            while( true ){
                System.out.print("Name:");
                String name = s.nextLine();
                p.name = checkName(name);
                int size = CB.size()+1;
                writer.write("\n"+ size +".   " + p.name);
                break;
            }

            // Birth
            while( true ){
                System.out.print("Birth(MMDD):");
                String birth = s.next();
                if(checkBirth(birth)){
                    p.birth = birth;
                    writer.write("       " + p.birth);
                    //System.out.println(p.birth);
                    break;
                }
            }

            // phone
            while(true){
                System.out.print("Phone(0912-345678):");
                String phone = s.next();
                if( checkPhone(phone)){
                    p.phone = phone;
                    writer.write("        " + p.phone);
                    break;
                }
            }

            // relation
            while( true ){
                System.out.println("Relation:");
                System.out.println("1.家人 2.同學 3~.其他");
                int r = s.nextInt();
                switch(r){
                    case 1:
                        p.relation = "家人";
                        break;
                    case 2:
                        p.relation = "同學";
                        break;
                    default:
                        p.relation = "其他";
                        break;
                }
                //System.out.println(p.relation);
                writer.write("    " + p.relation);
                break;
            }

            // email
            while(true){
                System.out.print("Email:");
                String email = s.next();
                if( checkEmail(email)){
                    p.email = email;
                    writer.write("        " + p.email);
                    break;
                }
            }
            writer.close();
            CB.add(p);

        }
        catch( IOException e ){
            System.out.println("An error accurred");
            e.printStackTrace();
        }
    }

    public static String checkName(String name){
        String[] nameStr = name.split(" ");
        String Name = "";
        for( String token : nameStr ){
            Name += token;
        }
        //System.out.println("Name = " + Name);
        return Name;
    }

    public static boolean checkBirth(String birth){
        // first check: whether there're 4 char in the string
        if( birth.length() != 4 ){
            System.out.println("Your Birth is out of bound, please enter 4 number MMDD");
            return false;
        }
        else{
            // second check MM
            int month = Integer.valueOf(birth.substring(0,2)); // remember substring 的 s 不用大寫 
            //System.out.println("Month = " + month );
            if( month >= 1 && month <= 12 ){
                // third check DD
                int day = Integer.valueOf(birth.substring(2,4));
                if( day >= 1 && day <= 31){
                    //System.out.println("Day = " + day );
                    return true;
                }
                else{
                    System.out.println("Your day is not in the range(1~31), please try again.");
                    return false;
                }
            }
            else{
                System.out.println("Your month is over 12, please try again.");
                return false;
            }
        }
    }

    public static boolean checkPhone(String phone){
        // check length
        if( phone.length() != 11 ){
            System.out.println("Please enter again, ensure that your enter contain just 10 character");
            return false;
        }
        else{ // check format
            for( int i = 0; i < 11; i++ ){
                if( i != 4 ){
                    if( !Character.isDigit(phone.charAt(i))){
                        System.out.println("Your Phone Number is wrong( there is/are not digit)");
                        return false;
                    }
                }
                else{
                    if(phone.charAt(i) != '-'){
                        System.out.println("Format is wrong ( ex.0977-111233 )");
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static boolean checkEmail(String email){
        int mouse = 0;
        int dot = 0;
        for( int i = 0; i < email.length(); i++ ){
            if( email.charAt(i) == '@'){
                mouse++;
            }
            else if( email.charAt(i) == '.'){
                dot++;
            }
        }
        if( dot > 0 && mouse == 1 ){
            return true;
        }
        else{
            System.out.println("There should be '@' and at least one '.' in it");
            return false;
        }
    }
}