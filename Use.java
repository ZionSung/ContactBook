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

    /*
    public static void Load(){
        try{
            File 
        }
    }
    */
}