import java.util.*;
import java.io.*;

class ContactBook{
	public static void main(String[] args){
		// Login
		System.out.println("Login...");
		if( Use.login()){
			System.out.println("Login Success!");
		}
		else{
			System.out.println("Login ERROR!");
			System.exit(0);
		}

		Scanner s = new Scanner(System.in);
		ArrayList<Person> CB = new ArrayList<Person>();
		ArrayList<String> RelationStore = new ArrayList<String>(); 

		Relation.RelationInit(RelationStore);

		System.out.println("Loading...");
		Use.CreateFile();
		Use.Load(CB);
		Relation.Load(RelationStore);
		// Main Select
		while( true ){
			Relation.Load(RelationStore);
			System.out.println("===============");
			System.out.println("Main Interface");
			System.out.println("===============");
			System.out.println("1. 使用者功能");
			System.out.println("2. 管理者功能");
			System.out.println("others. Logout");
			int choose = s.nextInt();
			switch(choose){
				case 1:
					System.out.println("===============");
					System.out.println("User Interface");
					System.out.println("===============");
					NewUser.Interface(CB,RelationStore);
					break;
				case 2:
					System.out.println("====================");
					System.out.println("Controller Interface");
					System.out.println("====================");
					Controller.Interface(CB,RelationStore);
					break;
				default:
					System.exit(0);
			}
		}

		// load current data
		//ArrayList<Person> CB = new ArrayList<Person>();
		//Person.addPerson(CB);
		//Person.showPerson(CB);
	}
}