import java.util.*;
import java.io.*;

class Use{
    public static boolean login(){
        try{
            File codeFile = new File("code.txt");
            Scanner read = new Scanner(codeFile);
            while( read.hasNextLine()){
                String data = read.nextLine();
                String[] code = data.split(" ");
                if( code[0].equals("cis") && code[1].equals("1234")){
                    return true;
                }
                else{
                    return false;
                }
            }
            System.out.println("Login Error");
            return false;
        } catch( FileNotFoundException e ){
            System.out.println("Login Error");
            return false;
        }
    }

    public static void CreateFile(){
        try{
            File book = new File("contactbook.txt");
            if( book.createNewFile()){
                System.out.println("File create " + book.getName());
                FileWriter writer = new FileWriter("contactbook.txt");
                writer.write("========================================================================================\n");
                writer.write("No.  姓名         生日        手機            關係        Email\n");
                writer.write("----------------------------------------------------------------------------------------\n");
                // Initialize Set
                writer.write("1.   宋得榮       1122        0977-287838    其他        1122overcomer@gmail.com\n");
                writer.write("2.   unknow      0118        0977-287838    家人        1122overcomer@gmail.com\n");
                writer.write("3.   宋得榮       1221        0977-287838    同學        1122overcomer@gmail.com\n");
                writer.write("4.   宋得榮       0223        0977-287838    同學        1122overcomer@gmail.com\n");
                writer.write("5.   宋主欣       0409        0977-287838    家人        1122overcomer@gmail.com\n");
                writer.write("6.   賴怡真       1003        0977-287838    家人        1122overcomer@gmail.com\n");
                writer.close();
            }
            else{
                System.out.println("File has exists");
                
            }
        }
        catch( IOException e ){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public static void Load( ArrayList<Person> CB ){


        try{
            File book = new File("contactbook.txt");
            Scanner s = new Scanner(book);
            int line = -3;
            while( s.hasNextLine()){
                line++;
                String data = s.nextLine();
                if( line > 0 ){
                    String[] tokens = data.split("\\s+");
                    Person p = new Person();
                    int point = 0;
                    for( String token : tokens ){
                        //System.out.println(token);
                        switch(point){
                            case 0:
                                // skip
                                break;
                            case 1:
                                p.name = token;
                                System.out.println(token);
                                break;
                            case 2:
                                p.birth = token;
                                break;
                            case 3:
                                p.phone = token;
                                break;
                            case 4:
                                p.relation = token;
                                break;
                            case 5:
                                p.email = token;
                                break;
                        }
                        point++;
                    }
                    CB.add(p);
                }

            }
        }
        catch( FileNotFoundException e ){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    
    public static void Relaod( ArrayList<Person> CB ){
        try{
            FileWriter writer = new FileWriter("contactbook.txt", false );
            writer.write("========================================================================================\n");
                writer.write("No.  姓名         生日        手機            關係        Email\n");
                writer.write("----------------------------------------------------------------------------------------");

            for( Person p : CB ){
                writer.write("\n" + (CB.indexOf(p)+1)+".   " + p.name);
                writer.write("       " + p.birth);
                writer.write("        " + p.phone);
                writer.write("    " + p.relation);
                writer.write("        " + p.email);
            }

            writer.close();
        }
        catch( IOException e ){
            System.out.println("An error accurred");
            e.printStackTrace();
        }
    }
}