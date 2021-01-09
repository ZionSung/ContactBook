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

            Load(RelationStore);

        }
        catch( IOException e ){
            System.out.println("Error!");
        }
    }

    public static void Load(ArrayList<String> RelationStore){
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

    public static void addRelation( ArrayList<String> RelationStore ){
        System.out.println("Which relation you want to add ");
        System.out.println("=>");
        Scanner s = new Scanner(System.in);
        String relation = s.next();
        RelationStore.add(relation);
        System.out.println("Add another relation?(y/n)");
        String choose = s.next();
        if( choose.equals("y")){
            addRelation(RelationStore);
        }
        else{
            return;
        }
    }

    public static void Update( ArrayList<String> RelationStore ){
        try{
            FileWriter writer = new FileWriter("Relation.txt", false );
            System.out.println(RelationStore.size());
            for( int counter = 0; counter < RelationStore.size(); counter++ ){
                writer.write(RelationStore.get(counter));
                writer.write("\n");
            }
            writer.close();
        }catch(IOException e){
            System.out.println("An error occurred");
        }
    } 
}
