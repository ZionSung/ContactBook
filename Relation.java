import java.util.*;
import java.io.*;

class Relation {
    
    public static void RelationInit(ArrayList<String> RelationStore){
        try{
            File RelBook = new File("Relation.txt");
            if( RelBook.createNewFile()){
                FileWriter writer = new FileWriter("Relation.txt");
                writer.write("家人\n");
                writer.write("同學\n");
                writer.write("其他\n");
                writer.close();
            }

            Update(RelationStore);

        }
        catch( IOException e ){
            System.out.println("Error!");
        }
    }

    public static void Update(ArrayList<String> RelationStore){
        try{
            File RelBook = new File("Relation.txt");
            Scanner s = new Scanner(RelBook);
            while( s.hasNextLine() ){
                String relation = s.nextLine();
                RelationStore.add(relation);
            }
        }
        catch( IOException e ){
            System.out.println("Error");
        }
    }
}
