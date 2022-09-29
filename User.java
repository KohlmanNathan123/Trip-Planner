import java.util.*;
import java.io.*;
public class User implements Serializable{
	protected ArrayList<Trip> trips = new ArrayList<Trip>();
	protected String username;
	protected String password;
		
	public static void main(String[] args){
		User u = new User();
	}
	
	public User(){
		userMenu();
	}

	public User(String username, String password){
		this.username = username;
		this.password = password;	
	}
	
	public void userMenu(){
		boolean keepGoing = true;
		while(keepGoing){
			Scanner obj = new Scanner(System.in);
			System.out.println("1) Add a new trip ");
			System.out.println("2) Remove a trip ");
			System.out.println("3) Display trip list ");
			System.out.println("4) View a trip report ");
			System.out.println("0) Exit Menu ");
			System.out.print("Choice: ");
			String choice = obj.nextLine();
			if(choice.equals("1")){
				Trip newTrip = new Trip();
				trips.add(newTrip);
			}
			else if(choice.equals("2")){
				removeTrip();
			}
			else if(choice.equals("3")){
				displayArray();
			}
			else if(choice.equals("4")){
				tripReport();
			}
			else if(choice.equals("0")){
				keepGoing = false;
				System.out.print("\n");
			}
			else{
				System.out.println("Input not recognized...\n");
			}
		}
	}
	
	public void displayArray(){
		if(trips.size() == 0){
			System.out.println("No trips to display \n");
		}
		else{
			for(int i = 0; i < trips.size(); i++){
				System.out.println(i + ") " + (trips.get(i)).getName());
			}
			System.out.print("\n");
		}
	}
	
	public void removeTrip(){
		Scanner obj = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing){
			displayArray();
			System.out.print("Which trip would you like to remove: ");
			int input = obj.nextInt();
			try{
				trips.remove(input);
				keepGoing = false;
			}catch(Exception e){
				System.out.println("Input not recognized...\n");
			}
		}
	}

	public void tripReport(){
		displayArray();
		Scanner obj = new Scanner(System.in);
		System.out.print("What trip would you like a report for: ");
		int tripNum = obj.nextInt();
		Trip currTrip = trips.get(tripNum);
		currTrip.report();
	}

	public String getUsername(){
		return(username);
	}

	public void setUsername(String newU){
		username = newU;
	}
	
	public String getPassword(){
		return(password);
	}
	
	public void setPassword(String newP){
		password = newP;
	}
}
